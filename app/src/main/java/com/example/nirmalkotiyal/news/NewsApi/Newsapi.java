package com.example.nirmalkotiyal.news.NewsApi;

import com.example.nirmalkotiyal.news.Model.NewsList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Newsapi {

    private static final String BASE_URL="https://gnews.io/api/v3/";
    private static final String token="a92dc942f0e8fa25c991208021baaf76";

    public static PostService postService=null;

    public static PostService getService(){
        if(postService==null){
            Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            postService = retrofit.create(PostService.class);
        }
        return postService;
    }

    public interface PostService{
        @GET("search?q=uttarakhand&token="+token)
        Call<NewsList> getPostList();

    }

}
