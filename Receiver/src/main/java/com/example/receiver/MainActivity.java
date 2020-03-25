package com.example.receiver;

import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

     MyReciever myReciever = new MyReciever();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.this.registerReceiver(myReciever, new IntentFilter("com.example.MY_ACTION"));
    }

    protected void onDestroy(){
        super.onDestroy();
        MainActivity.this.unregisterReceiver(myReciever);
    }


}
