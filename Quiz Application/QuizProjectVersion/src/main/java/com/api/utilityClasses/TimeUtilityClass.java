package com.api.utilityClasses;

import java.text.ParseException;
public class TimeUtilityClass {
	public static boolean compareTime(String Str,String str2) throws ParseException
	{
		/*Str ->Current time String
		 * str2 ->Expiry time string
		 */
		
		String currentTime = Str;
		String expiryTime =  str2;
		
		String year1 = currentTime.substring(0,4);
		String month1 = currentTime.substring(5,7);
		String date1 = currentTime.substring(8,10);
		String hour1 =currentTime.substring(11,13);
		String minute1 = currentTime.substring(14);
		
		int yr1=Integer.parseInt(year1);
		int mn1=Integer.parseInt(month1);
		int dt1 = Integer.parseInt(date1);
		int hr1 = Integer.parseInt(hour1);
		int min1 = Integer.parseInt(minute1);	
		
		String year2 = expiryTime.substring(0,4);
		String month2 = expiryTime.substring(5,7);
		String date2 = expiryTime.substring(8,10);
		String hour2=expiryTime.substring(11,13);
		String minute2=expiryTime.substring(14);
		
		int yr2=Integer.parseInt(year2);
		int mn2=Integer.parseInt(month2);
		int dt2 = Integer.parseInt(date2);
		int hr2 = Integer.parseInt(hour2);
		int min2 = Integer.parseInt(minute2);	
		
		System.out.println(yr1+" "+yr2);
		System.out.println(mn1+" "+mn2);
		System.out.println(dt1+" "+dt2);
		System.out.println(hr1+" "+hr2);
		System.out.println(min1+" "+min2);
		
		if(yr1 < yr2 )
		{
			return true;
		}
		else if(yr1 == yr2 && mn1 < mn2)
		{
			return true;
		}
		else if(yr1 == yr2 && mn1 == mn2 && dt1 < dt2)
		{
			return true;
		}
		else if(yr1 == yr2 && mn1 == mn2 && dt1 == dt2 && hr1<hr2)
		{
			return true;
		}
		else if(yr1 == yr2 && mn1 == mn2 && dt1 == dt2 && hr1 == hr2 && min1<min2)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}
