package com.moringa.shoerankapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.moringa.shoerankapp.R;

public class SplashScreen extends AppCompatActivity {

    RelativeLayout rLayout;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rLayout.setVisibility(View.VISIBLE);
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        rLayout = findViewById(R.id.delay);

        handler.postDelayed(runnable,3000);

      }

}



