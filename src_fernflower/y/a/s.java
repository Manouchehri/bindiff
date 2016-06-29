package y.a;

import y.a.e;
import y.a.h;
import y.a.t;

class s extends e {
   private final t[] a;

   s(t[] var1) {
      this.a = var1;
   }

   protected void a(y.c.d var1, y.c.q var2) {
      y.c.q var3 = var1.a(var2);
      t var4 = this.a[var3.d()];
      t var5 = this.a[var2.d()];
      if(var5.c + 1 > var4.c) {
         var4.d = var4.c;
         var4.b = var4.a;
         var4.c = var5.c + 1;
         var4.a = var1;
         if(!h.a) {
            return;
         }
      }

      if(var5.c + 1 > var4.d) {
         var4.d = var5.c + 1;
         var4.b = var1;
      }

   }
}
