import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class PushNotificationService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {

        if(remoteMessage.getData().size()>0) {
            showNotification(remoteMessage.getData().get("title"), remoteMessage.getData().get("message"));
        }

        if(remoteMessage.getNotification() != null) {
            showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        }

    }

    private RemoteViews getCustomNotificationDesign(String title, String message) {
        RemoteViews remoteViews = new RemoteViews(getApplicationContext().getPackageName(), R.layout.notification);
        remoteViews.setTextViewText(R.id.notif_title, title);
        remoteViews.setTextViewText(R.id.notif_message, message);
        remoteViews.setImageViewResource(R.id.notif_icon, R.drawable.logo);
        return remoteViews;
    }

    private void showNotification(String title, String message) {

        Intent intent = new Intent(this, "Your Main Activity Here".class);
        String channel_id = "Your channel ID here (eg. "name_channel")";
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channel_id)
                .setSmallIcon(R.drawable."your icon name for custom notification icon")
                .setSound(uri)
                .setAutoCancel(true)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setOnlyAlertOnce(true)
                .setContentIntent(pendingIntent);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            builder = builder.setContent(getCustomNotificationDesign(title,message));
        } else  {
            builder = builder.setContentTitle(title)
                    .setContentText(message)
                    .setSmallIcon(R.drawable.logo);
        }

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(channel_id, "your channel id here (eg. "channel_name")", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setSound(uri,null);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        notificationManager.notify(0,builder.build());
    }

}
