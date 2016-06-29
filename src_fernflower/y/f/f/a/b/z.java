package y.f.f.a.b;

import y.f.f.a.b.a;

public class z {
   public static void a(a var0, y.c.h var1, y.c.h var2) {
      boolean var14 = a.c;
      y.c.i var3 = var0.d();
      y.f.f.a.a.p var4 = var0.b();
      y.c.d[] var6 = var3.n();
      int var7 = 0;

      while(var7 < var6.length) {
         boolean var5 = false;
         y.c.d var8 = var6[var7];
         y.c.q var9 = var8.c();
         y.c.q var10 = var8.d();
         y.f.f.a.a.b var11 = var4.a(var9);
         y.f.f.a.a.b var12 = var4.a(var10);
         y.f.f.a.a.b var13;
         if(!var11.d()) {
            var13 = (y.f.f.a.a.b)y.f.f.a.a.n.a((y.f.f.a.a.e)var11);
            var9 = var13.b_();
            var5 = true;
         }

         if(!var12.d()) {
            var13 = (y.f.f.a.a.b)y.f.f.a.a.n.a((y.f.f.a.a.e)var12);
            var10 = var13.b_();
            var5 = true;
         }

         if(var5) {
            y.c.d var15 = var3.a(var9, var10);
            var0.q(var15);
            var0.d(var8, var15);
            if(var1 != null) {
               var1.a(var15, var1.b(var8));
            }

            if(var2 != null) {
               var2.a(var15, var2.b(var8));
            }

            var3.d(var8);
         }

         ++var7;
         if(var14) {
            break;
         }
      }

   }

   public static void a(a var0, y.c.f var1) {
      boolean var7 = a.c;
      y.c.e var2 = var1.a();

      while(var2.f()) {
         label26: {
            y.c.d var3 = var2.a();
            y.c.f var4 = var0.x(var3);
            y.c.d var5;
            if(var4 != null) {
               var5 = (y.c.d)var4.i();
               y.c.d var6 = var0.w(var5);
               if(var6 != null) {
                  a(var0, var0.d(var6), var5.c(), var5.d());
               }

               var5 = (y.c.d)var4.f();
               var6 = var0.w(var5);
               if(var6 == null) {
                  break label26;
               }

               a(var0, var0.d(var6), var5.c(), var5.d());
               if(!var7) {
                  break label26;
               }
            }

            var5 = var0.w(var3);
            if(var5 != null) {
               a(var0, var0.d(var5), var3.c(), var3.d());
            }
         }

         var2.g();
         if(var7) {
            break;
         }
      }

   }

   private static void a(a var0, y.c.f var1, y.c.q var2, y.c.q var3) {
      boolean var5 = a.c;
      y.c.e var4 = var1.a();

      y.c.e var6;
      label56:
      while(true) {
         if(var4.f()) {
            y.c.q var10000 = var4.a().c();
            if(!var5) {
               if(var10000 != var2) {
                  var0.o(var4.a());
                  var4.g();
                  if(!var5) {
                     continue;
                  }
               }
            } else {
               if(var10000 == var2) {
                  var6 = var4;
                  break;
               }

               var4.g();
               if(var5) {
                  var6 = var4;
                  break;
               }
            }
         }

         do {
            if(!var4.f()) {
               var6 = var4;
               break label56;
            }

            var6 = var4;
            if(var5) {
               break label56;
            }

            if(var4.a().c() == var3) {
               var6 = var4;
               break label56;
            }

            var4.g();
         } while(!var5);

         var6 = var4;
         break;
      }

      while(var6.f()) {
         var0.o(var4.a());
         var4.g();
         if(var5) {
            break;
         }

         var6 = var4;
      }

   }
}
