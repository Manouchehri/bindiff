package y.f.d;

import y.f.d.a;
import y.f.d.u;
import y.f.d.z;

class y implements y.d.g {
   private final u a;

   y(u var1) {
      this.a = var1;
   }

   public void a(Object var1, Object var2) {
      int var7 = a.f;
      z var3 = (z)var1;
      z var4 = (z)var2;
      y.d.m var5;
      if(var3.c == 1 && var4.c == 1) {
         var5 = (y.d.m)var3.a;
         y.d.m var6 = (y.d.m)var4.a;
         if(y.d.m.a(var5, var6) == null) {
            return;
         }

         ++var3.d;
         ++var4.d;
         if(var7 == 0) {
            return;
         }
      }

      if(var3.c == 1 || var4.c == 1) {
         var5 = (y.d.m)(var3.c == 1?var3.a:var4.a);
         y.d.y var8 = var3.c != 1?var3.h():var4.h();
         if(!var5.a(var8)) {
            return;
         }

         ++var3.d;
         ++var4.d;
         if(var7 == 0) {
            return;
         }
      }

      if(var3.b != var4.a && var4.b != var3.a) {
         ++var3.d;
         ++var4.d;
      }

   }
}
