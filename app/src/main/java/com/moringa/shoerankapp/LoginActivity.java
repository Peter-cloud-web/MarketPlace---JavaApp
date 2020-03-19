package com.moringa.shoerankapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener

    Button mLogin;
    Button mRegister;
    Button mWrite;
    TextView viewText;
    EditText mName;
    EditText mPassword;
    SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefs = PreferenceManager.getDefaultSharedPreferences(this); //
        prefs.registerOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) this);

        mLogin = findViewById(R.id.login);
        mRegister = findViewById(R.id.register);


        mName = findViewById(R.id.loginName);
        mPassword = findViewById(R.id.loginPassword);

        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        mWrite = findViewById(R.id.writeToUs);
        mWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.setValue("Hello, I would like to make a purchase of 2 jordans.");
            }
        });
        viewText = findViewById(R.id.viewText);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                viewText.setText(value);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Ch3", "Failed to read value.", error.toException());
            }
        });
    }


    @Override
    public void onClick(View v) {
        if ( v == mLogin){
            openLogin();
        }
        if(v==mRegister){
            openRegister();
        }
    }

    private void openLogin() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        String name  = mName.getText().toString();
        intent.putExtra("name",name);
        Toast.makeText(LoginActivity.this,"You are logged in as " +name ,Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
    private void openRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        Toast.makeText(LoginActivity.this,"Welcome to the registry panel " ,Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}
