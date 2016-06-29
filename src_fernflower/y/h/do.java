package y.h;

import y.h.fj;

final class do {
   final y.d.n a;
   private final y.d.n b;
   private final y.d.n c;
   private final double d;
   private final double e;

   do(y.d.n var1, y.d.n var2) {
      this.b = var1;
      this.d = var1.j();
      this.c = var2;
      double var7 = var2.j() - this.d;
      if(var7 != 0.0D) {
         boolean var9 = var7 < 0.0D;
         if(var9) {
            var7 = -var7;
         }

         if(var7 > 6.283185307179586D) {
            var7 -= 6.283185307179586D * Math.floor(var7 / 6.283185307179586D);
         }

         boolean var10 = var7 > 3.141592653589793D;
         if(var10) {
            var7 = 6.283185307179586D - var7;
         }

         if(var10 ^ var9) {
            var7 = -var7;
         }
      }

      this.e = var7;
      this.a = new y.d.n(var1);
   }

   void a(double var1, double var3) {
      boolean var6 = fj.z;
      boolean var5 = 0.0D < var3;
      if(var5 && var3 < 1.0D) {
         this.a.a(var1 * this.b.b() + var3 * this.c.b(), var1 * this.b.c() + var3 * this.c.c());
         this.a.a(this.d + var3 * this.e);
         if(!var6) {
            return;
         }
      }

      if(var5) {
         this.a.a(this.c.b(), this.c.c());
         this.a.c(this.c.g(), this.c.i());
         if(!var6) {
            return;
         }
      }

      this.a.a(this.b.b(), this.b.c());
      this.a.c(this.b.g(), this.b.i());
   }
}
