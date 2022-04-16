package com.example.anabi.finalyearproject1try.DesktopMonitorActivity;


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
public class DesktopMonitorAsusTab extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.asus.com/us/Monitors/Professional-Products/";
    SmartphoneBrandAppleWebview fromApple;




    public DesktopMonitorAsusTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_desktop_monitor_asus_tab, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.desktopMonitorAsusPb);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.desktopMonitorAsusWebview);
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
