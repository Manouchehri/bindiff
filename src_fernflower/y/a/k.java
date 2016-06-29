package y.a;

import y.a.h;

public class k {
   public static y.c.y[] a(y.c.i var0) {
      boolean var5 = h.a;
      y.c.D var1 = new y.c.D();
      y.g.I var2 = new y.g.I(var0);

      Object var10000;
      while(true) {
         if(!var0.i()) {
            y.c.y var3 = b(var0);
            var1.add(var3);
            var10000 = var3;
            if(var5) {
               break;
            }

            y.c.x var4 = var3.a();

            label27: {
               while(var4.f()) {
                  var2.a(var4.e().j());
                  var4.g();
                  if(var5) {
                     break label27;
                  }

                  if(var5) {
                     break;
                  }
               }

               var2.a(var3);
            }

            if(!var5) {
               continue;
            }
         }

         var2.f();
         var10000 = var1;
         break;
      }

      return (y.c.y[])((y.c.D)var10000).toArray(new y.c.y[var1.size()]);
   }

   public static y.c.y b(y.c.i var0) {
      boolean var10 = h.a;
      y.c.y var1 = new y.c.y();
      y.g.a.d var2 = new y.g.a.d(var0);
      y.c.x var3 = var0.o();

      y.c.q var4;
      while(var3.f()) {
         var4 = var3.e();
         var2.a(var4, var4.a());
         var3.g();
         if(var10) {
            break;
         }
      }

      y.c.A var11 = y.g.M.a(new boolean[var0.f()]);

      label74:
      while(true) {
         boolean var10000 = var2.a();

         label72:
         while(!var10000) {
            var4 = var2.c();
            var1.add(var4);
            var11.a(var4, true);
            y.c.x var5 = var4.m();

            label70:
            while(true) {
               var10000 = var5.f();

               y.c.q var6;
               label67:
               while(true) {
                  if(var10000) {
                     var6 = var5.e();
                     var10000 = var11.d(var6);
                     if(var10) {
                        break;
                     }

                     if(!var10000) {
                        y.c.x var7 = var6.m();

                        while(var7.f()) {
                           y.c.q var8 = var7.e();
                           var10000 = var11.d(var8);
                           if(var10) {
                              continue label67;
                           }

                           if(!var10000) {
                              int var9 = var2.b(var8);
                              var2.b(var8, var9 - 1);
                           }

                           var7.g();
                           if(var10) {
                              break;
                           }
                        }
                     }

                     var5.g();
                     if(!var10) {
                        continue label70;
                     }
                  }

                  var5 = var4.m();
                  var10000 = var5.f();
                  break;
               }

               while(true) {
                  if(!var10000) {
                     continue label74;
                  }

                  var6 = var5.e();
                  var10000 = var11.d(var6);
                  if(var10) {
                     continue label72;
                  }

                  if(!var10000) {
                     var2.c(var6);
                     var11.a(var6, true);
                  }

                  var5.g();
                  if(var10) {
                     return var1;
                  }

                  var10000 = var5.f();
               }
            }
         }

         return var1;
      }
   }
}
