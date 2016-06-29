package y.f.d;

import y.f.d.o;

class p {
   private byte a;
   private boolean b;
   private double c;
   private int d;
   private int e;

   private p(byte var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   p(byte var1, boolean var2, o var3) {
      this(var1, var2);
   }

   static int a(p var0, int var1) {
      return var0.e = var1;
   }

   static double a(p var0, double var1) {
      return var0.c = var1;
   }

   static int b(p var0, int var1) {
      return var0.d = var1;
   }

   static int a(p var0) {
      return var0.e;
   }

   static byte b(p var0) {
      return var0.a;
   }

   static boolean c(p var0) {
      return var0.b;
   }

   static double d(p var0) {
      return var0.c;
   }

   static int e(p var0) {
      return var0.d;
   }
}
