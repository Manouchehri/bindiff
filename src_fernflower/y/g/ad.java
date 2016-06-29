package y.g;

import java.util.Locale;
import java.util.StringTokenizer;
import y.g.X;
import y.g.a;
import y.g.p;

final class ad extends a {
   ad() {
      super(X.q == null?(X.q = X.a("java.util.Locale")):X.q);
   }

   protected Object a(String var1) {
      boolean var7 = p.c;
      StringTokenizer var3 = new StringTokenizer(var1, "_", false);
      String var4 = var3.nextToken();
      Locale var2;
      if(var3.hasMoreTokens()) {
         String var5 = var3.nextToken();
         if(var3.hasMoreTokens()) {
            String var6 = var3.nextToken();
            var2 = new Locale(var4, var5, var6);
            if(!var7) {
               return var2;
            }
         }

         var2 = new Locale(var4, var5);
         if(!var7) {
            return var2;
         }
      }

      var2 = new Locale(var4, "");
      return var2;
   }

   protected String a(Object var1) {
      Locale var2 = (Locale)var1;
      String var3 = var2.getLanguage();
      if(var2.getCountry().length() > 0) {
         var3 = var3 + "_" + var2.getCountry();
         if(var2.getVariant().length() > 0) {
            var3 = var3 + "_" + var2.getVariant();
         }
      }

      return var3;
   }
}
