package com.mansoor.supermarketmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mansoor.supermarketmanagement.Database.ContainsTable;
import com.mansoor.supermarketmanagement.Database.DataBaseHelper;
import com.mansoor.supermarketmanagement.Database.PaysTable;
import com.mansoor.supermarketmanagement.Database.ShoppingCartTable;
import com.mansoor.supermarketmanagement.Utility.MyAdapterUtility;

public class ProductInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mproduct_id;
    private TextView mname;
    private TextView mprice;
    private TextView mdescription;
    private EditText mquantiy;
    private Button mbutton;
    String stock_id;
    String produt_id;
    String name;
    String price;
    String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);
        mproduct_id=findViewById(R.id.product_info_id);
        mname=findViewById(R.id.product_info_productname);
        mprice=findViewById(R.id.product_info_price);
        mdescription=findViewById(R.id.product_info_description);
        mbutton=findViewById(R.id.product_info_buyproduct_button);
        mbutton.setOnClickListener(this);
        mquantiy=findViewById(R.id.product_info_quantity);
        displayProduct();
    }

    //   ADD TO CART BUTTON
    @Override
    public void onClick(View view) {
        int quantity=Integer.parseInt(mquantiy.getText().toString());
        DataBaseHelper dataBaseHelper=DataBaseHelper.getInstance(this);
        //Toast.makeText(this, mquantiy.getText().toString(), Toast.LENGTH_SHORT).show();
        //checking and deducting quantity from stock as well as product & entering in cart table:
        Cursor cursor=dataBaseHelper.getDataFromTable("stock","where stock_id="+stock_id);
        Toast.makeText(this, stock_id, Toast.LENGTH_SHORT).show();
        if(cursor!=null && cursor.moveToFirst())
        {
            int stock_quantity=Integer.parseInt(cursor.getString(2));
            if(quantity>stock_quantity)
            {
                Toast.makeText(this,"Not sufficient quantiy",Toast.LENGTH_SHORT).show();
                return;
            }
            else
            {
                //deducting quantiy from stock & deleting product rows from product:
                dataBaseHelper.updateTableData("update stock set  quantity="+(stock_quantity-quantity));
                for(int i=0;i<quantity;i++)
                {
                    String product_id;
                    cursor=dataBaseHelper.getDataFromTable("product","where stock_id="+stock_id);
                    if(cursor!=null && cursor.moveToFirst())
                    {
                        product_id=cursor.getString(0);
                        dataBaseHelper.updateTableData("delete from product where product_id="+product_id);
                    }
                }
                if(dataBaseHelper.addShoppingData(new ShoppingCartTable("0")))
                {
                    String cus_id;
                    SharedPreferences sharedPreferences=getSharedPreferences("supermarket", Context.MODE_PRIVATE);
                    cus_id=sharedPreferences.getString("cus_id","");
                    String cart_id;
                    //get cart_id:
                    cursor=dataBaseHelper.getDataFromTable("shopping_cart");
                    cursor.moveToLast();
                    cart_id=cursor.getString(0);
                    if(dataBaseHelper.addPaysData(new PaysTable(cus_id,null,cart_id))) {
                        if (dataBaseHelper.addContainsData(new ContainsTable(produt_id, cart_id, Integer.toString(quantity)))) {
                            Toast.makeText(this, "Added to cart successfully!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        }

        //Storing in shopping cart if product quantiy is available :



    }
    void displayProduct()
    {
        //Get Stock ID
        stock_id= MyAdapterUtility.getStockIDforProduct();
        //Toast.makeText(this, stock_id, Toast.LENGTH_SHORT).show();
        DataBaseHelper dataBaseHelper=DataBaseHelper.getInstance(this);
        Cursor cursor=dataBaseHelper.getDataFromTable("product","where stock_id="+stock_id);
        if(cursor!=null && cursor.moveToFirst())
        {
            produt_id=cursor.getString(0);
            name=cursor.getString(1);
            price=cursor.getString(2);
            description=cursor.getString(4);
            mproduct_id.setText(produt_id);
            mname.setText(name);
            mprice.setText(price);
            mdescription.setText(description);
        }
    }
}
