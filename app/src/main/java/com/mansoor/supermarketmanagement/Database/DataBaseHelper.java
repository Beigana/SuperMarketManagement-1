package com.mansoor.supermarketmanagement.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        new EmployeeTable(sqLiteDatabase);
        new CustomerTable(sqLiteDatabase);
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
    public boolean addEmployeeData(EmployeeTable employeeTable)
    {
        try {
            EmployeeTable keyEmployee = new EmployeeTable();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(keyEmployee.getFname(),employeeTable.getFname());
            contentValues.put(keyEmployee.getLname(),employeeTable.getLname());
            contentValues.put(keyEmployee.getEmail(),employeeTable.getEmail());
            contentValues.put(keyEmployee.getMobile(),employeeTable.getMobile());
            contentValues.put(keyEmployee.getAddress(),employeeTable.getAddress());
            contentValues.put(keyEmployee.getGender(),employeeTable.getGender());
            contentValues.put(keyEmployee.getSalary(),employeeTable.getSalary());
            contentValues.put(keyEmployee.getSuper_id(),employeeTable.getSuper_id());
            sqLiteDatabase.insert(keyEmployee.getTableName(), null, contentValues);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addCustomerData(CustomerTable customerTable)
    {
        try {
            CustomerTable keyCustomer = new CustomerTable();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(keyCustomer.getFname(),customerTable.getFname());
            contentValues.put(keyCustomer.getLname(),customerTable.getLname());
            contentValues.put(keyCustomer.getEmail(),customerTable.getEmail());
            contentValues.put(keyCustomer.getPassword(),customerTable.getPassword());
            contentValues.put(keyCustomer.getMobile(),customerTable.getMobile());
            contentValues.put(keyCustomer.getDob(),customerTable.getDob());
            contentValues.put(keyCustomer.getGender(),customerTable.getGender());
            sqLiteDatabase.insert(keyCustomer.getTableName(), null, contentValues);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    //Display data :
    public Cursor getDataFromCustomerTable()
    {
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM customer",null);
    }


}
