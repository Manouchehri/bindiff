package y.f.f.c;

import y.a.u;
import y.c.A;
import y.c.x;
import y.f.f.c.g;
import y.f.f.c.k;
import y.f.f.c.l;
import y.f.f.c.o;
import y.f.f.c.p;

public class n implements l {
   private boolean a = false;

   public void a(y.f.f.b.h var1, p var2, p var3) {
      y.g.o.a(this, 3, "Simplex Compaction");
      this.a(var2);
      this.a(var3);
   }

   public void a(boolean var1) {
      this.a = var1;
   }

   public void a(p var1) {
      int var12 = g.a;
      y.c.i var2 = var1.f();
      y.c.h var3 = var2.u();
      y.c.h var4 = var2.u();
      A var5 = var2.t();
      A var6 = var2.t();
      x var7 = var2.o();

      label83:
      while(true) {
         if(var7.f()) {
            var6.a(var7.e(), new y.c.f());
            var7.g();
            if(var12 != 0) {
               break;
            }

            if(var12 == 0) {
               continue;
            }
         }

         y.c.e var13 = var2.p();

         while(var13.f()) {
            var4.a(var13.a(), (int)var1.b(var13.a()));
            var3.a(var13.a(), var1.c(var13.a()));
            var13.g();
            if(var12 != 0) {
               break label83;
            }

            if(var12 != 0) {
               break;
            }
         }

         if(!this.a) {
            k var14 = new k();
            var14.a(var1);
         }
         break;
      }

      var7 = var2.o();

      while(true) {
         if(var7.f()) {
            var5.a(var7.e(), var1.b(var7.e()).i());
            var7.g();
            if(var12 != 0) {
               break;
            }

            if(var12 == 0) {
               continue;
            }
         }

         var7 = var2.o();
         break;
      }

      while(true) {
         if(var7.f()) {
            y.c.q var8 = var7.e();
            g var9 = var1.b(var8);
            o var10 = var1.a(var9);
            if(var12 != 0) {
               break;
            }

            if(var10 != null && var10.a == var9) {
               y.c.d var11 = var8.a(var10.b.a());
               var3.a(var11, 20000);
            }

            var7.g();
            if(var12 == 0) {
               continue;
            }
         }

         u.a(var2, var5, var3, var4);
         break;
      }

      var7 = var2.o();

      while(true) {
         if(var7.f()) {
            g var15 = var1.b(var7.e());
            var15.a(var5.a(var7.e()));
            var7.g();
            if(var12 != 0) {
               break;
            }

            if(var12 == 0) {
               continue;
            }
         }

         var2.a(var5);
         var2.a(var6);
         var2.a(var3);
         var2.a(var4);
         break;
      }

      if(y.c.i.g) {
         ++var12;
         g.a = var12;
      }

   }
}
