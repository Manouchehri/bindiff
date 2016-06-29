package y.f;

import y.f.B;
import y.f.C;
import y.f.D;
import y.f.E;
import y.f.I;
import y.f.Q;
import y.f.X;
import y.f.aP;
import y.f.aW;
import y.f.ae;
import y.f.am;

public class aO implements E {
   private double a = 1.0D;
   private double b = 1.0D;
   private double c = 1.0D;
   private double d = 9.125D;
   private byte e;
   private static final aP f = new aP(0, 0.0D, new y.d.z(0.0D, 0.0D), (byte)2, 0.0D);
   private static final aP g = new aP(0, 0.0D, new y.d.z(0.0D, 0.0D), (byte)0, 0.0D);

   public aO(byte var1) {
      this.e = var1;
   }

   public byte a() {
      return this.e;
   }

   public void a(double var1, double var3) {
      this.a = var1;
      this.b = var3;
   }

   public Object c() {
      return this.e == 1?f:g;
   }

   public y.d.n a(y.d.q var1, I var2, am var3, am var4, Object var5) {
      aP var6 = var5 != null?(aP)var5:(aP)this.c();
      int var7 = var6.a();
      byte var8 = var6.d();
      double var9 = var6.b();
      y.d.z var11 = var6.c();
      y.d.v var12 = ae.a(var2, var3, var4, this.d);
      int var13 = var7 < 0?var12.h() - 1 + var7:var7;
      y.d.m var14 = var12.a(var13);
      y.d.n var15 = new y.d.n(new y.d.t(0.0D, 0.0D), var1);
      y.d.y var16 = var15.h();
      if(var14 == null) {
         var15.e(var3.getX() + var16.a * 0.5D, var3.getY() + var16.b * 0.5D);
         return var15;
      } else {
         y.d.t var17 = var14.c();
         y.d.t var18 = var14.d();
         if(var14.g() == 0.0D) {
            label27: {
               double var19 = var3.getX() + var3.getWidth() * 0.5D + var2.getSourcePoint().a - (var4.getX() + var4.getWidth() * 0.5D + var2.getTargetPoint().a);
               double var21 = var3.getY() + var3.getHeight() * 0.5D + var2.getSourcePoint().b - (var4.getY() + var4.getHeight() * 0.5D + var2.getTargetPoint().b);
               if(var19 == 0.0D && var21 == 0.0D) {
                  var18 = new y.d.t(var17.a + 1.0E-6D, var17.b);
                  if(!X.j) {
                     break label27;
                  }
               }

               double var23 = Math.sqrt(var19 * var19 + var21 * var21);
               var18 = new y.d.t(var17.a + 1.0E-6D * var19 / var23, var17.b + 1.0E-6D * var21 / var23);
            }
         }

         y.d.t var25 = this.a(var9, var17, var18, var16, var8);
         y.d.t var20 = y.d.z.a(var25, var11);
         var20 = y.d.t.b(var20, var17);
         var15.e(var20.a() + var16.a * 0.5D, var20.b() + var16.b * 0.5D);
         return var15;
      }
   }

