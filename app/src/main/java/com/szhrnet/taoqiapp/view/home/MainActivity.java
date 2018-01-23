package com.szhrnet.taoqiapp.view.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.szhrnet.taoqiapp.R;
import com.szhrnet.taoqiapp.base.BaseActivity;
import com.szhrnet.taoqiapp.base.BaseApplication;
import com.szhrnet.taoqiapp.helper.BottomNavigationViewHelper;
import com.szhrnet.taoqiapp.helper.NavHelper;


/**
 * Created by Administrator on 2017/12/1.
 */

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavHelper.OnTabChangedListener<Integer> {

    private NavHelper<Integer> mNavHelper;
    private BottomNavigationView mNavigation;

    @Override
    public int bindLayout() {

        return R.layout.activity_main;
    }


    @Override
    protected void initWidget(Bundle savedInstanceState) {
        mNavigation = getViewById(R.id.navigation);

        // 初始化底部辅助工具类
        mNavHelper = new NavHelper<>(this, R.id.lay_container,
                getSupportFragmentManager(), this);
        mNavHelper.add(R.id.action_home, new NavHelper.Tab<>(HomeFragment.class, R.string.sy))
                .add(R.id.action_type, new NavHelper.Tab<>(QuizFragment.class, R.string.bf))
                .add(R.id.action_shop, new NavHelper.Tab<>(ScoreFragment.class, R.string.jc))
                .add(R.id.action_cart, new NavHelper.Tab<>(MineFragment.class, R.string.wd));
        // 添加对底部按钮点击的监听
        BottomNavigationViewHelper.disableShiftMode(mNavigation);
        mNavigation.setOnNavigationItemSelectedListener(this);

        // 从底部导中接管我们的Menu，然后进行手动的触发第一次点击
        Menu menu = mNavigation.getMenu();
        // 触发首次选中Home
        menu.performIdentifierAction(R.id.action_home, 0);
    }


    @Override
    public void widgetClick(View v) {
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return mNavHelper.performClickMenu(item.getItemId());
    }

    @Override
    public void onTabChanged(NavHelper.Tab<Integer> newTab, NavHelper.Tab<Integer> oldTab) {
        NavHelper.Tab<Integer> currentTab = mNavHelper.getCurrentTab();

    }

}

