package com.assassinshadow.themeengine;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferencesAPI {


    public static void SetBoolean(Context context, String key, boolean bool)
    {
        SharedPreferences sp  = context.getSharedPreferences("ThemeEngine", 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, bool);
        editor.apply();
    }

    public static boolean getBoolean (Context context, String key)
    {
        SharedPreferences sp  = context.getSharedPreferences("ThemeEngine", 0);
        return sp.getBoolean(key,true);
    }


    public static void setBoolean(Context context,String key, boolean flag)
    {
        SharedPreferences pref = context.getSharedPreferences("ThemeEngine", 0);
        SharedPreferences.Editor editor = pref.edit();

        editor.putBoolean(key, flag);
        editor.commit();

    }

    public static boolean getBooleanTrueDefault(Context context,String key)
    {
        SharedPreferences pref = context.getSharedPreferences("ThemeEngine", 0);

        return pref.getBoolean(key, true);
    }
    public static String getString(Context context,String key)
    {
        SharedPreferences pref = context.getSharedPreferences("ThemeEngine", 0);

        return pref.getString(key, "");
    }
    public static void SetString(Context context,String key, String Value)
    {
        SharedPreferences pref =context.getSharedPreferences("ThemeEngine", 0);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString(key, Value);
        editor.commit();
    }
    public static void SetInt(Context context,String key, int Value)
    {
        SharedPreferences pref =context.getSharedPreferences("ThemeEngine", 0);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt(key, Value);
        editor.commit();
    }
    public static int getInt(Context context,String key, int Default)
    {
        SharedPreferences pref = context.getSharedPreferences("ThemeEngine", 0);

        return pref.getInt(key, Default);
    }




}