   public y.c.D a(C var1, I var2, am var3, am var4) {
      boolean var44 = X.j;
      byte[] var5 = a(this.e);
      y.d.n var6 = aW.a(var1.getOrientedBox());
      double var7 = var6.e();
      double var9 = var6.f();
      y.d.q var11 = new y.d.q(var7, var9);
      y.c.D var12 = new y.c.D();
      y.d.v var13 = ae.a(var2, var3, var4, this.d);
      y.d.u var14 = var13.b();
      if(!var14.f()) {
         var6.e(var3.getX() + var7 * 0.5D, var3.getY() + var9 * 0.5D);
         B var45 = new B(var6, this.c(), var1, false);
         var12.add(var45);
         return var12;
      } else {
         double[] var15 = new double[var13.h() - 1];
         double[] var16 = new double[var13.h() - 1];
         double var17 = this.a(var13, var15, var16);
         y.d.t var19 = var14.a();
         var14.g();
         int var20 = 0;

         do {
            byte var10000 = var14.f();

            label75:
            while(true) {
               if(var10000 == 0) {
                  return var12;
               }

               y.d.t var21 = var19;
               var19 = var14.a();
               double var22 = var19.a() - var21.a();
               double var24 = var19.b() - var21.b();
               double[] var26 = this.a(var22, var24, var7, var9);
               int var27 = 0;

               label73:
               while(true) {
                  int var46 = var27;
                  int var10001 = var5.length;

                  label70:
                  while(true) {
                     if(var46 >= var10001) {
                        break label75;
                     }

                     boolean var28 = false;
                     var10000 = var5[var27];
                     if(var44) {
                        continue label75;
                     }

                     if(var10000 == 0) {
                        var28 = true;
                     }

                     y.d.z var29 = this.a(var22, var24, var7, var9, var5[var27]);
                     y.d.z var30 = y.d.z.b(var29);
                     var30.b(this.a);
                     int var32 = 0;

                     while(true) {
                        ++var32;
                        int var33 = 0;

                        while(var33 < var26.length) {
                           double var34 = var26[var33];
                           y.d.t var36 = this.a(var34, var21, var19, var11, var5[var27]);
                           y.d.t var37 = y.d.z.a(var36, var30);
                           var37 = y.d.t.b(var37, var21);
                           double var38 = var16[var20] / var17 + var34 * var15[var20];
                           var46 = var20;
                           var10001 = (var13.h() - 2) / 2;
                           if(var44) {
                              continue label70;
                           }

                           int var40 = var20 > var10001?var20 + 1 - var13.h():var20;
                           aP var41 = new aP(var40, var34, var30, var5[var27], var38);
                           y.d.n var42 = new y.d.n(var6);
                           var42.e(var37.a() + var7 * 0.5D, var37.b() + var9 * 0.5D);
                           B var43 = new B(var42, var41, var1, var28);
                           var12.add(var43);
                           ++var33;
                           if(var44) {
                              break;
                           }
                        }

                        var30.a(var29);

                        while(y.d.z.a(var30, var29).d() >= this.b || this.e == 0 || var32 >= 5) {
                           ++var27;
                           if(!var44) {
                              if(var44) {
                                 break label75;
                              }
                              continue label73;
                           }
                        }
                     }
                  }
               }
            }

            var14.g();
            ++var20;
         } while(!var44);

         return var12;
      }
   }

   public Object a(y.d.n var1, I var2, am var3, am var4) {
      if(ae.a(var1)) {
         throw new IllegalArgumentException("Invalid label bounds: " + var1);
      } else {
         D var5 = new D();
         var5.a((y.d.n)var1);
         y.c.D var6 = this.a((C)var5, var2, var3, var4);
         if(var6.isEmpty()) {
            return this.c();
         } else {
            Q var7 = aW.a(var6, var1.k());
            return var7 != null?var7.b():this.c();
         }
      }
   }

   public y.d.z a(double var1, double var3, double var5, double var7, byte var9) {
      if(var9 == 0) {
         return new y.d.z(0.0D, 0.0D);
      } else {
         double var10 = Math.abs(var1);
         double var12 = Math.abs(var3);
         double var14 = var3 / var1;
         if(Double.isNaN(var14)) {
            var14 = 1.0D;
         }

         var5 = Math.max(0.01D, var5);
         var7 = Math.max(0.01D, var7);
         double var16 = var7 / var5;
         double var26 = var5 * 0.5D;
         double var28 = var7 * 0.5D;
         double var30;
         if(var12 < var10 * var16) {
            var30 = var28 + Math.abs(var26 * var14);
            return a(var9, var1, var3)?new y.d.z(0.0D, -var30):new y.d.z(0.0D, var30);
         } else {
            var30 = var26 + Math.abs(var28 / var14);
            return b(var9, var1, var3)?new y.d.z(-var30, 0.0D):new y.d.z(var30, 0.0D);
         }
      }
   }

   private static byte[] a(byte var0) {
      if(var0 == 0) {
         return new byte[]{(byte)0};
      } else if(var0 == 1) {
         return new byte[]{(byte)3, (byte)4};
      } else {
         throw new IllegalArgumentException("Unknown model mode " + var0);
      }
   }

   private double[] a(double var1, double var3, double var5, double var7) {
      int var9;
      boolean var14;
      label29: {
         var14 = X.j;
         var1 = Math.abs(var1);
         var3 = Math.abs(var3);
         var5 = Math.max(0.01D, var5);
         if(var3 < var1 * var7 / var5) {
            var9 = Math.max(2, (int)Math.floor(var1 / var5));
            if(!var14) {
               break label29;
            }
         }

         var9 = Math.max(2, (int)Math.floor(var3 / var7));
      }

      var9 = (int)((double)var9 + (this.c - 1.0D) * (double)(var9 - 1));
      var9 = Math.min(var9, 20);
      var9 = Math.max(3, var9);
      if(var9 % 2 == 0) {
         ++var9;
      }

      double var10 = 1.0D / (double)(var9 - 1);
      double[] var12 = new double[var9];
      int var13 = var9 - 2;

      while(true) {
         if(var13 > 0) {
            var12[var13] = var10 * (double)var13;
            --var13;
            if(var14) {
               break;
            }

            if(!var14) {
               continue;
            }
         }

         var12[var9 - 1] = 1.0D;
         break;
      }

      return var12;
   }

