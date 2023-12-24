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

    Button button3,button5,button6;
    TextView textView,textView1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        textView=findViewById(R.id.textView12);
        textView1=findViewById(R.id.textView13);

        button3=findViewById(R.id.button3);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
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
        Log.d("xl","3:onCreate...");//调试页面显示

        //连接到Service——普通方式连接
        Intent intent1=new Intent(Activity3.this,MyService1.class);
        //音乐播放
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent1);
            }
        });
        //音乐停止
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent1);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("xl","3:onPause...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("xl","3:onDestroy...");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("xl","3:onStop...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("xl","3:onRestart...");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("xl","3:onResume...");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("xl","3:onStart...");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("xl","3:onPostResume...");
    }
}