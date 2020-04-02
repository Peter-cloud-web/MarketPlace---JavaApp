package com.moringa.shoerankapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringa.shoerankapp.R;

public class SplashScreen extends AppCompatActivity {

    RelativeLayout rLayout;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void ru() {
            rLayout.setVisibility(View.VISIBLE);
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coverpage);

        rLayout = findViewById(R.id.delay);

        handler.postDelayed(runnable,3000);

//        mCoverPage //        mCoverPage = findViewById(R.id.coverpage);
//
//        mCoverPage.setOnClickListener(this);

//        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
//        firebaseAuth.addAuthStateListener(authStateListener);

      }

//    @Override
//    public void onClick(View v) {
//        if(v == mCoverPage){
//            openLogin();
//        }
//    }


//    private void openLogin() {
//        Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
//        startActivity(intent);
//    }

//
//    FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
//        @Override
//        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
//
//            if (firebaseUser == null) {
//
//                private void openLogin(){
//
//
//                }
//                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//            if (firebaseUser != null) {
//                Intent intent = new Intent(SplashScreen.this, MenuActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        }
//    };



}



