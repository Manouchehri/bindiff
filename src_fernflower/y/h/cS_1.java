package y.h;

import y.h.az;
import y.h.cQ;
import y.h.cT;
import y.h.ch;
import y.h.gW;

class cS implements y.b.d {
   double a;
   double b;
   ch c;
   boolean d;
   cT e;
   az f;
   private final cQ g;

   cS(cQ var1, ch var2, boolean var3) {
      this.g = var1;
      this.e = new cT(this);
      this.c = var2;
      this.d = var3;
   }

   public void calcFrame(double var1) {
      if(var1 > 0.0D) {
         var1 = 1.0D - 1.0D / ((1.0D + var1) * (1.0D + var1) * (1.0D + var1) * (1.0D + var1));
      }

      double var3 = this.d?50.0D + 50.0D * (1.0D - var1):50.0D + 50.0D * var1;
      this.e.setFrame(this.a - 0.5D * var3, this.b - 0.5D * var3, var3, var3);
      this.e.a = var1;
   }

   public void disposeAnimation() {
      this.c.removeDrawable(this.f);
      cQ.access$202(this.g, (cS)null);
   }

   public void initAnimation() {
      this.f = new gW(this.c, this.e);
      this.c.addDrawable(this.f);
   }

   public long preferredDuration() {
      return 500L;
   }

   static cQ a(cS var0) {
      return var0.g;
   }
}
