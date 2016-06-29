package y.f;

import y.f.G;
import y.f.aG;
import y.f.y;

class H {
   private final aG a;
   private final y b;

   private H(aG var1, y var2) {
      this.a = var1;
      this.b = var2;
   }

   H(aG var1, y var2, G var3) {
      this(var1, var2);
   }

   static aG a(H var0) {
      return var0.a;
   }

   static y b(H var0) {
      return var0.b;
   }
}
