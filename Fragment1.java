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

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    static class recycleviewactivity extends AppCompatActivity {

        RecyclerView recyclerView;
        List<String> list;
        Myadapater adapter;
        Context context;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.tab1);

            recyclerView = findViewById(R.id.RecyclerView);

            list = new ArrayList<String>();
            for (int i = 0; i < 9; i++) {
                list.add("这是第" + i + "行数据");
            }

            context = this;

            adapter = new Myadapater(context, list);

            LinearLayoutManager manager = new LinearLayoutManager(this);//布局
            manager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adapter);
        }
    }
}

