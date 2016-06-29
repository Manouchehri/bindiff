package y.h;

import y.h.bS;

class bK implements Runnable {
   private final bS a;

   bK(bS var1) {
      this.a = var1;
   }

   public void run() {
      this.a.c();
   }
}
