package com.example.anabi.finalyearproject1try.DesktopRamActivity;


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
public class DesktopRamCorsairTab extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.corsair.com/ww/en/Categories/Products/Memory/c/Cor_Products_Memory?q=%3Afeatured%3AmemoryType%3ADDR4&text=#rotatingText";
    SmartphoneBrandAppleWebview fromApple;



    public DesktopRamCorsairTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_desktop_ram_corsair_tab, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.desktopRamCorsairPb);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.desktopRamCorsairWebview);
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
