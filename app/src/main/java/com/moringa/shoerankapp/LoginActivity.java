package com.moringa.shoerankapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        Button login = (Button) findViewById(R.id.loginNow);
        EditText name = (EditText) findViewById(R.id.registerAllName);
        EditText email = (EditText) findViewById(R.id.RegisterEmail);
        EditText password = (EditText) findViewById(R.id.RegisterPassword);

    }
}
