package y.f;

import y.f.B;
import y.f.C;
import y.f.D;
import y.f.E;
import y.f.I;
import y.f.Q;
import y.f.X;
import y.f.aM;
import y.f.aV;
import y.f.aW;
import y.f.ae;
import y.f.am;

public class aL implements E {
   private double a;
   private boolean b;
   private boolean c;
   private boolean d;
   private double e;
   private byte f;
   private static final y.d.z g = new y.d.z(1.0D, 0.0D);

   public byte a() {
      return this.f;
   }

   public void a(double var1) {
      this.a = var1;
   }

   public boolean b() {
      return this.d;
   }

   public Object c() {
      return new aM(0, 0.0D, false);
   }

   public y.d.n a(y.d.q var1, I var2, am var3, am var4, Object var5) {
      boolean var23 = X.j;
      aM var6 = var5 != null?(aM)var5:(aM)this.c();
      int var7 = var6.a();
      double var8 = var6.b();
      boolean var10 = var6.c();
      y.d.n var11 = new y.d.n(new y.d.t(0.0D, 0.0D), var1);
      var11.a(6.283185307179586D - this.e);
      y.d.v var12 = ae.a(var2, var3, var4, 0.0D);
      if(var12.h() < 2 || var12.h() == 2 && y.d.t.a(var12.c(), var12.d()) < 1.0E-4D) {
         label90: {
            if(var12.h() < 2) {
               y.d.y var24 = var11.h();
               var11.e(var3.getX() + var24.a * 0.5D, var3.getY() + var24.b * 0.5D);
               if(!var23) {
                  break label90;
               }
            }

            y.d.t var25 = var12.c();
            var11.e(var25.a, var25.b);
         }

         if(this.b()) {
            ae.b(var11);
         }

         return var11;
      } else {
         int var13;
         label85: {
            if(var7 < 0) {
               var13 = Math.max(0, var12.h() - 1 + var7);
               if(!var23) {
                  break label85;
               }
            }

            var13 = Math.min(var12.h() - 2, var7);
         }

         y.d.m var14 = var12.a(var13);
         if(var14 == null) {
            y.d.y var26 = var11.h();
            var11.e(var3.getX() + var26.a * 0.5D, var3.getY() + var26.b * 0.5D);
            if(this.b()) {
               ae.b(var11);
            }

            return var11;
         } else {
            y.d.t var15 = var14.c();
            y.d.t var16 = var14.d();
            double var17;
            if(var14.g() == 0.0D) {
               label77: {
                  var17 = var3.getX() + var3.getWidth() * 0.5D + var2.getSourcePoint().a - (var4.getX() + var4.getWidth() * 0.5D + var2.getTargetPoint().a);
                  double var19 = var3.getY() + var3.getHeight() * 0.5D + var2.getSourcePoint().b - (var4.getY() + var4.getHeight() * 0.5D + var2.getTargetPoint().b);
                  if(var17 == 0.0D && var19 == 0.0D) {
                     var16 = new y.d.t(var15.a + 1.0E-6D, var15.b);
                     if(!var23) {
                        break label77;
                     }
                  }

                  double var21 = Math.sqrt(var17 * var17 + var19 * var19);
                  var16 = new y.d.t(var15.a + 1.0E-6D * var17 / var21, var15.b + 1.0E-6D * var19 / var21);
               }

               var14 = new y.d.m(var15, var16);
            }

            if(this.c) {
               var11.a(b(y.d.z.d(var14.i(), g) - this.e));
            }

            var17 = 0.0D;
            if(this.f != 0) {
               var17 = var10?-this.a:this.a;
            }

            y.d.n var27;
            label68: {
               var27 = new y.d.n(var11);
               if(var13 == 0 && a(var3, var15, 5.0D)) {
                  this.b(var27, var14, var3, var17);
                  if(!var23) {
                     break label68;
                  }
               }

               this.a(var27, var14, var15, var17);
            }

            y.d.n var20;
            label62: {
               var20 = new y.d.n(var11);
               if(var13 >= var12.h() - 2 && a(var4, var16, 5.0D)) {
                  this.a(var20, var14, var4, var17);
                  if(!var23) {
                     break label62;
                  }
               }

               this.a(var20, var14, var16, var17);
            }

            y.d.t var28 = new y.d.t(var27.b() * (1.0D - var8) + var20.b() * var8, var27.c() * (1.0D - var8) + var20.c() * var8);
            var11.a(var28);
            if(this.b()) {
               ae.b(var11);
            }

            return var11;
         }
      }
   }

