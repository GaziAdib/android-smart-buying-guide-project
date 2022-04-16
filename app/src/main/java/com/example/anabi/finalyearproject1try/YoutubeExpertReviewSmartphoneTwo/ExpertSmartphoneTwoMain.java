package com.example.anabi.finalyearproject1try.YoutubeExpertReviewSmartphoneTwo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

//import com.example.anabi.finalyearproject1try.OtherChannelYoutube.fragment.ChannelFragment;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewSmartphoneTwo.fragment.ChannelFragment;
import com.example.anabi.finalyearproject1try.R;

public class ExpertSmartphoneTwoMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_smartphone_two_main);

        ChannelFragment myf = new ChannelFragment();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrame,myf);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
