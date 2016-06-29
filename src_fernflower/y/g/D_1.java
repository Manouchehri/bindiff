package y.g;

import y.g.C;
import y.g.F;
import y.g.p;

public abstract class D extends F {
   protected final Object a;
   private y.c.b b;

   protected D(C var1, Object var2) {
      super(var1);
      this.a = var2;
   }

   protected void b(y.c.i var1, y.c.i var2) {
      super.b(var1, var2);
      if(var2.c(this.a) != null) {
         this.b = (y.c.b)var2.c(this.a);
         if(!p.c) {
            return;
         }
      }

      this.b = this.a(var2);
      var2.a((Object)this.a, (y.c.c)this.b);
   }

   protected abstract y.c.b a(y.c.i var1);

   protected y.c.b b(y.c.i var1) {
      if(this.b == null) {
         this.b = this.a(var1);
      }

      return this.b;
   }
}
