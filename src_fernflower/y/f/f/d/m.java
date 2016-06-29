package y.f.f.d;

import y.f.f.d.b;
import y.f.f.d.g;
import y.f.f.d.k;
import y.f.f.d.o;
import y.f.f.d.p;

class m implements k {
   private final g a;

   m(g var1) {
      this.a = var1;
   }

   public boolean a(y.c.D var1) {
      boolean var13 = o.p;
      if(var1.size() < 4) {
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
         if(var6.b() == 1 && var5.b() == 0 && var4.b() == 0) {
            var1.j();
            var1.j();
            var1.j();
            var1.j();
            b var7 = new b(var6.d(), var4.e(), 0, var4.c(), 2);
            var1.add(var7);
            var1.add(var3);
            p var8 = var6.d();
            p var9 = var3.e();
            p var10 = var6.e();
            p var11 = var4.e();
            p var12 = var5.e();
            if(var6.c().a(y.f.f.b.o.d)) {
               p.a(g.a(this.a), var8, var9, 1);
               p.a(g.a(this.a), var12, var8, 1);
               p.a(g.b(this.a), var10, var11, 1);
               if(!var13) {
                  return true;
               }
            }

            if(var6.c().a(y.f.f.b.o.b)) {
               p.a(g.a(this.a), var9, var8, 1);
               p.a(g.a(this.a), var8, var12, 1);
               p.a(g.b(this.a), var11, var10, 1);
               if(!var13) {
                  return true;
               }
            }

            if(var6.c().a(y.f.f.b.o.c)) {
               p.a(g.b(this.a), var9, var8, 1);
               p.a(g.b(this.a), var8, var12, 1);
               p.a(g.a(this.a), var10, var11, 1);
               if(!var13) {
                  return true;
               }
            }

            if(var6.c().a(y.f.f.b.o.a)) {
               p.a(g.b(this.a), var8, var9, 1);
               p.a(g.b(this.a), var12, var8, 1);
               p.a(g.a(this.a), var11, var10, 1);
               if(!var13) {
                  return true;
               }
            }

            y.g.o.a((Object)"Consistency Error in rect decomp.");
            return true;
         } else {
            return false;
         }
      }
   }
}
