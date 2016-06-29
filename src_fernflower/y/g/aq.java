package y.g;

import y.g.ap;

class aq implements y.c.b {
   private final ap a;

   aq(ap var1) {
      this.a = var1;
   }

   public Object b(Object var1) {
      y.c.c var2 = ap.a(this.a);
      if(var2 != null) {
         Object var3 = var2.b(var1);
         if(var3 != null) {
            return var3;
         }
      }

      return ap.b(this.a).b(var1);
   }

   public int a(Object var1) {
      throw new IllegalStateException("Only get(Object) may be used");
   }

   public double c(Object var1) {
      throw new IllegalStateException("Only get(Object) may be used");
   }

   public boolean d(Object var1) {
      throw new IllegalStateException("Only get(Object) may be used");
   }

   public void a(Object var1, Object var2) {
      ((y.c.a)ap.b(this.a)).a(var1, var2);
   }

   public void a(Object var1, int var2) {
      throw new IllegalStateException("Only set(Object) may be used");
   }

   public void a(Object var1, double var2) {
      throw new IllegalStateException("Only set(Object) may be used");
   }

   public void a(Object var1, boolean var2) {
      throw new IllegalStateException("Only set(Object) may be used");
   }
}
