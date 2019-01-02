package com.example.homepc.restauranteatitapp;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by HomePC on 1/9/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "EatItData";

                                //TABLE 1 FOR LOGIN DETAILS

    public  static final String TABLE_NAME = "Customers";
    public static final String COLUMN_1 = "Id";
    final String COLUMN_2 = "Name";
    public static final String COLUMN_3 = "Password";

                                //TABLE 2 FOR ORDER DETAILS

    public  static final String TABLE_NAME_2 = "OrderDetails";
    public  static final String KEY_1 = "OrderNo";
    public  static final String KEY_2 = "ItemName";
    public  static final String KEY_3 = "ItemQuantity";
    public  static final String KEY_4 = "ItemPrice";





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +" (id integer primary key autoincrement,name text,password text) "   );
        db.execSQL("CREATE TABLE " + TABLE_NAME_2 +" (orderno integer primary key autoincrement,itemname text,itemquantity text,itemprice text) "   );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_2);
        onCreate(db);
    }


    public boolean Add_Account(String Name,String Password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_2,Name);
        contentValues.put(COLUMN_3,Password);
        double check = db.insert(TABLE_NAME,null,contentValues);
        if(check == -1) return false;
        else return true;

    }
    public Cursor GetData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+ TABLE_NAME ,null);
        return res;

    }
    public Cursor CheckAccount(String searchstr){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Customers WHERE Name LIKE '%"+searchstr+"%'", null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        return cursor;

    }

                                   //ORDER DETAILS DATABASE WORK

    public boolean Add_to_Cart(String Name,String Quantity,String Price){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(KEY_2,Name);
        contentValues1.put(KEY_3,Quantity);
        contentValues1.put(KEY_4,Price);
        double check = db.insert(TABLE_NAME_2,null,contentValues1);
        if(check == -1) return false;
        else return true;




    }
    public Cursor Get_OrderDetails() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+ TABLE_NAME_2, null);
        return data;
    }

    public Integer delete_one(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_2,"Id = ?",new String [] {id});

    }
    public void delete_all( ){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME_2);
    }



}
