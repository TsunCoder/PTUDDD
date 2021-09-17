package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;
import java.util.Random;

public class FaceEmoijActivity extends Fragment implements View.OnClickListener {
    private static final int[] ids = {R.id.iv_face1, R.id.iv_face2, R.id.iv_face3, R.id.iv_face4,
            R.id.iv_face5, R.id.iv_face6, R.id.iv_face7, R.id.iv_face8, R.id.iv_face9};
    private Context mContext;

    Button btnRandomIc;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m001_frg_face_emoij,container,false);
        initView(rootView);

        btnRandomIc = (Button) rootView.findViewById(R.id.btn_RandomIC);

        btnRandomIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                ImageView ivFace = rootView.findViewById(ids[random.nextInt(ids.length)]);
                showToast(ivFace.getDrawable());
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        mContext = context;
        super.onAttach(context);
    }

    @Override
    public void onClick(View v) {
        ImageView ivFace = (ImageView) v;
        showToast(ivFace.getDrawable());
    }

    private void initView(View v){
        for(int id : ids){
            v.findViewById(id).setOnClickListener(this);
        }

    }

    private void showToast(Drawable drawable){
        Toast toast = new Toast(mContext);
        ImageView ivEmoji = new ImageView(mContext);
        ivEmoji.setImageDrawable(drawable);
        toast.setView(ivEmoji);
        toast.show();
    }
}
