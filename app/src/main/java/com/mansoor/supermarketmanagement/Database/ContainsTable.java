package com.mansoor.supermarketmanagement.Database;

import android.database.sqlite.SQLiteDatabase;

public class ContainsTable {
    private String tableName = "contains";
    private String product_id = "product_id";
    private String cart_id = "cart";
    private String quantity = "quantity";

    public ContainsTable() {

    }

    public ContainsTable(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+tableName+"(\n" +
                "product_id INTEGER(6) REFERENCES product(product_id) ON DELETE CASCADE ON UPDATE CASCADE," +
                "cart_id INTEGER(6)  REFERENCES shopping_cart(cart_id) ON DELETE CASCADE ON UPDATE CASCADE," +
                "quantity INTEGER(6)  CHECK(quantity>=0) NOT NULL," +
                "PRIMARY KEY(product_id,cart_id)" +
                ");";
        sqLiteDatabase.execSQL(sql);
    }

    public ContainsTable(String product_id, String cart_id, String quantity) {
        this.product_id = product_id;
        this.cart_id = cart_id;
        this.quantity = quantity;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}