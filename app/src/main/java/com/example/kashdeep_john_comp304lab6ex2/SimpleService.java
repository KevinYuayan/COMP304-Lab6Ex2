package com.example.kashdeep_john_comp304lab6ex2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class SimpleService extends Service {
    //replace with your package name
    public static final String INFO_INTENT =
            "com.example.kashdeep_john_comp304lab6ex2.INFO_UPDATE";
    public static final String INT_INFO_INTENT =
            "com.example.kashdeep_john_comp304lab6ex2.INT_INFO_UPDATE";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(INFO_INTENT);
        broadcastIntent.putExtra(INFO_INTENT, "Hello there! A simple service is sending this message to you!");
        broadcastIntent.putExtra(INT_INFO_INTENT, 1000);
        this.sendBroadcast(broadcastIntent);
        //
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed",
                Toast.LENGTH_LONG).show();
    }
}
