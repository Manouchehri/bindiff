package y.f.f.d;

import y.f.f.d.b;
import y.f.f.d.g;
import y.f.f.d.k;
import y.f.f.d.l;
import y.f.f.d.n;

class h implements k {
   private n a;
   private l b;
   private final g c;

   h(g var1) {
      this.c = var1;
      this.a = new n(this.c);
      this.b = new l(this.c);
   }

   public boolean a(y.c.D var1) {
      if(var1.size() < 6) {
         return false;
      } else {
         y.c.p var2 = var1.l();
         b var3 = (b)var2.c();
         var2 = var2.b();
         b var4 = (b)var2.c();
         var2 = var2.b();
         b var5 = (b)var2.c();
         var2 = var2.b();
         b var6 = (b)var2.c();
         if(var6.b() == 1 && var5.b() == 0 && var4.b() == 0 && var3.b() == 1 && var6.a() == 2 && var5.a() == 1 && var4.a() == 1 && var3.a() == 2) {
            if(var3.g()) {
               return this.a.a(var1);
            } else if(var6.f()) {
               return this.b.a(var1);
            } else {
               throw new RuntimeException("Cannot dispatch 1001 rule in KanCompactor !");
            }
         } else {
            return false;
         }
      }
   }
}
