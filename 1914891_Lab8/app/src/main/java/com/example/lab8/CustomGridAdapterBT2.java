package com.example.lab8;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomGridAdapterBT2 extends BaseAdapter {
    private List<Album> list;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomGridAdapterBT2(Context context, List<Album> list){
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_item_layout_bt2, null);
            holder = new ViewHolder();
            holder.imageViewAlbum = (ImageView) convertView.findViewById(R.id.imageView_album1);
            holder.albumNameView = (TextView) convertView.findViewById(R.id.textView_albumName);
            holder.populationView = (TextView) convertView.findViewById(R.id.textView_population);
            convertView.setTag(holder);
        }else {
            holder = (CustomGridAdapterBT2.ViewHolder) convertView.getTag();
        }

        Album album = this.list.get(position);
        holder.albumNameView.setText(album.getAlbumName());
        holder.populationView.setText(""+ album.getPopulation());

        int imageld = this.getMipmapResIdByName(album.getImageName());

        holder.imageViewAlbum.setImageResource(imageld);
        return convertView;
    }

    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();

        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomGridView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView imageViewAlbum;
        TextView albumNameView;
        TextView populationView;
    }
}
