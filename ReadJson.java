package com.example.json;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 JSONParser parser = new JSONParser();
	      try {
	         Object obj = parser.parse(new FileReader("C://Users/sam/Downloads/addresses.json"));
	         JSONArray jsonArray1=(JSONArray)obj;
	  
	         System.out.println("jsonArray1: ");
	         Iterator iterator = jsonArray1.iterator();
	         
	           while (iterator.hasNext()) {
	        	 
	            //System.out.println(iterator.next());
	            JSONObject jsonObject = (JSONObject)iterator.next();
	            JSONObject jsonObject1 = (JSONObject)jsonObject.get("type");
	            JSONObject jsonAddressLineDetail = (JSONObject)jsonObject.get("addressLineDetail");
	            String cityOrTown = (String)jsonObject.get("cityOrTown");
	            JSONObject provinceOrState = (JSONObject)jsonObject.get("provinceOrState");
	            String postalCode = (String)jsonObject.get("postalCode");
	            JSONObject jsonCountry = (JSONObject)jsonObject.get("country");
	            String lastUpdated=(String)jsonObject.get("lastUpdated");
				/*
				 * System.out.println("json object for type :"+jsonObject);
				 * System.out.println("json object for type1 :"+jsonObject1);
				 * System.out.println("json object for  jsonAddressLineDetail:"
				 * +jsonAddressLineDetail); System.out.println("jsonCityOrTown :"+cityOrTown);
				 * System.out.println("json object for jsonProvinceOrState :"+provinceOrState);
				 * System.out.println("postalCode :"+postalCode);
				 * System.out.println("json object for jsonCountry :"+jsonCountry);
				 */
	            
	            printAddress(jsonAddressLineDetail);
	            validateDateAndTime(lastUpdated);
	         }
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	}

	public static void printAddress(JSONObject addressLineDetail) {
		System.out.println("-------------------------------------------------");
		System.out.println("Address :"+addressLineDetail);
		if(null==addressLineDetail) {
			System.out.println("Address is empty..");
		}else {
			
		System.out.println("value for line2 :"+addressLineDetail.get("line2"));
		System.out.println("value for line1 :"+addressLineDetail.get("line1"));
			
		}
		System.out.println("-------------------------------------------------");
	}
	
	public static void validateDateAndTime(String lastUpdated) {
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		    Date birthDate = null;
			try {
				birthDate = sdf.parse(lastUpdated);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("invalid date");
			}
		    System.out.println("valid date :"+birthDate);
	}
}
