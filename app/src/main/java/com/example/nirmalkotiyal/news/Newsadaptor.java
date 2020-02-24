package com.example.nirmalkotiyal.news;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.nirmalkotiyal.news.Model.Article;

import java.util.List;

public class Newsadaptor extends RecyclerView.Adapter<Newsadaptor.Newsviewholder> {

    private Context context;
    private List<Article> items;


    public Newsadaptor(Context context, List<Article> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public Newsviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.newslist, viewGroup,false);
        return new Newsviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Newsviewholder postviewholder, int i) {
        final Article item =items.get(i);
        postviewholder.newsDesc.setText(item.getDescription());
        postviewholder.newsTitle.setText(item.getTitle());
        postviewholder.newsauthor.setText(item.getSource().getName());

        if(item.getImage()!=null) {
            Glide.with(context).load(item.getImage()).apply(RequestOptions.bitmapTransform(new RoundedCorners(50))).into(postviewholder.newsImage);
        }
        else{
            Glide.with(context).load(R.drawable.breakingnews).apply(RequestOptions.bitmapTransform(new RoundedCorners(50))).into(postviewholder.newsImage);
        }

        postviewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,NewsDetail.class);
                intent.putExtra("url", item.getUrl());
                context.startActivity(intent);
            }
        });

        }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Newsviewholder extends RecyclerView.ViewHolder {
        ImageView newsImage;
        TextView newsTitle;
        TextView newsDesc;
        TextView newsauthor;
        RecyclerView recyclerView;

        public Newsviewholder(@NonNull View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.news_image);
            newsDesc = itemView.findViewById(R.id.news_desc);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsauthor = itemView.findViewById(R.id.news_author);
        }
    }

}

