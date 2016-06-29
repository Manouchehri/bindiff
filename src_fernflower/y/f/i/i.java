package y.f.i;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import y.f.i.ah;
import y.f.i.ar;
import y.f.i.k;
import y.f.i.l;
import y.f.i.m;
import y.f.i.v;

public class i extends y.f.a {
   static final Object a = "EdgeGroupRouterStage#BUSNODE_DPKEY";
   static final Object b = "VERTICAL_BUS";
   static final Object c = "HORIZONTAL_BUS";
   private boolean d = false;
   private double e = 15.0D;

   public i(y.f.ah var1) {
      this.a(var1);
   }

   public void c(y.f.X var1) {
      int var40 = v.f;
      v var2 = this.b();
      if(var2 == null) {
         throw new IllegalStateException("No OrthogonalEdgeRouter in coreLayouter");
      } else if(!this.a(var1, var2)) {
         this.a().c(var1);
      } else {
         y.c.c var3 = var1.c(y.f.ax.a);
         y.c.c var4 = var1.c(y.f.ax.b);
         y.c.h var5 = this.a(var1, var3);
         y.c.h var6 = this.a(var1, var4);
         y.c.c var7 = var1.c(y.f.aF.a);
         y.c.c var8 = var1.c(y.f.aF.b);
         if(var3 == null && var4 == null && (var7 != null || var8 != null)) {
            y.c.e var9 = var1.p();

            while(var9.f()) {
               y.c.d var10 = var9.a();
               y.f.aE var11 = (y.f.aE)var7.b(var10);
               if(var11 != null) {
                  y.f.ax var12 = y.f.ax.a(var11);
                  if(var11.a()) {
                     y.d.t var13 = var1.n(var10);
                     var12 = y.f.ax.a(var13.a, var13.b, var12.a());
                  }

                  y.c.D var46 = new y.c.D();
                  var46.add(var12);
                  var5.a(var10, var46);
               }

               y.f.aE var44 = (y.f.aE)var8.b(var10);
               if(var44 != null) {
                  y.f.ax var47 = y.f.ax.a(var44);
                  if(var44.a()) {
                     y.d.t var14 = var1.o(var10);
                     var47 = y.f.ax.a(var14.a, var14.b, var47.a());
                  }

                  y.c.D var48 = new y.c.D();
                  var48.add(var47);
                  var6.a(var10, var48);
               }

               var9.g();
               if(var40 != 0) {
                  break;
               }
            }
         }

         l var41 = new l(var1);
         var41.a();
         y.c.c var42 = var1.c(y.f.aF.d);
         y.c.D var43 = new y.c.D();
         HashMap var45 = new HashMap();
         y.c.x var49 = var1.o();

         label412:
         while(true) {
            if(var49.f()) {
               y.c.q var50 = var49.e();
               var45.clear();
               if(var40 != 0) {
                  break;
               }

               y.c.e var15 = var50.k();

               while(var15.f()) {
                  y.c.d var16 = var15.a();
                  Object var17 = null;
                  if(var40 != 0) {
                     continue label412;
                  }

                  if(var42 != null && (var17 = var42.b(var16)) != null && !var16.e()) {
                     y.c.f var18 = (y.c.f)var45.get(var17);
                     if(var18 == null) {
                        var18 = new y.c.f();
                        var45.put(var17, var18);
                     }

                     var18.add(var16);
                  }

                  var15.g();
                  if(var40 != 0) {
                     break;
                  }
               }

               Iterator var53 = var45.values().iterator();

               label399: {
                  while(var53.hasNext()) {
                     y.c.f var55 = (y.c.f)var53.next();
                     if(var55.size() > 1) {
                        var43.add(var55);
                        if(var40 != 0) {
                           break label399;
                        }

                        if(var40 != 0) {
                           break;
                        }
                     }
                  }

                  var49.g();
               }

               if(var40 == 0) {
                  continue;
               }
            }

            if(var43.isEmpty()) {
               var41.b();
               var1.a((y.c.h)var5);
               var1.a((y.c.h)var6);
               this.a().c(var1);
               return;
            }
            break;
         }

         y.c.A var51 = y.g.M.a();
         y.c.A var52 = y.g.M.a();
         var1.a((Object)a, (y.c.c)var51);
         var41.a(var5, var6);
         var1.a((Object)y.f.ax.a, (y.c.c)var5);
         var1.a((Object)y.f.ax.b, (y.c.c)var6);
         if(var1.c(y.f.aF.a) != null) {
            var1.d_(y.f.aF.a);
         }

         if(var1.c(y.f.aF.b) != null) {
            var1.d_(y.f.aF.b);
         }

         ar var54 = new ar(var1, var2);
         var54.c();
         y.c.h var57 = var54.a();
         y.g.I var59 = new y.g.I(var1);
         var59.a();
         m var60 = new m();
         y.c.C var19 = var43.m();

         Object var56;
         label380:
         while(true) {
            boolean var10000 = var19.f();

            label377:
            while(var10000) {
               var56 = var19.d();

               y.c.f var20;
               y.c.y var21;
               y.c.f var22;
               y.c.e var23;
               label374:
               while(true) {
                  var20 = (y.c.f)var56;
                  var21 = this.a(var20.a(), true);
                  var22 = new y.c.f();
                  if(var40 != 0) {
                     break label380;
                  }

                  var23 = var20.a();

                  while(true) {
                     if(!var23.f()) {
                        break label374;
                     }

                     y.c.d var24 = var23.a();
                     var56 = var57;
                     if(var40 != 0) {
                        break;
                     }

                     if(var57 != null && var57.d(var24)) {
                        var22.add(var24);
                     }

                     var23.g();
                     if(var40 != 0) {
                        break label374;
                     }
                  }
               }

               label444: {
                  if(var22.isEmpty()) {
                     var20.clear();
                     var21.clear();
                     if(var40 == 0) {
                        break label444;
                     }
                  }

                  var23 = null;
                  y.c.q var66 = var20.b().d();
                  Double var25 = null;
                  Rectangle2D var27 = null;
                  byte var26;
                  if(var23 != null) {
                     var26 = ah.a(var1, var66, (y.c.D)var23);
                     y.d.t var28 = (y.d.t)var23.f();
                     var25 = new Double(var28.a, var28.b);
                  } else {
                     var26 = ah.a(var1, var66, var20);
                  }

                  y.c.y var71 = ah.a(var1, var66, var21, var26, this.e);
                  y.c.e var29 = var20.a();

                  int var58;
                  label357: {
                     while(var29.f()) {
                        y.c.d var30 = var29.a();
                        var58 = var71.contains(var30.c());
                        if(var40 != 0) {
                           break label357;
                        }

                        if(var58 == 0) {
                           var20.b(var29);
                           var21.remove(var30.c());
                        }

                        var29.g();
                        if(var40 != 0) {
                           break;
                        }
                     }

                     var58 = var20.size();
                  }

                  if(var58 > 1) {
                     y.g.I.a(var1, var20.a());
                     if(var23 == null) {
                        label464: {
                           switch(var26) {
                           case 2:
                              var60.a((byte)0);
                              if(var40 == 0) {
                                 break;
                              }
                           case 1:
                              var60.a((byte)2);
                              if(var40 == 0) {
                                 break;
                              }
                           case 4:
                              var60.a((byte)1);
                              if(var40 == 0) {
                                 break;
                              }
                           case 8:
                              var60.a((byte)3);
                           case 3:
                           case 5:
                           case 6:
                           case 7:
                           }

                           var60.b(var1);
                           var27 = ah.a(var1, var66, var71, (byte)2);
                           double var73 = var1.j(var66);
                           y.c.d var31 = var20.b();
                           y.c.c var32 = var1.c(y.f.ax.b);
                           if(var32 != null) {
                              y.f.ax var33 = this.a((Collection)var32.b(var31));
                              if(var33 != null && var33.b()) {
                                 var73 = var1.j(var31.d()) + var33.c();
                              }
                           }

                           var25 = new Double(var73, var27.getMaxY());
                           if(var2.q()) {
                              double var78 = Math.max(this.e, (double)var2.s());
                              int var35 = (int)Math.floor((var25.y - var78) / (double)var2.s());
                              var25.y = (double)(var35 * var2.s());

                              do {
                                 if(var25.y >= var27.getMinY()) {
                                    break label464;
                                 }

                                 var25.y += (double)Math.max(1, var2.s());
                                 if(var40 != 0) {
                                    continue label380;
                                 }
                              } while(var40 == 0);
                           }

                           var25.y -= Math.min(var27.getHeight() / 2.0D, Math.max(this.e, (double)var2.t()));
                        }
                     }

                     y.c.q var74;
                     label469: {
                        var74 = var1.d();
                        if(var26 == 1 || var26 == 2) {
                           var51.a(var74, c);
                           if(var40 == 0) {
                              break label469;
                           }
                        }

                        var51.a(var74, b);
                     }

                     y.c.D var38;
                     label315: {
                        double var75 = (double)var2.t();
                        double var77 = 0.5D * (double)var2.t();
                        var77 = Math.max(var77, 2.0D);
                        var75 = Math.max(var75, 4.0D);
                        var1.b(var74, var75, var77);
                        var1.a(var74, var25.x, var25.y);
                        var52.a(var74, var27);
                        y.c.d var34 = var1.a((y.c.q)var74, (y.c.q)var66);
                        if(var23 == null) {
                           y.c.D var79 = new y.c.D();
                           y.f.ax var36 = y.f.ax.a(y.f.aE.a((byte)0, true));
                           var79.add(var36);
                           var5.a(var34, var79);
                           y.f.ax var37 = this.a((Collection)var6.b(var20.b()));
                           if(var37 != null) {
                              var38 = new y.c.D();
                              var38.add(var37);
                              var6.a(var34, var38);
                           }

                           y.d.t var84 = var1.q(var20.b());
                           var1.d(var34, var84);
                           var20.b();
                           if(var57 == null) {
                              break label315;
                           }

                           var57.a(var34, true);
                           if(var40 == 0) {
                              break label315;
                           }
                        }

                        var1.a((y.c.d)var34, (y.c.D)var23);
                        if(var57 != null) {
                           var57.a(var34, false);
                        }
                     }

                     y.c.e var80 = var20.a();

                     label306: {
                        while(var80.f()) {
                           y.c.d var81 = var80.a();
                           y.c.D var83 = null;
                           var56 = var23;
                           if(var40 != 0) {
                              break label306;
                           }

                           label302: {
                              if(var23 != null && var57 != null && !var57.d(var81)) {
                                 var83 = var1.m(var81);
                                 int var85 = 0;

                                 while(var85 < var23.size() - 1) {
                                    var83.j();
                                    ++var85;
                                    if(var40 != 0) {
                                       break label302;
                                    }

                                    if(var40 != 0) {
                                       break;
                                    }
                                 }

                                 if(var83.size() < 2) {
                                    var83 = null;
                                 }
                              }

                              var1.a(var81, var81.c(), var74);
                           }

                           if(var83 != null) {
                              var1.a(var81, var83);
                           }

                           var1.b(var81, y.d.t.c);
                           var38 = new y.c.D();
                           y.f.ax var39 = y.f.ax.a(y.f.aE.a((byte)0, true));
                           var38.add(var39);
                           var6.a(var81, var38);
                           if(var57 != null) {
                              var57.a(var81, true);
                           }

                           var80.g();
                           if(var40 != 0) {
                              break;
                           }
                        }

                        var56 = var23;
                     }

                     if(var56 == null) {
                        var60.d(var1);
                     }

                     var80 = var74.k();

                     while(var80.f()) {
                        var1.d(var80.a());
                        var80.g();
                        if(var40 != 0) {
                           continue label380;
                        }

                        if(var40 != 0) {
                           break;
                        }
                     }

                     y.c.x var82 = var21.a();

                     while(var82.f()) {
                        var10000 = var1.f(var82.e());
                        if(var40 != 0) {
                           continue label377;
                        }

                        if(var10000) {
                           var1.c(var82.e());
                        }

                        var82.g();
                        if(var40 != 0) {
                           break;
                        }
                     }

                     var59.a(var74);
                  }
               }

               var19.g();
               if(var40 == 0) {
                  continue label380;
               }
               break;
            }

            var59.f();
            this.a(var1, var51, var52, c);
            this.a(var1, var51, var52, b);
            break;
         }

         k var61 = new k();
         var61.a(var1, var51);
         this.a().c(var1);
         var61.a(var1);
         y.c.C var62 = var43.m();

         while(true) {
            if(var62.f()) {
               y.c.f var63 = (y.c.f)var62.d();
               if(var40 != 0) {
                  break;
               }

               if(var63.size() > 1) {
                  y.c.q var64 = var63.b().d();
                  y.c.d var65 = var64.f();
                  y.c.D var67 = var1.m(var65);
                  y.d.t var68 = (y.d.t)var67.g();
                  y.d.t var69 = (y.d.t)var67.f();
                  var56 = var51.b(var64);
                  Object var10001 = c;

                  label243:
                  while(true) {
                     label458: {
                        if(var56 == var10001) {
                           if(ah.b(var68, var69)) {
                              var67.g();
                           }

                           var69 = new y.d.t(var69.a, var1.k(var64));
                           if(var40 == 0) {
                              break label458;
                           }
                        }

                        if(ah.a(var68, var69)) {
                           var67.g();
                        }

                        var69 = new y.d.t(var1.j(var64), var69.b);
                     }

                     var67.a((Object)var69);
                     y.c.e var70 = var63.a();

                     while(true) {
                        if(!var70.f()) {
                           break label243;
                        }

                        y.c.d var72 = var70.a();
                        y.c.D var76 = var1.m(var72);
                        var68 = (y.d.t)var76.j();
                        var64 = var72.d();
                        var69 = (y.d.t)var76.i();
                        var56 = var51.b(var64);
                        var10001 = c;
                        if(var40 != 0) {
                           break;
                        }

                        label460: {
                           if(var56 == var10001) {
                              if(ah.b(var68, var69)) {
                                 var76.j();
                              }

                              var69 = new y.d.t(var69.a, var1.k(var64));
                              if(var40 == 0) {
                                 break label460;
                              }
                           }

                           if(ah.a(var68, var69)) {
                              var76.j();
                           }

                           var69 = new y.d.t(var1.j(var64), var69.b);
                        }

                        var76.b((Object)var69);
                        var76.addAll(var67);
                        var1.a(var72, var72.c(), var65.d());
                        var1.a(var72, var76);
                        var70.g();
                        if(var40 != 0) {
                           break label243;
                        }
                     }
                  }

                  var1.a((y.c.q)var64);
               }

               var62.g();
               if(var40 == 0) {
                  continue;
               }
            }

            a(var1, var1.p());
            var1.d_(a);
            var41.b();
            var54.e();
            var1.a((y.c.h)var5);
            var1.a((y.c.h)var6);
            var1.d_(y.f.ax.a);
            var1.d_(y.f.ax.b);
            break;
         }

         if(var3 != null) {
            var1.a((Object)y.f.ax.a, (y.c.c)var3);
         }

         if(var4 != null) {
            var1.a((Object)y.f.ax.b, (y.c.c)var4);
         }

         if(var7 != null) {
            var1.a((Object)y.f.aF.a, (y.c.c)var7);
         }

         if(var8 != null) {
            var1.a((Object)y.f.aF.b, (y.c.c)var8);
         }

      }
   }

