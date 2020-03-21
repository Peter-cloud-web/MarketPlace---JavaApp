package com.moringa.shoerankapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moringa.shoerankapp.R;

public class CoverpageActivity extends AppCompatActivity implements View.OnClickListener {
    Button mCoverPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coverpage);

        mCoverPage = findViewById(R.id.coverpage);

        mCoverPage.setOnClickListener(this);


    }

        @Override
        public void onClick (View v){
            if (v == mCoverPage) {
                openLogin();
            }

        }
    private void openLogin() {
        Intent intent = new Intent (CoverpageActivity.this, LoginActivity.class);
        Toast.makeText(CoverpageActivity.this,"Welcome to shoeRank",Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}


