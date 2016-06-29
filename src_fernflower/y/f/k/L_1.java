package y.f.k;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import y.f.aN;
import y.f.ad;
import y.f.ah;
import y.f.am;
import y.f.k.M;
import y.f.k.N;
import y.f.k.d;

public class L implements ad {
   public static final Object a = "y.layout.tree.TreeComponentLayouter.DUMMY_NODE_DPKEY";
   private ah b;
   private ah c;
   private boolean d;

   public L(ah var1) {
      this.c = var1;
   }

   public void c(y.f.X var1) {
      int var38 = d.g;
      y.c.y[] var2 = y.a.A.a(var1);
      if(var2.length == 1 && var2[0].size() == var1.f()) {
         if(y.a.g.e(var1)) {
            this.c.c(var1);
            if(var38 == 0) {
               return;
            }
         }

         (new aN(this.c)).c(var1);
      } else if(y.a.g.d(var1)) {
         this.c.c(var1);
      } else {
         y.c.e var3 = var1.p();

         y.f.X var10000;
         while(true) {
            if(var3.f()) {
               var10000 = var1;
               if(var38 != 0) {
                  break;
               }

               var1.c(var3.a());
               var3.g();
               if(var38 == 0) {
                  continue;
               }
            }

            var10000 = var1;
            break;
         }

         y.c.y[] var39 = y.a.A.a(var10000);
         y.c.e var4 = var1.p();

         while(true) {
            if(var4.f()) {
               var1.c(var4.a());
               var4.g();
               if(var38 != 0) {
                  break;
               }

               if(var38 == 0) {
                  continue;
               }
            }

            if(var39.length == 1 && var39[0].size() == var1.f()) {
               if(y.a.g.e(var1)) {
                  this.c.c(var1);
                  if(var38 == 0) {
                     return;
                  }
               }

               (new aN(this.c)).c(var1);
               return;
            }
            break;
         }

         y.g.I var40 = new y.g.I(var1);
         HashSet var5 = new HashSet();
         y.c.f[] var6 = y.a.A.a((y.c.i)var1, (y.c.y[])var2);
         ArrayList var7 = new ArrayList();
         var40.a();
         int var8 = 0;

         double var17;
         double var19;
         int var56;
         label419:
         while(true) {
            var56 = var8;

            int var10001;
            label416:
            while(true) {
               if(var56 < var2.length) {
                  y.c.y var9 = var2[var8];
                  y.c.f var10 = var6[var8];
                  y.c.q var11 = var9.b();
                  var56 = var9.size();
                  var10001 = 2;
                  if(var38 != 0) {
                     break;
                  }

                  if(var56 <= 2) {
                     ++var8;
                  } else {
                     label463: {
                        y.g.I.a(var1, var10.a());
                        Rectangle var12 = var1.a();
                        this.c.c(var1);
                        double var15 = Double.MAX_VALUE;
                        double var13 = Double.MAX_VALUE;
                        var19 = -1.7976931348623157E308D;
                        var17 = -1.7976931348623157E308D;
                        y.c.x var21 = var9.a();
                        var21.g();

                        y.c.e var22;
                        while(true) {
                           if(var21.f()) {
                              am var63 = var1.a((Object)var21.e());
                              var13 = Math.min(var13, var63.getX());
                              var15 = Math.min(var15, var63.getY());
                              var17 = Math.max(var17, var63.getX() + var63.getWidth());
                              var19 = Math.max(var19, var63.getY() + var63.getHeight());
                              var21.g();
                              if(var38 != 0) {
                                 break label463;
                              }

                              if(var38 == 0) {
                                 continue;
                              }

                              var22 = var10.a();
                              break;
                           }

                           var22 = var10.a();
                           break;
                        }

                        while(var22.f()) {
                           y.f.I var23 = var1.b(var22.a());
                           var56 = 0;
                           if(var38 != 0) {
                              continue label416;
                           }

                           int var24 = 0;

                           while(true) {
                              if(var24 < var23.pointCount()) {
                                 y.d.t var25 = var23.getPoint(var24);
                                 var13 = Math.min(var13, var25.a);
                                 var15 = Math.min(var15, var25.b);
                                 var17 = Math.max(var17, var25.a);
                                 var19 = Math.max(var19, var25.b);
                                 ++var24;
                                 if(var38 != 0) {
                                    break;
                                 }

                                 if(var38 == 0) {
                                    continue;
                                 }

                                 var22.g();
                                 break;
                              }

                              var22.g();
                              break;
                           }

                           if(var38 != 0) {
                              break;
                           }
                        }

                        var21 = var9.a();
                        var21.g();
                        y.c.q var64 = var1.d();
                        var5.add(var64);
                        am var65 = var1.a((Object)var64);
                        var65.setSize(var17 - var13, var19 - var15);
                        var65.setLocation((double)var12.x, (double)var12.y);
                        y.c.d var67 = var1.a((y.c.q)var9.b(), (y.c.q)var64);
                        var40.a(var9);
                        var40.a();
                        N var68 = new N();
                        var68.b = var67;
                        var68.a = var64;
                        var68.c = new java.awt.geom.Rectangle2D.Double(var13, var15, var17 - var13, var19 - var15);
                        var68.d = var9;
                        var68.e = var6[var8];
                        var7.add(var68);
                        ++var8;
                     }
                  }

                  if(var38 == 0) {
                     continue label419;
                  }
               }

               var40.f();
               var8 = 0;
               var56 = var8;
               var10001 = var7.size();
               break;
            }

            while(true) {
               if(var56 >= var10001) {
                  break label419;
               }

               N var41 = (N)var7.get(var8);
               y.c.x var43 = var41.d.a();
               var43.g();

               while(true) {
                  if(!var43.f()) {
                     ++var8;
                     break;
                  }

                  var40.a(var43.e());
                  var43.g();
                  if(var38 != 0) {
                     break;
                  }

                  if(var38 != 0) {
                     ++var8;
                     break;
                  }
               }

               if(var38 != 0) {
                  break label419;
               }

               var56 = var8;
               var10001 = var7.size();
            }
         }

         M var44 = new M(var5);
         this.a(var1, var44);
         var40.f();
         int var42 = 0;
         int var45 = 0;
         int var46 = 0;

         y.d.t var58;
         label347:
         while(true) {
            var56 = var46;

            label344:
            while(var56 < var7.size()) {
               N var48 = (N)var7.get(var46);
               y.d.t var51 = var1.b(var48.b).getSourcePoint();
               y.f.I var14 = var1.b(var48.b);
               var56 = var14.pointCount();
               if(var38 != 0) {
                  break label347;
               }

               boolean var53;
               label452: {
                  y.d.t var16;
                  if(var56 > 0) {
                     var16 = var1.p(var48.b);
                     var58 = var14.getPoint(0);
                     var53 = Math.abs(var16.a - var58.a) > Math.abs(var16.b - var58.b);
                     if(var38 == 0) {
                        break label452;
                     }
                  }

                  var16 = var1.p(var48.b);
                  var58 = var1.q(var48.b);
                  var53 = Math.abs(var16.a - var58.a) > Math.abs(var16.b - var58.b);
               }

               am var54 = var1.a((Object)var48.a);
               var17 = var48.c.getCenterX();
               var19 = var48.c.getCenterY();
               double var61 = var54.getX() + var54.getWidth() / 2.0D;
               double var66 = var54.getY() + var54.getHeight() / 2.0D;
               y.c.x var69 = var48.d.a();
               var1.a((Object)var69.e());
               int var27 = var1.q(var48.b).a < var1.p(var48.b).a?1:0;
               boolean var28 = var1.q(var48.b).b < var1.p(var48.b).b;
               var1.a((y.c.d)var48.b);
               var42 += var27 != 0?-var48.d.size():var48.d.size();
               var45 += var28?-var48.d.size():var48.d.size();
               var69.g();

               while(var69.f()) {
                  am var29 = var1.a((Object)var69.e());
                  double var30 = var29.getX() + var29.getWidth() / 2.0D;
                  double var32 = var29.getY() + var29.getHeight() / 2.0D;
                  var56 = var27;
                  if(var38 != 0) {
                     continue label344;
                  }

                  label331: {
                     if(var27 != 0) {
                        var30 = var61 - (var30 - var17);
                        if(var38 == 0) {
                           break label331;
                        }
                     }

                     var30 = var61 + (var30 - var17);
                  }

                  label326: {
                     if(var28) {
                        var32 = var66 - (var32 - var19);
                        if(var38 == 0) {
                           break label326;
                        }
                     }

                     var32 = var66 + (var32 - var19);
                  }

                  var29.setLocation(var30 - var29.getWidth() / 2.0D, var32 - var29.getHeight() / 2.0D);
                  var69.g();
                  if(var38 != 0) {
                     break;
                  }
               }

               ArrayList var70 = new ArrayList(6);
               y.c.e var71 = var48.e.a();

               while(var71.f()) {
                  var70.clear();
                  y.f.I var31 = var1.b(var71.a());
                  var70.clear();
                  var56 = 0;
                  if(var38 != 0) {
                     continue label344;
                  }

                  int var72 = 0;

                  y.d.t var33;
                  while(true) {
                     if(var72 < var31.pointCount()) {
                        var33 = var31.getPoint(var72);
                        double var34 = var33.a;
                        double var36 = var33.b;
                        var56 = var27;
                        if(var38 != 0) {
                           break;
                        }

                        label308: {
                           if(var27 != 0) {
                              var34 = var61 - (var34 - var17);
                              if(var38 == 0) {
                                 break label308;
                              }
                           }

                           var34 = var61 + (var34 - var17);
                        }

                        label303: {
                           if(var28) {
                              var36 = var66 - (var36 - var19);
                              if(var38 == 0) {
                                 break label303;
                              }
                           }

                           var36 = var66 + (var36 - var19);
                        }

                        var70.add(new y.d.t(var34, var36));
                        ++var72;
                        if(var38 == 0) {
                           continue;
                        }
                     }

                     var31.clearPoints();
                     var56 = 0;
                     break;
                  }

                  var72 = var56;

                  label456: {
                     y.d.t var73;
                     while(true) {
                        if(var72 < var70.size()) {
                           var33 = (y.d.t)var70.get(var72);
                           var31.addPoint(var33.a, var33.b);
                           ++var72;
                           if(var38 != 0) {
                              break;
                           }

                           if(var38 == 0) {
                              continue;
                           }
                        }

                        if(var71.a().c() == var48.d.b()) {
                           y.c.D var35;
                           label282: {
                              var73 = var31.getTargetPoint();
                              var31.setTargetPoint(new y.d.t(var27 != 0?-var73.a:var73.a, var28?-var73.b:var73.b));
                              var31.setSourcePoint(var51);
                              var33 = var1.p(var71.a());
                              y.d.t var74 = var31.pointCount() > 0?var31.getPoint(0):var1.q(var71.a());
                              var35 = var1.k(var71.a());
                              if(var53) {
                                 var35.a((Object)(new y.d.t(var74.a, var33.b)));
                                 if(var38 == 0) {
                                    break label282;
                                 }
                              }

                              var35.a((Object)(new y.d.t(var33.a, var74.b)));
                           }

                           var1.b(var71.a(), var35);
                           break label456;
                        }
                        break;
                     }

                     var73 = var31.getSourcePoint();
                     var31.setSourcePoint(new y.d.t(var27 != 0?-var73.a:var73.a, var28?-var73.b:var73.b));
                  }

                  var71.g();
                  if(var38 != 0) {
                     break;
                  }
               }

               var1.a((y.c.q)var48.a);
               ++var46;
               if(var38 == 0) {
                  continue label347;
               }
               break;
            }

            var56 = this.b();
            break;
         }

         if(var56 != 0 && (var42 < 0 || var45 < 0)) {
            y.c.x var47 = var1.o();

            while(var47.f()) {
               y.c.q var49 = var47.e();
               am var52 = var1.a((Object)var49);
               if(var38 != 0) {
                  return;
               }

               if(var42 < 0) {
                  var52.setLocation(-var52.getX() - var52.getWidth(), var52.getY());
               }

               if(var45 < 0) {
                  var52.setLocation(var52.getX(), -var52.getY() - var52.getHeight());
               }

               y.c.e var50 = var49.l();

               label254: {
                  while(var50.f()) {
                     y.c.d var57 = var50.a();
                     y.f.I var55 = var1.b(var57);
                     var58 = var55.getSourcePoint();
                     if(var38 != 0) {
                        break label254;
                     }

                     var55.setSourcePoint(new y.d.t(var42 < 0?-var58.a:var58.a, var45 < 0?-var58.b:var58.b));
                     var58 = var55.getTargetPoint();
                     var55.setTargetPoint(new y.d.t(var42 < 0?-var58.a:var58.a, var45 < 0?-var58.b:var58.b));
                     y.c.D var59 = var1.k(var57);
                     y.c.p var62 = var59.k();

                     label250:
                     while(true) {
                        y.c.p var18 = var62;

                        while(true) {
                           if(var18 == null) {
                              break label250;
                           }

                           y.d.t var60 = (y.d.t)var18.c();
                           var62 = var18;
                           if(var38 != 0) {
                              break;
                           }

                           var18.a(new y.d.t(var42 < 0?-var60.a:var60.a, var45 < 0?-var60.b:var60.b));
                           var18 = var18.a();
                           if(var38 != 0) {
                              break label250;
                           }
                        }
                     }

                     var1.b(var57, var59);
                     var50.g();
                     if(var38 != 0) {
                        break;
                     }
                  }

                  var47.g();
               }

               if(var38 != 0) {
                  break;
               }
            }
         }

         var7.clear();
      }
   }

   protected void a(y.f.X var1, y.c.c var2) {
      ah var3 = this.a();
      var1.a((Object)a, (y.c.c)var2);
      var3.c(var1);
      var1.d_(a);
   }

   public ah a() {
      return this.b;
   }

   public void a(ah var1) {
      this.b = var1;
   }

   public boolean b() {
      return this.d;
   }

   public void a(boolean var1) {
      this.d = var1;
   }
}
