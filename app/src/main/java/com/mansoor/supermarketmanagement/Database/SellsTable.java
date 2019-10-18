package com.mansoor.supermarketmanagement.Database;

import android.database.sqlite.SQLiteDatabase;

public class SellsTable {
        private String tableName = "sells";
        private String supp_id = "supp_id";
        private String stock_id = "stock_id";

        public SellsTable() {}

        public SellsTable(SQLiteDatabase sqLiteDatabase) {
            String sql = "CREATE TABLE "+tableName+"(" +
                    "supp_id INTEGER(6) REFERENCES supplier(supp_id) ON DELETE CASCADE ON UPDATE CASCADE," +
                    "stock_id INTEGER(6) REFERENCES stock(stock_id) ON DELETE CASCADE ON UPDATE CASCADE," +
                    "PRIMARY KEY(supp_id,stock_id)" +
                    ");";
            sqLiteDatabase.execSQL(sql);
        }

        public SellsTable(String supp_id, String stock_id) {
            this.supp_id = supp_id;
            this.stock_id = stock_id;
        }

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public String getSupp_id() {
            return supp_id;
        }

        public void setSupp_id(String supp_id) {
            this.supp_id = supp_id;
        }

        public String getStock_id() {
            return stock_id;
        }

        public void setStock_id(String stock_id) {
            this.stock_id = stock_id;
        }
}
