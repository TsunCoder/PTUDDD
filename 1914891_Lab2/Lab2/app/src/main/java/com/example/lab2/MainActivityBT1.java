package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

public class MainActivityBT1 extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bt1);
        Random random = new Random();
        int color = Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
        findViewById(android.R.id.content).setBackgroundColor(color);

        randomImg();
    }
    private void randomImg(){
        // random image
        Random ran = new Random();
        imageView = findViewById(R.id.imageView);
        int[] images= {R.drawable.ic_fire,R.drawable.ic_gta,R.drawable.ic_penguin,R.drawable.ic_americanfootball,
                R.drawable.ic_football, R.drawable.ic_boxinggloves};
        imageView.setImageResource(images[ran.nextInt(images.length)]);
    }
}