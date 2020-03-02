package com.moringa.shoerankapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.registerApp) Button mRegister;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);
            mRegister.setOnClickListener(this);



    }
    @Override
    public void onClick(View v) {
       if ( v == mRegister){
           openRegister();
       }
    }

    private void openRegister() {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);

    }
}
