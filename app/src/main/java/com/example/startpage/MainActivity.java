package com.example.startpage;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    ListView Cocktaillist;
    String[] text = {"loerm","ipsum","test","local"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                new myTask().execute();            }
        }, 1000);

    }
    class myTask extends AsyncTask<Void,String,Void>{

        private ArrayList<String> arrayList = new ArrayList<String>();

        @Override
        protected Void doInBackground(Void... voids) {
            for(String item: text){
                publishProgress(item);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            arrayList.add(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(MainActivity.this,"All items where added succesfull", Toast.LENGTH_SHORT).show();

            /*// Test ArrayList
            for (String s : arrayList){
                Log.d("My array list content:", s);
            }*/

            Intent intent_ShowCocktailsActivity = new Intent(MainActivity.this, ShowCocktailsActivity.class);
            intent_ShowCocktailsActivity.putStringArrayListExtra("CocktailList",arrayList);
            intent_ShowCocktailsActivity.setFlags(intent_ShowCocktailsActivity.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent_ShowCocktailsActivity);
            finish();
        }
    }
}