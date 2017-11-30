package com.example.ar_pc.projectr.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.ar_pc.projectr.model.bahanMakananItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.ar_pc.projectr.R;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BukuHarianActivity extends AppCompatActivity {
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("bahan_makanan");
    private Spinner spBahanMakanan;
    private ValueEventListener bahanListener;
    private List<String> bahanArray;
    private ArrayAdapter<String> bahanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_harian);

        bahanArray = new ArrayList<String>();
        bahanAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bahanArray);
        bahanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBahanMakanan = findViewById(R.id.spBahanMakanan);
        spBahanMakanan.setAdapter(bahanAdapter);

        bahanListener = new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                bahanMakananItem bahan = dataSnapshot.getValue(bahanMakananItem.class);
                bahanArray.add(bahan.getNama());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
            }
        };
        mDatabase.addListenerForSingleValueEvent(bahanListener);
    }
}
