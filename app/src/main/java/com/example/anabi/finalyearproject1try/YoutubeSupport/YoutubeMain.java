package com.example.anabi.finalyearproject1try.YoutubeSupport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;
import com.example.anabi.finalyearproject1try.YoutubeSupport.fragment.ChannelFragment;


public class YoutubeMain extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_main);

        ChannelFragment myf = new ChannelFragment();

        final android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrame,myf);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}