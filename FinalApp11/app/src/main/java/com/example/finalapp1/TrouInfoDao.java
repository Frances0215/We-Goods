package com.example.finalapp1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TrouInfoDao {
    MySQLiteOpenHelper helper;
    public TrouInfoDao(Context context){
        helper=new MySQLiteOpenHelper(context);
    }

    public boolean insert(Trousers ts){
        SQLiteDatabase db=helper.getWritableDatabase();
        db.execSQL("insert into trousersNP values(null,?,?,?,?,?,?,?,?,?)",new Object[]{
                ts.getCode(),ts.getTime(),ts.getName(),ts.getValue(),ts.getStituation(),
                ts.getHigtTemperature(),ts.getLowTemperature(),ts.getColor(),
                ts.getWeather(),ts.getFabric()
        });
        return true;
    }
    public void delete(String Code){
        SQLiteDatabase db=helper.getWritableDatabase();
        db.execSQL("delete from trousersNP where code=?",new Object[]{Code});
    }
    public void deleteTab(boolean isDrop){//清空表数据，或删除表，此处是为了方便程序测试，因为可能编写过程中不合法的数据也添加进去了，需要进行清空操作

        SQLiteDatabase db = helper.getWritableDatabase();
        if(isDrop)
        {
            db.execSQL("drop table trousersNP ");//删除表
        }
        else
        {
            db.execSQL("delete from trousersNP ");//清空表的数据
        }
    }
    public void update(Trousers ts){//根据对象进行更新操作

        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("update trousersNP set code=?,time=?,name=?," +
                "vaule=?,situation=?,hightemperature=?,lowtemperature=?," +
                "color=?,weather=?,frabric=? where code=?", new Object[]{
                Integer.valueOf(ts.getCode()),ts.getTime(),ts.getName(),ts.getValue(),ts.getStituation(),
                ts.getHigtTemperature(),ts.getLowTemperature(),ts.getColor(),
                ts.getWeather(),ts.getFabric()
        });
    }
    public Trousers find(String Code){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from trousersNP where code=?",new String[]{Code});

        boolean result=cursor.moveToNext();
        Trousers ts=null;
        if(result){
            int code=cursor.getInt((cursor.getColumnIndex("code")));
            String time=cursor.getString((cursor.getColumnIndex("time")));
            String name=cursor.getString((cursor.getColumnIndex("name")));
            double value=cursor.getDouble((cursor.getColumnIndex("value")));
            String situation=cursor.getString((cursor.getColumnIndex("situation")));
            int hightemperature=cursor.getInt((cursor.getColumnIndex("hightemperature")));
            int lowtemperature=cursor.getInt((cursor.getColumnIndex("lowtemperature")));
            String color=cursor.getString((cursor.getColumnIndex("color")));
            String weather=cursor.getString((cursor.getColumnIndex("weather")));
            String frabic=cursor.getString((cursor.getColumnIndex("frabic")));

            ts=new Trousers(code,time,name,value,situation,hightemperature,lowtemperature,color,weather,frabic);

        }

        cursor.close();
        return ts;
    }
    public List<Trousers> search(){
        SQLiteDatabase db = helper.getWritableDatabase();
        List<Trousers> list=new ArrayList<Trousers>();
        list.clear();

        Cursor cursor=db.rawQuery("select * from trousersNP",null);
        while(cursor.moveToNext()){
            int code=cursor.getInt((cursor.getColumnIndex("code")));
            String time=cursor.getString((cursor.getColumnIndex("time")));
            String name=cursor.getString((cursor.getColumnIndex("name")));
            double value=cursor.getDouble((cursor.getColumnIndex("value")));
            String situation=cursor.getString((cursor.getColumnIndex("situation")));
            int hightemperature=cursor.getInt((cursor.getColumnIndex("hightemperature")));
            int lowtemperature=cursor.getInt((cursor.getColumnIndex("lowtemperature")));
            String color=cursor.getString((cursor.getColumnIndex("color")));
            String weather=cursor.getString((cursor.getColumnIndex("weather")));
            String frabic=cursor.getString((cursor.getColumnIndex("frabic")));

            Trousers ts=new Trousers(code,time,name,value,situation,hightemperature,lowtemperature,color,weather,frabic);
            list.add(ts);
        }
        cursor.close();
        return list;
    }
}
