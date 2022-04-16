package com.example.anabi.finalyearproject1try.FireBaseBackend.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.anabi.finalyearproject1try.DashboardActivity;
import com.example.anabi.finalyearproject1try.FireBaseBackend.fragment.DesktopFragment;
import com.example.anabi.finalyearproject1try.FireBaseBackend.fragment.LaptopPhoneFragment;
import com.example.anabi.finalyearproject1try.FireBaseBackend.fragment.PhoneFragment;
import com.example.anabi.finalyearproject1try.FireBaseBackend.fragment.TvFragment;
import com.example.anabi.finalyearproject1try.R;

public class DatabaseDashboardActivity extends AppCompatActivity {

    //new

    ImageButton backBtn;

    //new end

    private TextView mTextMessage;
    private FloatingActionButton fab;
    private static final String TAG = "DashBoardActivity";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_phone:
                    mTextMessage.setText(R.string.title_phone);
                    fragment = new PhoneFragment();
                    Log.d(TAG, "Phone fragment called");
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_laptop:
                    mTextMessage.setText(R.string.title_laptop);
                    fragment = new LaptopPhoneFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_desktop:
                    mTextMessage.setText(R.string.title_desktop);
                    fragment = new DesktopFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_television:
                    mTextMessage.setText(R.string.title_tv);
                    fragment = new TvFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.changeFrame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_dashboard);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // new


        backBtn = (ImageButton) findViewById(R.id.back_btn_from_post);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
            }
        });

        //new end


        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DatabaseDashboardActivity.this, PostActivity.class));

            }
        });

        BottomNavigationView navView = findViewById(R.id.main_bottom_nav);
        mTextMessage = findViewById(R.id.message);
        mTextMessage.setText(R.string.title_phone);
        Fragment fragment = new PhoneFragment();
        loadFragment(fragment);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
