package com.example.exam1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class adapter extends ArrayAdapter<String> {
    String title[];
    String Des[];
    int img[];
    public adapter(@NonNull Context context, String titles[],String Desc[],int[] imgs) {
        super(context,R.layout.prodlist,titles);
        this.title=titles;
        Des=Desc;
        img=imgs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.prodlist,null);
        TextView ti=v.findViewById(R.id.title);
        TextView de=v.findViewById(R.id.des);
        ImageView icons=v.findViewById(R.id.icon);
        ti.setText(title[position]);
        de.setText(Des[position]);
        icons.setImageResource(img[position]);
        return v;
    }
}
