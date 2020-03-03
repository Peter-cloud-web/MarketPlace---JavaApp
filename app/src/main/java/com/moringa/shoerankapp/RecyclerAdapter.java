package com.moringa.shoerankapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<Shoe> shoeList;

    public RecyclerAdapter(Context mContext, List<Shoe> shoeList) {
        this.mContext = mContext;
        this.shoeList = shoeList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.shoes_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        holder.shoeName.setText.get(mShoe).getName();
//        holder.shoeImage.setImageResource(mShoe.get(position).getImage());
//        holder.cardView.setOnClickListener(new View.OnClickListener());
    }

    @Override
    public int getItemCount() {
        return shoeList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView shoeName;
        ImageView shoeImage;
        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);

            shoeName= (TextView) itemView.findViewById(R.id.shoeTitle);
            shoeImage = (ImageView) itemView.findViewById(R.id.shoeImage);
            cardView = (CardView) itemView.findViewById(R.id.recycler);
        }
    }
}
