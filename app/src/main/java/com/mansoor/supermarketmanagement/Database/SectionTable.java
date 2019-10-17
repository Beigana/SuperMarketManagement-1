package com.mansoor.supermarketmanagement.Database;

import android.database.sqlite.SQLiteDatabase;

public class SectionTable {
    private String tableName="section";
    private String name="name";
    private String sec_id="table_name";
    private String mgr_id="mgr_id";

    public SectionTable()
    {
    }

    public SectionTable(SQLiteDatabase sqLiteDatabase)
    {
        String sql ="CREATE TABLE "+tableName+"("+
                sec_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                name+" VARCHAR(20) UNIQUE,"+
                mgr_id+" integer(6) REFERENCES employee(emp_id) ON DELETE SET NULL ON UPDATE CASCADE"+
                ");";
        sqLiteDatabase.execSQL(sql);
    }

    public SectionTable(String name,String mgr_id) {
        this.mgr_id=mgr_id;
        this.name = name;
    }

    public String getTableName() {
        return tableName;
    }

    public String getName() {
        return name;
    }

    public String getSec_id() {
        return sec_id;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSec_id(String sec_id) {
        this.sec_id = sec_id;
    }

    public String getMgr_id() {
        return mgr_id;
    }

    public void setMgr_id(String mgr_id) {
        this.mgr_id = mgr_id;
    }
}
