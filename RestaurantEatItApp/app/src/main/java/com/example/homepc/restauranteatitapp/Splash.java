package com.example.homepc.restauranteatitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent intent= new Intent(getApplicationContext(),LoginOptionsPage.class);
        startActivity(intent);
        finish();


    }
}
