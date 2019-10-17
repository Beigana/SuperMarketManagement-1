package com.mansoor.supermarketmanagement.Database;

import android.database.sqlite.SQLiteDatabase;

public class EmployeeTable {
    private String tableName="employee";
    private String emp_id="emp_id";
    private String fname="fname";
    private String lname="lname";
    private String email="email";
    private String mobile="mobile";
    private String address="address";
    private String gender="gender";
    private String salary="salary";
    private String super_id="super_id";
    //private String sec_id="sec_id";

    public EmployeeTable()
    {
    }
    public EmployeeTable(SQLiteDatabase sqLiteDatabase)
    {
        String sql = "CREATE TABLE "+ tableName+"(" +
                emp_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                fname+" VARCHAR(30) NOT NULL,"+
                lname+" VARCHAR(30) NOT NULL,"+
                email+" VARCHAR(30) UNIQUE NOT NULL,"+
                mobile+" VARCHAR(10) NOT NULL,"+
                address+" VARCHAR(80),"+
                gender+" CHAR CHECK (gender IN ('F','M')),"+
                salary+" FLOAT CHECK (salary>0),"+
                super_id+" INTEGER(6) REFERENCES employee(emp_id) ON DELETE SET NULL ON UPDATE CASCADE"+
                /*sec_id+" INTEGER(6)  NOT NULL REFERENCES section(sec_id) ON DELETE SET NULL ON UPDATE CASCADE"+*/
                ");";
        sqLiteDatabase.execSQL(sql);
    }

    public EmployeeTable(String fname, String lname, String email, String mobile, String address, String gender, String salary, String super_id)
    {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.gender = gender;
        this.salary = salary;
        this.super_id = super_id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSuper_id() {
        return super_id;
    }

    public void setSuper_id(String super_id) {
        this.super_id = super_id;
    }

    /*public String getSec_id() {
        return sec_id;
    }

    public void setSec_id(String sec_id) {
        this.sec_id = sec_id;
    }*/
}
