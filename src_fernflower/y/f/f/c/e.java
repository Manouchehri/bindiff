package y.f.f.c;

import y.c.D;
import y.f.f.c.g;
import y.f.f.c.p;

class e {
   p a;
   D b = new D();

   e(p var1) {
      this.a = var1;
   }

   public g[] a(g var1) {
      int var6 = g.a;
      g[] var2 = new g[]{null, null};
      y.c.p var3 = this.b.k();
      y.c.p var4 = null;

      while(true) {
         if(var3 != null) {
            g var5 = (g)this.b.g(var3);
            if(var6 != 0) {
               break;
            }

            if(var5.i() < var1.i()) {
               var4 = var3;
               var3 = this.b.c(var3);
               if(var6 == 0) {
                  continue;
               }
            }
         }

         this.b.a((Object)var1, (y.c.p)var3);
         break;
      }

      if(var4 != null) {
         var2[0] = (g)this.b.g(var4);
      }

      if(var3 != null) {
         var2[1] = (g)this.b.g(var3);
      }

      return var2;
   }

   public void b(g var1) {
      this.b.remove(var1);
   }
}
