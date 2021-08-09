package com.airsen.button;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.airsen.button.Retrofit.ApiUtils;
import com.airsen.button.Retrofit.datasevice;
import com.airsen.button.activity.SigninActivity;
import com.airsen.button.activity.flagactivity;
import com.airsen.button.fragment.ChartFragment;
import com.airsen.button.fragment.Home2Fragment;
import com.airsen.button.fragment.gelleryFragment;
import com.airsen.button.fragment.slideshowFragment;
import com.airsen.button.object.MyAplication;
import com.airsen.button.object.Node;
import com.airsen.button.object.Record;
import com.airsen.button.ui.AboutActivity;
import com.airsen.button.ui.AddNewDeviceActivity;
import com.airsen.button.ui.ContactActivity;
import com.airsen.button.ui.FeedBackActivity;
import com.airsen.button.ui.HelpActivity;
import com.airsen.button.ui.Libs;
import com.airsen.button.ui.shareFragment;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

     ArrayList<Node> allNode;
    public static final String CHANNEL_ID = "channel 1";
    public static ArrayList<Record> arrayListTakeRecord;
    public static TabLayout tabLayout;
    boolean check;
    RadioButton rbVn, rbEl;
    Button btnStLanguage;
    public static int currentNode = 0;
    public static boolean checkLanguage = false;
    public static boolean cheIntent = false;
    final String url = "";
    EditText mEdtUserName, mEdtPassword;
    TextView mTvForgotPw;
    Button mBtnSignIn;
    String mUserName, mPassword;
    public long backButton;

    private static final int Frangment_home = 1;
    private static final int Frangment_gellery = 2;
    private static final int Frangment_slideshow = 3;
    private static final int Fragment_chart = 4;
    private int curentFrangment = Frangment_home;

    private AppBarConfiguration mAppBarConfiguration;
    private BottomNavigationView mbottomNavigationView;
    private DrawerLayout drawer;
    private ViewPager mviewPager;

    private static final int Fragment_about = 1;
    private static final int Fragment_notifi = 2;
    private static final int Fragment_contact = 3;
    private static final int Fragment_share = 4;
    private static final int Fragment_help = 5;
    private static final int Fragment_feedback = 6;
    private static final int Fragment_smartconfit = 7;
    private static final int Fragment_language = 8;

    TextView mTvTakeData;
    ImageView mImvTakeData;
    public static SharedPreferences mSaveFavoritePlace;
    public static SharedPreferences prefs;
    NavigationView mnavigationView;

    private ImageView imageViewavatar;
    private  TextView tvname;
    private  TextView tvemail;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


       setLayout();
       // dialogSettingLanguage();
    }


    public void setLayout() {
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        iniUi();

//        drawer = findViewById(R.id.drawer_layout);
//        NavigationView navigationView = findViewById(R.id.nav_view);
//
//        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_language, R.id.nav_notification,
//                R.id.nav_about, R.id.nav_help, R.id.nav_feedback, R.id.nav_share, R.id.nav_contact)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        mnavigationView.setNavigationItemSelectedListener(this);
        showInformation();




        repalceFragment(new Home2Fragment());


//        mviewPager = findViewById(R.id.nav_host_fragment);
        mbottomNavigationView = findViewById(R.id.bottom_navigation);
        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_home:

                        openhomeFragment();
                        break;
                    case R.id.action_gellery:
                        //mviewPager.setCurrentItem(1);
                        opengelleryFragment();
                        break;
                    case R.id.action_slideshow:
                        //mviewPager.setCurrentItem(2);
                        openslideshowFragment();
//            Intent intent = new Intent(MainActivity.this, slideshowFragment.class);
//            startActivity(intent);
//            finish();
                        break;
                    case R.id.action_chart:
//                        mviewPager.setCurrentItem(3);
                        openchartFragment();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();

    }
    private void iniUi(){
        mnavigationView = findViewById(R.id.nav_view);
        imageViewavatar = mnavigationView.getHeaderView(0).findViewById(R.id.imageView);
        tvname = mnavigationView.getHeaderView(0).findViewById(R.id.text_name);
        tvemail = mnavigationView.getHeaderView(0).findViewById(R.id.textView_email);

    }
    private void showInformation(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user==null){
            return;
        }

        String name = user.getDisplayName();
        String email = user.getEmail();
        Uri photoUri = user.getPhotoUrl();

        if (name == null){
            tvname.setVisibility(View.GONE);
        }else {
            tvname.setVisibility(View.VISIBLE);
            tvname.setText(name);
        }

        tvname.setText(name);
        tvemail.setText(email);
        Glide.with(this).load(photoUri).error(R.drawable.ic_avatar).into(imageViewavatar);
    }


    private void openhomeFragment(){
        if(curentFrangment != Frangment_home){
            repalceFragment(new Home2Fragment());
            curentFrangment = Frangment_home;

        }
    }
    private void opengelleryFragment(){
        if(curentFrangment != Frangment_gellery){
            repalceFragment(new gelleryFragment());
            curentFrangment = Frangment_gellery;

        }
    }
    private void openslideshowFragment(){
        if(curentFrangment != Frangment_slideshow){
            repalceFragment(new slideshowFragment());
            curentFrangment = Frangment_slideshow;

        }

    }
    private void openchartFragment(){
        if(curentFrangment != Fragment_chart){
            repalceFragment(new ChartFragment());
            curentFrangment = Fragment_chart;

        }
    }
    private void repalceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.commit();
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
        int id = Item.getItemId();
        if (id == R.id.nav_language) {
            dialogSettingLanguage();

        } else if (id == R.id.nav_notification) {
            dialogSettingNotification(MainActivity.this);

        } else if (id == R.id.nav_contact) {
            if (curentFrangment != Fragment_contact) {
                repalceFragment(new ContactActivity());
                curentFrangment = Fragment_contact;
            }
//            Intent intent = new Intent(this, ContactActivity.class);
//            startActivity(intent);
        } else if (id == R.id.nav_share) {
            if (curentFrangment != Fragment_share) {
                repalceFragment(new shareFragment());
                curentFrangment = Fragment_share;
            }

        } else if (id == R.id.nav_feedback) {
            if (curentFrangment != Fragment_feedback) {
                repalceFragment(new FeedBackActivity());
                curentFrangment = Fragment_feedback;
            }
//            Intent intent = new Intent(this, FeedBackActivity.class);
//            startActivity(intent);
        } else if (id == R.id.nav_help) {
            if (curentFrangment != Fragment_help) {
                repalceFragment(new HelpActivity());
                curentFrangment = Fragment_help;
            }
//            Intent intent = new Intent(this, HelpActivity.class);
//            startActivity(intent);
        } else if (id == R.id.nav_about) {
            if (curentFrangment != Fragment_about) {
                repalceFragment(new AboutActivity());
                curentFrangment = Fragment_about;
            }
        }else if(id == R.id.nav_signout){
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(this, SigninActivity.class);
            startActivity(intent);
            finish();
//            Intent intent = new Intent(this, AboutActivity.class);
//            startActivity(intent);
        } else if (id == R.id.nav_smartcogfict) {
//            if (curentFrangment != Fragment_smartconfit) {
//                repalceFragment(new );
//                curentFrangment = Frangment_notifi;
//            }
            //Intent intent = new Intent(this, SmartConfigActivity.class);
            // startActivity(intent);

        } else if (id == R.id.nav_addnote) {
            dialogSignIn();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
    private void dialogSettingLanguage() {
        final Dialog mDialog = new Dialog(this);
        mDialog.setContentView(R.layout.fragment_language);
        Window window = mDialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        rbVn = mDialog.findViewById(R.id.rb_vietnamese);
        rbEl = mDialog.findViewById(R.id.rb_english);

        btnStLanguage = mDialog.findViewById(R.id.btn_setting_language);

        btnStLanguage.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String lang = "";
                if (rbVn.isChecked()) {
                    Toast.makeText(MainActivity.this, "Vi", Toast.LENGTH_SHORT).show();
                    lang = "vi";
                    checkLanguage = true;
                    mDialog.cancel();
                    Libs.changeLang(lang, MainActivity.this);
                    setLayout();
                } else if (rbEl.isChecked()) {
                    Toast.makeText(MainActivity.this, "El", Toast.LENGTH_SHORT).show();
                    lang = "";
                    checkLanguage = true;
                    mDialog.cancel();
                    Libs.changeLang(lang, MainActivity.this);
                    setLayout();
                }
                Libs.changeLang(lang, MainActivity.this);
            }
        });
        mDialog.show();
    }
    public  void dialogSettingNotification(final Context context) {
        Button btnStNotification, btncustom;
        final CheckBox cbNotfcation1, cbNotfcation2;
        final Dialog mDialog1 = new Dialog(context);
        mDialog1.setContentView(R.layout.dialog_setting_notification);
        Window window = mDialog1.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        cbNotfcation1 = mDialog1.findViewById(R.id.cb_notf1);
        cbNotfcation2 = mDialog1.findViewById(R.id.cb_notf2);
        btnStNotification = mDialog1.findViewById(R.id.btn_setting_notification);
        btncustom = mDialog1.findViewById(R.id.btn_custom_notification);

        btnStNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cbNotfcation1.isChecked()) {
                    Toast.makeText(context, "Sent me notification in my place", Toast.LENGTH_SHORT).show();
                    //NotificationMyHome();
                    CustomNotificationNearMe();


                }

                if (cbNotfcation2.isChecked()) {
                    Log.d("why", "2");
                    Toast.makeText(context, "Sent me notification near me", Toast.LENGTH_SHORT).show();
                    //NotificationNearMe();
                    CustomNotificationNearMe();
                }


                mDialog1.cancel();
            }
        });

        btncustom.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.btn_custom_notification){

                    Intent intent = new Intent(MainActivity.this, flagactivity.class);
                    startActivity(intent);


                }
            }
        });
        mDialog1.show();
    }

    private void NotificationNearMe() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification notification = new NotificationCompat.Builder(this, MyAplication.CHANNEL_ID)
                .setContentTitle("NotificationNearMe")
                .setContentText("near me")
                .setSound(uri)
                .setSmallIcon(R.drawable.airmap_logo)
                //.setLargeIcon(bitmap)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager!= null){
            notificationManager.notify(getNotificationID(),notification);
        }
    }
    private void NotificationMyHome() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        Notification notification = new NotificationCompat.Builder(this, MyAplication.CHANNEL_ID_2)
                .setContentTitle("NotificationMyHome")
                .setContentText("My home")
                .setSound(uri)
                .setSmallIcon(R.drawable.airmap_logo)
                //.setLargeIcon(bitmap)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager!= null){
            notificationManager.notify(getNotificationID(),notification);
        }

    }
    private void CustomNotificationNearMe(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

//         getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout,new ChartFragment()).commit();
        Intent resultIntent = new Intent (this, SigninActivity.class);
// Create the TaskStackBuilder and add the intent, which inflates the back stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
// Get the PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);


        RemoteViews notificationlayout = new RemoteViews(getPackageName(),R.layout.custom_notification);
        notificationlayout.setTextViewText(R.id.tv_titile_custom,"airsen");
        notificationlayout.setTextViewText(R.id.tv_messege_custom,"messege custom notification");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(new Date());
        notificationlayout.setTextViewText(R.id.tv_messege_custom,time);

        Notification notification = new NotificationCompat.Builder(this, MyAplication.CHANNEL_ID_2)
                .setSound(uri)
                .setSmallIcon(R.drawable.airmap_logo)
                .setCustomContentView(notificationlayout)
                .setContentIntent(resultPendingIntent)
                //.setLargeIcon(bitmap)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager!= null){
            notificationManager.notify(getNotificationID(),notification);
        }
    }


    private int getNotificationID() {
        return (int) new Date().getTime();
    }

    private void dialogSignIn() {
        final Dialog mDialog = new Dialog(this);
        mDialog.setContentView(R.layout.dialog_sign_in_developer);
        Window window = mDialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        mEdtUserName = mDialog.findViewById(R.id.edt_username);
        mEdtPassword = mDialog.findViewById(R.id.edt_password);
        mTvForgotPw = mDialog.findViewById(R.id.tv_forgotpw);
        mBtnSignIn = mDialog.findViewById(R.id.btn_signin);
        Log.d("failxx", "1");
        mBtnSignIn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {

                mUserName = mEdtUserName.getText().toString().trim();
                mPassword = mEdtPassword.getText().toString().trim();
                Log.d("failxx", "0" + mUserName + ".." + mPassword);

                if (mUserName.equals("") || mPassword.equals("")) {

                    mEdtUserName.setError("fail");
                } else {
                    mDialog.cancel();
                    CheckPassword(url, mUserName, mPassword);
                    mEdtUserName.setText("login success");
                }

            }
        });
        mDialog.show();
    }
        private void CheckPassword(String url, final String useName, final String passWord) {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("failxx", "" + response.toString());
                            if (response.trim().equals("login_success")) {
                                Intent intent = new Intent(MainActivity.this, AddNewDeviceActivity.class);
                                startActivity(intent);

                            } else if (response.trim().equals("login_fail")) {
                                dialogSignIn();
                                Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_LONG).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> param = new HashMap<>();
                    param.put("UserName", useName);
                    param.put("PassWord", passWord);
                    return param;
                }
            };

            requestQueue.add(stringRequest);
        }
    private void Getdat() {
        datasevice datasevice = ApiUtils.getService();

        datasevice.Getaqicurrentday().enqueue(new Callback<List<Node>>() {

            @Override
            public void onResponse(Call<List<Node>> call, retrofit2.Response<List<Node>> response) {
                allNode = (ArrayList<Node>) response.body();
                for (int i = 0; i < allNode.size(); i++) {
                    Log.d("checkkkkkkk12", "acb");
                    int bt = (int) allNode.get(i).getAqi();
                }

            }

            @Override
            public void onFailure(Call<List<Node>> call, Throwable t) {

            }
        });
    }



}