package y.g;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import y.g.X;
import y.g.a;

final class af extends a {
   af() {
      super(X.m == null?(X.m = X.a("java.net.URL")):X.m);
   }

   protected Object a(String var1) {
      try {
         if(var1.indexOf(":/") < 0) {
            return (new File(var1)).toURL();
         } else {
            if(var1.startsWith("resource://")) {
               String var2 = var1.substring("resource://".length());
               String var3 = null;
               String var4 = null;
               int var5 = var2.indexOf(35);
               if(var5 > 0) {
                  var4 = var2.substring(var5);
                  var2 = var2.substring(0, var5);
               }

               int var6 = var2.indexOf(63);
               if(var6 > 0) {
                  var3 = var2.substring(var6);
                  var2 = var2.substring(0, var6);
               }

               URL var7 = this.getClass().getClassLoader().getResource(var2);
               if(var7 == null || var4 == null && var3 == null) {
                  return var7;
               }

               var1 = var7.toString();
               if(var3 != null) {
                  var1 = var1 + var3;
               }

               if(var4 != null) {
                  var1 = var1 + var4;
               }
            }

            return new URL(var1);
         }
      } catch (MalformedURLException var8) {
         throw new IllegalArgumentException("Could not convert URL from " + var1);
      }
   }

   protected String a(Object var1) {
      return ((URL)var1).toString();
   }
}
