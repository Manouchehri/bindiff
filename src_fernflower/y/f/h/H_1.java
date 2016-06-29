package y.f.h;

import y.f.h.D;
import y.f.h.G;
import y.f.h.N;
import y.f.h.x;

public class H implements x {
   x a = null;
   private int b = 0;
   private G c;

   public H(x var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("You must specify a handler for non-planar graphs!");
      } else {
         this.a = var1;
         this.c = new G();
      }
   }

   public void a(D var1) {
      if(this.c.a(var1)) {
         this.b = 1;
         if(!N.d) {
            return;
         }
      }

      this.a.a(var1);
      this.b = 2;
   }

   public y.c.f c_() {
      if(this.b == 0) {
         throw new RuntimeException("Invalid Execution Order: call \'createPlanarization\' first!");
      } else {
         return this.b == 1?this.c.a():this.a.c_();
      }
   }
}
