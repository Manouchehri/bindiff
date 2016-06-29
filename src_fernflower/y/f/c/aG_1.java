package y.f.c;

import java.util.Comparator;

class aG implements Comparator {
   protected y.c.A a;
   protected byte b;

   public aG(y.c.A var1, byte var2) {
      this.a = var1;
      this.b = var2;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3;
      y.c.d var4;
      y.f.X var5;
      double var6;
      y.c.q var7;
      double var8;
      double var9;
      double var11;
      int var13;
      int var14;
      double var15;
      double var17;
      y.c.q var19;
      int var20;
      switch(this.b) {
      case 0:
         var3 = (y.c.d)var1;
         var4 = (y.c.d)var2;
         var5 = (y.f.X)var3.a();
         var19 = var3.d();
         var7 = var4.d();
         var20 = y.g.e.a(this.a.c(var19), this.a.c(var7));
         if(var20 == 0) {
            var9 = b(y.f.aE.e(var5, var3), var5.o(var3));
            var11 = b(y.f.aE.e(var5, var4), var5.o(var4));
            var13 = y.g.e.a(var9, var11);
            if(var13 == 0) {
               var14 = y.g.e.a(this.a.c(var3.c()), this.a.c(var4.c()));
               if(var14 == 0) {
                  var15 = a(y.f.aE.d(var5, var3), var5.n(var3));
                  var17 = a(y.f.aE.d(var5, var4), var5.n(var4));
                  return y.g.e.a(var15, var17);
               }

               return var14;
            }

            return var13;
         }

         return var20;
      case 1:
         var3 = (y.c.d)var1;
         var4 = (y.c.d)var2;
         var5 = (y.f.X)var3.a();
         var19 = var3.c();
         var7 = var4.c();
         var20 = y.g.e.a(this.a.c(var19), this.a.c(var7));
         if(var20 == 0) {
            var9 = a(y.f.aE.d(var5, var3), var5.n(var3));
            var11 = a(y.f.aE.d(var5, var4), var5.n(var4));
            var13 = y.g.e.a(var9, var11);
            if(var13 == 0) {
               var14 = y.g.e.a(this.a.c(var3.d()), this.a.c(var4.d()));
               if(var14 == 0) {
                  var15 = b(y.f.aE.e(var5, var3), var5.o(var3));
                  var17 = b(y.f.aE.e(var5, var4), var5.o(var4));
                  return y.g.e.a(var15, var17);
               }

               return var14;
            }

            return var13;
         }

         return var20;
      case 2:
         return y.g.e.a(this.a.c(var1), this.a.c(var2));
      case 3:
         var3 = (y.c.d)var1;
         var4 = (y.c.d)var2;
         var5 = (y.f.X)var3.a();
         var6 = a(y.f.aE.d(var5, var3), var5.n(var3));
         var8 = a(y.f.aE.d(var5, var4), var5.n(var4));
         return y.g.e.a(var6, var8);
      case 4:
         var3 = (y.c.d)var1;
         var4 = (y.c.d)var2;
         var5 = (y.f.X)var3.a();
         var6 = b(y.f.aE.e(var5, var3), var5.o(var3));
         var8 = b(y.f.aE.e(var5, var4), var5.o(var4));
         return y.g.e.a(var6, var8);
      default:
         throw new IllegalStateException("Unknown mode " + this.b);
      }
   }

   public static double a(y.f.aE var0, y.d.t var1) {
      if(var0 == null) {
         return 0.0D;
      } else {
         double var2 = var1.a;
         double var4 = var1.b;
         return var0.e()?0.1D - var4 / 10000.0D:(var0.f()?-0.1D + var4 / 10000.0D:(var0.c()?-0.3D - var2 / 10000.0D:var2 / 10000.0D));
      }
   }

   public static double b(y.f.aE var0, y.d.t var1) {
      if(var0 == null) {
         return 0.0D;
      } else {
         double var2 = var1.a;
         double var4 = var1.b;
         return var0.e()?0.1D + var4 / 10000.0D:(var0.f()?-0.1D - var4 / 10000.0D:(var0.d()?-0.3D - var2 / 10000.0D:var2 / 10000.0D));
      }
   }

   public boolean equals(Object var1) {
      return !(var1 instanceof aG)?false:this == var1 || this.a == ((aG)var1).a && this.b == ((aG)var1).b;
   }

   public int hashCode() {
      int var1 = this.a != null?this.a.hashCode():0;
      var1 = 31 * var1 + this.b;
      return var1;
   }
}
