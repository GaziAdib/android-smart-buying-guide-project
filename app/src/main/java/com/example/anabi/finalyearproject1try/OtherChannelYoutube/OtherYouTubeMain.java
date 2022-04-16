package com.example.anabi.finalyearproject1try.OtherChannelYoutube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.anabi.finalyearproject1try.OtherChannelYoutube.fragment.ChannelFragment;
import com.example.anabi.finalyearproject1try.R;

public class OtherYouTubeMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_you_tube_main);

        ChannelFragment myf = new ChannelFragment();

        final android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrame,myf);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
