package y.f.c;

import y.f.c.a;
import y.f.c.aa;

class ab {
   y.c.D a;
   private final aa b;

   ab(aa var1, y.c.q var2) {
      this.b = var1;
      this.a = new y.c.D();
      this.a.b((Object)var2);
   }

   double a() {
      boolean var4 = a.i;
      double var1 = 0.0D;
      y.c.C var3 = this.a.m();

      while(true) {
         if(var3.f()) {
            var1 += this.b.o[((y.c.q)var3.d()).d()];
            var3.g();
            if(var4) {
               break;
            }

            if(!var4) {
               continue;
            }
         }

         var1 /= (double)this.a.size();
         break;
      }

      return var1;
   }

   void a(double var1) {
      boolean var5 = a.i;
      y.c.C var3 = this.a.m();

      while(var3.f()) {
         y.c.q var4 = (y.c.q)var3.d();
         this.b.g.b(var4, this.b.g.o(var4).b(var1, 0.0D));
         var3.g();
         if(var5) {
            break;
         }
      }

   }
}
