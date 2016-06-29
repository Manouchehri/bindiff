package y.f.c;

import java.util.Comparator;

class aH implements Comparator {
   protected int[] a;
   protected byte b;

   public aH(int[] var1, byte var2) {
      this.a = var1;
      this.b = var2;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3;
      y.c.d var4;
      y.f.X var5;
      y.c.q var6;
      y.c.q var7;
      int var8;
      double var9;
      int var10;
      double var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      switch(this.b) {
      case 0:
         var3 = (y.c.d)var1;
         var4 = (y.c.d)var2;
         var5 = (y.f.X)var3.a();
         var6 = var3.d();
         var7 = var4.d();
         var8 = y.g.e.a(this.a[var6.d()], this.a[var7.d()]);
         if(var8 == 0) {
            var17 = b(y.f.aE.e(var5, var3), var5.o(var3));
            var10 = b(y.f.aE.e(var5, var4), var5.o(var4));
            var18 = y.g.e.a(var17, var10);
            if(var18 == 0) {
               var12 = y.g.e.a(this.a[var3.c().d()], this.a[var4.c().d()]);
               if(var12 == 0) {
                  var13 = a(y.f.aE.d(var5, var3), var5.n(var3));
                  var14 = a(y.f.aE.d(var5, var4), var5.n(var4));
                  return y.g.e.a(var13, var14);
               }

               return var12;
            }

            return var18;
         }

         return var8;
      case 1:
         var3 = (y.c.d)var1;
         var4 = (y.c.d)var2;
         var5 = (y.f.X)var3.a();
         var6 = var3.c();
         var7 = var4.c();
         var8 = y.g.e.a(this.a[var6.d()], this.a[var7.d()]);
         if(var8 == 0) {
            var17 = a(y.f.aE.d(var5, var3), var5.n(var3));
            var10 = a(y.f.aE.d(var5, var4), var5.n(var4));
            var18 = y.g.e.a(var17, var10);
            if(var18 == 0) {
               var12 = y.g.e.a(this.a[var3.d().d()], this.a[var4.d().d()]);
               if(var12 == 0) {
                  var13 = b(y.f.aE.e(var5, var3), var5.o(var3));
                  var14 = b(y.f.aE.e(var5, var4), var5.o(var4));
                  return y.g.e.a(var13, var14);
               }

               return var12;
            }

            return var18;
         }

         return var8;
      case 2:
         return y.g.e.a(this.a[((y.c.q)var1).d()], this.a[((y.c.q)var2).d()]);
      case 3:
         var3 = (y.c.d)var1;
         var4 = (y.c.d)var2;
         var5 = (y.f.X)var3.a();
         var15 = a(y.f.aE.d(var5, var3), var5.n(var3));
         var16 = a(y.f.aE.d(var5, var4), var5.n(var4));
         return y.g.e.a(var15, var16);
      case 4:
         var3 = (y.c.d)var1;
         var4 = (y.c.d)var2;
         var5 = (y.f.X)var3.a();
         var15 = b(y.f.aE.e(var5, var3), var5.o(var3));
         var16 = b(y.f.aE.e(var5, var4), var5.o(var4));
         return y.g.e.a(var15, var16);
      case 5:
         var3 = (y.c.d)var1;
         var4 = (y.c.d)var2;
         var5 = (y.f.X)var3.a();
         var6 = var3.d();
         var7 = var4.d();
         var8 = y.g.e.a(this.a[var6.d()], this.a[var7.d()]);
         if(var8 == 0) {
            var9 = var5.o(var3).a;
            var11 = var5.o(var4).a;
            var13 = y.g.e.a(var9, var11);
            if(var13 == 0) {
               return y.g.e.a(var5.n(var3).a, var5.n(var3).a);
            }

            return var13;
         }

         return var8;
      case 6:
         var3 = (y.c.d)var1;
         var4 = (y.c.d)var2;
         var5 = (y.f.X)var3.a();
         var6 = var3.c();
         var7 = var4.c();
         var8 = y.g.e.a(this.a[var6.d()], this.a[var7.d()]);
         if(var8 == 0) {
            var9 = var5.n(var3).a;
            var11 = var5.n(var4).a;
            var13 = y.g.e.a(var9, var11);
            if(var13 == 0) {
               return y.g.e.a(var5.o(var3).a, var5.o(var3).a);
            }

            return var13;
         }

         return var8;
      default:
         throw new IllegalStateException("Unknown mode " + this.b);
      }
   }

   public static final int a(y.f.aE var0, y.d.t var1) {
      if(var0 == null) {
         return 0;
      } else {
         int var2 = var0.a()?(int)var1.a:0;
         int var3 = var0.a()?(int)var1.b:0;
         return var0.e()?10000 - var3:(var0.f()?-10000 + var3:(var0.c()?-20000 - var2:var2));
      }
   }

   public static final int b(y.f.aE var0, y.d.t var1) {
      if(var0 == null) {
         return 0;
      } else {
         int var2 = var0.a()?(int)var1.a:0;
         int var3 = var0.a()?(int)var1.b:0;
         return var0.e()?10000 + var3:(var0.f()?-10000 - var3:(var0.d()?-20000 - var2:var2));
      }
   }

   public boolean equals(Object var1) {
      return !(var1 instanceof aH)?false:this == var1 || this.a == ((aH)var1).a && this.b == ((aH)var1).b;
   }

   public int hashCode() {
      int var1 = this.a != null?this.a.hashCode():0;
      var1 = 31 * var1 + this.b;
      return var1;
   }
}
