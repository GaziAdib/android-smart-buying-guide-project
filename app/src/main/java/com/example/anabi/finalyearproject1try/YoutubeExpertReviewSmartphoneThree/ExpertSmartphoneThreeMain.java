package com.example.anabi.finalyearproject1try.YoutubeExpertReviewSmartphoneThree;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewSmartphoneThree.fragment.ChannelFragment;

public class ExpertSmartphoneThreeMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_smartphone_three_main);

        ChannelFragment myf = new ChannelFragment();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrame,myf);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
