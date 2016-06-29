package y.f.k;

import y.f.k.A;
import y.f.k.E;
import y.f.k.P;
import y.f.k.T;
import y.f.k.l;
import y.f.k.x;

class F {
   private int a;
   private E b;
   private y.c.y c = new y.c.y();
   private double d;
   private double e;
   private double f;
   private double g;

   F(int var1, E var2) {
      this.b = var2;
      this.a = var1;
   }

   void a(y.c.q var1, P var2, l var3) {
      this.c.add(var1);
      T var4 = new T(var3.a(), this.b.a().a((Object)var1));
      double var5 = var4.d() + var4.a() * this.g;
      double var7 = var5 - var2.g();
      double var9 = var2.d() - var5;
      if(var7 > this.e) {
         this.e = var7;
      }

      if(var9 > this.f) {
         this.f = var9;
      }

   }

   void a(y.c.q var1, x var2, l var3, double var4, double var6) {
      A var8 = var2.f(var1);
      P var9 = new P(var3, var8);
      T var10 = new T(var3.a(), this.b.a().a((Object)var1));
      double var11 = var10.d() + var10.a() * this.g;
      double var13 = var11 - var9.g() + var4;
      double var15 = var9.d() - var11 + var6;
      if(var13 > this.e) {
         this.e = var13;
      }

      if(var15 > this.f) {
         this.f = var15;
      }

   }

   public double a() {
      return this.f;
   }

   public double b() {
      return this.e;
   }

   int c() {
      return this.a;
   }

   E d() {
      return this.b;
   }

   F e() {
      return E.a(this.d(), this.a + 1);
   }

   public void a(double var1) {
      this.d = var1;
   }

   public void b(double var1) {
      this.g = var1;
   }
}
