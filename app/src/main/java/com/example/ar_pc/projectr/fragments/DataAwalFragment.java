package com.example.ar_pc.projectr.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.ar_pc.projectr.IDataAwal;
import com.example.ar_pc.projectr.R;

/**
 * Created by AR-PC on 11/29/2017.
 */

public class DataAwalFragment extends Fragment {
    private View view;
    private EditText etUsia, etBerat, etTinggi;
    private RadioGroup rgJK;
    private Button btAnalisa;
    private IDataAwal parent;
    private int jk;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_data_awal, container, false);
        etUsia = view.findViewById(R.id.etUsia);
        etBerat = view.findViewById(R.id.etBerat);
        etTinggi = view.findViewById(R.id.etTinggi);
        rgJK = view.findViewById(R.id.rgJK);
        rgJK.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (rgJK.getCheckedRadioButtonId()){
                    case R.id.rbMale:jk = 1;break;
                    case R.id.rbFemale:jk = 2;break;
                }
            }
        });


        btAnalisa = view.findViewById(R.id.btAnalisa);
        btAnalisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tinggi = etTinggi.getText().toString();
                String berat = etBerat.getText().toString();
                parent.gantiFragment();
                if (!TextUtils.isEmpty(tinggi) && !TextUtils.isEmpty(berat)){
                    parent.kirimData(
                            Integer.valueOf(etTinggi.getText().toString()),
                            Integer.valueOf(etBerat.getText().toString()),
                            jk,
                            Integer.valueOf(etUsia.getText().toString()));
                }
            }
        });
        return view;
    }

    public void setParent(IDataAwal parent){this.parent=parent;}
}