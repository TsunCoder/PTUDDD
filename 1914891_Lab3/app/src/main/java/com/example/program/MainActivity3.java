package com.example.program;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {
    TextView tv_viet, tv_anh, tv_phap,tv_hello, tv_register;
    Button btnLogin;
    EditText et_Email, et_Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Multi Language App");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        changeLanguage();
    }

    public void changeLanguage(){
        tv_viet = findViewById(R.id.tv_viet);
        tv_anh = findViewById(R.id.tv_anh);
        tv_phap = findViewById(R.id.tv_phap);
        tv_hello = findViewById(R.id.tv_hello);
        tv_register = findViewById(R.id.tv_register);
        btnLogin = findViewById(R.id.btnLogin);
        et_Email = findViewById(R.id.et_Email);
        et_Pass = findViewById(R.id.et_Pass);

        tv_viet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ganNN("vi");
            }
        });

        tv_anh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ganNN("en");
            }
        });

        tv_phap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ganNN("fr");
            }
        });
    }

        public void ganNN(String language){
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(
                config,getBaseContext().getResources().getDisplayMetrics()
        );

        Intent intent = new Intent(MainActivity3.this, MainActivity3.class);
        startActivity(intent);
    }
}