package y.h;

import y.h.fC;
import y.h.fj;

final class fB {
   final fC a;
   final double b;
   final double c;
   private double d;
   private boolean e;

   fB(fC var1, double var2, double var4) {
      this.a = var1;
      this.b = var2;
      this.d = var4;
      this.c = var4 - var2;
   }

   double a() {
      return this.d;
   }

   double a(double var1) {
      double var3;
      if(var1 < 0.0D && this.c > 0.0D || var1 > 0.0D && this.c < 0.0D) {
         var3 = this.b;
         if(!fj.z) {
            return var3;
         }
      }

      var3 = this.b + var1;
      return var3;
   }

   void b(double var1) {
      double var3 = this.a(var1);
      if(this.e) {
         if(this.d == var3) {
            return;
         }

         this.a.b();
         if(!fj.z) {
            return;
         }
      }

      this.d = var3;
      this.e = true;
   }
}
