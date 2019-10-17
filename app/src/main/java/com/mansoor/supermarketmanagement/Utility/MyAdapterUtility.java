package com.mansoor.supermarketmanagement.Utility;

import com.mansoor.supermarketmanagement.Database.DataBaseHelper;
import com.mansoor.supermarketmanagement.Database.ProductTable;

//stores stock_id temporary and pass it to product_info table
public class MyAdapterUtility {
    static String stock_id;
    /*public MyAdapterUtility(ProductTable productTable) {
        this.productTable=productTable;
    }*/
    public MyAdapterUtility(String stock_id) {
        this.stock_id=stock_id;
    }
    public static String getStockIDforProduct()
    {
        return stock_id;
    }

}
