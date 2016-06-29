package y.f.f.c;

import y.c.A;
import y.c.x;
import y.f.f.c.g;
import y.f.f.c.l;
import y.f.f.c.o;
import y.f.f.c.p;

public class k implements l {
   public void a(y.f.f.b.h var1, p var2, p var3) {
      y.g.o.a(this, 3, "SSP Compaction");
      y.g.o.a(this, 3, "Vertical: ");
      this.a(var2);
      y.g.o.a(this, 3, "Horizontal: ");
      this.a(var3);
   }

   public void a(p var1) {
      int var16 = g.a;
      y.c.i var2 = var1.f();
      A var3 = var2.t();
      int[] var4 = new int[var2.e()];
      y.a.m.a(var2, var4);
      y.c.q[] var5 = new y.c.q[var2.f()];
      x var6 = var2.o();

      y.c.q var7;
      while(var6.f()) {
         var7 = var6.e();
         var3.a(var7, 0.0D);
         var5[var4[var7.d()]] = var7;
         var6.g();
         if(var16 != 0) {
            break;
         }
      }

      int var17 = 0;

      label54:
      while(true) {
         int var10000 = var17;

         label51:
         while(var10000 < var5.length) {
            var7 = var5[var17];
            double var8 = var3.c(var7);
            var1.b(var7).a((int)var8);
            if(var16 != 0) {
               return;
            }

            if(var8 > 100000.0D) {
               throw new RuntimeException("Compaction did not terminate ...");
            }

            g var10 = var1.b(var7);
            o var11 = var1.a(var10);
            if(var11 != null && var11.b() == var10) {
               y.c.q var12 = var11.a().a();
               if(var3.c(var12) < var8 - var11.c()) {
                  var3.a(var12, var8 - var11.c());
                  var17 = var4[var12.d()];
                  if(var16 == 0) {
                     continue label54;
                  }
               }
            }

            y.c.e var18 = var7.l();

            while(var18.f()) {
               y.c.d var13 = var18.a();
               double var14 = var1.b(var13);
               double var19;
               var10000 = (var19 = var8 + var14 - var3.c(var13.d())) == 0.0D?0:(var19 < 0.0D?-1:1);
               if(var16 != 0) {
                  continue label51;
               }

               if(var10000 > 0) {
                  var3.a(var13.d(), var8 + var14);
               }

               var18.g();
               if(var16 != 0) {
                  break;
               }
            }

            ++var17;
            if(var16 == 0) {
               continue label54;
            }
            break;
         }

         var2.a(var3);
         return;
      }
   }
}
