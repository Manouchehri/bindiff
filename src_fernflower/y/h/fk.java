package y.h;

import y.h.bu;
import y.h.fl;

public class fk extends y.g.p implements y.c.c {
   private fl a;

   public fk(bu var1, boolean var2) {
      this(var1, true, var2);
   }

   public fk(bu var1, boolean var2, boolean var3) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.a = new fl(var1, var2, var3);
      }
   }

   public Object b(Object var1) {
      if(!(var1 instanceof y.c.d)) {
         return null;
      } else {
         y.c.d var2 = (y.c.d)var1;
         this.a.c = var2;
         return this.a;
      }
   }
}
