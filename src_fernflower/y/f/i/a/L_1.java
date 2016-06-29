package y.f.i.a;

import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.ab;

public final class L {
   private final double a;
   private final double b;
   private final double c;

   public double a() {
      return this.a;
   }

   public double b() {
      return this.b;
   }

   public double c() {
      return this.c;
   }

   boolean a(M var1, boolean var2) {
      if(var1.a() != -1.7976931348623157E308D && var1.b() != Double.MAX_VALUE) {
         int var3 = this.a(var1.a(), var2);
         double var4 = this.a(var3, var2);
         return var4 + this.c <= var1.b() + 1.0E-6D;
      } else {
         return true;
      }
   }

   int a(M var1, boolean var2, int var3) {
      int var12 = ab.a;
      if(var1.a() != -1.7976931348623157E308D && var1.b() != Double.MAX_VALUE) {
         int var4 = this.a(var1.a(), var2);
         double var5 = this.a(var4, var2);
         double var7 = var5 + this.c;
         int var9 = 0;

         int var10000;
         while(true) {
            if(var9 <= var3) {
               double var13;
               var10000 = (var13 = var7 - (var1.b() + 1.0E-6D)) == 0.0D?0:(var13 < 0.0D?-1:1);
               if(var12 != 0) {
                  break;
               }

               if(var10000 <= 0) {
                  return var9;
               }

               label26: {
                  double var10 = (var5 + var7) / 2.0D;
                  if(var10 < var1.a() - 1.0E-6D) {
                     var5 = var10;
                     if(var12 == 0) {
                        break label26;
                     }
                  }

                  var7 = var10;
               }

               ++var9;
               if(var12 == 0) {
                  continue;
               }
            }

            var10000 = -1;
            break;
         }

         return var10000;
      } else {
         return 0;
      }
   }

   boolean a(P var1) {
      return this.a(var1.e(), !var1.a());
   }

   double a(int var1, boolean var2) {
      return (double)var1 * this.c + (var2?this.a:this.b);
   }

   int a(double var1, boolean var3) {
      double var4 = var3?this.a:this.b;
      double var6 = (var1 - var4) / this.c - 1.0E-6D;
      double var8 = Math.floor(var6);
      double var10 = this.a((int)var8, var3);
      return var10 >= var1?(int)(var8 - 1.0D):(int)var8;
   }

   int b(double var1, boolean var3) {
      double var4 = var3?this.a:this.b;
      double var6 = (var1 - var4) / this.c + 1.0E-6D;
      double var8 = Math.ceil(var6);
      double var10 = this.a((int)var8, var3);
      return var10 <= var1?(int)(var8 + 1.0D):(int)var8;
   }

   M b(M var1, boolean var2) {
      int var3 = this.a(var1.a(), var2) + 1;
      int var4 = this.b(var1.b(), var2) - 1;
      return var4 >= var3?new M(this.a(var3, var2), this.a(var4, var2)):null;
   }

   double a(double var1, M var3, boolean var4) {
      return this.a(var1, var3, var4, 0);
   }

   double a(double var1, M var3, boolean var4, int var5) {
      int var16 = ab.a;
      if(this.a(var3, var4, var5) < 0) {
         return Double.POSITIVE_INFINITY;
      } else {
         double var6 = var3.c(var1);
         int var8 = this.a(var6, var4);
         double var9 = this.a(var8, var4);
         double var11 = var9 + this.c;
         int var13 = 0;

         int var10000;
         while(true) {
            if(var13 < var5) {
               double var14 = (var9 + var11) / 2.0D;
               double var18;
               var10000 = (var18 = var14 - var6) == 0.0D?0:(var18 < 0.0D?-1:1);
               if(var16 != 0) {
                  break;
               }

               label38: {
                  if(var10000 >= 0) {
                     var11 = var14;
                     if(var16 == 0) {
                        break label38;
                     }
                  }

                  var9 = var14;
               }

               ++var13;
               if(var16 == 0) {
                  continue;
               }
            }

            double var19;
            var10000 = (var19 = Math.abs(var9 - var1) - Math.abs(var11 - var1)) == 0.0D?0:(var19 < 0.0D?-1:1);
            break;
         }

         boolean var17 = var10000 <= 0;
         return (!var17 || var3.b(var9) >= 1.0E-6D) && var3.b(var11) <= 1.0E-6D?var11:var9;
      }
   }

   double a(double var1, P var3) {
      return this.a(var1, var3.e(), !var3.a());
   }

   public String toString() {
      return "Grid[(" + this.a + ";" + this.b + "); " + this.c + "]";
   }

   double b(double var1, P var3) {
      double var4 = this.a(var1, var3);
      return var4 == Double.POSITIVE_INFINITY?Double.POSITIVE_INFINITY:Math.abs(var1 - var4);
   }
}
