package com.example.ar_pc.projectr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<menuItem> menuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuItems = new ArrayList<>();

        menuItem mi1 = new menuItem("Data Awal", DataAwalActivity.class);
        menuItem mi2 = new menuItem("Buku Harian Dietku", BukuHarianActivity.class);
        menuItem mi3 = new menuItem("Gula Darahku", GulaDarahActivity.class);
        menuItems.add(mi1);
        menuItems.add(mi2);
        menuItems.add(mi3);

        RecyclerView rvMenu = (RecyclerView) findViewById(R.id.rvMenu);
        MenuAdapter menuAdapter = new MenuAdapter(this, menuItems);
        rvMenu.setAdapter(menuAdapter);
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
    }
}
