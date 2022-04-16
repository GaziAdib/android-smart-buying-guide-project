package com.example.anabi.finalyearproject1try.SmartphoneAsusWebTabs;


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

public class AsusSmartphoneWebFragmentTwo extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.amazon.com/slp/asus-mobile-phones/ysqq2u6sp9bg8rk";
    SmartphoneBrandAppleWebview fromApple;


    public AsusSmartphoneWebFragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_asus_smartphone_web_fragment_two, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.asusSmartphoneWebFragPbTwoId);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.asusSmartphoneFragWebViewTwoId);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);


        // Inflate the layout for this fragment
        return v;



    }


    public interface OnFragmentInteractionListener {

    }
}
