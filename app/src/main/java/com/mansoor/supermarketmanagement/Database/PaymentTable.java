package com.mansoor.supermarketmanagement.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class PaymentTable {
    private String tableName="payment";
    private String payment_id="payment_id";
    private String mode="mode";
    private String timestamp="timestamp";

    public PaymentTable()
    {
    }
    public PaymentTable(SQLiteDatabase sqLiteDatabase)
    {
        String sql = "CREATE TABLE "+ tableName+"(" +
                payment_id+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                mode+" varchar(10) NOT NULL," +
                timestamp+" DATETIME DEFAULT (datetime('now','localtime'))" +
                ");";
        sqLiteDatabase.execSQL(sql);
    }

    public PaymentTable(String mode) {
        this.mode = mode;
    }

    public String getTableName() {
        return tableName;
    }

    public String getMode() {
        return mode;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
