package com.example.anabi.finalyearproject1try.DesktopMonitorActivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anabi.finalyearproject1try.MonitorTechnology.MonitorFeaturePorts;
import com.example.anabi.finalyearproject1try.MonitorTechnology.MonitorGsyncFsync;
import com.example.anabi.finalyearproject1try.MonitorTechnology.MonitorPanelType;
import com.example.anabi.finalyearproject1try.MonitorTechnology.MonitorRefreshRate;
import com.example.anabi.finalyearproject1try.MonitorTechnology.MonitorResolution;
import com.example.anabi.finalyearproject1try.MonitorTechnology.MonitorResponseTime;
import com.example.anabi.finalyearproject1try.MonitorTechnology.MonitorScreenSize;
import com.example.anabi.finalyearproject1try.MonitorTechnology.MonitorViewingAngle;
import com.example.anabi.finalyearproject1try.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DesktopMonitorTechTab extends Fragment {

    private CardView resolution,panelType,screenSize,viewingAngle,responseTime,refreshrate,gsyncFsync,featurePorts;

    public DesktopMonitorTechTab() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_desktop_monitor_tech_tab, container, false);

        resolution    =(CardView)v.findViewById(R.id.resolution);
        panelType     =(CardView)v.findViewById(R.id.panelType);
        screenSize    =(CardView)v.findViewById(R.id.screenSize);
        viewingAngle  =(CardView)v.findViewById(R.id.viewingAngle);
        responseTime  =(CardView)v.findViewById(R.id.responseTime);
        refreshrate   =(CardView)v.findViewById(R.id.refreshRate);
        gsyncFsync    =(CardView)v.findViewById(R.id.gsyncFsync);
        featurePorts  =(CardView)v.findViewById(R.id.featuresPorts);

        resolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MonitorResolution.class);
                startActivity(intent);
            }
        });



        panelType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MonitorPanelType.class);
                startActivity(intent);
            }
        });

        screenSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MonitorScreenSize.class);
                startActivity(intent);
            }
        });

        viewingAngle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MonitorViewingAngle.class);
                startActivity(intent);
            }
        });

        responseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MonitorResponseTime.class);
                startActivity(intent);
            }
        });

        refreshrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MonitorRefreshRate.class);
                startActivity(intent);
            }
        });

        gsyncFsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MonitorGsyncFsync.class);
                startActivity(intent);
            }
        });

        featurePorts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MonitorFeaturePorts.class);
                startActivity(intent);
            }
        });




        return v;
    }

    public interface OnFragmentInteractionListener {
    }

}
