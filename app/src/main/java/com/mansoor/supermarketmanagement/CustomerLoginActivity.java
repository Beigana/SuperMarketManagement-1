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
import android.widget.Toast;

import com.mansoor.supermarketmanagement.Database.DataBaseHelper;

public class CustomerLoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText memail;
    private EditText mpassword;
    private Button mloginbutton;
    private Button msignupbutton;
    private DataBaseHelper databaseHelper;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        memail=findViewById(R.id.cusomer_login_email);
        mpassword=findViewById(R.id.cusomer_login_password);
        mloginbutton=findViewById(R.id.cusomer_login_button);
        msignupbutton=findViewById(R.id.cusomer_login_signup_button);
        mloginbutton.setOnClickListener(this);
        msignupbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==mloginbutton.getId())
        {
            String email=memail.getText().toString();
            String password=mpassword.getText().toString();
            if(email.isEmpty()){
                Toast.makeText(this, "User name Field Empty", Toast.LENGTH_LONG).show();
            }
            if(password.isEmpty()){
                Toast.makeText(this, "Username or Password Field Empty", Toast.LENGTH_LONG).show();
            }
            if(!email.isEmpty() && !password.isEmpty()){

                verifyUser();
            }

        }
        else if(view.getId()==msignupbutton.getId())
        {
            Intent intent = new Intent(this, CustomerActivity.class);
            startActivity(intent);
            finish();
        }
    }
    private void verifyUser()
    {
        databaseHelper= DataBaseHelper.getInstance(this);
        Cursor cursor=databaseHelper.getDataFromCustomerTable();
        if(cursor!=null && cursor.moveToFirst())
        {
            do{
                String id=cursor.getString(0);
                String email=cursor.getString(3);
                String password=cursor.getString(4);
                String name=cursor.getString(1);
                if(email.equals(memail.getText().toString()) && password.equals(mpassword.getText().toString()))
                {
                    //storing name and id into shared preferences for makin session of logged in user.
                    sharedPreferences=getSharedPreferences("supermarket", Context.MODE_PRIVATE);
                    sharedPreferences.edit().putString("cus_id",id).apply();
                    sharedPreferences.edit().putString("cus_name",name).apply();
                    Toast.makeText(this,"Welcome "+name+ "!!",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(this,ProductDisplayActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }while(cursor.moveToNext());
            cursor.close();
        }
        Toast.makeText(this,"Entered Credentials are not correct",Toast.LENGTH_SHORT).show();
    }
}
