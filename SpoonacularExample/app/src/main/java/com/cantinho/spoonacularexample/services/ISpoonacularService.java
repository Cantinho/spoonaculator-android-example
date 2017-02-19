package com.cantinho.spoonacularexample.services;

import com.cantinho.spoonacularexample.retrofit_models.ClassifiedProduct;
import com.cantinho.spoonacularexample.retrofit_models.ConvertedAmount;
import com.cantinho.spoonacularexample.retrofit_models.GroceryProducts;
import com.cantinho.spoonacularexample.retrofit_models.MealPlan;
import com.cantinho.spoonacularexample.retrofit_models.QuickAnswer;
import com.cantinho.spoonacularexample.retrofit_models.RecipeInformation;
import com.cantinho.spoonacularexample.retrofit_models.RecipeSummary;
import com.cantinho.spoonacularexample.retrofit_models.mappers.AmountMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.GroceryProductClassifierBatchMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.GroceryProductClassifierMapper;
import com.cantinho.spoonacularexample.retrofit_models.mappers.GroceryProductsMapper;
import com.cantinho.spoonacularexample.retrofit_models.Recipe;

import java.io.File;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ISpoonacularService {

    /**
     * COMPUTE
     */

    @POST("food/products/classify")
    Call<ClassifiedProduct> classifyAGroceryProduct(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Body GroceryProductClassifierMapper body
    );


    @FormUrlEncoded
    @POST("recipes/cuisine")
    Call classifyCuisine(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Field("ingredientList") String ingredientList,
            @Field("title") String title
    );

    @POST("food/products/classifyBatch")
    Call<List<ClassifiedProduct>> classifyAGroceryProductBatch(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Body GroceryProductClassifierBatchMapper body);

    @GET("recipes/convert")
    Call<ConvertedAmount> convertAmounts(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Accept") String accept,
            @Query("ingredientName") String ingredientName,
            @Query("sourceAmount") double sourceAmount,
            @Query("sourceUnit") String sourceUnit,
            @Query("targetUnit") String targetUnit
    );

    @POST("recipes/visualizeRecipe")
    Call<ResponseBody> createRecipeCard(
            @Header("X-Mashape-Key") String mashapeKey,
            @Field("author") String author,
            @Field("backgroundColor") String backgroundColor,
            @Field("backgroundImage") String backgroundImage,
            @Field("fontColor") String fontColor,
            @Field("image") File image,
            @Field("ingredients") String ingredients,
            @Field("instructions") String instructions,
            @Field("mask") String mask,
            @Field("readyInMinutes") int readyInMinutes,
            @Field("servings") int servings,
            @Field("source") String source,
            @Field("title") String title);


    Call<MealPlan> generateMealPlan(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Query("diet") String diet,
            @Query("exclude") String exclude,
            @Query("targetCalories") int targetCalories,
            @Query("timeFrame") String timeFrame
    );

    @GET("recipes/mealplans/generate")
    Call<MealPlan> matchRecipesToDailyCalories(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Accept") String accept,
            @Query("targetCalories") int targetCalories,
            @Query("day") String day
    );

    @GET("recipes/quickAnswer")
    Call<QuickAnswer> getQuickAnswer(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Accept") String accept,
            @Query("q") String q
    );

    @GET("recipes/{id}/summary")
    Call<RecipeSummary> summarizeRecipe(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Accept") String accept,
            @Path("id") int id
    );

    @POST("recipes/visualizeEquipment")
    Call<String> visualizeEquipament(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Accept") String textHtmlAcceptHeader,
            @Field("defaultCss") boolean defaultCss,
            @Field("instructions") String instructions,
            @Field("showBackLink") boolean showBackLink,
            @Field("view") String view
    );

    @POST("recipes/visualizeIngredients")
    Call<String> visualizeIngredients(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Accept") String textHtmlAcceptHeader,
            @Field("defaultCss") boolean defaultCss,
            @Field("ingredientList") String ingredientsList,
            @Field("measure") String measure,
            @Field("servings") int servings,
            @Field("showBacklink") boolean showBacklink,
            @Field("view") String view
    );

    @POST("recipes/visualizeNutrition")
    Call<String> visualizeNutrients(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Accept") String textHtmlAcceptHeader,
            @Field("defaultCss") boolean defaultCss,
            @Field("ingredientList") String ingredientsList,
            @Field("servings") int servings,
            @Field("showBacklink") boolean showBacklink
    );

    /**
     * ANOTHER CATEGORY
     */

    @POST("food/ingredients/map")
    Call<List<GroceryProducts>> mapIngredientsToGroceryProducts(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Body GroceryProductsMapper body);

    @GET("recipes/findByIngredients")
    Call<List<Recipe>> findRecipesByIngredients(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Query("fillIngredients") boolean fillIngredients,
            @Query("ingredients") String ingredients,
            @Query("limitLicense") boolean limitLicense,
            @Query("number") Integer number,
            @Query("ranking") Integer ranking);

    @GET("recipes/{id}/information")
    Call<RecipeInformation> getRecipeInformation(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Path("id") int id,
            @Query("includeNutrition") boolean includeNutrition);



}
