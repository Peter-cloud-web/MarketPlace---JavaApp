package com.moringa.shoerankapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class shoeActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoe);

        Intent intent = getIntent();

        String name = intent.getExtras().getString("Name");
        String description = intent.getExtras().getString("Description");
        String price = intent.getExtras().getString("Price");
        String image = intent.getExtras().getString("Thumbnail");
    }
}
