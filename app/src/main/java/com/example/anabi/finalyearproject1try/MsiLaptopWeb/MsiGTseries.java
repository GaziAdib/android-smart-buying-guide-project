package com.example.anabi.finalyearproject1try.MsiLaptopWeb;


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
public class MsiGTseries extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.msi.com/Laptop/Products#?tag_multi_select=579";
    SmartphoneBrandAppleWebview fromApple;



    public MsiGTseries() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View v = inflater.inflate(R.layout.fragment_msi_gtseries, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.msiGTSeriesPb);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.msiGTWebId);
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
