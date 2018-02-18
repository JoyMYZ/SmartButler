package com.example.user.smartbutler.utils;

import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Project_name:   SmartButler
 * Package_name:   com.example.user.smartbutler.utils
 * User:           ${User}
 * Date&Time:      2018/2/16 16:43
 * Description:    TODO
 **/

public class LogUtil {
        //控制开关，发布软件后关闭
        private static boolean SWITCH=false;
        private static final String TAG="Logging";

        /*  开启/关闭调试 */
        public static void start(){
            if(SWITCH==false) {
                SWITCH = true;
            }
        }

        public static void stop(){
            if(SWITCH==true){
                SWITCH=false;
            }
        }

        //四种调试模式
        public static void d(String message){
            if(SWITCH){
                Log.d(TAG,message);
            }
        }
        public static void i(String message){
            if(SWITCH){
                Log.i(TAG,message);
            }
        }

        public static void w(String message){
            if(SWITCH){
                Log.w(TAG,message);
            }
        }

        public static void e(String message) {
            if (SWITCH) {
                Log.e(TAG, message);
            }
        }
}
