package com.airsen.button.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airsen.button.MainActivity;
import com.airsen.button.R;
import com.airsen.button.Retrofit.ApiUtils;
import com.airsen.button.object.Apputil;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class flagactivity extends AppCompatActivity {
    TextView mTvTakeData;
    ImageView mImvTakeData;
    public static SharedPreferences mSaveFavoritePlace;
    public static SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_data);
//        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        loadData();
        //
//
//        mTvTakeData = findViewById(R.id.tv_take_data_activity);
//        mImvTakeData = findViewById(R.id.imv_take_data_activity);
//
//        mSaveFavoritePlace = getSharedPreferences("favorite_place", Context.MODE_PRIVATE);
//        prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        //arrayListNodeTakeData = new ArrayList<>();
        //GetNode(url);
        //Log.d("arrayListNodeTakeData","arrayListNodeTakeData : "+arrayListNodeTakeData.size());


//        Intent intent = new Intent(this, SigninActivity.class);
//        startActivity(intent);
    }

    private void loadData(){
        if (Apputil.isNetconnect(this)){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user== null){
                        Intent intent = new Intent(flagactivity.this, SigninActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Intent intent = new Intent(flagactivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    finish();

                }
            }, 2000);
        }else {
            Toast.makeText(this, "Network disconnect", Toast.LENGTH_SHORT).show();
        }
    }

}
