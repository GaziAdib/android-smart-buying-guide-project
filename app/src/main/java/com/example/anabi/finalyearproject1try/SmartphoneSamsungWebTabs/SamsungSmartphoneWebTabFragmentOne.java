package com.example.anabi.finalyearproject1try.SmartphoneSamsungWebTabs;


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
public class SamsungSmartphoneWebTabFragmentOne extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.samsung.com/global/galaxy/";
    SmartphoneBrandAppleWebview fromApple;


    public SamsungSmartphoneWebTabFragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_samsung_samrtphone_web_tab_fragment_one, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.samsungSmartphoneWebFragPbOneId);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.samsungSmartphoneFragWebViewOneId);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);


        // Inflate the layout for this fragment
        return v;
    }

    public interface OnFragmentInteractionListener {

    }

}
