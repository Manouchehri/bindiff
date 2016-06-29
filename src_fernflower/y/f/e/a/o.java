package y.f.e.a;

import y.f.e.a.af;
import y.f.e.a.aw;
import y.f.e.a.l;
import y.f.e.a.w;

public class o implements aw {
   protected double a;
   protected double b;
   protected int c;
   protected long d;
   private double e;

   public o() {
      this(0.03D, 0.02D);
      this.d = 30000L;
   }

   public o(double var1, double var3) {
      this.c = Integer.MAX_VALUE;
      this.d = 30000L;
      this.a = var1;
      this.b = var3;
   }

   public void a(double var1) {
      this.a = var1;
   }

   public void b(double var1) {
      this.b = var1;
   }

   public void a(long var1) {
      if(var1 == 0L) {
         this.d = Long.MAX_VALUE;
         if(!af.b) {
            return;
         }
      }

      this.d = var1;
   }

   public double a(l var1) {
      if(this.b(var1)) {
         return 1.0D;
      } else {
         if(var1.c() < 1) {
            this.e = 0.0D;
         }

         double var2 = 1.0D - this.a;
         w var4 = var1.b();
         double var5 = (1.0D - var4.c()) / var2;
         double var7 = 1.0D - (this.a + this.b);
         double var9 = (1.0D - (var4.c() + var4.d())) / var7;
         double var11 = 1.0D - this.b;
         double var13 = (1.0D - var4.d()) / var11;
         double var15 = var5 * 0.4D + var9 * 0.5D + var13 * 0.1D;
         var15 *= var15;
         double var17 = 0.0D;
         if(this.c > 0 && this.c < Integer.MAX_VALUE) {
            var17 = (double)var1.c() / (double)this.c;
         }

         double var19 = Math.max(var15, var17);
         double var21 = 0.0D;
         if(this.d > 0L && this.d < Long.MAX_VALUE) {
            var21 = (double)var1.e() / (double)this.d;
         }

         var19 = Math.max(var19, var21);
         this.e = this.e * 0.6D + var19 * 0.4D;
         var19 = this.e;
         if(var19 < 0.0D) {
            var19 = 0.0D;
         }

         if(var19 > 1.0D) {
            var19 = 0.9999999D;
         }

         return var19;
      }
   }

   public boolean b(l var1) {
      return var1.b().f().e() < 2 || var1.e() > this.d || var1.c() >= this.c || var1.b().c() < this.a && var1.b().d() < this.b;
   }
}
