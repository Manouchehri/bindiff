package y.d;

import y.d.m;
import y.d.o;
import y.d.q;
import y.d.r;
import y.d.t;
import y.d.y;
import y.d.z;

public class n implements o {
   private double a;
   private double b;
   private double c;
   private double d;
   private double e;
   private double f;

   public n(y var1) {
      this(var1.c, var1.d + var1.b, var1.a, var1.b);
   }

   public n(n var1) {
      this(var1.b(), var1.c(), var1.e(), var1.f());
      this.e = var1.g();
      this.f = var1.i();
   }

   public n(t var1, q var2) {
      this(var1.a, var1.b, var2.a, var2.b);
   }

   public n(t var1, q var2, z var3) {
      this(var1.a, var1.b, var2.a, var2.b, var3.a(), var3.b());
   }

   public n(double var1, double var3, double var5, double var7) {
      this.a = var1;
      this.b = var3;
      this.c = var5;
      this.d = var7;
      this.e = 0.0D;
      this.f = -1.0D;
   }

   public n(double var1, double var3, double var5, double var7, double var9, double var11) {
      this(var1, var3, var5, var7);
      this.h(var9, var11);
   }

   public t a() {
      return new t(this.a, this.b);
   }

   public void a(t var1) {
      this.a(var1.a(), var1.b());
   }

   public void a(double var1, double var3) {
      this.a = var1;
      this.b = var3;
   }

   public double b() {
      return this.a;
   }

   public double c() {
      return this.b;
   }

   public q d() {
      return new q(this.c, this.d);
   }

   public void a(q var1) {
      this.b(var1.a, var1.b);
   }

   public void b(double var1, double var3) {
      this.c = var1;
      this.d = var3;
   }

   public double e() {
      return this.c;
   }

   public double f() {
      return this.d;
   }

   public void c(double var1, double var3) {
      this.h(var1, var3);
   }

   private void h(double var1, double var3) {
      if(var1 == 0.0D) {
         if(var3 == 0.0D) {
            throw new IllegalArgumentException("Invalid up vector: (0,0).");
         }

         this.e = 0.0D;
         this.f = var3 > 0.0D?1.0D:-1.0D;
      } else if(var3 == 0.0D) {
         this.e = var1 > 0.0D?1.0D:-1.0D;
         this.f = 0.0D;
      } else {
         double var5 = Math.sqrt(var1 * var1 + var3 * var3);
         this.e = var1 / var5;
         this.f = var3 / var5;
      }

   }

   public double g() {
      return this.e;
   }

   public double i() {
      return this.f;
   }

   public double j() {
      return Math.atan2(-this.e, -this.f);
   }

   public void a(double var1) {
      this.e = -Math.sin(var1);
      this.f = -Math.cos(var1);
   }

   public void d(double var1, double var3) {
      this.a += var1;
      this.b += var3;
   }

   public t k() {
      double var1 = this.d * 0.5D;
      double var3 = this.c * 0.5D;
      double var5 = this.a + this.e * var1 - this.f * var3;
      double var7 = this.b + this.f * var1 + this.e * var3;
      return new t(var5, var7);
   }

   public void b(t var1) {
      this.e(var1.a(), var1.b());
   }

   public void e(double var1, double var3) {
      double var5 = this.d * 0.5D;
      double var7 = this.c * 0.5D;
      this.a = var1 - this.e * var5 + this.f * var7;
      this.b = var3 - this.f * var5 - this.e * var7;
   }

   public y h() {
      t[] var1 = a(this);
      double var2 = Math.min(Math.min(var1[0].a, var1[1].a), Math.min(var1[2].a, var1[3].a));
      double var4 = Math.max(Math.max(var1[0].a, var1[1].a), Math.max(var1[2].a, var1[3].a));
      double var6 = Math.min(Math.min(var1[0].b, var1[1].b), Math.min(var1[2].b, var1[3].b));
      double var8 = Math.max(Math.max(var1[0].b, var1[1].b), Math.max(var1[2].b, var1[3].b));
      return new y(var2, var6, var4 - var2, var8 - var6);
   }

