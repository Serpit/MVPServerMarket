package com.itaem.serpit.mvpservicemarket.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.itaem.serpit.mvpservicemarket.R;
import com.itaem.serpit.mvpservicemarket.utils.Utils;


//欢迎页面 五秒后跳到主页面
public class WelcomeActivity extends AppCompatActivity {
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //跳转到MainActivity
            startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        initView();
        judgeAuthority();
        Message message = new Message();
        message.what = 1;
        handler.sendMessageDelayed(message,3*1000);//五秒后跳转
    }

    //初始化各种View
    public void initView(){
        TextView textView = (TextView) findViewById(R.id.textView);
        Utils.toArtFront(this,textView);
    }
    public void judgeAuthority(){//权限判断
        if (Build.VERSION.SDK_INT >= 23) {
            String[] permissions = {
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            };

            if (checkSelfPermission(permissions[0]) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(permissions, 0);
            }
        }
    }
}
