package y.h;

import y.h.fj;
import y.h.gv;
import y.h.hB;

class ik {
   private double a = 5.0D;
   private boolean b = true;
   private boolean c = false;
   private double d = 0.0D;
   private byte e = 0;
   private boolean f = false;
   private static final y.d.z g = new y.d.z(1.0D, 0.0D);

   public byte a() {
      return this.e;
   }

   public void a(byte var1) {
      this.e = var1;
   }

   public double b() {
      return this.a;
   }

   public void a(double var1) {
      this.a = var1;
   }

   public boolean c() {
      return this.b;
   }

   public void a(boolean var1) {
      this.b = var1;
   }

   public boolean d() {
      return this.c;
   }

   public void b(boolean var1) {
      this.c = var1;
   }

   public double e() {
      return this.d;
   }

   public void b(double var1) {
      this.d = var1;
   }

   public boolean f() {
      return this.f;
   }

   public void c(boolean var1) {
      this.f = var1;
   }

   public y.d.n a(y.d.q var1, y.f.I var2, y.f.am var3, y.f.am var4, gv var5) {
      boolean var32 = fj.z;
      int var6 = var5.a();
      double var7 = var5.b();
      y.d.n var9 = new y.d.n(new y.d.t(0.0D, 0.0D), var1);
      var9.a(6.283185307179586D - this.d);
      y.d.v var10 = y.f.ae.a(var2, var3, var4, 0.0D);
      if(var10.h() >= 2 && (var10.h() != 2 || y.d.t.a(var10.c(), var10.d()) >= 1.0E-4D)) {
         int var34;
         label93: {
            if(var6 < 0) {
               var34 = Math.max(0, var10.h() - 1 + var6);
               if(!var32) {
                  break label93;
               }
            }

            var34 = Math.min(var10.h() - 2, var6);
         }

         y.d.m var12 = var10.a(var34);
         if(var12 == null) {
            y.d.y var35 = var9.h();
            var9.e(var3.getX() + var35.a * 0.5D, var3.getY() + var35.b * 0.5D);
            if(this.d()) {
               y.f.ae.b(var9);
            }

            return var9;
         } else {
            y.d.t var13 = var12.c();
            y.d.t var14 = var12.d();
            double var15;
            if(var12.g() == 0.0D) {
               label85: {
                  var15 = var3.getX() + var3.getWidth() * 0.5D + var2.getSourcePoint().a - (var4.getX() + var4.getWidth() * 0.5D + var2.getTargetPoint().a);
                  double var17 = var3.getY() + var3.getHeight() * 0.5D + var2.getSourcePoint().b - (var4.getY() + var4.getHeight() * 0.5D + var2.getTargetPoint().b);
                  if(var15 == 0.0D && var17 == 0.0D) {
                     var14 = new y.d.t(var13.a + 1.0E-6D, var13.b);
                     if(!var32) {
                        break label85;
                     }
                  }

                  double var19 = Math.sqrt(var15 * var15 + var17 * var17);
                  var14 = new y.d.t(var13.a + 1.0E-6D * var15 / var19, var13.b + 1.0E-6D * var17 / var19);
               }

               var12 = new y.d.m(var13, var14);
            }

            if(this.b) {
               var9.a(c(y.d.z.d(var12.i(), g) - this.d));
            }

            var15 = Math.abs(var5.c());
            y.d.n var36 = new y.d.n(var9);
            this.a(var36, var12, var13, var15);
            if(var34 == 0 && this.a(var3, var36)) {
               this.b(var36, var12, var3, var15);
            }

            y.d.n var18 = new y.d.n(var9);
            this.a(var18, var12, var14, var15);
            if(var34 >= var10.h() - 2 && this.a(var4, var18)) {
               this.a(var18, var12, var4, var15);
            }

            if(y.d.t.a(var36.a(), var18.a()) < 1.0E-4D) {
               y.d.z var37 = var12.i();
               var37.c();
               var18.d(var37.a(), var37.b());
            }

            y.d.t var38;
            label115: {
               if(0.0D > var7 || var7 > 1.0D) {
                  double var28;
                  double var30;
                  label66: {
                     double var20 = var18.b() - var36.b();
                     double var22 = var18.c() - var36.c();
                     double var24 = Math.sqrt(var20 * var20 + var22 * var22);
                     double var26 = var24 != 0.0D?var7 / var24:0.0D;
                     if(var7 < 0.0D) {
                        var28 = var36.b() + var26 * var20;
                        var30 = var36.c() + var26 * var22;
                        if(!var32) {
                           break label66;
                        }
                     }

                     var28 = var18.b() + var26 * var20;
                     var30 = var18.c() + var26 * var22;
                  }

                  var38 = new y.d.t(var28, var30);
                  if(!var32) {
                     break label115;
                  }
               }

               var38 = new y.d.t(var36.b() * (1.0D - var7) + var18.b() * var7, var36.c() * (1.0D - var7) + var18.c() * var7);
            }

            var9.a(var38);
            if(this.d()) {
               y.f.ae.b(var9);
            }

            return var9;
         }
      } else {
         label98: {
            if(var10.h() < 2) {
               y.d.y var11 = var9.h();
               var9.e(var3.getX() + var11.a * 0.5D, var3.getY() + var11.b * 0.5D);
               if(!var32) {
                  break label98;
               }
            }

            y.d.t var33 = var10.c();
            var9.e(var33.a, var33.b);
         }

         if(this.d()) {
            y.f.ae.b(var9);
         }

         return var9;
      }
   }

