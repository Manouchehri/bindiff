package y.g.a;

import y.c.A;
import y.g.a.g;
import y.g.a.k;
import y.g.a.m;

public class j implements g {
   private A a = null;
   private boolean b = false;
   private y.c.i c;
   private m d = null;

   public j(y.c.i var1) {
      this.c = var1;
      this.a = this.c.t();
      this.a(this.a);
      this.b = true;
   }

   private void a(A var1) {
      this.a = var1;
      this.d = new m(new k(this, var1));
   }

   public boolean a() {
      return this.d.b();
   }

   public boolean a(y.c.q var1) {
      return this.d.c(var1);
   }

   public void a(y.c.q var1, int var2) {
      this.a.a(var1, var2);
      this.d.a((Object)var1);
   }

   public void c(y.c.q var1) {
      this.d.b((Object)var1);
   }

   public y.c.q b() {
      return (y.c.q)this.d.c();
   }

   public y.c.q c() {
      y.c.q var1 = this.b();
      this.c(var1);
      return var1;
   }

   public void b(y.c.q var1, int var2) {
      this.d.b((Object)var1);
      this.a.a(var1, var2);
      this.d.a((Object)var1);
   }

   public void d() {
      this.d.a();
   }

   public int b(y.c.q var1) {
      return this.a.a(var1);
   }
}
