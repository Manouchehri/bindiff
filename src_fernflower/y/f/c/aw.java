package y.f.c;

import y.f.c.K;
import y.f.c.a;
import y.f.c.ao;

class aw implements ao {
   public void a(y.f.X var1, y.c.A var2, y.c.A var3) {
      boolean var5 = a.i;
      y.c.p var4 = var1.E().l();

      while(var4 != null) {
         this.a(var1, (y.c.d)var4.c(), var2, var3);
         var4 = var4.b();
         if(var5) {
            break;
         }
      }

   }

   public y.c.q a(y.f.X var1, y.c.d var2, y.c.A var3, y.c.A var4) {
      boolean var12 = a.i;
      y.c.q var5 = var2.c();
      y.c.q var6 = var2.d();
      int var7 = var3.a(var6) - var3.a(var5);
      if(var7 <= 1) {
         return null;
      } else {
         y.c.A var8 = K.a((y.c.i)var1);
         y.c.q var9 = null;
         y.c.d var10 = null;
         y.c.q var11 = var5;

         y.c.q var10000;
         while(true) {
            if(var7 > 1) {
               var9 = var1.d();
               var8.a(var9, K.q);
               var1.b(var9, 1.0D, 1.0D);
               var1.b(var9, y.d.t.c);
               var10 = var1.a((y.c.q)var11, (y.c.q)var9);
               var10000 = var11;
               if(var12) {
                  break;
               }

               if(var11 == var5) {
                  var1.a(var10, var1.n(var2));
               }

               var3.a(var9, var3.a(var11) + 1);
               var4.a(var9, var2);
               var11 = var9;
               --var7;
               if(!var12) {
                  continue;
               }
            }

            var10 = var1.a((y.c.q)var9, (y.c.q)var6);
            var1.b(var10, var1.o(var2));
            var1.d(var2);
            var10000 = var9;
            break;
         }

         return var10000;
      }
   }

   public void b(y.f.X var1, y.c.A var2, y.c.A var3) {
      boolean var12 = a.i;
      y.c.x var4 = var1.o();

      while(true) {
         if(var4.f()) {
            y.c.q var5 = var4.e();
            y.c.d var6 = (y.c.d)var3.b(var5);
            if(!var12) {
               if(var6 != null && !var1.f(var6)) {
                  y.c.q var7 = var5.g().c();

                  while(true) {
                     if(var3.b(var7) != null) {
                        var5 = var7;
                        var7 = var7.g().c();
                        if(var12) {
                           break;
                        }

                        if(!var12) {
                           continue;
                        }

                        var1.e(var6);
                        break;
                     }

                     var1.e(var6);
                     break;
                  }

                  y.c.d var8 = var5.g();
                  y.c.D var9 = new y.c.D();

                  boolean var10000;
                  y.d.t var11;
                  while(true) {
                     y.d.t var10;
                     if(var3.b(var8.d()) != null) {
                        var10 = var1.p(var8);
                        var9.add(var10);
                        var9.a(var1.k(var8));
                        var11 = var1.q(var8);
                        var10000 = var11.equals(var10);
                        if(var12) {
                           break;
                        }

                        if(!var10000) {
                           var9.add(var11);
                        }

                        var8 = var8.d().f();
                        if(!var12) {
                           continue;
                        }
                     }

                     var10 = var1.p(var8);
                     var9.add(var10);
                     var9.a(var1.k(var8));
                     var11 = var1.q(var8);
                     var10000 = var11.equals(var10);
                     break;
                  }

                  if(!var10000) {
                     var9.add(var11);
                  }

                  var1.a(var6, var9);
               }

               var4.g();
               if(!var12) {
                  continue;
               }

               var4 = var1.o();
            } else {
               if(var6 != null) {
                  var1.a((y.c.q)var4.e());
               }

               var4.g();
               if(var12) {
                  return;
               }
            }
         } else {
            var4 = var1.o();
         }

         do {
            if(!var4.f()) {
               return;
            }

            if(var3.b(var4.e()) != null) {
               var1.a((y.c.q)var4.e());
            }

            var4.g();
         } while(!var12);

         return;
      }
   }
}
