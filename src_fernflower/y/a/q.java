package y.a;

import y.a.h;
import y.a.r;
import y.a.s;
import y.a.t;

public class q {
   public static y.c.f a(y.c.i var0, y.c.q var1, y.c.q var2, boolean var3) {
      boolean var9 = h.a;
      y.c.f var4 = new y.c.f();
      y.c.A var5 = var0.t();
      r var6 = new r(var5);
      var6.a(var3);
      var6.b(false);
      var6.a(var0, var1);
      y.c.d var7 = (y.c.d)var5.b(var2);
      if(var7 != null) {
         var4.c(var7);
         y.c.q var8 = var7.a(var2);

         while(var5.b(var8) != null) {
            var7 = (y.c.d)var5.b(var8);
            if(var7 != null) {
               var8 = var7.a(var8);
               var4.c(var7);
               if(var9) {
                  return var4;
               }

               if(var9) {
                  break;
               }
            }
         }

         if(var8 != var1) {
            var4.clear();
         }
      }

      var0.a(var5);
      return var4;
   }

   public static y.c.f a(y.c.i var0) {
      boolean var8 = h.a;
      t[] var1 = new t[var0.f()];
      int var2 = 0;

      while(var2 < var1.length) {
         var1[var2] = new t((r)null);
         ++var2;
         if(var8) {
            break;
         }
      }

      s var9 = new s(var1);
      var9.a(false);
      var9.a(var0);
      int var3 = -1;
      y.c.q var4 = null;
      y.c.x var5 = var0.o();

      y.c.q var6;
      while(var5.f()) {
         var6 = var5.e();
         t var7 = var1[var6.d()];
         if(var7.c + var7.d > var3) {
            var3 = var7.c + var7.d;
            var4 = var6;
         }

         var5.g();
         if(var8) {
            break;
         }
      }

      y.c.f var10 = new y.c.f();
      var6 = var4;
      y.c.d var11 = var1[var4.d()].a;

      while(true) {
         if(var11 != null) {
            var10.a(var11);
            var6 = var11.a(var6);
            var11 = var1[var6.d()].a;
            if(var8) {
               break;
            }

            if(!var8) {
               continue;
            }
         }

         var6 = var4;
         break;
      }

      var11 = var1[var6.d()].b;

      y.c.f var10000;
      while(true) {
         if(var11 != null) {
            var10000 = var10;
            if(var8) {
               break;
            }

            var10.b(var11);
            var6 = var11.a(var6);
            var11 = var1[var6.d()].a;
            if(!var8) {
               continue;
            }
         }

         var10000 = var10;
         break;
      }

      return var10000;
   }
}
