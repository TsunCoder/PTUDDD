package com.example.lab8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityBT1 extends AppCompatActivity {
    String[] nameFood = new String[]{"Hamberger","Bánh mì","Bánh bao","Bánh ú","Bánh giò chay","Bánh giò nhân thịt","Bánh đa cua","Bún bò Huế"};
    String[] description = new String[]{"Bánh mì kẹp thịt tròn","Bánh mì kẹp thịt","Bánh bao nhân thịt, trứng",
                                        "Bánh ú dùng cho lễ, tết","Bánh giò chay bằng nếp hoặc tẻ", "Bánh giò nếp, tẻ có nhân thịt",
                                        "Đặc sản Hải Phòng","Đặc sản xứ Huế"};
    String[] price = new String[]{"30.000đ","20.000","15.000","50.000","70.000","90.000","150.000","50.000"};
    int[] imgs = new int[]{R.drawable.hamburger,R.drawable.banhmi, R.drawable.banhbao, R.drawable.banhu,
                            R.drawable.banhgiochay, R.drawable.banhgiothit,R.drawable.banhdacua,R.drawable.bunbohue };
    ArrayList<Food> list1;
    ListView lvMainFood;
    MyListViewAdapterFood adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bt1);

        lvMainFood = (ListView) findViewById(R.id.lvMainBt1);

        list1 = new ArrayList<>();
        for (int i = 0; i < nameFood.length; i++){
            list1.add(new Food(imgs[i],nameFood[i],description[i], "Giá: " + price[i]));
        }
        adapter = new MyListViewAdapterFood(list1);
        lvMainFood.setAdapter(adapter);
        registerForContextMenu(lvMainFood);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu_lv,menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemAdd:
                Fragment_Add fragment_add = new Fragment_Add();
                fragment_add.show(getSupportFragmentManager(),"Thêm");
                break;
            case R.id.itemThoat:
                MainActivityBT1.this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.updateItem:
                break;
            case R.id.removeItem:
                list1.remove(info.position);
                adapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }
}