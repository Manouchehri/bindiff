package y.b;

import y.b.d;
import y.b.n;

class m implements d {
   private final d a;
   private n b;

   m(d var1, n var2) {
      this.a = var1;
      this.b = var2;
   }

   public void initAnimation() {
      this.a.initAnimation();
   }

   public void calcFrame(double var1) {
      this.a.calcFrame(this.b.a(var1));
   }

   public void disposeAnimation() {
      this.a.disposeAnimation();
   }

   public long preferredDuration() {
      return this.a.preferredDuration();
   }
}
