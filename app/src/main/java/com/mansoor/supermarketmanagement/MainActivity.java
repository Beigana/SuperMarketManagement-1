package com.mansoor.supermarketmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mansoor.supermarketmanagement.Database.CustomerTable;
import com.mansoor.supermarketmanagement.Database.DataBaseHelper;
import com.mansoor.supermarketmanagement.Database.PaymentTable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DataBaseHelper dataBaseHelper;
    private Button mpayment;
    private Button memployee;
    private Button mcustomer;
    private Button mpopulateTable;
    private Button mlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mpayment=findViewById(R.id.main_payment_button);
        mpayment.setOnClickListener(this);
        memployee=findViewById(R.id.main_employee_button);
        memployee.setOnClickListener(this);
        mcustomer=findViewById(R.id.main_customer_button);
        mcustomer.setOnClickListener(this);
        mpopulateTable=findViewById(R.id.main_populate_table);
        mpopulateTable.setOnClickListener(this);
        mlogout=findViewById(R.id.main_logout);
        mlogout.setOnClickListener(this);

        /*DataBaseHelper dataBaseHelper=DataBaseHelper.getInstance(this);
        PaymentTable paymentTable=new PaymentTable("electonic");
        if(dataBaseHelper.addPaymentData(paymentTable))
            Toast.makeText(this,"Payment Data added successfull!!",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Payment Data not",Toast.LENGTH_SHORT).show();
        paymentTable=new PaymentTable("electonic2");
        dataBaseHelper.addPaymentData(paymentTable);*/
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==mpayment.getId())
        {
            Intent intent =new Intent(this,PaymentActivity.class);
            startActivity(intent);
        }
        if(view.getId()==memployee.getId())
        {
            Intent intent =new Intent(this,EmployeeActivity.class);
            startActivity(intent);
        }
        if(view.getId()==mcustomer.getId())
        {
            Intent intent =new Intent(this, CustomerLoginActivity.class);
            startActivity(intent);
        }
        //Populating Table with initial data
        if(view.getId()==mpopulateTable.getId())
        {
            dataBaseHelper=DataBaseHelper.getInstance(this);
            if(dataBaseHelper.populateTable(this))
                Toast.makeText(this,"Table populated successfully",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"Table populated successfully",Toast.LENGTH_SHORT).show();
        }
        if(view.getId()==mlogout.getId())
        {
            SharedPreferences sharedPreferences=getSharedPreferences("supermarket", Context.MODE_PRIVATE);
            sharedPreferences.edit().clear().commit();
            Toast.makeText(this,"Logout Successfull",Toast.LENGTH_SHORT).show();
        }
    }
}
