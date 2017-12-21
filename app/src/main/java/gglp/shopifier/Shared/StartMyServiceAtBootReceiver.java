package gglp.shopifier.Shared;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import gglp.shopifier.MainActivity;

/**
 * Created by matte on 21/12/2017.
 */

public class StartMyServiceAtBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Intent serviceIntent = new Intent(context, MainActivity.class);
            context.startService(serviceIntent);
        }
    }
}
