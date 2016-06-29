package y.f.f.a.b;

import y.f.f.a.b.F;
import y.f.f.a.b.G;
import y.f.f.a.b.H;
import y.f.f.a.b.i;

public class E {
   private y.c.i a;
   private y.f.f.a.a.p b;
   private i c;
   private y.c.f d;
   private int e;

   public E(y.c.i var1, y.f.f.a.a.p var2) {
      this.a = var1;
      this.b = var2;
      this.c = new i(this.a, this.b);
      this.d = new y.c.f();
   }

   public void a() {
      this.c.d();
   }

   public y.c.f b() {
      return this.d;
   }

   public static y.c.f a(y.c.i var0, y.f.f.a.a.p var1) {
      E var2 = new E(var0, var1);
      var2.c();
      var2.a();
      return var2.b();
   }

   public static boolean b(y.c.i var0, y.f.f.a.a.p var1) {
      E var2 = new E(var0, var1);
      boolean var3 = var2.f();
      var2.a();
      return var3;
   }

   private void c() {
      this.e = 0;
      this.d();
   }

   private void d() {
      this.d.clear();
      this.c.h();
      this.c.e();
      this.e();
      this.c.i();
   }

   private void e() {
      this.c.f();
      y.f.f.a.a.m.a(new H(this, (F)null), (y.f.f.a.a.g)this.c);
      this.c.g();
   }

   private boolean f() {
      this.c.h();
      this.c.e();
      this.c.f();
      G var1 = new G(this, (F)null);
      y.f.f.a.a.m.a(var1, (y.f.f.a.a.g)this.c);
      this.c.g();
      this.c.i();
      return var1.b;
   }

   static y.c.i a(E var0) {
      return var0.a;
   }

   static int b(E var0) {
      return var0.e;
   }

   static y.c.f c(E var0) {
      return var0.d;
   }
}
