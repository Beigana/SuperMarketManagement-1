package com.mansoor.supermarketmanagement.Database;

import android.database.sqlite.SQLiteDatabase;

public class StockTable {
    private String table_name="stock";
    private String stock_id="stock_id";
    private String name="name";
    private String quantity="quantity";
    //private String section_table="section_table";
    private String sec_id="sec_id";

    public StockTable()
    {
    }

    public StockTable(SQLiteDatabase sqLiteDatabase)
    {
        String sql ="CREATE TABLE "+table_name+"("+
                stock_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                name+" VARCHAR(20) UNIQUE,"+
                quantity+" INTEGER CHECK(quantity>=0) NOT NULL,"+
                sec_id+" INTEGER(6) REFERENCES section(sec_id) ON DELETE CASCADE ON UPDATE CASCADE"+
                ");";
        sqLiteDatabase.execSQL(sql);
    }

    public StockTable(String name, String quantity,String sec_id) {
        this.name = name;
        this.quantity = quantity;
        this.sec_id=sec_id;
        //this.section_table = section_table;
    }

    public String getTable_name() {
        return table_name;
    }

    public String getStock_id() {
        return stock_id;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }


    public String getSec_id() {
        return sec_id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    public void setSec_id(String sec_id) {
        this.sec_id = sec_id;
    }

}
