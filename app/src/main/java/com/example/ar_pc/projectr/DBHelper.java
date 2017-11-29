package com.example.ar_pc.projectr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AR-Laptop on 11/29/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "bahan_makanan.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_BAHANMAKANAN_TABLE =
                "CREATE TABLE " + DatabaseContract.BahanEntry.TABLE_NAME +"(" +
                        DatabaseContract.BahanEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        DatabaseContract.BahanEntry.COLUMN_NAMA + " TEXT NOT NULL,);";
        sqLiteDatabase.execSQL(SQL_CREATE_BAHANMAKANAN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.BahanEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
