package com.itaem.serpit.mvpservicemarket.utils;


import android.content.Context;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

public class BDLocationHelper {
    private LocationClient locationClient ;
    private static LocationClientOption locationClientOption;
    Context context;

    static {
        locationClientOption   =  new LocationClientOption();
        locationClientOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        locationClientOption.setOpenGps(true);
        locationClientOption.setCoorType("bd09ll");
        locationClientOption.setIsNeedAddress(true);
    }


    public BDLocationHelper(BDLocationListener bdLocationListener, Context context){

        locationClient = new LocationClient(context);
        locationClient.setLocOption(locationClientOption);
        locationClient.registerLocationListener(bdLocationListener);
    }


    public  void stopClient(){
        if (locationClient!=null){
            if (locationClient.isStarted()){
                locationClient.stop();
            }
        }
    }
    public  void startClient(){
            if (!locationClient.isStarted()){
                locationClient.start();
            }

    }
}
