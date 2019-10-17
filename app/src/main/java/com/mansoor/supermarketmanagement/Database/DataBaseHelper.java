package com.mansoor.supermarketmanagement.Database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.mansoor.supermarketmanagement.MainActivity;

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
        new PaymentTable(sqLiteDatabase);            //Create table payment
        new CustomerTable(sqLiteDatabase);
        new EmployeeTable(sqLiteDatabase);
        new SectionTable(sqLiteDatabase);
        new StockTable(sqLiteDatabase);
        new ProductTable(sqLiteDatabase);
        new SupplierTable(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { }
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
            contentValues.put(keyEmployee.getSec_id(),employeeTable.getSec_id());
            sqLiteDatabase.insert(keyEmployee.getTableName(), null, contentValues);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addSectionData(SectionTable sectionTable)
    {
        try {
            SectionTable keySection = new SectionTable();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(keySection.getName(),sectionTable.getName());
            contentValues.put(keySection.getMgr_id(),sectionTable.getMgr_id());
            sqLiteDatabase.insert(keySection.getTableName(), null, contentValues);
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
    public boolean addSupplierData(SupplierTable supplierTable) {
        try {
            SupplierTable keySupplierTable = new SupplierTable();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(keySupplierTable.getFname(), supplierTable.getFname());
            contentValues.put(keySupplierTable.getLname(), supplierTable.getLname());
            contentValues.put(keySupplierTable.getEmail(), supplierTable.getEmail());
            contentValues.put(keySupplierTable.getAddress(), supplierTable.getAddress());
            contentValues.put(keySupplierTable.getMobile(), supplierTable.getMobile());
            contentValues.put(keySupplierTable.getPassword(),supplierTable.getPassword());
            sqLiteDatabase.insert(keySupplierTable.getTableName(),null, contentValues);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //Display data :
    public Cursor getDataFromCustomerTable()        //only create getdata for customer no need to create other getdata table
    {
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM customer",null);
    }                                                      //as below i have generalized getdata from table
    //General Select * from  Table function
    public Cursor getDataFromTable(String tablename)
    {
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM "+tablename,null);
    }
    //General Select * from Table WHERE function
    public Cursor getDataFromTable(String tablename,String where_clause)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM "+tablename+" "+where_clause,null);
    }


    //populate data :
    public boolean populateTable(Context context)
    {
        DataBaseHelper dataBaseHelper=DataBaseHelper.getInstance(context);
        //populating Suppliers table
        if(!dataBaseHelper.addSupplierData(new SupplierTable("Manohar","Yadav","manohar@gmail.com","Ujjain","9858965748","qwerty1")))
            return  false;
        if(!dataBaseHelper.addSupplierData(new SupplierTable("Rohit","Sharma","rohit12345@gmail.com","Indore","8958965458","qwerty2")))
            return  false;
        if(!dataBaseHelper.addSupplierData(new SupplierTable("Surjeet","Patel","surjeet@gmail.com","Lucknow","9858785896","qwerty3")))
            return  false;
        //populating section table
        SectionTable sectionTable=new SectionTable("Stationary","");
        if(!dataBaseHelper.addSectionData(sectionTable))
        {
            return  false;
        }
        if(!dataBaseHelper.addSectionData(new SectionTable("Garments","")))     //section_id=2
            return  false;
        if(!dataBaseHelper.addSectionData(new SectionTable("Laptops","1")))     //section_id=3
            return  false;
        if(!dataBaseHelper.addSectionData(new SectionTable("Mobiles","4")))     //section_id=4
            return  false;


       //populating employee table
        EmployeeTable employeeTable=new EmployeeTable("Sanjay","Sharma","sanjay@gmail.com","7859857869","Indore","M","450000","","1");
        if(!dataBaseHelper.addEmployeeData(employeeTable))
        {
            return false;
        }
        if(!dataBaseHelper.addEmployeeData(new EmployeeTable("Mohan","Verma","mohan@gmail.com","9858545256","Kolkata","M","850000","1","1")))
        {
            return false;
        }
        if(!dataBaseHelper.addEmployeeData(new EmployeeTable("Shilpa","Agarwal","shilpa123@gmail.com","8597858964","Mumbai","F","750000","","2")))
        {
            return false;
        }

        if(!dataBaseHelper.addEmployeeData(new EmployeeTable("Malini","Roy","malini198@gmail.com","85895652589","Indore","F","758000","","4")))
        {
            return false;
        }

        //populating stock table




        return true;
    }

}
