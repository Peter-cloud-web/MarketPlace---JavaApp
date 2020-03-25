package com.moringa.shoerankapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moringa.shoerankapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class shoeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView description,price;
    private TextView name;
    private ImageView thumbnail;

        @BindView(R.id.loginApp) Button mLogin;
        @BindView(R.id.registerApp) Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoe);
        ButterKnife.bind(this);

        mRegister.setOnClickListener(this);

        name = findViewById(R.id.txt1);
        description = findViewById(R.id.txt2);
        price = findViewById(R.id.txt3);
        thumbnail =findViewById(R.id.shoeImage);

        Intent intent = getIntent();

        String name = intent.getExtras().getString("name");
        String description = intent.getExtras().getString("description");
        int price = intent.getExtras().getInt("price");
        int image = intent.getExtras().getInt("Thumbnail");

        thumbnail.setImageResource(image);

    }
    @Override
    public void onClick(View v) {
        if ( v == mRegister){
            openLogin();
        }
            if ( v == mLogin){
                openRegister();
            }
        }

        private void openLogin() {
            Intent intent = new Intent(shoeActivity.this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(shoeActivity.this,"One ordered",Toast.LENGTH_LONG);
        }
    private void openRegister() {
        Intent intent = new Intent(shoeActivity.this,   RegisterActivity.class);
        startActivity(intent);
        Toast.makeText(shoeActivity.this,"One ordered",Toast.LENGTH_LONG);
    }
}
