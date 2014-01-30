package com.BLKBelediye.balikesirbelediye;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;

/**
 * Created by EsatTaha on 29.01.2014.
 */
public class Splash extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Thread timer = new Thread(){
            @Override
            public void run() {

                try {
                    sleep(1000);

                } catch (InterruptedException e) {
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
