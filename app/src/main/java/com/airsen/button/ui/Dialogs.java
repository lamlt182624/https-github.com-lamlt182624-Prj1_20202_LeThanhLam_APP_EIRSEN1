package com.airsen.button.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airsen.button.MainActivity;
import com.airsen.button.R;
import com.airsen.button.Retrofit.APIretrofitclient;
import com.airsen.button.Retrofit.ApiUtils;
import com.airsen.button.Retrofit.datasevice;
import com.airsen.button.activity.TakeDataActivity;
import com.airsen.button.object.Node;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Dialogs extends AppCompatActivity {


    ArrayList<Node> allNode;
    datasevice mSevice;


    public static void DialogMapFragment(final int a, Context context) {
        TextView mTvPlaceDialogAQIMap, mTvAQIDialogAQIMap, mTvWarningDialogAQIMap, mTvDetailDialogAQIMap;
        ImageView mImvStatusDialogAQIMap;
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_aqi_map);
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        mTvPlaceDialogAQIMap = dialog.findViewById(R.id.tv_place_small_notification);
        mTvAQIDialogAQIMap = dialog.findViewById(R.id.tv_AQI_small_notification);
        mTvWarningDialogAQIMap = dialog.findViewById(R.id.tv_warning_small_notification);
        mTvDetailDialogAQIMap = dialog.findViewById(R.id.tv_detail_small_notification);
        mImvStatusDialogAQIMap = dialog.findViewById(R.id.imv_status_AQI_small_notification);


//        mTvPlaceDialogAQIMap.setText(allNode.get(a).getContent());
//        for (int i = 0; i < allNode.size(); i++) {
//                mTvAQIDialogAQIMap.setText((int)allNode.get(i).getAqi() + "");
//                mTvWarningDialogAQIMap.setText(AQI_US.getMessage(allNode.get(i).getAqi()));
//                mImvStatusDialogAQIMap.setImageResource(AQI_US.getAqiIcon(allNode.get(i).getAqi()));
//        }

        mTvDetailDialogAQIMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.currentNode = a;
                MainActivity.tabLayout.getTabAt(2).select();
                dialog.cancel();
            }
        });
        dialog.show();
    }

    private void data(){
        mSevice = ApiUtils.getService();

        mSevice.Getaqicurrentday().enqueue(new Callback<List<Node>>() {

            @Override
            public void onResponse(Call<List<Node>> call, Response<List<Node>> response) {
                allNode = (ArrayList<Node>) response.body();

            }

            @Override
            public void onFailure(Call<List<Node>> call, Throwable t) {

            }
        });

    }



    public static void dialogChoiceFavaritePlace(final int position,Context context) {
        TextView mTvplaceFavorite;
        Button mBtnChoiceFavorite, mBtnCancel;

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_choice_favorite_place);
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        mTvplaceFavorite = dialog.findViewById(R.id.tv_place_favotite_place);
        mBtnChoiceFavorite = dialog.findViewById(R.id.btn_choice_dialog_favotite_place);
        mBtnCancel = dialog.findViewById(R.id.btn_cancle_dialog_favotite_place);

        //mTvplaceFavorite.setText(MainActivity.allNode.get(position).getmAddress());
        mTvplaceFavorite.setTextColor(context.getResources().getColor(R.color.colorAccent));

        mBtnChoiceFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = TakeDataActivity.mSaveFavoritePlace.edit();
                editor.putInt("number_favorite", position);
               // editor.putString("place", MainActivity.allNode.get(position).getmAddress());
                editor.commit();
                dialog.cancel();
            }
        });
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

    public static void dialogSettingNotification(final Context context) {
        Button btnStNotification;
        final CheckBox cbNotfcation1, cbNotfcation2;
        final Dialog mDialog1 = new Dialog(context);
        mDialog1.setContentView(R.layout.dialog_setting_notification);
        Window window = mDialog1.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        cbNotfcation1 = mDialog1.findViewById(R.id.cb_notf1);
        cbNotfcation2 = mDialog1.findViewById(R.id.cb_notf2);
        btnStNotification = mDialog1.findViewById(R.id.btn_setting_notification);

        btnStNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cbNotfcation1.isChecked()) {
                    Toast.makeText(context, "Sent me notification in my place", Toast.LENGTH_SHORT).show();
                }

                if (cbNotfcation2.isChecked()) {
                    Log.d("why", "2");
                    Toast.makeText(context, "Sent me notification near me", Toast.LENGTH_SHORT).show();
                }


                mDialog1.cancel();
            }
        });
        mDialog1.show();
    }
}
