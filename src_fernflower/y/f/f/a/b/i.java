package y.f.f.a.b;

import y.f.f.a.b.a;
import y.f.f.a.b.j;
import y.f.f.a.b.k;
import y.f.f.a.b.n;

public class i implements y.f.f.a.a.g, y.f.f.a.a.l {
   protected y.c.i a;
   protected y.f.f.a.a.p b;
   protected y.f.f.a.a.j c;
   private y.c.f d;
   private y.c.h e;

   public i(y.c.i var1, y.f.f.a.a.p var2) {
      this.a = var1;
      this.b = var2;
      this.c = this.b.b();
      this.d = new y.c.f();
      this.e = this.a.u();
      this.c();
   }

   public void c() {
      this.c.a((y.f.f.a.a.l)this);
   }

   public void d() {
      this.b.a((y.f.f.a.a.j)this.c);
      this.a.a(this.e);
   }

   public Object b() {
      return new n();
   }

   public y.f.f.a.a.e a() {
      return this.c.a();
   }

   public void e() {
      boolean var6 = a.c;
      this.c();
      y.c.e var5 = this.a.p();

      while(var5.f()) {
         y.c.d var1 = var5.a();
         y.f.f.a.a.b var3 = this.b.a(var5.a().c());
         y.f.f.a.a.b var4 = this.b.a(var5.a().d());
         if(var3.c() != var4.c()) {
            throw new RuntimeException("Replace edges by their representatives!");
         }

         n var2 = (n)this.c.a((y.f.f.a.a.f)var3.c());
         var2.a(var1);
         var5.g();
         if(var6) {
            break;
         }
      }

   }

   public void a(y.f.f.a.a.b var1) {
      n var2 = (n)this.c.a((y.f.f.a.a.f)var1);
      var2.a(this.a);
   }

   public void b(y.f.f.a.a.b var1) {
      n var2 = (n)this.c.a((y.f.f.a.a.f)var1);
      var2.b(this.a);
   }

   public void f() {
      y.f.f.a.a.m.a(new j(this), (y.f.f.a.a.g)this.c);
   }

   public void g() {
      y.f.f.a.a.m.a(new k(this), (y.f.f.a.a.g)this.c);
   }

   public void h() {
      boolean var9 = a.c;
      y.f.f.a.a.b var3 = null;
      y.f.f.a.a.b var4 = null;
      y.c.e var6 = this.a.p();

      while(var6.f()) {
         y.c.d var7 = var6.a();
         y.f.f.a.a.b var1 = this.b.a(var7.c());
         y.f.f.a.a.b var2 = this.b.a(var7.d());
         if(!y.f.f.a.a.n.a(var1, var2)) {
            y.f.f.a.a.e[] var5 = y.f.f.a.a.n.b(var1, var2);
            var3 = (y.f.f.a.a.b)var5[0];
            var4 = (y.f.f.a.a.b)var5[1];
            y.c.d var8 = this.a.a(var3.b_(), var4.b_());
            this.d.add(var8);
            this.e.a(var8, var7);
            this.a.d(var7);
         }

         var6.g();
         if(var9) {
            break;
         }
      }

   }

   public void i() {
      boolean var3 = a.c;
      y.c.e var1 = this.d.a();

      while(var1.f()) {
         y.c.d var2 = var1.a();
         this.a.e((y.c.d)this.e.b(var2));
         this.a.a(var2);
         var1.g();
         if(var3) {
            break;
         }
      }

   }

   public y.c.d a(y.c.d var1) {
      return (y.c.d)this.e.b(var1);
   }
}
