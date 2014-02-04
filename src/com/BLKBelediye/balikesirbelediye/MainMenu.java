package com.BLKBelediye.balikesirbelediye;

import java.io.IOException;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

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

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
        ImageLoader.getInstance().init(config);

        baskan.setOnClickListener(this);
        kurumsal.setOnClickListener(this);
        haberler.setOnClickListener(this);
        duyurular.setOnClickListener(this);
        balikesir.setOnClickListener(this);
        e_belediye.setOnClickListener(this);
        etkinlikler.setOnClickListener(this);
        e_rehber.setOnClickListener(this);
        hizmetler.setOnClickListener(this);
        fotograflar.setOnClickListener(this);




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
        e_belediye = (ImageButton) findViewById(R.id.ibBelediye);
        etkinlikler = (ImageButton) findViewById(R.id.ibEtkinlikler);
        e_rehber = (ImageButton) findViewById(R.id.ibRehber);
        hizmetler = (ImageButton) findViewById(R.id.ibHizmetler);
        fotograflar = (ImageButton) findViewById(R.id.ibFotograflar);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ibKurumsal:

                Intent kurumIntent = new Intent("android.intent.action.KURUMSAL");
                startActivity(kurumIntent);
                break;
            case R.id.ibBalikesir :

                Intent balikesirIntent = new Intent("android.intent.action.BALIKESIRMENU");
                startActivity(balikesirIntent);

                break;
            case R.id.ibBaskan :

                Intent baskan = new Intent("android.intent.action.DENEME");
                startActivity(baskan);

                break;
            case R.id.ibDuyurular :

                break;
            case R.id.ibBelediye:

                Intent eBelediyeIntent = new Intent("android.intent.action.EBELEDIYE");
                startActivity(eBelediyeIntent);

                break;
            case R.id.ibRehber :

                Intent eRehber = new Intent("android.intent.action.EREHBER");
                startActivity(eRehber);

                break;
            case R.id.ibEtkinlikler:

                break;
            case R.id.ibHaberler :

                Intent haberler = new Intent("android.intent.action.DYNAMIC");
                startActivity(haberler);

                break;
            case R.id.ibHizmetler:

                Intent proje = new Intent("android.intent.action.HIZMETLER");
                startActivity(proje);

                break;
            case R.id.ibFotograflar:

                break;
        }
    }
}
