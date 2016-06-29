package y.h;

import y.h.fT;

class fV implements Runnable {
   private final fT a;

   fV(fT var1) {
      this.a = var1;
   }

   public void run() {
      if(fT.b(this.a) && fT.c(this.a) != null && fT.c(this.a).getGlassPane() != null) {
         fT.c(this.a).getGlassPane().setVisible(fT.b(this.a));
      }

   }
}
