package com.example.anabi.finalyearproject1try.SamsungTv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.example.anabi.finalyearproject1try.R;
import com.example.anabi.finalyearproject1try.SmartphoneBrandActivityWebview.SmartphoneBrandAppleWebview;

public class SamsungQled8kTvWebView extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.samsung.com/us/televisions-home-theater/tvs/all-tvs/s/qled_8k_tvs/_/n-10+11+hv1uh+zq2mj/";
    SmartphoneBrandAppleWebview fromApple;private WebView samsungQled8kWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsung_qled8k_tv_web_view);


        progressBar = (ProgressBar) findViewById(R.id.samsungQled8kTvProgressBarId);
        progressBar.setMax(100);
        webView = (WebView) findViewById(R.id.samsung_tv_qled8k_webviewId);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);


    }
}
