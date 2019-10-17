package com.mansoor.supermarketmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mansoor.supermarketmanagement.Database.DataBaseHelper;
import com.mansoor.supermarketmanagement.Database.EmployeeTable;

public class EmployeeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mfname;
    private EditText mlname;
    private EditText memail;
    private EditText mmobile;
    private EditText maddress;
    private EditText mgender;
    private EditText msalary;
    private EditText msuper_id;
    private Button mbutton;
    private EditText msec_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        mfname=findViewById(R.id.emploayee_fname);
        mlname=findViewById(R.id.emploayee_lname);
        memail=findViewById(R.id.emploayee_email);
        mmobile=findViewById(R.id.emploayee_mobile);
        maddress=findViewById(R.id.emploayee_address);
        mgender=findViewById(R.id.emploayee_gender);
        msalary=findViewById(R.id.emploayee_salary);
        msuper_id=findViewById(R.id.emploayee_manager);
        msec_id=findViewById(R.id.emploayee_section);
        mbutton=findViewById(R.id.emploayee_button);
        mbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==mbutton.getId())
        {
            DataBaseHelper dataBaseHelper=DataBaseHelper.getInstance(this);
            EmployeeTable employeeTable=new EmployeeTable(mfname.getText().toString(),mlname.getText().toString(),memail.getText().toString(),mmobile.getText().toString(),maddress.getText().toString(),mgender.getText().toString(),msalary.getText().toString(),msuper_id.getText().toString(),msec_id.getText().toString());
            //employeeTable.setSuper_id(msuper_id.getText().toString());
            if(dataBaseHelper.addEmployeeData(employeeTable))
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
