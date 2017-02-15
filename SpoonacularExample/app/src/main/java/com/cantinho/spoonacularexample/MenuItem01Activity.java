package com.cantinho.spoonacularexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cantinho.spoonacularexample.retrofit_models.GroceryProducts;
import com.cantinho.spoonacularexample.retrofit_models.GroceryProductsMapper;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuItem01Activity extends AppCompatActivity {

    // Trailing slash is needed
    public static final String BASE_URL = "https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/";

    private SpoonacularService spoonacularService;
    private static final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    private static final OkHttpClient.Builder client = new OkHttpClient.Builder();

    static {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(logging);
        client.readTimeout(20, TimeUnit.SECONDS);
        client.connectTimeout(20, TimeUnit.SECONDS);
        client.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Content-Type", "application/json")
//                        .header("Accept", "application/json")
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });
    }


    private EditText ingredientsEditText;
    private EditText servingsEditText;
    private Button consultarButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item01);

        spoonacularService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build().create(SpoonacularService.class);

        ingredientsEditText = (EditText) findViewById(R.id.ingredients_edit_text);
        servingsEditText = (EditText) findViewById(R.id.servings_edit_text);
        consultarButton = (Button) findViewById(R.id.consultar);
        consultarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ingredients = ingredientsEditText.getText().toString();
                String servings = servingsEditText.getText().toString();
                consultar(ingredients, servings);
            }
        });

        resultTextView = (TextView) findViewById(R.id.result);

    }

    private void consultar(String ingredientsList, String servings) {
        if(ingredientsList != null && !ingredientsList.trim().isEmpty() &&
                servings != null && !servings.trim().isEmpty()) {

            String[] ingredients = ingredientsList.split(" ");
            if(ingredients.length < 1) {
                return;
            }
            int servingsNumber = 0;
            try {
                // testing if servings is a valid number
                servingsNumber = Integer.valueOf(servings);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

            String mashapeKey = "cNVH2hTI3qmshkI9LtSSmnFyBnKbp18BKEDjsnVNI60AO63aTg";

            GroceryProductsMapper groceryProductsMapper = new GroceryProductsMapper();

            List<String> mappedIngredients = new ArrayList<>();
            for(String ingredient : ingredients) {
                mappedIngredients.add(ingredient);
            }
            groceryProductsMapper.setIngredients(mappedIngredients);

            groceryProductsMapper.setServings(servingsNumber);

            Gson gson = new Gson();
            String json = gson.toJson(groceryProductsMapper);
            System.out.println(json);

            Call<List<GroceryProducts>> call = spoonacularService.groceryProducts(mashapeKey, "application/json", "application/json", groceryProductsMapper);
            call.enqueue(new Callback<List<GroceryProducts>>() {

                @Override
                public void onResponse(Call<List<GroceryProducts>> call, Response<List<GroceryProducts>> response) {
                        String resultText = "";
                        List<GroceryProducts> result = response.body();
                        for(GroceryProducts groceryProducts : result) {
                            resultText += groceryProducts.toString();
                        }
                        resultTextView.setText(resultText);
                }

                @Override
                public void onFailure(Call<List<GroceryProducts>> call, Throwable t) {
                    System.out.println(call.toString());
                    t.printStackTrace();
                }

            });



        }
    }

}
