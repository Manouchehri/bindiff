package y.f.e.a;

import y.f.e.a.Z;
import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.k;
import y.f.e.a.m;

public class ag implements m {
   private a a;
   private double b;
   private double c;
   private double d;
   private a e;
   private y.c.q f;
   private double g;
   private double h;
   private m i;
   private short j;
   private double k;
   private final af l;

   ag(af var1, y.c.q var2) {
      this.l = var1;
      this.a = new Z();
      this.d = 0.9D;
      this.e = new Z();
      this.j = 0;
      this.f = var2;
      this.o();
   }

   public boolean m() {
      return this.i != null;
   }

   public boolean n() {
      return this.j == 3;
   }

   public void a(boolean var1) {
      if(var1) {
         this.j = (short)(this.j | 2);
         if(!af.b) {
            return;
         }
      }

      this.j = (short)(this.j & -3);
   }

   public void a(m var1) {
      this.i = var1;
   }

   public boolean k() {
      return this.j != 0;
   }

   public m l() {
      return this.i;
   }

   public void b(boolean var1) {
      if(var1) {
         this.j = (short)(this.j | 1);
         if(!af.b) {
            return;
         }
      }

      this.j = (short)(this.j & -2);
   }

   public void o() {
      y.f.am var1 = af.a(this.l).h(this.f);
      this.a(var1.getWidth(), var1.getHeight());
      this.a(var1.getX() + var1.getWidth() / 2.0D, var1.getY() + var1.getHeight() / 2.0D, 0.0D);
   }

   public void a(double var1, double var3) {
      this.b = var1;
      this.c = var3;
      this.q();
   }

   private void q() {
      this.h = (this.b + this.c) / 4.0D;
   }

   private void b(double var1, double var3) {
      af.b(this.l).a(af.b(this.l).d() - var1 + var3);
      af.c(this.l).a(af.c(this.l).d() + (var3 * var3 - var1 * var1));
   }

   private void c(double var1, double var3) {
      af.b(this.l).b(af.b(this.l).e() - var1 + var3);
      af.c(this.l).b(af.c(this.l).e() + (var3 * var3 - var1 * var1));
   }

   private void d(double var1, double var3) {
      af.b(this.l).c(af.b(this.l).f() - var1 + var3);
      af.c(this.l).c(af.c(this.l).f() + (var3 * var3 - var1 * var1));
   }

   public void a(double var1, double var3, double var5) {
      double var7 = this.a.d();
      double var9 = this.a.e();
      double var11 = this.a.f();
      this.b(this.a.d(), var1);
      this.a.a(var1);
      this.c(this.a.e(), var3);
      this.a.b(var3);
      this.d(this.a.f(), var5);
      this.a.c(var5);
      this.l.a(this, var7, var9, var11, var1, var3, var5);
   }

   public void a(double var1) {
      double var3 = this.a.d();
      this.b(this.a.d(), var1);
      this.a.a(var1);
      this.l.a(this, var3, this.a.e(), this.a.f(), var1, this.a.e(), this.a.f());
   }

   public void b(double var1) {
      double var3 = this.a.e();
      this.c(this.a.e(), var1);
      this.a.b(var1);
      this.l.a(this, this.a.d(), var3, this.a.f(), this.a.d(), var1, this.a.f());
   }

   public k a() {
      return this.a;
   }

   public double b() {
      return this.a.d();
   }

   public double c() {
      return this.a.e();
   }

   public double d() {
      return this.a.f();
   }

   public double e() {
      return this.d;
   }

   public void c(double var1) {
      this.e(this.d, var1);
      this.d = var1;
   }

   private void e(double var1, double var3) {
      af.a(this.l, var3 - var1);
      af.b(this.l, var3 * var3 - var1 * var1);
      af.d(this.l);
   }

   public void p() {
      this.e.a();
   }

   public k f() {
      return this.e;
   }

   public void a(k var1) {
      this.e.a(var1);
   }

   public void b(k var1) {
      this.a(var1.d() + this.a.d(), var1.e() + this.a.e(), var1.f() + this.a.f());
   }

   public y.c.q j() {
      return this.f;
   }

   public void d(double var1) {
      this.g = var1;
   }

   public double g() {
      return this.g;
   }

   public double h() {
      return this.h;
   }

   public void e(double var1) {
      this.k = var1;
   }

   public double i() {
      return this.k;
   }

   public void f(double var1) {
      this.h = var1;
   }
}
