package y.f.c.a;

import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.an;
import y.f.c.a.bK;
import y.f.c.a.bP;
import y.f.c.a.bZ;
import y.f.c.a.bk;
import y.f.c.a.bs;
import y.f.c.a.bt;
import y.f.c.a.cT;
import y.f.c.a.cY;
import y.f.c.a.ca;
import y.f.c.a.cr;
import y.f.c.a.cy;
import y.f.c.a.dC;

class bY implements dC {
   private static final double a = Math.sqrt(2.0D);
   private bP b;
   private E c;
   private boolean d;
   private boolean e = true;
   private boolean f;
   private double g = 0.2D;
   private double h = 150.0D;
   private double i = 10.0D;
   private double j = 20.0D;
   private double k = 10.0D;
   private double l = 15.0D;
   private double m = 0.0D;
   private boolean n = false;
   private double o = 10.0D;
   private boolean p = false;
   private double q = 10.0D;
   private boolean r;
   private Map s;
   private long t = Long.MAX_VALUE;
   private List u = new ArrayList();
   private List v = new ArrayList();
   private List w = new ArrayList();
   private List x;
   private List y;
   private Map z;
   private bt A;
   private bt B;

   bY(bP var1, E var2) {
      this.b = var1;
      this.c = var2;
   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public void b(boolean var1) {
      this.r = var1;
   }

   void a(Map var1) {
      this.s = var1;
      Object var2 = var1.get("DefaultEdgeRouter.minimumNodeToEdgeDistance");
      if(var2 instanceof Number) {
         this.a(((Number)var2).doubleValue());
      }

      var2 = var1.get("DefaultEdgeRouter.enforceExactLayering");
      if(var2 instanceof Boolean) {
         this.b(((Boolean)var2).booleanValue());
      }

      var2 = var1.get("DefaultEdgeRouter.minimumEdgeDistance");
      if(var2 instanceof Number) {
         this.b(((Number)var2).doubleValue());
      }

      var2 = var1.get("DefaultEdgeRouter.polygonalGroupRoutingEnabled");
      if(var2 instanceof Boolean) {
         this.a(((Boolean)var2).booleanValue());
      }

      var2 = var1.get("DefaultEdgeRouter.polygonalRoutingEnabled");
      if(var2 instanceof Boolean) {
         this.e = ((Boolean)var2).booleanValue();
      }

      var2 = var1.get("DefaultEdgeRouter.defaultMaxBonusDist");
      if(var2 instanceof Number) {
         this.h = ((Number)var2).doubleValue();
      }

      var2 = var1.get("DefaultEdgeRouter.defaultMinPolyDistance");
      if(var2 instanceof Number) {
         this.i = ((Number)var2).doubleValue();
      }

      var2 = var1.get("DefaultEdgeRouter.defaultMinLayerDistance");
      if(var2 instanceof Number) {
         this.j = ((Number)var2).doubleValue();
      }

      var2 = var1.get("DefaultEdgeRouter.defaultMinPolyDistance");
      if(var2 instanceof Number) {
         this.i = ((Number)var2).doubleValue();
      }

      var2 = var1.get("DefaultEdgeRouter.defaultMinimumSlope");
      if(var2 instanceof Number) {
         this.g = ((Number)var2).doubleValue();
      }

      var2 = var1.get("DefaultEdgeRouter.defaultMinimumFirstSegmentLength");
      if(var2 instanceof Number) {
         this.k = ((Number)var2).doubleValue();
      }

      var2 = var1.get("DefaultEdgeRouter.defaultMinimumLastSegmentLength");
      if(var2 instanceof Number) {
         this.l = ((Number)var2).doubleValue();
      }

      var2 = var1.get("DefaultEdgeRouter.fromSketchMode");
      if(var2 instanceof Boolean) {
         this.n = ((Boolean)var2).booleanValue();
      }

      var2 = var1.get("DefaultEdgeRouter.assignLaneToProxyNodes");
      if(var2 instanceof Boolean) {
         this.p = ((Boolean)var2).booleanValue();
      }

   }

   public void a(y.f.X var1, aU var2, aV var3) {
      boolean var11 = N.x;
      this.z = new HashMap();
      this.b(var1, var2, var3);
      Iterator var4 = this.z.entrySet().iterator();

      label26:
      while(true) {
         if(var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            y.c.d var6 = (y.c.d)var5.getKey();
            y.c.D var7 = (y.c.D)var5.getValue();
            y.f.I var8 = var1.b(var6);
            var8.clearPoints();
            y.c.p var9 = var7.k();

            do {
               if(var9 == null) {
                  continue label26;
               }

               Double var10 = (Double)var9.c();
               var8.addPoint(var10.x, var10.y);
               var9 = var9.a();
               if(var11 || var11) {
                  return;
               }
            } while(!var11);
         }

         this.z = null;
         return;
      }
   }

   private static bK a(y.c.d var0, y.c.q var1, aV var2) {
      bK var3 = var2.a(var1).h();
      aX var4 = var2.a(var0.a(var1));
      if(var4.b() == 2) {
         return var3;
      } else {
         bK var5 = var4.h();
         return var3 != null && var3.equals(var5)?var3:null;
      }
   }

   public void a(y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var37 = N.x;
      y.f.ae.a(var1, false);
      this.u.clear();
      this.v.clear();
      this.w.clear();
      ArrayList var5 = new ArrayList(32);
      ArrayList var6 = new ArrayList(32);
      ArrayList var7 = new ArrayList(32);
      ArrayList var8 = new ArrayList(32);
      ArrayList var9 = new ArrayList(32);
      ArrayList var10 = new ArrayList(32);
      ArrayList var11 = new ArrayList(32);
      ArrayList var12 = new ArrayList(32);
      ArrayList var13 = new ArrayList(32);
      ArrayList var14 = new ArrayList(32);
      ArrayList var15 = new ArrayList(32);
      ArrayList var16 = new ArrayList(32);
      ArrayList var17 = new ArrayList(32);
      cY var18 = new cY(var1, var2, var3);
      cT var19 = new cT(var1, var2, var3);
      ca var20 = new ca(var1);
      int var21 = 0;

      do {
         int var10000 = var21;

         label500:
         while(true) {
            if(var10000 >= var2.b()) {
               return;
            }

            aQ var22 = var2.a(var21);
            int var23 = 0;
            y.c.y var24 = var22.d();
            y.c.q var25 = null;
            y.c.p var26 = var24.k();

            while(true) {
               if(var26 == null) {
                  break label500;
               }

               Object var44 = var26.c();

               label510: {
                  y.c.q var27;
                  y.c.p var38;
                  label494:
                  while(true) {
                     y.c.d var39;
                     A var40;
                     label475:
                     while(true) {
                        var27 = (y.c.q)var44;
                        aX var28 = var3.a(var27);
                        var10000 = var28.b();
                        if(var37) {
                           continue label500;
                        }

                        if(var10000 != 0 && var28.b() != 12 && var28.b() != 13 && var28.b() != 15) {
                           break label510;
                        }

                        if(var17.size() != 0) {
                           java.awt.geom.Rectangle2D.Double var29 = this.b.a(var1, var3, var25, var27, var17);
                           if(var29 != null) {
                              this.w.add(var4.a(var22, var29, (y.c.d[])var17.toArray(new y.c.d[var17.size()])));
                              y.c.p var30 = var24.l();
                              var24.h(var30);
                              var24.a(var30, var26);
                           }
                        }

                        var20.a = var27;
                        var25 = var27;
                        var17.clear();
                        var9.clear();
                        var11.clear();
                        var10.clear();
                        var12.clear();
                        var13.clear();
                        var15.clear();
                        var14.clear();
                        var16.clear();
                        var38 = var28.d();

                        y.c.q var45;
                        label455: {
                           while(var38 != null) {
                              var39 = (y.c.d)var38.c();
                              y.c.q var31 = var39.a(var27);
                              A var32 = var3.a(var39);
                              y.f.I var33 = var1.b(var39);
                              int var35 = var3.a(var31).k() - var28.k();
                              var45 = var39.c();
                              if(var37) {
                                 break label455;
                              }

                              y.f.aE var34;
                              label451: {
                                 boolean var36 = var45 == var27;
                                 if(var36) {
                                    var34 = var32.c();
                                    if(!var37) {
                                       break label451;
                                    }
                                 }

                                 var34 = var32.e();
                              }

                              label446: {
                                 if(var3.a(var39).a() == 4) {
                                    if(var35 <= 0) {
                                       break label446;
                                    }

                                    var17.add(var39);
                                    if(!var37) {
                                       break label446;
                                    }
                                 }

                                 var33.clearPoints();
                                 if(var34 != null && !var34.c() && !var34.d() && !var34.g()) {
                                    label514: {
                                       if(var34.e()) {
                                          if(var35 < 0) {
                                             if(var32.j()) {
                                                var10.add(var39);
                                                if(!var37) {
                                                   break label514;
                                                }
                                             }

                                             var14.add(var39);
                                             if(!var37) {
                                                break label514;
                                             }
                                          }

                                          if(var32.j()) {
                                             var12.add(var39);
                                             if(!var37) {
                                                break label514;
                                             }
                                          }

                                          var16.add(var39);
                                          if(!var37) {
                                             break label514;
                                          }
                                       }

                                       if(var35 > 0) {
                                          if(var32.j()) {
                                             var9.add(var39);
                                             if(!var37) {
                                                break label514;
                                             }
                                          }

                                          var13.add(var39);
                                          if(!var37) {
                                             break label514;
                                          }
                                       }

                                       if(var32.j()) {
                                          var11.add(var39);
                                          if(!var37) {
                                             break label514;
                                          }
                                       }

                                       var15.add(var39);
                                    }
                                 }
                              }

                              var38 = var38.a();
                              if(var37) {
                                 break;
                              }
                           }

                           var5.clear();
                           var6.clear();
                           var38 = var26;
                           var45 = var27;
                        }

                        var39 = var45.g();

                        while(true) {
                           if(var39 == null) {
                              break label475;
                           }

                           var40 = var3.a(var39);
                           var44 = var40.e();
                           if(var37) {
                              break;
                           }

                           if(var44 != null && !var40.e().c()) {
                              label535: {
                                 if(var40.e().f()) {
                                    var5.add(var39);
                                    if(!var37) {
                                       break label535;
                                    }
                                 }

                                 if(var40.e().e()) {
                                    var6.add(var39);
                                 }
                              }
                           }

                           var39 = var39.h();
                           if(var37) {
                              break label475;
                           }
                        }
                     }

                     var7.clear();
                     var8.clear();
                     var39 = var27.f();

                     while(true) {
                        if(var39 == null) {
                           break label494;
                        }

                        var40 = var3.a(var39);
                        var44 = var40.c();
                        if(var37) {
                           break;
                        }

                        if(var44 != null && !var40.c().d()) {
                           label537: {
                              if(var40.c().f()) {
                                 var7.add(var39);
                                 if(!var37) {
                                    break label537;
                                 }
                              }

                              if(var40.c().e()) {
                                 var8.add(var39);
                              }
                           }
                        }

                        var39 = var39.g();
                        if(var37) {
                           break label494;
                        }
                     }
                  }

                  int var41;
                  y.c.d var42;
                  y.c.p var43;
                  label404: {
                     if(var15.size() > 0) {
                        y.g.e.a((List)var15, var20);
                        var41 = var15.size() - 1;

                        while(var41 >= 0) {
                           var42 = (y.c.d)var15.get(var41);
                           var10000 = this.p;
                           if(var37) {
                              break label404;
                           }

                           label398: {
                              if(var10000 != 0) {
                                 this.v.add(var4.a(var22, var27, var42, a(var42, var27, var3)));
                                 if(!var37) {
                                    break label398;
                                 }
                              }

                              this.v.add(var4.a(var22, var27, var42));
                           }

                           var43 = var24.l();
                           var24.h(var43);
                           var24.a(var43, var26);
                           --var41;
                           if(var37) {
                              break;
                           }
                        }
                     }

                     var10000 = var7.size();
                  }

                  label387: {
                     if(var10000 > 0) {
                        y.g.e.a((List)var7, var19);
                        var41 = 0;

                        while(var41 < var7.size()) {
                           var42 = (y.c.d)var7.get(var41);
                           var10000 = this.p;
                           if(var37) {
                              break label387;
                           }

                           label381: {
                              if(var10000 != 0) {
                                 this.u.add(var4.a(var42, true, a(var42, var27, var3)));
                                 if(!var37) {
                                    break label381;
                                 }
                              }

                              this.u.add(var4.a(var42, true));
                           }

                           var43 = var24.l();
                           var24.h(var43);
                           var24.a(var43, var26);
                           ++var41;
                           if(var37) {
                              break;
                           }
                        }
                     }

                     var10000 = var13.size();
                  }

                  label370: {
                     if(var10000 > 0) {
                        y.g.e.a((List)var13, var20);
                        var41 = var13.size() - 1;

                        while(var41 >= 0) {
                           var42 = (y.c.d)var13.get(var41);
                           var10000 = this.p;
                           if(var37) {
                              break label370;
                           }

                           label364: {
                              if(var10000 != 0) {
                                 this.v.add(var4.a(var22, var27, var42, a(var42, var27, var3)));
                                 if(!var37) {
                                    break label364;
                                 }
                              }

                              this.v.add(var4.a(var22, var27, var42));
                           }

                           var43 = var24.l();
                           var24.h(var43);
                           var24.a(var43, var26);
                           --var41;
                           if(var37) {
                              break;
                           }
                        }
                     }

                     var10000 = var11.size();
                  }

                  label353: {
                     if(var10000 > 0) {
                        y.g.e.a((List)var11, var20);
                        var41 = 0;

                        while(var41 < var11.size()) {
                           var42 = (y.c.d)var11.get(var41);
                           var10000 = this.p;
                           if(var37) {
                              break label353;
                           }

                           label347: {
                              if(var10000 != 0) {
                                 this.v.add(var4.a(var22, var27, var42, a(var42, var27, var3)));
                                 if(!var37) {
                                    break label347;
                                 }
                              }

                              this.v.add(var4.a(var22, var27, var42));
                           }

                           var43 = var24.l();
                           var24.h(var43);
                           var24.a(var43, var26);
                           ++var41;
                           if(var37) {
                              break;
                           }
                        }
                     }

                     var10000 = var5.size();
                  }

                  label336: {
                     if(var10000 > 0) {
                        y.g.e.a((List)var5, var18);
                        var41 = 0;

                        while(var41 < var5.size()) {
                           var42 = (y.c.d)var5.get(var41);
                           var10000 = this.p;
                           if(var37) {
                              break label336;
                           }

                           label330: {
                              if(var10000 != 0) {
                                 this.u.add(var4.a(var42, false, a(var42, var27, var3)));
                                 if(!var37) {
                                    break label330;
                                 }
                              }

                              this.u.add(var4.a(var42, false));
                           }

                           var43 = var24.l();
                           var24.h(var43);
                           var24.a(var43, var26);
                           ++var41;
                           if(var37) {
                              break;
                           }
                        }
                     }

                     var10000 = var9.size();
                  }

                  label319: {
                     if(var10000 > 0) {
                        y.g.e.a((List)var9, var20);
                        var41 = 0;

                        while(var41 < var9.size()) {
                           var42 = (y.c.d)var9.get(var41);
                           var10000 = this.p;
                           if(var37) {
                              break label319;
                           }

                           label313: {
                              if(var10000 != 0) {
                                 this.v.add(var4.a(var22, var27, var42, a(var42, var27, var3)));
                                 if(!var37) {
                                    break label313;
                                 }
                              }

                              this.v.add(var4.a(var22, var27, var42));
                           }

                           var43 = var24.l();
                           var24.h(var43);
                           var24.a(var43, var26);
                           ++var41;
                           if(var37) {
                              break;
                           }
                        }
                     }

                     var10000 = var10.size();
                  }

                  label302: {
                     if(var10000 > 0) {
                        y.g.e.a((List)var10, var20);
                        var41 = var10.size() - 1;

                        while(var41 >= 0) {
                           var42 = (y.c.d)var10.get(var41);
                           var10000 = this.p;
                           if(var37) {
                              break label302;
                           }

                           label296: {
                              if(var10000 != 0) {
                                 this.v.add(var4.a(var22, var27, var42, a(var42, var27, var3)));
                                 if(!var37) {
                                    break label296;
                                 }
                              }

                              this.v.add(var4.a(var22, var27, var42));
                           }

                           var43 = var24.l();
                           var24.h(var43);
                           var24.b(var43, var38);
                           var38 = var43;
                           --var41;
                           if(var37) {
                              break;
                           }
                        }
                     }

                     var10000 = var6.size();
                  }

                  label285: {
                     if(var10000 > 0) {
                        y.g.e.a((List)var6, var18);
                        var41 = 0;

                        while(var41 < var6.size()) {
                           var42 = (y.c.d)var6.get(var41);
                           var10000 = this.p;
                           if(var37) {
                              break label285;
                           }

                           label279: {
                              if(var10000 != 0) {
                                 this.u.add(var4.a(var42, false, a(var42, var27, var3)));
                                 if(!var37) {
                                    break label279;
                                 }
                              }

                              this.u.add(var4.a(var42, false));
                           }

                           var43 = var24.l();
                           var24.h(var43);
                           var24.b(var43, var38);
                           var38 = var43;
                           ++var41;
                           if(var37) {
                              break;
                           }
                        }
                     }

                     var10000 = var12.size();
                  }

                  label268: {
                     if(var10000 > 0) {
                        y.g.e.a((List)var12, var20);
                        var41 = var12.size() - 1;

                        while(var41 >= 0) {
                           var42 = (y.c.d)var12.get(var41);
                           var10000 = this.p;
                           if(var37) {
                              break label268;
                           }

                           label262: {
                              if(var10000 != 0) {
                                 this.v.add(var4.a(var22, var27, var42, a(var42, var27, var3)));
                                 if(!var37) {
                                    break label262;
                                 }
                              }

                              this.v.add(var4.a(var22, var27, var42));
                           }

                           var43 = var24.l();
                           var24.h(var43);
                           var24.b(var43, var38);
                           var38 = var43;
                           --var41;
                           if(var37) {
                              break;
                           }
                        }
                     }

                     var10000 = var14.size();
                  }

                  label251: {
                     if(var10000 > 0) {
                        y.g.e.a((List)var14, var20);
                        var41 = 0;

                        while(var41 < var14.size()) {
                           var42 = (y.c.d)var14.get(var41);
                           var10000 = this.p;
                           if(var37) {
                              break label251;
                           }

                           label245: {
                              if(var10000 != 0) {
                                 this.v.add(var4.a(var22, var27, var42, a(var42, var27, var3)));
                                 if(!var37) {
                                    break label245;
                                 }
                              }

                              this.v.add(var4.a(var22, var27, var42));
                           }

                           var43 = var24.l();
                           var24.h(var43);
                           var24.b(var43, var38);
                           var38 = var43;
                           ++var41;
                           if(var37) {
                              break;
                           }
                        }
                     }

                     var10000 = var8.size();
                  }

                  label234: {
                     if(var10000 > 0) {
                        y.g.e.a((List)var8, var19);
                        var41 = 0;

                        while(var41 < var8.size()) {
                           var42 = (y.c.d)var8.get(var41);
                           var10000 = this.p;
                           if(var37) {
                              break label234;
                           }

                           label228: {
                              if(var10000 != 0) {
                                 this.u.add(var4.a(var42, true, a(var42, var27, var3)));
                                 if(!var37) {
                                    break label228;
                                 }
                              }

                              this.u.add(var4.a(var42, true));
                           }

                           var43 = var24.l();
                           var24.h(var43);
                           var24.b(var43, var38);
                           var38 = var43;
                           ++var41;
                           if(var37) {
                              break;
                           }
                        }
                     }

                     var10000 = var16.size();
                  }

                  if(var10000 > 0) {
                     y.g.e.a((List)var16, var20);
                     var41 = 0;

                     while(var41 < var16.size()) {
                        var42 = (y.c.d)var16.get(var41);
                        var10000 = this.p;
                        if(var37) {
                           continue label500;
                        }

                        label212: {
                           if(var10000 != 0) {
                              this.v.add(var4.a(var22, var27, var42, a(var42, var27, var3)));
                              if(!var37) {
                                 break label212;
                              }
                           }

                           this.v.add(var4.a(var22, var27, var42));
                        }

                        var43 = var24.l();
                        var24.h(var43);
                        var24.b(var43, var38);
                        var38 = var43;
                        ++var41;
                        if(var37) {
                           break;
                        }
                     }
                  }

                  var26 = var38;
               }

               var26 = var26.a();
               ++var23;
               if(var37) {
                  break label500;
               }
            }
         }

         ++var21;
      } while(!var37);

   }

   public void b(y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var7 = N.x;
      int var5 = 0;

      while(true) {
         if(var5 < this.u.size()) {
            y.c.q var6 = (y.c.q)this.u.get(var5);
            var4.b(var6);
            ++var5;
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         this.u.clear();
         break;
      }

   }

   public void c(y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var24 = N.x;
      int var7 = 0;

      while(true) {
         if(var7 < this.v.size()) {
            y.c.q var8 = (y.c.q)this.v.get(var7);
            aX var9 = var3.a(var8);
            y.c.q var10 = var9.f();
            y.c.d var11 = var9.g();
            aX var12 = var3.a(var10);
            y.f.am var13 = var1.a((Object)var10);
            if(var24) {
               break;
            }

            y.f.aE var14 = var10 == var11.c()?var3.a(var11).c():var3.a(var11).e();
            if(var14 != null && (var14.e() || var14.f()) && var3.a(var10).b() == 0) {
               label71: {
                  y.d.t var15 = var1.o(var8);
                  y.d.c var16 = var12.a(0, var13);
                  y.d.c var17 = var12.a(2, var13);
                  double var18 = var15.a - var13.getX();
                  double var20;
                  if(var15.a > var13.getX()) {
                     var20 = var13.getWidth();
                     double var22 = Math.abs(var20 - var18) > 1.0E-4D?var18:var20;
                     if(var16 != null) {
                        var16.a(var20, var22, var15.b - var13.getY());
                     }

                     if(var17 == null) {
                        break label71;
                     }

                     var17.b(var20, var22, var15.b - var13.getY());
                     if(!var24) {
                        break label71;
                     }
                  }

                  var20 = Math.abs(var18) > 1.0E-4D?var18:0.0D;
                  if(var16 != null) {
                     var16.a(var20, 0.0D, var15.b - var13.getY());
                  }

                  if(var17 != null) {
                     var17.b(var20, 0.0D, var15.b - var13.getY());
                  }
               }
            }

            var4.a(var8);
            ++var7;
            if(!var24) {
               continue;
            }
         }

         this.v.clear();
         break;
      }

   }

   public void d(y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var7 = N.x;
      int var5 = 0;

      while(true) {
         if(var5 < this.w.size()) {
            y.c.q var6 = (y.c.q)this.w.get(var5);
            var4.e(var6);
            ++var5;
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         this.w.clear();
         break;
      }

   }

   public void e(y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var14 = N.x;
      this.x = new ArrayList(62);
      this.y = new ArrayList(62);
      int var5 = 0;

      do {
         int var10000 = var5;

         label73:
         while(true) {
            int var10001 = var2.b();

            label71:
            while(var10000 < var10001) {
               aQ var6 = var2.a(var5);
               y.c.p var7 = var6.d().k();

               while(true) {
                  if(var7 == null) {
                     break label73;
                  }

                  y.c.q var8 = (y.c.q)var7.c();
                  byte var9 = var3.a(var8).b();
                  var10000 = var9;
                  if(var14) {
                     continue label73;
                  }

                  if(var9 == 0 || var9 == 15) {
                     y.c.d var10 = var8.i();

                     y.c.d var11;
                     A var12;
                     aX var13;
                     while(var10 != null) {
                        var11 = var10.j();
                        var12 = var3.a(var10);
                        var13 = var3.a(var10.c());
                        var10000 = var13.j();
                        var10001 = var5;
                        if(var14) {
                           continue label71;
                        }

                        label62: {
                           if(var10000 == var5) {
                              this.a(var1, var6, var12, var4, var8, var10);
                              if(!var14) {
                                 break label62;
                              }
                           }

                           this.b(var1, var6, var12, var4, var8, var10);
                        }

                        var10 = var11;
                        if(var14) {
                           break;
                        }
                     }

                     var10 = var8.h();

                     while(var10 != null) {
                        var11 = var10.i();
                        var12 = var3.a(var10);
                        var13 = var3.a(var10.d());
                        var10000 = var13.j();
                        var10001 = var5;
                        if(var14) {
                           continue label71;
                        }

                        if(var10000 != var5) {
                           this.b(var1, var6, var12, var4, var8, var10);
                        }

                        var10 = var11;
                        if(var14) {
                           break;
                        }
                     }
                  }

                  var7 = var7.a();
                  if(var14) {
                     break label73;
                  }
               }
            }

            return;
         }

         ++var5;
      } while(!var14);

   }

   public void a(y.f.X var1, aQ var2, A var3, aP var4, y.c.q var5, y.c.d var6) {
      y.f.aE var7 = var3.c();
      y.f.aE var8 = var3.e();
      if(var7 != null && var8 != null && (var7.d() && var8.c() || var7.c() && var8.d())) {
         this.y.add(var4.b(var2, var6));
      }

   }

   public void b(y.f.X var1, aQ var2, A var3, aP var4, y.c.q var5, y.c.d var6) {
      y.c.d var7;
      if(var5 == var6.d()) {
         if(var3.e() == null || !var3.e().d()) {
            return;
         }

         var7 = var4.a(var2, var6, var5);
         this.x.add(var7);
         if(!N.x) {
            return;
         }
      }

      if(var3.c() != null && var3.c().c()) {
         var7 = var4.a(var2, var6, var5);
         this.x.add(var7);
      }

   }

   public void f(y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var7 = N.x;
      int var5 = 0;

      while(true) {
         if(var5 < this.x.size()) {
            y.c.d var6 = (y.c.d)this.x.get(var5);
            var4.c(var6);
            ++var5;
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         var5 = 0;
         break;
      }

      while(true) {
         if(var5 < this.y.size()) {
            y.c.q var8 = (y.c.q)this.y.get(var5);
            var4.d(var8);
            ++var5;
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         this.y.clear();
         this.y = null;
         this.x.clear();
         this.x = null;
         break;
      }

   }

   private boolean a(aQ var1, aQ var2) {
      bt var3 = var1.b();
      bt var4 = var2.b();
      return var3 != null && var4 != null?var3 != var4:(var3 == null && var4 == null?false:var3 == null && var4 != this.B || var4 == null && var3 != this.B);
   }

   private y.c.D a(bt var1, bt var2, y.f.X var3) {
      boolean var9 = N.x;
      bk var4 = bk.c(var3);
      y.c.D var5 = new y.c.D();
      y.c.D var10000;
      if(var4 != null && (var1 != null || var2 != null)) {
         label65: {
            int var6;
            int var7;
            if(var1 == null) {
               var6 = var2.a();
               var7 = 0;

               do {
                  if(var7 >= var6) {
                     break label65;
                  }

                  var10000 = var5;
                  if(var9) {
                     return var10000;
                  }

                  var5.b((Object)var4.a(var7));
                  ++var7;
               } while(!var9);
            }

            if(var2 == null) {
               var6 = var1.a();
               var7 = var6 + 1;

               do {
                  if(var7 >= var4.e().size()) {
                     break label65;
                  }

                  var10000 = var5;
                  if(var9) {
                     return var10000;
                  }

                  var5.b((Object)var4.a(var7));
                  ++var7;
               } while(!var9);
            }

            var6 = Math.min(var1.a(), var2.a());
            var7 = Math.max(var1.a(), var2.a());
            int var8 = var6 + 1;

            while(var8 < var7) {
               var10000 = var5;
               if(var9) {
                  return var10000;
               }

               var5.b((Object)var4.a(var8));
               ++var8;
               if(var9) {
                  break;
               }
            }
         }
      }

      var10000 = var5;
      return var10000;
   }

   private void a(bt var1, y.f.X var2) {
      boolean var8 = N.x;
      y.c.D var3 = this.a((bt)null, (bt)var1, (y.f.X)var2);
      if(!var3.isEmpty()) {
         var3.n();
         double var4 = var1.h();
         y.c.C var6 = var3.m();

         while(var6.f()) {
            bt var7 = (bt)var6.d();
            var4 -= var7.b();
            var7.g(var4);
            var7.d(var7.b());
            var6.g();
            if(var8) {
               break;
            }
         }
      }

   }

   private void b(bt var1, y.f.X var2) {
      boolean var8 = N.x;
      y.c.D var3 = this.a((bt)var1, (bt)null, (y.f.X)var2);
      if(!var3.isEmpty()) {
         double var4 = var1.h() + var1.e();
         y.c.C var6 = var3.m();

         while(var6.f()) {
            bt var7 = (bt)var6.d();
            var7.g(var4);
            var7.d(var7.b());
            var4 += var7.e();
            var6.g();
            if(var8) {
               break;
            }
         }
      }

   }

   private double b(bt var1, bt var2, y.f.X var3) {
      boolean var9 = N.x;
      double var4 = var1.h() + var1.e();
      y.c.D var6 = this.a(var1, var2, var3);
      y.c.C var7 = var6.m();

      double var10000;
      while(true) {
         if(var7.f()) {
            bt var8 = (bt)var7.d();
            var8.g(var4);
            var8.d(var8.b());
            var10000 = var4 + var8.e();
            if(var9) {
               break;
            }

            var4 = var10000;
            var7.g();
            if(!var9) {
               continue;
            }
         }

         var10000 = var4;
         break;
      }

      return var10000;
   }

   private double c(bt var1, bt var2, y.f.X var3) {
      boolean var9 = N.x;
      double var4 = 0.0D;
      y.c.D var6 = this.a(var1, var2, var3);
      double var10000;
      if(!var6.isEmpty()) {
         y.c.C var7 = var6.m();

         while(var7.f()) {
            bt var8 = (bt)var7.d();
            var10000 = var4 + var8.b();
            if(var9) {
               return var10000;
            }

            var4 = var10000;
            var7.g();
            if(var9) {
               break;
            }
         }
      }

      var10000 = var4;
      return var10000;
   }

   private boolean a(y.f.X var1, aV var2) {
      boolean var5 = N.x;
      if(var2 == null) {
         return false;
      } else {
         y.c.e var3 = var1.p();

         while(true) {
            if(var3.f()) {
               A var4 = var2.a(var3.a());
               if(var4 == null || var4.k() == null || var4.k().h().b() != 2) {
                  return false;
               }

               var3.g();
               if(!var5) {
                  continue;
               }
            }

            return true;
         }
      }
   }

   private void b(y.f.X var1, aU var2, aV var3) {
      ArrayList var5;
      double var6;
      cr var8;
      long var9;
      boolean var57;
      label1121: {
         var57 = N.x;
         var5 = new ArrayList(120);
         var6 = 0.0D;
         var8 = new cr();
         var9 = System.currentTimeMillis();
         long var11 = this.t == Long.MAX_VALUE?Long.MAX_VALUE:this.t / (long)var2.b();
         var8.a(var11);
         if(this.t < 10L) {
            var8.a(0);
            var8.b(0);
            var8.c(0);
            if(!var57) {
               break label1121;
            }
         }

         var8.a(Integer.MAX_VALUE);
         var8.b(Integer.MAX_VALUE);
         var8.c(Integer.MAX_VALUE);
      }

      if(this.s != null) {
         Object var13 = this.s.get("ChannelRouter.maximalConstraintSimplexDuration");
         if(var13 instanceof Number) {
            var8.a(((Number)var13).longValue());
         }

         var13 = this.s.get("ChannelRouter.segmentMisgraphEdgeLimit");
         if(var13 instanceof Number) {
            var8.a(((Number)var13).intValue());
         }

         var13 = this.s.get("ChannelRouter.maxConstraintsCount");
         if(var13 instanceof Number) {
            var8.c(((Number)var13).intValue());
         }

         var13 = this.s.get("ChannelRouter.segmentMisGraphLimit");
         if(var13 instanceof Number) {
            var8.b(((Number)var13).intValue());
         }
      }

      HashMap var58 = new HashMap();
      Iterator var14 = this.w.iterator();

      label1115:
      while(true) {
         if(var14.hasNext()) {
            y.c.q var15 = (y.c.q)var14.next();
            an var16 = (an)var3.a(var15);
            int var17 = 0;

            do {
               if(var17 >= var16.a.length) {
                  continue label1115;
               }

               y.c.d var18 = var16.a[var17];
               var58.put(var18, var15);
               ++var17;
               if(var57 || var57) {
                  break label1115;
               }
            } while(!var57);
         }

         var8.c(0.0D);
         break;
      }

      y.d.c var59 = new y.d.c(-1.7976931348623157E308D, java.lang.Double.MAX_VALUE, -1.7976931348623157E308D);
      boolean var60 = this.a(var1, var3);
      int var61 = 0;

      while(var61 < var2.b()) {
         aQ var62 = var2.a(var61);
         y.c.y var63 = var62.d();
         y.d.c var19 = new y.d.c(-1.7976931348623157E308D, java.lang.Double.MAX_VALUE, java.lang.Double.MAX_VALUE);
         double var20 = -1.7976931348623157E308D;
         y.c.p var22 = var63.l();

         int var10000;
         while(true) {
            if(var22 != null) {
               y.c.q var23 = (y.c.q)var22.c();
               y.f.am var24 = var1.a((Object)var23);
               var24.setLocation(var24.getX(), var24.getY() + var6);
               var10000 = var61;
               if(var57) {
                  break;
               }

               if(var61 == 0) {
                  this.a(var1, var3, var19, var23, var24, 0.0D, true);
               }

               this.a(var1, var3, var59, var23, var24, 0.0D, false);
               var20 = Math.max(var20, var24.getY() + var24.getHeight());
               var22 = var22.b();
               if(!var57) {
                  continue;
               }
            }

            var8.b(var59);
            var10000 = var61;
            break;
         }

         double var64;
         if(var10000 == 0) {
            var8.a(var19);
            this.b.a(var1, var8, var62, var3, true, var6);
            this.c.a(var8, var62, true, var6);
            this.A = var62.b();
            if(this.A != null) {
               var8.a(this.A, 0.0D, 0.0D, this.A.c(), -1.7976931348623157E308D, false, java.lang.Double.MAX_VALUE, false);
            }

            var8.j();
            this.b.b(var1, var8, var62, var3, true, 0.0D);
            this.b.a(var1, var59, var62, var3, 0.0D, var58);
            this.c.b(var8, var62, true, 0.0D);
            if(this.A != null) {
               var64 = var8.d(this.A);
               this.A.g(var64);
               this.a(this.A, var1);
               this.B = this.A;
            }
         }

         var8.a();
         if(System.currentTimeMillis() - var9 > this.t) {
            var8.a(100);
            var8.b(20);
            var8.c(500);
         }

         label1129: {
            this.b.a(var1, var8, var62, var3, false, var6);
            this.c.a(var8, var62, false, var6);
            var64 = var59.d();
            var8.b(var64);
            var5.clear();
            if(var61 < var2.b() - 1) {
               double var25;
               aQ var27;
               aQ var65;
               label1081: {
                  var65 = var2.a(var61 + 1);
                  var25 = 0.0D;
                  if(var61 < var2.b() - 2) {
                     var27 = var2.a(var61 + 2);
                     if(!var57) {
                        break label1081;
                     }
                  }

                  var27 = null;
               }

               boolean var28;
               boolean var29;
               label1237: {
                  if(this.f || var60) {
                     var29 = false;
                     var28 = false;
                     if(!var57) {
                        break label1237;
                     }
                  }

                  label1132: {
                     byte var30 = var65.e();
                     if(var30 == 2) {
                        var28 = true;
                        var29 = var27 != null && var27.e() == 3;
                        if(!var57) {
                           break label1132;
                        }
                     }

                     if(var30 == 3) {
                        var28 = false;
                        var29 = true;
                        if(!var57) {
                           break label1132;
                        }
                     }

                     var28 = false;
                     var29 = false;
                  }

                  if(var28 && var29) {
                     var61 += 2;
                     if(!var57) {
                        break label1237;
                     }
                  }

                  if(var28 || var29) {
                     ++var61;
                  }
               }

               aQ var68 = var2.a(var61 + 1);
               this.A = null;
               double var31;
               if(this.a(var62, var68)) {
                  this.A = var68.b();
                  var31 = this.c(this.B, this.A, var1);
                  cy var33 = var8.a(this.A, var31, this.B.d(), this.A.c(), -1.7976931348623157E308D, false, java.lang.Double.MAX_VALUE, true);
                  var33.k = this.B.h() + this.B.b() + var31 * 0.5D;
                  var33.i = var33.k;
               }

               var31 = java.lang.Double.MAX_VALUE;
               y.d.c var69 = new y.d.c(-1.7976931348623157E308D, java.lang.Double.MAX_VALUE, java.lang.Double.MAX_VALUE);
               y.c.p var34 = var68.d().l();

               label1046: {
                  while(var34 != null) {
                     y.c.q var35 = (y.c.q)var34.c();
                     y.f.am var36 = var1.a(var34.c());
                     var31 = Math.min(var31, var36.getY() + var6);
                     this.a(var1, var3, var69, var35, var36, var6, true);
                     var34 = var34.b();
                     if(var57) {
                        break label1046;
                     }

                     if(var57) {
                        break;
                     }
                  }

                  var8.a(var69);
               }

               label1036: {
                  label1035: {
                     y.c.q var37;
                     y.c.d var39;
                     y.d.t var40;
                     cy var43;
                     double var47;
                     y.c.p var71;
                     Object var72;
                     double var76;
                     y.c.d var77;
                     double var78;
                     y.d.t var80;
                     double var82;
                     double var84;
                     y.c.d var87;
                     y.d.t var88;
                     double var96;
                     y.c.D var108;
                     y.c.D var110;
                     Object var116;
                     label1219: {
                        double var70 = -var59.c(var69) + this.b();
                        this.b.a(var1, var8, var68, var3, true, var6);
                        this.c.a(var8, var68, true, var6);
                        cy var45;
                        if(!var28 && !var29) {
                           var71 = var63.k();

                           byte var38;
                           y.d.t var41;
                           while(var71 != null) {
                              var37 = (y.c.q)var71.c();
                              var116 = var37.f();
                              if(var57) {
                                 break label1219;
                              }

                              if(var116 != null) {
                                 var38 = var3.a(var37).b();
                                 if(var38 != 12 && var38 != 13) {
                                    var39 = var37.f();

                                    while(var39 != null) {
                                       var40 = var1.p(var39);
                                       var41 = var1.q(var39);
                                       double var117;
                                       var10000 = (var117 = var40.a - var41.a) == 0.0D?0:(var117 < 0.0D?-1:1);
                                       if(var57) {
                                          break label1036;
                                       }

                                       if(var10000 != 0) {
                                          label1197: {
                                             if(this.d(var3, var39)) {
                                                var5.add(var39);
                                                if(!var57) {
                                                   break label1197;
                                                }
                                             }

                                             double var42 = this.a(var1, var3, var39);
                                             B var44 = var3.a(var39).k();
                                             var45 = var8.a(var39, this.m, var42, var40.a, true, var41.a, false, this.b(var3, var39), var44.i());
                                             if(a(var3.a(var39.c()))) {
                                                var45.k = var40.b + this.a(var3, var39, true);
                                                var45.i = var40.b;
                                             }

                                             if(a(var3.a(var39.d()))) {
                                                var45.l = var41.b + var6 - this.a(var3, var39, false);
                                                var45.j = var41.b + var6;
                                             }
                                          }
                                       }

                                       if(a(var3.a(var39.c())) && a(var3.a(var39.d()))) {
                                          var70 = this.a(var1, var3, var39, var40.a, var40.b, var41.a, var41.b + var6, var6, var70);
                                       }

                                       var39 = var39.g();
                                       if(var57) {
                                          break;
                                       }
                                    }
                                 }
                              }

                              var71 = var71.a();
                              if(var57) {
                                 break;
                              }
                           }

                           var25 += this.a(var1, var3, var62, var20, var68, var31, var8, var5, var6, var70);
                           var71 = var63.k();
                           if(var71 == null) {
                              break label1035;
                           }

                           while(true) {
                              var37 = (y.c.q)var71.c();
                              var116 = var37.f();
                              if(var57) {
                                 break label1219;
                              }

                              if(var116 != null) {
                                 var38 = var3.a(var37).b();
                                 if(var38 != 12 && var38 != 13) {
                                    var39 = var37.f();

                                    while(var39 != null) {
                                       var40 = var1.p(var39);
                                       var41 = var1.q(var39);
                                       double var118;
                                       var10000 = (var118 = var40.a - var41.a) == 0.0D?0:(var118 < 0.0D?-1:1);
                                       if(var57) {
                                          break label1036;
                                       }

                                       if(var10000 != 0 && !this.d(var3, var39)) {
                                          label1202: {
                                             y.c.D var79 = this.a(var39);
                                             if(this.b(var3, var39)) {
                                                var43 = var8.a((Object)var39);
                                                if(java.lang.Double.isNaN(var43.d)) {
                                                   break label1202;
                                                }

                                                if(var43.a() == 1) {
                                                   var79.add(new Double(var40.a, var43.d - (var40.a - var43.q)));
                                                   if(var43.p != var43.q) {
                                                      var79.add(new Double(var43.q, var43.d));
                                                      var79.add(new Double(var43.p, var43.d));
                                                   }

                                                   var79.add(new Double(var41.a, var43.d + (var43.p - var41.a)));
                                                   if(!var57) {
                                                      break label1202;
                                                   }
                                                }

                                                var79.add(new Double(var40.a, var43.d - (var43.p - var40.a)));
                                                if(var43.p != var43.q) {
                                                   var79.add(new Double(var43.p, var43.d));
                                                   var79.add(new Double(var43.q, var43.d));
                                                }

                                                var79.add(new Double(var41.a, var43.d + (var41.a - var43.q)));
                                                if(!var57) {
                                                   break label1202;
                                                }
                                             }

                                             var82 = var8.d(var39);
                                             if(!java.lang.Double.isNaN(var82)) {
                                                var79.add(new Double(var40.a, var82));
                                                var79.add(new Double(var41.a, var82));
                                             }
                                          }
                                       }

                                       var39 = var39.g();
                                       if(var57) {
                                          break;
                                       }
                                    }
                                 }
                              }

                              var71 = var71.a();
                              if(var57) {
                                 break;
                              }

                              if(var71 == null) {
                                 break label1035;
                              }
                           }
                        }

                        double var48;
                        double var50;
                        double var51;
                        cy var52;
                        y.c.d var89;
                        Object var90;
                        y.d.t var91;
                        y.c.d var92;
                        boolean var93;
                        y.c.q var94;
                        y.d.t var97;
                        double var98;
                        cy var99;
                        double var104;
                        boolean var109;
                        double var113;
                        if(var28 && var29) {
                           var71 = var65.d().k();

                           boolean var53;
                           double var54;
                           cy var56;
                           Object var75;
                           Object var95;
                           y.c.d var100;
                           y.d.t var107;
                           label923: {
                              while(var71 != null) {
                                 var37 = (y.c.q)var71.c();
                                 var10000 = this.c.e(var37);
                                 if(var57) {
                                    break label1036;
                                 }

                                 if(var10000 == 0) {
                                    label1146: {
                                       var72 = a(var37, var3);
                                       if(var72 == null) {
                                          y.c.q var74 = var37.f().d();
                                          var75 = a(var74, var3);
                                          if(var75 != null) {
                                             break label1146;
                                          }

                                          var77 = var37.g();
                                          var80 = var1.p(var77);
                                          y.d.t var83 = var1.q(var74.f());
                                          if(var80.a != var83.a) {
                                             label1203: {
                                                if(this.d(var3, var77)) {
                                                   var5.add(var77);
                                                   if(!var57) {
                                                      break label1203;
                                                   }
                                                }

                                                var84 = this.a(var1, var3, var77);
                                                boolean var46 = this.b(var3, var77);
                                                var47 = this.a(var3, var77);
                                                cy var49 = var8.a(var77, this.m, var84, var80.a, true, var83.a, false, var46, var47);
                                                if(a(var3.a(var77.c()))) {
                                                   var49.k = var80.b + this.a(var3, var77, true);
                                                   var49.i = var80.b;
                                                }

                                                if(a(var3.a(var74.f().d()))) {
                                                   var49.l = var83.b + var6 - this.a(var3, var74.f(), false);
                                                   var49.j = var83.b + var6;
                                                }
                                             }
                                          }

                                          if(!a(var3.a(var77.c())) || !a(var3.a(var74.f().d()))) {
                                             break label1146;
                                          }

                                          var70 = this.a(var1, var3, var77, var80.a, var80.b, var83.a, var83.b + var6, var6, var70);
                                          if(!var57) {
                                             break label1146;
                                          }
                                       }

                                       var76 = -1.7976931348623157E308D;
                                       var78 = -1.7976931348623157E308D;
                                       var82 = var1.j(var37);
                                       var89 = var37.g();

                                       while(var89 != null) {
                                          var91 = var1.p(var89);
                                          var93 = this.c(var3, var89);
                                          var48 = this.a(var3, var89);
                                          double var119;
                                          var10000 = (var119 = var91.a - var82) == 0.0D?0:(var119 < 0.0D?-1:1);
                                          if(var57) {
                                             break label1036;
                                          }

                                          label896: {
                                             if(var10000 != 0) {
                                                var50 = this.a(var1, var3, var89);
                                                var52 = var8.a(var89, var72, this.m, var50, var91.a, true, var82, true, var93, var48);
                                                if(!a(var3.a(var89.c()))) {
                                                   break label896;
                                                }

                                                var52.k = var91.b + this.a(var3, var89, true);
                                                var52.i = var91.b;
                                                if(!var57) {
                                                   break label896;
                                                }
                                             }

                                             var76 = Math.max(var76, var91.b + this.a(var3, var89, true));
                                             var78 = Math.max(var76, var91.b);
                                          }

                                          var89 = var89.h();
                                          if(var57) {
                                             break;
                                          }
                                       }

                                       var45 = null;
                                       var90 = new Object();
                                       var92 = var37.f();

                                       while(var92 != null) {
                                          var94 = var92.d();
                                          var95 = a(var94, var3);
                                          var116 = var95;
                                          if(var57) {
                                             break label1219;
                                          }

                                          label882: {
                                             if(var95 == null) {
                                                var100 = var94.f();
                                                var107 = var1.q(var100);
                                                if(var107.a == var82) {
                                                   break label882;
                                                }

                                                var51 = this.a(var1, var3, var92);
                                                var53 = this.c(var3, var92);
                                                var54 = this.a(var3, var92);
                                                var56 = var8.a(var92, var90, this.m, var51, var82, true, var107.a, false, var53, var54);
                                                if(a(var3.a(var100.d()))) {
                                                   var56.l = var107.b + var6 - this.a(var3, var100, false);
                                                   var56.j = var107.b + var6;
                                                }

                                                var56.k = var76;
                                                var56.i = var78;
                                                if(!var57) {
                                                   break label882;
                                                }
                                             }

                                             if(!var95.equals(var72)) {
                                                var104 = var1.j(var94);
                                                if(var82 != var104) {
                                                   var109 = this.c(var3, var92);
                                                   var113 = this.a(var3, var92);
                                                   var8.a(var92, var82, true, var104, false, var109, var113);
                                                }
                                             }
                                          }

                                          var92 = var92.g();
                                          if(var57) {
                                             break;
                                          }
                                       }
                                    }
                                 }

                                 var71 = var71.a();
                                 if(var57) {
                                    var71 = var27.d().k();
                                    break label923;
                                 }
                              }

                              var71 = var27.d().k();
                           }

                           while(var71 != null) {
                              var37 = (y.c.q)var71.c();
                              var10000 = this.c.e(var37);
                              if(var57) {
                                 break label1036;
                              }

                              if(var10000 == 0) {
                                 var72 = a(var37, var3);
                                 if(var72 != null) {
                                    var76 = java.lang.Double.MAX_VALUE;
                                    var78 = java.lang.Double.MAX_VALUE;
                                    var82 = var1.j(var37);
                                    var89 = var37.f();

                                    while(var89 != null) {
                                       var91 = var1.q(var89);
                                       double var120;
                                       var10000 = (var120 = var82 - var91.a) == 0.0D?0:(var120 < 0.0D?-1:1);
                                       if(var57) {
                                          break label1036;
                                       }

                                       label950: {
                                          if(var10000 != 0) {
                                             var47 = this.a(var1, var3, var89);
                                             boolean var105 = this.c(var3, var89);
                                             var50 = this.a(var3, var89);
                                             var52 = var8.a(var89, var72, this.m, var47, var82, false, var91.a, false, var105, var50);
                                             if(!a(var3.a(var89.d()))) {
                                                break label950;
                                             }

                                             var52.l = var91.b + var6 - this.a(var3, var89, false);
                                             var52.j = var91.b + var6;
                                             if(!var57) {
                                                break label950;
                                             }
                                          }

                                          var76 = Math.min(var76, var91.b + var6 - this.a(var3, var89, false));
                                          var78 = Math.min(var76, var91.b + var6);
                                       }

                                       var89 = var89.g();
                                       if(var57) {
                                          break;
                                       }
                                    }

                                    var45 = null;
                                    var90 = new Object();
                                    var92 = var37.g();

                                    while(var92 != null) {
                                       var94 = var92.c();
                                       var95 = a(var94, var3);
                                       var116 = var95;
                                       if(var57) {
                                          break label1219;
                                       }

                                       if(var95 == null) {
                                          var100 = var94.g();
                                          var107 = var1.p(var100);
                                          if(var107.a != var82) {
                                             var51 = this.a(var1, var3, var100);
                                             var53 = this.c(var3, var100);
                                             var54 = this.a(var3, var100);
                                             var56 = var8.a(var100, var90, this.m, var51, var107.a, true, var82, false, var53, var54);
                                             if(a(var3.a(var100.c()))) {
                                                var56.k = var107.b + this.a(var3, var100, true);
                                                var56.i = var107.b;
                                             }

                                             var56.l = var76;
                                             var56.j = var78;
                                          }
                                       }

                                       var92 = var92.h();
                                       if(var57) {
                                          break;
                                       }
                                    }
                                 }
                              }

                              var71 = var71.a();
                              if(var57) {
                                 break;
                              }
                           }

                           var25 += this.a(var1, var3, var62, var20, var68, var31, var8, var5, var6, var70);
                           var71 = var65.d().k();

                           y.c.q var81;
                           Object var85;
                           y.c.d var86;
                           label820: {
                              while(var71 != null) {
                                 var37 = (y.c.q)var71.c();
                                 var10000 = this.c.e(var37);
                                 if(var57) {
                                    break label1036;
                                 }

                                 if(var10000 == 0) {
                                    label1226: {
                                       double var73 = var1.j(var37);
                                       var75 = a(var37, var3);
                                       if(var75 == null) {
                                          var77 = var37.f();
                                          var81 = var77.d();
                                          var85 = a(var81, var3);
                                          if(var85 == null) {
                                             var86 = var37.g();
                                             var89 = var81.f();
                                             if(this.d(var3, var86)) {
                                                break label1226;
                                             }

                                             var91 = var1.p(var86);
                                             var97 = var1.q(var89);
                                             var1.a(var37, var91.a, var64);
                                             var1.a(var81, var97.a, var64);
                                             if(var91.a != var97.a) {
                                                var99 = var8.a((Object)var86);
                                                var104 = var99.d;
                                                if(!java.lang.Double.isNaN(var104)) {
                                                   label808: {
                                                      if(var99.n) {
                                                         label1158: {
                                                            y.c.D var112 = this.a(var86);
                                                            if(var91.a < var97.a) {
                                                               var112.add(new Double(var91.a, var104 - (var99.p - var99.b)));
                                                               if(var99.p != var99.q) {
                                                                  var112.add(new Double(var99.p, var104));
                                                                  var112.add(new Double(var99.q, var104));
                                                               }

                                                               var113 = var104 + (var99.c - var99.q);
                                                               if(!var57) {
                                                                  break label1158;
                                                               }
                                                            }

                                                            var112.add(new Double(var91.a, var104 - (var99.c - var99.q)));
                                                            if(var99.p != var99.q) {
                                                               var112.add(new Double(var99.q, var104));
                                                               var112.add(new Double(var99.p, var104));
                                                            }

                                                            var113 = var104 + (var99.p - var99.b);
                                                         }

                                                         var1.d(var86, new y.d.t(var97.a, var113));
                                                         var1.c(var89, new y.d.t(var97.a, var113));
                                                         if(!var57) {
                                                            break label808;
                                                         }
                                                      }

                                                      var1.d(var86, new y.d.t(var91.a, var104));
                                                      var1.c(var89, new y.d.t(var97.a, var104));
                                                   }
                                                }
                                             }

                                             var1.c(var77, var1.q(var86));
                                             var1.d(var77, var1.p(var81.f()));
                                             if(!var57) {
                                                break label1226;
                                             }
                                          }

                                          var1.a(var37, var73, var64);
                                          if(!var57) {
                                             break label1226;
                                          }
                                       }

                                       var1.a(var37, var73, var64);
                                       if(var8.c(var75)) {
                                          var78 = var8.e(var75);
                                          var1.a(var37, var73, var78);
                                          var87 = var37.g();

                                          while(var87 != null) {
                                             var88 = var1.p(var87);
                                             double var121;
                                             var10000 = (var121 = var88.a - var73) == 0.0D?0:(var121 < 0.0D?-1:1);
                                             if(var57) {
                                                break label1036;
                                             }

                                             label786: {
                                                if(var10000 != 0) {
                                                   var96 = var8.d(var87);
                                                   if(!java.lang.Double.isNaN(var96)) {
                                                      var1.d(var87, new y.d.t(var88.a, var96));
                                                      if(!var57) {
                                                         break label786;
                                                      }
                                                   }

                                                   var1.d(var87, new y.d.t(var88.a, var78));
                                                   if(!var57) {
                                                      break label786;
                                                   }
                                                }

                                                var1.d(var87, new y.d.t(var88.a, var78));
                                             }

                                             var87 = var87.h();
                                             if(var57) {
                                                break;
                                             }
                                          }
                                       }

                                       var77 = var37.f();

                                       while(var77 != null) {
                                          var81 = var77.d();
                                          var85 = a(var81, var3);
                                          var116 = var85;
                                          if(var57) {
                                             break label1219;
                                          }

                                          label769: {
                                             if(var85 == null) {
                                                var88 = var1.q(var81.f());
                                                var1.a(var81, var73, var64);
                                                if(var88.a == var73) {
                                                   break label769;
                                                }

                                                var96 = var8.d(var77);
                                                if(java.lang.Double.isNaN(var96)) {
                                                   break label769;
                                                }

                                                var1.d(var77, new y.d.t(var73, var96));
                                                var1.c(var81.f(), new y.d.t(var88.a, var96));
                                                if(!var57) {
                                                   break label769;
                                                }
                                             }

                                             var84 = var1.j(var81);
                                             var1.a(var81, var84, var64);
                                             if(!var85.equals(var75) && var73 != var84) {
                                                var98 = var8.d(var77);
                                                if(!java.lang.Double.isNaN(var98)) {
                                                   y.c.D var102 = this.a(var77);
                                                   var102.add(new Double(var73, var98));
                                                   var102.add(new Double(var84, var98));
                                                }
                                             }
                                          }

                                          var77 = var77.g();
                                          if(var57) {
                                             break;
                                          }
                                       }
                                    }
                                 }

                                 var71 = var71.a();
                                 if(var57) {
                                    var71 = var27.d().k();
                                    break label820;
                                 }
                              }

                              var71 = var27.d().k();
                           }

                           do {
                              if(var71 == null) {
                                 break label1035;
                              }

                              var37 = (y.c.q)var71.c();
                              var10000 = this.c.e(var37);
                              if(var57) {
                                 break label1036;
                              }

                              if(var10000 == 0) {
                                 var72 = a(var37, var3);
                                 if(var72 != null) {
                                    label1229: {
                                       var76 = var1.j(var37);
                                       if(var8.c(var72)) {
                                          var78 = var8.e(var72);
                                          var1.a(var37, var76, var78);
                                          var87 = var37.f();

                                          do {
                                             if(var87 == null) {
                                                var77 = var37.g();
                                                break label1229;
                                             }

                                             var88 = var1.q(var87);
                                             double var122;
                                             var10000 = (var122 = var88.a - var76) == 0.0D?0:(var122 < 0.0D?-1:1);
                                             if(var57) {
                                                break label1036;
                                             }

                                             label855: {
                                                if(var10000 != 0) {
                                                   var96 = var8.d(var87);
                                                   var1.c(var87, new y.d.t(var88.a, var96));
                                                   if(!var57) {
                                                      break label855;
                                                   }
                                                }

                                                var1.c(var87, new y.d.t(var88.a, var78));
                                             }

                                             var87 = var87.g();
                                          } while(!var57);
                                       }

                                       var1.a(var37, var76, var64);
                                       var77 = var37.g();
                                    }

                                    while(var77 != null) {
                                       var81 = var77.c();
                                       var85 = a(var81, var3);
                                       var116 = var85;
                                       if(var57) {
                                          break label1219;
                                       }

                                       if(var85 == null) {
                                          label1211: {
                                             var86 = var81.g();
                                             y.d.t var101 = var1.p(var86);
                                             if(var101.a != var76) {
                                                var98 = var8.d(var86);
                                                if(java.lang.Double.isNaN(var98)) {
                                                   break label1211;
                                                }

                                                var1.d(var86, new y.d.t(var101.a, var98));
                                                var1.c(var77, new y.d.t(var76, var98));
                                                if(!var57) {
                                                   break label1211;
                                                }
                                             }

                                             var1.a(var81, new y.d.t(var76, var64));
                                          }
                                       }

                                       var77 = var77.h();
                                       if(var57) {
                                          break;
                                       }
                                    }
                                 }
                              }

                              var71 = var71.a();
                           } while(!var57);
                        }

                        boolean var103;
                        if(var28) {
                           var71 = var65.d().k();

                           while(var71 != null) {
                              var37 = (y.c.q)var71.c();
                              var10000 = this.c.e(var37);
                              if(var57) {
                                 break label1036;
                              }

                              if(var10000 == 0) {
                                 label1171: {
                                    var72 = a(var37, var3);
                                    if(var72 == null) {
                                       var39 = var37.g();
                                       var40 = var1.p(var39);
                                       var77 = var37.f();
                                       var80 = var1.q(var77);
                                       if(var40.a != var80.a) {
                                          label1213: {
                                             if(this.d(var3, var39)) {
                                                var5.add(var39);
                                                if(!var57) {
                                                   break label1213;
                                                }
                                             }

                                             var82 = this.a(var1, var3, var39);
                                             var103 = this.b(var3, var39);
                                             var98 = this.a(var3, var39);
                                             var99 = var8.a(var39, this.m, var82, var40.a, true, var80.a, false, var103, var98);
                                             if(a(var3.a(var39.c()))) {
                                                var99.k = var40.b + this.a(var3, var39, true);
                                                var99.i = var40.b;
                                             }

                                             if(a(var3.a(var77.d()))) {
                                                var99.l = var80.b + var6 - this.a(var3, var77, false);
                                                var99.j = var80.b + var6;
                                             }
                                          }
                                       }

                                       if(!a(var3.a(var39.c())) || !a(var3.a(var77.d()))) {
                                          break label1171;
                                       }

                                       var70 = this.a(var1, var3, var39, var40.a, var40.b, var80.a, var80.b + var6, var6, var70);
                                       if(!var57) {
                                          break label1171;
                                       }
                                    }

                                    var76 = -1.7976931348623157E308D;
                                    var78 = -1.7976931348623157E308D;
                                    var82 = var1.j(var37);
                                    var89 = var37.g();

                                    while(var89 != null) {
                                       var91 = var1.p(var89);
                                       var93 = this.c(var3, var89);
                                       var48 = this.a(var3, var89);
                                       double var123;
                                       var10000 = (var123 = var91.a - var82) == 0.0D?0:(var123 < 0.0D?-1:1);
                                       if(var57) {
                                          break label1036;
                                       }

                                       label699: {
                                          if(var10000 != 0) {
                                             var50 = this.a(var1, var3, var89);
                                             var52 = var8.a(var89, var72, this.m, var50, var91.a, true, var82, false, var93, var48);
                                             if(!a(var3.a(var89.c()))) {
                                                break label699;
                                             }

                                             var52.k = var91.b + this.a(var3, var89, true);
                                             var52.i = var91.b;
                                             if(!var57) {
                                                break label699;
                                             }
                                          }

                                          if(a(var3.a(var89.c()))) {
                                             var76 = Math.max(var76, var91.b + this.a(var3, var89, true));
                                             var78 = Math.max(var76, var91.b);
                                          }
                                       }

                                       var89 = var89.h();
                                       if(var57) {
                                          break;
                                       }
                                    }

                                    var45 = null;
                                    var90 = new Object();
                                    var92 = var37.f();

                                    while(var92 != null) {
                                       var94 = var92.d();
                                       y.d.t var106 = var1.q(var92);
                                       double var124;
                                       var10000 = (var124 = var106.a - var82) == 0.0D?0:(var124 < 0.0D?-1:1);
                                       if(var57) {
                                          break label1036;
                                       }

                                       if(var10000 != 0) {
                                          var104 = this.a(var1, var3, var92);
                                          var109 = this.c(var3, var92);
                                          var113 = this.a(var3, var92);
                                          cy var115 = var8.a(var92, var90, this.m, var104, var82, false, var106.a, false, var109, var113);
                                          if(a(var3.a(var94))) {
                                             var115.l = var106.b + var6 - this.a(var3, var92, false);
                                             var115.j = var106.b + var6;
                                          }

                                          var115.k = var76;
                                          var115.i = var78;
                                       }

                                       var92 = var92.g();
                                       if(var57) {
                                          break;
                                       }
                                    }
                                 }
                              }

                              var71 = var71.a();
                              if(var57) {
                                 break;
                              }
                           }

                           var25 += this.a(var1, var3, var62, var20, var68, var31, var8, var5, var6, var70);
                           var71 = var65.d().k();

                           do {
                              if(var71 == null) {
                                 break label1035;
                              }

                              var37 = (y.c.q)var71.c();
                              var10000 = this.c.e(var37);
                              if(var57) {
                                 break label1036;
                              }

                              if(var10000 == 0) {
                                 label1214: {
                                    var72 = a(var37, var3);
                                    if(var72 == null) {
                                       var39 = var37.g();
                                       var40 = var1.p(var39);
                                       var77 = var37.f();
                                       var80 = var1.q(var77);
                                       if(this.d(var3, var39) && var40.a != var80.a) {
                                          break label1214;
                                       }

                                       var1.a(var37, var40.a, var64);
                                       if(var40.a == var80.a) {
                                          break label1214;
                                       }

                                       var43 = var8.a((Object)var39);
                                       var84 = var43.d;
                                       if(java.lang.Double.isNaN(var84)) {
                                          break label1214;
                                       }

                                       if(var43.n) {
                                          label1179: {
                                             var108 = this.a(var39);
                                             if(var40.a < var80.a) {
                                                var108.add(new Double(var40.a, var84 - (var43.p - var43.b)));
                                                if(var43.p != var43.q) {
                                                   var108.add(new Double(var43.p, var84));
                                                   var108.add(new Double(var43.q, var84));
                                                }

                                                var47 = var84 + (var43.c - var43.q);
                                                if(!var57) {
                                                   break label1179;
                                                }
                                             }

                                             var108.add(new Double(var40.a, var84 - (var43.c - var43.q)));
                                             if(var43.p != var43.q) {
                                                var108.add(new Double(var43.q, var84));
                                                var108.add(new Double(var43.p, var84));
                                             }

                                             var47 = var84 + (var43.p - var43.b);
                                          }

                                          var1.d(var39, new y.d.t(var80.a, var47));
                                          var1.c(var77, new y.d.t(var80.a, var47));
                                          if(!var57) {
                                             break label1214;
                                          }
                                       }

                                       var1.d(var39, new y.d.t(var40.a, var84));
                                       var1.c(var77, new y.d.t(var80.a, var84));
                                       if(!var57) {
                                          break label1214;
                                       }
                                    }

                                    label658: {
                                       var76 = var1.j(var37);
                                       if(var8.c(var72)) {
                                          var78 = var8.e(var72);
                                          var1.a(var37, var76, var78);
                                          var87 = var37.g();

                                          do {
                                             if(var87 == null) {
                                                break label658;
                                             }

                                             var88 = var1.p(var87);
                                             double var125;
                                             var10000 = (var125 = var88.a - var76) == 0.0D?0:(var125 < 0.0D?-1:1);
                                             if(var57) {
                                                break label1036;
                                             }

                                             label652: {
                                                if(var10000 != 0) {
                                                   var96 = var8.d(var87);
                                                   if(!java.lang.Double.isNaN(var96)) {
                                                      var1.d(var87, new y.d.t(var88.a, var96));
                                                      if(!var57) {
                                                         break label652;
                                                      }
                                                   }

                                                   var1.d(var87, new y.d.t(var88.a, var78));
                                                   if(!var57) {
                                                      break label652;
                                                   }
                                                }

                                                var1.d(var87, new y.d.t(var88.a, var78));
                                             }

                                             var87 = var87.h();
                                          } while(!var57);
                                       }

                                       var1.a(var37, var76, var64);
                                    }

                                    var77 = var37.f();

                                    while(var77 != null) {
                                       var80 = var1.q(var77);
                                       double var126;
                                       var10000 = (var126 = var80.a - var76) == 0.0D?0:(var126 < 0.0D?-1:1);
                                       if(var57) {
                                          break label1036;
                                       }

                                       if(var10000 != 0) {
                                          var82 = var8.d(var77);
                                          if(!java.lang.Double.isNaN(var82)) {
                                             var110 = this.a(var77);
                                             var110.add(new Double(var76, var82));
                                             var110.add(new Double(var80.a, var82));
                                          }
                                       }

                                       var77 = var77.g();
                                       if(var57) {
                                          break;
                                       }
                                    }
                                 }
                              }

                              var71 = var71.a();
                           } while(!var57);
                        }

                        var71 = var65.d().k();

                        while(var71 != null) {
                           var37 = (y.c.q)var71.c();
                           var10000 = this.c.e(var37);
                           if(var57) {
                              break label1036;
                           }

                           if(var10000 == 0) {
                              label1216: {
                                 var72 = a(var37, var3);
                                 if(var72 == null) {
                                    var39 = var37.g();
                                    var40 = var1.p(var39);
                                    var77 = var37.f();
                                    var80 = var1.q(var77);
                                    if(var40.a != var80.a) {
                                       label1217: {
                                          if(this.d(var3, var39)) {
                                             var5.add(var39);
                                             if(!var57) {
                                                break label1217;
                                             }
                                          }

                                          var82 = this.a(var1, var3, var39);
                                          var103 = this.b(var3, var39);
                                          var98 = this.a(var3, var39);
                                          var99 = var8.a(var77, this.m, var82, var40.a, true, var80.a, false, var103, var98);
                                          if(a(var3.a(var39.c()))) {
                                             var99.k = var40.b + this.a(var3, var39, true);
                                             var99.i = var40.b;
                                          }

                                          if(a(var3.a(var77.d()))) {
                                             var99.l = var80.b + var6 - this.a(var3, var77, false);
                                             var99.j = var80.b + var6;
                                          }
                                       }
                                    }

                                    if(!a(var3.a(var39.c())) || !a(var3.a(var77.d()))) {
                                       break label1216;
                                    }

                                    var70 = this.a(var1, var3, var39, var40.a, var40.b, var80.a, var80.b + var6, var6, var70);
                                    if(!var57) {
                                       break label1216;
                                    }
                                 }

                                 var76 = java.lang.Double.MAX_VALUE;
                                 var78 = java.lang.Double.MAX_VALUE;
                                 var82 = var1.j(var37);
                                 var89 = var37.f();

                                 while(var89 != null) {
                                    var91 = var1.q(var89);
                                    var93 = this.c(var3, var89);
                                    var48 = this.a(var3, var89);
                                    double var127;
                                    var10000 = (var127 = var82 - var91.a) == 0.0D?0:(var127 < 0.0D?-1:1);
                                    if(var57) {
                                       break label1036;
                                    }

                                    label602: {
                                       if(var10000 != 0) {
                                          var50 = this.a(var1, var3, var89);
                                          var52 = var8.a(var89, var72, this.m, var50, var82, false, var91.a, false, var93, var48);
                                          if(!a(var3.a(var89.d()))) {
                                             break label602;
                                          }

                                          var52.l = var91.b + var6 - this.a(var3, var89, false);
                                          var52.j = var91.b + var6;
                                          if(!var57) {
                                             break label602;
                                          }
                                       }

                                       var76 = Math.min(var76, var91.b + var6 - this.a(var3, var89, false));
                                       var78 = Math.min(var78, var91.b + var6);
                                    }

                                    var89 = var89.g();
                                    if(var57) {
                                       break;
                                    }
                                 }

                                 var45 = null;
                                 var90 = new Object();
                                 var92 = var37.g();

                                 while(var92 != null) {
                                    var97 = var1.p(var92);
                                    double var128;
                                    var10000 = (var128 = var97.a - var82) == 0.0D?0:(var128 < 0.0D?-1:1);
                                    if(var57) {
                                       break label1036;
                                    }

                                    if(var10000 != 0) {
                                       var48 = this.a(var1, var3, var92);
                                       boolean var111 = this.c(var3, var92);
                                       var51 = this.a(var3, var92);
                                       cy var114 = var8.a(var92, var90, this.m, var48, var97.a, true, var82, false, var111, var51);
                                       if(a(var3.a(var92.c()))) {
                                          var114.k = var97.b + this.a(var3, var92, true);
                                          var114.i = var97.b;
                                       }

                                       var114.l = var76;
                                       var114.j = var78;
                                    }

                                    var92 = var92.h();
                                    if(var57) {
                                       break;
                                    }
                                 }
                              }
                           }

                           var71 = var71.a();
                           if(var57) {
                              break;
                           }
                        }

                        var25 += this.a(var1, var3, var62, var20, var68, var31, var8, var5, var6, var70);
                        var71 = var65.d().k();
                        if(var71 == null) {
                           break label1035;
                        }

                        var116 = var71.c();
                     }

                     while(true) {
                        var37 = (y.c.q)var116;
                        var10000 = this.c.e(var37);
                        if(var57) {
                           break label1036;
                        }

                        if(var10000 == 0) {
                           label1188: {
                              var72 = a(var37, var3);
                              if(var72 == null) {
                                 var39 = var37.f();
                                 var40 = var1.q(var39);
                                 var77 = var37.g();
                                 var80 = var1.p(var77);
                                 if(this.d(var3, var39) && var80.a != var40.a) {
                                    break label1188;
                                 }

                                 var1.a(var37, var80.a, var64);
                                 if(var80.a == var40.a) {
                                    break label1188;
                                 }

                                 var43 = var8.a((Object)var39);
                                 var84 = var43.d;
                                 if(java.lang.Double.isNaN(var84)) {
                                    break label1188;
                                 }

                                 if(var43.n) {
                                    label1191: {
                                       var108 = this.a(var77);
                                       if(var80.a < var40.a) {
                                          var108.add(new Double(var80.a, var84 - (var43.p - var43.b)));
                                          if(var43.p != var43.q) {
                                             var108.add(new Double(var43.p, var84));
                                             var108.add(new Double(var43.q, var84));
                                          }

                                          var47 = var84 + (var43.c - var43.q);
                                          if(!var57) {
                                             break label1191;
                                          }
                                       }

                                       var108.add(new Double(var80.a, var84 - (var43.c - var43.q)));
                                       if(var43.p != var43.q) {
                                          var108.add(new Double(var43.q, var84));
                                          var108.add(new Double(var43.p, var84));
                                       }

                                       var47 = var84 + (var43.p - var43.b);
                                    }

                                    var1.d(var77, new y.d.t(var40.a, var47));
                                    var1.c(var39, new y.d.t(var40.a, var47));
                                    if(!var57) {
                                       break label1188;
                                    }
                                 }

                                 var1.d(var77, new y.d.t(var80.a, var84));
                                 var1.c(var39, new y.d.t(var40.a, var84));
                                 if(!var57) {
                                    break label1188;
                                 }
                              }

                              label548: {
                                 var76 = var1.j(var37);
                                 if(var8.c(var72)) {
                                    var78 = var8.e(var72);
                                    var1.a(var37, var76, var78);
                                    var87 = var37.f();

                                    do {
                                       if(var87 == null) {
                                          break label548;
                                       }

                                       var88 = var1.q(var87);
                                       double var129;
                                       var10000 = (var129 = var88.a - var76) == 0.0D?0:(var129 < 0.0D?-1:1);
                                       if(var57) {
                                          break label1036;
                                       }

                                       label542: {
                                          if(var10000 != 0) {
                                             var96 = var8.d(var87);
                                             if(!java.lang.Double.isNaN(var96)) {
                                                var1.c(var87, new y.d.t(var88.a, var96));
                                                if(!var57) {
                                                   break label542;
                                                }
                                             }

                                             var1.c(var87, new y.d.t(var88.a, var78));
                                             if(!var57) {
                                                break label542;
                                             }
                                          }

                                          var1.c(var87, new y.d.t(var88.a, var78));
                                       }

                                       var87 = var87.g();
                                    } while(!var57);
                                 }

                                 var1.a(var37, var76, var64);
                              }

                              var77 = var37.g();

                              while(var77 != null) {
                                 var80 = var1.p(var77);
                                 double var130;
                                 var10000 = (var130 = var80.a - var76) == 0.0D?0:(var130 < 0.0D?-1:1);
                                 if(var57) {
                                    break label1036;
                                 }

                                 if(var10000 != 0) {
                                    var82 = var8.d(var77);
                                    if(!java.lang.Double.isNaN(var82)) {
                                       var110 = this.a(var77);
                                       var110.add(new Double(var80.a, var82));
                                       var110.add(new Double(var76, var82));
                                    }
                                 }

                                 var77 = var77.h();
                                 if(var57) {
                                    break;
                                 }
                              }
                           }
                        }

                        var71 = var71.a();
                        if(var57 || var71 == null) {
                           break;
                        }

                        var116 = var71.c();
                     }
                  }

                  var10000 = this.r;
               }

               if(var10000 == 0) {
                  var6 += var25;
               }

               this.b.b(var1, var8, var68, var3, true, var6);
               this.b.a(var1, var59, var68, var3, var6, var58);
               this.c.b(var8, var68, true, var6);
               if(!var57) {
                  break label1129;
               }
            }

            this.A = var62.b();
            if(this.A != null) {
               cy var66 = var8.a(this.A, 0.0D, this.A.d(), 0.0D, -1.7976931348623157E308D, true, java.lang.Double.MAX_VALUE, true);
               var66.k = this.A.h() + this.A.b();
               var66.i = var66.k;
            }

            var8.j();
            this.b.a(var1, var59, var62, var3, var6, var58);
            if(this.A != null) {
               double var67 = var8.d(this.A);
               this.A.d(var67 - this.A.h());
               this.b(this.A, var1);
            }
         }

         this.b.b(var1, var8, var62, var3, false, 0.0D);
         this.b.a(var1, var59, var62, var3, 0.0D, var58);
         this.c.b(var8, var62, false, 0.0D);
         ++var61;
         if(var57) {
            break;
         }
      }

   }

   private double a(aV var1, y.c.d var2) {
      return this.d?0.0D:var1.a(var2).k().i();
   }

   private boolean b(aV var1, y.c.d var2) {
      if(!this.d && var1 != null && var1.a(var2).k() != null) {
         bs var3 = var1.a(var2).k().h();
         return var3.c() == 1;
      } else {
         return false;
      }
   }

   private boolean c(aV var1, y.c.d var2) {
      if(!this.d && var1 != null && var1.a(var2).k() != null) {
         bs var3 = var1.a(var2).k().h();
         return var3.b() != 0;
      } else {
         return false;
      }
   }

   private final double a(y.f.X var1, aV var2, y.c.d var3, double var4, double var6, double var8, double var10, double var12, double var14) {
      B var16 = var2.a(var3).k();
      if(var16 != null) {
         var14 = Math.max(var14, var16.c() - Math.abs(var4 - var8) - (var10 - var6));
      }

      return var14;
   }

   protected double a(y.f.X var1, aV var2, y.c.d var3) {
      B var4 = var2.a(var3).k();
      return var4 != null?var4.d():this.q;
   }

   private final boolean d(aV var1, y.c.d var2) {
      if(this.d) {
         return false;
      } else {
         B var3 = var1.a(var2).k();
         byte var4 = var1.a(var2.c()).b();
         if(var4 != 6 && var4 != 7) {
            byte var5 = var1.a(var2.d()).b();
            return var5 != 6 && var5 != 7?(var3 != null?var3.h().c() == 2:this.e):this.f || var3 != null && var3.h().b() == 2;
         } else {
            return this.f || var3 != null && var3.h().b() == 2;
         }
      }
   }

   private final double a(aV var1, y.c.d var2, boolean var3) {
      A var4 = var1.a(var2);
      B var5 = var4.k();
      return var5 != null?(var3?(var4.i()?var5.b():var5.a()):(var4.i()?var5.a():var5.b())):(var3?(var4.i()?this.l:this.k):(var4.i()?this.k:this.l));
   }

   private final double e(aV var1, y.c.d var2) {
      B var3 = var1.a(var2).k();
      return var3 != null?var3.e():this.g;
   }

   private final double f(aV var1, y.c.d var2) {
      B var3 = var1.a(var2).k();
      return var3 != null?var3.c():this.i;
   }

   private final double a(y.f.X var1, aV var2, aQ var3, aQ var4) {
      return this.h;
   }

   private final double b(y.f.X var1, aV var2, aQ var3, aQ var4) {
      return this.j;
   }

   private final double a(y.f.X var1, aV var2, aQ var3, double var4, aQ var6, double var7, cr var9, List var10, double var11, double var13) {
      int var15;
      double var16;
      double var18;
      double var26;
      double var28;
      boolean var53;
      label206: {
         var53 = N.x;
         var15 = var6.c() - var3.c() - 1;
         var16 = 0.0D;
         var18 = 0.0D;
         if(var10.size() > 0) {
            var9.d();
            var9.f();
            var9.g();
            bZ[] var20 = new bZ[var10.size() * 2];
            int var21 = 0;

            label199: {
               while(var21 < var10.size()) {
                  y.c.d var22 = (y.c.d)var10.get(var21);
                  double var23 = var1.p(var22).a;
                  double var25 = var1.q(a(var22, var15)).a;
                  var20[var21 * 2] = new bZ(var23, var22);
                  var20[var21 * 2 + 1] = new bZ(var25, var22);
                  ++var21;
                  if(var53) {
                     break label199;
                  }

                  if(var53) {
                     break;
                  }
               }

               var21 = var10.size() * 2;
            }

            int var56 = 0;
            ArrayList var57 = new ArrayList(var10.size());
            y.g.e.a(var20, 0, var21, (Comparator)null);
            BitSet var24 = new BitSet(var1.h());
            int var60 = 0;
            var26 = -1.7976931348623157E308D;
            var28 = java.lang.Double.MAX_VALUE;
            int var30 = 0;

            label188: {
               while(var30 < var21) {
                  y.c.d var31 = (y.c.d)var20[var30].b;
                  if(var53) {
                     break label188;
                  }

                  label210: {
                     if(var24.get(var31.b())) {
                        --var56;
                        if(var56 == 0) {
                           double var32 = var20[var60].a;
                           double var34 = var20[var30].a;
                           double var36 = var9.b(var32, var34, 0.0D);
                           if(java.lang.Double.isNaN(var36)) {
                              var36 = var4;
                           }

                           var36 = Math.min(var28, var36);
                           double var38 = var9.a(var32, var34, 0.0D);
                           if(java.lang.Double.isNaN(var38)) {
                              var38 = var7;
                           }

                           var38 = Math.max(var26, var38);
                           int var40 = 0;

                           int var10000;
                           while(true) {
                              if(var40 < var57.size()) {
                                 y.c.d var41 = (y.c.d)var57.get(var40);
                                 y.d.t var42 = var1.p(var41);
                                 y.d.t var43 = var1.q(a(var41, var15));
                                 y.c.D var44 = this.a(var41);
                                 double var73;
                                 var10000 = (var73 = var38 - var42.b) == 0.0D?0:(var73 < 0.0D?-1:1);
                                 if(var53) {
                                    break;
                                 }

                                 double var45;
                                 label174: {
                                    if(var10000 > 0) {
                                       var45 = var38;
                                       var44.add(new Double(var42.a, var38));
                                       if(!var53) {
                                          break label174;
                                       }
                                    }

                                    var45 = var42.b;
                                    var44.add(new Double(var42.a, var42.b));
                                 }

                                 double var47;
                                 label169: {
                                    if(var36 < var43.b + var11) {
                                       var47 = var36;
                                       var44.add(new Double(var43.a, var36));
                                       if(!var53) {
                                          break label169;
                                       }
                                    }

                                    var44.add(new Double(var43.a, var47 = var43.b + var11));
                                 }

                                 double var49 = Math.abs(var42.a - var43.a);
                                 double var51 = var47 - var45;
                                 var16 = Math.max(var16, this.f(var2, var41) - var51);
                                 var18 = Math.max(var18, var49 * this.e(var2, var41) - var51);
                                 ++var40;
                                 if(!var53) {
                                    continue;
                                 }
                              }

                              var26 = -1.7976931348623157E308D;
                              var28 = java.lang.Double.MAX_VALUE;
                              var57.clear();
                              var10000 = var30 + 1;
                              break;
                           }

                           var60 = var10000;
                        }

                        var24.clear(var31.b());
                        if(!var53) {
                           break label210;
                        }
                     }

                     double var33;
                     double var35;
                     y.c.d var65;
                     label156: {
                        var24.set(var31.b());
                        ++var56;
                        var57.add(var31);
                        var65 = a(var31, var15);
                        if(a(var2.a(var31.c()))) {
                           if(this.n) {
                              var33 = var1.p(var31).b + this.a(var2, var31, true);
                              var35 = (var1.p(var31).b + var7) * 0.4D;
                              var26 = Math.max(var26, Math.min(var33, var35));
                              if(!var53) {
                                 break label156;
                              }
                           }

                           var26 = Math.max(var26, var1.p(var31).b + this.a(var2, var31, true));
                           if(!var53) {
                              break label156;
                           }
                        }

                        var26 = Math.max(var26, var1.p(var31).b);
                     }

                     if(a(var2.a(var65.d()))) {
                        if(this.n) {
                           var33 = var1.q(var65).b + var11 - this.a(var2, var31, false);
                           var35 = (var1.q(var65).b + var4) * 0.6D;
                           var28 = Math.min(var28, Math.max(var33, var35));
                           if(!var53) {
                              break label210;
                           }
                        }

                        var28 = Math.min(var28, var1.q(var65).b + var11 - this.a(var2, var31, false));
                        if(!var53) {
                           break label210;
                        }
                     }

                     var28 = Math.min(var28, var1.q(var65).b + var11);
                  }

                  ++var30;
                  if(var53) {
                     break;
                  }
               }

               var9.h();
            }

            if(!var53) {
               break label206;
            }
         }

         if(this.n) {
            var9.i();
            if(!var53) {
               break label206;
            }
         }

         var9.j();
      }

      double var55 = var7 - var4;
      double var58 = this.b(var1, var2, var3, var6);
      double var59 = var58 - var55;
      var26 = this.n?var9.e():var9.d(var58);
      if(!this.n) {
         var28 = var18 - var16;
         var28 = Math.min(this.a(var1, var2, var3, var6), var28);
         var26 = Math.max(Math.max(Math.max(var13, var26), var59), Math.max(var16, var16 + var28));
      }

      label213: {
         label214: {
            int var62;
            if(var15 == 0) {
               if(var26 == 0.0D) {
                  break label214;
               }

               var62 = 0;

               do {
                  if(var62 >= var10.size()) {
                     break label214;
                  }

                  Double var54 = (Double)this.a((y.c.d)var10.get(var62)).i();
                  var54.y += var26;
                  ++var62;
                  if(var53) {
                     break label213;
                  }
               } while(!var53);
            }

            y.c.d var29;
            y.c.D var61;
            Double var63;
            if(var15 == 2) {
               var62 = 0;

               do {
                  if(var62 >= var10.size()) {
                     break label214;
                  }

                  var29 = (y.c.d)var10.get(var62);
                  var61 = this.a(var29);
                  var63 = (Double)var61.f();
                  Double var66 = (Double)var61.i();
                  var61.clear();
                  y.c.q var68 = var29.d();
                  y.c.d var70 = var68.f();
                  y.c.q var71 = var70.d();
                  y.c.d var72 = var71.f();
                  var1.b(var29, y.d.t.c);
                  var1.a(var70, y.d.t.c);
                  var1.b(var70, y.d.t.c);
                  var1.a(var72, y.d.t.c);
                  var1.a(var68, var63.x, var63.y);
                  var1.a(var71, var66.x, var66.y + var26);
                  ++var62;
                  if(var53) {
                     break label213;
                  }
               } while(!var53);
            }

            if(var15 == 1) {
               var62 = 0;

               while(var62 < var10.size()) {
                  var29 = (y.c.d)var10.get(var62);
                  var61 = this.a(var29);
                  var63 = (Double)var61.i();
                  var63.y += var26;
                  y.c.q var67 = var29.d();
                  y.c.d var69 = var67.f();
                  var1.b(var29, y.d.t.c);
                  var1.a(var69, y.d.t.c);
                  var1.a(var67, var63.x, var63.y);
                  ++var62;
                  if(var53) {
                     break label213;
                  }

                  if(var53) {
                     break;
                  }
               }
            }
         }

         if(var26 != 0.0D) {
            var9.e(var26);
         }

         var26 = this.c.a(var9, var58, var26);
      }

      if(this.A != null) {
         label90: {
            var28 = var9.d(this.A);
            double var64 = this.c(this.B, this.A, var1);
            if(var64 > 0.0D) {
               this.B.d(var28 - var64 * 0.5D - this.B.h());
               this.b(this.B, this.A, var1);
               this.A.g(var28 + var64 * 0.5D);
               var64 = 0.0D;
               if(!var53) {
                  break label90;
               }
            }

            this.B.d(var28 - this.B.h());
            this.A.g(var28);
         }

         this.B = this.A;
      }

      return var26;
   }

   private static final y.c.d a(y.c.d var0, int var1) {
      switch(var1) {
      case 0:
      default:
         return var0;
      case 1:
         return var0.d().f();
      case 2:
         return var0.d().f().d().f();
      }
   }

   private static final boolean a(aX var0) {
      return var0.b() == 0 || var0.b() == 5;
   }

   private static final Object a(y.c.q var0, aV var1) {
      return var0.a() == 2?null:var1.a(var0).a();
   }

   private final y.c.D a(y.c.d var1) {
      y.c.D var2 = (y.c.D)this.z.get(var1);
      if(var2 == null) {
         var2 = new y.c.D();
         this.z.put(var1, var2);
      }

      return var2;
   }

   private void a(y.f.X var1, aV var2, y.d.c var3, y.c.q var4, y.f.am var5, double var6, boolean var8) {
      boolean var21 = N.x;
      aX var9 = var2.a(var4);
      byte var10 = var9.b();
      if(var10 != 2 && var10 != 3) {
         double var22 = this.a();
         this.b.a(var1, var2, var3, var4, var5, var9, var6, var8);
         y.d.t var15;
         y.d.c var23;
         y.c.d var24;
         if(var8) {
            var3.a(var5.getX() - var22, var5.getX() + var5.getWidth() + var22, var6 + var5.getY());
            var23 = var9.a(0);
            if(var23 != null) {
               var23.b(var5.getX());
               var23.a(var5.getY() + var6);
               var3.b(var23);
               var23.a(-(var5.getY() + var6));
               var23.b(-var5.getX());
            }

            var24 = var4.g();

            do {
               if(var24 == null) {
                  return;
               }

               var15 = var1.q(var24);
               if(var15.a < var5.getX() - var22 || var15.a > var5.getX() + var5.getWidth() + var22) {
                  var3.a(var15.a - var22, var15.a + var22, var6 + var5.getY());
               }

               var24 = var24.h();
            } while(!var21);
         }

         var3.b(var5.getX() - var22, var5.getX() + var5.getWidth() + var22, var6 + var5.getY() + var5.getHeight());
         var23 = var9.a(2);
         if(var23 != null) {
            var23.b(var5.getX());
            var23.a(var5.getY() + var6);
            var3.a(var23);
            var23.a(-(var5.getY() + var6));
            var23.b(-var5.getX());
         }

         var24 = var4.f();

         while(var24 != null) {
            var15 = var1.p(var24);
            if(var15.a < var5.getX() - var22 || var15.a > var5.getX() + var5.getWidth() + var22) {
               var3.b(var15.a - var22, var15.a + var22, var6 + var5.getY() + var5.getHeight());
            }

            var24 = var24.g();
            if(var21) {
               break;
            }
         }

      } else {
         B var11 = var2.a(var9.g()).k();
         y.c.q var12 = var9.f();
         y.d.t var13 = var1.l(var4);
         double var14 = var1.j(var12);
         bs var16 = var11.h();
         boolean var17 = var10 == 3 && var16.d() == 1 || var10 == 2 && var16.c() == 1;
         if(var17) {
            double var18 = var11.i() / a;
            y.d.c var20;
            if(var8) {
               if(var14 > var13.a) {
                  var20 = new y.d.c(var13.a, var14, var13.b + var6);
                  var20.a(var13.a, var13.a + var18, var13.b + var6 - var18, 1.0D);
                  var3.b(var20);
                  if(!var21) {
                     return;
                  }
               }

               var20 = new y.d.c(var14, var13.a, var13.b + var6);
               var20.a(var13.a - var18, var13.a, var13.b + var6, -1.0D);
               var3.b(var20);
               if(!var21) {
                  return;
               }
            }

            if(var14 > var13.a) {
               var20 = new y.d.c(var13.a, var14, var13.b + var6);
               var20.a(var13.a, var13.a + var18, var13.b + var6 + var18, -1.0D);
               var3.a(var20);
               if(!var21) {
                  return;
               }
            }

            var20 = new y.d.c(var14, var13.a, var13.b + var6);
            var20.a(var13.a - var18, var13.a, var13.b + var6, 1.0D);
            var3.a(var20);
            if(!var21) {
               return;
            }
         }

         if(var8) {
            if(var14 > var13.a) {
               var3.a(var13.a, var14 + 1.0D, var13.b + var6);
               if(!var21) {
                  return;
               }
            }

            var3.a(var14, var13.a + 1.0D, var13.b + var6);
            if(!var21) {
               return;
            }
         }

         if(var14 > var13.a) {
            var3.b(var13.a, var14 + 1.0D, var13.b + var6);
            if(!var21) {
               return;
            }
         }

         var3.b(var14, var13.a + 1.0D, var13.b + var6);
      }
   }

   static final int a(byte var0, int var1) {
      switch(var0) {
      case 0:
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         return var1;
      case 1:
         return 0;
      case 2:
         return 2;
      case 4:
         return 1;
      case 8:
         return 3;
      }
   }

   static final int a(y.f.aE var0, int var1) {
      return var0 == null?var1:a(var0.b(), var1);
   }

   public double a() {
      return this.o;
   }

   public void a(double var1) {
      this.o = var1;
   }

   public double b() {
      return this.q;
   }

   public void b(double var1) {
      this.q = var1;
      this.b.a(var1);
   }

   public void a(long var1) {
      this.t = Math.max(0L, var1);
   }
}
