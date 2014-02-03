package com.BLKBelediye.balikesirbelediye;

import java.io.IOException;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;
import java.io.InputStream;
import java.util.ArrayList;
import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;

public  class RequestSoap {
	
    private static final String USERNAME = "tryout";
	private static final String PASSWORD = "tryout";
	private static final String TAG = "PropertyCountTag";
    private static String NAMESPACE ;
    private static String temp;
    public static ArrayList<ArrayList> contents = new ArrayList<ArrayList>();
    public static ArrayList<String> tempContents = new ArrayList<String>();
   //you can get these values from the wsdl file^
    
    public static ArrayList<ArrayList> soap(String _METHOD_NAME ,
    		String _PARAM_NAME , String _PARAM_VALUE , ArrayList<String> tags ) 
    		throws IOException, XmlPullParserException 
    {
        String SOAP_ACTION = "http://tempuri.org/" + _METHOD_NAME;
    	NAMESPACE = "http://tempuri.org/";
        String URL = "http://servis.balikesir.bel.tr/MobilService.asmx";


        SoapObject request = new SoapObject(NAMESPACE, _METHOD_NAME); //set up request

       if(!TextUtils.isEmpty(_PARAM_NAME) && !TextUtils.isEmpty(_PARAM_VALUE))
       {
    	   request.addProperty(_PARAM_NAME, _PARAM_VALUE); //variable name, value. I got the variable name, from the wsdl file!
       }
       
       SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11); //put all required data into a soap envelope
       
       envelope.dotNet = true;
       
       envelope.setOutputSoapObject(request);  //prepare request
       
       envelope.headerOut = new Element[1];
       
       envelope.headerOut[0] = buildAuthHeader();
       
       HttpTransportSE httpTransport = new HttpTransportSE(URL);  
       
       httpTransport.debug = true;  //this is optional, use it if you don't want to use a packet sniffer to check what the sent message was (httpTransport.requestDump)
       
       
       httpTransport.call(SOAP_ACTION, envelope); //send request
       
       SoapObject result=(SoapObject)envelope.getResponse(); //get response
       
       SoapObject response=(SoapObject)envelope.bodyIn;
       
       
       response = (SoapObject) response.getProperty(0);
       
       SoapObject response1 =(SoapObject) response.getProperty("diffgram");
  
       
       SoapObject response2 = (SoapObject) response1.getProperty("DocumentElement");

        int count = response2.getPropertyCount();

        String retValue = "";
       for (int i = 0; i < count; i++) 
       {
           tempContents.clear();

    	   Log.i(TAG , String.valueOf(count));
    	   
           Object property = response2.getProperty(i);


           if (property instanceof SoapObject)
           {
               SoapObject category_list = (SoapObject) property;



               for(int j = 0 ; j<tags.size() ; j++)
               {
            	   if(category_list.getProperty(tags.get(j)).toString().contains("Resim"))
            	   {
                       String tempResim = "htttp://www.balikesir.bel.tr/";
            		   tempResim += category_list.getProperty(tags.get(j)).toString();
            		   tempContents.add(tempResim);  
            	   }
            	   else
            	   {
            		   if(category_list.getProperty(tags.get(j)).toString().equals("anyType{}"))
            		   {continue;}
            		   tempContents.add(category_list.getProperty(tags.get(j)).toString());

            	   }
               }
               for(int k = 0 ;k < tempContents.size() ; k++ )
                   Log.i("For ici 5 minare",tempContents.get(k));
               Log.i("For disi 4 minare","Asdas asdas");
               contents.add(new ArrayList(tempContents));
           }

       	}


    //   temp = response1.toString();
       Log.i(TAG , "Return edildi");  
       return contents;
       
}//soap fonksiyonu bitis noktasi

   //usage:
   //SoapObject result=soap(METHOD_NAME, SOAP_ACTION, NAMESPACE, URL);
   //don't forget to catch the exceptions!!
    
    private static Element buildAuthHeader() {
        Element h = new Element().createElement(NAMESPACE, "soapGuvenlik");
        Element username = new Element().createElement(NAMESPACE, "KullaniciAdi");
        username.addChild(Node.TEXT, USERNAME);
        h.addChild(Node.ELEMENT, username);
        Element pass = new Element().createElement(NAMESPACE, "Sifre");
        pass.addChild(Node.TEXT, PASSWORD);
        h.addChild(Node.ELEMENT, pass);

        return h;
    }
}
