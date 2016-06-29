package y.f.g;

import y.f.g.d;
import y.g.M;

class k extends y.g.p {
   private y.c.A a;
   private y.c.c b;
   private final d d;

   k(d var1, y.c.q var2, y.c.c var3) {
      boolean var6 = d.d;
      super();
      this.d = var1;
      this.b = var3;
      this.a = M.a();
      y.c.x var4 = d.a(var1).c(var2).a();

      while(var4.f()) {
         y.c.q var5 = var4.e();
         this.a.a(var5, true);
         var4.g();
         if(var6) {
            break;
         }
      }

   }

   public boolean d(Object var1) {
      return this.b.d(var1) && !this.a.d(var1);
   }
}