   private gv g() {
      return this.a(0, 0.0D);
   }

   private gv a(int var1, double var2) {
      return new gv(var1, var2, this.b(), this.f(), this.a(), this.e());
   }

   public y.c.D a(y.f.C var1, y.f.I var2, y.f.am var3, y.f.am var4, Object var5) {
      boolean var25 = fj.z;
      y.c.D var6 = new y.c.D();
      y.d.v var7 = y.f.ae.a(var2, var3, var4, 0.0D);
      if(var7.h() >= 2 && (var7.h() != 2 || var7.a(0).g() >= 1.0E-4D)) {
         double var26 = var1.getModelParameter() == null?this.b():((gv)var5).c();
         y.d.n[] var10 = new y.d.n[var7.h() - 1];
         y.d.n[] var11 = new y.d.n[var7.h() - 1];
         int var12 = 0;

         int var10000;
         while(true) {
            if(var12 < var7.h() - 1) {
               var10[var12] = new y.d.n(0.0D, 0.0D, 0.0D, 0.0D);
               var11[var12] = new y.d.n(0.0D, 0.0D, 0.0D, 0.0D);
               this.a(var7, var12, var1.getOrientedBox().d(), var2, var3, var4, var10[var12], var11[var12], var26);
               double var30;
               var10000 = (var30 = y.d.t.a(var10[var12].a(), var11[var12].a()) - 1.0E-4D) == 0.0D?0:(var30 < 0.0D?-1:1);
               if(var25) {
                  break;
               }

               if(var10000 < 0) {
                  y.d.z var13 = var7.a(var12).i();
                  var13.c();
                  var11[var12].d(var13.a(), var13.b());
               }

               if(this.d()) {
                  y.f.ae.b(var10[var12]);
                  y.f.ae.b(var11[var12]);
               }

               ++var12;
               if(!var25) {
                  continue;
               }
            }

            var10000 = 0;
            break;
         }

         var12 = var10000;

         while(var12 < var7.h() - 1) {
            double var15;
            double var17;
            int var19;
            boolean var20;
            double[] var21;
            y.d.t var27;
            label76: {
               var27 = var10[var12].k();
               y.d.t var14 = var11[var12].k();
               var15 = var14.a() - var27.a();
               var17 = var14.b() - var27.b();
               var19 = var12 > (var7.h() - 2) / 2?var12 + 1 - var7.h():var12;
               var20 = var7.h() == 2;
               var21 = this.a(var12, var7, var10, var11);
               if(var21[0] > 0.0D) {
                  gv var22 = this.a(var19, var21[0]);
                  var6.add(new y.f.B(var10[var12].f(var15 * var21[0], var17 * var21[0]), var22, var1));
                  if(!var25) {
                     break label76;
                  }
               }

               var6.add(new y.f.B(var10[var12], this.a(var19, 0.0D), var1));
            }

            label70: {
               int var28 = var20?-1:var19;
               if(var21[1] < 1.0D) {
                  gv var23 = this.a(var28, var21[1]);
                  var6.add(new y.f.B(var10[var12].f(var15 * var21[1], var17 * var21[1]), var23, var1));
                  if(!var25) {
                     break label70;
                  }
               }

               var6.add(new y.f.B(var11[var12], this.a(var28, 1.0D), var1));
            }

            if(var21[0] < 0.5D && var21[1] > 0.5D) {
               y.d.n var29 = new y.d.n(var10[var12]);
               y.d.t var24 = y.d.t.c(var11[var12].k(), var27);
               var29.b(var24);
               if(this.d()) {
                  y.f.ae.b(var29);
               }

               var6.add(new y.f.B(var29, this.a(var19, 0.5D), var1));
            }

            ++var12;
            if(var25) {
               break;
            }
         }

         return var6;
      } else {
         y.d.n var8;
         label97: {
            var8 = new y.d.n(var1.getOrientedBox());
            if(var7.h() < 2) {
               var8.e(var3.getX() + var8.e() * 0.5D, var3.getY() - var8.f() * 0.5D);
               if(!var25) {
                  break label97;
               }
            }

            var8.e(var7.c().a, var7.c().b);
         }

         if(this.d()) {
            y.f.ae.b(var8);
         }

         var6.add(new y.f.B(var8, this.g(), var1, false));
         return var6;
      }
   }

   private static double c(double var0) {
      boolean var2 = fj.z;
      if(var0 < 0.0D) {
         var0 += 6.283185307179586D;
      }

      double var10000;
      while(true) {
         if(var0 > 6.283185307179586D) {
            var10000 = var0 - 6.283185307179586D;
            if(var2) {
               break;
            }

            var0 = var10000;
            if(!var2) {
               continue;
            }
         }

         var10000 = var0;
         break;
      }

      return var10000;
   }

