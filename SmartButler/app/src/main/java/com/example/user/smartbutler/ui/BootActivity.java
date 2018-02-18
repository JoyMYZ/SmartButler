package com.example.user.smartbutler.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.user.smartbutler.MainActivity;
import com.example.user.smartbutler.R;
import com.example.user.smartbutler.fragment.BootFirstFragment;
import com.example.user.smartbutler.fragment.BootSecondFragment;
import com.example.user.smartbutler.fragment.BootThirdFragment;
import com.example.user.smartbutler.utils.LogUtil;
import com.example.user.smartbutler.utils.SharedUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Project_name:   SmartButler
 * Package_name:   com.example.user.smartbutler.ui
 * User:           ${User}
 * Date&Time:      2018/2/17 18:28
 * Description:    引导页
 **/

public class BootActivity extends AppCompatActivity{
    private Button btn;
    private ViewPager splashView;
    private List<Fragment> pages=new ArrayList<>();
    private List<RadioButton> radios=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot);
        initView();
    }

    private void initView() {
        btn=findViewById(R.id.boot_finish);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BootActivity.this,MainActivity.class));
                finish();
            }
        });

        radios.add((RadioButton) findViewById(R.id.btn_firstSnap));
        radios.add((RadioButton) findViewById(R.id.btn_secondSnap));
        radios.add((RadioButton) findViewById(R.id.btn_thirdSnap));

        pages.add(new BootFirstFragment());
        pages.add(new BootSecondFragment());
        pages.add(new BootThirdFragment());

        splashView=findViewById(R.id.boot_viewPager);
        splashView.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return pages.get(position);
            }

            @Override
            public int getCount() {
                return pages.size();
            }
        });

        splashView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                radios.get(position).toggle();
                if(position==pages.size()-1){
                    btn.setVisibility(View.VISIBLE);
                }else{
                    if(btn.getVisibility()==View.VISIBLE){
                        btn.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
