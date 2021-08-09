package com.airsen.button.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airsen.button.R;
import com.airsen.button.fragment.Home2Fragment;
import com.airsen.button.ui.Libs;


public class TakeDataActivity extends AppCompatActivity {

    TextView mTvTakeData;
    ImageView mImvTakeData;
    public static SharedPreferences mSaveFavoritePlace;
    public static SharedPreferences prefs;
    // public static boolean checkIntent = false;
    //public ArrayList<Node> arrayListNodeTakeData;

    //String url = "http://192.168.1.183/AirMapDatabase/LocationManage/takeAllLocation.php"; //home
    //String url = "http://192.168.11.3/AirMapDatabase/LocationManage/takeAllLocation.php"; //wifi sparclab2
    //String url = "http://192.168.11.20/AirMapDatabase/LocationManage/takeAllLocation.php"; // rount sparclab2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_data);

        mTvTakeData = findViewById(R.id.tv_take_data_activity);
        mImvTakeData = findViewById(R.id.imv_take_data_activity);

        mSaveFavoritePlace = getSharedPreferences("favorite_place", Context.MODE_PRIVATE);
        prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        //arrayListNodeTakeData = new ArrayList<>();
        //GetNode(url);
        //Log.d("arrayListNodeTakeData","arrayListNodeTakeData : "+arrayListNodeTakeData.size());
    }

//    private void GetNode(String url) {
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        arrayListNodeTakeData = new ArrayList<>();
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//                                JSONObject object = response.getJSONObject(i);
//                                Log.d("loafurl", "" + object.toString());
//                                Node node = new Node(object.getString("IdDevice"),
//                                        object.getString("DiaDiem"),
//                                        object.getDouble("KinhDo"),
//                                        object.getDouble("ViDo"),
//                                        object.getString("MoTa"));
//                                arrayListNodeTakeData.add(node);
//                                Log.d("arrayListNodeTakeData", "arrayListNodeTakeData2 : " + node.getmId());
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        //Log.d("loafurl", "" + response.toString());
//                        Log.d("arrayListNodeTakeData", "arrayListNodeTakeData1 : " + arrayListNodeTakeData.size());
//
//                        Intent intent = new Intent(TakeDataActivity.this, MainActivity.class);
//                        Bundle b10 = new Bundle();
//                        b10.putParcelableArrayList("DataNote", arrayListNodeTakeData);
//                        b10.putInt("checkIntent", 3);
//                        intent.putExtras(b10);
//                        startActivity(intent);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                }
//        );
//        // Log.d("arrayListNodeTakeData","arrayListNodeTakeData3 : "+arrayListNodeTakeData.size());
//        requestQueue.add(jsonArrayRequest);
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(getBaseContext(), Home2Fragment.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        Libs.loadLocale(this);

        if (!isConnected()) buildDialog(TakeDataActivity.this).show();
        else {
            Toast.makeText(TakeDataActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
            startService(new Intent(getBaseContext(), Home2Fragment.class));
        }
    }

    public boolean isConnected() {
        boolean wifi = false;
        boolean mobileData = false;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] netinfo = cm.getAllNetworkInfo();

        for (NetworkInfo info : netinfo) {
            if (info.getTypeName().equalsIgnoreCase("WIFI")) {
                if (info.isConnected()) {
                    wifi = true;
                }
            }
            if (info.getTypeName().equalsIgnoreCase("MOBILE")) {
                if (info.isConnected()) {
                    mobileData = true;
                }
            }
        }
        return wifi | mobileData;
    }

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle(R.string.check_internet_access_title);
        builder.setMessage(R.string.check_internet_access_content);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        return builder;
    }

}
