package y.a;

import y.a.h;
import y.a.n;
import y.a.o;

public class m {
   public static boolean a(y.c.i var0, int[] var1) {
      return d(var0, var1);
   }

   public static y.c.y a(y.c.i var0) {
      int[] var1 = new int[var0.e()];
      if(!a(var0, var1)) {
         throw new IllegalArgumentException("Graph is not acyclic");
      } else {
         return c(var0, var1);
      }
   }

   public static void b(y.c.i var0, int[] var1) {
      o.a(new o((n)null), var0, var1);
   }

   public static y.c.y b(y.c.i var0) {
      return o.a(new o((n)null), var0);
   }

   public static y.c.y c(y.c.i var0, int[] var1) {
      boolean var7 = h.a;
      y.c.q[] var2 = new y.c.q[var0.f()];
      boolean var3 = false;
      y.c.x var4 = var0.o();

      while(var4.f()) {
         y.c.q var5 = var4.e();
         int var6 = var5.d();
         var2[var1[var6]] = var5;
         var4.g();
         if(var7) {
            break;
         }
      }

      return new y.c.y(var2);
   }

   public static void a(y.c.y var0, y.c.A var1) {
      boolean var4 = h.a;
      int var2 = 0;
      y.c.x var3 = var0.a();

      while(var3.f()) {
         var1.a(var3.e(), var2);
         var3.g();
         ++var2;
         if(var4) {
            break;
         }
      }

   }

   private static boolean d(y.c.i var0, int[] var1) {
      boolean var8 = h.a;
      int[] var2 = new int[var0.f()];
      y.g.c var3 = new y.g.c(var0.f());
      int var4 = 0;
      y.c.x var5 = var0.o();

      int var10000;
      label56:
      while(true) {
         if(var5.f()) {
            y.c.q var6 = var5.e();
            int var7 = var6.d();
            var10000 = var2[var7] = var6.b();
            if(!var8) {
               if(var10000 == 0) {
                  var3.b(var6);
               }

               var1[var7] = -1;
               var5.g();
               if(!var8) {
                  continue;
               }

               var10000 = var3.e();
            }
         } else {
            var10000 = var3.e();
         }

         while(true) {
            label52:
            while(true) {
               if(var10000 != 0) {
                  break label56;
               }

               y.c.q var9 = (y.c.q)var3.b();
               int var10 = var9.d();
               var1[var10] = var4++;
               y.c.d var11 = var9.f();

               while(var11 != null) {
                  var10000 = --var2[var11.d().d()];
                  if(var8) {
                     return var10000 == var0.f();
                  }

                  if(var8) {
                     continue label52;
                  }

                  if(var10000 == 0) {
                     var3.b(var11.d());
                  }

                  var11 = var11.g();
                  if(var8) {
                     break label56;
                  }
               }

               var10000 = var3.e();
            }
         }
      }

      var10000 = var4;
      return var10000 == var0.f();
   }
}
