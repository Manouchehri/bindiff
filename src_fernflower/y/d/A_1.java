package y.d;

import y.c.C;
import y.c.D;
import y.d.e;
import y.d.t;

class A {
   public static D a(D var0) {
      boolean var9 = t.d;
      D var1 = new D(var0.m());
      D var2 = new D();
      var1.o();
      if(var1.isEmpty()) {
         return var2;
      } else {
         t var3 = (t)var1.g();
         var2.b((Object)var3);

         boolean var10000;
         while(true) {
            if(!var1.isEmpty()) {
               var10000 = var3.equals(var1.f());
               if(var9) {
                  break;
               }

               if(var10000) {
                  var1.g();
                  if(!var9) {
                     continue;
                  }
               }
            }

            var10000 = var1.isEmpty();
            break;
         }

         if(var10000) {
            return var2;
         } else {
            var3 = (t)var1.g();
            y.c.p var4 = var2.b((Object)var3);
            C var6 = var1.m();

            while(var6.f()) {
               label76: {
                  t var5 = (t)var6.d();
                  if(!var5.equals(var3)) {
                     label94: {
                        var3 = var5;
                        if(var2.size() == 2 && e.d((t)var2.f(), (t)var2.i(), var5)) {
                           var4.a(var5);
                           if(!var9) {
                              break label94;
                           }
                        }

                        y.c.p var7 = var4;

                        while(!e.c((t)var2.f(var7).c(), (t)var7.c(), var5)) {
                           var7 = var2.f(var7);
                           if(var9) {
                              break label76;
                           }

                           if(var9) {
                              break;
                           }
                        }

                        y.c.p var8 = var4;

                        label59: {
                           while(!e.b((t)var2.e(var8).c(), (t)var8.c(), var5)) {
                              var8 = var2.e(var8);
                              if(var9) {
                                 break label59;
                              }

                              if(var9) {
                                 break;
                              }
                           }

                           while(var8 != var2.e(var7)) {
                              var2.h(var2.e(var7));
                              if(var9) {
                                 break label76;
                              }

                              if(var9) {
                                 break;
                              }
                           }
                        }

                        var4 = var2.b((Object)var5, var7);
                     }
                  }

                  var6.g();
               }

               if(var9) {
                  break;
               }
            }

            return var2;
         }
      }
   }
}
