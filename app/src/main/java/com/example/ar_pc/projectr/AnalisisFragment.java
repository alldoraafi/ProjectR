package com.example.ar_pc.projectr;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by AR-PC on 11/29/2017.
 */

public class AnalisisFragment extends Fragment {
    private View view;
    private TextView text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.view = (View) inflater.inflate(R.layout.frag_analisis, container, false);
        this.text = (TextView) this.view.findViewById(R.id.wow);
        return this.view;
    }

    public void setBerat(int tinggi, int berat){
        double bbi = (tinggi-100)*0.9;
        String g = text.getText().toString();
    }
}
