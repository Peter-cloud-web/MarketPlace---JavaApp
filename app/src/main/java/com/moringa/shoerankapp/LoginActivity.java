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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = LoginActivity.class.getSimpleName();

    Button mLogin;
    Button mRegister;
    Button mWrite;
    TextView viewText;
    EditText mEmail;
    EditText mPassword;

    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mLogin = findViewById(R.id.login);
        mRegister = findViewById(R.id.register);


        mEmail = findViewById(R.id.loginEmail);
        mPassword = findViewById(R.id.loginPassword);

        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        mWrite = findViewById(R.id.writeToUs);

        mAuth = FirebaseAuth.getInstance();


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

        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        if (email.equals("")) {
            mEmail.setError("Please enter your email");
            return;
        }
        if (password.equals("")) {
            mPassword.setError("Password cannot be blank");
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(LoginActivity.this, "Login was successful", Toast.LENGTH_SHORT).show()
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        }
                    }
                });

    }

    private void openRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        Toast.makeText(LoginActivity.this,"Welcome to the registry panel " ,Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}
