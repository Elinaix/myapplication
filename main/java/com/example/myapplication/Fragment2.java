package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    ImageView imageView4;
    Button button7;
    int i=0;
    Mythread thread;

    int[] p=new int[]{
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
    };

    class Mythread extends Thread{

        Handler handler;

        @Override
        public void run() {
            Looper.prepare();
            handler=new Handler(Looper.myLooper() ){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    if(msg.what==999){
                        String str=msg.getData().getString("name");
                        Log.d("xl","name"+str);
                        //借助 requireActivity()或getActivity()方法来获取Activity对象，并使用该对象的 runOnUiThread()方法
                        requireActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView4.setImageResource(p[i++]);
                                if (i>p.length)i=0;
                            }
                        });
                    }
                }
            };
            Looper.loop();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.tab2, container, false);

        imageView4=view.findViewById(R.id.imageView4);
        button7=view.findViewById(R.id.button7);

        thread=new Mythread();
        thread.start();

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message2=new Message();
                message2.what=999;
                Bundle bundle=new Bundle();
                bundle.putString("name","xl");
                message2.setData(bundle);
                thread.handler.sendMessage(message2);
            }
        });

        return view;
    }
}