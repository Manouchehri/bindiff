package y.a;

import java.util.Arrays;
import y.a.Q;
import y.a.h;

public class y {
   public static y.c.f a(y.c.i var0, y.c.c var1) {
      return b(var0, var1);
   }

   public static y.c.f b(y.c.i var0, y.c.c var1) {
      boolean var13 = h.a;
      y.c.f var2 = new y.c.f();
      y.g.a.c var3 = new y.g.a.c(var0);
      double[] var4 = new double[var0.e()];
      Arrays.fill(var4, Double.POSITIVE_INFINITY);
      y.c.d[] var5 = new y.c.d[var0.e()];
      y.c.x var6 = var0.o();

      while(true) {
         if(var6.f()) {
            var3.a(var6.e(), Double.POSITIVE_INFINITY);
            var6.g();
            if(var13) {
               return var2;
            }

            if(!var13) {
               continue;
            }
         }

         label59:
         while(true) {
            int var10000 = var3.b();

            label57:
            while(true) {
               y.c.d var8;
               y.c.q var9;
               int var10;
               double var11;
               y.c.q var14;
               label49:
               while(true) {
                  if(var10000 != 0) {
                     return var2;
                  }

                  var14 = var3.a();
                  int var7 = var14.d();
                  if(var4[var7] != Double.POSITIVE_INFINITY) {
                     var2.add(var5[var7]);
                  }

                  var4[var7] = Double.NEGATIVE_INFINITY;
                  var8 = var14.f();

                  while(true) {
                     if(var8 == null) {
                        break label49;
                     }

                     var9 = var8.d();
                     var10 = var9.d();
                     var11 = var1.c(var8);
                     double var15;
                     var10000 = (var15 = var11 - var4[var10]) == 0.0D?0:(var15 < 0.0D?-1:1);
                     if(var13) {
                        break;
                     }

                     if(var10000 < 0) {
                        var3.b(var9, var11);
                        var4[var10] = var11;
                        var5[var10] = var8;
                     }

                     var8 = var8.g();
                     if(var13) {
                        break label49;
                     }
                  }
               }

               var8 = var14.g();

               do {
                  if(var8 == null) {
                     continue label59;
                  }

                  var9 = var8.c();
                  var10 = var9.d();
                  var11 = var1.c(var8);
                  double var16;
                  var10000 = (var16 = var11 - var4[var10]) == 0.0D?0:(var16 < 0.0D?-1:1);
                  if(var13) {
                     continue label57;
                  }

                  if(var10000 < 0) {
                     var3.b(var9, var11);
                     var4[var10] = var11;
                     var5[var10] = var8;
                  }

                  var8 = var8.h();
               } while(!var13);

               return var2;
            }
         }
      }
   }

   public static y.c.f a(y.c.i var0) {
      boolean var7 = h.a;
      y.c.f var1 = new y.c.f();
      Q var2 = new Q(var0);
      y.c.e var3 = var0.p();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         y.c.q var5 = var4.c();
         y.c.q var6 = var4.d();
         if(!var2.b(var5, var6)) {
            var1.add(var4);
            var2.a(var5, var6);
         }

         var3.g();
         if(var7) {
            break;
         }
      }

      return var1;
   }
}