   private static byte a(y.d.m var0) {
      double var1 = y.d.z.d(var0.i(), g);
      return (byte)(var1 >= 0.7853981633974483D && var1 < 2.356194490192345D?0:(var1 >= 2.356194490192345D && var1 < 3.9269908169872414D?2:(var1 >= 3.9269908169872414D && var1 < 5.497787143782138D?1:3)));
   }

   private static byte b(y.d.m var0) {
      double var1 = y.d.z.d(var0.i(), g);
      return (byte)(var1 >= 0.7853981633974483D && var1 < 2.356194490192345D?(var1 <= 1.5707963267948966D?3:2):(var1 >= 2.356194490192345D && var1 < 3.9269908169872414D?(var1 <= 3.141592653589793D?0:1):(var1 >= 3.9269908169872414D && var1 < 5.497787143782138D?(var1 <= 4.71238898038469D?2:3):(var1 <= 3.141592653589793D?0:1))));
   }

   private void a(y.d.n var1, y.d.m var2, y.d.t var3, double var4) {
      boolean var12 = fj.z;
      if(0 == this.a()) {
         var1.e(var3.a, var3.b);
         if(!var12) {
            return;
         }
      }

      y.d.z var6 = y.d.z.c(var2.i());
      if(2 == this.a()) {
         var6 = new y.d.z(-var6.a(), -var6.b());
      }

      y.d.t var7;
      double var8;
      label38: {
         var6.b(Math.abs(var4) + var1.e() + var1.f());
         var7 = y.d.z.a(var3, var6);
         var1.e(var7.a, var7.b);
         var8 = Double.MAX_VALUE;
         if(this.f) {
            var8 = b(var2, var1.k());
            if(!var12) {
               break label38;
            }
         }

         y.d.t[] var10 = y.d.n.a(var1);
         int var11 = 0;

         while(var11 < var10.length) {
            var8 = Math.min(var8, b(var2, var10[var11]));
            ++var11;
            if(var12) {
               return;
            }

            if(var12) {
               break;
            }
         }
      }

      y.d.z var13 = new y.d.z(-var6.a(), -var6.b());
      var13.c();
      var13.b(var8 - Math.abs(var4));
      var7 = y.d.z.a(var7, var13);
      var1.e(var7.a, var7.b);
   }

   private void a(y.d.n var1, y.d.m var2, y.f.am var3, double var4) {
      this.a(var1, var2.d(), var2.c(), var3, false, var4);
   }

   private void b(y.d.n var1, y.d.m var2, y.f.am var3, double var4) {
      this.a(var1, var2.c(), var2.d(), var3, true, var4);
   }

   private void a(y.d.n var1, y.d.t var2, y.d.t var3, y.f.am var4, boolean var5, double var6) {
      y.d.y var8 = new y.d.y(var4.getX(), var4.getY(), var4.getWidth(), var4.getHeight());
      y.d.m var9 = new y.d.m(var2, var3);
      byte var10 = a(var9);
      y.d.t var11 = this.a(var10, var9, var1, var4, var5, var6);
      var1.a(var11);
      double var12 = a(var8, var1);
      y.d.y var14 = var1.h();
      boolean var10000;
      if(Math.abs(var2.a - var3.a) <= 1.0E-4D || Math.abs(var2.b - var3.b) <= 1.0E-4D || var12 >= 2.5D && var12 <= 6.0D || (var10 != 0 && var10 != 1 || var3.a >= var8.c() - 5.0D - var14.a * 0.5D && var3.a <= var8.c() + var8.a() + 5.0D + var14.a * 0.5D) && (var10 != 2 && var10 != 3 || var3.b >= var8.d() - 5.0D - var14.b * 0.5D && var3.b <= var8.d() + var8.b() + 5.0D + var14.b * 0.5D)) {
         var10000 = false;
      } else {
         var10000 = true;
      }

      boolean var15 = var10000;
      if(var15) {
         byte var16 = b(var9);
         y.d.t var17 = this.a(var16, var9, var1, var4, var5, var6);
         var1.a(var17);
         double var18 = a(var8, var1);
         if(var18 < 2.5D || var18 > var12 && var12 > 2.5D) {
            var1.a(var11);
         }
      }

   }

   private static double a(y.d.y var0, y.d.n var1) {
      return hB.a(var0, var1);
   }