   private y.d.t a(double var1, y.d.t var3, y.d.t var4, y.d.q var5, byte var6) {
      boolean var41 = X.j;
      double var7 = var4.a() - var3.a();
      double var9 = var4.b() - var3.b();
      double var11 = Math.max(1.0E-7D, Math.abs(var7));
      double var13 = Math.abs(var9);
      double var15 = var9 / var7;
      if(Double.isNaN(var15)) {
         var15 = 1.0D;
      }

      double var33;
      double var35;
      double var37;
      double var39;
      double var25;
      double var27;
      double var29;
      double var31;
      label56: {
         double var17 = Math.max(0.01D, var5.a());
         double var19 = Math.max(0.01D, var5.b());
         double var21 = var19 / var17;
         var33 = var17 * 0.5D;
         var35 = var19 * 0.5D;
         if(var13 < var11 * var21) {
            label49: {
               if(var7 > 0.0D) {
                  var25 = 1.0D + var33;
                  if(!var41) {
                     break label49;
                  }
               }

               var25 = -(1.0D + var33);
            }

            var29 = var7 - var25;
            var27 = var15 * var25;
            var31 = var9 - var27;
            if(var6 == 0) {
               break label56;
            }

            var37 = var35 + Math.abs(var33 * var15);
            if(a(var6, var7, var9)) {
               var27 -= var37;
               var31 -= var37;
               if(!var41) {
                  break label56;
               }
            }

            var27 += var37;
            var31 += var37;
            if(!var41) {
               break label56;
            }
         }

         label37: {
            var37 = 1.0D / var15;
            if(var9 > 0.0D) {
               var27 = 1.0D + var35;
               if(!var41) {
                  break label37;
               }
            }

            var27 = -(1.0D + var35);
         }

         var31 = var9 - var27;
         var25 = var27 / var15;
         var29 = var7 - var25;
         if(var6 != 0) {
            label32: {
               var39 = var33 + Math.abs(var35 * var37);
               if(b(var6, var7, var9)) {
                  var25 -= var39;
                  var29 -= var39;
                  if(!var41) {
                     break label32;
                  }
               }

               var25 += var39;
               var29 += var39;
            }
         }
      }

      var37 = var29 - var25;
      var39 = var31 - var27;
      return var37 * var7 >= 0.0D && var39 * var9 >= 0.0D?new y.d.t(var25 + var37 * var1 - var33, var27 + var39 * var1 - var35):new y.d.t((var25 + var29) * 0.5D - var33, (var27 + var31) * 0.5D - var35);
   }

   private static boolean a(byte var0, double var1, double var3) {
      return var0 == 2?true:(var0 == 1?false:(var1 > 0.0D && var0 == 3?true:var1 < 0.0D && var0 == 4));
   }

   private static boolean b(byte var0, double var1, double var3) {
      return var0 == 2?true:(var0 == 1?false:(var3 > 0.0D && var0 == 4?true:var3 < 0.0D && var0 == 3));
   }

   private double a(y.d.v var1, double[] var2, double[] var3) {
      boolean var18 = X.j;
      y.d.t var4 = null;
      y.d.t var5 = null;
      y.d.u var6 = var1.b();
      if(!var6.f()) {
         return 0.0D;
      } else {
         double var7 = 0.0D;
         var4 = var6.a();
         var6.g();

         double var9;
         while(true) {
            if(var6.f()) {
               var5 = var4;
               var4 = var6.a();
               var9 = var5.a() - var4.a();
               double var11 = var5.b() - var4.b();
               var7 += Math.sqrt(var9 * var9 + var11 * var11);
               var6.g();
               if(var18) {
                  break;
               }

               if(!var18) {
                  continue;
               }
            }

            var6 = var1.b();
            var4 = var6.a();
            var6.g();
            var9 = 0.0D;
            break;
         }

         int var19 = 0;

         double var10000;
         while(true) {
            if(var6.f()) {
               var5 = var4;
               var4 = var6.a();
               double var12 = var5.a() - var4.a();
               double var14 = var5.b() - var4.b();
               double var16 = Math.sqrt(var12 * var12 + var14 * var14);
               var3[var19] = var9;
               var2[var19] = var16 / var7;
               var10000 = var9 + var16;
               if(var18) {
                  break;
               }

               var9 = var10000;
               ++var19;
               var6.g();
               if(!var18) {
                  continue;
               }
            }

            var10000 = var7;
            break;
         }

         return var10000;
      }
   }
}