   public y.c.D a(C var1, I var2, am var3, am var4) {
      boolean var20 = X.j;
      y.c.D var5 = new y.c.D();
      y.d.t[] var6 = ae.a(var2, var3, var4, 0.0D).f();
      if(var6.length >= 2 && (var6.length != 2 || y.d.t.a(var6[0], var6[1]) >= 1.0E-4D)) {
         int var21 = 0;

         while(var21 < var6.length - 1) {
            y.d.t var8 = var6[var21];
            y.d.t var9 = var6[var21 + 1];
            double var14;
            if(var8.equals(var9)) {
               label85: {
                  double var10 = var3.getX() + var3.getWidth() * 0.5D + var2.getSourcePoint().a - (var4.getX() + var4.getWidth() * 0.5D + var2.getTargetPoint().a);
                  double var12 = var3.getY() + var3.getHeight() * 0.5D + var2.getSourcePoint().b - (var4.getY() + var4.getHeight() * 0.5D + var2.getTargetPoint().b);
                  if(var10 == 0.0D && var12 == 0.0D) {
                     var9 = new y.d.t(var8.a + 1.0E-4D, var8.b);
                     if(!var20) {
                        break label85;
                     }
                  }

                  var14 = Math.sqrt(var10 * var10 + var12 * var12);
                  var9 = new y.d.t(var8.a + 1.0E-4D * var10 / var14, var8.b + 1.0E-4D * var12 / var14);
               }
            }

            y.d.m var22 = new y.d.m(var8, var9);
            double var11 = 6.283185307179586D - this.e;
            if(this.c) {
               var11 = b(y.d.z.d(var22.i(), g) - this.e);
            }

            int var13;
            y.d.n var16;
            label76: {
               var13 = var21 > (var6.length - 2) / 2?var21 + 1 - var6.length:var21;
               var14 = this.f == 0?0.0D:this.a;
               var16 = new y.d.n(var1.getOrientedBox());
               var16.a(var11);
               if(var21 == 0 && a(var3, var8, 5.0D)) {
                  this.b(var16, var22, var3, var14);
                  if(!var20) {
                     break label76;
                  }
               }

               this.a(var16, var22, var8, var14);
            }

            aM var17;
            y.d.n var18;
            label70: {
               var17 = new aM(var13, 0.0D, false);
               var5.add(new B(var16, var17, var1));
               var18 = new y.d.n(var1.getOrientedBox());
               var18.a(var11);
               if(var21 == var6.length - 2 && a(var4, var9, 5.0D)) {
                  this.a(var18, var22, var4, var14);
                  if(!var20) {
                     break label70;
                  }
               }

               this.a(var18, var22, var9, var14);
            }

            aM var19 = new aM(var13, 1.0D, false);
            var5.add(new B(var18, var19, var1));
            this.a(var5, var1, var16, var18, var22, var21, false);
            if(this.f == 1) {
               y.d.n var23;
               label62: {
                  var23 = new y.d.n(var1.getOrientedBox());
                  var23.a(var11);
                  if(var21 == 0 && a(var3, var8, 5.0D)) {
                     this.b(var23, var22, var3, -this.a);
                     if(!var20) {
                        break label62;
                     }
                  }

                  this.a(var23, var22, var8, -this.a);
               }

               label56: {
                  aM var15 = new aM(var13, 0.0D, true);
                  var5.add(new B(var23, var15, var1));
                  var16 = new y.d.n(var1.getOrientedBox());
                  var16.a(var11);
                  if(var21 == var6.length - 2 && a(var4, var9, 5.0D)) {
                     this.a(var16, var22, var4, -this.a);
                     if(!var20) {
                        break label56;
                     }
                  }

                  this.a(var16, var22, var9, -this.a);
               }

               var17 = new aM(var13, 1.0D, true);
               var5.add(new B(var16, var17, var1));
               this.a(var5, var1, var23, var16, var22, var13, true);
            }

            ++var21;
            if(var20) {
               break;
            }
         }

         return var5;
      } else {
         y.d.n var7;
         label95: {
            var7 = new y.d.n(var1.getOrientedBox());
            if(var6.length < 2) {
               var7.e(var3.getX() + var7.e() * 0.5D, var3.getY() - var7.f() * 0.5D);
               if(!var20) {
                  break label95;
               }
            }

            var7.e(var6[0].a, var6[0].b);
         }

         var5.add(new B(var7, this.c(), var1, false));
         return var5;
      }
   }

