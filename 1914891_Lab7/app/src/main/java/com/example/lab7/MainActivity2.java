package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    View viewRGB, viewCMY;
    TextView tv_R, tv_G, tv_B;
    SeekBar sbR, sbG, sbB;

    int red = 0, green = 0, blue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    private void init(){
        viewRGB = findViewById(R.id.viewRgb);
        viewCMY = findViewById(R.id.viewCmy);
        tv_R = findViewById(R.id.tv_R);
        tv_G = findViewById(R.id.tv_G);
        tv_B = findViewById(R.id.tv_B);
        sbR = findViewById(R.id.seekbar1);
        sbG = findViewById(R.id.seekbar2);
        sbB = findViewById(R.id.seekbar3);

        // R
        sbR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBar.getId();
                red = i;
                viewRGB.setBackgroundColor(Color.rgb(red,green,blue));
                viewCMY.setBackgroundColor(Color.rgb(255 - red,255 - green,255 - blue));
                tv_R.setText(String.format("R = ") + red);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // G
        sbG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBar.getId();
                green = i;
                viewRGB.setBackgroundColor(Color.rgb(red,green,blue));
                viewCMY.setBackgroundColor(Color.rgb(255 - red,255 - green,255 - blue));
                tv_G.setText(String.format("R = ") + green);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        // B
        sbB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBar.getId();
                blue = i;
                viewRGB.setBackgroundColor(Color.rgb(red,green,blue));
                viewCMY.setBackgroundColor(Color.rgb(255 - red,255 - green,255 - blue));
                tv_B.setText(String.format("R = ") + blue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}