package y.f.e;

import y.f.e.q;

class t extends y.g.p {
   private final y.c.A a;
   private final q b;

   t(q var1, y.c.A var2) {
      this.b = var1;
      this.a = var2;
   }

   public boolean d(Object var1) {
      if(var1 instanceof y.c.d) {
         y.c.d var2 = (y.c.d)var1;
         return !this.a.d(var2.c());
      } else {
         return false;
      }
   }
}
