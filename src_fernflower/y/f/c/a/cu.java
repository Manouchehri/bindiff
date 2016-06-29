package y.f.c.a;

import y.f.c.a.cw;

class cu implements Comparable {
   private double a;
   private byte b;
   private cw c;

   cu(double var1, byte var3, cw var4) {
      this.a = var1;
      this.b = var3;
      this.c = var4;
   }

   boolean a() {
      return this.b == 0;
   }

   public int compareTo(Object var1) {
      cu var2 = (cu)var1;
      return this.a < var2.a?-1:(this.a > var2.a?1:0);
   }

   static double a(cu var0) {
      return var0.a;
   }

   static cw b(cu var0) {
      return var0.c;
   }
}
