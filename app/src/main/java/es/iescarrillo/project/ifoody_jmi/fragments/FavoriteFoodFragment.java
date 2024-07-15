package es.iescarrillo.project.ifoody_jmi.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import es.iescarrillo.project.ifoody_jmi.R;


public class FavoriteFoodFragment extends Fragment {

    public FavoriteFoodFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite_food, container, false);

        // Initialize the RadioGroup and set its check change listener
        RadioGroup radioGroup = view.findViewById(R.id.rgOrders);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rbUpcoming = view.findViewById(R.id.rbUpcoming);
                RadioButton rbHistory = view.findViewById(R.id.rbHistory);

                // Update UI based on the checked RadioButton
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