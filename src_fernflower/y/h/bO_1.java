package y.h;

import y.h.bI;
import y.h.bQ;
import y.h.bS;
import y.h.bu;
import y.h.ch;

class bO extends bS {
   private final bQ i;
   private final Runnable j;
   private final bI k;

   bO(bI var1, ch var2, bu var3, y.f.ah var4, boolean var5, bQ var6, Runnable var7) {
      super(var1, var2, var3, var4, var5);
      this.k = var1;
      this.i = var6;
      this.j = var7;
   }

   protected void a(y.f.l var1) {
      this.k.a(this.e, var1.C());
   }

   protected void a() {
      super.a();
      this.e.T();
      if(this.b != null && this.i != null) {
         this.i.a(this.b);
      }

      if(this.j != null) {
         this.j.run();
      }

   }
}
