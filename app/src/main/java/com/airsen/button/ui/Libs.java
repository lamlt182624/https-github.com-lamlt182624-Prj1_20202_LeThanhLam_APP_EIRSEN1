package com.airsen.button.ui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.Locale;



public class Libs {
    /* ------------------------------------- */
    private static Locale myLocale;
    //private String lang = "";
    // Lưu ngôn ngữ đã cài đặt
    public static void saveLocale(String lang, Activity activity) {
        String langPref = "Language";

    }
    // Load lại ngôn ngữ đã lưu và thay đổi chúng
    public static void loadLocale(Activity activity) {
        String langPref = "Language";

    }
    // method phục vụ cho việc thay đổi ngôn ngữ.
    public static void changeLang(String lang, Activity activity) {
        //if (lang.equals(""))
        //    return;
        myLocale = new Locale(lang);
        saveLocale(lang, activity);
        Locale.setDefault(myLocale);

        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        activity.getBaseContext().getResources().updateConfiguration(config,
                activity.getBaseContext().getResources().getDisplayMetrics());

    }
}
