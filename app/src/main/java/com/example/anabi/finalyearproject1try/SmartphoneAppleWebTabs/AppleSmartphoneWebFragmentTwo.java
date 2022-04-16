package com.example.anabi.finalyearproject1try.SmartphoneAppleWebTabs;


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
public class AppleSmartphoneWebFragmentTwo extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.amazon.com/stores/page/274063E7-B678-4682-875C-34DE3425FB22?ingress=0&visitId=d12702e8-b436-4e3c-abf6-6b0d232bc741";

    SmartphoneBrandAppleWebview fromApple;


    public AppleSmartphoneWebFragmentTwo() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_apple_smartphone_web_fragment_two, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.appleSmartphoneWebFragPbTwoId);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.appleSmartphoneFragWebViewTwoId);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);


        // Inflate the layout for this fragment
        return v;





    }





    public interface OnFragmentInteractionListener {

    }

}
