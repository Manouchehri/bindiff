package y.f.k;

import y.f.am;
import y.f.k.l;
import y.f.k.n;

class T {
   private l a;
   private am b;
   private double c;
   private double d;
   private double e;
   private double f;

   T(l var1, am var2) {
      this.a = var1;
      this.b = var2;
      n var3 = n.a(var2.getWidth(), var2.getHeight());
      n var4 = var3.a(var1);
      this.c = var4.a(0);
      this.d = var4.a(1);
      n var5 = n.a(var2.getX(), var2.getY());
      n var6 = var5.a(var1);
      this.e = var6.a(0);
      this.f = var6.a(1);
      if(this.c < 0.0D) {
         this.e += this.c;
         this.c = -this.c;
      }

      if(this.d < 0.0D) {
         this.f += this.d;
         this.d = -this.d;
      }

   }

   public double a() {
      return this.d;
   }

   public double b() {
      return this.c;
   }

   public double c() {
      return this.e;
   }

   public double d() {
      return this.f;
   }

   public double e() {
      return this.e + this.c / 2.0D;
   }
}
