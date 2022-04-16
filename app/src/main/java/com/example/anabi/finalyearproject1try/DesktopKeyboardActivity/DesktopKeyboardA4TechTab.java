package com.example.anabi.finalyearproject1try.DesktopKeyboardActivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.anabi.finalyearproject1try.R;
import com.example.anabi.finalyearproject1try.SmartphoneBrandActivityWebview.SmartphoneBrandAppleWebview;

/**
 * A simple {@link Fragment} subclass.
 */
public class DesktopKeyboardA4TechTab extends Fragment {


    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "http://a4tech.com/products.aspx?id=2";
    SmartphoneBrandAppleWebview fromApple;





    public DesktopKeyboardA4TechTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_desktop_keyboard_a4_tech_tab, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.desktopKeyboardA4TechPb);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.desktopKeyboardA4TechWebview);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);

        WebView desktopKeyboardA4TechWebView = (WebView)v.findViewById(R.id.desktopKeyboardA4TechWebview);
        desktopKeyboardA4TechWebView.getSettings().setJavaScriptEnabled(true);
        desktopKeyboardA4TechWebView.setWebViewClient(new WebViewClient());
        desktopKeyboardA4TechWebView.loadUrl("http://a4tech.com/products.aspx?id=2");
        desktopKeyboardA4TechWebView.getSettings().setSupportZoom(true);
        desktopKeyboardA4TechWebView.getSettings().setBuiltInZoomControls(true);
        desktopKeyboardA4TechWebView.getSettings().setDisplayZoomControls(true);

        desktopKeyboardA4TechWebView.setOnKeyListener(new View.OnKeyListener()
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

        // Inflate the layout for this fragment
        return v;

        // Inflate the layout for this fragment





    }

    public interface OnFragmentInteractionListener {
    }

}
