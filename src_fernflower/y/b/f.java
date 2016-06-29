package y.b;

import y.b.a;
import y.b.c;
import y.b.e;

class f implements Runnable {
   private final c[] a;
   private final a b;
   private final e c;

   f(e var1, c[] var2, a var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      int var3 = e.a;
      int var1 = 0;
      int var2 = this.a.length;

      while(var1 < var2) {
         this.a[var1].animationPerformed(this.b);
         ++var1;
         if(var3 != 0) {
            break;
         }
      }

   }
}
