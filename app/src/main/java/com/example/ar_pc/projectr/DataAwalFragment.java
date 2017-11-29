package com.example.ar_pc.projectr;

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

/**
 * Created by AR-PC on 11/29/2017.
 */

public class DataAwalFragment extends Fragment {
    private View view;
    private EditText etUsia, etBerat, etTinggi;
    private RadioGroup rgJK;
    private Button btAnalisa;
    private IDataAwal parent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_data_awal, container, false);
        etUsia = view.findViewById(R.id.etUsia);
        etBerat = view.findViewById(R.id.etBerat);
        etTinggi = view.findViewById(R.id.etTinggi);
        rgJK = view.findViewById(R.id.rgJK);
        btAnalisa = view.findViewById(R.id.btAnalisa);
        btAnalisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tinggi = etTinggi.getText().toString();
                String berat = etBerat.getText().toString();
                if (!TextUtils.isEmpty(tinggi) && !TextUtils.isEmpty(berat)){
                    parent.kirimData(Integer.valueOf(etTinggi.getText().toString()),
                            Integer.valueOf(etBerat.getText().toString()));
                }
            }
        });

        return view;
    }

    public void setParent(IDataAwal parent){this.parent=parent;}
}
