package com.example.notificationtest;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationManagerCompat;

public class Receiver extends BroadcastReceiver {

    @Override
    public void OnReceive(Context context, Intent intent){

        if (intent != null){

            //get notificationId of notification using intent
            int id = intent.getIntExtra(id);
            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);

            //cancel the specific notificationId notification.
            notificationManagerCompat.cancel(id);
        }
    }
}