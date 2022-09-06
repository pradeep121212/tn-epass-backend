package com.pradeep.rest.webservices.epasswebservices.otp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SMSService {
//static String userId = "epassmanager";
//static String password = "Sqd9pvpx";
static String userId = "fastsms";
static String password = "nXgUuARjxlowZBG4hCkWQS8qMszHvFp3NbE1PJeLVfKDYi0rT7Vry3cAXPvSnZLkbhdQIHUO9iECJ20W";


//  
//https://www.fast2sms.com/dev/bulk?authorization=nXgUuARjxlowZBG4hCkWQS8qMszHvFp3NbE1PJeLVfKDYi0rT7Vry3cAXPvSnZLkbhdQIHUO9iECJ20W&sender_id=epass&message=Helloworld&language=english&route=p&numbers=9003085016

	public static void sendSMS(String message, String mobileNo) {
			
		  try{
	            String data = "";
	            data += "authorization="+password;
	            data += "&sender_id="+userId;
	            data += "&message="+message;
	            data += "&language=english&route=p&numbers=" + mobileNo;
	     
	            
	            URL url = new URL("https://www.fast2sms.com/dev/bulk?" + data);
	           
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestProperty("cache-control", "no-cache");
	            conn.setRequestMethod("GET");
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            conn.setUseCaches(false); 
	          conn.connect();
	            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String line;
	            StringBuffer buffer = new StringBuffer();
	            while((line = rd.readLine()) != null){
	                buffer.append(line).append("\n");
	            }
	            System.out.println(buffer.toString());
	            rd.close();
	            conn.disconnect();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }



}
}
