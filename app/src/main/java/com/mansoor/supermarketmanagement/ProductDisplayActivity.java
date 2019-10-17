package com.mansoor.supermarketmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.mansoor.supermarketmanagement.Adapter.MyAdapter;
import com.mansoor.supermarketmanagement.Database.DataBaseHelper;

public class ProductDisplayActivity extends AppCompatActivity {
    private Cursor cursor;
    private RecyclerView mrecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_display);
        mrecyclerview=findViewById(R.id.product_display_recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,true);
        mrecyclerview.setLayoutManager(linearLayoutManager);
        mrecyclerview.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        final DataBaseHelper databaseHelper=DataBaseHelper.getInstance(this);
        cursor=databaseHelper.getDataFromTable("stock");
        if(cursor!=null )
        {
            MyAdapter myAdapter=new MyAdapter(this,cursor);
            mrecyclerview.setAdapter(myAdapter);
        }
    }
}
