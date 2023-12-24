package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Activity2 extends AppCompatActivity {

    TextView textView,textView8;
    Button button9,button10,button16,button17,button18,button19;
    MyDAO myDAO;
    ArrayList<HashMap<String, Object>> list;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textView=findViewById(R.id.textView11);
        textView8=findViewById(R.id.textView8);
        button9=findViewById(R.id.button9);
        button10=findViewById(R.id.button10);
        button16=findViewById(R.id.button16);
        button17=findViewById(R.id.button17);
        button18=findViewById(R.id.button18);
        button19=findViewById(R.id.button19);

        Intent intent=getIntent();
        String str=intent.getStringExtra("name");
        textView.setText(str);//显示标题

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });//返回页面

        myDAO=new MyDAO(this);

        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDAO.MyconnectDB();//连接数据库
                Log.d("xl"," connect");
            }
        });

        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //添加原有歌曲信息
                ContentValues values1=new ContentValues();
                values1.put("name","爱到1440");
                values1.put("author","TNT");
                ContentValues values2=new ContentValues();
                values2.put("name","无尽的冒险");
                values2.put("author","TNT");
                ContentValues values3=new ContentValues();
                values3.put("name","相遇");
                values3.put("author","TNT");
                ContentValues values4=new ContentValues();
                values4.put("name","朱雀");
                values4.put("author","TNT");
                myDAO.Myinsert(values1);
                myDAO.Myinsert(values2);
                myDAO.Myinsert(values3);
                myDAO.Myinsert(values4);
                Log.d("xl","add");
            }
        });

        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDAO.Mydelete();
            }
        });

        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDAO.Myupdate();
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示信息
                list=myDAO.MyqueryAll("TNT");
                Log.i("xl","list"+list.toString());
                textView8.setText(list.toString());
                //Intent intent=new Intent(Activity2.this,recycleviewActivity.class);
                //intent.putExtra("data",list);
                //intent.putExtra("isFromActivity2", true); // 添加一个标识
                //startActivity(intent);
            }
        });
        Log.d("xl","2:onCreate...");//调试页面显示
    }

}