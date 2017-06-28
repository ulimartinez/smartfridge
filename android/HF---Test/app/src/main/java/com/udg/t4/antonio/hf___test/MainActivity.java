package com.udg.t4.antonio.hf___test;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_Profile:
                    fragment = new ProfileFragment();
                    //mTextMessage.setText("Profile");
                    break;
                case R.id.navigation_CalorieC:
                    fragment = new CalorieFragment();
                    //mTextMessage.setText("Calorie Count");
                    break;
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    //mTextMessage.setText("Home");
                    break;
                case R.id.navigation_Ingredients:
                    fragment = new IngredientFragment();
                    //mTextMessage.setText("Ingredients");
                    break;
                case R.id.navigation_Recipes:
                    fragment = new RecipeFragment();
                    //mTextMessage.setText("Recipes");
                    break;
            }
            if (fragment != null) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content, fragment);
                fragmentTransaction.commit();
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
