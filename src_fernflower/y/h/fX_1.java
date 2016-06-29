package y.h;

import y.h.fW;

class fX implements Runnable {
   private final fW a;

   fX(fW var1) {
      this.a = var1;
   }

   public void run() {
      fW.a(this.a).a();
      fW.b(this.a).repaint();
   }
}