   private y.d.t a(byte var1, y.d.m var2, y.d.n var3, y.f.am var4, boolean var5, double var6) {
      y.d.n var9;
      y.d.t var10;
      y.d.t var11;
      boolean var22;
      label206: {
         var22 = fj.z;
         boolean var8 = 0 == this.a();
         var9 = new y.d.n(var3);
         var10 = var2.c();
         var11 = var2.d();
         y.d.y var12 = var9.h();
         boolean var13;
         double var14;
         double var16;
         y.d.t var18;
         y.d.t var19;
         double var20;
         if(var1 == 0) {
            var13 = var5 && this.a() == 2 || !var5 && this.a() == 1;
            var14 = var4.getY() - 5.0D - var12.b() * 0.5D;
            if(var14 < var11.b) {
               var14 = var11.b;
            }

            var16 = var13?Math.min(var10.a, var11.a) - var12.a:Math.max(var10.a, var11.a) + var12.a;
            var9.e(var16, var14);
            var18 = !var8 && !this.f?a(y.d.n.a(var9), var2):var9.k();
            var19 = a(var2, var18, 1.0D, 0.0D);
            var9.d(var19.a - var18.a, 0.0D);
            if(var8) {
               break label206;
            }

            var20 = a(var2, new y.d.z(1.0D, 0.0D), Math.abs(var6));
            if(var13) {
               var20 = -var20;
            }

            var9.d(var20, 0.0D);
            if(!var22) {
               break label206;
            }
         }

         if(var1 == 1) {
            var13 = var5 && this.a() == 1 || !var5 && this.a() == 2;
            var14 = var4.getY() + var4.getHeight() + 5.0D + var12.b() * 0.5D;
            if(var14 > var11.b) {
               var14 = var11.b;
            }

            var16 = var13?Math.min(var10.a, var11.a) - var12.a:Math.max(var10.a, var11.a) + var12.a;
            var9.e(var16, var14);
            var18 = !var8 && !this.f?a(y.d.n.a(var9), var2):var9.k();
            var19 = a(var2, var18, 1.0D, 0.0D);
            var9.d(var19.a - var18.a, 0.0D);
            if(var8) {
               break label206;
            }

            var20 = a(var2, new y.d.z(1.0D, 0.0D), Math.abs(var6));
            if(!var13) {
               var20 = -var20;
            }

            var9.d(var20, 0.0D);
            if(!var22) {
               break label206;
            }
         }

         if(var1 == 2) {
            var13 = var5 && this.a() == 2 || !var5 && this.a() == 1;
            var14 = var4.getX() - 5.0D - var12.a() * 0.5D;
            if(var14 < var11.a) {
               var14 = var11.a;
            }

            var16 = var13?Math.max(var10.b, var11.b) + var12.b:Math.min(var10.b, var11.b) - var12.b;
            var9.e(var14, var16);
            var18 = !var8 && !this.f?a(y.d.n.a(var9), var2):var9.k();
            var19 = a(var2, var18, 0.0D, 1.0D);
            var9.d(0.0D, var19.b - var18.b);
            if(var8) {
               break label206;
            }

            var20 = a(var2, new y.d.z(0.0D, 1.0D), Math.abs(var6));
            if(var13) {
               var20 = -var20;
            }

            var9.d(0.0D, var20);
            if(!var22) {
               break label206;
            }
         }

         if(var1 == 3) {
            var13 = var5 && this.a() == 1 || !var5 && this.a() == 2;
            var14 = var4.getX() + var4.getWidth() + 5.0D + var12.a() * 0.5D;
            if(var14 > var11.a) {
               var14 = var11.a;
            }

            var16 = var13?Math.max(var10.b, var11.b) + var12.b:Math.min(var10.b, var11.b) - var12.b;
            var9.e(var14, var16);
            var18 = !var8 && !this.f?a(y.d.n.a(var9), var2):var9.k();
            var19 = a(var2, var18, 0.0D, 1.0D);
            var9.d(0.0D, var19.b - var18.b);
            if(!var8) {
               var20 = a(var2, new y.d.z(0.0D, 1.0D), Math.abs(var6));
               if(!var13) {
                  var20 = -var20;
               }

               var9.d(0.0D, var20);
            }
         }
      }

      if(y.d.t.a(var9.k(), var10) > y.d.t.a(var9.k(), var11)) {
         y.d.t var23 = new y.d.t((var10.a + var11.a) / 2.0D, (var10.b + var11.b) / 2.0D);
         if(var5) {
            this.a(var9, var2, var23, var6);
            if(!var22) {
               return var9.a();
            }
         }

         y.d.m var24 = new y.d.m(var2.d(), var2.c());
         this.a(var9, var24, var23, var6);
      }

      return var9.a();
   }

   private static double a(y.d.m var0, y.d.z var1, double var2) {
      double var4 = y.d.z.d(var0.i(), var1);
      if(var4 == 1.5707963267948966D) {
         return var2;
      } else {
         if(var4 > 1.5707963267948966D) {
            var4 = 3.141592653589793D - var4;
         }

         return var2 / Math.sin(var4);
      }
   }

   private static y.d.t a(y.d.t[] var0, y.d.m var1) {
      return var0[b(var0, var1)];
   }

   private static int b(y.d.t[] var0, y.d.m var1) {
      boolean var8 = fj.z;
      double var2 = Double.MAX_VALUE;
      int var4 = -1;
      int var5 = 0;

      int var10000;
      while(true) {
         if(var5 < var0.length) {
            double var6 = b(var1, var0[var5]);
            double var9;
            var10000 = (var9 = var6 - var2) == 0.0D?0:(var9 < 0.0D?-1:1);
            if(var8) {
               break;
            }

            if(var10000 < 0) {
               var4 = var5;
               var2 = var6;
            }

            ++var5;
            if(!var8) {
               continue;
            }
         }

         var10000 = var4;
         break;
      }

      return var10000;
   }

