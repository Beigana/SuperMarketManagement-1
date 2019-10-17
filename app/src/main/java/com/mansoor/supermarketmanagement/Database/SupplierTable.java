package com.mansoor.supermarketmanagement.Database;

import android.database.sqlite.SQLiteDatabase;
import android.location.Address;

public class SupplierTable {
    private String tableName="supplier";
    private String supp_id="supp_id";
    private String fname = "fname";
    private String lname = "lname";
    private String mobile = "mobile";
    private String email = "email";
    private String address = "address";
    private String password = "password";

    public SupplierTable() {

    }

    public SupplierTable(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+ tableName+"(" +
                supp_id+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                fname+" VARCHAR(30) NOT NULL,"+
                lname+" VARCHAR(30) NOT NULL,"+
                email+" VARCHAR(30) NOT NULL UNIQUE,"+
                address+" VARCHAR(80),"+
                mobile+" VARCHAR(10) NOT NULL,"+
                password+" VARCHAR(30) NOT NULL"+
                ");";
        sqLiteDatabase.execSQL(sql);
    }

    public SupplierTable(String fname, String lname, String email, String address,String mobile,String password) {
        this.fname = fname;
        this.lname = lname;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.password=password;
    }

    public String getTableName() {
        return tableName;
    }


    public String getSupp_id() {
        return supp_id;
    }
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
