package y.f.i;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import y.f.i.ad;
import y.f.i.v;

class aG implements Comparator {
   private y.f.X a;
   private v b;

   public aG(y.f.X var1, v var2) {
      this.a = var1;
      this.b = var2;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a(this.a((y.c.d)var1), this.a((y.c.d)var2));
   }

   private int a(y.c.d var1) {
      int var2;
      label13: {
         var2 = 0;
         if(this.b.b(var1.c())) {
            var2 -= 128;
            if(v.f == 0) {
               break label13;
            }
         }

         if(this.b.b(var1.d())) {
            var2 -= 64;
         }
      }

      var2 += this.a(ad.a(this.a, var1, true));
      var2 += this.a(ad.a(this.a, var1, false));
      return var2;
   }

   private int a(Collection var1) {
      int var6 = v.f;
      int var2 = 0;
      int var10000;
      if(var1 != null && !var1.isEmpty()) {
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            y.f.ax var4 = (y.f.ax)var3.next();
            boolean var5 = false;
            var10000 = var4.b();
            if(var6 != 0) {
               return var10000;
            }

            int var7;
            label40: {
               if(var10000 != 0) {
                  var7 = -16;
                  if(var6 == 0) {
                     break label40;
                  }
               }

               var7 = -4;
            }

            if(var4.a((int)1)) {
               ++var7;
            }

            if(var4.a((int)2)) {
               ++var7;
            }

            if(var4.a((int)8)) {
               ++var7;
            }

            if(var4.a((int)4)) {
               ++var7;
            }

            var2 = Math.min(var7, var2);
            if(var6 != 0) {
               break;
            }
         }
      }

      var10000 = var2;
      return var10000;
   }
}
