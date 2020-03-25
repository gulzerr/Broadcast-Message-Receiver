package com.example.sender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String recievedText = intent.getStringExtra("com.example.MY_ACTION");
            textView.setText(recievedText);
        }
    };

    protected void onStart(){
        super.onStart();
        IntentFilter filter = new IntentFilter("com.example.MY_ACTION");
        registerReceiver(broadcastReceiver, filter);
    }

    protected void onStop(){
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent("com.example.MY_ACTION");
        intent.putExtra("com.example.EXTRA_TEXT", "Broadcast received");
        sendBroadcast(intent);
    }
}
