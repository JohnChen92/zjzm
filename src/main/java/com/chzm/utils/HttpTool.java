package com.chzm.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;


public class HttpTool {

   public static String sendPost(String url, String param) {
       OutputStreamWriter out = null;
       BufferedReader in = null;
       String result = "";
       try {
           URL realUrl = new URL(url);
           HttpURLConnection conn = null;
//           if(isproxy){
//               @SuppressWarnings("static-access")
//               Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(url, prot));
//               conn = (HttpURLConnection) realUrl.openConnection(proxy);
//           }else{
               conn = (HttpURLConnection) realUrl.openConnection();
//           }

           conn.setDoOutput(true);
           conn.setDoInput(true);
           conn.setRequestMethod("POST");



           conn.setRequestProperty("accept", "*/*");
           conn.setRequestProperty("connection", "Keep-Alive");
           conn.setRequestProperty("user-agent",
                   "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
           conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");  

           conn.connect();

           out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
           out.write(param);
           out.flush();
           in = new BufferedReader(
                   new InputStreamReader(conn.getInputStream()));
           String line;
           while ((line = in.readLine()) != null) {
               result += line;
           }
       } catch (Exception e) {
           System.out.println(""+e);
           e.printStackTrace();
       }
       finally{
           try{
               if(out!=null){
                   out.close();
               }
               if(in!=null){
                   in.close();
               }
           }
           catch(IOException ex){
               ex.printStackTrace();
           }
       }
       return result;
   }    

}
