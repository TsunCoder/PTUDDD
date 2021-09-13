package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imagePhoto;
    Button btnTapToRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        innitControl();
    }

    private void innitControl(){
        imagePhoto = findViewById(R.id.imgPhoto);
        btnTapToRoll = findViewById(R.id.btnTapToRoll);
        btnTapToRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int number = random.nextInt(6) + 1;
                if(number == 1)
                {
                    imagePhoto.setImageResource(R.drawable.dice1);
                }
                else if( number == 2)
                {
                    imagePhoto.setImageResource(R.drawable.dice2);
                }
                else if(number == 3){
                    imagePhoto.setImageResource(R.drawable.dice3);
                }
                else if(number == 4){
                    imagePhoto.setImageResource(R.drawable.dice4);
                }
                else if(number == 5){
                    imagePhoto.setImageResource(R.drawable.dice5);
                }
                else {
                    imagePhoto.setImageResource(R.drawable.dice6);
                }
            }
        });

        imagePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int number = random.nextInt(6) + 1;
                if(number == 1)
                {
                    imagePhoto.setImageResource(R.drawable.dice1);
                }
                else if( number == 2)
                {
                    imagePhoto.setImageResource(R.drawable.dice2);
                }
                else if(number == 3){
                    imagePhoto.setImageResource(R.drawable.dice3);
                }
                else if(number == 4){
                    imagePhoto.setImageResource(R.drawable.dice4);
                }
                else if(number == 5){
                    imagePhoto.setImageResource(R.drawable.dice5);
                }
                else {
                    imagePhoto.setImageResource(R.drawable.dice6);
                }
            }
        });
    }
}