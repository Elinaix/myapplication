package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    Button button1,button2;
    TextView textView3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);

        textView3=findViewById(R.id.textView10);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1.this,Activity2.class);
                intent.putExtra("name","xr");
                intent.putExtra("age","10");
                Bundle bundle=new Bundle();
                bundle.putString("name","xr");
                bundle.putInt("age",10);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        //启动项
        ActivityResultLauncher launcher=
                registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>() {
                            @Override
                            public void onActivityResult(ActivityResult result) {
                                if (result.getResultCode()==666){
                                    String str=result.getData().getStringExtra("result");
                                    textView3.setText(str);
                                }
                            }
                        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(Activity1.this,Activity3.class);
                launcher.launch(intent3);
            }
        });

        Log.d("xr","onCreate...");//调试页面显示
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("xr","onPause...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("xr","onDestroy...");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("xr","onStop...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("xr","onRestart...");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("xr","onResume...");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("xr","onStart...");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("xr","onPostResume...");
    }
}