package com.example.anabi.finalyearproject1try.DesktopKeyboardActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anabi.finalyearproject1try.KeyboardTechnology.KeyboardCompatibility;
import com.example.anabi.finalyearproject1try.KeyboardTechnology.KeyboardDesign;
import com.example.anabi.finalyearproject1try.KeyboardTechnology.KeyboardExtraFunction;
import com.example.anabi.finalyearproject1try.KeyboardTechnology.KeyboardPurpose;
import com.example.anabi.finalyearproject1try.KeyboardTechnology.KeyboardSwitch;
import com.example.anabi.finalyearproject1try.KeyboardTechnology.KeyboardWireWireless;
import com.example.anabi.finalyearproject1try.KeyboardTechnology.KeyboardWorkType;
import com.example.anabi.finalyearproject1try.R;

import static android.content.Context.VIBRATOR_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class DesktopKeyboardTechTab extends Fragment {

    CardView keyboardPurpose,keyboardTypes,keyboardSwitch,keyboardCompatibility,keyboardDesign,keyboardWireWireless,keyboardExtraFunction;


    Vibrator vibrator;

    public DesktopKeyboardTechTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        View v = inflater.inflate(R.layout.fragment_desktop_keyboard_tech_tab, container, false);

        keyboardPurpose = (CardView)v.findViewById(R.id.keyboardPurposeId);
        keyboardTypes = (CardView)v.findViewById(R.id.keyboardTypesId);
        keyboardSwitch = (CardView)v.findViewById(R.id.keyboardSwitchId);
        keyboardCompatibility = (CardView)v.findViewById(R.id.keyboardCompatibilityId);
        keyboardDesign = (CardView)v.findViewById(R.id.keyboardDesignId);
        keyboardWireWireless = (CardView)v.findViewById(R.id.keyboardWireWirelessId);
        keyboardExtraFunction = (CardView)v.findViewById(R.id.keyboardExtraFeatureId);

        vibrator = (Vibrator) getActivity().getSystemService(VIBRATOR_SERVICE);






        keyboardPurpose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);

                Intent intent = new Intent(getContext(),KeyboardPurpose.class);
                startActivity(intent);

            }
        });


        keyboardTypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);

                Intent intent = new Intent(getContext(),KeyboardWorkType.class);
                startActivity(intent);

            }
        });


        keyboardSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);

                Intent intent = new Intent(getContext(),KeyboardSwitch.class);
                startActivity(intent);

            }
        });


        keyboardCompatibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);

                Intent intent = new Intent(getContext(),KeyboardCompatibility.class);
                startActivity(intent);

            }
        });


        keyboardDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);

                Intent intent = new Intent(getContext(),KeyboardDesign.class);
                startActivity(intent);

            }
        });


        keyboardWireWireless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);

                Intent intent = new Intent(getContext(),KeyboardWireWireless.class);
                startActivity(intent);

            }
        });


        keyboardExtraFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);

                Intent intent = new Intent(getContext(),KeyboardExtraFunction.class);
                startActivity(intent);

            }
        });



        // Inflate the layout for this fragment
        return v;
    }





    public interface OnFragmentInteractionListener {

    }



    //vibrator class





}
