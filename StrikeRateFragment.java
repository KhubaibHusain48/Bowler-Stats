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

public class StrikeRateFragment extends Fragment {


    public StrikeRateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_strike_rate, container, false);

        EditText SR_Overs, SR_wkts;
        Button SR_Calculate, ResetSRValues;

        SR_Overs = v.findViewById(R.id.SR_OversBowled);
        SR_wkts = v.findViewById(R.id.SRwktsTaken);
        SR_Calculate = v.findViewById(R.id.StrikeRateButton);
        ResetSRValues = v.findViewById(R.id.resetButtonSR);

        SR_Calculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                int overs = Integer.parseInt(SR_Overs.getText().toString());
                int wkts = Integer.parseInt(SR_wkts.getText().toString());

                int balls = overs * 6;

                double StrikeRate = (double) balls / wkts;

                Dialog d = new Dialog(requireContext());
                d.setContentView(R.layout.dialogbox);
                TextView sr_text = d.findViewById(R.id.Show);
                Button dialog_Button = d.findViewById(R.id.dialog_button);
                sr_text.setText("Your Strike Rate is " + String.format("%.2f", StrikeRate));
                d.show();

                dialog_Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });
            }
        });
        ResetSRValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SR_Overs.setText("");
                SR_wkts.setText("");
            }
        });
        return v;
    }
}