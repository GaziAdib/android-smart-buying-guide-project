package com.example.anabi.finalyearproject1try.DesktopMoboTabActivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anabi.finalyearproject1try.MotherboardTechnology.MotherBoardChipset;
import com.example.anabi.finalyearproject1try.MotherboardTechnology.MotherboardBasic;
import com.example.anabi.finalyearproject1try.MotherboardTechnology.MotherboardBudget;
import com.example.anabi.finalyearproject1try.MotherboardTechnology.MotherboardExtraFeature;
import com.example.anabi.finalyearproject1try.MotherboardTechnology.MotherboardFormFactor;
import com.example.anabi.finalyearproject1try.MotherboardTechnology.MotherboardMultiGpu;
import com.example.anabi.finalyearproject1try.MotherboardTechnology.MotherboardOverclock;
import com.example.anabi.finalyearproject1try.MotherboardTechnology.MotherboardPlatform;
import com.example.anabi.finalyearproject1try.MotherboardTechnology.MotherboardPorts;
import com.example.anabi.finalyearproject1try.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DesktopMoboTechTab extends Fragment {

    CardView basic,platform,formFactor,chipset,overClock,feature,port,multiGpu,budget;


    public DesktopMoboTechTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_desktop_mobo_tech_tab,container,false);

        basic = (CardView)v.findViewById(R.id.basicCard);
        platform = (CardView)v.findViewById(R.id.platFormCard);
        formFactor = (CardView)v.findViewById(R.id.formFactorCard);
        chipset = (CardView)v.findViewById(R.id.chipsetCard);
        overClock = (CardView)v.findViewById(R.id.overClockCard);
        feature = (CardView)v.findViewById(R.id.featureCard);
        port = (CardView)v.findViewById(R.id.portCard);
        multiGpu = (CardView)v.findViewById(R.id.multiGpuCard);
        budget = (CardView)v.findViewById(R.id.budgetCard);


        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),MotherboardBasic.class);
                startActivity(intent);
            }
        });


        platform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),MotherboardPlatform.class);
                startActivity(intent);
            }
        });

        formFactor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),MotherboardFormFactor.class);
                startActivity(intent);
            }
        });

        chipset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),MotherBoardChipset.class);
                startActivity(intent);
            }
        });

        overClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),MotherboardOverclock.class);
                startActivity(intent);
            }
        });

        feature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),MotherboardExtraFeature.class);
                startActivity(intent);
            }
        });

        port.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),MotherboardPorts.class);
                startActivity(intent);
            }
        });


        multiGpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),MotherboardMultiGpu.class);
                startActivity(intent);
            }
        });


        budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),MotherboardBudget.class);
                startActivity(intent);
            }
        });


        return v;
    }

    public interface OnFragmentInteractionListener {
    }

}
