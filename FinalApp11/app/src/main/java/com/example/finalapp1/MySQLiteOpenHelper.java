package com.example.finalapp1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String TROUSERS_TABLE="trousersNP";
    public MySQLiteOpenHelper(Context context){
        super(context,"mydatabase.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建boxNP表
        //创建TrousersNP表
        db.execSQL("create table trousersNP(code integer primary key autoincrement," +
                "time text," +
                "name text," +
                "value float(53)," +
                "situation text," +
                "hightemperature integer," +
                "lowtemperature integer," +
                "weather text," +
                "color text," +
                "fabric text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
