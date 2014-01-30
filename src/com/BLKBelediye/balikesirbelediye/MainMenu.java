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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainMenu extends Activity implements View.OnClickListener{

	private static ArrayList<ArrayList> result = new ArrayList<ArrayList>();
	TextView tx;
	String temp;
    ImageButton baskan;
    ImageButton kurumsal;
    ImageButton haberler;
    ImageButton duyurular;
    ImageButton balikesir;
    ImageButton e_belediye;
    ImageButton etkinlikler;
    ImageButton e_rehber;
    ImageButton hizmetler;
    ImageButton fotograflar;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);

        initialize();//ImageButton lari bu method icinde initialize ettim

        kurumsal.setOnClickListener(this);








        /*
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
				tx.setText(temp);*/
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
/*
* Bu kisim bu class icinde kullanilan methodlari tanimlamak icin ayrilmistir
* */

    private void initialize()
    {
        baskan = (ImageButton) findViewById(R.id.ibBaskan);
        kurumsal =(ImageButton) findViewById(R.id.ibKurumsal);
        haberler = (ImageButton) findViewById(R.id.ibHaberler);
        duyurular = (ImageButton) findViewById(R.id.ibDuyurular);
        balikesir = (ImageButton) findViewById(R.id.ibBalikesir);
        e_belediye = (ImageButton) findViewById(R.id.ibEBelediye);
        etkinlikler = (ImageButton) findViewById(R.id.ibEtkinlikler);
        e_rehber = (ImageButton) findViewById(R.id.ibERehber);
        hizmetler = (ImageButton) findViewById(R.id.ibHizmetler);
        fotograflar = (ImageButton) findViewById(R.id.ibFotoğraflar);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ibKurumsal :



                break;
            case R.id.ibBalikesir :
                break;
            case R.id.ibBaskan :
                break;
            case R.id.ibDuyurular :
                break;
            case R.id.ibEBelediye :
                break;
            case R.id.ibERehber :
                break;
            case R.id.ibEtkinlikler :
                break;
            case R.id.ibHaberler :
                break;
            case R.id.ibHizmetler :
                break;
            case R.id.ibFotoğraflar :
                break;
        }
    }
}
