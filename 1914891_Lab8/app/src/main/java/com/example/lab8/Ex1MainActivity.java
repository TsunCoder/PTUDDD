package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Ex1MainActivity extends AppCompatActivity {
    String[] titles = new String[]{"Android","iOS","Window Phone"};
    String[] contents = new String[]{"Đây là hệ điều hành Android",
                                    "Đây là hệ điều hành iOS",
                                    "Đây là hệ điều hành Window Phone"};
    int[] imgs = new int[]{R.drawable.android, R.drawable.ios, R.drawable.windowphone};
    ListView lvMain;
    TextView txtDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex1_activity_main);

        lvMain = findViewById(R.id.lvMain);
        txtDisplay = findViewById(R.id.txtDisplay);

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arr);
        ArrayList<Product> list = new ArrayList<>();
        for (int i = 0; i < titles.length; i++){
            list.add(new Product(imgs[i],titles[i],contents[i]));
        }
        MyListViewAdapter adapter = new MyListViewAdapter(list);
        lvMain.setAdapter(adapter);
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtDisplay.setText("Bạn chọn: " + titles[i]);
                txtDisplay.setGravity(Gravity.CENTER);
            }
        });


    }
}