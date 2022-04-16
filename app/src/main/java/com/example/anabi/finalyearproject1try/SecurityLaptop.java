package com.example.anabi.finalyearproject1try;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.example.anabi.finalyearproject1try.SmartphoneBrandActivityWebview.SmartphoneBrandAppleWebview;

public class SecurityLaptop extends AppCompatActivity {


    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "http://greatadibtutorial.blogspot.com/2019/07/laptop-original-vs-duplicate-guide.html";
    SmartphoneBrandAppleWebview fromApple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_laptop);


        progressBar = (ProgressBar) findViewById(R.id.security_laptop_progressbarId);
        progressBar.setMax(100);
        webView = (WebView) findViewById(R.id.securityLaptopWebViewId);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);


    }
}
