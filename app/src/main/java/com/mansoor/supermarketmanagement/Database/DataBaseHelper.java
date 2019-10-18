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
        new ShoppingCartTable(sqLiteDatabase);
        new PaysTable(sqLiteDatabase);
        new EmployeeTable(sqLiteDatabase);
        new SectionTable(sqLiteDatabase);
        new StockTable(sqLiteDatabase);
        new ProductTable(sqLiteDatabase);
        new SupplierTable(sqLiteDatabase);
        new CheckAvailabilityTable(sqLiteDatabase);
        new ContainsTable(sqLiteDatabase);
        new PurchaseReqTable(sqLiteDatabase);
        new SellsTable(sqLiteDatabase);

    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
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
           //if(!sectionTable.getMgr_id().toLowerCase().equals("null"))

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
    public boolean addShoppingData(ShoppingCartTable shoppingCartTable) {
        try {
            ShoppingCartTable keyShoppingCart = new ShoppingCartTable();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            //contentValues.put(keyShoppingCart.getCart_id(), shoppingCartTable.getCart_id());
            contentValues.put(keyShoppingCart.getDiscount(), shoppingCartTable.getDiscount());
            sqLiteDatabase.insert(keyShoppingCart.getTableName(),null, contentValues);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addPaysData(PaysTable paysTable) {
        try {
            PaysTable keyPaysTable = new PaysTable();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(keyPaysTable.getCus_id(), paysTable.getCus_id());
            contentValues.put(keyPaysTable.getPayment_id(), paysTable.getPayment_id());
            contentValues.put(keyPaysTable.getCart_id(), paysTable.getCart_id());
            sqLiteDatabase.insert(keyPaysTable.getTableName(),null, contentValues);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addPurchaseReqData(PurchaseReqTable purchaseReqTable) {
        try {
            PurchaseReqTable keyPurchaseReqTable1 = new PurchaseReqTable();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(keyPurchaseReqTable1.getSupp_id(), purchaseReqTable.getSupp_id());
            contentValues.put(keyPurchaseReqTable1.getSec_id(), purchaseReqTable.getSec_id());
            contentValues.put(keyPurchaseReqTable1.getQuantitiy(), purchaseReqTable.getQuantitiy());
            sqLiteDatabase.insert(keyPurchaseReqTable1.getTableName(), null, contentValues);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addSellsData(SellsTable sells) {
        try {
            SellsTable keySells = new SellsTable();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(keySells.getSupp_id(), sells.getSupp_id());
            contentValues.put(keySells.getStock_id(), sells.getStock_id());
            sqLiteDatabase.insert(keySells.getTableName(), null, contentValues);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addContainsData(ContainsTable containsTable) {
        try {
            ContainsTable keyContainsTable = new ContainsTable();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(keyContainsTable.getProduct_id(), containsTable.getProduct_id());
            contentValues.put(keyContainsTable.getCart_id(), containsTable.getCart_id());
            contentValues.put(keyContainsTable.getQuantity(), containsTable.getQuantity());

            sqLiteDatabase.insert(keyContainsTable.getTableName(), null, contentValues);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addCheckAvailabilityData(CheckAvailabilityTable checkAvailabilityTable) {
        try {
            CheckAvailabilityTable keyCheckAvailability = new CheckAvailabilityTable();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(keyCheckAvailability.getStock_id(), checkAvailabilityTable.getStock_id());
            contentValues.put(keyCheckAvailability.getCart_id(), checkAvailabilityTable.getCart_id());

            sqLiteDatabase.insert(keyCheckAvailability.getTableName(), null, contentValues);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addStockData(StockTable stockTable) {
        try {
            StockTable keyStocktable = new StockTable();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(keyStocktable.getName(), stockTable.getName());
            contentValues.put(keyStocktable.getQuantity(), stockTable.getQuantity());
            contentValues.put(keyStocktable.getSec_id(), stockTable.getSec_id());
            sqLiteDatabase.insert(keyStocktable.getTable_name(), null, contentValues);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addProductData(ProductTable productTable) {
        try {
            ProductTable keyProductTable = new ProductTable();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(keyProductTable.getName(), productTable.getName());
            contentValues.put(keyProductTable.getPrice(), productTable.getPrice());
            contentValues.put(keyProductTable.getStock_id(),productTable.getStock_id());
            contentValues.put(keyProductTable.getDescription(), productTable.getDescription());
            sqLiteDatabase.insert(keyProductTable.getTableName(), null, contentValues);
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


    //General Updata Table :
    public boolean updateTableData(String sql)
    {
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            sqLiteDatabase.execSQL(sql);

            /*ContentValues contentValues = new ContentValues();
            contentValues.put(keyCheckAvailability.getStock_id(), checkAvailabilityTable.getStock_id());
            contentValues.put(keyCheckAvailability.getCart_id(), checkAvailabilityTable.getCart_id());
            sqLiteDatabase.insert(keyCheckAvailability.getTableName(), null, contentValues);*/
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
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
        SectionTable sectionTable=new SectionTable("Stationary",null);      //section_id=1
        if(!dataBaseHelper.addSectionData(sectionTable))
            return  false;
        if(!dataBaseHelper.addSectionData(new SectionTable("Garments",null)))     //section_id=2
            return  false;
        if(!dataBaseHelper.addSectionData(new SectionTable("Laptops",null)))     //section_id=3
            return  false;

        if(!dataBaseHelper.addSectionData(new SectionTable("Mobiles",null)))     //section_id=4
            return  false;

       //populating employee table
        EmployeeTable employeeTable=new EmployeeTable("Sanjay","Sharma","sanjay@gmail.com","7859857869","Indore","M","450000",null,"1");
        if(!dataBaseHelper.addEmployeeData(employeeTable))
        {
            return false;
        }
        if(!dataBaseHelper.addEmployeeData(new EmployeeTable("Mohan","Verma","mohan@gmail.com","9858545256","Kolkata","M","850000","1","1")))
        {
            return false;
        }
        if(!dataBaseHelper.addEmployeeData(new EmployeeTable("Shilpa","Agarwal","shilpa123@gmail.com","8597858964","Mumbai","F","750000",null,"2")))
        {
            return false;
        }

        if(!dataBaseHelper.addEmployeeData(new EmployeeTable("Malini","Roy","malini198@gmail.com","85895652589","Indore","F","758000",null,"4")))
        {
            return false;
        }
        dataBaseHelper.updateTableData(" update section set mgr_id=1 where sec_id=3;");
        dataBaseHelper.updateTableData(" update section set mgr_id=4 where sec_id=4;");

        //populating stock table
        if(!dataBaseHelper.addStockData(new StockTable("Natraj Sparkle Pen","200","1")))
            return false;
        if(!dataBaseHelper.addStockData(new StockTable("Reynolds Max INK","50","1")))
            return false;
        if(!dataBaseHelper.addStockData(new StockTable("Samasung Galaxy J7 MAX","13","4")))
            return false;
        if(!dataBaseHelper.addStockData(new StockTable("HP G79090","11","3")))
            return false;

        //populating Product table
        for(int i=0;i<200;i++)
        {
            if(!dataBaseHelper.addProductData(new ProductTable("Natraj Sparkle Pen","25","1","Ball pen")))
                return false;
        }
        for(int i=0;i<50;i++)
        {
            if(!dataBaseHelper.addProductData(new ProductTable("Reynolds Max INK","20","2","Ball pen Reynolds")))
                return false;
        }
        for(int i=0;i<13;i++)
        {
            if(!dataBaseHelper.addProductData(new ProductTable("Samasung Galaxy J7 MAX","15000","4","Samsung Mobile")))
                return false;
        }
        for(int i=0;i<11;i++)
        {
            if(!dataBaseHelper.addProductData(new ProductTable("HP G79090","15000","3","HP Laptop")))
                return false;
        }



        return true;
    }
}
