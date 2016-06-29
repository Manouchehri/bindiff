package y.h;

import y.h.cQ;
import y.h.fj;

class cR implements y.b.c {
   private final cQ a;

   cR(cQ var1) {
      this.a = var1;
   }

   public void animationPerformed(y.b.a var1) {
      if(var1.a() == 3) {
         cQ.access$002(this.a, true);
         if(!fj.z) {
            return;
         }
      }

      if(var1.a() == 4) {
         cQ.access$002(this.a, false);
      }

   }
}
