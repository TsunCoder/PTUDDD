package com.example.lab8;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListViewAdapter extends BaseAdapter {
    ArrayList<Product> list;
    public MyListViewAdapter(ArrayList<Product> list){
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        View view = View.inflate(parent.getContext(), R.layout.cus_lv_layout,null);
        Product product = (Product) getItem(position);
        ImageView img = view.findViewById(R.id.imgRow);
        img.setImageResource(product.image);
        TextView txtTitles = view.findViewById(R.id.txtTitle);
        txtTitles.setText(product.title);
        TextView txtContent = view.findViewById(R.id.txtContent);
        txtContent.setText(product.content);
        return view;
    }
}
