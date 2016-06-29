package y.b;

import y.b.d;
import y.b.e;

final class h {
   private final d a;
   private long b;
   private long c;
   private final e d;

   h(e var1, d var2) {
      this.d = var1;
      this.a = var2;
      this.b = -1L;
      this.c = -1L;
   }

   boolean a() {
      if(this.c < 0L) {
         long var1 = this.a.preferredDuration();
         this.b = 0L < var1?(long)((double)var1 / e.a(this.d)):0L;
         this.c = System.currentTimeMillis();
      }

      double var3 = 0L < this.b?(double)(System.currentTimeMillis() - this.c) / (double)this.b:1.0D;
      if(var3 < 1.0D) {
         this.a.calcFrame(var3);
         return false;
      } else {
         this.a.calcFrame(1.0D);
         this.a.disposeAnimation();
         return true;
      }
   }
}
