package y.f.i;

import java.util.HashSet;
import y.f.i.o;
import y.f.i.p;
import y.f.i.v;

public class n extends y.f.a {
   boolean a = false;
   static final Object b = "GroupNodeRouterStage#GROUP_BORDER_NODE_DBKEY";
   boolean c = true;

   public n() {
   }

   public n(y.f.ah var1) {
      super(var1);
   }

   public void c(y.f.X var1) {
      int var28 = v.f;
      v var2 = this.b();
      y.c.c var3 = var1.c(y.f.b.f.d);
      if(y.f.b.c.c((y.c.i)var1)) {
         this.a().c(var1);
      } else {
         if(var2 != null) {
            boolean var4 = this.c;
            if(var2.k() <= 0.0D) {
               var4 = false;
            }

            y.c.h var5 = var1.u();
            y.c.h var6 = var1.u();
            y.c.f var7 = new y.c.f();
            y.c.y var8 = new y.c.y();
            y.c.A var9 = var1.t();
            if(var4) {
               var1.a((Object)b, (y.c.c)var9);
            }

            y.f.b.c var10 = new y.f.b.c(var1);
            HashSet var11 = new HashSet();
            Object var12 = var1.o();

            y.c.c var10000;
            boolean var35;
            label295: {
               while(((y.c.x)var12).f()) {
                  y.c.q var13 = ((y.c.x)var12).e();
                  var10000 = var3;
                  if(var28 != 0) {
                     break label295;
                  }

                  if(var3.d(var13)) {
                     y.c.e var14 = var13.j();

                     label288: {
                        while(var14.f()) {
                           y.c.d var15 = var14.a();
                           var35 = var11.add(var15);
                           if(var28 != 0) {
                              break label288;
                           }

                           if(var35) {
                              var7.add(var15);
                           }

                           var14.g();
                           if(var28 != 0) {
                              break;
                           }
                        }

                        var8.add(var13);
                        var35 = var4;
                     }

                     if(var35) {
                        y.c.q var30 = var1.d();
                        y.f.am var32 = var1.h(var13);
                        var1.b(var30, (double)var2.t(), (double)var2.t());
                        var1.a(var30, var32.getX(), var32.getY());
                        y.c.D var16 = new y.c.D();
                        var16.add(new y.d.t(var32.getX() + var32.getWidth(), var32.getY()));
                        var16.add(new y.d.t(var32.getX() + var32.getWidth(), var32.getY() + var32.getHeight()));
                        var16.add(new y.d.t(var32.getX(), var32.getY() + var32.getHeight()));
                        y.c.d var17 = var1.a((y.c.q)var30, (y.c.q)var30);
                        var1.b(var17, var16);
                        var9.a(var30, true);
                     }

                     var1.c(var13);
                  }

                  ((y.c.x)var12).g();
                  if(var28 != 0) {
                     break;
                  }
               }

               var12 = var2.c();
               var10000 = var1.c(var12);
            }

            y.c.c var29 = var10000;
            y.c.c var31 = var1.c(var2.b());
            byte var33 = var2.p();
            o var34 = new o(this, var33, var29, var31, var9);
            var2.b((byte)2);
            var1.a((Object)var12, (y.c.c)var34);
            this.a().c(var1);
            p var36 = new p(this, var33, var29, var31, var9, var3);
            var1.a((Object)var12, (y.c.c)var36);
            boolean var37 = true;
            y.c.f var18 = new y.c.f(var7.a());
            HashSet var19 = new HashSet();
            y.c.f var20 = new y.c.f();

            label270:
            while(true) {
               var20.clear();
               var19.clear();
               y.c.p var21 = var18.k();

               y.c.d var22;
               y.c.q var23;
               label223: {
                  while(var21 != null) {
                     var22 = (y.c.d)var21.c();
                     var35 = var19.contains(var22.c());
                     if(var28 != 0) {
                        break label223;
                     }

                     if(!var35 && !var19.contains(var22.d())) {
                        if(!var1.f(var22.c())) {
                           label324: {
                              var23 = var10.a(var22.c());

                              while(var23 != null) {
                                 var19.add(var23);
                                 var23 = var10.a(var23);
                                 if(var28 != 0) {
                                    break label324;
                                 }

                                 if(var28 != 0) {
                                    break;
                                 }
                              }

                              var19.addAll(var10.c(var22.c()));
                           }
                        }

                        label203: {
                           if(!var1.f(var22.d())) {
                              var23 = var10.a(var22.d());

                              while(var23 != null) {
                                 var19.add(var23);
                                 var23 = var10.a(var23);
                                 if(var28 != 0) {
                                    break label203;
                                 }

                                 if(var28 != 0) {
                                    break;
                                 }
                              }

                              var19.addAll(var10.c(var22.d()));
                           }

                           var20.add(var22);
                        }

                        var18.h(var21);
                     }

                     var21 = var21.a();
                     if(var28 != 0) {
                        break;
                     }
                  }

                  var35 = var20.isEmpty();
               }

               y.c.q var25;
               y.c.e var38;
               y.c.x var40;
               if(var35) {
                  var40 = var8.a();

                  Object var39;
                  label318: {
                     while(true) {
                        if(var40.f()) {
                           var35 = var1.f(var40.e());
                           if(var28 != 0) {
                              break;
                           }

                           if(!var35) {
                              var1.d(var40.e());
                           }

                           var40.g();
                           if(var28 == 0) {
                              continue;
                           }
                        }

                        var38 = var7.a();

                        while(var38.f()) {
                           var22 = var38.a();
                           var23 = (y.c.q)var5.b(var22);
                           y.c.q var41 = null;
                           var25 = null;
                           if(var28 != 0) {
                              return;
                           }

                           label157: {
                              if(var23 == null) {
                                 var23 = var22.c();
                                 if(var28 == 0) {
                                    break label157;
                                 }
                              }

                              var41 = var22.c();
                           }

                           y.c.q var26;
                           label162: {
                              var26 = (y.c.q)var6.b(var22);
                              if(var26 == null) {
                                 var26 = var22.d();
                                 if(var28 == 0) {
                                    break label162;
                                 }
                              }

                              var25 = var22.d();
                           }

                           y.c.D var27 = var1.m(var22);
                           var1.a(var22, var23, var26);
                           var1.a(var22, var27);
                           if(var41 != null) {
                              var1.a((y.c.q)var41);
                           }

                           if(var25 != null && var25 != var41) {
                              var1.a((y.c.q)var25);
                           }

                           var38.g();
                           if(var28 != 0) {
                              break;
                           }
                        }

                        var40 = var1.o();
                        var35 = var40.f();
                        break;
                     }

                     while(var35) {
                        var39 = var9;
                        if(var28 != 0) {
                           break label318;
                        }

                        if(var9.d(var40.e())) {
                           var1.a((y.c.q)var40.e());
                        }

                        var40.g();
                        if(var28 != 0) {
                           break;
                        }

                        var35 = var40.f();
                     }

                     var2.b(var33);
                     var1.d_(var12);
                     var39 = var29;
                  }

                  if(var39 != null) {
                     var1.a((Object)var12, (y.c.c)var29);
                  }

                  var1.a((y.c.h)var5);
                  var1.a((y.c.h)var6);
                  var1.a((y.c.A)var9);
                  var10.c();
                  if(var28 == 0) {
                     return;
                  }
                  break;
               }

               var38 = var20.a();

               label255:
               while(true) {
                  var35 = var38.f();

                  while(true) {
                     label314: {
                        if(var35) {
                           var22 = var38.a();
                           var35 = var1.f(var22.c());
                           if(var28 != 0) {
                              break label314;
                           }

                           if(!var35) {
                              var1.d(var22.c());
                           }

                           if(!var1.f(var22.d())) {
                              var1.d(var22.d());
                           }

                           if(!var1.f(var22)) {
                              var1.e(var22);
                           }

                           var38.g();
                           if(var28 == 0) {
                              break;
                           }
                        }

                        this.a().c(var1);
                        var38 = var20.a();
                        var35 = var38.f();
                     }

                     while(true) {
                        if(!var35) {
                           break label255;
                        }

                        var22 = var38.a();
                        var35 = var3.d(var22.c());
                        if(var28 != 0) {
                           break;
                        }

                        y.c.D var24;
                        if(var35) {
                           var23 = var1.d();
                           var1.b(var23, 5.0D, 5.0D);
                           var24 = var1.m(var22);
                           var1.a(var23, (y.d.t)var24.f());
                           var25 = var22.c();
                           var1.a(var22, var23, var22.d());
                           var1.a(var22, var24);
                           var5.a(var22, var25);
                        }

                        if(var3.d(var22.d())) {
                           var23 = var1.d();
                           var1.b(var23, 5.0D, 5.0D);
                           var24 = var1.m(var22);
                           var1.a(var23, (y.d.t)var24.i());
                           var25 = var22.d();
                           var1.a(var22, var22.c(), var23);
                           var1.a(var22, var24);
                           var6.a(var22, var25);
                        }

                        var38.g();
                        if(var28 != 0) {
                           break label255;
                        }

                        var35 = var38.f();
                     }
                  }
               }

               var40 = var8.a();

               while(true) {
                  var35 = var40.f();

                  do {
                     if(!var35) {
                        continue label270;
                     }

                     var35 = var1.f(var40.e());
                  } while(var28 != 0 || var28 != 0);

                  if(var35) {
                     var1.c(var40.e());
                  }

                  var40.g();
               }
            }
         }

         this.a().c(var1);
      }

   }

   v b() {
      int var2 = v.f;
      y.f.ah var1 = this.a();

      while(var1 instanceof y.f.ad) {
         if(var1 instanceof v) {
            return (v)var1;
         }

         var1 = ((y.f.ad)var1).a();
         if(var2 != 0) {
            break;
         }
      }

      return null;
   }
}
