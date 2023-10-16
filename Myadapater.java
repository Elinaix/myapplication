package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myadapater extends RecyclerView.Adapter<Myadapater.Myholder> {
    Context context1;
    List<String> list1;

    public Myadapater(Context context, List<String> list)
    {
        context1=context;
        list1=list;
    }

    @NonNull
    //指向每一行的指针
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context1).inflate(R.layout.item,parent,false);
        Myholder holder;
        holder = new Myholder(view);
        return holder;
    }

    public void onBindViewHolder(@NonNull Myholder holder, int position) {

        holder.textView.setText(list1.get(position));
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        TextView textView;
        public Myholder(View itemView){
            super(itemView);
            textView=itemView.findViewById(R.id.textView8);
        }
    }
}
