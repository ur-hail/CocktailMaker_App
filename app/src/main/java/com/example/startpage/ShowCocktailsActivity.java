package com.example.startpage;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class ShowCocktailsActivity extends AppCompatActivity {
    ListView Cocktaillist;
    String[] text = {"loerm","ipsum","test","local"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cocktails);

        ListView list = (ListView) findViewById(R.id.cocktailListView);
        ArrayList<String> cocktaillijst = getIntent().getStringArrayListExtra("CocktailList");

        list.setAdapter((new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,cocktaillijst)));
    }
}
