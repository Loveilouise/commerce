package com.neuesoft.commerce.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Tools {
	public static String getTime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}
	
	public static String getTrackingno() {  	      

		Random random = new Random();
		String result="";
		for (int i=0;i<12;i++)
		{
			result+=random.nextInt(10);
		}	
	    return result;  
	}  
}
