package com.moringa.shoerankapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moringa.shoerankapp.Network.BestbuyApi;
import com.moringa.shoerankapp.Network.BestbuyClient;
import com.moringa.shoerankapp.Adapters.CategoriesRecyclerViewAdapter;
import com.moringa.shoerankapp.Models.BestbuyCategoriesResponse;
import com.moringa.shoerankapp.Models.Category;
import com.moringa.shoerankapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends AppCompatActivity {
    @BindView(R.id.welcomeMessage)
    TextView mWelcomeMessage;
    @BindView(R.id.categoryErrorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBarCategories)
    ProgressBar mProgressBar;

    @BindView(R.id.categoryList)
    RecyclerView mRecyclerView;
    private CategoriesRecyclerViewAdapter mAdapter;

    public List<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        mWelcomeMessage.setText("Welcome back " + userName);

        BestbuyApi client = BestbuyClient.getClient();

        Call<BestbuyCategoriesResponse> call = client.getCategories();

        call.enqueue(new Callback<BestbuyCategoriesResponse>() {
            @Override
            public void onResponse(Call<BestbuyCategoriesResponse> call, Response<BestbuyCategoriesResponse> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    categories = response.body().getCategories();
                    mAdapter = new CategoriesRecyclerViewAdapter (CategoriesActivity.this, categories);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CategoriesActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    showRestaurants();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<BestbuyCategoriesResponse> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }

        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showRestaurants() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

}