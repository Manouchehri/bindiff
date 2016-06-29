package y.f.c.a;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import y.f.c.a.N;

class c implements Comparator, y.g.g {
   private final y.c.c a;
   private final Comparator b;
   private final byte c;
   private final int d;

   c(y.c.c var1, Comparator var2, byte var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.d = var4;
      this.c = var3;
   }

   public int compare(Object var1, Object var2) {
      boolean var11 = N.x;
      if(this.b != null && this.b.compare(var1, var2) != 0) {
         return this.b.compare(var1, var2);
      } else if(this.a == null) {
         return 0;
      } else {
         Collection var3 = (Collection)this.a.b(var1);
         Collection var4 = (Collection)this.a.b(var2);
         if(var3 == null && var4 == null) {
            return 0;
         } else if(var3 == null) {
            return -1;
         } else if(var4 == null) {
            return 1;
         } else {
            double var5 = 0.0D;
            Iterator var7 = var3.iterator();

            while(true) {
               if(var7.hasNext()) {
                  y.f.ax var8 = (y.f.ax)var7.next();
                  var5 += var8.a(this.c, this.d);
                  if(var11) {
                     break;
                  }

                  if(!var11) {
                     continue;
                  }
               }

               var5 /= (double)var3.size();
               break;
            }

            double var12 = 0.0D;
            Iterator var9 = var4.iterator();

            while(true) {
               if(var9.hasNext()) {
                  y.f.ax var10 = (y.f.ax)var9.next();
                  var12 += var10.a(this.c, this.d);
                  if(var11) {
                     break;
                  }

                  if(!var11) {
                     continue;
                  }
               }

               var12 /= (double)var4.size();
               break;
            }

            return (int)(100.0D * (var5 - var12));
         }
      }
   }
}
