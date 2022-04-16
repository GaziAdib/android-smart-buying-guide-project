package com.example.anabi.finalyearproject1try;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.anabi.finalyearproject1try.TvActivityMain.TvBrandCategory;
import com.example.anabi.finalyearproject1try.TvActivityMain.TvTechActivity;

public class TvActivity extends AppCompatActivity {

    private CardView tvBrandCategory,tvTech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);

        tvBrandCategory = (CardView)findViewById(R.id.tv_selectBrand_id);
        tvTech = (CardView)findViewById(R.id.tv_tech_id);

        tvBrandCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TvBrandCategory.class);
                startActivity(intent);
            }
        });

        tvTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TvTechActivity.class);
                startActivity(intent);
            }
        });

    }
}
