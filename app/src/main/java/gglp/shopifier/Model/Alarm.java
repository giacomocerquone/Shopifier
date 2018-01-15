package gglp.shopifier.Model;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gglp.shopifier.Shared.NotificationReceiver;

/**
 * Created by matte on 11/01/2018.
 */

public class Alarm {
 public static void startNotifications(Context context, int num){
        if(num==1){
        AlarmManager alarmManager=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent myIntent = new Intent(context, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,myIntent,0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime()+3000,100*1000,pendingIntent);
        }
 }
}
