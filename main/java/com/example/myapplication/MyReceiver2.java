package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

public class MyReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent intent1=new Intent(context,MyService1.class);
        context.startService(intent1);//通过context调用
        Log.d("xr","MyReceiver2:onReceive...."+ Calendar.getInstance().getTime());
    }
}