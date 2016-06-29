package y.f.c.a;

import y.f.c.a.cs;

class cy {
   public final Object a;
   public final double b;
   public final double c;
   public double d;
   final double e;
   double f;
   double g;
   double h;
   double i;
   double j;
   public double k;
   public double l;
   public byte m;
   public final boolean n;
   public double o;
   public double p;
   public double q;
   int r;

   private cy(Object var1, double var2, double var4, double var6, byte var8, double var9, double var11, double var13, double var15, boolean var17, double var18, double var20, double var22) {
      this.i = -1.7976931348623157E308D;
      this.j = Double.MAX_VALUE;
      this.o = 20.0D;
      this.r = -1;
      this.h = Math.max(var13, var15);
      this.f = var13;
      this.g = var15;
      this.k = var9;
      this.l = var11;
      this.e = var2 * 0.5D;
      this.a = var1;
      this.d = Double.NaN;
      this.m = var8;
      this.b = var4;
      this.c = var6;
      this.n = var17;
      this.o = var18;
      this.p = var20;
      this.q = var22;
   }

   public byte a() {
      return this.m;
   }

   static cy a(Object var0, double var1, double var3, boolean var5, double var6, boolean var8, double var9, double var11) {
      return a(var0, var1, var3, var5, var6, var8, -1.7976931348623157E308D, Double.MAX_VALUE, var9, var11);
   }

   static cy a(Object var0, double var1, double var3, boolean var5, double var6, boolean var8, double var9, double var11, double var13, double var15) {
      return a(var0, var1, var3, var5, var6, var8, var9, var11, var13, var15, false, 0.0D);
   }

   static cy a(Object var0, double var1, double var3, boolean var5, double var6, boolean var8, double var9, double var11, boolean var13, double var14) {
      return a(var0, var1, var3, var5, var6, var8, -1.7976931348623157E308D, Double.MAX_VALUE, var9, var11, var13, var14);
   }

   static cy a(Object var0, double var1, double var3, boolean var5, double var6, boolean var8, double var9, double var11, double var13, double var15, boolean var17, double var18) {
      return var3 > var6?new cy(var0, var1, var6, var3, (byte)(var8?(var5?0:2):(var5?1:3)), var9, var11, var13, var15, var17, var18, var6, var3):new cy(var0, var1, var3, var6, (byte)(var5?(var8?0:2):(var8?1:3)), var9, var11, var13, var15, var17, var18, var3, var6);
   }

   cy(Object var1, double var2, double var4, double var6, byte var8, double var9, double var11, double var13, double var15, boolean var17, double var18, double var20, double var22, cs var24) {
      this(var1, var2, var4, var6, var8, var9, var11, var13, var15, var17, var18, var20, var22);
   }
}
