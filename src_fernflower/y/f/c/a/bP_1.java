package y.f.c.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.an;
import y.f.c.a.bs;
import y.f.c.a.cB;
import y.f.c.a.cr;
import y.f.c.a.cy;

class bP {
   private static final double a = Math.sqrt(2.0D);
   private y.c.f b = new y.c.f();
   private aV c;
   private aP d;
   private double e = 10.0D;
   private double f = 0.0D;

   public bP(aV var1, aP var2) {
      this.c = var1;
      this.d = var2;
   }

   void a(Map var1) {
      Object var2 = var1.get("SameLayerEdgeSupport.minimumEdgeDistance");
      if(var2 instanceof Number) {
         this.a(((Number)var2).doubleValue());
      }

      var2 = var1.get("SameLayerEdgeSupport.defaultThickness");
      if(var2 instanceof Number) {
         this.f = ((Number)var2).doubleValue();
      }

   }

   public void a(y.f.X var1) {
      boolean var6 = N.x;
      y.c.e var2 = var1.p();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         int var4 = this.c.a(var3.c()).j();
         int var5 = this.c.a(var3.d()).j();
         if(var4 == var5) {
            this.a(var1, var3);
         }

         var2.g();
         if(var6) {
            break;
         }
      }

   }

   public void a(y.f.X var1, y.c.d var2) {
      if(var1.f(var2)) {
         var1.d(var2);
      }

      this.d.b(var2);
      this.b.add(var2);
   }

   public void b(y.f.X var1, y.c.d var2) {
      if(!var1.f(var2)) {
         var1.e(var2);
      }

   }

   public void b(y.f.X var1) {
      boolean var3 = N.x;
      y.c.p var2 = this.b.k();

      while(var2 != null) {
         this.b.h(var2);
         this.b(var1, (y.c.d)var2.c());
         var2 = var2.a();
         if(var3) {
            break;
         }
      }

   }

   public void a(y.f.X var1, aV var2, y.d.c var3, y.c.q var4, y.f.am var5, aX var6, double var7, boolean var9) {
   }

   void a(y.f.X var1, y.d.c var2, aQ var3, aV var4, double var5, Map var7) {
      boolean var30 = N.x;
      cB var8 = cB.b((y.c.i)var1);
      Iterator var9 = var3.f().iterator();

      label108:
      while(var9.hasNext()) {
         y.c.d var10 = (y.c.d)var9.next();
         A var11 = var4.a(var10);
         y.f.I var12 = var1.b(var10);
         int var13 = var12.pointCount();
         if(var11.a() == 4) {
            double var14 = 0.0D;
            double var16 = 0.0D;
            if(var7.containsKey(var10)) {
               y.c.q var18 = (y.c.q)var7.get(var10);
               an var19 = (an)var4.a(var18);
               y.f.am var20 = var1.a((Object)var18);
               var14 = var20.getX() - var19.c;
               var16 = var20.getY() - var19.b;
            }

            ArrayList var32 = new ArrayList(var13 + 2);
            y.d.t var33 = var1.p(var10);
            y.d.t var35 = var1.q(var10);
            double var21 = var33.a();
            double var23 = var35.a();
            double[] var25 = new double[2];
            if(var8 != null) {
               var8.a(var1, var10, (byte)0, var25, true, var21 < var23);
            }

            label114: {
               double var26 = var25[1];
               int var28;
               y.d.t var29;
               if(var21 < var23) {
                  var32.add(new y.d.t(var33.a(), var33.b() + var26 + var5));
                  var28 = 0;

                  label96: {
                     while(var28 < var13) {
                        var29 = var12.getPoint(var28);
                        var32.add(new y.d.t(var14 + var29.a(), var16 + var29.b() + var26 + var5));
                        ++var28;
                        if(var30) {
                           break label96;
                        }

                        if(var30) {
                           break;
                        }
                     }

                     var32.add(new y.d.t(var35.a(), var35.b() + var26 + var5));
                  }

                  if(!var30) {
                     break label114;
                  }
               }

               var32.add(new y.d.t(var35.a(), var35.b() + var26 + var5));
               var28 = var13 - 1;

               while(var28 >= 0) {
                  var29 = var12.getPoint(var28);
                  var32.add(new y.d.t(var14 + var29.a(), var16 + var29.b() + var26 + var5));
                  --var28;
                  if(var30) {
                     break label114;
                  }

                  if(var30) {
                     break;
                  }
               }

               var32.add(new y.d.t(var33.a(), var33.b() + var26 + var5));
            }

            y.d.c var39 = this.a((List)var32);
            var2.a(var39);
            if(!var30) {
               continue;
            }
         }

         if(var13 >= 2) {
            ArrayList var31 = new ArrayList(var13);
            double var15 = var12.getPoint(0).a();
            double var17 = var12.getPoint(var13 - 1).a();
            double[] var34 = new double[2];
            if(var8 != null) {
               var8.a(var1, var10, (byte)0, var34, true, var15 < var17);
            }

            label118: {
               double var36 = var34[1];
               int var22;
               y.d.t var38;
               if(var15 < var17) {
                  var22 = 0;

                  do {
                     if(var22 >= var13) {
                        break label118;
                     }

                     var38 = var12.getPoint(var22);
                     var31.add(new y.d.t(var38.a(), var38.b() + var36));
                     ++var22;
                     if(var30) {
                        continue label108;
                     }
                  } while(!var30);
               }

               var22 = var13 - 1;

               while(var22 >= 0) {
                  var38 = var12.getPoint(var22);
                  var31.add(new y.d.t(var38.a(), var38.b() + var36));
                  --var22;
                  if(var30) {
                     continue label108;
                  }

                  if(var30) {
                     break;
                  }
               }
            }

            y.d.c var37 = this.a((List)var31);
            var2.a(var37);
            if(var30) {
               break;
            }
         }
      }

   }

   private y.d.c a(List var1) {
      boolean var17 = N.x;
      if(var1.isEmpty()) {
         return null;
      } else {
         y.d.c var2 = new y.d.c(-1.7976931348623157E308D);
         y.d.c var3 = new y.d.c(-1.7976931348623157E308D);
         y.d.t var4 = null;
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            y.d.t var6 = (y.d.t)var5.next();
            if(var4 != null) {
               double var7 = Math.min(var4.a(), var6.a());
               double var9 = Math.max(var4.a(), var6.a());
               if(var7 != var9) {
                  double var11 = var4.a() < var6.a()?var4.b():var6.b();
                  double var13 = var4.a() < var6.a()?var6.b():var4.b();
                  double var15 = var13 == var11?0.0D:(var13 - var11) / (var9 - var7);
                  var3.a(var7, var9, var11, var15);
                  var2.a(var3);
                  var3.c(-1.7976931348623157E308D, Double.MAX_VALUE, -1.7976931348623157E308D);
               }
            }

            var4 = var6;
            if(var17) {
               break;
            }
         }

         return var2;
      }
   }

   public int a(y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var29 = N.x;
      int var5 = 0;
      ArrayList var6 = new ArrayList(120);
      int var7 = 0;

      label181:
      while(true) {
         int var10000 = var7;

         label178:
         while(true) {
            int var10001 = var2.b();

            label175:
            while(true) {
               if(var10000 >= var10001) {
                  break label178;
               }

               aQ var8 = var2.a(var7);
               var10000 = var8.e();
               if(var29) {
                  return var10000;
               }

               if(var10000 == 1) {
                  break;
               }

               var6.clear();
               y.c.p var9 = var8.d().k();

               while(true) {
                  if(var9 == null) {
                     break label175;
                  }

                  y.c.q var10 = (y.c.q)var9.c();
                  aX var11 = var3.a(var10);
                  var10000 = var11.e();
                  if(var29) {
                     continue label178;
                  }

                  if(var10000 > 0) {
                     y.c.p var12 = var11.d();

                     while(var12 != null) {
                        y.c.d var13 = (y.c.d)var12.c();
                        A var14 = var3.a(var13);
                        var10000 = var14.a();
                        var10001 = 4;
                        if(var29) {
                           continue label175;
                        }

                        if(var10000 != 4) {
                           y.c.q var15 = var13.a(var10);
                           aX var16 = var3.a(var15);
                           if(var16.b() == 0 || var16.b() == 12 || var16.b() == 13 || var16.b() == 15) {
                              int var17 = var3.a(var15).k();
                              if(var17 < var6.size() && (var14.c() == null || var14.c().g() || var14.c().e() || var14.c().f()) && (var14.e() == null || var14.e().g() || var14.e().e() || var14.e().f())) {
                                 y.c.p var19;
                                 y.c.p var20;
                                 label208: {
                                    ++var5;
                                    y.c.p var18 = (y.c.p)var6.get(var17);
                                    var19 = var18;
                                    var20 = var9;
                                    if(var13.c() == var15) {
                                       if(var14.c() == null || !var14.c().f()) {
                                          var19 = var18.a();
                                       }

                                       if(var14.e() == null || !var14.e().e()) {
                                          break label208;
                                       }

                                       var20 = var9.a();
                                       if(!var29) {
                                          break label208;
                                       }
                                    }

                                    if(var14.e() == null || !var14.e().f()) {
                                       var19 = var18.a();
                                    }

                                    if(var14.c() != null && var14.c().e()) {
                                       var20 = var20.a();
                                    }
                                 }

                                 int var21 = 0;
                                 int var22 = 0;

                                 label140: {
                                    while(true) {
                                       if(var19 != var20) {
                                          y.c.q var23 = (y.c.q)var19.c();
                                          var21 += var23.b();
                                          var22 += var23.c();
                                          aX var24 = var3.a(var23);
                                          var10000 = var24.e();
                                          if(var29) {
                                             break;
                                          }

                                          if(var10000 > 0) {
                                             y.c.p var25 = var24.d();

                                             while(var25 != null) {
                                                y.c.d var26 = (y.c.d)var25.c();
                                                y.c.q var27 = var26.a(var23);
                                                int var28 = var3.a(var27).k();
                                                var10000 = var28;
                                                var10001 = var17;
                                                if(var29) {
                                                   break label140;
                                                }

                                                if(var28 < var17 || var28 > var6.size()) {
                                                   label207: {
                                                      if(var3.a(var26).j()) {
                                                         ++var21;
                                                         if(!var29) {
                                                            break label207;
                                                         }
                                                      }

                                                      ++var22;
                                                   }
                                                }

                                                var25 = var25.a();
                                                if(var29) {
                                                   break;
                                                }
                                             }
                                          }

                                          var19 = var19.a();
                                          if(!var29) {
                                             continue;
                                          }
                                       }

                                       var10000 = var21;
                                       break;
                                    }

                                    var10001 = var22;
                                 }

                                 if(var10000 != var10001) {
                                    var14.a(var21 < var22);
                                 }
                              }
                           }
                        }

                        var12 = var12.a();
                        if(var29) {
                           break;
                        }
                     }
                  }

                  var6.add(var9);
                  var9 = var9.a();
                  if(var29) {
                     break label175;
                  }
               }
            }

            ++var7;
            if(!var29) {
               continue label181;
            }
            break;
         }

         var10000 = var5;
         return var10000;
      }
   }

   public void a(y.f.X var1, cr var2, aQ var3, aV var4, boolean var5, double var6) {
      boolean var28 = N.x;
      cB var8 = cB.b((y.c.i)var1);
      y.c.p var9 = var3.d().k();

      while(var9 != null) {
         y.c.q var10000 = (y.c.q)var9.c();

         label116:
         while(true) {
            y.c.q var10 = var10000;
            aX var11 = var4.a(var10);
            if(var11.e() <= 0) {
               break;
            }

            y.c.p var12 = var11.d();

            while(true) {
               if(var12 == null) {
                  break label116;
               }

               y.c.d var13 = (y.c.d)var12.c();
               var10000 = var13.c();
               if(var28) {
                  break;
               }

               if(var10000 == var10 && var5 == this.a(var4, var13)) {
                  double var14 = Double.MAX_VALUE;
                  double var16 = -1.7976931348623157E308D;
                  A var19 = var4.a(var13);
                  if(var19.a() != 4) {
                     label130: {
                        y.d.t var18;
                        label126: {
                           y.f.aE var20 = var19.c();
                           if(var20 != null && (var20.b() == 4 || var20.b() == 8)) {
                              y.f.I var21 = var1.b(var13);
                              var18 = var21.getPoint(0);
                              if(!var28) {
                                 break label126;
                              }
                           }

                           var18 = var1.p(var13);
                           if(var5) {
                              if(!a(var4.a(var13.c()))) {
                                 break label126;
                              }

                              var14 = var18.b + var6 - this.a(var4, var13, true);
                              if(!var28) {
                                 break label126;
                              }
                           }

                           if(a(var4.a(var13.c()))) {
                              var16 = var18.b + this.a(var4, var13, true);
                           }
                        }

                        y.d.t var29;
                        label127: {
                           y.f.aE var22 = var19.e();
                           if(var22 != null && (var22.b() == 4 || var22.b() == 8)) {
                              y.f.I var23 = var1.b(var13);
                              var29 = var23.getPoint(var23.pointCount() - 1);
                              if(!var28) {
                                 break label127;
                              }
                           }

                           var29 = var1.q(var13);
                           if(var5) {
                              if(!a(var4.a(var13.d()))) {
                                 break label127;
                              }

                              var14 = Math.min(var14, var29.b + var6 - this.a(var4, var13, false));
                              if(!var28) {
                                 break label127;
                              }
                           }

                           if(a(var4.a(var13.d()))) {
                              var16 = Math.max(var16, var29.b + this.a(var4, var13, false));
                           }
                        }

                        double var30 = this.a(var1, var4, var13);
                        double[] var25 = new double[2];
                        var8.a(var1, var13, (byte)0, var25, true, var18.a < var29.a);
                        B var26 = var4.a(var13).k();
                        cy var27 = var2.a(var13, this.f, Math.max(var30, var25[0] * 2.0D), Math.max(var30, var25[1] * 2.0D), var18.a, !var5, var29.a, !var5, !this.b(var4, var13), var26.i());
                        if(var5) {
                           var27.l = var14;
                           if(!var28) {
                              break label130;
                           }
                        }

                        var27.k = var16;
                     }
                  }
               }

               var12 = var12.a();
               if(var28) {
                  break label116;
               }
            }
         }

         var9 = var9.a();
         if(var28) {
            break;
         }
      }

   }

   private static final boolean a(aX var0) {
      return var0.b() == 0 || var0.b() == 5;
   }

   private final double a(aV var1, y.c.d var2, boolean var3) {
      A var4 = var1.a(var2);
      B var5 = var4.k();
      return var5 != null?(var3?(var4.i()?var5.b():var5.a()):(var4.i()?var5.a():var5.b())):(var3?(var4.i()?15.0D:10.0D):(var4.i()?10.0D:15.0D));
   }

   private y.d.q a(y.c.i var1) {
      y.c.c var2 = var1.c(N.u);
      return var2 == null?null:(y.d.q)var2.b(var1);
   }

   protected double a(y.f.X var1, aV var2, y.c.d var3) {
      double var4 = 0.0D;
      y.d.q var6 = this.a((y.c.i)var1);
      if(var6 != null) {
         byte var7 = var2.a(var3.c()).b();
         byte var8 = var2.a(var3.d()).b();
         if(var7 == 15 || var8 == 15) {
            var4 = var6.b * 0.5D;
         }
      }

      B var9 = var2.a(var3).k();
      return var4 + (var9 != null?var9.d():this.e);
   }

   public java.awt.geom.Rectangle2D.Double a(y.f.X var1, aV var2, y.c.q var3, y.c.q var4, List var5) {
      boolean var40 = N.x;
      if(var5.size() <= 0) {
         return null;
      } else {
         y.f.am var6 = var1.a((Object)var3);
         y.f.am var7 = var1.a((Object)var4);
         cr var8 = new cr();
         double var9 = 0.0D;
         var8.a(0.0D);
         var8.a(true);
         var8.b(Double.NaN);
         double var11 = Double.MAX_VALUE;
         double var13 = -1.7976931348623157E308D;
         cB var15 = cB.b((y.c.i)var1);
         int var16 = 0;

         double var33;
         while(true) {
            if(var16 < var5.size()) {
               y.c.d var17 = (y.c.d)var5.get(var16);
               y.f.I var18 = var1.b(var17);
               var18.clearPoints();
               double var19 = this.a(var1, var2, var17);
               double var21 = this.f;
               double[] var23 = new double[2];
               y.d.q var24 = new y.d.q(0.0D, 0.0D);
               double[] var25 = new double[2];
               y.d.q var26 = new y.d.q(0.0D, 0.0D);
               if(var40) {
                  break;
               }

               label142: {
                  double var27;
                  double var29;
                  double var31;
                  B var35;
                  double var36;
                  double var38;
                  if(var17.c() == var3) {
                     if(var15 != null) {
                        var24 = var15.a(var1, var17, (byte)0, var23, true, true, (byte)2);
                        var26 = var15.a(var1, var17, (byte)0, var25, true, true, (byte)1);
                     }

                     label128: {
                        var27 = var6.getY() + var6.getHeight() * 0.5D + var18.getSourcePoint().b;
                        var29 = var7.getY() + var7.getHeight() * 0.5D + var18.getTargetPoint().b;
                        if(var27 >= var29) {
                           var31 = Math.max(var23[1], var25[1] - var27 + var29);
                           var33 = -Math.max(var25[0], var23[0] - var27 + var29);
                           if(!var40) {
                              break label128;
                           }
                        }

                        var31 = -Math.max(var23[0], var25[0] - var29 + var27);
                        var33 = Math.max(var25[1], var23[1] - var29 + var27);
                     }

                     var11 = Math.min(var11, Math.min(var27 + var31, var29 + var33));
                     var13 = Math.max(var13, Math.max(var27 + var31, var29 + var33));
                     var35 = var2.a(var17).k();
                     var36 = var35.i() / a;
                     var38 = !this.b(var2, var17)?var36:0.0D;
                     var8.a(var17, var21, Math.max(var19, var24.a) + var38, Math.max(var19, var26.a) + var38, var27 + var31, true, var29 + var33, false, false, 0.0D);
                     if(var35 == null) {
                        break label142;
                     }

                     var9 = Math.max(var9, var35.c() - Math.abs(var27 - var29));
                     if(!var40) {
                        break label142;
                     }
                  }

                  if(var15 != null) {
                     var24 = var15.a(var1, var17, (byte)0, var23, true, false, (byte)2);
                     var26 = var15.a(var1, var17, (byte)0, var25, true, false, (byte)1);
                  }

                  label122: {
                     var27 = var6.getY() + var6.getHeight() * 0.5D + var18.getTargetPoint().b;
                     var29 = var7.getY() + var7.getHeight() * 0.5D + var18.getSourcePoint().b;
                     if(var29 < var27) {
                        var31 = -Math.max(var23[0], var25[0] - var27 + var29);
                        var33 = Math.max(var25[1], var23[1] - var27 + var29);
                        if(!var40) {
                           break label122;
                        }
                     }

                     var31 = Math.max(var23[1], var25[1] - var29 + var27);
                     var33 = -Math.max(var25[0], var23[0] - var29 + var27);
                  }

                  var11 = Math.min(var11, Math.min(var29 + var31, var27 + var33));
                  var13 = Math.max(var13, Math.max(var29 + var31, var27 + var33));
                  var35 = var2.a(var17).k();
                  var36 = var35.i() / a;
                  var38 = !this.b(var2, var17)?var36:0.0D;
                  var8.a(var17, var21, Math.max(var19, var26.a) + var38, Math.max(var19, var24.a) + var38, var27 + var33, true, var29 + var31, false, false, 0.0D);
                  if(var35 != null) {
                     var9 = Math.max(var9, var35.c() - Math.abs(var29 - var27));
                  }
               }

               ++var16;
               if(!var40) {
                  continue;
               }
            }

            var8.j();
            break;
         }

         double var41 = Double.MAX_VALUE;
         double var42 = -1.7976931348623157E308D;
         int var20 = 0;

         while(true) {
            if(var20 < var5.size()) {
               y.c.d var43 = (y.c.d)var5.get(var20);
               y.f.I var22 = var1.b(var43);
               cy var44 = var8.a((Object)var43);
               if(var40) {
                  break;
               }

               if(var44 != null && !Double.isNaN(var44.d)) {
                  label153: {
                     var41 = Math.min(var41, var44.d - var44.f);
                     var42 = Math.max(var42, var44.d + var44.g);
                     double var45 = var44.d;
                     y.d.t var46 = var22.getSourcePoint();
                     y.d.t var47 = var22.getTargetPoint();
                     if(this.b(var2, var43)) {
                        if(var43.c() == var3) {
                           var22.addPoint(var45, var6.getY() + var6.getHeight() * 0.5D + var46.b);
                           var22.addPoint(var45, var7.getY() + var7.getHeight() * 0.5D + var47.b);
                           if(!var40) {
                              break label153;
                           }
                        }

                        var22.addPoint(var45, var7.getY() + var7.getHeight() * 0.5D + var46.b);
                        var22.addPoint(var45, var6.getY() + var6.getHeight() * 0.5D + var47.b);
                        if(!var40) {
                           break label153;
                        }
                     }

                     double var28;
                     double var30;
                     B var32;
                     if(var43.c() == var3) {
                        var28 = var6.getY() + var6.getHeight() * 0.5D + var46.b;
                        var30 = var7.getY() + var7.getHeight() * 0.5D + var47.b;
                        var32 = var2.a(var43).k();
                        var33 = var32.i() / a;
                        if(var44.a() == 2) {
                           if(var30 - var28 <= 2.0D * var33) {
                              var22.addPoint(var44.d - (var30 - var28) * 0.5D, var28);
                              var22.addPoint(var44.d + (var30 - var28) * 0.5D, var30);
                              if(!var40) {
                                 break label153;
                              }
                           }

                           var22.addPoint(var44.d - var33, var28);
                           var22.addPoint(var44.d, var28 + var33);
                           var22.addPoint(var44.d, var30 - var33);
                           var22.addPoint(var44.d + var33, var30);
                           if(!var40) {
                              break label153;
                           }
                        }

                        if(var28 - var30 <= 2.0D * var33) {
                           var22.addPoint(var44.d - (var28 - var30) * 0.5D, var28);
                           var22.addPoint(var44.d + (var28 - var30) * 0.5D, var30);
                           if(!var40) {
                              break label153;
                           }
                        }

                        var22.addPoint(var44.d - var33, var28);
                        var22.addPoint(var44.d, var28 - var33);
                        var22.addPoint(var44.d, var30 + var33);
                        var22.addPoint(var44.d + var33, var30);
                        if(!var40) {
                           break label153;
                        }
                     }

                     var28 = var7.getY() + var7.getHeight() * 0.5D + var46.b;
                     var30 = var6.getY() + var6.getHeight() * 0.5D + var47.b;
                     var32 = var2.a(var43).k();
                     var33 = var32.i() / a;
                     if(2 != var44.a()) {
                        if(var30 - var28 <= 2.0D * var33) {
                           var22.addPoint(var44.d + (var30 - var28) * 0.5D, var28);
                           var22.addPoint(var44.d - (var30 - var28) * 0.5D, var30);
                           if(!var40) {
                              break label153;
                           }
                        }

                        var22.addPoint(var44.d + var33, var28);
                        var22.addPoint(var44.d, var28 + var33);
                        var22.addPoint(var44.d, var30 - var33);
                        var22.addPoint(var44.d - var33, var30);
                        if(!var40) {
                           break label153;
                        }
                     }

                     if(var28 - var30 <= 2.0D * var33) {
                        var22.addPoint(var44.d + (var28 - var30) * 0.5D, var28);
                        var22.addPoint(var44.d - (var28 - var30) * 0.5D, var30);
                        if(!var40) {
                           break label153;
                        }
                     }

                     var22.addPoint(var44.d + var33, var28);
                     var22.addPoint(var44.d, var28 - var33);
                     var22.addPoint(var44.d, var30 + var33);
                     var22.addPoint(var44.d - var33, var30);
                  }
               }

               ++var20;
               if(!var40) {
                  continue;
               }
            }

            if(var41 > var42) {
               return new java.awt.geom.Rectangle2D.Double(0.0D, var11, var9, var13 - var11);
            }
            break;
         }

         return new java.awt.geom.Rectangle2D.Double(var41, var11, Math.max(var9, var42 - var41), var13 - var11);
      }
   }

   private boolean b(aV var1, y.c.d var2) {
      if(var1 != null && var1.a(var2) != null && var1.a(var2).k() != null) {
         bs var3 = var1.a(var2).k().h();
         return b(var2, var1)?var3.a() == 0:(a(var2, var1)?var3.d() == 0:var3.c() == 0);
      } else {
         return true;
      }
   }

   private static boolean a(y.c.d var0, aV var1) {
      y.c.d var2 = var1.a(var0).b();
      aX var3 = var1.a(var0.c());
      aX var4 = var1.a(var0.d());
      if(var2 == null) {
         return var3.j() == var4.j();
      } else {
         aX var5 = var1.a(var2.c());
         aX var6 = var1.a(var2.d());
         return !b(var3) && !b(var4) && !b(var5) && !b(var6) && var5.j() == var6.j();
      }
   }

   private static boolean b(aX var0) {
      return var0 == null?false:var0.b() == 15;
   }

   private static boolean b(y.c.d var0, aV var1) {
      aX var2 = var1.a(var0.c());
      aX var3 = var1.a(var0.d());
      y.c.d var4 = var1.a(var0).b();
      aX var5 = var4 == null?null:var1.a(var4.c());
      aX var6 = var4 == null?null:var1.a(var4.d());
      return var2.b() == 8 || var2.b() == 9 || var3.b() == 8 || var3.b() == 9 || b(var2) || b(var3) || b(var5) || b(var6);
   }

   public void b(y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var22 = N.x;
      int var5 = 0;

      do {
         int var10000 = var5;

         label136:
         while(true) {
            int var10001 = var2.b();

            label134:
            while(var10000 < var10001) {
               aQ var6 = var2.a(var5);
               if(var6.e() == 1) {
                  break label136;
               }

               int var7 = 0;
               y.c.y var8 = var6.d();
               int var9 = -1;
               y.c.p var10 = var8.k();

               while(true) {
                  if(var10 == null) {
                     break label136;
                  }

                  y.c.q var11 = (y.c.q)var10.c();
                  aX var12 = var3.a(var11);
                  byte var13 = var12.b();
                  var10000 = var13;
                  if(var22) {
                     continue label136;
                  }

                  if(var13 == 0 || var13 == 12 || var13 == 13 || var13 == 15) {
                     y.c.p var14 = var12.d();

                     while(var14 != null) {
                        y.c.d var15 = (y.c.d)var14.c();
                        y.c.q var16 = var15.a(var11);
                        aX var17 = var3.a(var16);
                        var10000 = var17.k();
                        var10001 = var7;
                        if(var22) {
                           continue label134;
                        }

                        if(var10000 < var7 && var9 <= var17.k()) {
                           y.f.aE var19;
                           y.f.aE var20;
                           boolean var21;
                           label125: {
                              A var18 = var3.a(var15);
                              var21 = var15.c() == var11;
                              if(var21) {
                                 var19 = var18.c();
                                 var20 = var18.e();
                                 if(!var22) {
                                    break label125;
                                 }
                              }

                              var19 = var18.e();
                              var20 = var18.c();
                           }

                           if((var19 == null || var19.g() || var19.f()) && (var20 == null || var20.g() || var20.e())) {
                              label166: {
                                 var4.d(var15);
                                 if(var21) {
                                    var4.a(var15, true, y.f.aE.a((byte)8, var19 != null && var19.a()));
                                    var4.a(var15, false, y.f.aE.a((byte)4, var20 != null && var20.a()));
                                    if(!var22) {
                                       break label166;
                                    }
                                 }

                                 var4.a(var15, false, y.f.aE.a((byte)8, var19 != null && var19.a()));
                                 var4.a(var15, true, y.f.aE.a((byte)4, var20 != null && var20.a()));
                              }
                           }
                        }

                        var14 = var14.a();
                        if(var22) {
                           break;
                        }
                     }
                  }

                  if(var13 == 0) {
                     var9 = var7;
                  }

                  var10 = var10.a();
                  ++var7;
                  if(var22) {
                     break label136;
                  }
               }
            }

            return;
         }

         ++var5;
      } while(!var22);

   }

   public void b(y.f.X var1, cr var2, aQ var3, aV var4, boolean var5, double var6) {
      boolean var42 = N.x;
      y.c.p var8 = var3.d().k();

      while(var8 != null) {
         y.c.q var10000 = (y.c.q)var8.c();

         label212:
         while(true) {
            y.c.q var9 = var10000;
            aX var10 = var4.a(var9);
            if(var10.e() <= 0) {
               break;
            }

            y.c.p var11 = var10.d();

            while(true) {
               if(var11 == null) {
                  break label212;
               }

               y.c.d var12 = (y.c.d)var11.c();
               var10000 = var12.c();
               if(var42) {
                  break;
               }

               if(var10000 == var9 && var5 == this.a(var4, var12)) {
                  label276: {
                     var1.e(var12);
                     y.f.I var13 = var1.b(var12);
                     A var14 = var4.a(var12);
                     if(var14.a() == 4) {
                        var1.d(var12);
                        if(!var42) {
                           break label276;
                        }
                     }

                     label223: {
                        y.f.aE var15 = var14.c();
                        boolean var16 = var15 != null && (var15.b() == 4 || var15.b() == 8);
                        y.f.aE var17 = var14.e();
                        boolean var18 = var17 != null && (var17.b() == 4 || var17.b() == 8);
                        double var19;
                        double var21;
                        if(this.b(var4, var12)) {
                           label185: {
                              if(var16) {
                                 var19 = var13.getPoint(0).a;
                                 var13.setPoint(0, var19, var1.p(var12).b + var6);
                                 if(!var42) {
                                    break label185;
                                 }
                              }

                              var19 = var1.p(var12).a;
                           }

                           if(var18) {
                              var21 = var13.getPoint(var13.pointCount() - 1).a;
                              var13.setPoint(var13.pointCount() - 1, var19, var2.d(var12));
                              var13.addPoint(var21, var2.d(var12));
                              var13.addPoint(var21, var1.q(var12).b + var6);
                              if(!var42) {
                                 break label223;
                              }
                           }

                           var21 = var1.q(var12).a;
                           var13.addPoint(var19, var2.d(var12));
                           var13.addPoint(var21, var2.d(var12));
                           if(!var42) {
                              break label223;
                           }
                        }

                        double var24;
                        cy var26;
                        boolean var27;
                        boolean var32;
                        double var35;
                        double var37;
                        boolean var39;
                        double var40;
                        label174: {
                           var19 = var16?var13.getPoint(0).a:var1.p(var12).a;
                           var21 = var18?var13.getPoint(var13.pointCount() - 1).a:var1.q(var12).a;
                           B var23 = var4.a(var12).k();
                           var24 = var23.i() / a;
                           var26 = var2.a((Object)var12);
                           var27 = var26.a() == 0;
                           double var28 = var27?var26.d - (var26.p - var26.b):var26.d + (var26.p - var26.b);
                           double var30 = var27?var26.d - (var26.c - var26.q):var26.d + (var26.c - var26.q);
                           var13.clearPoints();
                           var32 = var19 < var21;
                           double var33 = var32?var28:var30;
                           var35 = var32?var30:var28;
                           if(var16) {
                              var37 = var1.p(var12).b + var6;
                              var39 = var15.b() == 4;
                              var40 = Math.abs(var37 - var33);
                              if(var40 > var24) {
                                 var13.addPoint(var39?var19 - var24:var19 + var24, var37);
                                 var13.addPoint(var19, var27?var37 + var24:var37 - var24);
                                 var13.addPoint(var19, var33);
                                 if(!var42) {
                                    break label174;
                                 }
                              }

                              var13.addPoint(var39?var19 - var40:var19 + var40, var37);
                              if(var32 == var39) {
                                 break label174;
                              }

                              var13.addPoint(var19, var33);
                              if(!var42) {
                                 break label174;
                              }
                           }

                           var13.addPoint(var19, var33);
                        }

                        var13.addPoint(var32?var26.p:var26.q, var26.d);
                        var13.addPoint(var32?var26.q:var26.p, var26.d);
                        if(var18) {
                           var37 = var1.q(var12).b + var6;
                           var39 = var17.b() == 8;
                           var40 = Math.abs(var37 - var35);
                           if(var40 > var24) {
                              var13.addPoint(var21, var35);
                              var13.addPoint(var21, var27?var37 + var24:var37 - var24);
                              var13.addPoint(var39?var21 + var24:var21 - var24, var37);
                              if(!var42) {
                                 break label223;
                              }
                           }

                           if(var32 != var39) {
                              var13.addPoint(var21, var35);
                           }

                           var13.addPoint(var39?var21 + var40:var21 - var40, var37);
                           if(!var42) {
                              break label223;
                           }
                        }

                        var13.addPoint(var21, var35);
                     }

                     var1.d(var12);
                  }
               }

               var11 = var11.a();
               if(var42) {
                  break label212;
               }
            }
         }

         var8 = var8.a();
         if(var42) {
            break;
         }
      }

   }

   public boolean a(aV var1, y.c.d var2) {
      A var3 = var1.a(var2);
      return var3.j();
   }

   public y.c.f a() {
      return this.b;
   }

   public void a(double var1) {
      this.e = var1;
   }
}
