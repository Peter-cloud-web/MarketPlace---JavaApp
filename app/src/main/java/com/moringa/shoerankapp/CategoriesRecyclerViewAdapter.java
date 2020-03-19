package com.moringa.shoerankapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesRecyclerViewAdapter extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.CategoryItemsViewHolder> {
    private List<Category> mCategories;
    private Context mContext;

    public CategoriesRecyclerViewAdapter(Context context, List<Category> categories) {
        mContext = context;
        mCategories = categories;
    }

    @Override
    public CategoriesRecyclerViewAdapter.CategoryItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories, parent, false);
        CategoryItemsViewHolder viewHolder = new CategoryItemsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategoriesRecyclerViewAdapter.CategoryItemsViewHolder holder, int position)
        holder.bindProducts(mCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public class CategoryItemsViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.categoriesImage)
        ImageView mCategoriesImageView;
        @BindView(R.id.categoriesTitle)
        TextView mCategoriesTitle;
        @BindView(R.id.categoriesSecondTitle) TextView mCategoriesSecondTitle;

        private Context mContext;

        public CategoryItemsViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindProducts(Category category){
            mCategoriesTitle.setText(category.getName());
            mCategoriesSecondTitle.setText(category.getId());
            Picasso.get().load(category.getUrl()).into(mCategoriesImageView);
        }
    }
}


