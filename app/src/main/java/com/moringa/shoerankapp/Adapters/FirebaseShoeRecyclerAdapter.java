package com.moringa.shoerankapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringa.shoerankapp.Activities.shoeActivity;
import com.moringa.shoerankapp.Models.Shoe;
import com.moringa.shoerankapp.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseShoeRecyclerAdapter extends RecyclerView.Adapter<FirebaseShoeRecyclerAdapter.MyViewHolder>{
    private Context mContext;
    private List<Shoe> mShoe;

    public FirebaseShoeRecyclerAdapter(Context mContext, List<Shoe> mShoe) {
        this.mContext = mContext;
        this.mShoe = mShoe;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.shoes_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.shoeName.setText(mShoe.get(position).getName());
        holder.shoeImage.setImageResource(mShoe.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("posts").push();

                Map<String, Object> map = new HashMap<>();

                map.put("name", databaseReference.getKey());
                map.put("description",databaseReference.getKey());
                map.put("price",databaseReference.getKey());
                map.put("Thumbnail",databaseReference.getKey());

                databaseReference.setValue(map);

                Intent intent = new Intent(mContext, shoeActivity.class);
                intent.putExtra("name",mShoe.get(position).getName());
                intent.putExtra("description",mShoe.get(position).getDescription());
                intent.putExtra("price",mShoe.get(position).getPrice());
                intent.putExtra("Thumbnail",mShoe.get(position).getThumbnail());
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mShoe.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView shoeName;
        ImageView shoeImage;
        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);

            shoeName= itemView.findViewById(R.id.shoeTitle);
            shoeImage =  itemView.findViewById(R.id.shoeImage);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
