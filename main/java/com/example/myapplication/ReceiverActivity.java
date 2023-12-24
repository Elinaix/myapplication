package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.Inflater;

public class ReceiverActivity extends AppCompatActivity {

    Button button;

    MyReceiver2 myReceiver2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

       button = findViewById(R.id.button);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent1=new Intent(ReceiverActivity.this,MyService1.class);
               stopService(intent1);
              // finish();
           }
       });


/*     //接收短信消息
        String[] permissions={Manifest.permission.RECEIVE_SMS};
        int requestCode=999;
        ActivityCompat.requestPermissions(this,permissions,requestCode);
       //发送
        String actinname="xr.Broadcast.666";//string是一个action的name
        Intent intent=new Intent(actinname);
       //定时发送
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sendBroadcast(intent);
            }
        },10);//定时执行，秒
      //接收并播放音乐
        myReceiver2=new MyReceiver2();
        IntentFilter filter=new IntentFilter();//过滤器，过滤广播
        filter.addAction(actinname);
        registerReceiver(myReceiver2,filter);//广播接收器
        //通过按钮实现发送广播，然后接收并播放音乐
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sendBroadcast(intent);
            }
        });
*/  }

/*    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 999) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 用户授予了短信权限，可以执行读取短信的操作
                // 执行读取短信的逻辑...
            } else {
                // 用户拒绝了短信权限，你可以根据需要进行适当的处理
                Toast.makeText(this,"用户拒绝了短信权限",Toast.LENGTH_LONG).show();
            }
        }
    }*/
}