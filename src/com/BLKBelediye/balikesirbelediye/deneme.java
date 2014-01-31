package com.BLKBelediye.balikesirbelediye;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by EsatTaha on 30.01.2014.
 */
public class deneme extends Activity {
    String temp;
    private static ArrayList<ArrayList> result = new ArrayList<ArrayList>();
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deneme);

        tv = (TextView) findViewById(R.id.tvDeneme);

        temp = "";
        try {
            result = MethodInfoGetter.methodRequest("BelediyeMeclisiGetir", "", "");
            Log.i("MainMenu", "Result gelis vakti");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(result.isEmpty())
        {
            tv.setText("Result is emty");
        }
        else
        {
            for(int i = 0 ; i < result.size() ; i++)
            {
                for(int j = 0 ; j < result.get(i).size() ; j++ )
                {
                    temp += result.get(i).get(j) + " \n";

                }
            }
        }
        tv.setText(temp);

    }
}
