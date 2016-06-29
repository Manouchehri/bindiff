package com.google.security.zynamics.zylib.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class WebsiteReader {
   public static String read(String var0) {
      URL var1 = new URL(var0);
      BufferedReader var2 = new BufferedReader(new InputStreamReader(var1.openStream()));
      StringBuilder var3 = new StringBuilder();

      String var4;
      while((var4 = var2.readLine()) != null) {
         var3.append(var4);
      }

      var2.close();
      return var3.toString();
   }

   public static String sendPost(String var0, String var1) {
      URL var2 = new URL(var0);
      URLConnection var3 = var2.openConnection();
      var3.setDoOutput(true);
      OutputStreamWriter var4 = new OutputStreamWriter(var3.getOutputStream());

      try {
         var4.write(var1);
         var4.flush();
      } finally {
         var4.close();
      }

      BufferedReader var5 = new BufferedReader(new InputStreamReader(var3.getInputStream()));
      StringBuilder var6 = new StringBuilder();

      String var7;
      try {
         while((var7 = var5.readLine()) != null) {
            var6.append(var7);
         }
      } finally {
         var5.close();
      }

      return var6.toString();
   }
}
