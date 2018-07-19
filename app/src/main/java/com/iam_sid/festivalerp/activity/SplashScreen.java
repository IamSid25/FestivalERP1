package com.iam_sid.festivalerp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.iam_sid.festivalerp.R;
import com.iam_sid.festivalerp.utils.SharedPreferenceUtils;

public class SplashScreen extends Activity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        init();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,Dashboard.class));
                finish();
            }
        },SPLASH_TIME_OUT);
    }

    private void init(){
        TextView txtFooter=(TextView)findViewById(R.id.tvFooter);

        SharedPreferenceUtils sharedPreferenceUtils=new SharedPreferenceUtils(this);
        sharedPreferenceUtils.setDeviceResolution();
    }
}
