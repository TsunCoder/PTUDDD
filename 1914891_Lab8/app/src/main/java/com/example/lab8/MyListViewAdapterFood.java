package com.example.lab8;

import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListViewAdapterFood extends BaseAdapter {
    ArrayList<Food> list;
    public MyListViewAdapterFood(ArrayList<Food> list){
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(parent.getContext(), R.layout.cus_lv_layout_bt1,null);
        Food food = (Food) getItem(position);
        ImageView img = view.findViewById(R.id.imgRowFood);
        img.setImageResource(food.image);
        TextView txtNameFood = view.findViewById(R.id.txtNameFood);
        txtNameFood.setText(food.nameFood);
        TextView txtDescription = view.findViewById(R.id.txtDescription);
        txtDescription.setText(food.description);
        TextView txtPrice = view.findViewById(R.id.txtPrice);
        txtPrice.setText(food.price);
        return view;

    }
}
