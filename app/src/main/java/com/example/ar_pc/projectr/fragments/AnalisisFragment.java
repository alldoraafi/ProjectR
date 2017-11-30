package com.example.ar_pc.projectr.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ar_pc.projectr.R;

/**
 * Created by AR-PC on 11/29/2017.
 */

public class AnalisisFragment extends Fragment {
    private View view;
    private TextView tvBBI, tvIMT, tvIMT2, tvKkal;
    private double bbi, imt, kkal;
    private String IMT;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.view = (View) inflater.inflate(R.layout.fragment_analisis, container, false);
        this.tvBBI = (TextView) this.view.findViewById(R.id.tvBerat);
        this.tvIMT = this.view.findViewById(R.id.tvIMT);
        this.tvIMT2 = this.view.findViewById(R.id.tvIMT2);
        this.tvKkal = this.view.findViewById(R.id.tvKkal);
        return this.view;
    }

    @Override
    public void onStart() {
        super.onStart();
        this.tvBBI.setText(bbi + " kg");
        this.tvIMT.setText(imt + "");
        this.tvIMT2.setText(IMT);
        this.tvKkal.setText(kkal+" kkal");
    }

    public void setBerat(int tinggi, int berat, int jk, int usia) {

        //Rumus BBI
        switch (jk) {
            case 1:
                if (tinggi < 160) this.bbi = tinggi - 100;
                else this.bbi = (tinggi - 100) * 0.9;
                kkal = 30 * this.bbi;
                break;
            case 2:
                if (tinggi < 150) this.bbi = tinggi - 100;
                else this.bbi = (tinggi - 100) * 0.9;
                kkal = 25 * this.bbi;
                break;
        }

        //Rumus Indeks Masa Tubuh
        this.imt = berat / ((tinggi / 100) ^ 2);
        if (imt < 18.5) IMT = "Underweight";
        else if (imt < 22.9) IMT = "Normal";
        else if (imt < 24.9) IMT = "Overweight";
        else if (imt < 29.9) IMT = "Obesitas 1";
        else IMT = "Obesitas 2";

        //Rumus kkal
        if (usia>70) kkal = kkal*0.8;
        else if(usia>60) kkal = kkal*0.9;
        else if(usia>40) kkal = kkal*0.95;
    }
}
