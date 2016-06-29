package y.g;

import y.g.C;
import y.g.D;
import y.g.M;

public class G extends D {
   public G(C var1, Object var2) {
      super(var1, var2);
   }

   protected y.c.b a(y.c.i var1) {
      return M.c();
   }

   protected void a(y.c.q var1, y.c.q var2) {
      super.a(var1, var2);
      y.c.c var3 = var1.e().c(this.a);
      if(var3 != null) {
         Object var4 = this.a(this.a, var1, var2, var3.b(var1));
         if(var4 != null) {
            this.b(var2.e()).a(var2, var4);
         }
      }

   }

   protected void a(y.c.d var1, y.c.d var2) {
      super.a(var1, var2);
      y.c.c var3 = var1.a().c(this.a);
      if(var3 != null) {
         Object var4 = this.a(this.a, var1, var2, var3.b(var1));
         if(var4 != null) {
            this.b(var2.a()).a(var2, var4);
         }
      }

   }

   protected Object a(Object var1, y.c.q var2, y.c.q var3, Object var4) {
      return var4;
   }

   protected Object a(Object var1, y.c.d var2, y.c.d var3, Object var4) {
      return var4;
   }
}
