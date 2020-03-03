package com.moringa.shoerankapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class shoeActivity extends AppCompatActivity {
    private TextView name,description,price;
    private ImageView thumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoe);

        name = (TextView)findViewById(R.id.txt1);
        description = (TextView)findViewById(R.id.txt2);
        price = (TextView)findViewById(R.id.txt3);
        thumbnail = (ImageView) findViewById(R.id.shoeImage);

        Intent intent = getIntent();

        String name = intent.getExtras().getString("Name");
        String description = intent.getExtras().getString("Description");
        String price = intent.getExtras().getString("Price");
        int image = intent.getExtras().getInt("Thumbnail");

        thumbnail.setImageResource(image);
    }
}
