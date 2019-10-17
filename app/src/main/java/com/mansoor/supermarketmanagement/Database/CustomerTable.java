package com.mansoor.supermarketmanagement.Database;

import android.database.sqlite.SQLiteDatabase;

public class CustomerTable {
    private String tableName="customer";
    private String cus_id="cus_id";
    private String fname="fname";
    private String lname="lname";
    private String email="email";
    private String password="password";
    private String mobile="mobile";
    private String dob="dob";
    private String gender="gender";


    public CustomerTable()
    {
    }
    public CustomerTable(SQLiteDatabase sqLiteDatabase)
    {
        String sql ="CREATE TABLE "+tableName+"("+
                cus_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                fname+" VARCHAR(30) NOT NULL,"+
                lname+" VARCHAR(30) NOT NULL,"+
                email+" VARCHAR(40) NOT NULL UNIQUE,"+
                password+" VARCHAR(30) NOT NULL,"+
                mobile+" VARCHAR(10),"+
                gender+" CHAR ,"+
                dob+" DATE,"+
                "CONSTRAINT gender_check CHECK (gender IN ('F','M')),CONSTRAINT dob_check CHECK (dob>'1900-01-01')"+
                ");";
        sqLiteDatabase.execSQL(sql);
    }

    public CustomerTable(String fname, String lname, String email,String password, String mobile, String dob, String gender) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.mobile = mobile;
        this.dob = dob;
        this.gender = gender;
        this.password=password;
    }

    public String getTableName() {
        return tableName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