   public boolean a(double var1, double var3, boolean var5) {
      return a(this, var1, var3, 0.0D, var5);
   }

   public static t[] a(n var0) {
      double var1 = var0.c;
      double var3 = var0.d;
      double var5 = var0.a;
      double var7 = var0.b;
      double var9 = var0.e;
      double var11 = var0.f;
      double var13 = var5 + var9 * var3;
      double var15 = var7 + var11 * var3;
      double var17 = var5 + var9 * var3 - var11 * var1;
      double var19 = var7 + var11 * var3 + var9 * var1;
      double var21 = var5 - var11 * var1;
      double var23 = var7 + var9 * var1;
      return new t[]{new t(var5, var7), new t(var13, var15), new t(var17, var19), new t(var21, var23)};
   }

   private static y a(y var0, double var1) {
      return new y(var0.c - var1, var0.d - var1, var0.a + 2.0D * var1, var0.b + 2.0D * var1);
   }

   private static boolean a(y var0, double var1, double var3, double var5) {
      y var7 = var0;
      if(var5 > 0.0D) {
         var7 = a(var0, var5);
      }

      return var7.a(var1, var3);
   }

   private static boolean a(double var0, double var2, double var4, double var6, y var8, double var9) {
      y var11 = var8;
      if(var9 > 0.0D) {
         var11 = a(var8, var9);
      }

      m var12 = new m(new t(var0, var2), new t(var4, var6));
      return var12.a(var11);
   }

