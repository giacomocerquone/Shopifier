package gglp.shopifier.Shared;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import gglp.shopifier.Model.Alarm;

public class StartMyServiceAtBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Alarm.startNotifications(context);
    }
}
