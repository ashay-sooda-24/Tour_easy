//package com.example.toureasy;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//public class DBHelper2 extends SQLiteOpenHelper {
//    public static final String DBname = "TourEasy2.db";
//
//    public DBHelper2(Context context) {
//        super(context, DBname, null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase myDB) {
//        myDB.execSQL("CREATE TABLE DISTAN(sid INTEGER,did INTEGER,distance INTEGER)");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
//        myDB.execSQL("drop Table if exists DISTAN");
//        onCreate(myDB);
//    }
//
//    public Boolean insertDistance(){
//        int i,j,k=0;
//        double[] distances = {11,12.6,4.9,10,9.5,22.5,6,14.1,13,4,14.3,3.5,30,5.1,14,16,12,11,17,11.2,14};
//        long result =0;
//        SQLiteDatabase myDB = this.getReadableDatabase();
//        ContentValues contentValues = new ContentValues();
//        for(i=0;i<3;i++){
//            for(j=0;j<7;j++) {
//                contentValues.put("sid", i+1);
//                contentValues.put("did",j+1);
//                contentValues.put("distance",distances[k]);
//                k++;
//                result = myDB.insert("distan", null, contentValues);
//            }
//        }
//        myDB.close();
//        if(result==-1) return false;
//        else return true;
//    }
//
//    public Boolean getDistan(int sidd,int did){
//        SQLiteDatabase MyDB = this.getWritableDatabase();
//        String sid = Integer.toString(sidd);
//        String didd = Integer.toString(did);
//        Cursor cursor = MyDB.rawQuery("Select distance from distan where sid = ? and did=?",new String[]{sid,didd});
//        if(cursor.getCount()>0) {
//            cursor.close();
//            MyDB.close();
//            return true;
//        }
//        else {
//            cursor.close();
//            MyDB.close();
//            return false;
//        }
//    }
//
//
//}