   public static boolean a(n var0, y var1, double var2) {
      if(var1.a >= 0.0D && var1.b >= 0.0D) {
         double var4 = var0.a;
         double var6 = var0.b;
         double var8 = var0.c;
         double var10 = var0.d;
         if(var8 >= 0.0D && var10 >= 0.0D) {
            if(a(var1, var4, var6, var2)) {
               return true;
            } else if(var0.l()) {
               y var13 = new y(var4 - var2, var6 - var10 - var2, var8 + 2.0D * var2, var10 + 2.0D * var2);
               return y.a(var1, var13);
            } else {
               t[] var12 = a(var0);
               return a(var12[0].a, var12[0].b, var12[1].a, var12[1].b, var1, var2)?true:(a(var12[1].a, var12[1].b, var12[2].a, var12[2].b, var1, var2)?true:(a(var12[2].a, var12[2].b, var12[3].a, var12[3].b, var1, var2)?true:a(var12[3].a, var12[3].b, var12[0].a, var12[0].b, var1, var2)));
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private boolean l() {
      return this.e == 0.0D && this.f == -1.0D;
   }

   public static boolean a(n var0, t var1, double var2) {
      return a(var0, var1.a, var1.b, var2);
   }

   public static boolean a(n var0, double var1, double var3, double var5) {
      return a(var0, var1, var3, var5, false);
   }

   private static boolean a(n var0, double var1, double var3, double var5, boolean var7) {
      double var8 = var0.e;
      double var10 = var0.f;
      if(var0.l()) {
         return y.a(var0.a - var5, var0.b - var0.d - var5, var0.c + 2.0D * var5, var0.d + 2.0D * var5, var1, var3, var7);
      } else {
         double var12 = var0.a;
         double var14 = var0.b;
         double var16 = var0.c;
         double var18 = var0.d;
         if(var16 >= 0.0D && var18 >= 0.0D) {
            double var20 = var1 - var12;
            double var22 = var3 - var14;
            double var24 = var16 + var18 + var5;
            if(var20 >= -var24 && var20 <= var24 && var22 >= -var24 && var22 <= var24) {
               double var26 = var20 * -var10 + var22 * var8;
               double var28 = var20 * var8 + var22 * var10;
               return y.a(0.0D - var5, 0.0D - var5, var16 + 2.0D * var5, var18 + 2.0D * var5, var26, var28, var7);
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }

   public static boolean a(n var0, n var1, double var2) {
      t[] var4 = a(var1);
      return a(var0, var4[0], var2) && a(var0, var4[1], var2) && a(var0, var4[2], var2) && a(var0, var4[3], var2);
   }

   public static boolean a(n var0, m var1, double var2) {
      double var4 = var0.e;
      double var6 = var0.f;
      if(var0.l()) {
         y var34 = new y(var0.a - var2, var0.b - var0.d - var2, var0.c + 2.0D * var2, var0.d + 2.0D * var2);
         return var1.a(var34);
      } else {
         double var8 = var0.a;
         double var10 = var0.b;
         double var12 = var0.c;
         double var14 = var0.d;
         if(var12 >= 0.0D && var14 >= 0.0D) {
            double var16 = var1.c().a;
            double var18 = var1.c().b;
            double var20 = var1.d().a;
            double var22 = var1.d().b;
            var16 -= var8;
            var18 -= var10;
            var20 -= var8;
            var22 -= var10;
            double var24 = var16 * -var6 + var18 * var4;
            double var26 = var16 * var4 + var18 * var6;
            double var28 = var20 * -var6 + var22 * var4;
            double var30 = var20 * var4 + var22 * var6;
            y var32 = new y(0.0D - var2, 0.0D - var2, var12 + 2.0D * var2, var14 + 2.0D * var2);
            m var33 = new m(new t(var24, var26), new t(var28, var30));
            return var33.a(var32);
         } else {
            return false;
         }
      }
   }

   public static t b(n var0, m var1, double var2) {
      double var4 = var0.e;
      double var6 = var0.f;
      double var8 = var1.c().a;
      double var10 = var1.c().b;
      double var12 = var1.d().a;
      double var14 = var1.d().b;
      if(var0.l()) {
         y var38 = new y(var0.a - var2, var0.b - var0.d - var2, var0.c + 2.0D * var2, var0.d + 2.0D * var2);
         return a(var38, var8, var10, var12, var14);
      } else {
         double var16 = var0.a;
         double var18 = var0.b;
         double var20 = var0.c;
         double var22 = var0.d;
         if(var20 >= 0.0D && var22 >= 0.0D) {
            var8 -= var16;
            var10 -= var18;
            var12 -= var16;
            var14 -= var18;
            double var24 = var8 * -var6 + var10 * var4;
            double var26 = var8 * var4 + var10 * var6;
            double var28 = var12 * -var6 + var14 * var4;
            double var30 = var12 * var4 + var14 * var6;
            y var32 = new y(0.0D - var2, 0.0D - var2, var20 + 2.0D * var2, var22 + 2.0D * var2);
            t var33 = a(var32, var24, var26, var28, var30);
            if(var33 != null) {
               double var34 = var16 + var33.a * -var6 + var33.b * var4;
               double var36 = var18 + var33.a * var4 + var33.b * var6;
               return new t(var34, var36);
            } else {
               return null;
            }
         } else {
            return null;
         }
      }
   }

   private static boolean a(int var0, int var1) {
      return (var0 & var1) != 0;
   }

   private static boolean b(int var0, int var1) {
      return (var0 | var1) == 0;
   }

   private static boolean c(int var0, int var1) {
      return a(var0, var1) || b(var0, var1);
   }

   private static final t a(y var0, double var1, double var3, double var5, double var7) {
      boolean var24 = t.d;
      double var9 = var0.c();
      double var11 = var0.d();
      double var13 = var9 + var0.a();
      double var15 = var11 + var0.b();
      byte var17 = a(var9, var11, var13, var15, var1, var3);
      byte var18 = a(var9, var11, var13, var15, var5, var7);
      boolean var19 = false;
      boolean var20 = false;
      int var21 = 10;

      int var10000;
      while(true) {
         if(!c(var17, var18)) {
            var10000 = var21;
            if(var24) {
               break;
            }

            if(var21 > 0) {
               --var21;
               double var22;
               if(var17 != 0) {
                  label85: {
                     if((var17 & 3) != 0) {
                        var22 = (var17 & 2) != 0?var13:var9;
                        var3 += (var22 - var1) * (var7 - var3) / (var5 - var1);
                        var1 = var22;
                        if(!var24) {
                           break label85;
                        }
                     }

                     var22 = (var17 & 8) != 0?var15:var11;
                     var1 += (var22 - var3) * (var5 - var1) / (var7 - var3);
                     var3 = var22;
                  }

                  var19 = true;
                  var17 = a(var9, var11, var13, var15, var1, var3);
                  if(!var24) {
                     continue;
                  }
               }

               label86: {
                  if((var18 & 3) != 0) {
                     var22 = (var18 & 2) != 0?var13:var9;
                     var7 += (var22 - var5) * (var7 - var3) / (var5 - var1);
                     var5 = var22;
                     if(!var24) {
                        break label86;
                     }
                  }

                  var22 = (var18 & 8) != 0?var15:var11;
                  var5 += (var22 - var7) * (var5 - var1) / (var7 - var3);
                  var7 = var22;
               }

               var20 = true;
               var18 = a(var9, var11, var13, var15, var5, var7);
               if(!var24) {
                  continue;
               }
            }
         }

         var10000 = var21;
         break;
      }

      return var10000 == 0?null:(a(var17, var18)?null:(!var19 && !var20?null:(var19?new t(var1, var3):new t(var5, var7))));
   }

   private static byte a(double var0, double var2, double var4, double var6, double var8, double var10) {
      byte var12;
      boolean var13;
      label23: {
         var13 = t.d;
         var12 = 0;
         if(var8 < var0) {
            var12 = 1;
            if(!var13) {
               break label23;
            }
         }

         if(var8 > var4) {
            var12 = 2;
         }
      }

      if(var10 < var2) {
         var12 = (byte)(var12 | 4);
         if(!var13) {
            return var12;
         }
      }

      if(var10 > var6) {
         var12 = (byte)(var12 | 8);
      }

      return var12;
   }

   public String toString() {
      return this.getClass().getName() + "[anchorX=" + this.a + ";anchorY=" + this.b + ";width=" + this.c + ";height=" + this.d + ";upX=" + this.e + ";upY=" + this.f + "]";
   }

   private static int i(double var0, double var2) {
      return r.a(var0, var2);
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         n var2 = (n)var1;
         return i(var2.a, this.a) != 0?false:(i(var2.b, this.b) != 0?false:(i(var2.d, this.d) != 0?false:(i(var2.c, this.c) != 0?false:(i(var2.e, this.e) != 0?false:i(var2.f, this.f) == 0))));
      } else {
         return false;
      }
   }

   public int hashCode() {
      boolean var4 = t.d;
      int var1 = super.hashCode();
      long var2 = this.a != 0.0D?Double.doubleToLongBits(this.a):0L;
      var1 = 31 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = this.b != 0.0D?Double.doubleToLongBits(this.b):0L;
      var1 = 31 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = this.e != 0.0D?Double.doubleToLongBits(this.e):0L;
      var1 = 31 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = this.f != 0.0D?Double.doubleToLongBits(this.f):0L;
      var1 = 31 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = this.c != 0.0D?Double.doubleToLongBits(this.c):0L;
      var1 = 31 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = this.d != 0.0D?Double.doubleToLongBits(this.d):0L;
      var1 = 31 * var1 + (int)(var2 ^ var2 >>> 32);
      if(y.c.i.g) {
         t.d = !var4;
      }

      return var1;
   }

   public n f(double var1, double var3) {
      return new n(this.a + var1, this.b + var3, this.c, this.d, this.e, this.f);
   }

   public n g(double var1, double var3) {
      return new n(this.a, this.b, var1, var3, this.e, this.f);
   }
}
