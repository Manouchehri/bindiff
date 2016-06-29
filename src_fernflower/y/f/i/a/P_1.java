package y.f.i.a;

import y.f.i.a.M;

public class P {
   private final M a;
   private final double b;
   private final boolean c;

   P(double var1, double var3, double var5, double var7) {
      if(Math.abs(var3 - var7) < 1.0E-6D && Math.abs(var1 - var5) < 1.0E-6D) {
         throw new IllegalStateException("Not able to calculate the orientation.");
      } else {
         this.c = Math.abs(var1 - var5) < 1.0E-6D;
         this.a = this.c?new M(var3, var7):new M(var1, var5);
         this.b = this.c?var1:var3;
      }
   }

   public P(double var1, double var3, double var5, boolean var7) {
      this(new M(var1, var3), var5, var7);
   }

   public P(M var1, double var2, boolean var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("range must not be null");
      } else {
         this.a = var1;
         this.b = var2;
         this.c = var4;
      }
   }

   public boolean a() {
      return this.c;
   }

   public double b() {
      return this.a.a();
   }

   public double c() {
      return this.a.b();
   }

   public double d() {
      return this.a.b() - this.a.a();
   }

   public M e() {
      return this.a;
   }

   public double f() {
      return this.b;
   }

   public double a(P var1) {
      return this.c != var1.c?this.e().b(var1.f()) + var1.e().b(this.f()):this.e().b(var1.e()) + Math.abs(this.f() - var1.f());
   }

   public boolean b(P var1) {
      return this.a(var1, 0.0D);
   }

   public boolean a(P var1, double var2) {
      if(this.c != var1.c) {
         throw new IllegalArgumentException("orthogonal intervals have different orientation");
      } else {
         return this.a.a(var1.a, var2);
      }
   }

   public boolean c(P var1) {
      if(this.c != var1.c) {
         throw new IllegalArgumentException("orthogonal intervals have different orientation");
      } else {
         return this.a.c(var1.a);
      }
   }

   public boolean d(P var1) {
      if(this.c != var1.c) {
         throw new IllegalArgumentException("orthogonal intervals have different orientation");
      } else {
         return this.a.d(var1.a);
      }
   }

   public static P a(P var0, P var1) {
      if(var0.c != var1.c) {
         throw new IllegalArgumentException("orthogonal intervals have different orientation");
      } else {
         M var2 = M.a(var0.a, var1.a);
         return var2 != null?new P(var2.a(), var2.b(), var1.b, var1.a()):null;
      }
   }

   public String toString() {
      return "OrthogonalInterval{range=" + this.a + ", location=" + this.b + ", isVertical=" + this.c + '}';
   }

   private double g() {
      return this.c?this.c():this.b;
   }

   private double h() {
      return this.c?this.b:this.c();
   }

   private double i() {
      return this.c?this.b():this.b;
   }

   private double j() {
      return this.c?this.b:this.b();
   }

   static boolean a(y.d.y var0, P var1) {
      double var2 = var1.j();
      double var4 = var1.i();
      double var6 = var1.h();
      double var8 = var1.g();
      return var0.a(var2, var4) || var0.a(var6, var8);
   }
}
