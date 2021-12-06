package com.example.apphome;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import androidx.core.app.TaskStackBuilder;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.v4.app.NotificationCompat;
//import android.support.v4.app.RemoteInput;
//import android.support.v4.app.TaskStackBuilder;
//import android.support.v4.app.AppCompatActivity;
import android.os.Bundle;

public class LaunchActivity extends AppCompatActivity {
    // Key for the string that's delivered in the action's intent.
    private static final String KEY_TEXT_REPLY = "key_text_reply";

    // mRequestCode allows you to update the notification later on.
    int mRequestCode = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_feed);

        // Create the RemoteInput specifying this key
        String replyLabel = getString(R.string.reply_label);
        RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
                .setLabel(replyLabel)
                .build();

        Intent resultIntent = new Intent(this, NotificationActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(NotificationActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        // Add to your action, enabling Direct Reply for it
        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(R.drawable.ic_stat_social_notifications_on, replyLabel, resultPendingIntent)
                        .addRemoteInput(remoteInput)
                        .setAllowGeneratedReplies(true)
                        .build();

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .addAction(action)
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.ic_stat_social_notifications_on)
                        .setContentTitle("Wired Says")
                        .setContentText("Do I Even Work?");

        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //Show it
        mNotificationManager.notify(mRequestCode, mBuilder.build());
    }
}
