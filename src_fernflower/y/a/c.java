package y.a;

import y.a.d;
import y.a.h;
import y.a.m;

public class c {
   public static void a(y.c.i param0, y.c.h param1, y.c.c param2) {
      // $FF: Couldn't be decompiled
   }

   public static void a(y.c.i var0, y.c.h var1) {
      boolean var5 = h.a;
      int[] var2 = new int[var0.e()];
      m.b(var0, var2);
      y.c.e var3 = var0.p();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         var1.a(var4, false);
         if(var2[var4.c().d()] < var2[var4.d().d()]) {
            var1.a(var4, true);
         }

         var3.g();
         if(var5) {
            break;
         }
      }

   }

   public static y.c.f a(y.c.i var0, boolean var1) {
      y.c.f var2 = new y.c.f();
      d var3 = new d(var2);
      var3.a(var1);
      var3.a(var0);
      return var2;
   }
}
