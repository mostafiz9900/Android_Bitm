package com.example.datetimetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ExpenceDatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "expences.db";
    public static String TABLE_NAME = "expences";

    public static String COL_ID = "Id";
    public static String COL_TYPE = "Type";
    public static String COL_COST = "Cost";
    public static String COL_DATE = "Date";
    public static String COL_TIME = "Time";
    public static String COL_IMAGE = "Image";
    public static String CREATE_TABLE = "create table " + TABLE_NAME + "(Id integer primary key, Type text, Cost text, Date text, Time text, Image text)";


    public static int VERSOIN = 1;


    public ExpenceDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSOIN);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
