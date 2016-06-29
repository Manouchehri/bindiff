package y.d;

import y.d.t;

public class z {
   private double a;
   private double b;

   public z(double var1, double var3) {
      this.a = var1;
      this.b = var3;
   }

   public z(z var1) {
      this.a = var1.a();
      this.b = var1.b();
   }

   public z(t var1, t var2) {
      this.a = var1.a() - var2.a();
      this.b = var1.b() - var2.b();
   }

   public z(t var1) {
      this.a = var1.a();
      this.b = var1.b();
   }

   public z(double var1, double var3, double var5, double var7) {
      this.a = var1 - var5;
      this.b = var3 - var7;
   }

   public double a() {
      return this.a;
   }

   public double b() {
      return this.b;
   }

   public void c() {
      if(this.a != 0.0D || this.b != 0.0D) {
         double var1 = this.d();
         this.a /= var1;
         this.b /= var1;
      }
   }

   public z a(double var1) {
      double var3 = Math.cos(var1) * this.a - Math.sin(var1) * this.b;
      double var5 = Math.sin(var1) * this.a + Math.cos(var1) * this.b;
      return new z(var3, var5);
   }

   public void a(z var1) {
      this.a += var1.a();
      this.b += var1.b();
   }

   public static z a(z var0, z var1) {
      z var2 = new z(var0);
      var2.a(var1);
      return var2;
   }

   public static t a(t var0, z var1) {
      return new t(var0.a() + var1.a(), var0.b() + var1.b());
   }

   public void b(double var1) {
      this.a *= var1;
      this.b *= var1;
   }

   public double d() {
      return Math.sqrt(this.a * this.a + this.b * this.b);
   }

   public static boolean b(z var0, z var1) {
      return var0.a() * var1.b() - var0.b() * var1.a() > 0.0D;
   }

   public static z b(z var0) {
      z var1 = new z(var0.a(), var0.b());
      var1.c();
      return var1;
   }

   public static z c(z var0) {
      double var1 = var0.d();
      return new z(-var0.b() / var1, var0.a() / var1);
   }

   public static double c(z var0, z var1) {
      return var0.a() * var1.a() + var0.b() * var1.b();
   }

   public static double d(z var0, z var1) {
      double var4;
      label24: {
         boolean var6 = t.d;
         double var2 = c(var0, var1) / (var0.d() * var1.d());
         if(var2 > 1.0D) {
            var4 = Math.acos(1.0D);
            if(!var6) {
               break label24;
            }
         }

         if(var2 < -1.0D) {
            var4 = Math.acos(-1.0D);
            if(!var6) {
               break label24;
            }
         }

         var4 = Math.acos(Math.min(1.0D, var2));
      }

      if(!b(var0, var1)) {
         var4 = 6.283185307179586D - var4;
      }

      return var4;
   }

   public String toString() {
      return "X: " + this.a() + " Y: " + this.b();
   }
}
