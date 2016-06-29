package y.f.i.a;

import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.e;
import y.f.i.a.v;

public class f {
   private R c;
   private f d;
   private P e;
   private y.f.y f;
   private boolean g;
   private double h;
   y.c.D a;
   e b;
   private boolean i;
   private boolean j;
   private v k;
   private P l;

   public f(R var1) {
      this.c = var1;
   }

   public f(f var1) {
      this(var1.c);
      this.d = var1.d;
      this.e = var1.e;
      this.f = var1.f;
      this.g = var1.g;
      this.h = var1.h;
      this.a = var1.a;
      this.b = var1.b;
      this.i = var1.i;
      this.j = var1.j;
      this.k = var1.k;
   }

   public String toString() {
      return "cellRect: " + this.c.e() + "\ninterval: " + (this.e == null?"-":this.e.e().toString()) + "\ncosts: " + this.h + "\n";
   }

   public R a() {
      return this.c;
   }

   public f b() {
      return this.d;
   }

   public void a(f var1) {
      this.d = var1;
   }

   public P c() {
      return this.e;
   }

   public void a(P var1) {
      this.e = var1;
   }

   public y.f.y d() {
      return this.f;
   }

   public void a(y.f.y var1) {
      this.f = var1;
   }

   boolean e() {
      return this.g;
   }

   void a(boolean var1) {
      this.g = var1;
   }

   public double f() {
      return this.h;
   }

   public void a(double var1) {
      this.h = var1;
   }

   boolean g() {
      return this.i;
   }

   void b(boolean var1) {
      this.i = var1;
   }

   P h() {
      return this.l;
   }

   void b(P var1) {
      this.l = var1;
   }

   boolean i() {
      return this.j;
   }

   void c(boolean var1) {
      this.j = var1;
   }

   public v j() {
      return this.k;
   }

   public void a(v var1) {
      this.k = var1;
   }
}
