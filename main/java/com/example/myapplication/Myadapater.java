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

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myadapater extends RecyclerView.Adapter<Myadapater.Myholder> {
    Context context1;
    List<String> list1,list2;

    public Myadapater(Context context, List<String> list,List<String> list_1)
    {
        context1=context;
        list1=list;
        list2=list_1;
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
        holder.textView1.setText(list2.get(position));
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                Toast.makeText(context1,"跳转到歌曲详情页",Toast.LENGTH_LONG).show();
                intent.setClass(context1,Activity3.class);
                /**/intent.putExtra("author","S.H.E");
                Bundle bundle=new Bundle();
                bundle.putString("name",list1.get(position));
                bundle.putString("author",list2.get(position));
                intent.putExtras(bundle);
                context1.startActivity(intent);
            }
        });
        /*
         holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context1,Activity2.class);
                intent.putExToast.makeText(context1,"跳转到歌曲详情页",Toast.LENGTH_LONG).show();tra("name","我爱你");
                intent.putExtra("author","S.H.E");
                Bundle bundle=new Bundle();
                bundle.putString("name","我爱你");
                bundle.putString("author","S.H.E");
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });*/
    }
    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        TextView textView,textView1;
        Button button;
        public Myholder(View itemView){
            super(itemView);
            textView=itemView.findViewById(R.id.textView8);
            button=itemView.findViewById(R.id.button4);
            textView1=itemView.findViewById(R.id.textView9);
        }
    }
}
