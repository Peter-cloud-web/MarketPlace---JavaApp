package com.moringa.shoerankapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringa.shoerankapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class profileActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.userEmail) TextView userEmail;
    @BindView(R.id.logout) Button logout;
    @BindView(R.id.delete) Button delete;
    private static final String TAG = "profileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            userEmail.setText(user.getEmail());


            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
        }

        logout.setOnClickListener(this);
        delete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
       if (v == logout){
           signOut();
       }
       if(v == delete){
           delete();
       }
    }
    private void signOut(){
        AuthUI.getInstance().signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(profileActivity.this,"successfully logged out",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                            finish();
                        } else {
                            // Signout failed
                        }
                    }
                });
    }
    private void delete(){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        currentUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(profileActivity.this, CoverpageActivity.class));
                    Toast.makeText(profileActivity.this,"Account deleted successfully",Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(profileActivity.this, "Connection error.PLease try again later", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
