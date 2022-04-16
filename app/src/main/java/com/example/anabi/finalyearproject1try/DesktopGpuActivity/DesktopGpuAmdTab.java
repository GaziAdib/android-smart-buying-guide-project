package com.example.anabi.finalyearproject1try.DesktopGpuActivity;


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
public class DesktopGpuAmdTab extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.amd.com/en/RX-series";
    SmartphoneBrandAppleWebview fromApple;





    public DesktopGpuAmdTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_desktop_gpu_amd_tab, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.desktopGpuAmdPb);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.desktopGpuAmdWebview);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);





        // Inflate the layout for this fragment
        return v;
    }

    public interface OnFragmentInteractionListener {
    }

}
