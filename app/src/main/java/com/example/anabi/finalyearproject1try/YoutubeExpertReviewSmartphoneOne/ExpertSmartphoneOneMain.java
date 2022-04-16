package com.example.anabi.finalyearproject1try.YoutubeExpertReviewSmartphoneOne;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.YoutubeExpertReviewSmartphoneOne.fragment.ChannelFragment;
import com.example.anabi.finalyearproject1try.R;

public class ExpertSmartphoneOneMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_smartphone_one_main);

        ChannelFragment myf = new ChannelFragment();
        final android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrame,myf);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
