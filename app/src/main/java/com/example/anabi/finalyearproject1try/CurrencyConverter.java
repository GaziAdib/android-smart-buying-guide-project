package com.example.anabi.finalyearproject1try;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.example.anabi.finalyearproject1try.SmartphoneBrandActivityWebview.SmartphoneBrandAppleWebview;

public class CurrencyConverter extends AppCompatActivity {


    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.xe.com/";
    SmartphoneBrandAppleWebview fromApple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        progressBar = (ProgressBar) findViewById(R.id.currency_convert_progressbarId);
        progressBar.setMax(100);
        webView = (WebView) findViewById(R.id.currencyConverterWebId);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);



    }
}