   private y.f.ax a(Collection var1) {
      int var5 = v.f;
      if(var1 != null && !var1.isEmpty()) {
         y.f.ax var2 = null;
         Iterator var3 = var1.iterator();

         y.f.ax var10000;
         while(true) {
            if(var3.hasNext()) {
               y.f.ax var4 = (y.f.ax)var3.next();
               if(var2 == null) {
                  var2 = var4;
               }

               if(var4.b()) {
                  continue;
               }

               var10000 = var4;
               if(var5 != 0) {
                  break;
               }

               var2 = var4;
            }

            var10000 = var2;
            break;
         }

         return var10000;
      } else {
         return null;
      }
   }

   y.c.y a(y.c.e var1, boolean var2) {
      int var4 = v.f;
      y.c.y var3 = new y.c.y();

      y.c.y var10000;
      while(true) {
         if(var1.f()) {
            var10000 = var3;
            if(var4 != 0) {
               break;
            }

            var3.add(var2?var1.a().c():var1.a().d());
            var1.g();
            if(var4 == 0) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
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

   boolean a(y.f.X var1, v var2) {
      return var1.c(y.f.aF.c) != null || var1.c(y.f.aF.d) != null;
   }

   y.c.h a(y.f.X var1, y.c.c var2) {
      int var6 = v.f;
      y.c.h var3 = var1.u();
      y.c.h var10000;
      if(var2 != null) {
         y.c.e var4 = var1.p();

         while(var4.f()) {
            y.c.d var5 = var4.a();
            var10000 = var3;
            if(var6 != 0) {
               return var10000;
            }

            var3.a(var5, var2.b(var5));
            var4.g();
            if(var6 != 0) {
               break;
            }
         }
      }

      var10000 = var3;
      return var10000;
   }

   static void a(y.f.X var0, y.c.e var1) {
      int var9 = v.f;

      while(var1.f()) {
         y.c.d var2 = var1.a();
         y.c.D var3 = var0.m(var2);
         y.c.p var4 = var3.k();
         y.d.t var5 = (y.d.t)var4.c();
         var4 = var4.a();
         y.d.t var6 = (y.d.t)var4.c();
         boolean var7 = false;
         var4 = var4.a();

         boolean var10000;
         while(true) {
            if(var4 != null) {
               y.d.t var8 = (y.d.t)var4.c();
               var10000 = y.d.e.d(var5, var6, var8);
               if(var9 != 0) {
                  break;
               }

               label30: {
                  if(var10000) {
                     var3.h(var4.b());
                     var6 = var8;
                     var7 = true;
                     if(var9 == 0) {
                        break label30;
                     }
                  }

                  var5 = var6;
                  var6 = var8;
               }

               var4 = var4.a();
               if(var9 == 0) {
                  continue;
               }
            }

            var10000 = var7;
            break;
         }

         if(var10000) {
            var0.a(var2, var3);
         }

         var1.g();
         if(var9 != 0) {
            break;
         }
      }

   }

   void a(y.f.X var1, y.c.A var2, y.c.A var3, Object var4) {
      int var11 = v.f;
      y.f.w var5 = new y.f.w();
      y.c.A var6 = var5.t();
      y.c.x var7 = var1.o();

      y.c.q var9;
      while(var7.f()) {
         y.c.q var8 = var7.e();
         if(var2.b(var8) == var4 && var3.b(var8) != null) {
            label39: {
               var9 = var5.d();
               var6.a(var9, var8);
               Rectangle2D var10 = (Rectangle2D)var3.b(var8);
               if(var4 == c) {
                  var5.b(var9, var10.getWidth(), var1.q(var8));
                  var5.c(var9, var10.getX(), var1.n(var8));
                  if(var11 == 0) {
                     break label39;
                  }
               }

               var5.b(var9, var1.p(var8), var10.getWidth());
               var5.c(var9, var1.m(var8), var10.getX());
            }
         }

         var7.g();
         if(var11 != 0) {
            break;
         }
      }

      y.f.e.l var13 = new y.f.e.l();
      var13.b(true);
      var13.a(5.0D);
      var13.c(var5);
      y.c.x var14 = var5.o();

      while(var14.f()) {
         var9 = var14.e();
         y.c.q var12 = (y.c.q)var6.b(var9);
         if(var12 != null) {
            label26: {
               if(var4 == c) {
                  var1.c(var12, var1.m(var12), var5.n(var9));
                  if(var11 == 0) {
                     break label26;
                  }
               }

               var1.c(var12, var5.m(var9), var1.n(var12));
            }
         }

         var14.g();
         if(var11 != 0) {
            break;
         }
      }

   }
}
