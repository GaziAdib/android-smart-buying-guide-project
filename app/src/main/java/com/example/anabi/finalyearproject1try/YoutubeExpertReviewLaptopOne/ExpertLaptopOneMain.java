package com.example.anabi.finalyearproject1try.YoutubeExpertReviewLaptopOne;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

import com.example.anabi.finalyearproject1try.YoutubeExpertReviewLaptopOne.fragment.ChannelFragment;

public class ExpertLaptopOneMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_laptop_one_main);

        ChannelFragment myf = new ChannelFragment();
        final android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrame,myf);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
