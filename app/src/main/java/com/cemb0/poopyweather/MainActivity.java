package com.cemb0.poopyweather;

import android.app.Notification;
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
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;

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
                        .setContentText("YO YOU BETTER LET THE DOG OUT BEFORE IT RAINS")
                        .setPriority(Notification.PRIORITY_HIGH)
                        .setDefaults(Notification.DEFAULT_ALL);

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

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                int PLACE_PICKER_REQUEST = 1;
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                try {
                    startActivityForResult(builder.build(MainActivity.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }

                /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (requestCode == PLACE_PICKER_REQUEST) {
                    if (resultCode == RESULT_OK) {
                        Place place = PlacePicker.getPlace(data, this);
                        String toastMsg = String.format("Place: %s", place.getName());
                        Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
                    }
                }*/
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
