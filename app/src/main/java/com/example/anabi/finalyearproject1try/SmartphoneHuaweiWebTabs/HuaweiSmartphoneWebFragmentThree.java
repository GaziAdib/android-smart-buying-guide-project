package com.example.anabi.finalyearproject1try.SmartphoneHuaweiWebTabs;


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
public class HuaweiSmartphoneWebFragmentThree extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.pickaboo.com/mobile-phone/smartphone/huawei.html";
    SmartphoneBrandAppleWebview fromApple;


    public HuaweiSmartphoneWebFragmentThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_huawei_smartphone_web_fragment_three, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.huaweiSmartphoneWebFragPbThreeId);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.huaweiSmartphoneFragWebViewThreeId);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);


        // Inflate the layout for this fragment
        return v;




    }


    public interface OnFragmentInteractionListener {

    }

}
