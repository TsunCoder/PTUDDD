package com.example.lab5;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Random;

public class Ex1Activity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivAnimals;

    final int[] anim = {R.anim.alpha,R.anim.rotate,R.anim.scale,R.anim.translate};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);
        initView();
    }
    private void initView(){
        ivAnimals = findViewById(R.id.iv_animal);
        findViewById(R.id.btn_alpha).setOnClickListener(this);
        findViewById(R.id.btn_scale).setOnClickListener(this);
        findViewById(R.id.btn_trans).setOnClickListener(this);
        findViewById(R.id.btn_rotate).setOnClickListener(this);
        findViewById(R.id.iv_animal).setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_alpha){
            ivAnimals.startAnimation(AnimationUtils.loadAnimation(this,R.anim.alpha));
        }
        else if(view.getId() == R.id.btn_rotate){
            ivAnimals.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate));
        }
        else if(view.getId() == R.id.btn_scale){
            ivAnimals.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
        }
        else if(view.getId() == R.id.btn_trans){
            ivAnimals.startAnimation(AnimationUtils.loadAnimation(this,R.anim.translate));
        }
        else {
        Random random = new Random();
        view.startAnimation(AnimationUtils.loadAnimation(this,anim[random.nextInt(anim.length)]));
        }
    }
}