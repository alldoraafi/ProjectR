package com.example.ar_pc.projectr.model;

/**
 * Created by AR-PC on 11/30/2017.
 */

public class bahanMakananItem {
    private String nama;
    private int jumlah;

    public bahanMakananItem() {
    }

    public bahanMakananItem(String nama, int jumlah) {
        this.nama = nama;
        this.jumlah = jumlah;
    }

    public String getNama() {
        return nama;
    }
}
