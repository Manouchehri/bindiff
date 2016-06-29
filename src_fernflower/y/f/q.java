package y.f;

import y.f.C;
import y.f.aj;
import y.f.l;

class q implements y.c.c {
   y.c.c a;
   private final l b;

   q(l var1, y.c.c var2) {
      this.b = var1;
      this.a = var2;
   }

   public Object b(Object var1) {
      Object var2 = this.e(var1);
      return var2 != null?this.a.b(var2):null;
   }

   public int a(Object var1) {
      Object var2 = this.e(var1);
      return var2 != null?this.a.a(var2):0;
   }

   public double c(Object var1) {
      Object var2 = this.e(var1);
      return var2 != null?this.a.c(var2):0.0D;
   }

   public boolean d(Object var1) {
      Object var2 = this.e(var1);
      return var2 != null?this.a.d(var2):false;
   }

   Object e(Object var1) {
      return var1 instanceof y.c.q?l.a(this.b).b(var1):(var1 instanceof y.c.d?l.b(this.b).b(var1):(var1 instanceof aj?l.c(this.b).get(var1):(var1 instanceof C?l.d(this.b).get(var1):var1)));
   }
}
