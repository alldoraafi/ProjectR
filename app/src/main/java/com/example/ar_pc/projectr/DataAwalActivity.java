package com.example.ar_pc.projectr;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DataAwalActivity extends AppCompatActivity implements IDataAwal{
    private FragmentManager fm;
    private DataAwalFragment fragDataAwal;
    private AnalisisFragment fragAnalisis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_awal);

        fragDataAwal = new DataAwalFragment();
        fragDataAwal.setParent(this);
        fragAnalisis = new AnalisisFragment();

        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.layout, fragDataAwal).commit();
    }

    @Override
    public int getUsia() {
        return 0;
    }

    @Override
    public void gantiFragment() {
        fm.beginTransaction().replace(R.id.layout, fragAnalisis).commit();
    }


    @Override
    public void kirimData(int tinggi, int berat, int jk, int usia) {
        fragAnalisis.setBerat(tinggi, berat, jk, usia);
    }
}
