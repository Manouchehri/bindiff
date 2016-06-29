package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.M;
import y.f.i.a.bN;
import y.f.i.a.w;

class bM implements Comparator {
   private final bN a;

   bM(bN var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      M var3 = ((w)var1).a(this.a.b).c();
      double var4 = var3.a();
      M var6 = ((w)var2).a(this.a.b).c();
      double var7 = var6.a();
      if(var4 < var7) {
         return -1;
      } else if(var4 > var7) {
         return 1;
      } else {
         double var9 = var3.b();
         double var11 = var6.b();
         return var9 > var11?-1:(var9 < var11?1:0);
      }
   }
}
