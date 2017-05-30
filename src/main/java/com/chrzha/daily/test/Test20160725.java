package com.chrzha.daily.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test20160725 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        String body = "";
        try {
            FileInputStream fis = new FileInputStream(new File("D:\\body.txt"));
            body = inputStream2String(fis);
            
            System.out.println(body);
            
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     // 3. remove attributes in p tag, remove <strong> css
        Pattern pattern = Pattern.compile("<p(\\s+[-a-zA-Z]*=\"[^\"]*\")*>");
        Matcher matcher = pattern.matcher(body);
        if(matcher.find()){
            body = matcher.replaceAll("<p>");
        }
        body = body.replaceAll("<strong>", ""); 
        body = body.replaceAll("</strong>", "");
        System.out.println(body);
        pattern = Pattern.compile("<div class=\"(.*?)embed\">(.*?)</div>");
         matcher = pattern.matcher(body);
        if(matcher.find()){
            body = matcher.replaceAll("");
        }
        System.out.println(body);
        
        
    }
    public static String inputStream2String(InputStream is) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null){
          buffer.append(line);
        }
        return buffer.toString();
    }
    public static String unicode2String(String unicode) {
        
        StringBuffer string = new StringBuffer();
     
        String[] hex = unicode.split("\\\\u");
     
        for (int i = 1; i < hex.length; i++) {
     
            int data = Integer.parseInt(hex[i], 16);
     
            string.append((char) data);
        }
     
        return string.toString();
    }
}
