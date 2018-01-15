package gglp.shopifier.Shared;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import gglp.shopifier.Shared.GetLocationService;

public class Alarm {
    public static void startNotifications(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent myIntent = new Intent(context, GetLocationService.class);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, myIntent, 0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime() + 3000, 61000, pendingIntent);
    }
}
