package com.example.anabi.finalyearproject1try.SamsungTv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.example.anabi.finalyearproject1try.R;
import com.example.anabi.finalyearproject1try.SmartphoneBrandActivityWebview.SmartphoneBrandAppleWebview;

public class SamsungFullHdOrHdTvWebView extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.samsung.com/us/televisions-home-theater/tvs/all-tvs/s/full_hd_tvs-hd_tvs/_/n-10+11+hv1uh+zq204+zq205/";
    SmartphoneBrandAppleWebview fromApple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsung_full_hd_or_hd_tv_web_view);


        progressBar = (ProgressBar) findViewById(R.id.samsungFullHdOrHdTvProgressBarId);
        progressBar.setMax(100);
        webView = (WebView) findViewById(R.id.samsung_tv_fhd_hd_webviewId);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);



    }
}
