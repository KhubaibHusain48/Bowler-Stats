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

public class EconomyFragment extends Fragment {


    public EconomyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_economy, container, false);

        EditText Runs, Overs;
        Button CalcEconomy, ResetEco;

        Runs = v.findViewById(R.id.ecoRuns);
        Overs = v.findViewById(R.id.eco_Overs);
        CalcEconomy = v.findViewById(R.id.EcoButton);
        ResetEco = v.findViewById(R.id.EcoReset);

        CalcEconomy.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                int EcoRuns = Integer.parseInt(Runs.getText().toString());
                int EcoOvers = Integer.parseInt(Overs.getText().toString());

                int finalRuns = EcoRuns * 6;
                int balls = EcoOvers * 6;

                double Economy = (double) finalRuns / balls;

                Dialog d = new Dialog(requireContext());
                d.setContentView(R.layout.dialogbox);
                TextView EcoShow = d.findViewById(R.id.Show);
                Button dialogButton=d.findViewById(R.id.dialog_button);
                EcoShow.setText("Your Economy is " + String.format("%.2f", Economy) + " RPO");
                d.show();

                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });

            }

        });
        ResetEco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runs.setText("");
                Overs.setText("");
            }
        });
        return v;
    }
}