package y.f.h;

import java.util.HashMap;
import y.f.h.p;
import y.f.h.r;

class U implements r {
   private HashMap a = new HashMap();

   public void a(p var1, Object var2) {
      this.a.put(var1, var2);
   }

   public Object b(Object var1) {
      return this.a.get(var1);
   }

   public void a(p var1, boolean var2) {
      this.a.put(var1, var2?Boolean.TRUE:Boolean.FALSE);
   }

   public boolean d(Object var1) {
      Object var2 = this.a.get(var1);
      return var2 == null?false:((Boolean)var2).booleanValue();
   }

   public double c(Object var1) {
      Object var2 = this.a.get(var1);
      return var2 == null?0.0D:((Double)var2).doubleValue();
   }

   public void a(p var1, int var2) {
      this.a.put(var1, new Integer(var2));
   }

   public int a(Object var1) {
      Object var2 = this.a.get(var1);
      return var2 == null?0:((Integer)var2).intValue();
   }

   public void a() {
      this.a.clear();
   }
}
