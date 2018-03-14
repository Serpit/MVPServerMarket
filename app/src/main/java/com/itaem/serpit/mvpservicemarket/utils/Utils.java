package com.itaem.serpit.mvpservicemarket.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.widget.TextView;
import android.widget.Toast;

import com.norbsoft.typefacehelper.TypefaceCollection;
import com.norbsoft.typefacehelper.TypefaceHelper;



/*工具类*/
public class Utils {



    public static void toArtFront(Context context, TextView textView){
        TypefaceCollection typefaceCollection = new TypefaceCollection.Builder()
                .set(Typeface.NORMAL, Typeface.createFromAsset(context.getAssets(), "front.TTF"))
                .create();
        TypefaceHelper.init(typefaceCollection);
        TypefaceHelper.typeface(textView);
    }



}
