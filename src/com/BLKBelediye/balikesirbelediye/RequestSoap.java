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
	
    private static final String USERNAME = "bldwebserviskullanici";
	private static final String PASSWORD = "dsadsadd_hmddsadsa6dUdsadsas_d";
	private static final String TAG = "PropertyCountTag";
	private static String METHOD_NAME ;
    private static String SOAP_ACTION ;
    private static String NAMESPACE ;
    private static String URL ;
    private static String PARAM_NAME ;
    private static String PARAM_VALUE ;
    private static String retValue;
    private static  int count;
    private static String tempResim;
    private static String temp;
    public static ArrayList<ArrayList> contents = new ArrayList<ArrayList>();
    public static ArrayList<String> tempContents = new ArrayList<String>();
   //you can get these values from the wsdl file^
    
    public static ArrayList<ArrayList> soap(String _METHOD_NAME ,
    		String _PARAM_NAME , String _PARAM_VALUE , ArrayList<String> tags ) 
    		throws IOException, XmlPullParserException 
    {
    	METHOD_NAME = _METHOD_NAME ;
    	SOAP_ACTION = "http://tempuri.org/" + METHOD_NAME;
    	NAMESPACE = "http://tempuri.org/";
    	URL = "http://servis.balikesir.bel.tr/MobilService.asmx";;
    	PARAM_NAME = _PARAM_NAME ;
    	PARAM_VALUE = _PARAM_VALUE ;
    	
    	
       SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME); //set up request

       if(!TextUtils.isEmpty(PARAM_NAME) && !TextUtils.isEmpty(PARAM_VALUE))
       {
    	   request.addProperty(PARAM_NAME,PARAM_VALUE); //variable name, value. I got the variable name, from the wsdl file!
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
     
       count = response2.getPropertyCount() ;
       
       retValue = "";
       for (int i = 0; i < count; i++) 
       {

    	   Log.i(TAG , String.valueOf(count));
    	   
           Object property = response2.getProperty(i); 
           if (property instanceof SoapObject)
           {
               SoapObject category_list = (SoapObject) property;
               
               for(int j = 0 ; j<tags.size() ; j++)
               {
            	   if(category_list.getProperty(tags.get(j)).toString().contains("Resim"))
            	   {
            		   tempResim ="htttp://www.balikesir.bel.tr/";
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
               tempContents.add("\n \n");
              
           }
         //  contents.add(tempContents);
           
       	}    
       	contents.add(tempContents);
       /*
       temp = "";
       for(int i = 0 ; i < tempContents.size() ; i++)
       {
    	   temp += tempContents.get(i) + "\n";
       }
       */
       
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
