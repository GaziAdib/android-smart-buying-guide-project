package com.example.anabi.finalyearproject1try.SmartphoneAppleWebTabs;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.anabi.finalyearproject1try.R;
import com.example.anabi.finalyearproject1try.SmartphoneBrandActivityWebview.SmartphoneBrandAppleWebview;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppleSmartphoneWebFragmentOne extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.apple.com/iphone/";
    SmartphoneBrandAppleWebview fromApple;
    SwipeRefreshLayout swip;




    public AppleSmartphoneWebFragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_apple_smartphone_web_fragment_one, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.appleSmartphoneWebFragPbOneId);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.appleSmartphoneFragWebViewOneId);
        swip = (SwipeRefreshLayout)v.findViewById(R.id.swipApplePhoneFragOne);


        fromApple = new SmartphoneBrandAppleWebview();


        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                fromApple.PerformanceZoom(webView,progressBar,URL); // after click refresh load

            }

        });



        fromApple.PerformanceZoom(webView,progressBar,URL); // outside call
        //fromApple.swipeRefresh(swip);
        //fromApple.WebClientMethod(webView);
        fromApple.BackFunction(webView);




        webView.setWebViewClient(new WebViewClient(){


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                progressBar.setVisibility(View.VISIBLE);
                webView.setVisibility(View.VISIBLE);


            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {



                webView.loadUrl("file:///android_asset/error.html");
                webView.goBack();


            }


            @Override
            public void onPageFinished(WebView view, String url) {

                swip.setRefreshing(false);
                progressBar.setVisibility(View.GONE);

            }
        });




        // Inflate the layout for this fragment
        return v;


    }


    //method




    public interface OnFragmentInteractionListener {

    }



}