   private static double a(y.d.m var0, y.d.n var1) {
      boolean var8 = fj.z;
      y.d.t[] var2 = y.d.n.a(var1);
      double var3 = a(var0, var2[0]);
      if(var3 == 0.0D) {
         return 0.0D;
      } else {
         int var5 = 1;

         double var10000;
         while(true) {
            if(var5 < var2.length) {
               double var6 = a(var0, var2[var5]);
               var10000 = var6;
               if(var8) {
                  break;
               }

               if(var6 == 0.0D || var6 != var3) {
                  return 0.0D;
               }

               ++var5;
               if(!var8) {
                  continue;
               }
            }

            var10000 = Double.MAX_VALUE;
            break;
         }

         double var9 = var10000;
         int var7 = 0;

         while(true) {
            if(var7 < var2.length) {
               var10000 = Math.min(var9, b(var0, var2[var7]));
               if(var8) {
                  break;
               }

               var9 = var10000;
               ++var7;
               if(!var8) {
                  continue;
               }
            }

            var10000 = var9;
            break;
         }

         return var10000;
      }
   }

   private static double a(y.d.m var0, y.d.t var1) {
      y.d.t var2 = var0.c();
      y.d.t var3 = var0.d();
      double var4 = (var3.a() - var2.a()) * (var1.b() - var2.b()) - (var3.b() - var2.b()) * (var1.a() - var2.a());
      return Double.isNaN(var4)?var4:(var4 > 0.0D?1.0D:(var4 < -0.0D?-1.0D:var4));
   }

   private static double b(y.d.m var0, y.d.t var1) {
      y.d.t var2 = var0.c();
      y.d.t var3 = var0.d();
      double var4 = var3.a - var2.a;
      double var6 = var3.b - var2.b;
      double var8 = var1.a - var2.a;
      double var10 = var1.b - var2.b;
      double var12 = var8 * var4 + var10 * var6;
      double var14 = var12 * var12 / (var4 * var4 + var6 * var6);
      double var16 = var8 * var8 + var10 * var10 - var14;
      if(var16 < 0.0D) {
         var16 = 0.0D;
      }

      return Math.sqrt(var16);
   }

   private double[] a(int var1, y.d.v var2, y.d.n[] var3, y.d.n[] var4) {
      boolean var27 = fj.z;
      double[] var5 = new double[]{0.0D, 1.0D};
      y.d.t[] var6 = var2.f();
      double var7 = Math.sqrt(var3[var1].f() * var3[var1].f() + var3[var1].e() * var3[var1].e());
      double var9 = 30.0D + var7;
      double var11 = y.d.t.a(var3[var1].k(), var4[var1].k());
      y.d.z var13;
      y.d.z var14;
      y.d.t var15;
      double var16;
      double var18;
      double var20;
      y.d.m var22;
      y.d.n var23;
      double var24;
      y.d.z var26;
      double var29;
      if(var1 > 0) {
         var13 = new y.d.z(var6[var1 + 1], var6[var1]);
         var14 = new y.d.z(var6[var1 - 1], var6[var1]);
         var15 = y.d.e.a(var3[var1 - 1].k(), var14, var3[var1].k(), var13);
         if(var15 != null) {
            label106: {
               var16 = y.d.z.d(var13, var14);
               if(this.a() == 1 && var16 < 3.141592653589793D || this.a() == 2 && var16 > 3.141592653589793D) {
                  var18 = y.d.t.a(var6[var1], var6[var1 + 1]);
                  var20 = y.d.t.a(var6[var1 - 1], var6[var1]);
                  if(var20 + var7 < var18 && y.d.t.a(var6[var1], var15) > var20) {
                     var22 = new y.d.m(var6[var1 - 1], y.d.z.a(var6[var1 - 1], y.d.z.c(var13)));
                     var23 = new y.d.n(var4[var1]);
                     var24 = a(var22, var23);
                     if(var24 > 0.0D) {
                        var26 = new y.d.z(var6[var1], var6[var1 + 1]);
                        var26.c();
                        var26.b(var24);
                        var23.d(var26.a(), var26.b());
                     }

                     var15 = var23.k();
                  }

                  if(y.d.t.a(var6[var1], var15) > var18) {
                     var5[0] = 1.0D;
                     if(!var27) {
                        break label106;
                     }
                  }

                  var29 = y.d.t.a(var15, var3[var1].k());
                  if(var29 >= var11) {
                     break label106;
                  }

                  var5[0] = var29 / var11;
                  if(!var27) {
                     break label106;
                  }
               }

               if(y.d.t.a(var15, var4[var1].k()) > var11) {
                  var5[0] = -Math.min(Math.abs(var9), y.d.t.a(var15, var3[var1].k()));
               }
            }
         }
      }

      if(var1 < var6.length - 2) {
         var13 = new y.d.z(var6[var1], var6[var1 + 1]);
         var14 = new y.d.z(var6[var1 + 2], var6[var1 + 1]);
         var15 = y.d.e.a(var3[var1 + 1].k(), var14, var3[var1].k(), var13);
         if(var15 != null) {
            label107: {
               var16 = y.d.z.d(var14, var13);
               if(this.a() == 1 && var16 < 3.141592653589793D || this.a() == 2 && var16 > 3.141592653589793D) {
                  var18 = y.d.t.a(var6[var1], var6[var1 + 1]);
                  var20 = y.d.t.a(var6[var1 + 2], var6[var1 + 1]);
                  if(var20 + var7 < var18 && y.d.t.a(var6[var1 + 1], var15) > var20) {
                     var22 = new y.d.m(var6[var1 + 2], y.d.z.a(var6[var1 + 2], y.d.z.c(var13)));
                     var23 = new y.d.n(var3[var1]);
                     var24 = a(var22, var23);
                     if(var24 > 0.0D) {
                        var26 = new y.d.z(var6[var1 + 1], var6[var1]);
                        var26.c();
                        var26.b(var24);
                        var23.d(var26.a(), var26.b());
                     }

                     var15 = var23.k();
                  }

                  if(y.d.t.a(var6[var1 + 1], var15) > var18) {
                     var5[1] = 0.0D;
                     if(!var27) {
                        break label107;
                     }
                  }

                  var29 = y.d.t.a(var15, var3[var1].k()) / var11;
                  if(var29 >= 1.0D) {
                     break label107;
                  }

                  var5[1] = var29;
                  if(!var27) {
                     break label107;
                  }
               }

               var18 = y.d.t.a(var15, var3[var1].k()) / var11;
               if(var18 > 1.0D) {
                  var5[1] = Math.max(1.0001D, Math.min(Math.abs(var9), y.d.t.a(var15, var4[var1].k())));
               }
            }
         }
      }

      if(var5[0] > var5[1]) {
         double var28 = var5[0];
         var5[0] = var5[1];
         var5[1] = var28;
      }

      return var5;
   }

