package y.f.i;

import y.f.i.v;

class U {
   private final Object b;
   private final double c;
   private final double d;
   private double e;
   final double a;
   private final double f;
   private double g;
   private double h;
   private final byte i;
   private boolean j;

   private U(Object var1, double var2, double var4, double var6, double var8, byte var10, double var11, double var13) {
      int var15 = v.f;
      super();
      this.b(var11);
      this.c(var13);
      this.a = var2 * 0.5D;
      this.f = var4;
      this.b = var1;
      this.a(Double.NaN);
      this.i = var10;
      this.c = var6;
      this.d = var8;
      switch(var10) {
      case 0:
      case 3:
         this.b(false);
         if(var15 == 0) {
            break;
         }
      case 1:
      case 2:
         this.b(true);
         if(var15 == 0) {
            break;
         }
      default:
         this.b(true);
      }

   }

   public byte a() {
      return this.i;
   }

   static U a(Object var0, double var1, double var3, double var5, boolean var7, double var8, boolean var10) {
      return a(var0, var1, var3, var5, var7, var8, var10, -1.7976931348623157E308D, Double.MAX_VALUE);
   }

   static U a(Object var0, double var1, double var3, double var5, boolean var7, double var8, boolean var10, double var11, double var13) {
      return var5 > var8?new U(var0, var1, var3, var8, var5, (byte)(var10?(var7?0:2):(var7?1:3)), var11, var13):new U(var0, var1, var3, var5, var8, (byte)(var7?(var10?0:2):(var10?1:3)), var11, var13);
   }

   public void a(boolean var1) {
      this.b(var1);
   }

   public boolean b() {
      return this.j;
   }

   public Object c() {
      return this.b;
   }

   public double d() {
      return this.e;
   }

   public void a(double var1) {
      this.e = var1;
   }

   public double e() {
      return this.g;
   }

   public void b(double var1) {
      this.g = var1;
   }

   public double f() {
      return this.h;
   }

   public void c(double var1) {
      this.h = var1;
   }

   public void b(boolean var1) {
      this.j = var1;
   }

   static byte a(U var0) {
      return var0.i;
   }

   static double b(U var0) {
      return var0.d;
   }

   static double c(U var0) {
      return var0.c;
   }

   static double d(U var0) {
      return var0.e;
   }

   static double e(U var0) {
      return var0.f;
   }
}
