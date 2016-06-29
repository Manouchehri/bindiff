package y.f.f.c;

import y.c.A;
import y.c.x;
import y.f.f.c.g;
import y.f.f.c.i;
import y.f.f.c.j;
import y.f.f.c.l;
import y.f.f.c.o;
import y.f.f.c.p;
import y.g.M;

public class h implements l {
   public void a(y.f.f.b.h var1, p var2, p var3) {
      y.g.o.a(this, 3, "Flow Compaction");
      this.a(var2);
      this.a(var3);
   }

   public void a(p var1) {
      int var15 = g.a;
      y.c.i var2 = var1.f();
      int[] var3 = new int[var2.f()];
      y.c.h var4 = var2.u();
      y.c.f var5 = new y.c.f();
      int var6 = 0;
      y.c.e var7 = var2.p();

      int var10001;
      while(true) {
         if(var7.f()) {
            y.c.d var8 = var7.a();
            var4.a(var8, (int)var1.b(var8));
            int var9 = var1.c(var8);
            var10001 = var8.c().d();
            var3[var10001] -= var9;
            var10001 = var8.d().d();
            var3[var10001] += var9;
            var6 += var9;
            var7.g();
            if(var15 != 0) {
               break;
            }

            if(var15 == 0) {
               continue;
            }

            y.c.i.g = !y.c.i.g;
         }

         y.g.o.a(this, "Total weight: " + var6);
         break;
      }

      int var16 = var6 + 1;
      x var17 = var2.o();

      while(true) {
         if(var17.f()) {
            y.c.q var18 = var17.e();
            var10001 = var18.d();
            var3[var10001] += var16 * var18.c() - var16 * var18.b();
            var17.g();
            if(var15 != 0) {
               break;
            }

            if(var15 == 0) {
               continue;
            }
         }

         var17 = var2.o();
         break;
      }

      while(var17.f()) {
         g var20 = var1.b(var17.e());
         o var10 = var1.a(var20);
         if(var10 != null && var10.a() == var20) {
            y.c.d var11 = var2.a(var10.b().a(), var10.a().a());
            var4.a(var11, (int)var10.c());
            var5.add(var11);
         }

         var17.g();
         if(var15 != 0) {
            break;
         }
      }

      i var19 = new i(this, var16);
      j var21 = new j(this);
      A var22 = M.a(var3);
      y.c.h var23 = var2.u();
      A var12 = var2.t();
      y.a.l.a(var2, (y.c.c)var21, (y.c.c)var19, var4, var22, var23, var12);
      x var13 = var2.o();

      while(var13.f()) {
         g var14 = var1.b(var13.e());
         var14.a(var12.a(var13.e()));
         var13.g();
         if(var15 != 0) {
            break;
         }
      }

      y.c.e var24 = var5.a();

      while(true) {
         if(var24.f()) {
            var2.a(var24.a());
            var24.g();
            if(var15 != 0) {
               break;
            }

            if(var15 == 0) {
               continue;
            }
         }

         var2.a(var4);
         var2.a(var23);
         var2.a(var12);
         break;
      }

   }
}