   public gv a(y.d.n var1, y.f.I var2, y.f.am var3, y.f.am var4, gv var5, byte var6, boolean var7) {
      boolean var51 = fj.z;
      y.d.v var8 = y.f.ae.a(var2, var3, var4, 0.0D);
      int var9 = var8.h();
      if(var9 >= 2 && (var9 != 2 || var8.a(0).g() >= 1.0E-4D)) {
         double var10 = Double.MAX_VALUE;
         double var12 = Double.MAX_VALUE;
         gv var14 = null;
         double[] var15 = null;
         y.d.t var16 = var1.k();
         int var17 = -1;
         if(var6 == 1 || var6 == 2 || var5 != null && var5.e() == this.a()) {
            label287: {
               if(var5.a() < 0) {
                  var17 = Math.max(0, var9 - 1 + var5.a());
                  if(!var51) {
                     break label287;
                  }
               }

               var17 = Math.min(var9 - 2, var5.a());
            }
         }

         y.d.n[] var18 = new y.d.n[var8.h() - 1];
         y.d.n[] var19 = new y.d.n[var8.h() - 1];
         double[] var20 = new double[var8.h() - 1];
         int var21 = 0;

         while(var21 < var9 - 1) {
            var18[var21] = new y.d.n(0.0D, 0.0D, 0.0D, 0.0D);
            var19[var21] = new y.d.n(0.0D, 0.0D, 0.0D, 0.0D);
            y.d.m var22 = var8.a(var21);
            var20[var21] = 2 != var6 && var5 != null?var5.c():(this.a() == 0?this.b():this.a(var1, var22));
            this.a(var8, var21, var1.d(), var2, var3, var4, var18[var21], var19[var21], var20[var21]);
            ++var21;
            if(var51) {
               break;
            }
         }

         var21 = 0;

         int var10000;
         int var10001;
         y.d.t var24;
         y.d.t var25;
         double var27;
         double var29;
         label224: {
            while(true) {
               if(var21 < var9 - 1) {
                  var10000 = var6;
                  var10001 = 1;
                  if(var51) {
                     break;
                  }

                  if(var6 != 1 || var6 == 1 && var17 == var21) {
                     var24 = var18[var21].k();
                     var25 = var19[var21].k();
                     if(y.d.t.a(var24, var25) < 1.0E-4D) {
                        y.d.z var26 = var8.a(var21).i();
                        var26.c();
                        var25 = y.d.z.a(var25, var26);
                     }

                     y.d.t var54 = a(var16, var24, new y.d.z(var25, var24));
                     var27 = var54.a - var24.a;
                     var29 = var54.b - var24.b;
                     double var31 = var25.a - var24.a;
                     double var33 = var25.b - var24.b;
                     if(var31 == 0.0D && var33 == 0.0D) {
                        var31 = 1.0D;
                        var33 = 0.0D;
                     }

                     double var53;
                     label264: {
                        if(var31 < 1.0E-4D && var31 > -1.0E-4D) {
                           var53 = var29 / var33;
                           if(!var51) {
                              break label264;
                           }
                        }

                        if(var33 < 1.0E-4D && var33 > -1.0E-4D) {
                           var53 = var27 / var31;
                           if(!var51) {
                              break label264;
                           }
                        }

                        var53 = (var27 / var31 + var29 / var33) / 2.0D;
                     }

                     double[] var35 = this.a(var21, var8, var18, var19);
                     if(var53 < 0.0D) {
                        var53 = -Math.sqrt(var27 * var27 + var29 * var29);
                     }

                     if(2 != var6 && var5 != null) {
                        label199: {
                           if(var17 == var21 && var5.b() < 0.0D) {
                              var53 = Math.max(var53, var5.b());
                              var35[0] = Math.min(var35[0], var5.b());
                              if(!var51) {
                                 break label199;
                              }
                           }

                           var53 = Math.max(var35[0], var53);
                        }
                     }

                     if(var53 > 1.0D) {
                        var27 = var25.a - var54.a;
                        var29 = var25.b - var54.b;
                        var53 = Math.max(Math.sqrt(var27 * var27 + var29 * var29), 1.0000001D);
                     }

                     if(2 != var6 && var5 != null) {
                        label190: {
                           if(var17 == var21 && var5.b() > 1.0D) {
                              var53 = Math.min(var53, var5.b());
                              var35[1] = Math.max(var35[1], var5.b());
                              if(!var51) {
                                 break label190;
                              }
                           }

                           var53 = Math.min(var35[1], var53);
                        }
                     }

                     gv var37;
                     double var39;
                     double var41;
                     label179: {
                        int var36 = var53 <= 1.0D && var21 != var9 - 2?var21:var21 + 1 - var9;
                        var37 = new gv(var36, var53, var20[var21], this.f(), this.a(), this.e());
                        y.d.n var38 = this.a(var1.d(), var2, var3, var4, var37);
                        var39 = y.d.t.a(var38.k(), var16);
                        var41 = Math.abs(var37.c());
                        y.d.m var43 = var8.a(var21);
                        double var44 = var43.g();
                        y.d.t var46 = a(var16, var43.c(), var43.i());
                        double var47 = y.d.t.a(var24, var46);
                        double var49 = y.d.t.a(var25, var46);
                        if(var47 > var44 && var49 < var47) {
                           var41 += 1.1D * Math.abs(var49);
                           if(!var51) {
                              break label179;
                           }
                        }

                        if(var49 > var44 && var47 < var49) {
                           var41 += 1.1D * Math.abs(var47);
                        }
                     }

                     if(var6 == 2 && var17 != var21) {
                        var41 += 5.0D;
                     }

                     if(var39 + 1.0E-4D < var10 || var39 < 1.0E-4D && var41 < var12) {
                        var14 = var37;
                        var10 = var39;
                        var12 = var41;
                        var15 = var35;
                     }
                  }

                  ++var21;
                  if(!var51) {
                     continue;
                  }
               }

               if(var14.a() >= 0) {
                  var10000 = var14.a();
                  break label224;
               }

               var10000 = var14.a();
               var10001 = var9 - 1;
               break;
            }

            var10000 += var10001;
         }

         var21 = var10000;
         y.d.n var57 = var18[var21];
         y.d.n var23 = var19[var21];
         var24 = var57.k();
         var25 = var23.k();
         y.d.m var58;
         if(var5 == null) {
            var18 = new y.d.n[var8.h() - 1];
            var19 = new y.d.n[var8.h() - 1];
            var20 = new double[var8.h() - 1];
            int var55 = 0;

            double[] var52;
            label266: {
               while(var55 < var9 - 1) {
                  var18[var55] = new y.d.n(0.0D, 0.0D, 0.0D, 0.0D);
                  var19[var55] = new y.d.n(0.0D, 0.0D, 0.0D, 0.0D);
                  var58 = var8.a(var55);
                  var52 = var20;
                  var10001 = var55;
                  if(var51) {
                     break label266;
                  }

                  var20[var55] = var14 != null?var14.c():(this.a() == 0?this.b():this.a(var1, var58));
                  this.a(var8, var55, var1.d(), var2, var3, var4, var18[var55], var19[var55], var14.c());
                  ++var55;
                  if(var51) {
                     break;
                  }
               }

               var15 = this.a(var21, var8, var18, var19);
               if(var14.b() < 0.0D) {
                  var15[0] = Math.min(var15[0], var14.b());
               }

               if(var14.b() > 1.0D) {
                  var15[1] = Math.max(var15[1], var14.b());
               }

               var15[0] = Math.min(var15[0], var14.b());
               var52 = var15;
               var10001 = 1;
            }

            var52[var10001] = Math.max(var15[1], var14.b());
         }

         double[] var56;
         y.d.z var59;
         label268: {
            var56 = new double[4];
            if(var15[0] < 0.0D) {
               var59 = new y.d.z(var25, var24);
               var59.c();
               var59.b(var15[0]);
               var56[0] = var24.a() + var59.a();
               var56[1] = var24.b() + var59.b();
               if(!var51) {
                  break label268;
               }
            }

            if(var15[0] > 0.0D) {
               var27 = var25.a() - var24.a();
               var29 = var25.b() - var24.b();
               var56[0] = var24.a() + var27 * var15[0];
               var56[1] = var24.b() + var29 * var15[0];
               if(!var51) {
                  break label268;
               }
            }

            var56[0] = var24.a();
            var56[1] = var24.b();
         }

         label269: {
            if(var15[1] > 1.0D) {
               var59 = new y.d.z(var25, var24);
               var59.c();
               var59.b(var15[1]);
               var56[2] = var25.a() + var59.a();
               var56[3] = var25.b() + var59.b();
               if(!var51) {
                  break label269;
               }
            }

            if(var15[1] < 1.0D) {
               var27 = var25.a() - var24.a();
               var29 = var25.b() - var24.b();
               var56[2] = var24.a() + var27 * var15[1];
               var56[3] = var24.b() + var29 * var15[1];
               if(!var51) {
                  break label269;
               }
            }

            var56[2] = var25.a();
            var56[3] = var25.b();
         }

         if(var7) {
            var58 = var8.a(var21);
            double var28 = (var14.f() - y.d.z.d(new y.d.z(1.0D, 0.0D), var58.i())) % 6.283185307179586D;
            gv var30 = new gv(var14.a(), var14.b(), var14.c(), var14.d(), var14.e(), var28);
            var30.a(var56[0], var56[1], var56[2], var56[3]);
            return var30;
         } else {
            var14.a(var56[0], var56[1], var56[2], var56[3]);
            return var14;
         }
      } else {
         return this.g();
      }
   }

