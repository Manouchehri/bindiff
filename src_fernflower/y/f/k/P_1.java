package y.f.k;

import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;
import y.f.k.A;
import y.f.k.d;
import y.f.k.l;
import y.f.k.n;

class P {
   private A a;
   private l b;
   private A c;

   protected P() {
   }

   P(l var1, A var2) {
      if(var2 == null) {
         throw new NullPointerException("originalShape was null");
      } else if(var1 == null) {
         throw new NullPointerException("modificationMatrix was null");
      } else {
         this.a = var2;
         this.b = var1;
         this.c = var2.a(var1.a());
      }
   }

   void a(double var1, double var3) {
      this.c.a(var1, var3);
   }

   y.d.c a(int var1) {
      return this.c.a(var1);
   }

   Rectangle2D a() {
      return this.c.a();
   }

   double b() {
      return this.c.b();
   }

   double c() {
      return this.c.c();
   }

   double d() {
      return this.c.h();
   }

   double e() {
      return this.c.g();
   }

   double f() {
      return this.c.e();
   }

   double g() {
      return this.c.f();
   }

   void h() {
      this.c.d();
   }

   void a(P var1) {
      this.c.a(var1.c);
      this.j();
      var1.j();
   }

   void a(double var1) {
      this.b(0.0D, var1);
   }

   void b(double var1) {
      this.b(var1, 0.0D);
   }

   void b(double var1, double var3) {
      this.c.b(var1, var3);
   }

   A i() {
      return this.a;
   }

   void j() {
      this.c.a(this.a, this.b);
   }

   n a(y.d.c var1, double var2) {
      return this.a(n.d, var1, var2, false);
   }

   private n a(n var1, y.d.c var2, double var3, boolean var5) {
      n var6 = this.b(var1, var2, var3, var5);
      this.b(var6.a(0), var6.a(1));
      return var6;
   }

   private n b(n var1, y.d.c var2, double var3, boolean var5) {
      double var6 = this.a(var1, var2) - var3;
      return var5 && var6 < 0.0D?n.e:var1.a(var6);
   }

   double a(n var1, y.d.c var2) {
      double var3;
      if(var1.a() < 0.0D) {
         var3 = var2.c(this.a(var1));
         if(d.g == 0) {
            return var3;
         }
      }

      var3 = this.a(var1).c(var2);
      return var3;
   }

   y.d.c a(n var1) {
      return var1.equals(n.a)?this.a(0):(var1.equals(n.b)?this.a(1):(var1.equals(n.c)?this.a(2):this.a(3)));
   }

   void a(List var1) {
      int var4 = d.g;
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         P var3 = (P)var2.next();
         this.a(var3);
         if(var4 != 0) {
            break;
         }
      }

   }

   l k() {
      return this.b;
   }

   double l() {
      return this.e() - this.f();
   }
}
