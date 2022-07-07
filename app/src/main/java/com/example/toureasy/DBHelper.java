package com.example.toureasy;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBname = "TourEasy.db";

    public DBHelper(Context context) {

        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE USERS(username TEXT PRIMARY KEY, password TEXT,phone INTEGER)");
//        MyDB.execSQL("CREATE TABLE SOURCE(sid INTEGER,did INTEGER ,sname TEXT,dname TEXT,PRIMARY KEY(sid,did))");
        MyDB.execSQL("CREATE TABLE SOURCE(sid INTEGER,sname TEXT,PRIMARY KEY(sid))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists source");
        onCreate(MyDB);
    }

//    public Boolean destinInsert(){
//        int i,j,k=0;
//        String[] destList = {"Panambur Beach","Tannirbhavi Beach"};
////        double[] distances = {11,12.6,4.9,10,9.5,22.5,6,14.1,13,4,14.3,3.5,30,5.1,14,16,12,11,17,11.2,14};
//        SQLiteDatabase MyDB = this.getReadableDatabase();
//        ContentValues contentValues = new ContentValues();
//        long result=0;
//        for(i=0;i<2;i++){
//
//                contentValues.put("dname",destList[i]);
////                contentValues.put("dist",distances[k]);
////                k++;
//                result = MyDB.insert("destin", null, contentValues);
//        }
//        MyDB.close();
//        if(result==-1){
//            return false;
//        }
//        else return true;
//    }

    public Boolean insertData(String username, String password,int phone){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("phone",phone);
        long result = MyDB.insert("users",null,contentValues);
        MyDB.close();
        if(result==-1) return false;
        else return true;
    }

    public void sourceInsert(){
        int i,j,k=0;
        String[] sourceList = {"KSRTC","Railway Station","Mangalore Airport"};
//        String[] destList = {"Panambur Beach","Tannirbhavi Beach", "Kadri Temple", "Pilikula Nisargadham", "Mangaldevi Temple","Kateel","Sulthan Bathery"};
//        double[] distances = {11,12.6,4.9,10,9.5,22.5,6,14.1,13,4,14.3,3.5,30,5.1,14,16,12,11,17,11.2,14};
        SQLiteDatabase MyDB = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        long result=0;
        for(i=0;i<3;i++){
//            for(j=0;j<7;j++) {
                contentValues.put("sid", i+1);
//                contentValues.put("did",j+1);
                contentValues.put("sname", sourceList[i]);
//                contentValues.put("dname",destList[j]);
//                contentValues.put("dist",distances[k]);
//                k++;
                result = MyDB.insert("source", null, contentValues);
//            }
        }
        MyDB.close();
    }



    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?",new String[]{username});
        if(cursor.getCount()>0) {
            cursor.close();
            MyDB.close();
            return true;
        }
        else {
            cursor.close();
            MyDB.close();
            return false;
        }
    }

    public int checkSourceId(String source){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select sid from source where sname  = ?", new String[]{source});
        if(cursor.getCount()>0){
            String id = null;
            int count = 0;
            while(cursor.moveToNext()){
                 id = cursor.getString(0);
                 count++;
            }
//            int id = cursor.getCount();
            cursor.close();
            MyDB.close();
            return Integer.parseInt(id);

        }
        cursor.close();
        MyDB.close();
        return 00;
    }

    public int getPhone(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select phone from users where username = ?",new String[]{username});
        if(cursor.getCount()>0){
            String phone = null;
            while(cursor.moveToNext()){
                phone = cursor.getString(0);
            }
            cursor.close();
            MyDB.close();
            return Integer.parseInt(phone);
        }
        cursor.close();
        MyDB.close();
        return 00;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{username,password});
        if(cursor.getCount()>0){
            cursor.close();
            MyDB.close();
            return true;
        }
        else{
            cursor.close();
            MyDB.close();
            return false;
        }
    }


}
