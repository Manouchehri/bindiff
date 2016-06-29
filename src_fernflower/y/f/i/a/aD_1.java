package y.f.i.a;

import java.util.Iterator;
import java.util.List;
import y.f.i.a.I;
import y.f.i.a.K;
import y.f.i.a.Z;
import y.f.i.a.aE;
import y.f.i.a.aF;
import y.f.i.a.ab;

class aD extends K {
   public void a(Z var1, I var2) {
      int var17 = ab.a;
      super.a(var1, var2);
      y.f.X var3 = var1.a();
      y.c.c var4 = var3.c(y.f.ay.a);
      y.c.c var5 = var3.c(y.f.ax.a);
      y.c.c var6 = var3.c(y.f.ax.b);
      if(var3.c(y.f.aF.a) != null || var3.c(y.f.aF.b) != null || var4 != null || var5 != null || var6 != null) {
         y.c.e var7 = var3.p();

         label141:
         while(true) {
            boolean var10000 = var7.f();

            label138:
            while(true) {
               y.c.q var9;
               y.c.q var10;
               y.c.D var11;
               y.c.D var12;
               label147: {
                  if(!var10000) {
                     return;
                  }

                  y.c.d var8 = var7.a();
                  var9 = var8.c();
                  var10 = var8.d();
                  var11 = new y.c.D();
                  var12 = new y.c.D();
                  if(this.a(var3, var8)) {
                     y.f.aE var13 = y.f.aE.d(var3, var8);
                     if(var13 != null) {
                        var11.add(this.a(var13, var3, var8, true));
                     }

                     y.f.aE var14 = y.f.aE.e(var3, var8);
                     if(var14 == null) {
                        break label147;
                     }

                     var12.add(this.a(var14, var3, var8, false));
                     if(var17 == 0) {
                        break label147;
                     }
                  }

                  if(this.b(var3, var8)) {
                     List var18;
                     if(var5 != null && var5.b(var8) != null) {
                        var18 = (List)var5.b(var8);
                        if(!var18.isEmpty()) {
                           var11.addAll(var18);
                        }
                     }

                     if(var6 == null || var6.b(var8) == null) {
                        break label147;
                     }

                     var18 = (List)var6.b(var8);
                     if(var18.isEmpty()) {
                        break label147;
                     }

                     var12.addAll(var18);
                     if(var17 == 0) {
                        break label147;
                     }
                  }

                  if(this.c(var3, var8)) {
                     label155: {
                        y.f.ax var15;
                        y.f.ay var19;
                        Iterator var20;
                        if(var4 != null && var4.b(var9) != null) {
                           var19 = (y.f.ay)var4.b(var9);
                           var20 = var19.a();

                           while(var20.hasNext()) {
                              var15 = ((y.f.aA)var20.next()).a();
                              var11.add(var15);
                              if(var17 != 0) {
                                 break label155;
                              }

                              if(var17 != 0) {
                                 break;
                              }
                           }
                        }

                        if(var4 != null && var4.b(var10) != null) {
                           var19 = (y.f.ay)var4.b(var10);
                           var20 = var19.a();

                           while(var20.hasNext()) {
                              var15 = ((y.f.aA)var20.next()).a();
                              var12.add(var15);
                              if(var17 != 0) {
                                 continue label141;
                              }

                              if(var17 != 0) {
                                 break;
                              }
                           }
                        }
                     }
                  }
               }

               Iterator var21 = var11.iterator();

               y.d.y var16;
               y.f.ax var22;
               y.d.t var23;
               while(true) {
                  if(var21.hasNext()) {
                     var22 = (y.f.ax)var21.next();
                     if(!var22.b()) {
                        continue;
                     }

                     var10000 = this.a(var3, var9, var22);
                     if(var17 != 0) {
                        break;
                     }

                     if(!var10000) {
                        continue;
                     }

                     var23 = a(var22, var9);
                     var16 = new y.d.y(var23.a() - 0.5D, var23.b() - 0.5D, 1.0D, 1.0D);
                     this.b().a((y.d.y)var16, (Object)(new aF((aE)null)));
                     if(var17 == 0) {
                        continue;
                     }
                  }

                  var21 = var12.iterator();
                  var10000 = var21.hasNext();
                  break;
               }

               while(true) {
                  if(!var10000) {
                     break label138;
                  }

                  var22 = (y.f.ax)var21.next();
                  if(var22.b()) {
                     var10000 = this.a(var3, var10, var22);
                     if(var17 != 0) {
                        break;
                     }

                     if(var10000) {
                        var23 = a(var22, var10);
                        var16 = new y.d.y(var23.a() - 0.5D, var23.b() - 0.5D, 1.0D, 1.0D);
                        this.b().a((y.d.y)var16, (Object)(new aF((aE)null)));
                        if(var17 != 0) {
                           break label138;
                        }
                     }
                  }

                  var10000 = var21.hasNext();
               }
            }

            var7.g();
            if(var17 != 0) {
               return;
            }
         }
      }
   }

   private boolean a(y.f.X var1, y.c.d var2) {
      return y.f.aE.a(var1, var2);
   }

   private boolean b(y.f.X var1, y.c.d var2) {
      y.c.c var3 = var1.c(y.f.ax.a);
      y.c.c var4 = var1.c(y.f.ax.b);
      return var3 != null && var3.b(var2) != null || var4 != null && var4.b(var2) != null;
   }

   private boolean c(y.f.X var1, y.c.d var2) {
      y.c.c var3 = var1.c(y.f.ay.a);
      return var3 != null && (var3.b(var2.c()) != null || var3.b(var2.d()) != null);
   }

   static y.d.t a(y.f.ax var0, y.c.q var1) {
      y.f.X var2 = (y.f.X)var1.e();
      y.d.t var3 = var2.l(var1);
      double var4 = var3.a() + var0.c();
      double var6 = var3.b() + var0.d();
      return new y.d.t(var4, var6);
   }

   private boolean a(y.f.X var1, y.c.q var2, y.f.ax var3) {
      y.f.am var4 = var1.a((Object)var2);
      y.d.y var5 = new y.d.y(var4.getX() - 1.0E-6D, var4.getY() - 1.0E-6D, var4.getWidth() + 2.0E-6D, var4.getHeight() + 2.0E-6D);
      y.d.t var6 = var1.l(var2);
      y.d.t var7 = new y.d.t(var6.a() + var3.c(), var6.b() + var3.d());
      return !y.d.y.a(var5.c(), var5.d(), var5.a(), var5.b(), var7.a(), var7.b(), true);
   }

   private y.f.ax a(y.f.aE var1, y.f.X var2, y.c.d var3, boolean var4) {
      y.d.t var5 = var4?var2.n(var3):var2.o(var3);
      return var1.a()?y.f.ax.a(var5.a(), var5.b(), var1.b()):y.f.ax.a(var1);
   }
}
