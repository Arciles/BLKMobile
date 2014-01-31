package com.BLKBelediye.balikesirbelediye;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by EsatTaha on 29.01.2014.
 */
public class Splash extends Activity
{
    Timer timer = new Timer();
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        timer.schedule(new TimerTask() {
            public void run() {
                Intent intent = new Intent(Splash.this, MainMenu.class);
                startActivity(intent);
            }
        }, 2000);
    }

}














/*
public class Splash extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Splash screen", " Layoutu yuklenicek");
        setContentView(R.layout.splash_screen);
        Log.d("Splash screen", " Layoutu yukledi");
        Thread timer = new Thread(){
            @Override
            public void run() {

                try {
                    sleep(5000);
                    Log.d("Splash screen", " Basariyla uyudu");

                } catch (InterruptedException e) {
                   Log.d("Splash screen", " Uyumaksızın buraya atladı");
                    e.printStackTrace();
                }
                finally {

                        Intent startIntent;
                        startIntent = new Intent("android.intent.action.MAINMENU");
                        startActivity(startIntent);

                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
*/
