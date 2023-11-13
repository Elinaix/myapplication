package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    Button button3;
    TextView textView,textView1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        textView=findViewById(R.id.textView12);
        textView1=findViewById(R.id.textView13);

        button3=findViewById(R.id.button3);
        Intent intent=getIntent();
        String str1=intent.getExtras().getString("name");
        textView.setText(str1);
        String str2= intent.getExtras().getString("author");
        textView1.setText(str2);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Log.d("xr","3:onCreate...");//调试页面显示
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("xr","3:onPause...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("xr","3:onDestroy...");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("xr","3:onStop...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("xr","3:onRestart...");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("xr","3:onResume...");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("xr","3:onStart...");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("xr","3:onPostResume...");
    }
}