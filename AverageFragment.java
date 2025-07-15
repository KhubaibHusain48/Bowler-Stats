package com.example.bowlerstats;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class AverageFragment extends Fragment {

    public AverageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_average, container, false);

        EditText avgRuns, avgWkts;
        Button calcAverage, ResetAll;


        avgRuns = v.findViewById(R.id.avgRunsConceded);
        avgWkts = v.findViewById(R.id.avgwktsTaken);
        calcAverage = v.findViewById(R.id.AverageButton);
        ResetAll = v.findViewById(R.id.resetButtonAvg);



        calcAverage.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View v) {
                int average_Runs = Integer.parseInt(avgRuns.getText().toString());
                int average_Wkts = Integer.parseInt(avgWkts.getText().toString());

                double average = (double) average_Runs / average_Wkts;

                Dialog d = new Dialog(requireContext());
                d.setContentView(R.layout.dialogbox);

                TextView avg_display = d.findViewById(R.id.Show);
                Button dialogButton=d.findViewById(R.id.dialog_button);
                avg_display.setText("Your Average is " + String.format("%.2f", average));
                d.show();

                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });
            }
        });


        ResetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avgRuns.setText("");
                avgWkts.setText("");

            }
        });


        return v;
    }
}