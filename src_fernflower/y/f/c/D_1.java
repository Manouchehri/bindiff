package y.f.c;

import y.f.c.R;
import y.f.c.a;
import y.f.c.w;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.ba;

public class D implements R, aT {
   public static final Object a = "y.layout.hierarchic.GivenLayersLayerer.LAYER_ID_KEY";

   public int a(y.c.i var1, y.c.c var2, y.c.a var3) {
      boolean var10 = a.i;
      if(var1.i()) {
         return 0;
      } else {
         y.c.q[] var4 = var1.m();
         y.g.e.a((Object[])var4, y.g.e.b(var2));
         int var5 = var2.a(var4[0]);
         int var6 = var5;
         int var7 = var5;
         int var8 = 0;

         int var10000;
         byte var10001;
         while(true) {
            if(var8 < var4.length) {
               int var9 = var2.a(var4[var8]);
               var10000 = var9 - var6;
               var10001 = 1;
               if(var10) {
                  break;
               }

               if(var10000 > 1) {
                  var7 += var9 - var6 - 1;
               }

               var3.a(var4[var8], var9 - var7);
               var6 = var9;
               ++var8;
               if(!var10) {
                  continue;
               }
            }

            var10000 = var6 - var7;
            var10001 = 1;
            break;
         }

         return var10000 + var10001;
      }
   }

   public int a(y.f.X var1, y.c.A var2, y.c.f var3) {
      if(var1.i()) {
         return 0;
      } else {
         y.c.c var4 = var1.c(a);
         if(var4 == null) {
            throw new IllegalArgumentException("Given graph does not yield LAYER_ID_KEY DataProvider");
         } else {
            int var5 = this.a((y.c.i)var1, (y.c.c)var4, (y.c.a)var2);
            var3.a(w.a(var1, var2));
            return var5;
         }
      }
   }

   public void a(y.f.X var1, aU var2, aV var3) {
      (new ba(this)).a(var1, var2, var3);
   }
}
