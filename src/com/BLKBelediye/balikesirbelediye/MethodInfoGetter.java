package com.BLKBelediye.balikesirbelediye;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.xmlpull.v1.XmlPullParserException;

import android.os.AsyncTask;
import android.util.Log;

public class MethodInfoGetter {

	
	private static ArrayList<ArrayList> retValue = new ArrayList<ArrayList>();
	private static ArrayList<String> tags = new ArrayList<String>();;
	private static String method,name,value;
	
	public static ArrayList<ArrayList> methodRequest(String METHOD_NAME ,String PARAM_NAME ,String PARAM_VALUE) throws IOException, XmlPullParserException
	{
		method = METHOD_NAME;
		name = PARAM_NAME;
		value = PARAM_VALUE;
		AsyncCallWS task = new AsyncCallWS();
        retValue.clear();
		
		if(METHOD_NAME.equals("BalikesirTarihiGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Icerik");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(METHOD_NAME.equals("BalikesirUniversitesiGetir"))
		{
			tags.clear();
			tags.add("Adi");
			tags.add("Tel");
			tags.add("Fax");
			tags.add("Adres");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("BankalarGetir"))
		{
			tags.clear();
			tags.add("Adi");
			tags.add("Tel");
			tags.add("Fax");
			tags.add("Adres");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else if(METHOD_NAME.equals("BasinBulteniGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Aciklama");
			tags.add("Icerik");
			tags.add("Resim_b"); tags.add("Resim1_b");tags.add("Resim2_b");tags.add("Resim3_b");tags.add("Resim4_b");tags.add("Resim5_b");tags.add("Resim6_b");tags.add("Resim7_b");
			tags.add("Resim_k"); tags.add("Resim1_k");tags.add("Resim2_k");tags.add("Resim3_k");tags.add("Resim4_k");tags.add("Resim5_k");tags.add("Resim6_k");tags.add("Resim7_k");
			tags.add("HaberTarihi");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("BaskanOzgecmisGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Icerik");
			tags.add("Resim_b"); tags.add("Resim1_b");tags.add("Resim2_b");tags.add("Resim3_b");
			tags.add("Resim_k"); tags.add("Resim1_k");tags.add("Resim2_k");tags.add("Resim3_k");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("BaskanYardimcilariGetir"))
		{
			tags.clear();
			tags.add("Resim");
			tags.add("Adi");
			tags.add("Unvan");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("BaskanlarimizGetir"))
		{
			tags.clear();
			tags.add("Resim");
			tags.add("Adi");
			tags.add("GorevTarihi");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("BelediyeEncumeniGetir"))
		{
			tags.clear();
			tags.add("Resim");
			tags.add("Adi");
			tags.add("Unvan");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("BelediyeMeclisiGetir"))
		{
			tags.clear();
			tags.add("Resim");
			tags.add("Adi");
			tags.add("Parti");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("BelediyeMudurleriGetir"))
		{
			tags.clear();
			tags.add("Resim");
			tags.add("Adi");
			tags.add("MudurlukAdi");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("BelediyeTarihiGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Icerik");	
			tags.add("Resim_b"); tags.add("Resim1_b");tags.add("Resim2_b");tags.add("Resim3_b");
			tags.add("Resim_k"); tags.add("Resim1_k");tags.add("Resim2_k");tags.add("Resim3_k");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("CTVIslemleriGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Icerik");	
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("DigerProjelerGetir"))
		{
			//Bos Zamanla doldurulur
		}
		else if(METHOD_NAME.equals("DuyuruGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Aciklama");
			tags.add("Icerik");	
			tags.add("Resim_b"); tags.add("Resim1_b");tags.add("Resim2_b");tags.add("Resim3_b");
			tags.add("Resim_k"); tags.add("Resim1_k");tags.add("Resim2_k");tags.add("Resim3_k");
			tags.add("DuyuruTarihi");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("EczanelerGetir"))
		{
			tags.clear();
			tags.add("Adi");
			tags.add("Tel");
			tags.add("Adres");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("EgitimTeknolojiProjeleriGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Icerik");
			tags.add("Resim_b"); tags.add("Resim1_b");tags.add("Resim2_b");tags.add("Resim3_b");tags.add("Resim4_b");tags.add("Resim5_b");tags.add("Resim6_b");tags.add("Resim7_b");
			tags.add("Resim_k"); tags.add("Resim1_k");tags.add("Resim2_k");tags.add("Resim3_k");tags.add("Resim4_k");tags.add("Resim5_k");tags.add("Resim6_k");tags.add("Resim7_k");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("EmlakVergiIslemleriGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Icerik");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("EtkinlikTarihiGetir"))
		{
			tags.clear();
			tags.add("notedate");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("EtkinlikTarihiSecGetir"))
		{
			tags.clear();
			tags.add("etkinlik");
			tags.add("notedate");
			tags.add("yer");
			tags.add("duzenleyen");
			tags.add("aciklama");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("EvlendirmeIslemleriGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Icerik");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("HaberGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Aciklama");
			tags.add("Icerik");
			tags.add("Resim_b"); tags.add("Resim1_b");tags.add("Resim2_b");tags.add("Resim3_b");tags.add("Resim4_b");tags.add("Resim5_b");tags.add("Resim6_b");tags.add("Resim7_b");
			tags.add("Resim_k"); tags.add("Resim1_k");tags.add("Resim2_k");tags.add("Resim3_k");tags.add("Resim4_k");tags.add("Resim5_k");tags.add("Resim6_k");tags.add("Resim7_k");
			tags.add("HaberTarihi");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("HalklaIliskilerProjeleriGetir"))
		{
			//Bos zamanla doldurulacak
		}
		else if(METHOD_NAME.equals("InsaatRuhsatiIslemleriGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Icerik");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("IskanRaporuIslemleriGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Icerik");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("IsyeriAcmaIslemleriGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Icerik");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("KulturSanatProjeleriGetir"))
		{
			//Bos zamanla doldurulacak
		}
		else if(METHOD_NAME.equals("KutuphanelerGetir"))
		{
			tags.clear();
			tags.add("Adi");
			tags.add("Tel");
			tags.add("Fax");
			tags.add("Adres");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("MeclisKararOzetleriDetayGetir"))
		{
			tags.clear();
			tags.add("ID");
			tags.add("Icerik");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("MeclisKararOzetleriGetir"))
		{
			tags.clear();
			tags.add("ID");
			tags.add("Baslik");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("MuhtarliklarGetir"))
		{
			tags.clear();
			tags.add("Muhtarlik");
			tags.add("Adi");
			tags.add("Tel_Fax");
			tags.add("Adres");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("NobetciEczaneTarihiGetir"))
		{
			tags.clear();
			tags.add("notedate");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		/*
		else if(METHOD_NAME.equals("NobetciEczaneTarihiSecGetir"))
		{
			//sec getir parametre gir
			
		}*/
		else if(METHOD_NAME.equals("OnemliTelefonlarGetir"))
		{
			tags.clear();
			tags.add("Adi");
			tags.add("Tel");
			tags.add("Fax");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("ParkCevreProjeleriGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Icerik");	
			tags.add("Resim_b"); tags.add("Resim1_b");tags.add("Resim2_b");tags.add("Resim3_b");tags.add("Resim4_b");tags.add("Resim5_b");tags.add("Resim6_b");tags.add("Resim7_b");
			tags.add("Resim_k"); tags.add("Resim1_k");tags.add("Resim2_k");tags.add("Resim3_k");tags.add("Resim4_k");tags.add("Resim5_k");tags.add("Resim6_k");tags.add("Resim7_k");
			tags.add("HaberTarihi");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("SaglikKuruluslariGetir"))
		{
			tags.clear();
			tags.add("Adi");
			tags.add("Tel");
			tags.add("Fax");
			tags.add("Adres");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("SaglikProjeleriGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Icerik");	
			tags.add("Resim_b"); tags.add("Resim1_b");tags.add("Resim2_b");tags.add("Resim3_b");tags.add("Resim4_b");tags.add("Resim5_b");tags.add("Resim6_b");tags.add("Resim7_b");
			tags.add("Resim_k"); tags.add("Resim1_k");tags.add("Resim2_k");tags.add("Resim3_k");tags.add("Resim4_k");tags.add("Resim5_k");tags.add("Resim6_k");tags.add("Resim7_k");
			tags.add("HaberTarihi");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("SosyalYardimProjeleriGetir"))
		{
			//Bos sonra doldur
		}
		else if(METHOD_NAME.equals("SporProjeleriGetir"))
		{
			//Bos sonra doldur
		}
		else if(METHOD_NAME.equals("SuKanalIslemleriGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Icerik");	
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(METHOD_NAME.equals("UlasimProjeleriGetir"))
		{
			//bos sonra doldur
		}
		else if(METHOD_NAME.equals("YolCaddeProjeleriGetir"))
		{
			tags.clear();
			tags.add("Baslik");
			tags.add("Icerik");	
			tags.add("Resim_b"); tags.add("Resim1_b");tags.add("Resim2_b");tags.add("Resim3_b");tags.add("Resim4_b");tags.add("Resim5_b");tags.add("Resim6_b");tags.add("Resim7_b");
			tags.add("Resim_k"); tags.add("Resim1_k");tags.add("Resim2_k");tags.add("Resim3_k");tags.add("Resim4_k");tags.add("Resim5_k");tags.add("Resim6_k");tags.add("Resim7_k");
			tags.add("HaberTarihi");
			try {
				task.execute().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
        method="";
		return retValue;
	}
	
	
	
public static class AsyncCallWS extends AsyncTask<String, Void, Void> {
        
        private static final String TAG = "Esat";


		protected Void doInBackground(String... params) {
				
			if(!(name.equals("") && value.equals("")))
			{
				try {
					retValue = 	RequestSoap.soap(method, name ,value ,tags);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			else
			{
        	try{
        		retValue =	RequestSoap.soap(method, "" ,"" ,tags);
        	}
        	catch(IOException e)
        	{e.printStackTrace();}
        	catch(XmlPullParserException e)
        	{e.printStackTrace();}
			}
          return null;
        }
        protected void onPostExecute(Void result) {

        }    
        protected void onPreExecute() {

        }
        protected void onProgressUpdate(Void... values) {
           
        }
    }
	
	
}