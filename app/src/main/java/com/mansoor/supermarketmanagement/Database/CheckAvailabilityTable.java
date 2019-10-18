package com.mansoor.supermarketmanagement.Database;

import android.database.sqlite.SQLiteDatabase;

public class CheckAvailabilityTable {
        private String tableName = "checkAvailability";
        private String stock_id = "stock_id";
        private String cart_id = "cart_id";

        public CheckAvailabilityTable() {}

        public CheckAvailabilityTable(SQLiteDatabase sqLiteDatabase) {
            String sql = "CREATE TABLE "+tableName+"(" +
                    "stock_id INTEGER(6)  REFERENCES stock(stock_id) ON DELETE CASCADE ON UPDATE CASCADE," +
                    "cart_id INTEGER(6)  REFERENCES shopping_cart(cart_id) ON DELETE CASCADE ON UPDATE CASCADE," +
                    "PRIMARY KEY(stock_id,cart_id)" +
                    ");";

            sqLiteDatabase.execSQL(sql);
        }

        public CheckAvailabilityTable(String stock_id, String cart_id) {
            this.stock_id = stock_id;
            this.cart_id = cart_id;
        }

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public String getStock_id() {
            return stock_id;
        }

        public void setStock_id(String stock_id) {
            this.stock_id = stock_id;
        }

        public String getCart_id() {
            return cart_id;
        }

        public void setCart_id(String cart_id) {
            this.cart_id = cart_id;
        }
}
