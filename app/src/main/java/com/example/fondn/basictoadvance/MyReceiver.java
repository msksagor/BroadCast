package com.example.fondn.basictoadvance;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = TelephonyManager.EXTRA_STATE_RINGING;

        if(intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(action)){
            String phoneNo = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

            Notification notification = new Notification.Builder(context)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Sagor")
                    .setContentText(phoneNo)
                    .setAutoCancel(true)
                    .build();

            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(0,notification);
        }
    }
}
