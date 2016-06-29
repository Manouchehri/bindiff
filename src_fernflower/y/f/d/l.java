package y.f.d;

import y.f.Q;
import y.f.d.a;
import y.f.d.i;
import y.f.d.j;

class l implements y.d.g {
   private final i a;

   l(i var1) {
      this.a = var1;
   }

   public void a(Object var1, Object var2) {
      int var12 = a.f;
      j var3 = (j)var1;
      j var4 = (j)var2;
      j var5 = null;
      j var6 = null;
      if(var3.c() == 2) {
         var5 = var3;
         var6 = var4;
      } else if(var4.c() == 2) {
         var5 = var4;
         var6 = var3;
      }

      if(var5 != null) {
         Q var7 = var5.d();
         if(var6.c() == 0) {
            if(var5.a() == null || var5.a() == var6.a()) {
               return;
            }

            this.a.a(var7, (y.c.q)var6.a(), var6.h());
            if(var12 == 0) {
               return;
            }
         }

         if(var6.c() == 2) {
            Q var8 = var6.d();
            y.c.q var9 = (y.c.q)this.a.o.get(var7);
            y.c.q var10 = (y.c.q)this.a.o.get(var8);
            y.c.d var11 = this.a.i.a(var9, var10);
            this.a.a(var7, var8, var11);
            if(var12 == 0) {
               return;
            }
         }

         this.a.a(var7, (y.c.d)var6.a(), (y.d.m)var6.b());
      }

   }
}
