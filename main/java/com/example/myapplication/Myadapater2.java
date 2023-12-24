package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Myadapater2 extends RecyclerView.Adapter<Myadapater2.Myholder> {
    Context context1;
    ArrayList<HashMap<String, Object>> list1;

    public Myadapater2(Context context, ArrayList<HashMap<String, Object>> list)
    {
        context1=context;
        list1=list;
    }

    @NonNull
    //指向每一行的指针
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context1).inflate(R.layout.item2,parent,false);
        Myholder holder;
        holder = new Myholder(view);
        return holder;
    }

    public void onBindViewHolder(@NonNull Myholder holder, int position) {

        HashMap<String, Object> dataItem=list1.get(position);
        String id=dataItem.get("id").toString();
        String name=dataItem.get("name").toString();
        String author=dataItem.get("author").toString();

        holder.textView.setText("号码:"+id);
        holder.textView1.setText("歌名:"+name);
        holder.textView2.setText("歌手:"+author);
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        TextView textView,textView1,textView2;
        public Myholder(View itemView){
            super(itemView);
            textView=itemView.findViewById(R.id.filetextView10);
            textView1=itemView.findViewById(R.id.filetextView11);
            textView2=itemView.findViewById(R.id.filetextView12);
        }
    }
}
