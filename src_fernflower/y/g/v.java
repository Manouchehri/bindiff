package y.g;

import y.g.p;

class v extends p {
   private Object a;

   v(Object var1) {
      this.a = var1;
   }

   public Object b(Object var1) {
      return this.a;
   }

   public double c(Object var1) {
      return ((Number)this.a).doubleValue();
   }

   public int a(Object var1) {
      return ((Number)this.a).intValue();
   }

   public boolean d(Object var1) {
      return ((Boolean)this.a).booleanValue();
   }
}
