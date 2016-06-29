package y.f.c.a;

import y.f.c.a.A;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;

final class cq {
   public void a(y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var10 = N.x;
      y.c.d[] var5 = var1.n();
      int var6 = 0;

      while(var6 < var5.length) {
         y.c.d var7 = var5[var6];
         aX var8 = var3.a(var7.c());
         aX var9 = var3.a(var7.d());
         if(var9.j() - var8.j() > 1) {
            this.a(var1, var7, var2, var3, var4, false);
         }

         ++var6;
         if(var10) {
            break;
         }
      }

   }

   public void a(y.f.X var1, aV var2) {
      boolean var11 = N.x;
      y.c.x var3 = var1.o();

      while(true) {
         if(var3.f()) {
            y.c.q var4 = var3.e();
            aX var5 = var2.a(var4);
            byte var10000 = var5.b();
            if(!var11) {
               if(var10000 == 1 && !var1.f(var5.g())) {
                  y.c.q var6 = var4.g().c();

                  while(true) {
                     if(var2.a(var6).b() == 1) {
                        var4 = var6;
                        var6 = var6.g().c();
                        if(var11) {
                           break;
                        }

                        if(!var11) {
                           continue;
                        }
                     }

                     var1.e(var5.g());
                     break;
                  }

                  y.c.d var7 = var4.g();
                  y.c.D var8 = new y.c.D();

                  y.d.t var10;
                  boolean var12;
                  while(true) {
                     y.d.t var9;
                     if(var2.a(var7.d()).b() == 1) {
                        var9 = var1.p(var7);
                        var8.add(var9);
                        var8.a(var1.k(var7));
                        var10 = var1.q(var7);
                        var12 = var10.equals(var9);
                        if(var11) {
                           break;
                        }

                        if(!var12) {
                           var8.add(var10);
                        }

                        var7 = var7.d().f();
                        if(!var11) {
                           continue;
                        }
                     }

                     var9 = var1.p(var7);
                     var8.add(var9);
                     var8.a(var1.k(var7));
                     var10 = var1.q(var7);
                     var12 = var10.equals(var9);
                     break;
                  }

                  if(!var12) {
                     var8.add(var10);
                  }

                  var1.a(var5.g(), var8);
               }

               var3.g();
               if(!var11) {
                  continue;
               }

               var3 = var1.o();
            } else {
               if(var10000 == 1) {
                  var1.a((y.c.q)var3.e());
               }

               var3.g();
               if(var11) {
                  return;
               }
            }
         } else {
            var3 = var1.o();
         }

         do {
            if(!var3.f()) {
               return;
            }

            if(var2.a(var3.e()).b() == 1) {
               var1.a((y.c.q)var3.e());
            }

            var3.g();
         } while(!var11);

         return;
      }
   }

   public y.c.f a(y.f.X var1, y.c.d var2, aU var3, aV var4, aP var5, boolean var6) {
      boolean var16 = N.x;
      aX var7 = var4.a(var2.c());
      aX var8 = var4.a(var2.d());
      A var9 = var4.a(var2);
      if(var7.j() + 1 >= var8.j()) {
         return null;
      } else {
         y.c.f var10 = null;
         if(var6) {
            var10 = new y.c.f();
         }

         y.c.c var11 = var1.c("com.yworks.yfiles.bpmn.layout.BpmnLayouter.ASSIGN_DUMMIES_TO_SOURCE_LANE");
         y.c.q var12 = var2.c();
         int var13 = var7.j() + 1;

         while(var13 < var8.j()) {
            y.c.q var14;
            label57: {
               if(var11 != null) {
                  if(var11.d(var2)) {
                     var14 = var5.a(var3.a(var13), var2, var9.i()?var8.h():var7.h());
                     if(!var16) {
                        break label57;
                     }
                  }

                  var14 = var5.a(var3.a(var13), var2, var9.i()?var7.h():var8.h());
                  if(!var16) {
                     break label57;
                  }
               }

               var14 = var5.a(var3.a(var13), var2);
            }

            y.c.d var15 = var5.a(var12, var14, var2, var12 == var2.c(), false);
            if(var10 != null) {
               var10.b(var15);
            }

            var12 = var14;
            ++var13;
            if(var16) {
               break;
            }
         }

         y.c.d var17 = var5.a(var12, var2.d(), var2, false, true);
         if(var10 != null) {
            var10.b(var17);
         }

         if(var1.f(var2)) {
            var1.d(var2);
         }

         return var10;
      }
   }
}
