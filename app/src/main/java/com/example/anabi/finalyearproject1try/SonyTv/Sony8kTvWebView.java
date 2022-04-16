package com.example.anabi.finalyearproject1try.SonyTv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.example.anabi.finalyearproject1try.R;
import com.example.anabi.finalyearproject1try.SmartphoneBrandActivityWebview.SmartphoneBrandAppleWebview;

public class Sony8kTvWebView extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.sony.com/electronics/tv/t/televisions?type=8k";
    SmartphoneBrandAppleWebview fromApple;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sony8k_tv_web_view);


        progressBar = (ProgressBar) findViewById(R.id.sony4kTvProgressBarId);
        progressBar.setMax(100);
        webView = (WebView) findViewById(R.id.sony_tv_8k_webviewId);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);

    }
}
