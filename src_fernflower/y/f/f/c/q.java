package y.f.f.c;

import java.util.Iterator;
import y.c.C;
import y.f.f.c.g;
import y.f.f.c.p;

public class q {
   protected y.f.f.b.h a;
   protected p b;
   protected p c;

   public q(p var1, p var2) {
      this.b = var1;
      this.c = var2;
      this.a();
   }

   public void a(y.f.f.b.h var1) {
      this.a = var1;
   }

   private void a() {
      this.a(this.b, this.c);
      this.a(this.c, this.b);
   }

   private void a(p var1, p var2) {
      int var8 = g.a;
      Iterator var3 = var1.d();

      while(var3.hasNext()) {
         g var4 = (g)var3.next();
         C var5 = var4.h().m();
         y.c.q var6 = (y.c.q)var5.d();
         var5.j();
         y.c.q var7 = (y.c.q)var5.d();
         var4.a(var2.a(var6), var2.a(var7));
         if(var8 != 0) {
            break;
         }
      }

   }

   public static int a(y.f.f.b.h var0, p var1, p var2) {
      int var8 = g.a;
      int var3 = 0;
      y.c.e var4 = var0.a().p();

      int var10000;
      while(true) {
         if(var4.f()) {
            y.c.d var5 = var4.a();
            var10000 = var0.h(var5).a(y.f.f.b.o.b);
            if(var8 != 0) {
               break;
            }

            g var6;
            g var7;
            if(var10000 != 0) {
               var6 = var1.a(var5.c());
               var7 = var1.a(var5.d());
               var3 = var3 + var7.i() - var6.i();
            }

            if(var0.h(var5).a(y.f.f.b.o.c)) {
               var6 = var2.a(var5.c());
               var7 = var2.a(var5.d());
               var3 = var3 + var7.i() - var6.i();
            }

            var4.g();
            if(var8 == 0) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }
}
