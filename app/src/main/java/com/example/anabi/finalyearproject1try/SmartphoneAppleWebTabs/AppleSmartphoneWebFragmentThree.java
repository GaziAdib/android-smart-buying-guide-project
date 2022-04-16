package com.example.anabi.finalyearproject1try.SmartphoneAppleWebTabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.example.anabi.finalyearproject1try.R;
import com.example.anabi.finalyearproject1try.SmartphoneBrandActivityWebview.SmartphoneBrandAppleWebview;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppleSmartphoneWebFragmentThree extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.pickaboo.com/mobile-phone/smartphone/iphone.html";
    SmartphoneBrandAppleWebview fromApple;



    public AppleSmartphoneWebFragmentThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_apple_smartphone_web_fragment_three, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.appleSmartphoneWebFragPbThreeId);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.appleSmartphoneFragWebViewThreeId);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);


        // Inflate the layout for this fragment
        return v;


    }

    public interface OnFragmentInteractionListener {

    }

}
