package com.devpro.android54_day6.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.devpro.android54_day6.MyApplication;

public class PrefManager {
    public static final String PREF_NAME = "Android54_day6";

    public static void saveString(String key, String value) {
        SharedPreferences sharedPreferences = MyApplication.getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(key, value).commit();
    }

    public static String getString(String key){
        SharedPreferences sharedPreferences = MyApplication.getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,null);
    }
}
