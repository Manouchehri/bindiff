package y.f.a;

import java.util.Comparator;
import y.f.a.a;

class b implements Comparator {
   y.c.h a;
   y.c.h b;
   y.c.q c;
   private final a d;

   b(a var1, y.c.h var2, y.c.h var3, y.c.q var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      int var5 = y.g.e.a(this.a.c(var3), this.a.c(var4));
      if(var5 != 0) {
         return var5;
      } else if(a.b(this.d)) {
         double var6 = this.b.c(var3);
         double var8 = this.b.c(var4);
         if(var3.c() == this.c) {
            double var10 = a.a(y.d.e.a(this.a.c(var3)) + 3.141592653589793D);
            var6 = a.a(var6);
            var8 = a.a(var8);
            if(var6 < var10) {
               var6 += 6.283185307179586D;
            }

            if(var8 < var10) {
               var8 += 6.283185307179586D;
            }
         }

         return var6 > var8?1:(var8 > var6?-1:0);
      } else {
         return 0;
      }
   }
}
