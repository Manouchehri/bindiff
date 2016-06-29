package y.h;

import y.h.bu;
import y.h.fj;

class ii extends y.c.q {
   fj l;

   protected ii(bu var1, fj var2) {
      super(var1);
      if(var2 != null) {
         this.l = var2;
         var2.b((y.c.q)this);
      }

   }

   public y.c.q a(y.c.i var1) {
      if(var1 instanceof bu) {
         bu var2 = (bu)var1;
         return var2.a(this.l.createCopy());
      } else {
         return super.a(var1);
      }
   }

   public String toString() {
      if(this.l != null && this.l.labelCount() > 0) {
         String var1 = this.l.getLabelText();
         if(var1 != null && var1.length() > 0) {
            return var1;
         }
      }

      return super.toString();
   }
}
