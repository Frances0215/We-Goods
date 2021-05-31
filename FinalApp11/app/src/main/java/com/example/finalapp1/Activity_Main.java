package com.example.finalapp1;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

public class Activity_Main extends AppCompatActivity implements View.OnClickListener {
    ViewPager2 viewPager;
    private LinearLayout llHome, llBox, llMe;
    private ImageView ivHome, ivBox, ivMe, ivCurrent;

    //private MySQLiteOpenHelper dbhelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initPager();
        initTabView();
        //页面跳转
        if(getIntent().getIntExtra("id",0) == 1){
            gotoDownloadFragment();
        }

        // dbhelper=new MySQLiteOpenHelper(this);
    }




    private void initTabView() {
        //LinearLayout
        llHome = findViewById(R.id.id_tab_home);
        llHome.setOnClickListener(this);
        llBox = findViewById(R.id.id_tab_box);
        llBox.setOnClickListener(this);
        llMe = findViewById(R.id.id_tab_me);
        llMe.setOnClickListener(this);
        //ImageView
        ivHome = findViewById(R.id.id_iv_home);
        ivBox = findViewById(R.id.id_iv_box);
        ivMe = findViewById(R.id.id_iv_me);

        ivHome.setSelected(true);
        ivCurrent = ivHome;

    }

    private void initPager(){
        viewPager = findViewById(R.id.id_viewpager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(Fragment_2.newInstance("首页"));
        fragments.add(Fragment_1.newInstance("储物箱"));
        fragments.add(Fragment_3.newInstance("我的"));
        MyFragmentPagerAdepter pagerAdepter = new MyFragmentPagerAdepter(
                getSupportFragmentManager(), getLifecycle(), fragments);
        viewPager.setAdapter(pagerAdepter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changeTab(int position) {
        ivCurrent.setSelected(false);
        switch (position) {
            case R.id.id_tab_home:
                viewPager.setCurrentItem(0);
            case 0:
                ivHome.setSelected(true);
                ivCurrent = ivHome;
                break;
            case R.id.id_tab_box:
                viewPager.setCurrentItem(1);
            case 1:
                ivBox.setSelected(true);
                ivCurrent = ivBox;
                break;
            case R.id.id_tab_me:
                viewPager.setCurrentItem(2);
            case 2:
                ivMe.setSelected(true);
                ivCurrent = ivMe;
                break;
        }
    }

    @Override
    public void onClick(View view) {
        changeTab(view.getId());
    }

    public void gotoDownloadFragment() {    //去下载页面
        FragmentManager fManager = getSupportFragmentManager();
        FragmentTransaction fTransaction = fManager.beginTransaction();
        Fragment_3  fragment3 = new Fragment_3();
        fTransaction.replace(R.id.id_fragment_3, fragment3);
        fTransaction.commit();
    }


}
