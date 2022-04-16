package com.example.anabi.finalyearproject1try.SmartphoneBrandActivityWebview;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.anabi.finalyearproject1try.R;

public class SmartphoneBrandAppleWebview extends AppCompatActivity {

    WebView appleBrandWebview;
    ProgressBar appleProgressBar;
    WebSettings webSettings;
    String URL = "https://www.apple.com/iphone/";
    SwipeRefreshLayout swip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphone_brand_apple_webview);

        appleProgressBar = (ProgressBar) findViewById(R.id.appleBrandPbId);
        appleProgressBar.setMax(100);
        appleBrandWebview = (WebView) findViewById(R.id.appleBrandWebId);
        swip = (SwipeRefreshLayout) findViewById(R.id.swipAppleBrandWebId);


       swipeRefresh(swip);
       PerformanceZoom(appleBrandWebview,appleProgressBar,URL);
       BackFunction(appleBrandWebview);


    }

    // all method are below back,  performance and zoom feature


    public void PerformanceZoom(final WebView webView, final ProgressBar progressBar, String URL){


        webView.loadUrl(URL);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
            }
        });



        //increase Performance
        webSettings = webView.getSettings();
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.getSettings().setAppCacheEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setSaveFormData(true);
        webSettings.setUseWideViewPort(false);



        //webView.loadUrl(URL);

        //webSettings.setEnableSmoothTransition(true);
        //webSettings.setSavePassword(true);

        //increase performance

        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(true);


       // WebClientMethod(webView);






        /*
        webView.setWebViewClient(new WebViewClient(){


            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                webView.loadUrl("file:///android_asset/error.html");
                webView.goBack();


            }


            @Override
            public void onPageFinished(WebView view, String url) {


                if (swip != null) {
                    swip.setRefreshing(false);
                }


            }

        });



        */





        //new


        //x.setLoadWithOverviewMode(true);
        //x.setUseWideViewPort(false);
        //x.setSupportZoom(true);
       // x.setBuiltInZoomControls(true);
       // x.setCacheMode(WebSettings.LOAD_NO_CACHE);
       // x.setDomStorageEnabled(true);
       // x.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
       // x.setSaveFormData(true);
       // x.setRenderPriority(WebSettings.RenderPriority.HIGH);

       // mywebview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
       // mywebview.setScrollbarFadingEnabled(true);




    }



    //webclient

    /*
    public void WebClientMethod(final WebView webView){

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //appleProgressBar.setVisibility(View.VISIBLE);
                webView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {

                webView.loadUrl("file:///android_asset/error.html");
                webView.goBack();
            }


            @Override
            public void onPageFinished(WebView view, String url) {

                swip.setRefreshing(false);

            }
        });

    }
    */











    public void swipeRefresh(SwipeRefreshLayout swip){

        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                PerformanceZoom(appleBrandWebview,appleProgressBar,URL);

            }

        });


    }



    public void BackFunction(WebView webView) {
        webView.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    WebView webView = (WebView) v;

                    switch(keyCode)
                    {
                        case KeyEvent.KEYCODE_BACK:
                            if(webView.canGoBack())
                            {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }

                return false;
            }
        });


    }










}

















/*


        WebView appleBrandWebview;
        ProgressBar appleProgressBar;
        WebSettings webSettings;
        String URL = "https://www.apple.com/iphone/";

//
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphone_brand_apple_webview);

        appleProgressBar = (ProgressBar) findViewById(R.id.appleSmartphoneProgressBarId);
        appleProgressBar.setMax(100);
        appleBrandWebview = (WebView) findViewById(R.id.appleBrandWebview);

        PerformanceZoom(appleBrandWebview,appleProgressBar,URL);
        BackFunction(appleBrandWebview);


        }

// all method are below back,  performance and zoom feature


public void PerformanceZoom(final WebView webView, final ProgressBar progressBar,String URL){


        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){


@Override
public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        progressBar.setVisibility(View.VISIBLE);
        webView.setVisibility(View.INVISIBLE);

        }


@Override
public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        progressBar.setVisibility(View.GONE);
        webView.setVisibility(View.VISIBLE);
        }
        });
        webView.setWebChromeClient(new WebChromeClient(){

@Override
public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        progressBar.setProgress(newProgress);
        }
        });



        //increase Performance
        webSettings = webView.getSettings();
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.getSettings().setAppCacheEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);
        webView.loadUrl(URL);


        //increase performance

        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);


        }


public void BackFunction(WebView webView) {
        webView.setOnKeyListener(new View.OnKeyListener()
        {
@Override
public boolean onKey(View v, int keyCode, KeyEvent event)
        {
        if(event.getAction() == KeyEvent.ACTION_DOWN)
        {
        WebView webView = (WebView) v;

        switch(keyCode)
        {
        case KeyEvent.KEYCODE_BACK:
        if(webView.canGoBack())
        {
        webView.goBack();
        return true;
        }
        break;
        }
        }

        return false;
        }
        });


        }


*/
