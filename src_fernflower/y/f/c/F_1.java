package y.f.c;

import y.f.c.E;
import y.f.c.J;
import y.f.c.a;
import y.f.c.at;

final class F extends J implements y.f.ah {
   at a;
   Object b;
   private final E h;

   public F(E var1, at var2) {
      super(var1);
      this.h = var1;
      this.a = var2;
   }

   public y.c.y[] a(y.f.X var1, y.c.A var2, int var3) {
      boolean var6 = a.i;
      this.a.a(this.b, var1, var2, var3, this.f, this.g, E.a(this.h).c(y.f.ah.f_), E.a(this.h).c(y.f.ah.k), E.a(this.h).c(y.f.aF.a), E.a(this.h).c(y.f.aF.b), E.a(this.h).c(y.f.aF.c), E.a(this.h).c(y.f.aF.d));
      y.c.y[] var4 = new y.c.y[var3];
      int var5 = 0;

      while(var5 < var4.length) {
         var4[var5] = new y.c.y();
         ++var5;
         if(var6) {
            break;
         }
      }

      y.c.x var7 = var1.o();

      y.c.y[] var10000;
      while(true) {
         if(var7.f()) {
            var10000 = var4;
            if(var6) {
               break;
            }

            var4[var2.a(var7.e())].add(var7.e());
            var7.g();
            if(!var6) {
               continue;
            }
         }

         var10000 = var4;
         break;
      }

      return var10000;
   }

   public void a(y.f.X var1, y.c.y[] var2, y.c.c var3) {
   }

   public void c(y.f.X var1) {
      this.h.d(var1);
   }
}
