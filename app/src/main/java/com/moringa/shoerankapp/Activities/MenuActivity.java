package com.moringa.shoerankapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.moringa.shoerankapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.logout) ImageView logout;
    @BindView(R.id.settings) ImageView settings;
    @BindView(R.id.profile) ImageView profile;
    @BindView(R.id.cart) ImageView cart;
    @BindView(R.id.purchases) ImageView purchases;
    @BindView(R.id.shop) ImageView shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        profile.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(MenuActivity.this,"click to view profile",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        logout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(MenuActivity.this,"click to logout",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        shop.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)++ {
                Toast.makeText(MenuActivity.this,"click to start shopping",Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        logout.setOnClickListener(this);
        profile.setOnClickListener(this);
        settings.setOnClickListener(this);
        cart.setOnClickListener(this);
        purchases.setOnClickListener(this);
        shop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(v == profile ){
            openProfile();
        }
        if(v == logout){
            signOut();
        }

        if(v==shop){
            openShop();
        }
    }
    private void openProfile(){
        Intent intent = new Intent(MenuActivity.this,profileActivity.class);
        Toast.makeText(MenuActivity.this,"Welcome to your profile",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
    private void signOut(){
        AuthUI.getInstance().signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MenuActivity.this,"Successfully logged out",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                            finish();
                        } else {
                            // Signout failed
                        }
                    }
                });
    }
    private void openShop(){
        Intent intent = new Intent(MenuActivity.this,MainActivity.class);
        Toast.makeText(MenuActivity.this,"Start shopping for shoes",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}