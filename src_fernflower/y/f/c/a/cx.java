package y.f.c.a;

import java.util.ArrayList;
import java.util.Iterator;
import y.f.c.a.N;
import y.f.c.a.cw;

class cx {
   private ArrayList a = new ArrayList();

   void a(cw var1) {
      this.a.add(var1);
   }

   void b(cw var1) {
      this.a.remove(var1);
   }

   cw a(double var1) {
      boolean var12 = N.x;
      double var3 = -1.7976931348623157E308D;
      cw var5 = null;
      double var6 = -1.7976931348623157E308D;
      Iterator var8 = this.a.iterator();

      cw var10000;
      while(true) {
         if(var8.hasNext()) {
            cw var9 = (cw)var8.next();
            double var10 = var9.c + var9.d;
            var10000 = var5;
            if(var12) {
               break;
            }

            if(var5 == null || var10 > var6) {
               var5 = var9;
               var6 = var10;
            }

            var3 = Math.max(var3, var10 + var9.e);
            if(!var12) {
               continue;
            }
         }

         var10000 = var5;
         break;
      }

      if(var10000 == null) {
         return null;
      } else {
         double var13 = var3 - var6;
         return new cw(var1, var5.c, var5.d, var13, var5.a);
      }
   }
}
