package com.example.anabi.finalyearproject1try.DesktopMouseActivity;


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
public class DesktopMouseRazorTab extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.razer.com/gaming-mice-and-mats";
    SmartphoneBrandAppleWebview fromApple;




    public DesktopMouseRazorTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.fragment_desktop_mouse_razor_tab, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.desktopMouseRazerPb);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.desktopMouseRazorWebview);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);




        // Inflate the layout for this fragment
        return v;
    }

    public interface OnFragmentInteractionListener {
    }

}
