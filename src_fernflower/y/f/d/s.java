package y.f.d;

import y.f.M;
import y.f.X;
import y.f.ai;
import y.f.aj;
import y.f.ak;
import y.f.al;
import y.f.am;
import y.f.d.a;

class s {
   private static final am a = new y.f.x(0.0D, 0.0D, 30.0D, 30.0D);
   private static final y.d.n[] b = new y.d.n[]{new y.d.n(15.0D, 5.0D, 30.0D, 10.0D, 1.0D, 0.0D), new y.d.n(-15.0D, -15.0D, 100.0D, 30.0D, 0.5D, 0.5D), new y.d.n(50.0D, 90.0D, 40.0D, 15.0D, 0.0D, -1.0D)};

   static y.c.D a(X var0, y.c.q var1, aj var2, al var3, boolean var4) {
      y.c.D var5;
      y.c.D var10000;
      label45: {
         int var15 = a.f;
         var5 = new y.c.D();
         am var6 = var0.a((Object)var1);
         al var7 = var2.a();
         Object var8 = var2.getModelParameter() == null?var7.c():var2.getModelParameter();
         y.d.n var9 = var7 == null?var2.getOrientedBox():var7.a(var2.getOrientedBox().d(), var6, var8);
         if(var4) {
            var5.add(new ai(var9, var8, var2, false));
            if(var15 == 0) {
               break label45;
            }
         }

         if(var3 != null && var3 != var7) {
            Object var10 = var3.a(var9, var6);
            aj var11 = a(var2.getOrientedBox(), var3, var10);
            y.c.D var12 = a(var0, var1, var11, var3);
            y.c.C var13 = var12.m();

            do {
               if(!var13.f()) {
                  break label45;
               }

               ai var14 = (ai)var13.d();
               var10000 = var5;
               if(var15 != 0) {
                  return var10000;
               }

               var5.add(a(var14, var2, var7, var6));
               var13.g();
            } while(var15 == 0);
         }

         var5.addAll(a(var0, var1, var2, var7));
      }

      var10000 = var5;
      return var10000;
   }

   private static y.c.D a(X var0, y.c.q var1, aj var2) {
      return a(var0, var1, var2, 4.0D);
   }

   private static y.c.D a(X var0, y.c.q var1, aj var2, al var3) {
      am var4 = var0.a((Object)var1);
      return var3 != null && !a(var3)?var3.a(var2, var4):a(var0, var1, var2);
   }

   private static y.c.D a(X var0, y.c.q var1, aj var2, double var3) {
      int var34 = a.f;
      y.c.D var5 = new y.c.D();
      y.d.n var6 = var2.getOrientedBox();
      y.d.y var7 = var2.getBox();
      al var8 = var2.a();
      am var9 = var0.a((Object)var1);
      y.d.y var10 = var0.s(var1);
      int var11 = a(var0);
      int var12 = (int)Math.max(3.0D, var10.b / var7.b);
      var12 = Math.min(var12, var11);
      double var13 = (var10.b - var7.b) / (double)(var12 - 1);
      double var15 = var10.c() - var3 - var7.a;
      double var17 = var10.c() + var10.a + var3;
      double var19 = var10.d();
      int var21 = 0;

      while(true) {
         if(var21 < var12) {
            y.d.t var22 = new y.d.t(var15, var19);
            y.d.n var23 = new y.d.n(var6);
            var23.e(var22.a() + var7.a() * 0.5D, var22.b() + var7.b() * 0.5D);
            Object var24 = var8.a(var23, var9);
            ai var25 = new ai(var23, var24, var2, false);
            var5.add(var25);
            y.d.t var26 = new y.d.t(var17, var19);
            y.d.n var27 = new y.d.n(var6);
            var27.e(var26.a() + var7.a() * 0.5D, var26.b() + var7.b() * 0.5D);
            var24 = var8.a(var27, var9);
            var25 = new ai(var27, var24, var2, false);
            var5.add(var25);
            var19 += var13;
            ++var21;
            if(var34 != 0) {
               break;
            }

            if(var34 == 0) {
               continue;
            }
         }

         var12 = (int)Math.max(3.0D, var10.a / var7.a + 2.0D);
         var12 = Math.min(var12, 15);
         var13 = (var10.a + var7.a) / (double)(var12 - 1);
         break;
      }

      double var35 = var10.d() - var3 - var7.b;
      double var36 = var10.d() + var10.b + var3;
      double var37 = var10.c() - var7.a;
      int var38 = 0;

      y.c.D var10000;
      while(true) {
         if(var38 < var12) {
            y.d.t var28 = new y.d.t(var37, var35);
            y.d.n var29 = new y.d.n(var6);
            var29.e(var28.a() + var7.a() * 0.5D, var28.b() + var7.b() * 0.5D);
            Object var30 = var8.a(var29, var9);
            ai var31 = new ai(var29, var30, var2, false);
            var5.add(var31);
            y.d.t var32 = new y.d.t(var37, var36);
            y.d.n var33 = new y.d.n(var6);
            var33.e(var32.a() + var7.a() * 0.5D, var32.b() + var7.b() * 0.5D);
            var30 = var8.a(var33, var9);
            var31 = new ai(var33, var30, var2, false);
            var10000 = var5;
            if(var34 != 0) {
               break;
            }

            var5.add(var31);
            var37 += var13;
            ++var38;
            if(var34 == 0) {
               continue;
            }
         }

         var10000 = var5;
         break;
      }

      return var10000;
   }

   private static ai a(ai var0, aj var1, al var2, am var3) {
      Object var4 = var2.a(var0.d(), var3);
      y.d.n var5 = var2.a(var0.d().d(), var3, var4);
      return new ai(var5, var4, var1, false);
   }

   private static aj a(y.d.n var0, al var1, Object var2) {
      ak var3 = new ak();
      var3.a(var1);
      var3.setModelParameter(var2);
      var3.a(var0);
      return var3;
   }

   private static boolean a(al var0) {
      int var4 = a.f;
      if(var0 instanceof M) {
         return true;
      } else {
         int var1 = 0;

         boolean var10000;
         while(true) {
            if(var1 < b.length) {
               Object var2 = var0.a(b[var1], a);
               y.d.n var3 = var0.a(b[var1].d(), a, var2);
               var10000 = y.d.n.a(b[var1], var3, 1.0D);
               if(var4 != 0) {
                  break;
               }

               if(!var10000) {
                  return false;
               }

               ++var1;
               if(var4 == 0) {
                  continue;
               }
            }

            var10000 = true;
            break;
         }

         return var10000;
      }
   }

   private static int a(X var0) {
      byte var1 = 15;
      if(var0.f() > 100) {
         var1 = 10;
         if(a.f == 0) {
            return var1;
         }
      }

      if(var0.f() > 500) {
         var1 = 5;
      }

      return var1;
   }
}
