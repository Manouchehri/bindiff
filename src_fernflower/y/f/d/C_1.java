package y.f.d;

import java.util.Arrays;
import y.f.d.D;
import y.f.d.E;
import y.f.d.a;
import y.f.d.m;

class C {
   private static y.d.y a(y.d.n var0) {
      int var9 = a.f;
      double var1;
      double var3;
      double var5;
      double var7;
      if(var0.g() == 0.0D && var0.i() == -1.0D) {
         var1 = var0.b();
         var3 = var0.c() - var0.f();
         var5 = var0.f();
         var7 = var0.e();
         if(var9 == 0) {
            return new y.d.y(var1, var3, var7, var5);
         }
      }

      if(var0.g() == 0.0D && var0.i() == 1.0D) {
         var1 = var0.b() - var0.e();
         var3 = var0.c();
         var5 = var0.f();
         var7 = var0.e();
         if(var9 == 0) {
            return new y.d.y(var1, var3, var7, var5);
         }
      }

      if(var0.g() == 1.0D && var0.i() == 0.0D) {
         var1 = var0.b();
         var3 = var0.c();
         var5 = var0.e();
         var7 = var0.f();
         if(var9 == 0) {
            return new y.d.y(var1, var3, var7, var5);
         }
      }

      if(var0.g() != -1.0D || var0.i() != 0.0D) {
         return null;
      } else {
         var1 = var0.b() - var0.e();
         var3 = var0.c() - var0.f();
         var5 = var0.e();
         var7 = var0.f();
         if(var9 != 0) {
            return null;
         } else {
            return new y.d.y(var1, var3, var7, var5);
         }
      }
   }

   private static boolean b(y.d.n var0) {
      return var0.g() == 0.0D && var0.i() == -1.0D || var0.g() == 0.0D && var0.i() == 1.0D || var0.g() == -1.0D && var0.i() == 0.0D || var0.g() == 1.0D && var0.i() == 0.0D;
   }

   static double a(y.d.n var0, y.d.n var1) {
      int var9 = a.f;
      if(b(var0) && b(var1)) {
         return a(a(var0), a(var1));
      } else if(!y.d.n.a(var0, var1, 0.001D) && !y.d.n.a(var1, var0, 0.001D) && !var1.equals(var0)) {
         y.d.t[] var2 = b(var0, var1);
         if(var2 == null) {
            return 0.0D;
         } else {
            double var3 = 0.0D;
            int var5 = 0;

            while(true) {
               if(var5 < var2.length) {
                  int var6 = (var5 + 1) % var2.length;
                  var3 += (var2[var5].a + var2[var6].a) * (var2[var6].b - var2[var5].b);
                  ++var5;
                  if(var9 != 0) {
                     break;
                  }

                  if(var9 == 0) {
                     continue;
                  }
               }

               var3 = Math.abs(var3 * 0.5D);
               break;
            }

            double var10 = var3 / (var0.e() * var0.f());
            double var7 = var3 / (var1.e() * var1.f());
            return Math.max(var10, var7);
         }
      } else {
         return 1.0D;
      }
   }

   static double a(y.d.n var0, y.d.y var1) {
      return a(var0, new y.d.n(var1));
   }

   private static double a(y.d.y var0, y.d.y var1) {
      if(!var0.b(var1) && !var1.b(var0) && !var1.equals(var0)) {
         if(y.d.y.a(var0, var1)) {
            y.d.y var2 = b(var0, var1);
            double var3 = var2.a * var2.b;
            double var5 = var3 / (var0.a * var0.b);
            double var7 = var3 / (var1.a * var1.b);
            return Math.max(var5, var7);
         } else {
            return 0.0D;
         }
      } else {
         return 1.0D;
      }
   }

   private static y.d.y b(y.d.y var0, y.d.y var1) {
      double var2 = Math.max(var0.c, var1.c);
      double var4 = Math.max(var0.d, var1.d);
      double var6 = Math.min(var0.c + var0.a, var1.c + var1.a) - var2;
      double var8 = Math.min(var0.d + var0.b, var1.d + var1.b) - var4;
      return new y.d.y(var2, var4, var6, var8);
   }

