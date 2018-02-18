package com.example.user.smartbutler.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.user.smartbutler.MainActivity;
import com.example.user.smartbutler.R;
import com.example.user.smartbutler.utils.LogUtil;
import com.example.user.smartbutler.utils.SharedUtil;
import com.example.user.smartbutler.utils.StaticClass;
import com.example.user.smartbutler.utils.UtilTools;

/**
 * Project_name:   SmartButler
 * Package_name:   com.example.user.smartbutler.ui
 * User:           ${User}
 * Date&Time:      2018/2/17 18:30
 * Description:    启动页
 *
 * 1.等待两秒钟
 * 2.判断是否第一次启动
 *      2.1.第一次启动，进入BootActivity,设置启动标志
 *      2.2.非第一次启动，进入MainActivity
 *
 *
 **/

public class StartActivity extends AppCompatActivity{
    private Handler start_handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                //接到启动消息
                case StaticClass.ENTER_BOOT: {
                    LogUtil.i(String.valueOf(SharedUtil.getBoolean(StartActivity.this,StaticClass.FIRST_START,false)));
                    if(isFirst()){
                        startActivity(new Intent(StartActivity.this,BootActivity.class));
                    }else{
                        startActivity(new Intent(StartActivity.this, MainActivity.class));
                    }
                    finish();
                    break;
                }
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initView();
    }

    private void initView() {
        start_handler.sendEmptyMessageDelayed(StaticClass.ENTER_BOOT,StaticClass.START_DELAY);
        TextView title=findViewById(R.id.title);
        //工具类设置字体
        UtilTools.setTypeFace(this,title,"font/FZLTCXHJW.TTF");
    }

    private boolean isFirst() {
        boolean is_first= SharedUtil.getBoolean(this,StaticClass.FIRST_START,true);
        if(is_first){
            SharedUtil.putBoolean(this,StaticClass.FIRST_START,false);
        }
        return is_first;
    }
}
