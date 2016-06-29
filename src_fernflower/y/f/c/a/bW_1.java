package y.f.c.a;

import y.f.c.a.bT;

class bW extends y.a.e {
   private final y.c.p[] a;
   private final int[] f;
   private final y.c.D[] g;
   private final bT h;

   bW(bT var1, y.c.p[] var2, int[] var3, y.c.D[] var4) {
      this.h = var1;
      this.a = var2;
      this.f = var3;
      this.g = var4;
   }

   protected void a(y.c.q var1, int var2) {
      y.c.p var3 = this.a[var1.d()];
      int var4 = this.f[var1.d()] - 1;
      if(var4 >= 0) {
         y.c.D var5 = this.g[var4];
         if(bT.a(this.h, var1)) {
            var5.h(var3);
            var5.a(var3);
         }
      }

   }
}
