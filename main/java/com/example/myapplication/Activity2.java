package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textView=findViewById(R.id.textView11);

        Intent intent=getIntent();
        //String str=intent.getStringExtra("name")+"-"
        //        +intent.getStringExtra("age");
        String str2=intent.getExtras().getString("name")+"-"+"\n"
                +intent.getExtras().getString("author");

        textView.setText(str2);

        Log.d("xr","2:onCreate...");//调试页面显示
    }


    @Override
    protected void onPause() {
        super.onPause();

        Log.d("xr","2:onPause...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("xr","2:onDestroy...");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("xr","2:onStop...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("xr","2:onRestart...");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("xr","2:onResume...");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("xr","2:onStart...");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("xr","2:onPostResume...");
    }
}