package y.d;

import y.d.o;
import y.d.t;
import y.d.y;
import y.d.z;

public class m implements o {
   private t a;
   private t b;
   private double c;
   private double d;
   private static double e = 1.0E-8D;

   public m(t var1, t var2) {
      boolean var3 = t.d;
      super();
      this.a = var1;
      this.b = var2;
      if(var2.a == var1.a) {
         if(var1.b < var2.b) {
            this.c = Double.MAX_VALUE;
            this.d = Double.NaN;
            if(!var3) {
               return;
            }
         }

         this.c = -1.7976931348623157E308D;
         this.d = Double.NaN;
         if(!var3) {
            return;
         }
      }

      this.c = (var2.b - var1.b) / (var2.a - var1.a);
      this.d = var1.b - var1.a * this.c;
   }

   public boolean a() {
      return Math.abs(this.c().a - this.d().a) < e;
   }

   public boolean b() {
      return Math.abs(this.c().b - this.d().b) < e;
   }

   public t c() {
      return this.a;
   }

   public t d() {
      return this.b;
   }

   public boolean a(double var1) {
      return this.a.b < this.b.b?var1 > this.a.b + e && var1 < this.b.b - e:var1 > this.b.b + e && var1 < this.a.b - e;
   }

   public boolean b(double var1) {
      return this.a.a < this.b.a?var1 > this.a.a + e && var1 < this.b.a - e:var1 > this.b.a + e && var1 < this.a.a - e;
   }

   public double e() {
      return this.d;
   }

   public double f() {
      return this.c;
   }

   public double g() {
      return this.i().d();
   }

   public y h() {
      double var1 = this.a.a < this.b.a?this.a.a:this.b.a;
      double var3 = this.a.a > this.b.a?this.a.a:this.b.a;
      double var5 = this.a.b < this.b.b?this.a.b:this.b.b;
      double var7 = this.a.b > this.b.b?this.a.b:this.b.b;
      return new y(var1, var5, var3 - var1, var7 - var5);
   }

   public boolean a(y var1) {
      return a(var1, this.a.a, this.a.b, this.b.a, this.b.b);
   }

   public boolean a(t var1) {
      y var2 = new y(var1.a - e, var1.b - e, 2.0D * e, 2.0D * e);
      return a(var2, this.a.a, this.a.b, this.b.a, this.b.b);
   }

   public boolean b(t var1) {
      y var4 = new y(var1.a - 0.01D, var1.b - 0.01D, 0.02D, 0.02D);
      return a(var4, this.a.a, this.a.b, this.b.a, this.b.b);
   }

   public static final boolean a(y var0, double var1, double var3, double var5, double var7) {
      boolean var21 = t.d;
      double var9 = var0.c();
      double var11 = var0.d();
      double var13 = var9 + var0.a();
      double var15 = var11 + var0.b();
      byte var17 = a(var9, var11, var13, var15, var1, var3);
      if(var17 == 0) {
         return true;
      } else {
         byte var18 = a(var9, var11, var13, var15, var5, var7);
         if(var18 == 0) {
            return true;
         } else {
            int var10000;
            while(true) {
               if(var17 != 0) {
                  var10000 = var17 & var18;
                  if(var21) {
                     break;
                  }

                  if(var10000 != 0) {
                     return false;
                  }

                  label47: {
                     double var19;
                     if((var17 & 3) != 0) {
                        var19 = var9;
                        if((var17 & 2) != 0) {
                           var19 = var13;
                        }

                        var3 += (var19 - var1) * (var7 - var3) / (var5 - var1);
                        var1 = var19;
                        if(!var21) {
                           break label47;
                        }
                     }

                     var19 = var11;
                     if((var17 & 8) != 0) {
                        var19 = var15;
                     }

                     var1 += (var19 - var3) * (var5 - var1) / (var7 - var3);
                     var3 = var19;
                  }

                  var17 = a(var9, var11, var13, var15, var1, var3);
                  if(!var21) {
                     continue;
                  }
               }

               var10000 = 1;
               break;
            }

            return (boolean)var10000;
         }
      }
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

   public static t a(m var0, m var1) {
      if(var1.a()) {
         m var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      double var4;
      double var6;
      double var8;
      if(var0.a()) {
         if(!var1.b(var0.c().a)) {
            return null;
         } else {
            var8 = var1.f();
            if(!Double.isInfinite(var8) && !Double.isNaN(var8)) {
               var4 = var1.e();
               if(!Double.isInfinite(var4) && !Double.isNaN(var4)) {
                  var6 = var1.e() + var1.f() * var0.c().a;
                  return !var0.a(var6)?null:new t(var0.c().a, var6);
               } else {
                  return null;
               }
            } else {
               return null;
            }
         }
      } else {
         var8 = var0.f();
         var4 = var1.f();
         if(var8 == var4) {
            return null;
         } else {
            var6 = (var1.e() - var0.e()) / (var8 - var4);
            return var0.b(var6) && var1.b(var6)?new t(var6, var6 * var8 + var0.e()):null;
         }
      }
   }

   public z i() {
      return new z(this.b, this.a);
   }

   public double j() {
      return this.b.a - this.a.a;
   }

   public double k() {
      return this.b.b - this.a.b;
   }

   public String toString() {
      return "SP: " + this.a.toString() + " TP: " + this.b.toString();
   }
}
