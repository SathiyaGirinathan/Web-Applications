package com.api.utilityClasses;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

public class Reading {
	
	public static String readJson(HttpServletRequest request)
	{
		StringBuilder jb = new StringBuilder();
        String line;
        try 
        {
            BufferedReader reader = request.getReader();
            
            while ((line = reader.readLine()) != null) 
            {
                jb.append(line);
            }
     
        } catch (Exception ignored) {

        }
        return jb.toString();
	}
}
