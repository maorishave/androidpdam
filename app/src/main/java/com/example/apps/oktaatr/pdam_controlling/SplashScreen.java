package com.example.apps.oktaatr.pdam_controlling;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.apps.oktaatr.pdam_controlling.Controller.SessionManager;

public class SplashScreen  extends AppCompatActivity {
    private ImageView iv1,iv2;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        sessionManager=new SessionManager(this);

        //final Intent i=new Intent(SplashScreen.this,LoginActivity.class);
        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(2000);
                    if(sessionManager.isLoggedIn()){
                        startActivity(new Intent(SplashScreen.this,MainActivity.class));
                    }else
                        startActivity(new Intent(SplashScreen.this,LoginActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        timer.start();
    }
}
