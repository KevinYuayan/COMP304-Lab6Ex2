package com.example.kashdeep_john_comp304lab6ex2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ServicesActivity extends AppCompatActivity {
    private TextView textView;
    //replace with your package name
    public static final String INFO_INTENT =
            "com.example.kashdeep_john_comp304lab6ex2.INFO_UPDATE";
    public static final String INT_INFO_INTENT =
            "com.example.kashdeep_john_comp304lab6ex2.INT_INFO_UPDATE";

    //This will handle the broadcast
    public BroadcastReceiver receiver = new BroadcastReceiver() {
        //@Override
        public void onReceive(Context context, Intent intent) {
            //textView.setText("Here");
            String action = intent.getAction();
            if (action.equals(SimpleService.INFO_INTENT)) {
                String info = intent.getStringExtra(INFO_INTENT);
                int intInfo = intent.getIntExtra(INT_INFO_INTENT, 0);
                textView.setText(info + "\n" + intInfo);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        textView = findViewById(R.id.textView);
    }
    //
    public void startService(View view) {
        startService(new Intent(getBaseContext(), SimpleService.class));
    }
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), SimpleService.class));
    }
    @Override
    public void onResume() {
        super.onResume();
        //This needs to be in the activity that will end up receiving the broadcast
        registerReceiver(receiver, new IntentFilter(INFO_INTENT));
    }

}



