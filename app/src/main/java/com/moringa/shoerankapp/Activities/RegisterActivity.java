package com.moringa.shoerankapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moringa.shoerankapp.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button mRegister;
    private FirebaseAuth mAuth;
    EditText mName, mEmail, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mRegister =  findViewById(R.id.registerNow);

        mName = findViewById(R.id.registerName);
        mEmail = findViewById(R.id.RegisterEmail);
        mPassword = findViewById(R.id.RegisterPassword);

        mRegister.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        if ( v == mRegister){
            openLogin();
        }
    }


    private void openLogin() {
        String name = mName.getText().toString().trim();
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();


        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                          Toast.makeText(RegisterActivity.this,"User successfully created",Toast.LENGTH_LONG).show();
                          Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                          startActivity(intent);
                      } else{
                          Toast.makeText(RegisterActivity.this,"Please try again later",Toast.LENGTH_LONG).show();
                      }
                    }
                });

    }
}
