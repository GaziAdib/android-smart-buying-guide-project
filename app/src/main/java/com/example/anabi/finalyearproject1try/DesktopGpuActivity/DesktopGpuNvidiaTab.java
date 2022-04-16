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
public class DesktopGpuNvidiaTab extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.nvidia.com/en-us/geforce/20-series/";
    SmartphoneBrandAppleWebview fromApple;




    public DesktopGpuNvidiaTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.fragment_desktop_gpu_nvidia_tab, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.desktopGpuNvidiaPb);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.desktopGpuNvidiaWebview);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);




        // Inflate the layout for this fragment
        return v;
}

    public interface OnFragmentInteractionListener {
    }

}


   /* desktopGpuNvidiaWebView = (WebView) desktopGpuNvidiaWebView.findViewById(R.id.desktopGpuNvidiaWebview);
        desktopGpuNvidiaWebView.loadUrl("https://www.nvidia.com/en-us/geforce/20-series/");
        WebSettings webSettings = desktopGpuNvidiaWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        desktopGpuNvidiaWebView.setWebViewClient(new WebViewClient());
        desktopGpuNvidiaWebView.getSettings().setSupportZoom(true);
        desktopGpuNvidiaWebView.getSettings().setBuiltInZoomControls(true);
        desktopGpuNvidiaWebView.getSettings().setDisplayZoomControls(true);

        // on Back Pressed feature

        desktopGpuNvidiaWebView.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    WebView webView = (WebView) v;

                    switch(keyCode)
                    {
                        case KeyEvent.KEYCODE_BACK:
                            if(webView.canGoBack())
                            {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }

                return false;
            }
        });

*/

