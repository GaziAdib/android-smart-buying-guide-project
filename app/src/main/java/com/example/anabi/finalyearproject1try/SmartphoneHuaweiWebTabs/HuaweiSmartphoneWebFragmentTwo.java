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
public class HuaweiSmartphoneWebFragmentTwo extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    String URL = "https://www.amazon.com/s?i=mobile&bbn=7072561011&rh=n%3A2335752011%2Cn%3A2335753011%2Cn%3A7072561011%2Cp_89%3AHUAWEI&dc&fst=as%3Aoff&qid=1563664761&rnid=2528832011&ref=sr_nr_p_89_5";
    SmartphoneBrandAppleWebview fromApple;


    public HuaweiSmartphoneWebFragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_huawei_smartphone_web_fragment_two, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.huaweiSmartphoneWebFragPbTwoId);
        progressBar.setMax(100);
        webView = (WebView) v.findViewById(R.id.huaweiSmartphoneFragWebViewTwoId);
        fromApple = new SmartphoneBrandAppleWebview();

        fromApple.PerformanceZoom(webView,progressBar,URL);
        fromApple.BackFunction(webView);


        // Inflate the layout for this fragment
        return v;



    }


    public interface OnFragmentInteractionListener {

    }

}