   private void a(y.c.D var1, C var2, y.d.n var3, y.d.n var4, y.d.m var5, int var6, boolean var7) {
      boolean var44 = X.j;
      y.d.t[] var8 = y.d.n.a(var3);
      int var9 = b(var8, var5);
      y.d.t var10 = var9 > 0?var8[var9 - 1]:var8[3];
      y.d.m var11 = new y.d.m(var8[var9], var10);
      y.d.t var12 = var9 < 3?var8[var9 + 1]:var8[0];
      y.d.m var13 = new y.d.m(var8[var9], var12);
      y.d.t[] var14 = y.d.n.a(var4);
      y.d.t var15 = a(var14[var9], var11, var8[var9]);
      double var16 = y.d.t.a(var8[var9], var15);
      int var18 = (int)Math.floor((var16 - var13.g()) / var13.g());
      y.d.t var19 = a(var14[var9], var13, var8[var9]);
      double var20 = y.d.t.a(var8[var9], var19);
      int var22 = (int)Math.floor((var20 - var11.g()) / var11.g());
      boolean var23 = var18 >= var22;
      double var24 = var23?var16:var20;
      y.d.m var26 = var23?var11:var13;
      y.d.m var27 = var23?var13:var11;
      int var28 = var23?var18:var22;
      if(var28 > 0 && var28 % 2 == 0) {
         ++var28;
      }

      double var29 = (var24 - (double)(var28 + 1) * var27.g()) / (double)(var28 + 1);
      y.d.z var31 = var5.i();
      var31.c();
      y.d.z var32 = var27.i();
      var32.c();
      var32.b(var29 + var27.g());
      y.d.t var33 = y.d.z.a(var3.a(), var32);
      y.d.t var34 = a(var33, var26, var3.a(), var5);
      if(var34 == null) {
         var34 = var33;
      }

      var31.b(y.d.t.a(var3.a(), var34));
      y.d.t var35 = var3.a();
      double var36 = y.d.t.a(var3.a(), var4.a());
      if(var28 > 0) {
         int var38 = 0;

         do {
            if(var38 >= var28) {
               return;
            }

            y.d.n var39 = new y.d.n(var3);
            y.d.t var40 = y.d.z.a(var35, var31);
            double var41 = y.d.t.a(var3.a(), var40);
            var39.a(var40);
            aM var43 = new aM(var6, var41 / var36, var7);
            var1.add(new B(var39, var43, var2));
            var35 = var40;
            ++var38;
         } while(!var44);
      }

      y.d.n var45 = new y.d.n(var3);
      y.d.t var46 = y.d.t.c(var4.k(), var3.k());
      var45.b(var46);
      aM var47 = new aM(var6, 0.5D, var7);
      var1.add(new B(var45, var47, var2));
   }

   private static boolean a(am var0, y.d.t var1, double var2) {
      return var0.getX() - var2 < var1.a && var0.getX() + var0.getWidth() + var2 > var1.a && var0.getY() - var2 < var1.b && var0.getY() + var0.getHeight() + var2 > var1.b;
   }

   public Object a(y.d.n var1, I var2, am var3, am var4) {
      if(ae.a(var1)) {
         throw new IllegalArgumentException("Invalid label bounds: " + var1);
      } else {
         D var5 = new D();
         var5.a((y.d.n)var1);
         y.c.D var6 = this.a((C)var5, (I)var2, (am)var3, (am)var4);
         if(var6.isEmpty()) {
            return this.c();
         } else {
            Q var7 = aW.a(var6, var1.k());
            return var7 != null?var7.b():this.c();
         }
      }
   }

   private static double b(double var0) {
      boolean var2 = X.j;
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
      boolean var12 = X.j;
      if(0 == this.a()) {
         var1.e(var3.a, var3.b);
         if(!var12) {
            return;
         }
      }

      y.d.z var6;
      label59: {
         var6 = y.d.z.c(var2.i());
         if(this.b) {
            if(!d(var4)) {
               break label59;
            }

            var6 = new y.d.z(-var6.a(), -var6.b());
            if(!var12) {
               break label59;
            }
         }

         double var7 = y.d.z.d(g, var6);
         if(var7 == 6.283185307179586D) {
            var7 = 0.0D;
         }

         if(var7 >= 3.141592653589793D && d(var4) || var7 < 3.141592653589793D && c(var4)) {
            var6 = new y.d.z(-var6.a(), -var6.b());
         }
      }

      var6.b(Math.abs(var4) + var1.e() + var1.f());
      y.d.t var13 = y.d.z.a(var3, var6);
      var1.e(var13.a, var13.b);
      y.d.t[] var8 = y.d.n.a(var1);
      double var9 = Double.MAX_VALUE;
      int var11 = 0;

      while(var11 < var8.length) {
         var9 = Math.min(var9, a(var2, var8[var11]));
         ++var11;
         if(var12) {
            return;
         }

         if(var12) {
            break;
         }
      }

      y.d.z var14 = new y.d.z(-var6.a(), -var6.b());
      var14.c();
      var14.b(var9 - Math.abs(var4));
      var13 = y.d.z.a(var13, var14);
      var1.e(var13.a, var13.b);
   }

