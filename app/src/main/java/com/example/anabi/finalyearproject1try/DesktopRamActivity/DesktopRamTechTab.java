package com.example.anabi.finalyearproject1try.DesktopRamActivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anabi.finalyearproject1try.R;
import com.example.anabi.finalyearproject1try.RamTechnology.RamBasics;
import com.example.anabi.finalyearproject1try.RamTechnology.RamDDRVersions;
import com.example.anabi.finalyearproject1try.RamTechnology.RamFormFactor;
import com.example.anabi.finalyearproject1try.RamTechnology.RamLatency;
import com.example.anabi.finalyearproject1try.RamTechnology.RamPurpose;
import com.example.anabi.finalyearproject1try.RamTechnology.RamSpecs;

/**
 * A simple {@link Fragment} subclass.
 */
public class DesktopRamTechTab extends Fragment {

    CardView ramBasic,ramFormFactor,ramDDR,ramSpec,ramLatency,ramPurpose,ramDIMM;


    public DesktopRamTechTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_desktop_ram_tech_tab, container, false);


        ramBasic = (CardView)v.findViewById(R.id.ramBasicId);
        ramSpec = (CardView)v.findViewById(R.id.ramSpecId);
        ramDDR = (CardView)v.findViewById(R.id.ramDdrId);
        ramFormFactor = (CardView)v.findViewById(R.id.ramFormFactorId);
        ramLatency = (CardView)v.findViewById(R.id.ramLatencyId);
        ramPurpose = (CardView)v.findViewById(R.id.ramPurposeId);



        ramBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(getContext(),RamBasics.class);
                startActivity(intent);
            }
        });


        ramSpec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getContext(),RamSpecs.class);
                startActivity(intent);
            }
        });


        ramDDR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getContext(), RamDDRVersions.class);
                startActivity(intent);
            }
        });


        ramFormFactor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getContext(),RamFormFactor.class);
                startActivity(intent);
            }
        });


        ramLatency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getContext(),RamLatency.class);
                startActivity(intent);
            }
        });


        ramPurpose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getContext(),RamPurpose.class);
                startActivity(intent);
            }
        });







        // Inflate the layout for this fragment
        return v;
    }

    public interface OnFragmentInteractionListener {
    }

}
