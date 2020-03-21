package com.moringa.shoerankapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.moringa.shoerankapp.Models.Shoe;
import com.moringa.shoerankapp.R;
import com.moringa.shoerankapp.Adapters.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{
    List<Shoe> shoeList = new ArrayList<>();

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        shoeList.add(new Shoe("Jordans", 500,"Pretty affordable",R.drawable.s));
        shoeList.add(new Shoe("Nike", 500,"Pretty affordable",R.drawable.s11));
        shoeList.add(new Shoe("Adidas", 500,"Pretty affordable",R.drawable.s1));
        shoeList.add(new Shoe("Airmax", 500,"Pretty affordable",R.drawable.s2));
        shoeList.add(new Shoe("Puma", 500,"Pretty affordable",R.drawable.s12));
        shoeList.add(new Shoe("Converse", 500,"Pretty affordable",R.drawable.s14));
        shoeList.add(new Shoe("Asics", 500,"Pretty affordable",R.drawable.s3));
        shoeList.add(new Shoe("Vans", 500,"Pretty affordable",R.drawable.s4));
        shoeList.add(new Shoe("Supra", 500,"Pretty affordable",R.drawable.s5));
        shoeList.add(new Shoe("Asics", 500,"Pretty affordable",R.drawable.s6));
        shoeList.add(new Shoe("New Balance", 500,"Pretty affordable",R.drawable.s7));
        shoeList.add(new Shoe("Skechers", 500,"Pretty affordable",R.drawable.s8));
        shoeList.add(new Shoe("Eddie", 500,"Pretty affordable",R.drawable.s9));
        shoeList.add(new Shoe("Newton", 500,"Pretty affordable",R.drawable.s3));
        shoeList.add(new Shoe("Geecheer", 500,"Pretty affordable",R.drawable.s4));
        shoeList.add(new Shoe("Amer", 500,"Pretty affordable",R.drawable.s5));
        shoeList.add(new Shoe("Brooks", 500,"Pretty affordable",R.drawable.s6));
        shoeList.add(new Shoe("Avia", 500,"Pretty affordable",R.drawable.s7));
        shoeList.add(new Shoe("Saecony", 500,"Pretty affordable",R.drawable.s8));
        shoeList.add(new Shoe("British Knights", 500,"Pretty affordable",R.drawable.s9));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this,shoeList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(recyclerAdapter);


    }

}
