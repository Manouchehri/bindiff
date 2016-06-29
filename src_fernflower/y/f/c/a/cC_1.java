package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.N;

final class cC implements Comparator {
   boolean a;

   cC(boolean var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      y.f.aG var3;
      y.f.aG var4;
      label51: {
         if(this.a) {
            var4 = ((y.f.S)var1).f();
            var3 = ((y.f.S)var2).f();
            if(!N.x) {
               break label51;
            }
         }

         var3 = ((y.f.S)var1).f();
         var4 = ((y.f.S)var2).f();
      }

      byte var5 = var3.b();
      byte var6 = var4.b();
      byte var7 = var3.a();
      byte var8 = var4.a();
      return var7 == var8?(var5 == var6?0:(var5 == 16?-1:(var6 == 16?1:(var5 == 32?-1:(var6 == 32?1:0))))):(var7 == 1?-1:(var7 == 2?1:(var8 == 1?1:(var8 == 2?-1:0))));
   }
}
