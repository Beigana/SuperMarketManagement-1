package com.mansoor.supermarketmanagement.Database;

import android.database.sqlite.SQLiteDatabase;

public class ProductTable {
    private String tableName="product";
    private String product_id="product_id";
    private String name="name";
    private String price="price";
    private String stock_id="stock_id";
    private String description="description";

    public ProductTable()
    {
    }

    public ProductTable(SQLiteDatabase sqLiteDatabase)
    {
        String sql ="CREATE TABLE "+tableName+"("+
                product_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                name+" VARCHAR(20)  REFERENCES stock(name) ON DELETE CASCADE ON UPDATE CASCADE,"+
                price+" FLOAT CHECK(price>=0) NOT NULL,"+
                stock_id+" INTEGER(6) REFERENCES stock(stock_id) ON DELETE CASCADE ON UPDATE CASCADE,"+
                description+" VARCHAR(100)"+ ");";
        sqLiteDatabase.execSQL(sql);
    }

    public ProductTable(String name, String price,String stock_id,String description) {
        this.name = name;
        this.price = price;
        this.stock_id=stock_id;
        this.description = description;
    }

    public String getTableName() {
        return tableName;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getStock_id() {
        return stock_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getDescription() {
        return description;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStock_id(String stock_id) {
        this.stock_id = stock_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
