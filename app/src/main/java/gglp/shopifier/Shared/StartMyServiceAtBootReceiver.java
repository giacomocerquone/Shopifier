package gglp.shopifier.Shared;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import gglp.shopifier.MainActivity;

/**
 * Created by matte on 21/12/2017.
 */

public class StartMyServiceAtBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Service stops","OHHHHHHH");
        context.startService(new Intent(context, NotificationService.class));
    }
}
