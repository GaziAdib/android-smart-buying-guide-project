package com.example.anabi.finalyearproject1try.DesktopHddActivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anabi.finalyearproject1try.HDDSSDTechnology.HddInternalExternal;
import com.example.anabi.finalyearproject1try.HDDSSDTechnology.HddPurpose;
import com.example.anabi.finalyearproject1try.HDDSSDTechnology.HddSize;
import com.example.anabi.finalyearproject1try.HDDSSDTechnology.HddSpec;
import com.example.anabi.finalyearproject1try.HDDSSDTechnology.HddSsdCombination;
import com.example.anabi.finalyearproject1try.HDDSSDTechnology.SsdExplained;
import com.example.anabi.finalyearproject1try.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DesktopHddTechTab extends Fragment {

    CardView hddSpec,hddFormFactor,hddPurpose,hddIntExt,ssdHddCombination,ssdExplained;


    public DesktopHddTechTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_desktop_hdd_tech_tab, container, false);


        hddSpec = (CardView)v.findViewById(R.id.hddSpecId);
        hddFormFactor =(CardView)v.findViewById(R.id.hddFormFactorId);
        hddPurpose = (CardView)v.findViewById(R.id.hddPurposeId);
        hddIntExt = (CardView)v.findViewById(R.id.hddInternalExternalId);
        ssdHddCombination = (CardView)v.findViewById(R.id.ssdHddId);
        ssdExplained = (CardView)v.findViewById(R.id.ssdExplainedId);


        hddSpec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),HddSpec.class);
                startActivity(intent);

            }
        });



        hddFormFactor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),HddSize.class);
                startActivity(intent);

            }
        });




        hddPurpose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),HddPurpose.class);
                startActivity(intent);

            }
        });




        hddIntExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),HddInternalExternal.class);
                startActivity(intent);

            }
        });




        ssdHddCombination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),HddSsdCombination.class);
                startActivity(intent);

            }
        });





        ssdExplained.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),SsdExplained.class);
                startActivity(intent);

            }
        });







        // Inflate the layout for this fragment
        return v;
    }

    public interface OnFragmentInteractionListener {
    }

}
