package com.example.anabi.finalyearproject1try;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecurityTv extends AppCompatActivity {

    WebView mywebview;
    WebSettings x;
    String URL = "http://greatadibtutorial.blogspot.com/2019/07/laptop-original-vs-duplicate-guide.html";
    SwipeRefreshLayout swip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_tv);

        mywebview =(WebView) findViewById(R.id.securityTvWebViewId);
        swip = (SwipeRefreshLayout) findViewById(R.id.swip);


        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                LoadWeb(mywebview,x,URL); // after click refresh load

            }

        });

        LoadWeb(mywebview,x,URL); // outside call

    }




    public void LoadWeb(final WebView mywebview, WebSettings x, final String URL){


        mywebview.loadUrl(URL);

        x = mywebview.getSettings();

        x.setJavaScriptEnabled(true);
        x.setLoadWithOverviewMode(true);
        x.setUseWideViewPort(false);
        x.setSupportZoom(true);
        x.setBuiltInZoomControls(true);
        x.setCacheMode(WebSettings.LOAD_NO_CACHE);
        x.setDomStorageEnabled(true);
        x.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        x.setSaveFormData(true);
        x.setRenderPriority(WebSettings.RenderPriority.HIGH);

        mywebview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        mywebview.setScrollbarFadingEnabled(true);


        mywebview.setWebViewClient(new WebViewClient() {


                                       @Override
                                       public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {



                                           mywebview.loadUrl("file:///android_asset/error.html");
                                           mywebview.goBack();
                                          // Toast.makeText(SecurityTv.this, "No Internet", Toast.LENGTH_SHORT).show();


                                       }


                                       @Override
                                       public void onPageFinished(WebView view, String url) {

                                           swip.setRefreshing(false);

                                       }



                                   }

        );




    }









    //Swipe Function code()


    //public void swipRefresh(final SwipeRefreshLayout swip){



    //}
//




    @Override
    public void onBackPressed() {

        if(mywebview.canGoBack()){

            mywebview.goBack();

        } else {

            finish();

        }
    }
}
