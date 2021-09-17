package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class WordActivity extends AppCompatActivity {
    public static final int[] ID_DRAWABLES = {R.drawable.ic_mess, R.drawable.ic_flight, R.drawable.ic_hospital,
            R.drawable.ic_hotel, R.drawable.ic_restaurant, R.drawable.ic_cocktails,
            R.drawable.ic_store, R.drawable.ic_atwork, R.drawable.ic_clock, R.drawable.ic_education, R.drawable.ic_entertainment};
    public static final int[] ID_TEXTS = {R.string.txt_mess, R.string.txt_flight, R.string.txt_hospital, R.string.txt_hotel, R.string.txt_restaurant, R.string.txt_cocktail,
            R.string.txt_store, R.string.txt_work, R.string.txt_time, R.string.txt_education, R.string.txt_movie};
    String[] vocabulary = {"chat, message, call, call- video, ...", "fly, flight, plane, ...",
                            "nurse, doctor, ambulance, ...", "room, key, halll, staff, ...",
                            "food, drink, eat, vegetable, ...","wine, beer, fruit, soda,...",
                            "gift, book, pen, ...", "employee, boss, headquarter, ...",
                            "clock, haft, hour, minutes, ...","school, student, university, ...",
                            "game, film, movie, ..."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_word);
        initView();
    }

    private void initView(){
        LinearLayout lnMain = findViewById(R.id.ln_main);
        lnMain.removeAllViews();
        for (int i = 0; i < ID_DRAWABLES.length;i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_topic, null);
            ImageView ivTopic = view.findViewById(R.id.iv_topic);
            TextView tvTopic = view.findViewById(R.id.tv_topic);
            ivTopic.setImageResource(ID_DRAWABLES[i]);
            tvTopic.setText(ID_TEXTS[i]);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1.0f
            );
            view.setLayoutParams(params);
            lnMain.addView(view);

            String tuvung = vocabulary[i];
            int hinh = ID_DRAWABLES[i];

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toast = new Toast(WordActivity.this);
                    LayoutInflater inflater = getLayoutInflater();
                    View viewVocab = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.ll_toast));
                    TextView tv_vocab = viewVocab.findViewById(R.id.tv_toast);
                    tv_vocab.setText(tuvung);
                    toast.setView(viewVocab);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }
            });

        }
    }

}