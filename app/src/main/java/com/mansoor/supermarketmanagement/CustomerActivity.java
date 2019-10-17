package com.mansoor.supermarketmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mansoor.supermarketmanagement.Database.CustomerTable;
import com.mansoor.supermarketmanagement.Database.DataBaseHelper;
import com.mansoor.supermarketmanagement.Database.EmployeeTable;

public class CustomerActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mfname;
    private EditText mlname;
    private EditText memail;
    private EditText mmobile;
    private EditText mdob;
    private EditText mgender;
    private Button mbutton;
    private EditText mpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        mfname=findViewById(R.id.customer_fname);
        mlname=findViewById(R.id.customer_lname);
        memail=findViewById(R.id.customer_email);
        mpassword=findViewById(R.id.customer_password);
        mmobile=findViewById(R.id.customer_mobile);
        mdob=findViewById(R.id.customer_dob);
        mgender=findViewById(R.id.customer_gender);
        mbutton=findViewById(R.id.customer_button);
        mbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==mbutton.getId())
        {
            DataBaseHelper dataBaseHelper=DataBaseHelper.getInstance(this);
            CustomerTable customerTable=new CustomerTable(mfname.getText().toString(),mlname.getText().toString(),memail.getText().toString(),mpassword.getText().toString(),mmobile.getText().toString(),mdob.getText().toString(),mgender.getText().toString());
            if(dataBaseHelper.addCustomerData(customerTable))
            {
                Toast.makeText(this, "Employee Details added successfull!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
            }
            else
                Toast.makeText(this,"Error is storing employee details",Toast.LENGTH_SHORT).show();
        }

    }
}
