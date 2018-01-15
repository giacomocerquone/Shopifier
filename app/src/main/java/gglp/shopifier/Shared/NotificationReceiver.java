package gglp.shopifier.Shared;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gglp.shopifier.MainActivity;
import gglp.shopifier.Model.Shop;
import gglp.shopifier.R;

public class NotificationReceiver extends BroadcastReceiver {
    private String lat;
    private Double lon;

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String str = preferences.getString("shops", "");
        Gson gson = new GsonBuilder().create();
        Shop[] shops = gson.fromJson(str, Shop[].class);

        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                notificationIntent, 0);

        Intent serviceIntent = new Intent(context, GetLocationService.class);
        context.startService(serviceIntent); //start service for get location
        lat = intent.getStringExtra("yolo");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(lat)
                .setContentText("Un negozio è nelle vicinanze!")
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND)
                .setContentInfo("Clicca qui");

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());

    }

}
