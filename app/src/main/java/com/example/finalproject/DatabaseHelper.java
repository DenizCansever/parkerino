package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ThePark.db";
    public static final String TABLE1_NAME = "officer_table";
    public static final String COL_1 = "offID";
    public static final String COL_2 = "offName";
    public static final String COL_3 = "offUser";
    public static final String COL_4 = "offPass";



    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table "+ TABLE1_NAME + "(offID integer " +
                "primary key autoincrement, offName text, offUser text, offPass text)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE1_NAME);
        onCreate(db);
    }

    public boolean insertOfficer(String name, String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,username);
        contentValues.put(COL_4,password);
        long result = db.insert(TABLE1_NAME,null,contentValues);
        if(result==-1)
            return false;
        else return true;
    }



    public boolean getAllData(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectString = "SELECT * FROM " + TABLE1_NAME + " WHERE " + COL_3 + "= ?"
                + " AND " + COL_4 + " = ?";

        Cursor cursor = db.rawQuery(selectString,new String[]{username,password});
        boolean exist;
        if(cursor.getCount()>0){
            exist=true;
        } else {
            exist=false;
        }
        db.close();
        cursor.close();

        return exist;
    }
    }

