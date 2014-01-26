package com.BLKBelediye.balikesirbelediye;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class MainMenu extends Activity {

	private static ArrayList<ArrayList> result = new ArrayList<ArrayList>();
	TextView tx;
	String temp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		tx = (TextView) findViewById(R.id.tvView);
		temp = "";
				try {
					result = MethodInfoGetter.methodRequest("BaskanOzgecmisGetir", "", "");
					Log.i("MainMenu","Result gelis vakti");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(result.isEmpty())
				{
					tx.setText("Result is emty");
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
				tx.setText(temp);
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

}
