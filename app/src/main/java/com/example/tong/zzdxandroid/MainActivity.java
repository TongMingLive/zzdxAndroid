package com.example.tong.zzdxandroid;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.example.tong.zzdxandroid.Fragment.Fragment1;
import com.example.tong.zzdxandroid.Fragment.Fragment2;
import com.example.tong.zzdxandroid.Fragment.Fragment3;
import com.example.tong.zzdxandroid.Util.PermissionTool;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private long exitTime = 0;
    private BottomNavigationView navigation;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private List<Fragment> list = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fragmentTransaction = getSupportFragmentManager()
                    .beginTransaction();
            fragmentTransaction.hide(list.get(0));
            fragmentTransaction.hide(list.get(1));
            fragmentTransaction.hide(list.get(2));
            fragmentTransaction.commit();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction.show(list.get(0));
                    return true;
                case R.id.navigation_introduce:
                    fragmentTransaction.show(list.get(1));
                    return true;
                case R.id.navigation_more:
                    fragmentTransaction.show(list.get(2));
                    return true;
            }
            fragmentTransaction.commit();
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkSdkVersion();

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //获取fragment管理者对象
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());

        fragmentTransaction.add(R.id.content,list.get(0));
        fragmentTransaction.add(R.id.content,list.get(1));
        fragmentTransaction.hide(list.get(1));
        fragmentTransaction.add(R.id.content,list.get(2));
        fragmentTransaction.hide(list.get(2));

        fragmentTransaction.show(list.get(0));
        fragmentTransaction.commit();
    }

    //判断sdk版本
    private void checkSdkVersion(){
        if (Build.VERSION.SDK_INT >= 23){
            //sdk版本6.0及以后
            PermissionTool.requestPermission(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},0X123);
        }
    }

    //权限回调事件
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0x123){
            for (int result : grantResults){
                if (PackageManager.PERMISSION_DENIED == result){
                    //用户拒绝授权
                    PermissionTool.showDialog(this,"拒绝后你将无法使用部分功能，是否前往修改");
                    break;
                }
            }
        }
    }

    //再次返回键退出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Snackbar.make(navigation, "再按一次退出程序", Snackbar.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
