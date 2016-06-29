package y.b;

import y.b.d;

final class j implements Runnable {
   private final d a;
   private double b;

   public j(d var1) {
      this.a = var1;
      this.b = 0.0D;
   }

   public void a(double var1) {
      this.b = var1;
   }

   public void run() {
      this.a.calcFrame(this.b);
   }
}
