package com.example.anabi.finalyearproject1try.BloggerApiPosts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BloggerMainActivity extends AppCompatActivity {


    Toolbar toolbar;
    RecyclerView recyclerView;
    LinearLayoutManager manager;
    PostAdapter adapter;
    List<Item> items = new ArrayList<>();
    Boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;
    String token = "";
    //ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogger_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView = (RecyclerView) findViewById(R.id.postList);
        manager = new LinearLayoutManager(this);
        adapter = new PostAdapter(this, items);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
       // progress = (ProgressBar) findViewById(R.id.progressBar);

        //setUpToolbar();


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = manager.getChildCount();
                totalItems = manager.getItemCount();
                scrollOutItems = manager.findFirstVisibleItemPosition();

                if(isScrolling && (currentItems + scrollOutItems == totalItems))
                {
                    isScrolling = false;
                    getData();
                }
            }
        });

        getData();
    }

//    private void setUpToolbar()
//
//    {
//
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//
//    }

    private void getData()
    {
        String url = BloggerAPI.url+ "?key=" + BloggerAPI.key;
        if(token != ""){
            url = url+ "&pageToken="+ token;
        }
        if(token == null){
            return;
        }
        //progress.setVisibility(View.VISIBLE);
        final Call<PostList> postList = BloggerAPI.getService().getPostList(url);
        postList.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                PostList list = response.body();
                token = list.getNextPageToken();
                items.addAll(list.getItems());
                adapter.notifyDataSetChanged();
                Toast.makeText(BloggerMainActivity.this, "Success", Toast.LENGTH_SHORT).show();
               /// progress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                Toast.makeText(BloggerMainActivity.this, "Error Occured", Toast.LENGTH_SHORT).show();
            }
        });

    }


}











//apikey:AIzaSyCnujpV7gFMRoCbE0jfmeG9cJ0bjxrTJcQ

//GET https://www.googleapis.com/blogger/v3/blogs/3213900?key=YOUR-API-KEY

// post id: 3816132198012555650

// blog id: 8834286761788906779

//https://www.googleapis.com/blogger/v3/blogs/8834286761788906779?key=AIzaSyAhYQwfoAcLDBmXMmiPOM34svn2K8LvrY4