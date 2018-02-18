package com.example.user.smartbutler.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

/**
 * Project_name:   SmartButler
 * Package_name:   com.example.user.smartbutler.utils
 * User:           ${User}
 * Date&Time:      2018/2/16 14:14
 * Description:    TODO
 **/

public class UtilTools {
    public static void setTypeFace(Context mContext, TextView view, String path){
        Typeface type = Typeface.createFromAsset(mContext.getAssets(),path);
        view.setTypeface(type);
    }
}
