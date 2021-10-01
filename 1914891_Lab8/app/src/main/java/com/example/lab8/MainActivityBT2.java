package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivityBT2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bt2);

        List<Album> image_details1 = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(new CustomGridAdapterBT2(this, image_details1));
    }

    private List<Album> getListData() {
        List<Album> list = new ArrayList<Album>();
        Album curtaincall = new Album("Curtain Call", "curtaincall", 9800);
        Album encore = new Album("encore", "encore", 32000);
        Album kamikaze = new Album("Kamikaze", "kamikaze", 142000);
        Album recovery = new Album("Recovery", "recovery", 23305);
        Album revival = new Album("Revival", "revival", 123427);
        Album relapse = new Album("Relapse", "relapse", 812677);
        Album stan = new Album("Stan", "stan", 64567);
        Album theslimshady = new Album("The slim shady", "theslimshady", 78657);
        Album withoutme = new Album("Without me", "withoutme", 437827);
        list.add(curtaincall);
        list.add(encore);
        list.add(kamikaze);
        list.add(recovery);
        list.add(revival);
        list.add(relapse);
        list.add(stan);
        list.add(theslimshady);
        list.add(withoutme);

        return list;
    }
}