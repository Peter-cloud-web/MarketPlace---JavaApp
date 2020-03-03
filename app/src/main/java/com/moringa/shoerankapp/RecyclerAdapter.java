package com.moringa.shoerankapp;

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

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    private Context mContext;
    private List<Shoe> mShoe;

    public RecyclerAdapter(Context mContext, List<Shoe> mShoe) {
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
                Intent intent = new Intent(mContext,shoeActivity.class);
                intent.putExtra("Name",mShoe.get(position).getName());
                intent.putExtra("Description",mShoe.get(position).getDescription());
                intent.putExtra("Price",mShoe.get(position).getPrice());
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

            shoeName= (TextView) itemView.findViewById(R.id.shoeTitle);
            shoeImage = (ImageView) itemView.findViewById(R.id.shoeImage);
            cardView = (CardView) itemView.findViewById(R.id.card_view)
        }
    }
}
