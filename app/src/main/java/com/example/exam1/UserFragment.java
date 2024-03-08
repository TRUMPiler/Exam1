package com.example.exam1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class UserFragment extends Fragment {

    TextView showinfo;
    Button sendinfo;
    View v;
    String ContactGG;
    public void displayGG(String Name,String City,String Contact,String Choice,String Gender)
    {
        showinfo.setVisibility(View.VISIBLE);
        showinfo.setText("Name:"+Name+"\n"+"ContactNo:"+Contact+"\n"+"Gender:"+Gender+"\n"+"City:"+City+"\n"+"Intrests:"+Choice+"\n");
        sendinfo.setVisibility(View.VISIBLE);
        ContactGG=Contact;
        ButtonClick();
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private void ButtonClick() {
        sendinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+ContactGG));
                i.putExtra("sms_body",showinfo.getText().toString());
                startActivity(i);
            }
        });
    }

    private void intial() {
        sendinfo=v.findViewById(R.id.sendsms);
        showinfo=v.findViewById(R.id.ViewInfo);
    }
    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v= inflater.inflate(R.layout.fragment_user, container, false);
         intial();
        return v;
    }

}