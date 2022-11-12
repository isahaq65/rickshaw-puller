package com.rickshawpuller.r.driverapp.service;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import com.rickshawpuller.r.driverapp.activity.CustomerCallActivity;
import com.rickshawpuller.r.driverapp.common.Common;
import com.rickshawpuller.r.driverapp.model.firebase.Pickup;

public class firebaseMessaging extends FirebaseMessagingService{


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d("yes", remoteMessage.getNotification().getBody().toString());
        if(remoteMessage.getNotification().getTitle().equals("Pickup")){
           // Toast.makeText(getBaseContext(),"yes",Toast.LENGTH_SHORT).show();
            Pickup pickup = new Gson().fromJson(remoteMessage.getNotification().getBody(), Pickup.class);
            Intent intent = new Intent(getApplicationContext(), CustomerCallActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("lat", pickup.getLat());
            intent.putExtra("lng", pickup.getLng());
            intent.putExtra("rider", pickup.getID());
            intent.putExtra("token", pickup.getToken());
            startActivity(intent);

        }

    }



//    @Override
//    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
//        super.onMessageReceived(remoteMessage);
//        String title=remoteMessage.getNotification().getTitle();
//        String body=remoteMessage.getNotification().getBody();
//
////        NotificationManager notificationManager=new NotificationCompat.Builder(this)
////                .setSmallIcon(R.drawable.com_facebook_button_icon)
////                .setContentTitle(title)
////                .setContentText(body)
////                .setColor(Color.RED)
////                .build();
////        NotificationManager manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
////        manager.notify(1002, notificationManager);
////    }

    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference tokens=db.getReference(Common.token_tbl);
        if (FirebaseAuth.getInstance().getCurrentUser()!=null)
            tokens.child(FirebaseAuth.getInstance().getUid())
                .setValue(token);
    }
}
