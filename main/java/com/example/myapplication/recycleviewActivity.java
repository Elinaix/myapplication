package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class recycleviewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> list;
    ArrayList<HashMap<String, Object>> list1,list2;//实例修改
    Myadapater2 adapter;
    Context context;
    MyDAO myDAO;
    Button buttonfile,button15;
    EditText editText1,editText2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        recyclerView = findViewById(R.id.RecyclerView);
        button15=findViewById(R.id.button15);
        buttonfile=findViewById(R.id.button_file);//添加歌曲的方法一
        editText1=findViewById(R.id.editTextText);//添加歌曲的方法二
        editText2=findViewById(R.id.editTextText2);
        context=this;
       //list1=(ArrayList<HashMap<String, Object>>) getIntent().getSerializableExtra("data");

        if (getIntent().getBooleanExtra("isFromActivity2", false)) {
            // 如果是从 Activity2 来的，则获取最新数据
            ArrayList<HashMap<String, Object>> data = myDAO.MyqueryAll("TNT");
            if (data != null) {
            Log.i("xl","list"+data.toString());
            adapter=new Myadapater2(this, data);
            recyclerView.setAdapter(adapter);
            } else {
                Log.i("xl", "No data received"); // 检查是否没有接收到数据
            }

            DividerItemDecoration mDivider = new
                    DividerItemDecoration(context,DividerItemDecoration.VERTICAL);
            recyclerView.addItemDecoration(mDivider);//间隔线

            LinearLayoutManager manager = new LinearLayoutManager(context);//布局
            manager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(manager);

            myDAO = new MyDAO(this);

            buttonfile.setOnClickListener(new View.OnClickListener() {//添加一个值
                @Override
                public void onClick(View v) {
                    //ContentValues values4=new ContentValues();
                    //values4.put("name","朱雀");
                    //values4.put("author","TNT");
                    //myDAO.Myinsert(values4);
                    String name = editText1.getText().toString(); // 获取姓名输入框中的文本
                    String author = editText2.getText().toString();
                    ContentValues values = new ContentValues();
                    values.put("name", name);
                    values.put("author", author);
                    myDAO.Myinsert(values);
                    // 重新获取最新数据并更新 RecyclerView
                    list1 = myDAO.MyqueryAll("TNT");
                    adapter.notifyDataSetChanged(); // 通知适配器数据源已更改
                }
            });

            button15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
/*
        myDAO=new MyDAO(this);
        myDAO.MyconnectDB();
        list2=myDAO.MyqueryAll("lisi");
*/
    }
}