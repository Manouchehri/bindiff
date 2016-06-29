package y.h;

import y.h.bS;

class bM implements Runnable {
   private final bS a;

   bM(bS var1) {
      this.a = var1;
   }

   public void run() {
      this.a.a();
   }
}
