package com.example.anabi.finalyearproject1try.RazerLaptopWeb;


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
public class RazerStealthSeries extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.razer.com/gaming-laptops/razer-blade-stealth";
    SmartphoneBrandAppleWebview fromApple;



    public RazerStealthSeries() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_razer_stealth_series, container, false);


        progressBar = (ProgressBar) v.findViewById(R.id.razerStealthSeriesPb);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.razerStealthWebId);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);


        // Inflate the layout for this fragment
        return v;

        // Inflate the layout for this fragment

    }



    public interface OnFragmentInteractionListener {
    }

}
