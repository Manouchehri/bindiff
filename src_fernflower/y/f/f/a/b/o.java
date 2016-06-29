package y.f.f.a.b;

import y.f.f.a.b.a;
import y.f.f.a.b.i;
import y.f.f.a.b.p;
import y.f.f.a.b.q;

public class o {
   private y.c.i a;
   private y.f.f.a.a.p b;
   private i c;
   private y.c.f d;
   private y.c.f e;

   public o(y.c.i var1, y.f.f.a.a.p var2) {
      this.a = var1;
      this.b = var2;
      this.c = new i(this.a, this.b);
      this.d = new y.c.f();
      this.e = new y.c.f();
   }

   public void a() {
      this.c.d();
   }

   public y.c.f b() {
      return this.e;
   }

   public y.c.f c() {
      return this.d;
   }

   public void d() {
      boolean var4 = a.c;
      this.d.clear();
      this.e.clear();
      this.e.a(this.a.p());
      this.c.h();
      this.c.e();
      this.e();
      y.c.e var1 = this.d.a();
      var1.j();

      while(true) {
         if(var1.f()) {
            y.c.d var2 = var1.a();
            y.c.d var3 = this.c.a(var2);
            if(var4) {
               break;
            }

            if(var3 != null) {
               this.d.b(var3);
               this.d.remove(var2);
            }

            var1.h();
            if(!var4) {
               continue;
            }
         }

         this.e.removeAll(this.d);
         this.c.i();
         break;
      }

   }

   private void e() {
      this.c.f();
      y.f.f.a.a.m.a(new q(this, (p)null), (y.f.f.a.a.g)this.c);
      this.c.g();
   }

   static y.c.i a(o var0) {
      return var0.a;
   }

   static y.c.f b(o var0) {
      return var0.d;
   }
}
