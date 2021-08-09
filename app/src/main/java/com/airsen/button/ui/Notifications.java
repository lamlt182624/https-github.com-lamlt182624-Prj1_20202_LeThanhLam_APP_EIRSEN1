package com.airsen.button.ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.airsen.button.MainActivity;
import com.airsen.button.R;
import com.airsen.button.Retrofit.ApiUtils;
import com.airsen.button.Retrofit.datasevice;
import com.airsen.button.object.Node;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.core.content.ContextCompat.getSystemService;

public class Notifications extends Fragment {
    public static final String CHANNEL_ID = "channel 1";
    private datasevice mService;
    List<Node> allNode;
    // tao nen thong bao ve muc do o nhiem trong ung dung

    private Button mbutton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_setting_notification,container,false);
 //      mbutton = view.findViewById(R.id.btn_setting_language);
//       mbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CreateNotifications(getContext());
////                setNotification();
//            }
//        });

        return view;
    }

//    private void setNotification() {
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
//        Notification notification = new Notification.Builder(this)
//                .setContentTitle("set notification")
//                .setContentText("masegeput")
//                .setSmallIcon(R.drawable.airmap_logo)
//                .setLargeIcon(bitmap)
//                .build();
//        NotificationManager notificationManager = (NotificationManager) Context.getSystemService(Context.NOTIFICATION_SERVICE);
//        if (notificationManager!= null){
//            notificationManager.notify(100,notification);
//        }
//    }


    public void NotificationNearMe(){

    }
    public void NotificationMyHome(){

    }

    private void data(){
        allNode = new ArrayList<>();
        mService = ApiUtils.getService();
        mService.Getaqicurrentday().enqueue(new Callback<List<Node>>() {

            @Override
            public void onResponse(Call<List<Node>> call, Response<List<Node>> response) {
                allNode = response.body();

            }

            @Override
            public void onFailure(Call<List<Node>> call, Throwable t) {

            }
        });
    }


}
