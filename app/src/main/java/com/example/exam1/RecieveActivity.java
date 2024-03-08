package com.example.exam1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RecieveActivity extends AppCompatActivity {

    Button b,b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recieve);
        intial();
        ButtonClick();

    }
    private void ButtonClick() {
        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UnsafeIntentLaunch")
            @Override
            public void onClick(View v) {
                Intent i=getIntent();
                String Name=i.getStringExtra("Name");
                Toast.makeText(getApplicationContext(),Name,Toast.LENGTH_LONG).show();
                setResult(RESULT_OK,i);
                i.putExtra("REQUEST CODE",1);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UnsafeIntentLaunch")
            @Override
            public void onClick(View v) {

                Intent i=getIntent();
                String Name=i.getStringExtra("Name");
                Toast.makeText(getApplicationContext(),Name,Toast.LENGTH_LONG).show();
                String data = "additionalData"; // Example additional data to be returned
                i.putExtra("key", data); // Put extra data into the intent (optional)
                setResult(RESULT_CANCELED, i); // Set the result code and intent
                finish();

            }
        });
    }
    private void intial() {
        b=findViewById(R.id.success);
        b1=findViewById(R.id.unsuccess);

    }

}