package y.a;

import y.a.H;
import y.a.h;

final class I {
   public H a;
   public H b;

   public void a(H var1) {
      var1.b = null;
      var1.a = null;
      if(this.b == null) {
         this.a = this.b = var1;
         if(!h.a) {
            return;
         }
      }

      this.b.a = var1;
      var1.b = this.b;
      this.b = var1;
   }

   public void b(H var1) {
      boolean var2;
      label19: {
         var2 = h.a;
         if(var1 != this.a) {
            var1.b.a = var1.a;
            if(!var2) {
               break label19;
            }
         }

         this.a = var1.a;
      }

      if(var1 != this.b) {
         var1.a.b = var1.b;
         if(!var2) {
            return;
         }
      }

      this.b = var1.b;
   }
}
