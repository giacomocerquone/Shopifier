package gglp.shopifier.Shared;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import gglp.shopifier.Model.Alarm;

/**
 * Created by matte on 21/12/2017.
 */

public class StartMyServiceAtBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Alarm.startNotifications(context,1);

}}
