package com.moringa.shoerankapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.moringa.shoerankapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.registerApp) Button mRegister;
    @BindView(R.id.loginApp) Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);
        mRegister.setOnClickListener(this);
        mLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if ( v == mRegister){
            openRegister();
        }
        if ( v == mLogin){
            openLogin();
        }
    }

    private void openRegister() {
        Intent intent = new Intent(CartActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
    private void openLogin() {
        Intent intent = new Intent(CartActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}
