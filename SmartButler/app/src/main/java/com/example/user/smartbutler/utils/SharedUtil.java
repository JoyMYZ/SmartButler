package com.example.user.smartbutler.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Project_name:   SmartButler
 * Package_name:   com.example.user.smartbutler.utils
 * User:           ${User}
 * Date&Time:      2018/2/16 19:44
 * Description:    SharedPreference封装类
 **/

public class SharedUtil {
    private static final String SHARED_NAME="Shared";

    public static void putString(Context mContext,String key,String value){
        SharedPreferences shared=mContext.getSharedPreferences(SHARED_NAME,Context.MODE_PRIVATE);
        shared.edit().putString(key,value).commit();
    }

    public static String getString(Context mContext,String key,String defValue){
        SharedPreferences shared=mContext.getSharedPreferences(SHARED_NAME,Context.MODE_PRIVATE);
        return shared.getString(key,defValue);
    }

    public static void putInt(Context mContext,String key,int value){
        SharedPreferences shared=mContext.getSharedPreferences(SHARED_NAME,Context.MODE_PRIVATE);
        shared.edit().putInt(key,value).commit();
    }

    public static int getInt(Context mContext,String key,int defValue){
        SharedPreferences shared=mContext.getSharedPreferences(SHARED_NAME,Context.MODE_PRIVATE);
        return shared.getInt(key,defValue);
    }

    public static void putBoolean(Context mContext,String key,boolean value){
        SharedPreferences shared=mContext.getSharedPreferences(SHARED_NAME,Context.MODE_PRIVATE);
        shared.edit().putBoolean(key,value).commit();
    }

    public static boolean getBoolean(Context mContext,String key,boolean defValue){
        SharedPreferences shared=mContext.getSharedPreferences(SHARED_NAME,Context.MODE_PRIVATE);
        return shared.getBoolean(key,defValue);
    }

    public static void deleteItem(Context mContext,String key){
        SharedPreferences shared=mContext.getSharedPreferences(SHARED_NAME,Context.MODE_PRIVATE);
        shared.edit().remove(key);
    }

    public static void deleteAll(Context mContext){
        SharedPreferences shared=mContext.getSharedPreferences(SHARED_NAME,Context.MODE_PRIVATE);
        shared.edit().clear().commit();
    }
}
