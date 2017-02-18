package com.cantinho.spoonacularexample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cantinho.spoonacularexample.R;
import com.cantinho.spoonacularexample.retrofit_models.Recipe;
import com.cantinho.spoonacularexample.services.ISpoonacularService;
import com.cantinho.spoonacularexample.services.SpoonacularService;

import java.io.IOException;
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


public class MenuItem02Activity extends AppCompatActivity {

    // Trailing slash is needed
    public static final String BASE_URL = "https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/";

    private ISpoonacularService spoonacularService;
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


    private EditText fillIngredientsEditText;
    private EditText ingredientsEditText;
    private EditText limitLicenseEditText;
    private EditText numberEditText;
    private EditText rankingEditText;
    private Button consultarButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item02);

        spoonacularService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build().create(ISpoonacularService.class);

        fillIngredientsEditText = (EditText) findViewById(R.id.fill_ingredients_edit_text);
        ingredientsEditText = (EditText) findViewById(R.id.ingredients_edit_text);
        limitLicenseEditText = (EditText) findViewById(R.id.limit_license_edit_text);
        numberEditText = (EditText) findViewById(R.id.number_edit_text);
        rankingEditText = (EditText) findViewById(R.id.ranking_edit_text);

        consultarButton = (Button) findViewById(R.id.consultar);
        consultarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fillIngredients = fillIngredientsEditText.getText().toString();
                String ingredients = ingredientsEditText.getText().toString();
                String limitLicense = limitLicenseEditText.getText().toString();
                String number = numberEditText.getText().toString();
                String ranking = rankingEditText.getText().toString();

                consultar(fillIngredients, ingredients, limitLicense, number, ranking);
            }
        });

        resultTextView = (TextView) findViewById(R.id.result);



    }


    private void consultar(String fillIngredients, String ingredientsList, String limitLicense,
                           String number, String ranking) {

        if(fillIngredients != null && !fillIngredients.trim().isEmpty() &&
                ingredientsList != null && !ingredientsList.trim().isEmpty() &&
                limitLicense != null && !limitLicense.trim().isEmpty() &&
                number != null && !number.trim().isEmpty() &&
                ranking != null && !ranking.trim().isEmpty()) {

            boolean mustFillIngredients;
            boolean mustLimitLicense;
            int numberAsInteger;
            int rankingAsInteger;
            try {
                mustFillIngredients = Boolean.parseBoolean(fillIngredients);
                mustLimitLicense = Boolean.parseBoolean(limitLicense);
                numberAsInteger = Integer.valueOf(number.trim());
                rankingAsInteger = Integer.valueOf(ranking.trim());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

            String ingredients = ingredientsList.replace(" ", "").trim();

            Call<List<Recipe>> call = spoonacularService.findRecipesByIngredients(SpoonacularService.MASHAPE_KEY, "application/json", "application/json", mustFillIngredients, ingredientsList, mustLimitLicense, numberAsInteger, rankingAsInteger);
            call.enqueue(new Callback<List<Recipe>>() {

                @Override
                public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                    String resultText = "";
                    List<Recipe> result = response.body();
                    for(Recipe recipe : result) {
                        resultText += recipe.toString();
                    }
                    resultTextView.setText(resultText);
                }

                @Override
                public void onFailure(Call<List<Recipe>> call, Throwable t) {
                    System.out.println(call.toString());
                    t.printStackTrace();
                }

            });



        }
    }

}
