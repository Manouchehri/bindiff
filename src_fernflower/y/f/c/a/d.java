package y.f.c.a;

import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.bx;

public class d implements bx {
   private E a;

   public void a(y.f.X param1, aU param2, aV param3, aP param4) {
      // $FF: Couldn't be decompiled
   }

   private static final double a(y.c.D var0, double var1, double var3, double var5) {
      boolean var12 = N.x;
      if(var0.size() < 3) {
         y.d.t var13 = (y.d.t)var0.f();
         y.d.t var14 = (y.d.t)var0.i();
         return var14.b != var13.b?var13.a + (var14.a - var13.a) * ((var5 - var13.b) / (var14.b - var13.b)):(var13.a + var14.a) * 0.5D;
      } else {
         y.c.p var7 = var0.k().a();

         y.c.p var10000;
         while(true) {
            if(var7.a() != null) {
               var10000 = var7;
               if(var12) {
                  break;
               }

               if(((y.d.t)var7.c()).b < var1) {
                  var7 = var7.a();
                  if(!var12) {
                     continue;
                  }
               }
            }

            var10000 = var0.l().b();
            break;
         }

         y.c.p var8 = var10000;

         double var15;
         while(true) {
            if(var8.b() != null) {
               var15 = ((y.d.t)var8.c()).b;
               if(var12) {
                  break;
               }

               if(var15 > var3) {
                  var8 = var8.b();
                  if(!var12) {
                     continue;
                  }
               }
            }

            if(var8 != var7) {
               y.c.p var9 = var7.b();

               while(true) {
                  if(var9.a() != null) {
                     var15 = ((y.d.t)var9.c()).b;
                     if(var12) {
                        break;
                     }

                     if(var15 < var5) {
                        var9 = var9.a();
                        if(!var12) {
                           continue;
                        }
                     }
                  }

                  if(var9.b() != null) {
                     y.d.t var10 = (y.d.t)var9.b().c();
                     y.d.t var11 = (y.d.t)var9.c();
                     if(var10.b != var11.b) {
                        return var10.a + (var11.a - var10.a) * ((var5 - var10.b) / (var11.b - var10.b));
                     }

                     return (var10.a + var11.a) * 0.5D;
                  }

                  var15 = ((y.d.t)var9.c()).a;
                  break;
               }

               return var15;
            }

            var15 = ((y.d.t)var7.c()).a;
            break;
         }

         return var15;
      }
   }
}
