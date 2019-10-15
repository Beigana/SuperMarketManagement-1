package com.mansoor.supermarketmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mansoor.supermarketmanagement.Database.DataBaseHelper;
import com.mansoor.supermarketmanagement.Database.PaymentTable;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mmode;
    private Button mpaymentButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        mmode=findViewById(R.id.payment_mode);
        mpaymentButton=findViewById(R.id.payment_button);
        mpaymentButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        PaymentTable paymentTable=new PaymentTable(mmode.getText().toString());
        DataBaseHelper dataBaseHelper=DataBaseHelper.getInstance(this);
        if(dataBaseHelper.addPaymentData(paymentTable)) {
            Toast.makeText(this, "Payment Data added successfull!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
            Toast.makeText(this,"Payment Data not",Toast.LENGTH_SHORT).show();
    }
}
