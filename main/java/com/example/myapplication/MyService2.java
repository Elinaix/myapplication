package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService2 extends Service {

    MediaPlayer player;

    public MyService2() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("xr","Mysevice2:onCreate....");
        player= MediaPlayer.create(this,R.raw.music);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //player.start();
        Log.d("xr","Mysevice2:onStartCommand....");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
        super.onDestroy();
        Log.d("xr","Mysevice2:onDestroy....");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d("xr","Mysevice2:onBind....");
        MyBinder myBinder=new MyBinder();
        return  myBinder;
        //抛出异常throw new UnsupportedOperationException("Not yet implemented");
    }

    class MyBinder extends Binder{
        public MyBinder(){

        }
        public void Todo(){
            player.start();
            Log.d("xr","Mysevice2:Todo....");
        }

    }
}
