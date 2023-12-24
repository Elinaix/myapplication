package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
    public class Fragment1 extends Fragment {

        RecyclerView recyclerView;
        List<String> list,list1;
        Myadapater adapter;
        Context context;

        TextView textView;
        Button button;

        @SuppressLint("MissingInflatedId")
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.tab1, container, false);

            recyclerView = view.findViewById(R.id.RecyclerView);
            context = view.getContext();

            textView=view.findViewById(R.id.textView12);
            button=view.findViewById(R.id.button4);

            list = new ArrayList<String>(Arrays.asList("编号89757","爱","血腥爱情故事","黑暗骑士","波斯猫","输情歌","童年"));
            list1= new ArrayList<String>(Arrays.asList("林俊杰","莫文蔚","张惠妹","五月天","S.H.E","J.Sheon","罗大佑"));

            adapter = new Myadapater(context, list,list1);
            recyclerView.setAdapter(adapter);

            DividerItemDecoration mDivider = new
                    DividerItemDecoration(context,DividerItemDecoration.VERTICAL);
            recyclerView.addItemDecoration(mDivider);//间隔线

            LinearLayoutManager manager = new LinearLayoutManager(context);//布局
                manager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(manager);
        return view;
    }
}

