package y.f.i.a;

import y.f.i.a.aN;
import y.f.i.a.aT;
import y.f.i.a.ab;

class aP implements y.d.g {
   private final y.c.i a;
   private final y.c.h b;
   private final y.c.h c;
   private final y.c.c d;
   private final aN e;

   aP(aN var1, y.c.i var2, y.c.h var3, y.c.h var4, y.c.c var5) {
      this.e = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
   }

   public void a(Object var1, Object var2) {
      int var19 = ab.a;
      aT var3 = (aT)var1;
      aT var4 = (aT)var2;
      if(!var3.a() || !var4.a()) {
         y.c.q var5 = var3.f;
         y.c.q var6 = var4.f;
         int var7 = !var3.a() && !var4.a()?100:10;
         y.c.q var8;
         y.c.d var9;
         y.c.d var10;
         if(var3.f() != null && var3.f() == var4.f()) {
            var8 = this.a.d();
            var9 = this.a.a(var5, var8);
            var10 = this.a.a(var6, var8);
            this.b.a(var9, 0);
            this.c.a(var9, var7);
            this.b.a(var10, 0);
            this.c.a(var10, var7);
            if(var19 == 0) {
               return;
            }
         }

         var8 = this.a.d();
         var9 = this.a.a(var5, var8);
         var10 = this.a.a(var6, var8);
         y.c.q var11 = this.a.d();
         y.c.d var12 = this.a.a(var5, var11);
         y.c.d var13 = this.a.a(var6, var11);
         int var14 = (int)Math.ceil(aN.a(this.e, var3, var4));
         if(var3.i() == var4.i()) {
            double var15 = var4.b() - var3.b();
            double var17 = var4.c() - var3.c();
            if(var3.k() && var15 + var17 > 0.0D || !var3.k() && var15 - var17 > 0.0D) {
               this.b.a(var9, var14);
               this.b.a(var10, 0);
               this.c.a(var10, 10);
               this.c.a(var13, var7);
               if(var19 == 0) {
                  return;
               }
            }

            this.b.a(var10, var14);
            this.b.a(var9, 0);
            this.c.a(var9, 10);
            this.c.a(var12, var7);
            if(var19 == 0) {
               return;
            }
         }

         boolean var20 = this.d.a(var5) < this.d.a(var6);
         if(var3.i() == 3 || var3.i() == 1) {
            if(var20) {
               this.b.a(var9, var14);
               this.b.a(var10, 0);
               this.c.a(var10, 10);
               this.c.a(var13, 100);
               if(var19 == 0) {
                  return;
               }
            }

            this.b.a(var10, var14);
            this.b.a(var9, 0);
            this.c.a(var9, 10);
            this.c.a(var12, 100);
            if(var19 == 0) {
               return;
            }
         }

         if(var3.i() == 2 || var3.i() == 0) {
            if(!var20) {
               this.b.a(var10, var14);
               this.b.a(var9, 0);
               this.c.a(var9, 10);
               this.c.a(var12, 100);
               if(var19 == 0) {
                  return;
               }
            }

            this.b.a(var9, var14);
            this.b.a(var10, 0);
            this.c.a(var10, 10);
            this.c.a(var13, 100);
         }

      }
   }
}
