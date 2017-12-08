package com.cemb0.poopyweather;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The more info toggle button
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                View view = (View) findViewById(R.id.textView9);
                if (view.getVisibility() == view.VISIBLE){
                    view.setVisibility(View.GONE);
                } else {
                    view.setVisibility(View.VISIBLE);
                }
            }
        });

        final NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.example_picture)
                        .setContentTitle("First notification")
                        .setContentText("YO YOU BETTER LET THE DOG OUT BEFORE IT RAINS");

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                // Gets an instance of the NotificationManager service
                NotificationManager mNotifyMgr =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // Builds the notification and issues it.
                mNotifyMgr.notify(1, mBuilder.build());

            }
        });

        // Time picker adjustments
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker1);
        timePicker.setHour(7);
        timePicker.setMinute(00);
        TimePicker timePicker2 = (TimePicker) findViewById(R.id.timePicker2);
        timePicker2.setHour(22);
        timePicker2.setMinute(00);
    }


    @Override
    public void onResume() {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onResume();
    }

    @Override
    public void onStart() {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onStart();
    }

}
