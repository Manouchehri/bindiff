package y.g;

import java.util.Map;

class U implements y.c.c {
   Map a;

   U(Map var1) {
      this.a = var1;
   }

   public Object b(Object var1) {
      return this.a.get(var1);
   }

   public int a(Object var1) {
      Object var2 = this.a.get(var1);
      return var2 instanceof Number?((Number)var2).intValue():0;
   }

   public double c(Object var1) {
      Object var2 = this.a.get(var1);
      return var2 instanceof Number?((Number)var2).doubleValue():0.0D;
   }

   public boolean d(Object var1) {
      return Boolean.TRUE.equals(this.a.get(var1));
   }
}
