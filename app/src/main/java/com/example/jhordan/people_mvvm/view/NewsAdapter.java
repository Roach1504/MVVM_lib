package com.example.jhordan.people_mvvm.view;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder> {

    @Override
    public NewsAdapter.NewsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(NewsAdapter.NewsAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class NewsAdapterViewHolder extends RecyclerView.ViewHolder {
        public NewsAdapterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
