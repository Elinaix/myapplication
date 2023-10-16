package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {

   RecyclerView recyclerView;
        List<String> list;
        Myadapater adapter;
        Context context;

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

            View view=inflater.inflate(R.layout.tab1, container, false);

            recyclerView = view.findViewById(R.id.RecyclerView);
            context = view.getContext();

            list = new ArrayList<String>();
            for (int i = 0; i < 9; i++) {
                list.add("这是第" + i + "行数据");
            }
                adapter = new Myadapater(context, list);
                recyclerView.setAdapter(adapter);

                LinearLayoutManager manager = new LinearLayoutManager(context);//布局
                manager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(manager);
        return view;
    }
}

