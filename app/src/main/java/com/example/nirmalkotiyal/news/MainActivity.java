package com.example.nirmalkotiyal.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.nirmalkotiyal.news.Model.NewsList;
import com.example.nirmalkotiyal.news.NewsApi.Newsapi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    NewsList newsLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.news_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getdata();
    }

    private void getdata() {
        Call<NewsList> postListCall = Newsapi.getService().getPostList();
        postListCall.enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                NewsList list = response.body();
                newsLists=response.body();

                recyclerView.setAdapter(new Newsadaptor(MainActivity.this,((NewsList) list).getArticles()));

            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
