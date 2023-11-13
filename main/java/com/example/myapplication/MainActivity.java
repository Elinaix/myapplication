package com.example.myapplication;

import static com.example.myapplication.R.id.LinearLayout1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {//this的点

    Fragment fragment1,fragment2,fragment3;
    FragmentManager fm;//官方管理器

    LinearLayout linearLayout1,linearLayout2,linearLayout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();

        linearLayout1=findViewById(R.id.LinearLayout1);
        linearLayout2=findViewById(R.id.LinearLayout2);
        linearLayout3=findViewById(R.id.LinearLayout3);

        fm=getSupportFragmentManager();//返回值

        initial();
        fragmenthide();
        fragmentshow(fragment1);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")

    private void fragmentshow(Fragment fragment) {
        FragmentTransaction transaction=fm.beginTransaction()
                .show(fragment);
        transaction.commit();
    }

    private void fragmenthide() {//隐藏fragment，点击效果之一先隐藏

        FragmentTransaction ft=fm.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                ;
        ft.commit();
    }

    private void initial() {//封包到函数里

        //fm= new 重写完整代码
        FragmentTransaction ft=fm.beginTransaction()
                .add(R.id.content,fragment1)//content1
                .add(R.id.content,fragment2)
                .add(R.id.content,fragment3)
                ;
        ft.commit();//单独分行写，区分事物的完结
    }

    @Override
    public void onClick(View view) {
        fragmenthide();
        if (view.getId()==R.id.LinearLayout1)fragmentshow(fragment1);
        else if (view.getId()==R.id.LinearLayout2)fragmentshow(fragment2);
        else if (view.getId()==R.id.LinearLayout3)fragmentshow(fragment3);
    }
}