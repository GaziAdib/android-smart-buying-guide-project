package com.example.anabi.finalyearproject1try.DesktopGpuActivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anabi.finalyearproject1try.GraphicsCardTechnology.GraphicsCardBasics;
import com.example.anabi.finalyearproject1try.GraphicsCardTechnology.GraphicsCardGpuCategory;
import com.example.anabi.finalyearproject1try.GraphicsCardTechnology.GraphicsCardNvidiaOrAmdorIntel;
import com.example.anabi.finalyearproject1try.GraphicsCardTechnology.GraphicsCardSepcialFeatures;
import com.example.anabi.finalyearproject1try.GraphicsCardTechnology.GraphicsCardSpecs;
import com.example.anabi.finalyearproject1try.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DesktopGpuTechTab extends Fragment {

    CardView gpuBasic,amdOrnvidia,gpuCategory,gpuSpec,specialFeatures;


    public DesktopGpuTechTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_desktop_gpu_tech_tab, container, false);


        gpuBasic = (CardView)v.findViewById(R.id.gpuBasicId);
        gpuSpec = (CardView)v.findViewById(R.id.gpuSpecId);
        amdOrnvidia = (CardView)v.findViewById(R.id.amdOrnvidiaId);
        gpuCategory = (CardView)v.findViewById(R.id.gpuCategoryId);
        specialFeatures = (CardView)v.findViewById(R.id.gpuSpecialFeatureId);

        gpuBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),GraphicsCardBasics.class);
                startActivity(intent);

            }
        });

        gpuSpec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),GraphicsCardSpecs.class);
                startActivity(intent);

            }
        });

        amdOrnvidia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), GraphicsCardNvidiaOrAmdorIntel.class);
                startActivity(intent);

            }
        });

        gpuCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),GraphicsCardGpuCategory.class);
                startActivity(intent);

            }
        });

        specialFeatures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), GraphicsCardSepcialFeatures.class);
                startActivity(intent);

            }
        });








        // Inflate the layout for this fragment
        return v;
    }

    public interface OnFragmentInteractionListener {
    }

}
