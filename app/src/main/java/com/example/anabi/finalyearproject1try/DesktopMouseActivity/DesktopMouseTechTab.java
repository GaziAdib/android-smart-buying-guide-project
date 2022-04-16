package com.example.anabi.finalyearproject1try.DesktopMouseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anabi.finalyearproject1try.MouseTechnology.DesktopMouseDPi;
import com.example.anabi.finalyearproject1try.MouseTechnology.DesktopMouseDesignBuild;
import com.example.anabi.finalyearproject1try.MouseTechnology.DesktopMouseDurability;
import com.example.anabi.finalyearproject1try.MouseTechnology.DesktopMouseGaming;
import com.example.anabi.finalyearproject1try.MouseTechnology.DesktopMouseTypes;
import com.example.anabi.finalyearproject1try.R;


public class DesktopMouseTechTab extends Fragment {

    CardView mouseTypes, gamingMouse, mouseDurability, mouseDpi, mouseDesign;


    public DesktopMouseTechTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_desktop_mouse_tech_tab, container, false);

        mouseTypes = (CardView)v.findViewById(R.id.desktopMouseTypesId);
        gamingMouse = (CardView)v.findViewById(R.id.desktopMouseGamingId);
        mouseDurability = (CardView)v.findViewById(R.id.desktopMouseDurabilityId);
        mouseDpi = (CardView)v.findViewById(R.id.desktopMouseDpiId);
        mouseDesign = (CardView)v.findViewById(R.id.desktopMouseDesignBuildId);


        mouseTypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getContext(), DesktopMouseTypes.class);
                startActivity(i);

            }
        });


        gamingMouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getContext(), DesktopMouseGaming.class);
                startActivity(i);

            }
        });


        mouseDurability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getContext(), DesktopMouseDurability.class);
                startActivity(i);

            }
        });


        mouseDpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getContext(), DesktopMouseDPi.class);
                startActivity(i);

            }
        });


        mouseDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getContext(), DesktopMouseDesignBuild.class);
                startActivity(i);

            }
        });


        return v;

    }


    public interface OnFragmentInteractionListener {

    }


}
