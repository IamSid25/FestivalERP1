package com.iam_sid.festivalerp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class SharedPreferenceUtils {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public SharedPreferenceUtils( Context context) {
        this.sharedPreferences = context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
        this.editor = editor;
        this.context = context;
    }

    public void setDeviceResolution(){
        WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics=new DisplayMetrics();
        display.getMetrics(metrics);
        int width=metrics.widthPixels;
        int height=metrics.heightPixels;

        editor.putInt("height",height);
        editor.putInt("width",width);
        editor.commit();
    }
    public int getHeightDevice(){
        return sharedPreferences.getInt("Height",0);
    }
    public int getWidthDevice(){
        return sharedPreferences.getInt("Width",0);
    }

}
