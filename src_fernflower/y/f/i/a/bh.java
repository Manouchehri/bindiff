package y.f.i.a;

import y.f.i.a.bg;
import y.f.i.a.f;
import y.f.i.a.v;

class bh {
   private f a;
   private v b;
   private v c;

   private bh(f var1, v var2, v var3) {
      this.a = var1;
      this.c = var3;
      this.b = var2;
   }

   bh(f var1, v var2, v var3, bg var4) {
      this(var1, var2, var3);
   }

   static v a(bh var0) {
      return var0.b;
   }

   static f b(bh var0) {
      return var0.a;
   }

   static v c(bh var0) {
      return var0.c;
   }
}
