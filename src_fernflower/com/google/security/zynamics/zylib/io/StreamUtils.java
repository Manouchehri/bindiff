package com.google.security.zynamics.zylib.io;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class StreamUtils {
   public static List readLinesFromReader(Reader var0) {
      BufferedReader var1 = new BufferedReader(var0);

      try {
         ArrayList var2 = new ArrayList();

         while(true) {
            String var3 = var1.readLine();
            if(var3 == null) {
               ArrayList var4 = var2;
               return var4;
            }

            var2.add(var3);
         }
      } finally {
         var1.close();
      }
   }
}
