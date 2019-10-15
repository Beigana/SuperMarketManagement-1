package com.mansoor.supermarketmanagement.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static String dbName="SuperMarket";             //DataBase Name
    private static DataBaseHelper dataBaseHelper;


    private DataBaseHelper(Context context) {
        super(context, dbName, null, 1);     //Creates database (only 1 time)
    }

    public static DataBaseHelper getInstance(Context context)
    {
        if (dataBaseHelper==null)
            return new DataBaseHelper(context);
        else
            return dataBaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        new PaymentTable(sqLiteDatabase);                   //Create table payment
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void getSQLiteWriteablepermission()
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
    }
    public boolean addPaymentData(PaymentTable paymentTable)
    {
        try {
            PaymentTable keyPayment = new PaymentTable();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(keyPayment.getMode(),paymentTable.getMode());
            sqLiteDatabase.insert(keyPayment.getTableName(), null, contentValues);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }



}
