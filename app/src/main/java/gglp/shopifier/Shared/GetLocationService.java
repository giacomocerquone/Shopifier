package gglp.shopifier.Shared;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;


public class GetLocationService extends Service {
    String lat = "45.90909";
    Double lon = 45.90909;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Intent intent = new Intent(this, NotificationReceiver.class);
        intent.putExtra("yolo", lat);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
    }
}
