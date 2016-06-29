package y.h;

import y.h.F;

class I implements y.c.o {
   private final F a;

   I(F var1) {
      this.a = var1;
   }

   public void onGraphEvent(y.c.l var1) {
      if(var1.a() == 3 && var1.b().equals(F.f(this.a))) {
         this.a.n();
      }

   }
}
