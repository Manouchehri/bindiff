package y.f.d;

import y.f.d.a;

class w {
   static double[] a(y.d.v var0, y.d.t var1) {
      int var32 = a.f;
      double[] var2 = new double[6];
      double var3 = 0.0D;
      y.d.s var5 = var0.j();
      if(!var5.f()) {
         return null;
      } else {
         y.d.t var6 = var5.a().c();
         double var7 = y.d.t.a(var1.a(), var1.b(), var6.a(), var6.b());
         var2[0] = var6.a();
         var2[1] = var6.b();
         var2[2] = var7;
         var2[3] = 0.0D;
         var2[4] = 0.0D;
         var2[5] = 0.0D;
         int var9 = 0;
         double var10 = 0.0D;

         int var10000;
         while(true) {
            if(var5.f()) {
               y.d.m var12 = var5.a();
               y.d.t var13 = var12.c();
               y.d.t var14 = var12.d();
               y.d.z var15 = new y.d.z(var14, var13);
               double var16 = var15.d();
               var3 += var16;
               var15.c();
               y.d.a var18 = new y.d.a(var13, var15);
               y.d.a var19 = new y.d.a(var1, y.d.z.c(var15));
               y.d.t var20 = y.d.a.a(var18, var19);
               y.d.z var21 = new y.d.z(var20, var13);
               y.d.z var22 = new y.d.z(var14, var13);
               double var23 = y.d.z.c(var22, var15);
               double var25 = y.d.z.c(var21, var15);
               double var33;
               var10000 = (var33 = var25 - 0.0D) == 0.0D?0:(var33 < 0.0D?-1:1);
               if(var32 != 0) {
                  break;
               }

               double var27;
               double var29;
               y.d.t var31;
               label50: {
                  if(var10000 <= 0) {
                     var27 = y.d.t.a(var1, var13);
                     var31 = var13;
                     var29 = 0.0D;
                     if(var32 == 0) {
                        break label50;
                     }
                  }

                  if(var25 >= var23) {
                     var27 = y.d.t.a(var1, var14);
                     var31 = var14;
                     var29 = 1.0D;
                     if(var32 == 0) {
                        break label50;
                     }
                  }

                  var27 = y.d.t.a(var1, var20);
                  var31 = var20;
                  var29 = var25 / var23;
               }

               if(var27 < var7) {
                  var7 = var27;
                  var2[0] = var31.a();
                  var2[1] = var31.b();
                  var2[2] = var27;
                  var2[3] = (double)var9;
                  var2[4] = var29;
                  var2[5] = var16 * var29 + var10;
               }

               ++var9;
               var10 = var3;
               var5.g();
               if(var32 == 0) {
                  continue;
               }
            }

            double var34;
            var10000 = (var34 = var3 - 0.0D) == 0.0D?0:(var34 < 0.0D?-1:1);
            break;
         }

         if(var10000 > 0) {
            var2[5] /= var3;
            if(var32 == 0) {
               return var2;
            }
         }

         var2[5] = 0.0D;
         return var2;
      }
   }
}
