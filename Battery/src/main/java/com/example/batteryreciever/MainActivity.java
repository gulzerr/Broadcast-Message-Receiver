package com.example.batteryreciever;

import java.io.IOException;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private BroadcastReceiver battery = new BroadcastReceiver()
    {
        int oldLevel = 0;

        public void onReceive(Context context, Intent intent)
        {
            int percentage = intent.getIntExtra(" Percentage", 0);
            ProgressBar pb = (ProgressBar)findViewById(R.id.progressBar1);
            TextView tv = (TextView)findViewById(R.id.textView1);
            pb.setProgress(percentage);
            tv.setText("Batterylevel:" + Integer.toString(level) + "%");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(battery, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}