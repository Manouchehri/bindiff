package y.f.a;

class t {
   static y.d.y a(y.d.y var0, y.d.y var1) {
      if(var0 != null && var1 != null) {
         double var2 = Math.min(var0.c(), var1.c());
         double var4 = Math.max(var0.c() + var0.a(), var1.c() + var1.a());
         double var6 = Math.min(var0.d(), var1.d());
         double var8 = Math.max(var0.d() + var0.b(), var1.d() + var1.b());
         return new y.d.y(var2, var6, var4 - var2, var8 - var6);
      } else {
         return var0 == null?var1:var0;
      }
   }

   static double b(y.d.y var0, y.d.y var1) {
      if(y.d.y.a(var0, var1)) {
         return 0.0D;
      } else {
         double var2 = a(var0, var1, false);
         double var4 = a(var0, var1, true);
         return Math.sqrt(var2 * var2 + var4 * var4);
      }
   }

   private static double a(y.d.y var0, y.d.y var1, boolean var2) {
      double var3 = var2?var0.c():var0.d();
      double var5 = var2?var0.c() + var0.a():var0.d() + var0.b();
      double var7 = var2?var1.c():var1.d();
      double var9 = var2?var1.c() + var1.a():var1.d() + var1.b();
      return a(var3, var5, var7, var9);
   }

   private static double a(double var0, double var2, double var4, double var6) {
      return var6 < var0?var6 - var0:(var2 < var4?var4 - var2:0.0D);
   }
}
