package com.moringa.shoerankapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

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
           openShop();
       }
  }
   private void openShop(){
       Intent intent = new Intent(MenuActivity.this,profileActivity.class);
        startActivity(intent);
  }
}