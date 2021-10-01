package com.example.lab8;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.net.URI;
import java.util.ArrayList;

public class Fragment_Add extends DialogFragment {

    Button btnAddImage, btnSaveItem;
    ImageView imageFood;
    EditText txtFood, txtMota, txtGia;
    int SELECT_IMAGE_CODE = 1;
    ArrayList<Food> list1;
    MyListViewAdapterFood adapter;
    Food food;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_food_layout,container,false);
        btnAddImage = (Button) view.findViewById(R.id.btnAddImage);
        imageFood = (ImageView) view.findViewById(R.id.imageFood);
        imageFood.setImageDrawable(imageFood.getDrawable());

        btnSaveItem = (Button) view.findViewById(R.id.btnSaveItem);

        txtFood = (EditText) view.findViewById(R.id.txtFood);
        txtMota = (EditText) view.findViewById(R.id.txtMota);
        txtGia = (EditText) view.findViewById(R.id.txtGia);


        btnAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,SELECT_IMAGE_CODE);
            }
        });

        btnSaveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addFoodName = txtFood.getText().toString(),
                        addMota = txtMota.getText().toString(),
                        addGia = txtGia.getText().toString();
                list1.add(food);
                adapter.notifyDataSetChanged();

            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            Uri uri = data.getData();
            imageFood.setImageURI(uri);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

}
