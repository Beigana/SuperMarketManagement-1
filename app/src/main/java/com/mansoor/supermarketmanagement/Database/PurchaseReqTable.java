package com.mansoor.supermarketmanagement.Database;

import android.database.sqlite.SQLiteDatabase;

public class PurchaseReqTable {
    private String tableName="purchase_req";
    private String supp_id="supp_id";
    private String sec_id="sec_id";
    private String quantitiy="quantity";

    public PurchaseReqTable(){

    }

    public PurchaseReqTable(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+tableName+"(" +
                supp_id+" INTEGER REFERENCES supplier(supp_id) ON DELETE CASCADE ON UPDATE CASCADE," +
                sec_id+" INTEGER REFERENCES section(sec_id) ON DELETE CASCADE ON UPDATE CASCADE," +
                quantitiy+" INTEGER(4) NOT NULL,"+
                "PRIMARY KEY(supp_id,sec_id)" +
                ");";
        sqLiteDatabase.execSQL(sql);
    }

    public PurchaseReqTable(String supp_id, String sec_id,String quantitiy) {
        this.supp_id = supp_id;
        this.sec_id = sec_id;
        this.quantitiy=quantitiy;
    }

    public String getTableName() {
        return tableName;
    }

    public String getSupp_id() {
        return supp_id;
    }

    public String getSec_id() {
        return sec_id;
    }

    public void setSec_id(String sec_id) {
        this.sec_id = sec_id;
    }

    public String getQuantitiy() {
        return quantitiy;
    }

    public void setQuantitiy(String quantitiy) {
        this.quantitiy = quantitiy;
    }
}