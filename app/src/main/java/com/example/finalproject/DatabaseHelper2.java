package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper2 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Car.db";
    public static final String TABLE2_NAME = "car_table";
    public static final String COL_1 = "carID";
    public static final String COL_2 = "carPlate";
    public static final String COL_3 = "carModel";

    public DatabaseHelper2(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table "+ TABLE2_NAME + "(carID integer " +
                "primary key autoincrement, carPlate text, carModel text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE2_NAME);
        onCreate(db);
    }

    public boolean insertCar(String plate, String model){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,plate);
        contentValues.put(COL_3,model);
        long result = db.insert(TABLE2_NAME,null,contentValues);
        if(result==-1)
            return false;
        else return true;
    }
}
