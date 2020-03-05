package com.moringa.shoerankapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button mLogin;
    EditText mName;
    EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogin = findViewById(R.id.login);
        mName = findViewById(R.id.loginName);
        mPassword = findViewById(R.id.loginPassword);

        mLogin.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        if ( v == mLogin){
            openLogin();
        }
    }

    private void openLogin() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        String name  = mName.getText().toString();
        intent.putExtra("name",name);
        Toast.makeText(LoginActivity.this,"You are logged in as " +name ,Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}
