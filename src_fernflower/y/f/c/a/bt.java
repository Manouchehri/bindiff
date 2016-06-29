package y.f.c.a;

import y.f.c.a.bk;

public class bt implements Comparable {
   private bk a;
   private double b;
   private double c;
   private double d;
   private double e;
   private double f;
   private double g;
   private int h;
   private boolean i = true;
   private double j;
   private double k;

   bt(int var1, bk var2) {
      this.h = var1;
      this.a = var2;
   }

   public int a() {
      return this.h;
   }

   void a(int var1) {
      this.h = var1;
   }

   public int compareTo(Object var1) {
      int var2 = ((bt)var1).h;
      return this.h < var2?-1:(this.h == var2?0:1);
   }

   public double b() {
      return this.b;
   }

   public void a(double var1) {
      if(var1 < 0.0D) {
         throw new IllegalArgumentException();
      } else {
         this.b = var1;
      }
   }

   public double c() {
      return this.c;
   }

   public void b(double var1) {
      if(var1 < 0.0D) {
         throw new IllegalArgumentException();
      } else {
         this.c = var1;
      }
   }

   public double d() {
      return this.d;
   }

   public void c(double var1) {
      if(var1 < 0.0D) {
         throw new IllegalArgumentException();
      } else {
         this.d = var1;
      }
   }

   public double e() {
      return this.e;
   }

   public void d(double var1) {
      this.e = var1;
   }

   public double f() {
      return this.k;
   }

   public void e(double var1) {
      this.k = var1;
   }

   public double g() {
      return this.j;
   }

   public void f(double var1) {
      this.j = var1;
   }

   public double h() {
      return this.f;
   }

   public void g(double var1) {
      this.f = var1;
   }

   public double i() {
      return this.g;
   }

   public void h(double var1) {
      if(var1 >= 0.0D && var1 <= 1.0D) {
         this.g = var1;
      } else {
         throw new IllegalArgumentException();
      }
   }

   public boolean j() {
      return this.i;
   }

   public void a(boolean var1) {
      this.i = var1;
   }
}
