package y.f;

import java.util.Collection;
import java.util.Iterator;
import y.f.X;
import y.f.aA;
import y.f.aB;
import y.f.ax;
import y.f.ay;
import y.f.az;

final class aD implements az {
   y.c.D a;
   private final ay b;

   aD(ay var1, Collection var2) {
      boolean var5 = X.j;
      super();
      this.b = var1;
      this.a = new y.c.D();
      Iterator var3 = var2.iterator();

      while(true) {
         if(var3.hasNext()) {
            aB var4 = (aB)var3.next();
            this.a.add(new aB(var4));
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         this.a.sort(ay.b);
         break;
      }

   }

   public aA a(y.c.d var1, boolean var2, int var3) {
      boolean var11 = X.j;
      if(this.a.isEmpty()) {
         throw new IllegalStateException("No candidates left");
      } else {
         y.c.p var4 = null;
         double var5 = -1.7976931348623157E308D;
         y.c.p var7 = this.a.k();

         Object var10000;
         while(true) {
            if(var7 != null) {
               aB var8 = (aB)var7.c();
               var10000 = var8.a;
               if(var11) {
                  break;
               }

               if(((ax)var10000).a(var3)) {
                  double var9 = this.b.a(var8, var1, var2);
                  if(var9 > var5) {
                     var5 = var9;
                     var4 = var7;
                  }
               }

               var7 = var7.a();
               if(!var11) {
                  continue;
               }
            }

            if(var4 == null) {
               throw new IllegalStateException("No candidates left");
            }

            var10000 = var4.c();
            break;
         }

         aB var12 = (aB)var10000;
         --var12.c;
         if(var12.c <= 0) {
            this.a.h(var4);
         }

         return var12;
      }
   }
}
