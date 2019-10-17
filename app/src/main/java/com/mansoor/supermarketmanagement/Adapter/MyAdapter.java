package com.mansoor.supermarketmanagement.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mansoor.supermarketmanagement.Database.ProductTable;
import com.mansoor.supermarketmanagement.R;
import com.mansoor.supermarketmanagement.Utility.MyAdapterUtility;

import java.sql.DriverPropertyInfo;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private ArrayList<ProductTable> productTableArrayList;
    private int flag=0;
    private Cursor cursor;
    private Context context;
    public MyAdapter(Context context,Cursor cursor) {
        this.cursor=cursor;
        this.context=context;
        cursor.moveToFirst();
        flag=0;
    }
    public MyAdapter(Context context,ArrayList<ProductTable> productTableArrayList) {
        this.productTableArrayList=productTableArrayList;
        this.context=context;
        flag=1;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.recycler_cell,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i) {
       /* final String product_name;
        final String product_id;
        final String product_price;
        final String product_description;*/
       final String stock_id;
       String stock_name;
        //if(flag==0) {
            cursor.moveToPosition(i);
            /*product_id = cursor.getString(0);
            product_name = cursor.getString(1);
            product_price = cursor.getString(2);
            product_description = cursor.getString(4);*/
            stock_id=cursor.getString(0);
            stock_name=cursor.getString(1);
            viewHolder.mproduct_name.setText(stock_name);
        //}
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ProductTable productTable=new ProductTable(product_name,product_price,product_description);
                //productTable.setProduct_id(product_id);
                Intent intent = new Intent(context, DriverPropertyInfo.class);
                //intent.putExtra("PropertyTable_object",propertyTableData);
                new MyAdapterUtility(stock_id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView mproduct_name;
        Button mbutton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //mimageview=itemView.findViewById(R.id.recycler_cell_imageView);
            mproduct_name=itemView.findViewById(R.id.recycler_cell_product_name);
            mbutton=itemView.findViewById(R.id.recycler_cell_button);
        }
    }
}
