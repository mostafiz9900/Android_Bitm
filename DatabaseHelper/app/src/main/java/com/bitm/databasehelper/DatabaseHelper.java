package com.bitm.databasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "User.db";
    private static String TABLE_NAME = "User";

    private static String COL_ID = "Id";
    private static String COL_NAME = "Name";
    private static String COL_AGE = "Age";

    private String CREATE_TANBLE = "create table " + TABLE_NAME + "(Id integer primary key, Name Text, Age Text)";


    private static int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TANBLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public Long insertData(String name,String age){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_NAME,name);
        contentValues.put(COL_AGE,age);
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
       long id= sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        return id;
    }
}
