package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.N;

class ca implements Comparator {
   y.c.q a;
   private final y.f.X b;

   public ca(y.f.X var1) {
      this.b = var1;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var4;
      double var5;
      boolean var9;
      label43: {
         var9 = N.x;
         y.c.d var3 = (y.c.d)var1;
         var4 = (y.c.d)var2;
         if(var3.c() == this.a) {
            var5 = this.b.n(var3).b;
            if(!var9) {
               break label43;
            }
         }

         if(var3.d() != this.a) {
            throw new IllegalStateException();
         }

         var5 = this.b.o(var3).b;
         if(var9) {
            throw new IllegalStateException();
         }
      }

      double var7;
      if(var4.c() == this.a) {
         var7 = this.b.n(var4).b;
         if(!var9) {
            return var5 > var7?-1:(var5 < var7?1:0);
         }
      }

      if(var4.d() == this.a) {
         var7 = this.b.o(var4).b;
         if(!var9) {
            return var5 > var7?-1:(var5 < var7?1:0);
         }
      }

      throw new IllegalStateException();
   }
}
