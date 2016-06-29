package y.b;

import y.b.d;

final class k implements Runnable {
   private final d a;

   public k(d var1) {
      this.a = var1;
   }

   public void run() {
      this.a.initAnimation();
   }
}
