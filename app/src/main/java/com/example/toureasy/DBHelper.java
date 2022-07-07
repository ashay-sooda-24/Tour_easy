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
        MyDB.execSQL("CREATE TABLE SOURCE(sid INTEGER,sname TEXT,PRIMARY KEY(sid))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists source");
        onCreate(MyDB);
    }

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
        SQLiteDatabase MyDB = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        long result=0;
        for(i=0;i<3;i++){
                contentValues.put("sid", i+1);
                contentValues.put("sname", sourceList[i]);
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
            while(cursor.moveToNext()){
                 id = cursor.getString(0);
            }
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
