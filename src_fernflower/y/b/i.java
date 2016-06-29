package y.b;

import y.b.d;

final class i implements Runnable {
   private final d a;

   public i(d var1) {
      this.a = var1;
   }

   public void run() {
      this.a.disposeAnimation();
   }
}