   private void a(y.d.n var1, y.d.m var2, am var3, double var4) {
      this.a(var1, var2.d(), var2.c(), var3, false, var4);
   }

   private void b(y.d.n var1, y.d.m var2, am var3, double var4) {
      this.a(var1, var2.c(), var2.d(), var3, true, var4);
   }

   private void a(y.d.n var1, y.d.t var2, y.d.t var3, am var4, boolean var5, double var6) {
      y.d.y var8 = new y.d.y(var4.getX(), var4.getY(), var4.getWidth(), var4.getHeight());
      y.d.m var9 = new y.d.m(var2, var3);
      byte var10 = a(var9);
      y.d.t var11 = this.a(var10, var9, var1, var4, var5, var6);
      var1.a(var11);
      double var12 = aV.a(var8, var1);
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
         double var18 = aV.a(var8, var1);
         if(var18 < 2.5D || var18 > var12 && var12 > 2.5D) {
            var1.a(var11);
         }
      }

   }

   private y.d.t a(byte var1, y.d.m var2, y.d.n var3, am var4, boolean var5, double var6) {
      y.d.n var9;
      y.d.t var10;
      y.d.t var11;
      boolean var24;
      label254: {
         var24 = X.j;
         boolean var8 = 0 == this.a();
         var9 = new y.d.n(var3);
         var10 = var2.c();
         var11 = var2.d();
         double var12 = y.d.z.d(var2.i(), g);
         y.d.y var14 = var9.h();
         boolean var15;
         double var16;
         double var18;
         y.d.t var20;
         y.d.t var21;
         double var22;
         if(var1 == 0) {
            label309: {
               if(this.b) {
                  var15 = var5 && d(var6) || !var5 && c(var6);
                  if(!var24) {
                     break label309;
                  }
               }

               var15 = c(var6) && var12 <= 1.5707963267948966D || d(var6) && var12 > 1.5707963267948966D;
            }

            var16 = var4.getY() - 5.0D - var14.b() * 0.5D;
            if(var16 < var11.b) {
               var16 = var11.b;
            }

            var18 = var15?Math.min(var10.a, var11.a) - var14.a:Math.max(var10.a, var11.a) + var14.a;
            var9.e(var18, var16);
            var20 = var8?var9.k():a(y.d.n.a(var9), var2);
            var21 = a(var2, var20, 1.0D, 0.0D);
            var9.d(var21.a - var20.a, 0.0D);
            if(var8) {
               break label254;
            }

            var22 = a(var2, new y.d.z(1.0D, 0.0D), Math.abs(var6));
            if(var15) {
               var22 = -var22;
            }

            var9.d(var22, 0.0D);
            if(!var24) {
               break label254;
            }
         }

         if(var1 == 1) {
            label311: {
               if(this.b) {
                  var15 = var5 && c(var6) || !var5 && d(var6);
                  if(!var24) {
                     break label311;
                  }
               }

               var15 = c(var6) && var12 <= 4.71238898038469D || d(var6) && var12 > 4.71238898038469D;
            }

            var16 = var4.getY() + var4.getHeight() + 5.0D + var14.b() * 0.5D;
            if(var16 > var11.b) {
               var16 = var11.b;
            }

            var18 = var15?Math.min(var10.a, var11.a) - var14.a:Math.max(var10.a, var11.a) + var14.a;
            var9.e(var18, var16);
            var20 = var8?var9.k():a(y.d.n.a(var9), var2);
            var21 = a(var2, var20, 1.0D, 0.0D);
            var9.d(var21.a - var20.a, 0.0D);
            if(var8) {
               break label254;
            }

            var22 = a(var2, new y.d.z(1.0D, 0.0D), Math.abs(var6));
            if(!var15) {
               var22 = -var22;
            }

            var9.d(var22, 0.0D);
            if(!var24) {
               break label254;
            }
         }

         if(var1 == 2) {
            label177: {
               if(this.b) {
                  var15 = var5 && d(var6) || !var5 && c(var6);
                  if(!var24) {
                     break label177;
                  }
               }

               var15 = d(var6);
            }

            var16 = var4.getX() - 5.0D - var14.a() * 0.5D;
            if(var16 < var11.a) {
               var16 = var11.a;
            }

            var18 = var15?Math.max(var10.b, var11.b) + var14.b:Math.min(var10.b, var11.b) - var14.b;
            var9.e(var16, var18);
            var20 = var8?var9.k():a(y.d.n.a(var9), var2);
            var21 = a(var2, var20, 0.0D, 1.0D);
            var9.d(0.0D, var21.b - var20.b);
            if(var8) {
               break label254;
            }

            var22 = a(var2, new y.d.z(0.0D, 1.0D), Math.abs(var6));
            if(var15) {
               var22 = -var22;
            }

            var9.d(0.0D, var22);
            if(!var24) {
               break label254;
            }
         }

         if(var1 == 3) {
            label153: {
               if(this.b) {
                  var15 = var5 && c(var6) || !var5 && d(var6);
                  if(!var24) {
                     break label153;
                  }
               }

               var15 = d(var6);
            }

            var16 = var4.getX() + var4.getWidth() + 5.0D + var14.a() * 0.5D;
            if(var16 > var11.a) {
               var16 = var11.a;
            }

            var18 = var15?Math.max(var10.b, var11.b) + var14.b:Math.min(var10.b, var11.b) - var14.b;
            var9.e(var16, var18);
            var20 = var8?var9.k():a(y.d.n.a(var9), var2);
            var21 = a(var2, var20, 0.0D, 1.0D);
            var9.d(0.0D, var21.b - var20.b);
            if(!var8) {
               var22 = a(var2, new y.d.z(0.0D, 1.0D), Math.abs(var6));
               if(!var15) {
                  var22 = -var22;
               }

               var9.d(0.0D, var22);
            }
         }
      }

      if(y.d.t.a(var9.k(), var10) > y.d.t.a(var9.k(), var11)) {
         y.d.t var25 = new y.d.t((var10.a + var11.a) / 2.0D, (var10.b + var11.b) / 2.0D);
         if(var5) {
            this.a(var9, var2, var25, var6);
            if(!var24) {
               return var9.a();
            }
         }

         y.d.m var26 = new y.d.m(var2.d(), var2.c());
         this.a(var9, var26, var25, var6);
      }

      return var9.a();
   }

   private static boolean c(double var0) {
      return var0 > 0.0D || var0 == 0.0D && Double.doubleToLongBits(var0) == 0L;
   }

   private static boolean d(double var0) {
      return var0 < 0.0D || var0 == 0.0D && Double.doubleToLongBits(var0) < 0L;
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
      boolean var8 = X.j;
      double var2 = Double.MAX_VALUE;
      int var4 = -1;
      int var5 = 0;

      int var10000;
      while(true) {
         if(var5 < var0.length) {
            double var6 = a(var1, var0[var5]);
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

   private static double a(y.d.m var0, y.d.t var1) {
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

   private static y.d.t a(y.d.t var0, y.d.m var1, y.d.t var2) {
      double var3 = var0.a();
      double var5 = var0.b();
      y.d.t var7 = var1.c();
      y.d.t var8 = var1.d();
      double var9 = var8.a() - var7.a();
      double var11 = var8.b() - var7.b();
      double var13 = var2.a();
      double var15 = var2.b();
      double var17 = -var11;
      return y.d.e.a(var3, var5, var3 + var9, var5 + var11, var13, var15, var13 + var17, var15 + var9);
   }

   private static y.d.t a(y.d.t var0, y.d.m var1, y.d.t var2, y.d.m var3) {
      double var4 = var0.a();
      double var6 = var0.b();
      y.d.t var8 = var1.c();
      y.d.t var9 = var1.d();
      double var10 = var9.a() - var8.a();
      double var12 = var9.b() - var8.b();
      double var14 = var2.a();
      double var16 = var2.b();
      y.d.t var18 = var3.c();
      y.d.t var19 = var3.d();
      double var20 = var19.a() - var18.a();
      double var22 = var19.b() - var18.b();
      return y.d.e.a(var4, var6, var4 + var10, var6 + var12, var14, var16, var14 + var20, var16 + var22);
   }

   private static y.d.t a(y.d.m var0, y.d.t var1, double var2, double var4) {
      y.d.t var6 = var0.d();
      y.d.t var7 = var0.c();
      double var8 = var1.a();
      double var10 = var1.b();
      return y.d.e.a(var6.a(), var6.b(), var7.a(), var7.b(), var8, var10, var8 + var2, var10 + var4);
   }
}
