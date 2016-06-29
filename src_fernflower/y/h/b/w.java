package y.h.b;

import java.util.Comparator;
import y.h.b.B;
import y.h.b.a;
import y.h.b.i;
import y.h.b.v;

class w implements Comparator {
   private final boolean a;
   private final v b;

   w(v var1, boolean var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      i var3 = (i)var1;
      i var4 = (i)var2;
      int var5;
      int var6;
      if(this.a) {
         var5 = ((B)v.a(this.b).get(var3)).e.size();
         var6 = ((B)v.a(this.b).get(var4)).e.size();
         if(a.H == 0) {
            return y.g.e.a(var6, var5);
         }
      }

      var5 = ((B)v.b(this.b).get(var3)).e.size();
      var6 = ((B)v.b(this.b).get(var4)).e.size();
      return y.g.e.a(var6, var5);
   }
}
