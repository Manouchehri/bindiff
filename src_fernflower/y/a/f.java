package y.a;

final class f {
   int a = -1;
   byte[] b;
   y.c.d[] c;
   int[] d;
   y.c.q[] e;

   f(int var1) {
      this.d = new int[var1];
      this.c = new y.c.d[var1];
      this.b = new byte[var1];
      this.e = new y.c.q[var1];
   }

   final boolean a() {
      return this.a < 0;
   }

   final void b() {
      --this.a;
   }

   final y.c.q c() {
      return this.e[this.a];
   }

   final y.c.d d() {
      return this.c[this.a];
   }

   final byte e() {
      return this.b[this.a];
   }

   final int f() {
      return this.d[this.a];
   }

   final int a(y.c.q var1, y.c.d var2, byte var3, int var4) {
      ++this.a;
      if(this.a == this.e.length) {
         int var5 = (this.a + 1) * 2;
         y.c.q[] var6 = new y.c.q[var5];
         System.arraycopy(this.e, 0, var6, 0, this.e.length);
         this.e = var6;
         y.c.d[] var7 = new y.c.d[var5];
         System.arraycopy(this.c, 0, var7, 0, this.c.length);
         this.c = var7;
         int[] var8 = new int[var5];
         System.arraycopy(this.d, 0, var8, 0, this.d.length);
         this.d = var8;
         byte[] var9 = new byte[var5];
         System.arraycopy(this.b, 0, var9, 0, this.b.length);
         this.b = var9;
      }

      this.e[this.a] = var1;
      this.c[this.a] = var2;
      this.b[this.a] = var3;
      return this.d[this.a] = var4;
   }

   final void a(y.c.d var1, byte var2) {
      this.c[this.a] = var1;
      this.b[this.a] = var2;
   }
}
