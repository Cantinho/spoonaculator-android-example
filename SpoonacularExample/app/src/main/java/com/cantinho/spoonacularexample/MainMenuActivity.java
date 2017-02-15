package com.cantinho.spoonacularexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MainMenuActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";

    public static final int MENU_01 = 1;
    public static final int MENU_02 = 2;
    public static final int MENU_03 = 3;
    public static final int MENU_04 = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        initFunctions();
        mRecyclerView = (RecyclerView) findViewById(R.id.spoonacular_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(MainMenuActivity.this, getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }


    @Override
    protected void onResume() {
        super.onResume();
        ((MyAdapter) mAdapter).setOnItemClickListener(new MyAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    private ArrayList<com.cantinho.spoonacularexample.Card> getDataSet() {
        ArrayList<com.cantinho.spoonacularexample.Card> results = new ArrayList<>();
        if(functions != null && !functions.isEmpty()) {
            int functionsSize = functions.size();
            for (int index = 1; index <= functionsSize; index++) {
                String currentNumber = String.format("%01d", index);
                Card card = functions.get("F"+currentNumber);
                if(card != null) {
                    results.add(card);
                }
            }
        }
        return results;
    }

    private static Map<String, Card> functions = new TreeMap<>();

    private void initFunctions() {
        if(functions == null) {
            functions = new TreeMap<>();
        }
        if(functions.isEmpty()) {
            functions.put("F1", new Card(1, "Map Ingredients to Grocery Products" , "Map a set of ingredients to products you can buy in the grocery store."));
            functions.put("F2", new Card(2, "Find By Ingredients" , "Find recipes that use as many of the given ingredients as possible and have as little as possible missing ingredients. This is a whats in your fridge API endpoint."));
            functions.put("F3", new Card(3, "Map Ingredients to Grocery Products" , "Map a set of ingredients to products you can buy in the grocery store."));
            functions.put("F4", new Card(4, "Map Ingredients to Grocery Products" , "Map a set of ingredients to products you can buy in the grocery store."));

        }
    }

}
