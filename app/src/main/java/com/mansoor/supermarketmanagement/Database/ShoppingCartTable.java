package com.mansoor.supermarketmanagement.Database;

import android.database.sqlite.SQLiteDatabase;

public class ShoppingCartTable {

    private String tableName="shopping_cart";
    private String cart_id = "cart_id";
    private String discount = "discount";

    public ShoppingCartTable() {

    }

    public ShoppingCartTable(SQLiteDatabase sqLiteDatabase) {
        String sql ="CREATE TABLE "+tableName+"("+
                cart_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                discount+" FLOAT DEFAULT 0.00"+ ");";
        sqLiteDatabase.execSQL(sql);
    }

    public ShoppingCartTable(String discount) {
        this.discount = discount;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}