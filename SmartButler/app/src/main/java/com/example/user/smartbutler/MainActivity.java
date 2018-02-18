package com.example.user.smartbutler;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user.smartbutler.fragment.ButlerFragment;
import com.example.user.smartbutler.fragment.GirlFragment;
import com.example.user.smartbutler.fragment.MyFragment;
import com.example.user.smartbutler.fragment.WechatFragment;
import com.example.user.smartbutler.ui.SettingActivity;
import com.example.user.smartbutler.utils.LogUtil;
import com.example.user.smartbutler.utils.SharedUtil;
import com.example.user.smartbutler.utils.UtilTools;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private FloatingActionButton fab_setting;
    private List<String> mTitles;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //开启调试模式
        LogUtil.start();

        //消除阴影
        getSupportActionBar().setElevation(0);
        initData();
        initView();
    }

    private void initData() {
        Resources resources = getResources();
        mTitles = new ArrayList<>();
        mTitles.add(resources.getString(R.string.viewPager_fragment1_butler));
        mTitles.add(resources.getString(R.string.viewPager_fragment2_wechat));
        mTitles.add(resources.getString(R.string.viewPager_fragment3_girl));
        mTitles.add(resources.getString(R.string.viewPager_fragment4_my));

        mFragments = new ArrayList<>();
        mFragments.add(new ButlerFragment());
        mFragments.add(new WechatFragment());
        mFragments.add(new GirlFragment());
        mFragments.add(new MyFragment());
    }

    private void initView() {
        fab_setting=findViewById(R.id.fab_setting);
        mTablayout = findViewById(R.id.mTabLayout);
        mViewPager = findViewById(R.id.mViewPager);

        //预加载
        mViewPager.setOffscreenPageLimit(mFragments.size());

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    //管家
                    case 0:{
                        fab_setting.setVisibility(View.GONE);
                        break;
                    }
                    default:fab_setting.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //TabActivity绑定一个ViewPager
        mTablayout.setupWithViewPager(mViewPager);

        //浮动按钮设置
        fab_setting.setOnClickListener(this);
        fab_setting.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_setting:
                startActivity(new Intent(this,SettingActivity.class));
        }
    }
}
