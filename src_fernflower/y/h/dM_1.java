package y.h;

import y.h.dI;

class dM implements y.c.o {
   private final y.c.d a;
   private final dI b;

   dM(dI var1, y.c.d var2) {
      this.b = var1;
      this.a = var2;
   }

   public void onGraphEvent(y.c.l var1) {
      if(var1.a() == 5 && var1.b().equals(this.a)) {
         dI.c(this.b);
      }

   }
}
