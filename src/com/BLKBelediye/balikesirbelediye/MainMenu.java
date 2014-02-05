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

import infoDisplay.HaberlerDynamic;

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
		setContentView(R.layout.main_menu_tablet);

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
        */
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
        baskan = (ImageButton) findViewById(R.id.ibBaskanTablet);
        kurumsal =(ImageButton) findViewById(R.id.ibKurumsalTablet);
        haberler = (ImageButton) findViewById(R.id.ibHTablet);
        duyurular = (ImageButton) findViewById(R.id.ibDuyurularTablet);
        balikesir = (ImageButton) findViewById(R.id.ibBalikesirTablet);
        e_belediye = (ImageButton) findViewById(R.id.ibBelediyeTablet);
        etkinlikler = (ImageButton) findViewById(R.id.ibEtkinliklerTablet);
        e_rehber = (ImageButton) findViewById(R.id.ibRehberTablet);
        hizmetler = (ImageButton) findViewById(R.id.ibHizmetlerTablet);
        fotograflar = (ImageButton) findViewById(R.id.ibFotograflarTablet);
    }

/*
* Bu kısım buttonların onClick methodlarını tanımlamak için kullanıldı
* */
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ibKurumsalTablet:

                Intent kurumIntent = new Intent("android.intent.action.KURUMSAL");
                startActivity(kurumIntent);
                break;
            case R.id.ibBalikesirTablet :

                Intent balikesirIntent = new Intent("android.intent.action.BALIKESIRMENU");
                startActivity(balikesirIntent);

                break;
            case R.id.ibBaskanTablet :

                Intent baskan = new Intent("android.intent.action.BASKAN");

                startActivity(baskan);

                break;
            case R.id.ibDuyurularTablet :

                break;
            case R.id.ibBelediyeTablet :

                Intent eBelediyeIntent = new Intent("android.intent.action.EBELEDIYE");
                startActivity(eBelediyeIntent);

                break;
            case R.id.ibRehberTablet :

                Intent eRehber = new Intent("android.intent.action.EREHBER");
                startActivity(eRehber);

                break;
            case R.id.ibEtkinliklerTablet :

                break;
            case R.id.ibHTablet :

                HaberlerDynamic a = new HaberlerDynamic();

                break;
            case R.id.ibHizmetlerTablet :

                Intent proje = new Intent("android.intent.action.HIZMETLER");
                startActivity(proje);

                break;
            case R.id.ibFotograflarTablet :

                break;
        }
    }
}
