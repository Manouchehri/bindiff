package y.a;

import y.a.ag;

class aj {
   private final y.c.i a;
   private final y.c.A b;
   private final int c;
   private final double d;

   static aj a(y.c.i var0, y.c.A var1, int var2, double var3) {
      y.c.A var5 = y.g.M.a(new int[var0.e()]);
      ag.a(var0.o(), (y.c.c)var1, (y.c.a)var5);
      return new aj(var0, var5, var2, var3);
   }

   private aj(y.c.i var1, y.c.A var2, int var3, double var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   y.c.A a() {
      return this.b;
   }

   int b() {
      return this.c;
   }

   double c() {
      return this.d;
   }
}
