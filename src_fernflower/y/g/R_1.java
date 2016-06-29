package y.g;

import java.util.Map;
import y.g.U;

class R extends U implements y.c.A, y.c.b, y.c.h {
   R(Map var1) {
      super(var1);
   }

   public void a(Object var1, Object var2) {
      this.a.put(var1, var2);
   }

   public void a(Object var1, int var2) {
      this.a.put(var1, new Integer(var2));
   }

   public void a(Object var1, double var2) {
      this.a.put(var1, new Double(var2));
   }

   public void a(Object var1, boolean var2) {
      this.a.put(var1, var2?Boolean.TRUE:Boolean.FALSE);
   }
}
