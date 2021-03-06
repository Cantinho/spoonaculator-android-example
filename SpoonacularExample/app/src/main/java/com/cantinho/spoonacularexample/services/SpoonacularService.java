package com.cantinho.spoonacularexample.services;

import com.cantinho.spoonacularexample.retrofit_models.ClassifiedCuisine;
import com.cantinho.spoonacularexample.retrofit_models.ClassifiedProduct;
import com.cantinho.spoonacularexample.retrofit_models.ConvertedAmount;
import com.cantinho.spoonacularexample.retrofit_models.GroceryProducts;
import com.cantinho.spoonacularexample.retrofit_models.MealPlan;
import com.cantinho.spoonacularexample.retrofit_models.QuickAnswer;
import com.cantinho.spoonacularexample.retrofit_models.RecipeSummary;
import com.cantinho.spoonacularexample.retrofit_models.mappers.AmountMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.CuisineClassifierMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.DailyCaloriesMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.GroceryProductClassifierBatchMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.GroceryProductClassifierMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.GroceryProductsMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.IngredientsMapper;
import com.cantinho.spoonacularexample.retrofit_models.Recipe;
import com.cantinho.spoonacularexample.retrofit_models.mappers.MealMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.QuestioMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.RecipeMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.RecipeSummaryMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.VisualizeEquipamentParametersMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.VisualizeIngredientsParametersMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.VisualizeNutrientsParametersMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.VisualizePriceBreakdownParametersMapper;

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
    public static final String JSON_ACCEPT_HEADER = "application/json";
    public static final String TEXT_HTML_ACCEPT_HEADER = "text/html";

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
                        .header("Accept", JSON_ACCEPT_HEADER)
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
     * COMPUTE
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

        Call<ClassifiedProduct> call = spoonacularService.classifyAGroceryProduct(
                MASHAPE_KEY,
                APP_JSON_CONTENT_TYPE_HEADER,
                JSON_ACCEPT_HEADER,
                groceryProductClassifierMapper);
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

        Call<ClassifiedCuisine> call = spoonacularService.classifyCuisine(
            MASHAPE_KEY,
            URL_FORM_CONTENT_TYPE_HEADER, JSON_ACCEPT_HEADER,
            cuisineClassifierMapper.getIngredientListAsString(),
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

        Call<List<ClassifiedProduct>> call = spoonacularService.classifyAGroceryProductBatch(
                MASHAPE_KEY,
                APP_JSON_CONTENT_TYPE_HEADER,
                JSON_ACCEPT_HEADER,
                groceryProductClassifierBatchMapper);
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
                JSON_ACCEPT_HEADER,
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
                JSON_ACCEPT_HEADER,
                mealMapper.getDiet(),
                mealMapper.getExcludeListAsString(","),
                mealMapper.getTargetCalories(),
                mealMapper.getTimeFrame()
        );

        call.enqueue(callback);
    }

    /**
     * Map Ingredients to Grocery Products
     * Map a set of ingredients to products you can buy in the grocery store.
     *
     * @param groceryProductsMapper
     * @param callback
     */
    public void mapIngredientsToGroceryProducts(final GroceryProductsMapper groceryProductsMapper,
                                                final Callback<List<GroceryProducts>> callback) {

        Call<List<GroceryProducts>> call = spoonacularService
                .mapIngredientsToGroceryProducts(MASHAPE_KEY, APP_JSON_CONTENT_TYPE_HEADER, JSON_ACCEPT_HEADER,
                        groceryProductsMapper);

        call.enqueue(callback);
    }

    /**
     * Match Recipes to Daily Calories
     * Find multiple recipes that, when added up reach your daily caloric needs.
     *
     *
     * @param dailyCaloriesMapper
     * @param callback
     */
    public void matchRecipesToDailyCalories(final DailyCaloriesMapper dailyCaloriesMapper,
                                            final Callback<MealPlan> callback) {
        Call<MealPlan> call = spoonacularService.matchRecipesToDailyCalories(
                MASHAPE_KEY,
                JSON_ACCEPT_HEADER,
                dailyCaloriesMapper.getTargetCalories(),
                dailyCaloriesMapper.getTimeFrame()
        );
        call.enqueue(callback);
    }

    /**
     * Quick Answer
     * Answer a nutrition related natural language question.
     *
     * @param questioMapper
     * @param callback
     */
    public void getQuickAnswer(final QuestioMapper questioMapper,
                               final Callback<QuickAnswer> callback) {

        Call<QuickAnswer> call = spoonacularService.getQuickAnswer(
                MASHAPE_KEY,
                JSON_ACCEPT_HEADER,
                questioMapper.getQ()
        );
        call.enqueue(callback);
    }

    /**
     * Summarize Recipe
     * Summarize the recipe in a short text.
     *
     * @param recipeSummaryMapper
     * @param callback
     */
    public void summarizeRecipe(final RecipeSummaryMapper recipeSummaryMapper,
                                final Callback<RecipeSummary> callback) {

        Call<RecipeSummary> call = spoonacularService.summarizeRecipe(
                MASHAPE_KEY,
                JSON_ACCEPT_HEADER,
                recipeSummaryMapper.getId()
        );
        call.enqueue(callback);
    }


    /**
     * Visualize Equipment
     * Visualize the equipment used to make a recipe.
     *
     * @param visualizeEquipamentParametersMapper
     * @param callback
     */
    //todo: check custom accept header (text/html or application/json)
    public void visualizeEquipament(final VisualizeEquipamentParametersMapper visualizeEquipamentParametersMapper,
                                    final Callback<String> callback) {

        Call<String> call = spoonacularService.visualizeEquipament(
                MASHAPE_KEY,
                TEXT_HTML_ACCEPT_HEADER,
                visualizeEquipamentParametersMapper.isDefaultCss(),
                visualizeEquipamentParametersMapper.getInstructions(),
                visualizeEquipamentParametersMapper.isShowBackLink(),
                visualizeEquipamentParametersMapper.getView()
        );
        call.enqueue(callback);
    }

    /**
     * Visualize Ingredients
     * Visualize ingredients of a recipe.
     *
     * @param visualizeIngredientsParametersMapper
     * @param callback
     */
    public void visualizeIngredients(final VisualizeIngredientsParametersMapper visualizeIngredientsParametersMapper,
                                    final Callback<String> callback) {

        Call<String> call = spoonacularService.visualizeIngredients(
                MASHAPE_KEY,
                TEXT_HTML_ACCEPT_HEADER,
                visualizeIngredientsParametersMapper.isDefaultCss(),
                visualizeIngredientsParametersMapper.getIngredientsListAsStringPerLine(),
                visualizeIngredientsParametersMapper.getMeasure(),
                visualizeIngredientsParametersMapper.getServings(),
                visualizeIngredientsParametersMapper.isShowBacklink(),
                visualizeIngredientsParametersMapper.getView()
        );
        call.enqueue(callback);
    }

    /**
     * Visualize Nutrition
     * Visualize a recipe's nutritional information.
     *
     * @param visualizeNutrientsParametersMapper
     * @param callback
     */
    public void visualizeNutrients(final VisualizeNutrientsParametersMapper visualizeNutrientsParametersMapper,
                                     final Callback<String> callback) {

        Call<String> call = spoonacularService.visualizeNutrients(
                MASHAPE_KEY,
                TEXT_HTML_ACCEPT_HEADER,
                visualizeNutrientsParametersMapper.isDefaultCss(),
                visualizeNutrientsParametersMapper.getIngredientsListAsStringPerLine(),
                visualizeNutrientsParametersMapper.getServings(),
                visualizeNutrientsParametersMapper.isShowBacklink()
        );
        call.enqueue(callback);
    }

    public void visualizePriceBreakdown(final VisualizePriceBreakdownParametersMapper visualizePriceBreakdownParametersMapper,
                                   final Callback<String> callback) {

        Call<String> call = spoonacularService.visualizePriceBreakdown(
                MASHAPE_KEY,
                TEXT_HTML_ACCEPT_HEADER,
                visualizePriceBreakdownParametersMapper.isDefaultCss(),
                visualizePriceBreakdownParametersMapper.getIngredientsListAsStringPerLine(),
                visualizePriceBreakdownParametersMapper.getMode(),
                visualizePriceBreakdownParametersMapper.getServings(),
                visualizePriceBreakdownParametersMapper.isShowBacklink()
        );
        call.enqueue(callback);
    }


    /**
     * ANOTHER CATEGORY
     */

    public void findRecipesByIngredients(final IngredientsMapper ingredientsMapper, final Callback<List<Recipe>> callback) {

        Call<List<Recipe>> call = spoonacularService.findRecipesByIngredients(MASHAPE_KEY,
                APP_JSON_CONTENT_TYPE_HEADER, JSON_ACCEPT_HEADER, ingredientsMapper.isFillIngredients(),
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
