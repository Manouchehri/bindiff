package y.h;

import y.h.aC;

class aE extends y.g.p {
   private final aC a;

   aE(aC var1) {
      this.a = var1;
   }

   public boolean d(Object var1) {
      if(var1 instanceof y.c.d) {
         y.c.d var2 = (y.c.d)var1;
         return this.a.isOrthogonalRouting(var2);
      } else {
         return false;
      }
   }
}
