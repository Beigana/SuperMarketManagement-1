package com.mansoor.supermarketmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mansoor.supermarketmanagement.Utility.MyAdapterUtility;

public class ProductInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mproduct_id;
    private TextView mname;
    private TextView mprice;
    private TextView mdescription;
    private Button mbutton;
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
    }

    //   ADD TO CART BUTTON
    @Override
    public void onClick(View view) {
        //Get Stock ID
        String stock_id= MyAdapterUtility.getStockIDforProduct();
        Toast.makeText(this, stock_id, Toast.LENGTH_SHORT).show();

    }
}
