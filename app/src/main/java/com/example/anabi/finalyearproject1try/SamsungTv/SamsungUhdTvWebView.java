package com.example.anabi.finalyearproject1try.SamsungTv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.example.anabi.finalyearproject1try.R;
import com.example.anabi.finalyearproject1try.SmartphoneBrandActivityWebview.SmartphoneBrandAppleWebview;

public class SamsungUhdTvWebView extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.samsung.com/us/televisions-home-theater/tvs/all-tvs/s/uhd_tvs/_/n-10+11+hv1uh+zq203/";
    SmartphoneBrandAppleWebview fromApple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsung_uhd_tv_web_view);


        progressBar = (ProgressBar) findViewById(R.id.samsungUhdTvProgressBarId);
        progressBar.setMax(100);
        webView = (WebView) findViewById(R.id.samsung_tv_uhd4k_webviewId);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);



    }
}
