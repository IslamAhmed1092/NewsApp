package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private ArrayList<News> news;
    private Context context;

    public NewsAdapter(ArrayList<News> news, Context context) {
        this.news = news;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.bind(position);
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView newsImage;
        TextView title, authorName, section, date;

        NewsViewHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.title) ;
            newsImage = (ImageView)itemView.findViewById(R.id.news_image);
            authorName = (TextView) itemView.findViewById(R.id.author_name);
            section = (TextView) itemView.findViewById(R.id.section);
            date = (TextView) itemView.findViewById(R.id.date);

            itemView.setOnClickListener(this);
        }
        void bind(int position) {
            News newsObject = news.get(position);
            title.setText(newsObject.getTitle());

            newsImage.setImageBitmap(newsObject.getImage());

            if(!TextUtils.isEmpty(newsObject.getAuthorName())) authorName.setText(newsObject.getAuthorName());
            date.setText(newsObject.getDate());
            section.setText(newsObject.getSection());

        }

        @Override
        public void onClick(View v) {

            // Convert the String URL into a URI object (to pass into the Intent constructor)
            Uri newsUri = Uri.parse(news.get(getAdapterPosition()).getUrl());

            // Create a new intent to view the news URI
            Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);

            // Send the intent to launch a new activity
            context.startActivity(websiteIntent);
        }
    }

    public void addAll(ArrayList<News> news){
        if (this.news != null)
            this.news.addAll(news);

    }
    public void clear() {
        if (news != null)
            news.clear();
    }
}
