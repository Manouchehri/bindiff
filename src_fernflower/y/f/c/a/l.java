package y.f.c.a;

import y.f.c.a.bk;

public class l implements Comparable {
   private bk a;
   private double b;
   private double c;
   private double d;
   private double e;
   private double f;
   private double g;
   private double h;
   private double i;
   private int j;
   private boolean k;

   l(int var1, bk var2) {
      this.j = var1;
      this.a = var2;
      this.k = true;
   }

   public int a() {
      return this.j;
   }

   void a(int var1) {
      this.j = var1;
   }

   public int compareTo(Object var1) {
      int var2 = ((l)var1).j;
      return this.j < var2?-1:(this.j == var2?0:1);
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
      return this.h;
   }

   public void e(double var1) {
      this.h = var1;
   }

   public double g() {
      return this.i;
   }

   public void f(double var1) {
      this.i = var1;
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
      return this.k;
   }

   public void a(boolean var1) {
      this.k = var1;
   }
}