   private double a(y.d.n var1, y.d.m var2) {
      y.d.n var3 = new y.d.n(var1);
      y.d.t var4 = var1.k();
      double var5;
      if(this.c()) {
         var5 = c(y.d.z.d(var2.i(), g) - var3.j());
         var3.a(var5);
         var3.b(var4);
      }

      var5 = y.d.z.d(var2.i(), (new y.d.m(var2.c(), var4)).i());
      double var7 = this.f?b(var2, var4):a(var2, var3);
      return var5 > 3.141592653589793D?-var7:var7;
   }

   private static y.d.t a(y.d.t var0, y.d.t var1, y.d.z var2) {
      double var3 = var0.a - var1.a;
      double var5 = var0.b - var1.b;
      double var7 = var2.a();
      double var9 = var2.b();
      double var11 = var7 * var7 + var9 * var9;
      double var13 = (var3 * var7 + var5 * var9) / var11;
      return new y.d.t(var1.a + var13 * var7, var1.b + var13 * var9);
   }

   private void a(y.d.v var1, int var2, y.d.q var3, y.f.I var4, y.f.am var5, y.f.am var6, y.d.n var7, y.d.n var8, double var9) {
      y.d.m var11 = var1.a(var2);
      y.d.t var12 = var11.c();
      y.d.t var13 = var11.d();
      double var14;
      if(var11.g() == 0.0D) {
         label31: {
            var14 = var5.getX() + var5.getWidth() * 0.5D + var4.getSourcePoint().a - (var6.getX() + var6.getWidth() * 0.5D + var4.getTargetPoint().a);
            double var16 = var5.getY() + var5.getHeight() * 0.5D + var4.getSourcePoint().b - (var6.getY() + var6.getHeight() * 0.5D + var4.getTargetPoint().b);
            if(var14 == 0.0D && var16 == 0.0D) {
               var13 = new y.d.t(var12.a + 1.0E-4D, var12.b);
               if(!fj.z) {
                  break label31;
               }
            }

            double var18 = Math.sqrt(var14 * var14 + var16 * var16);
            var13 = new y.d.t(var12.a + 1.0E-4D * var14 / var18, var12.b + 1.0E-4D * var16 / var18);
         }

         var11 = new y.d.m(var12, var13);
      }

      var14 = 6.283185307179586D - this.d;
      if(this.b) {
         var14 = c(y.d.z.d(var11.i(), g) - this.d);
      }

      var7.a(var3);
      var7.a(var14);
      this.a(var7, var11, var12, var9);
      if(var2 == 0 && this.a(var5, var7)) {
         this.b(var7, var11, var5, var9);
      }

      var8.a(var3);
      var8.a(var14);
      this.a(var8, var11, var13, var9);
      if(var2 == var1.h() - 2 && this.a(var6, var8)) {
         this.a(var8, var11, var6, var9);
      }

   }

   private boolean a(y.f.am var1, y.d.n var2) {
      y.d.y var3 = new y.d.y(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
      return y.d.n.a(var2, var3, 5.0D);
   }

   private static y.d.t a(y.d.m var0, y.d.t var1, double var2, double var4) {
      y.d.t var6 = var0.d();
      y.d.t var7 = var0.c();
      double var8 = var1.a();
      double var10 = var1.b();
      return y.d.e.a(var6.a(), var6.b(), var7.a(), var7.b(), var8, var10, var8 + var2, var10 + var4);
   }
}
