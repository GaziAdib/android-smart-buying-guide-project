package com.example.anabi.finalyearproject1try.BloggerApiPosts;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class BloggerAPI {
    //https://www.googleapis.com/blogger/v3/blogs/4535374877214989841?key=AIzaSyDTrMw3uW26DZFFnLTE7jyjlDWeaOUKiAs

    //AIzaSyDTrMw3uW26DZFFnLTE7jyjlDWeaOUKiAs
    //AIzaSyAhYQwfoAcLDBmXMmiPOM34svn2K8LvrY4
    // public static final String url = "https://www.googleapis.com/blogger/v3/blogs/8834286761788906779/posts/";

    public static final String key = "AIzaSyDTrMw3uW26DZFFnLTE7jyjlDWeaOUKiAs";
    public static final String url = "https://www.googleapis.com/blogger/v3/blogs/4535374877214989841/posts/";

    public static PostService postService = null;

    public static PostService getService()
    {
        if(postService == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postService = retrofit.create(PostService.class);
        }
        return postService;
    }

    public interface PostService {
        @GET
        Call<PostList> getPostList(@Url String url);
    }


}

//https://www.googleapis.com/blogger/v3/blogs/8834286761788906779?key=AIzaSyAhYQwfoAcLDBmXMmiPOM34svn2K8LvrY4