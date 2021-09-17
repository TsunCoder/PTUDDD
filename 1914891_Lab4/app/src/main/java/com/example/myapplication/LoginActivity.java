package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText et_email, et_pass;
    TextView tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m001_act_login);
        login();
    }

    private void login(){
        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        tv_login = findViewById(R.id.tv_login);

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(LoginActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.ll_toast));
                TextView tv_Message = view.findViewById(R.id.tv_toast);
                tv_Message.setText(new StringBuilder().append("Bạn đã đăng nhập thành công với Email: ").append(et_email.getText()).append("\nMật khẩu: ").append(et_pass.getText()).toString());
                toast.setView(view);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });

    }
}