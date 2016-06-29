package y.f.c.a;

import java.util.Comparator;

public class bK implements Comparable, y.g.g {
   private Object a;
   private Comparator b;
   private double c;
   private double d;
   private double e;
   private double f;
   private int g = -1;
   private double h;
   private double i;
   private boolean j = true;

   public bK(Comparable var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.a = var1;
         this.b = null;
      }
   }

   public boolean a() {
      return this.j;
   }

   public void a(boolean var1) {
      this.j = var1;
   }

   public void a(Object var1) {
      if(this.d() == null && !(var1 instanceof Comparable)) {
         throw new IllegalArgumentException("Object must be Comparable if no comparator is set!");
      } else {
         this.a = var1;
      }
   }

   public Object b() {
      return this.a;
   }

   public void a(double var1) {
      if(var1 >= 0.0D && var1 <= 1.0D) {
         this.i = var1;
      } else {
         throw new IllegalArgumentException();
      }
   }

   public double c() {
      return this.i;
   }

   public Comparator d() {
      return this.b;
   }

   public double e() {
      return this.c;
   }

   public void b(double var1) {
      if(var1 < 0.0D) {
         throw new IllegalArgumentException();
      } else {
         this.c = var1;
      }
   }

   public double f() {
      return this.d;
   }

   public double g() {
      return this.e;
   }

   public void c(double var1) {
      if(var1 < 0.0D) {
         throw new IllegalArgumentException();
      } else {
         this.d = var1;
      }
   }

   public void d(double var1) {
      if(var1 < 0.0D) {
         throw new IllegalArgumentException();
      } else {
         this.e = var1;
      }
   }

   void e(double var1) {
      this.h = var1;
   }

   public double h() {
      return this.h;
   }

   void f(double var1) {
      this.f = var1;
   }

   public double i() {
      return this.f;
   }

   void a(int var1) {
      this.g = var1;
   }

   public int j() {
      return this.g;
   }

   public int compareTo(Object var1) {
      bK var2 = (bK)var1;
      Comparator var3 = this.d();
      return var3 == null?((Comparable)this.b()).compareTo(var2.b()):var3.compare(this.b(), var2.b());
   }
}
