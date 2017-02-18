package com.cantinho.spoonacularexample.services;

import com.cantinho.spoonacularexample.retrofit_models.ClassifiedCuisine;
import com.cantinho.spoonacularexample.retrofit_models.ClassifiedProduct;
import com.cantinho.spoonacularexample.retrofit_models.ConvertedAmount;
import com.cantinho.spoonacularexample.retrofit_models.GroceryProducts;
import com.cantinho.spoonacularexample.retrofit_models.MealPlan;
import com.cantinho.spoonacularexample.retrofit_models.mappers.AmountMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.CuisineClassifierMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.GroceryProductClassifierBatchMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.GroceryProductClassifierMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.GroceryProductsMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.IngredientsMapper;
import com.cantinho.spoonacularexample.retrofit_models.Recipe;
import com.cantinho.spoonacularexample.retrofit_models.mappers.MealMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.RecipeMapper;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samirtf on 18/02/17.
 */
public class SpoonacularService {

    // Trailing slash is needed
    public static final String BASE_URL = "https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/";
    public static final String MASHAPE_KEY = "put_your_mashape_key_here";
    public static final String APP_JSON_CONTENT_TYPE_HEADER = "application/json";
    public static final String URL_FORM_CONTENT_TYPE_HEADER = "application/x-www-form-urlencoded";
    public static final String ACCEPT_HEADER = "application/json";

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
                        .header("Content-Type", APP_JSON_CONTENT_TYPE_HEADER)
                        .header("Accept", ACCEPT_HEADER)
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });
    }

    public SpoonacularService() {
        createRetrofitService();
    }

    private void createRetrofitService() {
        spoonacularService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build().create(ISpoonacularService.class);
    }

    /**
     * CLASSIFIERS
     */

    /**
     * Classify a Grocery Product
     * Given a grocery product title, this endpoint allows you to detect what
     * basic ingredient it is.
     *
     * @param groceryProductClassifierMapper
     * @param callback
     */
    public void classifyAGroceryProduct(final GroceryProductClassifierMapper groceryProductClassifierMapper,
                                        final Callback<ClassifiedProduct> callback) {

        Call<ClassifiedProduct> call = spoonacularService.classifyAGroceryProduct(MASHAPE_KEY, APP_JSON_CONTENT_TYPE_HEADER, ACCEPT_HEADER, groceryProductClassifierMapper);
        call.enqueue(callback);
    }

    /**
     * Classify Cuisine
     * Classify the recipe's cuisine.
     *
     * @param cuisineClassifierMapper
     * @param callback
     */
    public void classifyCuisine(final CuisineClassifierMapper cuisineClassifierMapper,
                                final Callback<ClassifiedCuisine> callback) {

        Call<ClassifiedCuisine> call = spoonacularService
                .classifyCuisine(MASHAPE_KEY, URL_FORM_CONTENT_TYPE_HEADER, ACCEPT_HEADER,
                        cuisineClassifierMapper.getIngredientList(),
                        cuisineClassifierMapper.getTitle());

        call.enqueue(callback);
    }

    /**
     * Classify Grocery Products (Batch)
     * Given a set of product jsons, get back classified products.
     *
     * @param groceryProductClassifierBatchMapper
     * @param callback
     */
    public void classifyAGroceryProductBatch(final GroceryProductClassifierBatchMapper groceryProductClassifierBatchMapper,
                                             final Callback<List<ClassifiedProduct>> callback) {

        Call<List<ClassifiedProduct>> call = spoonacularService.classifyAGroceryProductBatch(MASHAPE_KEY,
                APP_JSON_CONTENT_TYPE_HEADER, ACCEPT_HEADER, groceryProductClassifierBatchMapper);
        call.enqueue(callback);
    }

    /**
     * Convert Amounts
     * Convert amounts like "2 cups of flour to grams".
     *
     * @param amountMapper
     * @param callback
     */
    public void convertAmounts(final AmountMapper amountMapper,
                               final Callback<ConvertedAmount> callback) {

        Call<ConvertedAmount> call = spoonacularService.convertAmounts(
                MASHAPE_KEY,
                ACCEPT_HEADER,
                amountMapper.getIngredientName(),
                amountMapper.getSourceAmount(),
                amountMapper.getSourceUnit(),
                amountMapper.getTargetUnit());

        call.enqueue(callback);
    }

    // todo: we must test this.

    /**
     * Create Recipe Card
     * Create a recipe card given a recipe.
     *
     * @param recipeMapper
     * @param callback
     */
    public void createRecipeCard(final RecipeMapper recipeMapper, final Callback<ResponseBody> callback) {
        Call<ResponseBody> call = spoonacularService.createRecipeCard(
                MASHAPE_KEY,
                recipeMapper.getAuthor(),
                recipeMapper.getBackgroundColor(),
                recipeMapper.getBackgroundImage(),
                recipeMapper.getFontColor(),
                recipeMapper.getImage(),
                recipeMapper.getIngredientsAsStringPerLine(),
                recipeMapper.getInstructionsAsStringPerLine(),
                recipeMapper.getMask(),
                recipeMapper.getReadyInMinutes(),
                recipeMapper.getServings(),
                recipeMapper.getSource(),
                recipeMapper.getTitle());
    }

    /**
     * Generate Meal Plan
     * Generate a meal plan with three meals per day (breakfast, lunch, and dinner).
     *
     * @param mealMapper
     * @param callback
     */
    public void generateMealPlan(final MealMapper mealMapper, final Callback<MealPlan> callback) {
        Call<MealPlan> call = spoonacularService.generateMealPlan(
                MASHAPE_KEY,
                APP_JSON_CONTENT_TYPE_HEADER,
                ACCEPT_HEADER,
                mealMapper.getDiet(),
                mealMapper.getExclude(),
                mealMapper.getTargetCalories(),
                mealMapper.getTimeFrame()
        );

        call.enqueue(callback);
    }



    /**
     * ANOTHER CATEGORY
     */

    public void mapIngredientsToGroceryProducts(final GroceryProductsMapper groceryProductsMapper,
                                                final Callback<List<GroceryProducts>> callback) {

        Call<List<GroceryProducts>> call = spoonacularService
                .mapIngredientsToGroceryProducts(MASHAPE_KEY, APP_JSON_CONTENT_TYPE_HEADER, ACCEPT_HEADER,
                        groceryProductsMapper);

        call.enqueue(callback);
    }

    /**
     * ANOTHER CATEGORY
     */

    public void findRecipesByIngredients(final IngredientsMapper ingredientsMapper, final Callback<List<Recipe>> callback) {

        Call<List<Recipe>> call = spoonacularService.findRecipesByIngredients(MASHAPE_KEY,
                APP_JSON_CONTENT_TYPE_HEADER, ACCEPT_HEADER, ingredientsMapper.isFillIngredients(),
                ingredientsMapper.getIngredientsAsString(","),
                ingredientsMapper.isLimitLicense(),
                ingredientsMapper.getNumber(),
                ingredientsMapper.getRanking());

        call.enqueue(callback);
    }

    /**
     * ANOTHER CATEGORY
     */

}
