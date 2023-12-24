package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MyDAO {
    MyOpenhelper openhelper;
    SQLiteDatabase database;
    Context mycontext;
    public MyDAO(Context context) {
        mycontext=context;
    }

    public void MyconnectDB(){
        openhelper=new MyOpenhelper(mycontext,"xldb",null,1);
        database =openhelper.getWritableDatabase();
        openhelper.onCreate(database);
    }

    public void Myinsert(ContentValues contentValues){
        /*ContentValues values1=new ContentValues();
        values1.put("name","zhangsan");
        values1.put("age",18);
        ContentValues values2=new ContentValues();
        values2.put("name","lisi");
        values2.put("age",19);
        ContentValues values3=new ContentValues();
        values3.put("name","zhangsan");
        values3.put("age",19);
        database.insert("person",null,values1);
        database.insert("person",null,values2);*/
        database.insert("person",null,contentValues);
    }

    public void Mydelete(){
        database.delete("person","name=?",new String[]{"爱到1440"});
    }

    public void Myupdate(){
        ContentValues values=new ContentValues();
        values.put("name","绝配");
        database.update("person",values,
                "name=? AND author=?",new String[]{"朱雀","TNT"});
    }

    public ArrayList<HashMap<String, Object>> MyqueryAll(String str){
        Cursor cursor=database.rawQuery("select * from person where author=?",
                new String[]{str});
        //textView1.setText("查询到的结果的值："+cursor.getCount());
        //StringBuilder stringBuilder=new StringBuilder();
        cursor.moveToFirst();
        ArrayList<HashMap<String, Object>> list1=new ArrayList<>();//键值对
        while (!cursor.isAfterLast()) {
            @SuppressLint("Range")int id=cursor.getInt(cursor.getColumnIndex("id"));
            @SuppressLint("Range")String name=cursor.getString(cursor.getColumnIndex("name"));
            @SuppressLint("Range")String author=cursor.getString(cursor.getColumnIndex("author"));
            /*stringBuilder.append(id+name+age);*/
            HashMap<String, Object> map=new HashMap();
            map.put("id",id);
            map.put("name",name);
            map.put("author",author);
            list1.add(map);
            cursor.moveToNext();
            //Log.d("xl","")
        };
        cursor.close();
        return list1;
    }
}
