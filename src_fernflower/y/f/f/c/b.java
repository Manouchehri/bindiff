package y.f.f.c;

import y.c.C;
import y.c.D;
import y.f.f.c.c;
import y.f.f.c.d;
import y.f.f.c.e;
import y.f.f.c.g;
import y.f.f.c.h;
import y.f.f.c.k;
import y.f.f.c.l;
import y.f.f.c.n;
import y.f.f.c.p;
import y.f.f.c.q;

public class b implements l {
   private int a = 1;

   public void a(int var1) {
      this.a = var1;
   }

   public void a(y.f.f.b.h var1, p var2, p var3) {
      int var10 = g.a;
      q var4 = new q(var2, var3);
      var4.a(var1);
      int var5 = Integer.MAX_VALUE;
      byte var6 = 0;
      byte var7 = 1;
      int var8 = 0;
      boolean var9 = true;

      while(var9) {
         y.g.o.a(this, "New Iteration: " + var7);
         var9 = false;
         switch(var7) {
         case 0:
            var6 = 1;
            this.a(var1, var2, y.f.f.b.o.b);
            var8 = q.a(var1, var2, var3);
            if(var8 < var5) {
               var9 = true;
            }

            var5 = var8;
            if(var10 == 0) {
               break;
            }
         case 1:
            var6 = 0;
            this.a(var1, var3, y.f.f.b.o.c);
            var8 = q.a(var1, var2, var3);
            if(var8 < var5) {
               var9 = true;
            }

            var5 = var8;
         }

         var7 = var6;
         y.g.o.a(this, "Total Edge Length: " + var8);
         if(var10 != 0) {
            break;
         }
      }

   }

   public void a(y.f.f.b.h var1, p var2, y.f.f.b.o var3) {
      int var12 = g.a;
      var2.b();
      D var4 = this.a(var2.e());
      C var5 = var4.m();
      e var7 = new e(var2);

      int var10000;
      while(true) {
         if(var5.f()) {
            d var6 = (d)var5.d();
            var10000 = var6.b();
            if(var12 != 0) {
               break;
            }

            switch(var10000) {
            case 0:
               g var8 = var6.c();
               g[] var9 = var7.a(var8);
               g var10 = var9[0];
               g var11 = var9[1];
               if(var10 != null && var10.i() != var8.i() && !a(var1, var10, var8)) {
                  var2.a(var10, var8, 1);
               }

               if(var11 == null || var8.i() == var11.i() || a(var1, var8, var11)) {
                  break;
               }

               var2.a(var8, var11, 1);
               if(var12 == 0) {
                  break;
               }
            case 1:
               var7.b(var6.c());
            }

            var5.g();
            if(var12 == 0) {
               continue;
            }
         }

         var10000 = this.a;
         break;
      }

      switch(var10000) {
      case 0:
         k var13 = new k();
         var13.a(var2);
         if(var12 == 0) {
            break;
         }
      case 1:
         h var14 = new h();
         var14.a(var2);
         if(var12 == 0) {
            break;
         }
      case 2:
         n var15 = new n();
         var15.a(true);
         var15.a(var2);
      }

   }

   protected D a(C var1) {
      int var6 = g.a;
      D var2 = new D();

      while(true) {
         if(var1.f()) {
            g var3 = (g)var1.d();
            d var4 = new d((double)var3.d().i(), 0, var3);
            d var5 = new d((double)var3.e().i(), 1, var3);
            var2.add(var4);
            var2.add(var5);
            var1.g();
            if(var6 != 0) {
               break;
            }

            if(var6 == 0) {
               continue;
            }
         }

         var2.sort(new c(this));
         break;
      }

      return var2;
   }

   protected static boolean a(y.f.f.b.h var0, g var1, g var2) {
      y.c.d var3;
      if(var1.e() == var2.d()) {
         var3 = var1.g().a(var2.f());
         return var3 != null;
      } else if(var2.e() == var1.d()) {
         var3 = var2.g().a(var1.f());
         return var3 != null;
      } else {
         return false;
      }
   }
}