   private static y.d.t[] b(y.d.n var0, y.d.n var1) {
      int var10 = a.f;
      y.d.t[] var2 = y.d.n.a(var0);
      y.d.t[] var3 = y.d.n.a(var1);
      y.c.D var4 = new y.c.D();
      int var5 = 0;

      byte var10000;
      while(true) {
         if(var5 < 4) {
            y.d.m var6 = new y.d.m(var2[var5], var2[(var5 + 1) % 4]);
            var10000 = 0;
            if(var10 != 0) {
               break;
            }

            int var7 = 0;

            label71: {
               while(var7 < 4) {
                  y.d.m var8 = new y.d.m(var3[var7], var3[(var7 + 1) % 4]);
                  y.d.t var9 = y.d.m.a(var6, var8);
                  if(var10 != 0) {
                     break label71;
                  }

                  if(var9 != null) {
                     var4.add(var9);
                  }

                  ++var7;
                  if(var10 != 0) {
                     break;
                  }
               }

               ++var5;
            }

            if(var10 == 0) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      var5 = var10000;

      boolean var14;
      while(true) {
         if(var5 < 4) {
            var14 = y.d.n.a(var0, var3[var5], 0.001D);
            if(var10 != 0) {
               break;
            }

            if(var14) {
               var4.add(var3[var5]);
            }

            if(y.d.n.a(var1, var2[var5], 0.001D)) {
               var4.add(var2[var5]);
            }

            ++var5;
            if(var10 == 0) {
               continue;
            }
         }

         var14 = var4.isEmpty();
         break;
      }

      if(var14) {
         return null;
      } else {
         y.d.t[] var11 = new y.d.t[var4.size()];
         int var12 = 0;
         y.c.C var13 = var4.m();

         while(true) {
            if(var13.f()) {
               var11[var12++] = (y.d.t)var13.d();
               var13.g();
               if(var10 != 0) {
                  break;
               }

               if(var10 == 0) {
                  continue;
               }
            }

            Arrays.sort(var11, new E(var11, (D)null));
            break;
         }

         return var11;
      }
   }

   static double a(y.d.n var0, y.d.m var1) {
      int var13 = a.f;
      if(b(var0)) {
         return a(a(var0), var1);
      } else if(!y.d.n.a(var0, var1, 0.001D)) {
         return 0.0D;
      } else {
         y.d.t var2;
         double var3;
         double var5;
         y.d.m var7;
         label33: {
            var2 = var0.k();
            var3 = (new y.d.m(var2, var0.a())).g();
            var5 = Math.sqrt(var0.e() * var0.e() + var0.f() * var0.f());
            y.d.t[] var8 = b(var0, var1);
            if(var8 == null) {
               var7 = var1;
               if(var13 == 0) {
                  break label33;
               }
            }

            if(var8.length == 1) {
               y.d.t var9 = y.d.n.a(var0, var1.c(), 0.001D)?var1.c():var1.d();
               var7 = new y.d.m(var9, var8[0]);
               if(var13 == 0) {
                  break label33;
               }
            }

            var7 = new y.d.m(var8[0], var8[1]);
         }

         double var14 = var7.g() / var5;
         double var11 = 1.0D - m.a(var7, var2) / var3;
         return (3.0D * var11 + 1.0D * var14) / 4.0D;
      }
   }

   private static y.d.t[] b(y.d.n var0, y.d.m var1) {
      int var7 = a.f;
      y.d.t[] var2 = y.d.n.a(var0);
      y.c.D var3 = new y.c.D();
      int var4 = 0;

      while(true) {
         if(var4 < var2.length) {
            y.d.m var5 = new y.d.m(var2[var4], var2[(var4 + 1) % var2.length]);
            y.d.t var6 = y.d.m.a(var5, var1);
            if(var7 != 0) {
               break;
            }

            label37: {
               if(var6 != null) {
                  var3.add(var6);
                  if(var7 == 0) {
                     break label37;
                  }
               }

               if(var1.b(var2[var4])) {
                  var3.add(var2[var4]);
               }
            }

            ++var4;
            if(var7 == 0) {
               continue;
            }
         }

         if(var3.isEmpty()) {
            return null;
         }
         break;
      }

      y.d.t[] var8 = new y.d.t[var3.size()];
      int var9 = 0;
      y.c.C var10 = var3.m();

      y.d.t[] var10000;
      while(true) {
         if(var10.f()) {
            var10000 = var8;
            if(var7 != 0) {
               break;
            }

            var8[var9++] = (y.d.t)var10.d();
            var10.g();
            if(var7 == 0) {
               continue;
            }
         }

         var10000 = var8;
         break;
      }

      return var10000;
   }

   private static double a(y.d.y var0, y.d.m var1) {
      int var13 = a.f;
      if(!var1.a(var0)) {
         return 0.0D;
      } else {
         y.d.t var2;
         double var3;
         double var5;
         y.d.m var7;
         label29: {
            var2 = new y.d.t(var0.c + var0.a * 0.5D, var0.d + var0.b * 0.5D);
            var3 = (new y.d.m(var2, var0.e())).g();
            var5 = Math.sqrt(var0.a * var0.a + var0.b * var0.b);
            y.d.t[] var8 = b(var0, var1);
            if(var8 == null) {
               var7 = var1;
               if(var13 == 0) {
                  break label29;
               }
            }

            if(var8.length == 1) {
               y.d.t var9 = var0.a(var1.c())?var1.c():var1.d();
               var7 = new y.d.m(var9, var8[0]);
               if(var13 == 0) {
                  break label29;
               }
            }

            var7 = new y.d.m(var8[0], var8[1]);
         }

         double var14 = var7.g() / var5;
         double var11 = 1.0D - m.a(var7, var2) / var3;
         return (3.0D * var11 + 1.0D * var14) / 4.0D;
      }
   }

   private static y.d.t[] b(y.d.y var0, y.d.m var1) {
      int var15 = a.f;
      y.d.t var2 = var0.e();
      y.d.t var3 = new y.d.t(var2.a, var2.b + var0.b());
      y.d.t var4 = new y.d.t(var3.a + var0.a(), var3.b);
      y.d.t var5 = new y.d.t(var4.a, var2.b);
      y.c.D var6 = new y.c.D();
      y.d.m var7 = new y.d.m(var2, var3);
      y.d.t var8 = y.d.m.a(var7, var1);
      if(var8 != null) {
         var6.add(var8);
      }

      y.d.m var9 = new y.d.m(var5, var4);
      var8 = y.d.m.a(var9, var1);
      if(var8 != null) {
         var6.add(var8);
      }

      y.d.m var10 = new y.d.m(var2, var5);
      var8 = y.d.m.a(var10, var1);
      if(var8 != null) {
         var6.add(var8);
      }

      y.d.m var11 = new y.d.m(var3, var4);
      var8 = y.d.m.a(var11, var1);
      if(var8 != null) {
         var6.add(var8);
      }

      if(var1.b(var2)) {
         var6.add(var2);
      }

      if(var1.b(var5)) {
         var6.add(var5);
      }

      if(var1.b(var3)) {
         var6.add(var3);
      }

      if(var1.b(var4)) {
         var6.add(var4);
      }

      if(var6.isEmpty()) {
         return null;
      } else {
         y.d.t[] var12 = new y.d.t[var6.size()];
         int var13 = 0;
         y.c.C var14 = var6.m();

         y.d.t[] var10000;
         while(true) {
            if(var14.f()) {
               var10000 = var12;
               if(var15 != 0) {
                  break;
               }

               var12[var13++] = (y.d.t)var14.d();
               var14.g();
               if(var15 == 0) {
                  continue;
               }
            }

            var10000 = var12;
            break;
         }

         return var10000;
      }
   }
}
