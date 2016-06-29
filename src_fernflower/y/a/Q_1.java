package y.a;

import y.a.M;
import y.a.N;
import y.a.h;

class Q {
   N[] a;
   M b;

   public Q(y.c.i var1) {
      boolean var3 = h.a;
      super();
      this.a = new N[var1.e()];
      this.b = new M();
      y.c.x var2 = var1.o();

      while(var2.f()) {
         this.a[var2.e().d()] = this.b.a((Object)var2.e());
         var2.g();
         if(var3) {
            break;
         }
      }

   }

   public void a(y.c.q var1, y.c.q var2) {
      this.b.a(this.b(var1), this.b(var2));
   }

   public y.c.q a(y.c.q var1) {
      return this.a(this.b.a(this.b(var1)));
   }

   public boolean b(y.c.q var1, y.c.q var2) {
      return this.a(var1) == this.a(var2);
   }

   private N b(y.c.q var1) {
      return this.a[var1.d()];
   }

   private y.c.q a(N var1) {
      return var1 != null?(y.c.q)this.b.b(var1):null;
   }
}
