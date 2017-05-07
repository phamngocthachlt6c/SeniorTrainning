package com.game.thach.seniortrainning;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by phamn on 5/3/2017.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    public static final String TAG = MyBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "***********************************");
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            Log.d(TAG, "Connected");
        }else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            Log.d(TAG, "Disconnected");
        }
    }
}
