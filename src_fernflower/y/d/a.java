package y.d;

import y.d.t;
import y.d.z;

public class a {
   private double a;
   private double b;
   private double c;

   public a(t var1, z var2) {
      this(var1, z.a(var1, var2));
   }

   public a(t var1, t var2) {
      if(a(var1.a(), var2.a())) {
         this.a = 1.0D;
         this.b = 0.0D;
         this.c = -var1.a();
      } else {
         this.b = -1.0D;
         double var3 = (var2.b() - var1.b()) / (var2.a() - var1.a());
         double var5 = var1.b() - var1.a() * var3;
         this.a = var3;
         this.c = var5;
      }
   }

   public double a() {
      return this.a;
   }

   public double b() {
      return this.b;
   }

   public double c() {
      return this.c;
   }

   public String toString() {
      return "a: " + this.a + " b: " + this.b + " c: " + this.c;
   }

   public static t a(a var0, a var1) {
      if(a(var0.a()) && a(var1.a())) {
         return null;
      } else if(a(var0.b()) && a(var1.b())) {
         return null;
      } else {
         if(a(var1.b())) {
            a var16 = var0;
            var0 = var1;
            var1 = var16;
         }

         double var6 = var0.a();
         double var8 = var0.b();
         double var10 = -var0.c();
         double var2;
         double var4;
         if(!a(var6)) {
            double var12 = var1.b() - var1.a() / var6 * var8;
            double var14 = -var1.c() - var1.a() / var6 * var10;
            var4 = var14 / var12;
            var2 = (var10 - var4 * var8) / var6;
            return new t(var2, var4);
         } else {
            var4 = var10 / var8;
            var2 = (var1.c() + var1.b() * var4) / -var1.a();
            return new t(var2, var4);
         }
      }
   }

   private static boolean a(double var0) {
      return a(var0, 0.0D);
   }

   private static boolean a(double var0, double var2) {
      return Math.abs(var0 - var2) < 1.0E-5D;
   }
}
