package es.iescarrillo.project.ifoody_jmi.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import es.iescarrillo.project.ifoody_jmi.R;

public class MyOrdersFragment extends Fragment {

    public MyOrdersFragment() {
        // Empty constructor for the fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_orders, container, false);

        // Get reference to the RadioGroup in the layout
        RadioGroup radioGroup = view.findViewById(R.id.rgOrders);

        // Set up a listener for changes in the checked state of radio buttons
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rbUpcoming = view.findViewById(R.id.rbUpcoming);
                RadioButton rbHistory = view.findViewById(R.id.rbHistory);

                // Change background and text color based on the checked radio button
                if (checkedId == R.id.rbUpcoming) {
                    rbUpcoming.setBackgroundResource(R.drawable.rounded_button_orange);
                    rbHistory.setBackgroundResource(R.drawable.rounded_button_white);
                    rbUpcoming.setTextColor(getResources().getColor(R.color.white));
                    rbHistory.setTextColor(getResources().getColor(R.color.primary_color));
                } else if (checkedId == R.id.rbHistory) {
                    rbUpcoming.setBackgroundResource(R.drawable.rounded_button_white);
                    rbHistory.setBackgroundResource(R.drawable.rounded_button_orange);
                    rbUpcoming.setTextColor(getResources().getColor(R.color.primary_color));
                    rbHistory.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        return view;
    }
}
