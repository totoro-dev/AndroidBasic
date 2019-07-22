package com.hlm.basic;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.hlm.basic.activity.BasicActivity;

public class MainActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSelfActionBarWithTitle(R.layout.action_bar_view,R.id.tv_title,"Main");
//        request(Manifest.permission.CAMERA,Manifest.permission.BODY_SENSORS,Manifest.permission.ACCESS_WIFI_STATE,Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_MMS,Manifest.permission.SEND_SMS},1);
//        request(null,Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        request(null,Manifest.permission.CAMERA);
//        request(null,Manifest.permission.BODY_SENSORS);
//        request(null,Manifest.permission.RECEIVE_MMS);
        request(Manifest.permission.SEND_SMS);
//        new Thread() {
//            private Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    setDefaultHelp("This is default help!");
//                    setHelpListener("This is main listener");
//                }
//            };
//            @Override
//            public void run() {
//                if (isRequested(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                    runnable.run();
//                } else {
//                    request(runnable, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//                }
//            }
//        }.start();
    }
}
