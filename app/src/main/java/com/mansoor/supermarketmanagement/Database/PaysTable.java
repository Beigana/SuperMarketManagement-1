package com.mansoor.supermarketmanagement.Database;

import android.database.sqlite.SQLiteDatabase;

public class PaysTable {
    private String tableName="pays";
    private String cus_id = "cus_id";
    private String payment_id = "payment_id";
    private String cart_id = "cart_id";

    public PaysTable() {

    }

    public PaysTable(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+tableName+"(" +
                "cus_id INTEGER REFERENCES customer(cus_id) ON DELETE CASCADE ON UPDATE CASCADE," +
                "payment_id INTEGER  REFERENCES payment(payment_id) ON DELETE CASCADE ON UPDATE CASCADE," +
                "cart_id INTEGER  REFERENCES shopping_cart(cart_id) ON DELETE CASCADE ON UPDATE CASCADE," +
                "PRIMARY KEY(cus_id,cart_id)" +
                ");";
        sqLiteDatabase.execSQL(sql);
    }

    public PaysTable(String cus_id, String payment_id, String cart_id) {
        this.cus_id = cus_id;
        this.payment_id = payment_id;
        this.cart_id = cart_id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }
}