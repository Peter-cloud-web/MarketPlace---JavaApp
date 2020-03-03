package com.moringa.shoerankapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{
    List<Shoe> shoeList;
//    @BindView(R.id.cart) Button mCart;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);
//            mCart.setOnClickListener(this);

            shoeList = new ArrayList<>();
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s11));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s1));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s2));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s12));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s14));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s3));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s4));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s5));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s6));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s7));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s8));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s9));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s3));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s4));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s5));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s6));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s7));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s8));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s9));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this,shoeList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(recyclerAdapter);


    }

//    @Override
//    public void onClick(View v) {
//       if ( v == mCart){
//           openCart();
//       }
//    }
//
//    private void openCart() {
//        Intent intent = new Intent(MainActivity.this, CartActivity.class);
//        startActivity(intent);
//     Toast.makeText(MainActivity.this,"One ordered",Toast.LENGTH_LONG);
//    }


}
