package com.example.databasehelper_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "User.db";
    public static String TABLE_NAME = "User";

    public static String COL_ID = "Id";
    public static String COL_NAME = "Name";
    public static String COL_AGE = "Age";

    public static String CREATE_TABLE = "create table " + TABLE_NAME + "(Id integer primary key, Name text, Age text)";

    public static int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Long insertData(String name, String age) {
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_AGE, age);
        SQLiteDatabase database = getWritableDatabase();
        long id = database.insert(TABLE_NAME, null, values);
        database.close();
        return id;
    }

    public Cursor dataList() {
        String show_all = "select * from " + TABLE_NAME;
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(show_all, null);
        return cursor;
    }

    public void deleteData(int id) {
        getWritableDatabase().delete(TABLE_NAME, "Id=?", new String[]{String.valueOf(id)});
    }
}
