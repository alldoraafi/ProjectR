package com.example.ar_pc.projectr;

import android.provider.BaseColumns;

/**
 * Created by AR-Laptop on 11/29/2017.
 */

public class DatabaseContract {
    public static final class BahanEntry implements BaseColumns{
        public static final String TABLE_NAME = "bahanmakanan_table";
        public static final String COLUMN_NAMA = "nama";
    }
}
