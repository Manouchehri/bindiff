package y.f;

import y.f.R;
import y.f.X;

public class Q implements y.d.o {
   private y.d.n a;
   private Object b;
   private R c;
   private boolean d;
   private double e;
   private double f;
   private double g;
   private boolean h;

   public Q(y.d.t var1, y.d.q var2, Object var3, R var4, boolean var5) {
      this.d = false;
      this.e = 0.0D;
      this.f = 0.0D;
      this.g = 0.0D;
      this.h = false;
      this.a = new y.d.n(var1.a, var1.b + var2.b, var2.a, var2.b);
      this.b = var3;
      this.c = var4;
      this.h = var5;
   }

   public Q(y.d.n var1, Object var2, R var3, boolean var4) {
      this.d = false;
      this.e = 0.0D;
      this.f = 0.0D;
      this.g = 0.0D;
      this.h = false;
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.h = var4;
   }

   public Q(y.d.n var1, Object var2, R var3) {
      this(var1, var2, var3, false);
   }

   public double a() {
      return this.g;
   }

   public void a(double var1) {
      if(var1 >= 0.0D && var1 <= 1.0D) {
         this.g = var1;
      } else {
         throw new IllegalArgumentException("Value does not lie in interval [0,1]");
      }
   }

   public Object b() {
      return this.b;
   }

   public y.d.t c() {
      y.d.y var1 = a(this.a);
      return var1 != null?var1.e():this.a.h().e();
   }

   public y.d.y h() {
      y.d.y var1 = a(this.a);
      return var1 != null?var1:this.a.h();
   }

   public y.d.n d() {
      return this.a;
   }

   private static y.d.y a(y.d.n var0) {
      boolean var9 = X.j;
      double var1;
      double var3;
      double var5;
      double var7;
      if(var0.g() == 0.0D && var0.i() == -1.0D) {
         var1 = var0.b();
         var3 = var0.c() - var0.f();
         var5 = var0.f();
         var7 = var0.e();
         if(!var9) {
            return new y.d.y(var1, var3, var7, var5);
         }
      }

      if(var0.g() == 0.0D && var0.i() == 1.0D) {
         var1 = var0.b() - var0.e();
         var3 = var0.c();
         var5 = var0.f();
         var7 = var0.e();
         if(!var9) {
            return new y.d.y(var1, var3, var7, var5);
         }
      }

      if(var0.g() == 1.0D && var0.i() == 0.0D) {
         var1 = var0.b();
         var3 = var0.c();
         var5 = var0.e();
         var7 = var0.f();
         if(!var9) {
            return new y.d.y(var1, var3, var7, var5);
         }
      }

      if(var0.g() != -1.0D || var0.i() != 0.0D) {
         return null;
      } else {
         var1 = var0.b() - var0.e();
         var3 = var0.c() - var0.f();
         var5 = var0.e();
         var7 = var0.f();
         if(var9) {
            return null;
         } else {
            return new y.d.y(var1, var3, var7, var5);
         }
      }
   }

   public R e() {
      return this.c;
   }

   public boolean f() {
      return this.h;
   }

   public void g() {
      this.c.setModelParameter(this.b);
      this.d = true;
   }

   public void b(double var1) {
      this.e = var1;
   }

   public void c(double var1) {
      this.f = var1;
   }

   public double i() {
      return this.e;
   }

   public double j() {
      return this.f;
   }

   public double k() {
      return this.e + this.f;
   }

   public Object l() {
      return this.b;
   }

   public String toString() {
      return "Label: " + this.c.toString() + " Location: " + this.c().toString();
   }
}
