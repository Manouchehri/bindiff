package y.f;

import y.f.l;

class m extends y.g.p {
   private final y.c.c a;
   private final l b;

   m(l var1, y.c.c var2) {
      this.b = var1;
      this.a = var2;
   }

   public Object b(Object var1) {
      if(var1 instanceof y.c.q) {
         Object var2 = l.a(this.b).b(var1);
         if(var2 != null) {
            if(this.a != null) {
               return this.a.b(var2);
            }

            return var2;
         }
      }

      return null;
   }
}
