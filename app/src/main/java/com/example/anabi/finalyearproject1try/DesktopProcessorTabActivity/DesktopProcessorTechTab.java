package com.example.anabi.finalyearproject1try.DesktopProcessorTabActivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anabi.finalyearproject1try.ProcessorTechnology.DesktopProcessorHyperThreading;
import com.example.anabi.finalyearproject1try.ProcessorTechnology.DesktopProcessorIntegratedGraphics;
import com.example.anabi.finalyearproject1try.ProcessorTechnology.DesktopProcessorOverClock;
import com.example.anabi.finalyearproject1try.ProcessorTechnology.DesktopProcessorPurpose;
import com.example.anabi.finalyearproject1try.ProcessorTechnology.DesktopProcessorSmartCache;
import com.example.anabi.finalyearproject1try.ProcessorTechnology.DesktopProcessorSpecs;
import com.example.anabi.finalyearproject1try.ProcessorTechnology.DesktopProcessorTurboBoost;
import com.example.anabi.finalyearproject1try.ProcessorTechnology.DesktopProcessorVirtualization;
import com.example.anabi.finalyearproject1try.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DesktopProcessorTechTab extends Fragment {

    CardView specs,turboboost,hyperThreading,smartCache,integratedGraphics,overClock,virtualization,purpose;


    public DesktopProcessorTechTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_desktop_processor_tech_tab,container,false);

        specs = (CardView)v.findViewById(R.id.specs);
        turboboost = (CardView)v.findViewById(R.id.turboBoost);
        hyperThreading = (CardView)v.findViewById(R.id.hyperThread);
        smartCache = (CardView)v.findViewById(R.id.cache);
        integratedGraphics = (CardView)v.findViewById(R.id.integratedGpu);
        overClock = (CardView)v.findViewById(R.id.overclock);
        virtualization = (CardView)v.findViewById(R.id.virtualization);
        purpose = (CardView)v.findViewById(R.id.purpose);


        specs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), DesktopProcessorSpecs.class);
                startActivity(intent);

            }
        });



        turboboost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), DesktopProcessorTurboBoost.class);
                startActivity(intent);

            }
        });


        hyperThreading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), DesktopProcessorHyperThreading.class);
                startActivity(intent);

            }
        });


        smartCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), DesktopProcessorSmartCache.class);
                startActivity(intent);

            }
        });


        integratedGraphics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), DesktopProcessorIntegratedGraphics.class);
                startActivity(intent);

            }
        });


        overClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), DesktopProcessorOverClock.class);
                startActivity(intent);

            }
        });


        virtualization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), DesktopProcessorVirtualization.class);
                startActivity(intent);

            }
        });


        purpose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), DesktopProcessorPurpose.class);
                startActivity(intent);

            }
        });



        return v;
    }

    public interface OnFragmentInteractionListener {
    }

}
