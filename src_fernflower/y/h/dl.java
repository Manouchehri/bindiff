package y.h;

import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.ch;
import y.h.dj;
import y.h.dk;
import y.h.dm;
import y.h.dn;
import y.h.do;
import y.h.dp;
import y.h.dq;
import y.h.eR;
import y.h.eU;
import y.h.fP;
import y.h.fj;
import y.h.gJ;
import y.h.x;
import y.h.y;

final class dl implements y.b.d {
   final bu a;
   final y.f.O b;
   Point2D c;
   double[] d;
   double[] e;
   double[] f;
   double[] g;
   boolean[] h;
   double[][] i;
   double[][] j;
   y.d.t[] k;
   y.d.t[] l;
   Point2D m;
   double n;
   y.c.q o;
   ch p;
   boolean q;
   boolean r;
   int[][] s;
   Map t;
   long u;
   private boolean x;
   private final dj y;
   private y.b.d z;
   int v;
   int w;

   public dl(ch var1, y.f.O var2, dj var3) {
      this.y = var3;
      this.a = var1.getGraph2D();
      this.p = var1;
      this.b = new dm(this.a, var2);
      this.u = 300L;
      this.x = true;
   }

   public void a(boolean var1) {
      this.x = var1;
   }

   public long preferredDuration() {
      return this.u;
   }

   public void a(long var1) {
      this.u = var1;
   }

   public void a(y.c.q var1) {
      this.o = var1;
   }

   public void b(boolean var1) {
      this.q = var1;
   }

   public void initAnimation() {
      boolean var24 = fj.z;
      this.c = this.p.getCenter();
      this.n = 0.0D;
      this.v = this.p.getVerticalScrollBarPolicy();
      this.w = this.p.getHorizontalScrollBarPolicy();
      int var1 = this.a.f();
      this.d = new double[var1];
      this.e = new double[var1];
      this.f = new double[var1];
      this.g = new double[var1];
      this.h = new boolean[var1];
      y.f.x var2 = new y.f.x();
      dn var3 = new dn((dk)null);
      int var4 = 0;
      y.c.x var5 = this.a.o();

      boolean var10000;
      dl var41;
      label236:
      while(true) {
         var10000 = var5.f();

         label233:
         while(var10000) {
            y.c.q var6 = var5.e();
            y.f.am var7 = this.b.a(var5.e());
            this.d[var4] = this.a.m(var6);
            this.e[var4] = this.a.n(var6);
            this.f[var4] = this.a.p(var6);
            this.g[var4] = this.a.q(var6);
            var41 = this;
            if(var24) {
               break label236;
            }

            this.h[var4] = var7.getWidth() != this.f[var4] || var7.getHeight() != this.g[var4];
            y.f.aj[] var8 = this.b.a_(var6);
            if(var8 != null) {
               fj var9 = this.a.t(var6);
               var2.setSize(var9.getWidth(), var9.getHeight());
               var2.setLocation(var9.getX(), var9.getY());
               int var10 = 0;
               int var11 = var9.labelCount();

               while(var10 < var11) {
                  eR var12 = var9.getLabel(var10);
                  var10000 = a(var12.getModelParameter(), var8[var10].getModelParameter());
                  if(var24) {
                     continue label233;
                  }

                  if(!var10000) {
                     label254: {
                        y.d.n var13 = var12.getOrientedBox();
                        y.d.q var14 = new y.d.q(var13.e(), var13.f());
                        y.d.n var15 = var12.a().a(var14, var2, var12.getModelParameter());
                        if(var15.equals(var13)) {
                           y.d.n var16 = var8[var10].a().a(var14, var7, var8[var10].getModelParameter());
                           var12.a(var3, new do(var13, var16));
                           if(!var24) {
                              break label254;
                           }
                        }

                        var12.setModelParameter(var8[var10].getModelParameter());
                     }
                  }

                  ++var10;
                  if(var24) {
                     break;
                  }
               }
            }

            var5.g();
            ++var4;
            if(!var24) {
               continue label236;
            }
            break;
         }

         var41 = this;
         break;
      }

      int var25 = var41.a.h();
      this.i = new double[var25][];
      this.j = new double[var25][];
      this.s = new int[var25][];
      this.k = new y.d.t[var25];
      this.l = new y.d.t[var25];
      dp var26 = new dp((dk)null);
      this.t = new LinkedHashMap();
      this.t.put((Object)null, (Object)null);
      int var27 = 0;
      Double var28 = new Double();
      y.c.e var29 = this.a.p();

      label201:
      while(true) {
         var10000 = var29.f();

         label198:
         while(var10000) {
            y.c.d var32 = var29.a();
            aB var34 = this.a.i(var32);
            var34.calcUnionRect(var28);
            y.f.I var36 = this.b.b(var32);
            if(var24) {
               break label201;
            }

            label195: {
               label246: {
                  if(var36 == null) {
                     y.g.o.a((Object)("EdgeLayout is null! " + var32));
                     if(!var24) {
                        break label246;
                     }
                  }

                  int var37 = var34.bendCount();
                  int var39 = var36.pointCount();
                  this.k[var27] = var34.getSourcePoint();
                  this.l[var27] = var34.getTargetPoint();
                  eU var42 = eU.b(var34);
                  if(!this.t.containsKey(var42)) {
                     this.t.put(var42, var42.g());
                     var42.a(var26.a(this.k[var27], var36.getSourcePoint()));
                  }

                  eU var17 = eU.d(var34);
                  if(!this.t.containsKey(var17)) {
                     this.t.put(var17, var17.g());
                     var17.a(var26.a(this.l[var27], var36.getTargetPoint()));
                  }

                  int var43 = var39;
                  int var10001 = var37;

                  int var19;
                  int var20;
                  label247: {
                     int var18;
                     y.d.t var40;
                     label187:
                     while(true) {
                        label163:
                        while(var43 > var10001) {
                           this.i[var27] = new double[var39];
                           this.j[var27] = new double[var39];
                           this.s[var27] = new int[var39];
                           Arrays.fill(this.s[var27], -1);
                           var18 = 0;
                           var19 = 0;
                           var20 = var34.pointCount();

                           while(true) {
                              if(var19 < var20) {
                                 var18 = this.a(var34.getPoint(var19), var36, var18, var20 - var19 - 1);
                                 this.s[var27][var18] = var19++;
                                 ++var18;
                                 if(var24) {
                                    break;
                                 }

                                 if(!var24) {
                                    continue;
                                 }
                              }

                              var19 = -1;
                              break;
                           }

                           var20 = 0;

                           while(var20 < this.s[var27].length) {
                              var43 = this.s[var27][var20];
                              var10001 = -1;
                              if(var24) {
                                 continue label163;
                              }

                              if(var43 > -1) {
                                 this.a(var34, var36, var27, var19, var20);
                                 var19 = var20;
                              }

                              ++var20;
                              if(var24) {
                                 break;
                              }
                           }

                           this.a(var34, var36, var27, var19, var39);
                           var20 = 0;
                           y var21 = var34.bends();

                           while(true) {
                              if(var21.f()) {
                                 var40 = var36.getPoint(var20);
                                 this.i[var27][var20] = var40.a - var21.a().b();
                                 this.j[var27][var20] = var40.b - var21.a().c();
                                 var21.g();
                                 ++var20;
                                 if(var24) {
                                    break;
                                 }

                                 if(!var24) {
                                    continue;
                                 }
                              }

                              this.s[var27] = null;
                              break;
                           }

                           if(!var24) {
                              break label247;
                           }
                           break;
                        }

                        if(var39 >= var37) {
                           break;
                        }

                        this.i[var27] = new double[var37];
                        this.j[var27] = new double[var37];
                        this.s[var27] = new int[var37];
                        Arrays.fill(this.s[var27], -1);
                        var18 = 0;
                        var19 = 0;

                        while(true) {
                           if(var19 < var39) {
                              var40 = var36.getPoint(var19);
                              var18 = this.a(var40, var34, var18, var39 - var19 - 1);
                              this.s[var27][var18] = var19;
                              x var46 = var34.getBend(var18);
                              this.i[var27][var18] = var40.a() - var46.b();
                              this.j[var27][var18] = var40.b() - var46.c();
                              ++var19;
                              ++var18;
                              if(var24) {
                                 break;
                              }

                              if(!var24) {
                                 continue;
                              }
                           }

                           var19 = -1;
                           break;
                        }

                        var20 = 0;

                        while(var20 < this.s[var27].length) {
                           var43 = this.s[var27][var20];
                           var10001 = -1;
                           if(var24) {
                              continue label187;
                           }

                           if(var43 > -1) {
                              this.a(var36, var34, var27, var19, var20);
                              var19 = var20;
                           }

                           ++var20;
                           if(var24) {
                              break;
                           }
                        }

                        this.a(var36, var34, var27, var19, var34.pointCount());
                        if(!var24) {
                           break label247;
                        }
                        break;
                     }

                     this.i[var27] = new double[var37];
                     this.j[var27] = new double[var37];
                     var18 = 0;
                     y var47 = var34.bends();

                     while(var47.f()) {
                        var40 = var36.getPoint(var18);
                        this.i[var27][var18] = var40.a() - var47.a().b();
                        this.j[var27][var18] = var40.b() - var47.a().c();
                        var47.g();
                        ++var18;
                        if(var24) {
                           break label195;
                        }

                        if(var24) {
                           break;
                        }
                     }
                  }

                  y.f.C[] var44 = this.b.d(var32);
                  if(var44 != null) {
                     var19 = 0;
                     var20 = var34.labelCount();

                     while(var19 < var20) {
                        aA var45 = var34.getLabel(var19);
                        var10000 = a(var45.getModelParameter(), var44[var19].getModelParameter());
                        if(var24) {
                           continue label198;
                        }

                        if(!var10000) {
                           y.d.n var22 = var45.getOrientedBox();
                           y.d.n var23 = var44[var19].getLabelModel().a(new y.d.q(var22.e(), var22.f()), var36, this.b.a(var32.c()), this.b.a(var32.d()), var44[var19].getModelParameter());
                           var45.setLabelModel(var3, new do(var22, var23));
                        }

                        ++var19;
                        if(var24) {
                           break;
                        }
                     }
                  }
               }

               var29.g();
               ++var27;
            }

            if(!var24) {
               continue label201;
            }
            break;
         }

         this.t.remove((Object)null);
         break;
      }

      if(this.o != null) {
         y.f.am var30 = this.b.a(this.o);
         this.m = new java.awt.geom.Point2D.Double(var30.getX() + var30.getWidth() * 0.5D, var30.getY() + var30.getHeight() * 0.5D);
      } else {
         Rectangle var31;
         if(this.q) {
            this.p.setScrollBarPolicy(21, 31);
            this.p.adjustScrollBarVisibility();
            var31 = this.b.a();
            this.a((y.c.i)this.a, (y.f.O)this.b, (Rectangle2D)var31);
            this.m = new java.awt.geom.Point2D.Double(var31.getX() + var31.getWidth() * 0.5D, var31.getY() + var31.getHeight() * 0.5D);
            Rectangle var33 = this.p.getVisibleRect();
            double var35 = this.p.getZoom();
            this.p.fitRectangle(var31);
            double var38 = this.p.getZoom();
            this.p.fitRectangle(var33);
            this.p.setZoom(var35);
            this.z = (new gJ(this.p)).a(var38, y.g.w.a(this.m), this.u);
            this.z.initAnimation();
         } else {
            if(this.r) {
               this.p.setScrollBarPolicy(21, 31);
               this.p.adjustScrollBarVisibility();
               if(!var24) {
                  return;
               }
            }

            var31 = this.b.a();
            if(var31 != null) {
               this.a((y.c.i)this.a, (y.f.O)this.b, (Rectangle2D)var31);
               this.p.setScrollBarPolicy(21, 31);
               this.p.adjustScrollBarVisibility();
               this.p.fitRectangle(var31);
            }
         }
      }

   }

   private static boolean a(Object var0, Object var1) {
      return var0 == null?var0 == var1:var0.equals(var1);
   }

   private void a(aB var1, y.f.I var2, int var3, int var4, int var5) {
      boolean var12 = fj.z;
      if(var4 < var5 - 1) {
         y.d.t var6;
         label57: {
            if(var4 == -1) {
               fj var7 = var1.getSourceRealizer();
               var6 = var1.getSourcePoint();
               var6 = new y.d.t(var6.a() + var7.getCenterX(), var6.b() + var7.getCenterY());
               if(!var12) {
                  break label57;
               }
            }

            var6 = var1.getPoint(this.s[var3][var4]);
         }

         y.d.t var13;
         label52: {
            if(var2.pointCount() == var5) {
               fj var8 = var1.getTargetRealizer();
               var13 = var1.getTargetPoint();
               var13 = new y.d.t(var13.a() + var8.getCenterX(), var13.b() + var8.getCenterY());
               if(!var12) {
                  break label52;
               }
            }

            var13 = var1.getPoint(this.s[var3][var5]);
         }

         if(var1.bendCount() == 0 || var2.pointCount() == var5) {
            int var14 = var4 + 1;

            do {
               if(var14 >= var5) {
                  return;
               }

               y.d.t var9 = a(var2.getPoint(var14), var6, var13);
               x var10 = var1.appendBend(var9.a(), var9.b());
               if(var10 == null) {
                  return;
               }

               ++var14;
            } while(!var12);
         }

         x var15 = var1.getBend(this.s[var3][var5]);
         int var16 = var4 + 1;

         while(var16 < var5) {
            y.d.t var17 = a(var2.getPoint(var16), var6, var13);
            x var11 = var1.createBend(var17.a(), var17.b(), var15, 1);
            if(var11 == null) {
               break;
            }

            ++var16;
            if(var12) {
               break;
            }
         }

      }
   }

   private void a(y.f.I var1, aB var2, int var3, int var4, int var5) {
      boolean var11 = fj.z;
      if(var4 < var5 - 1) {
         y.d.t var6;
         label32: {
            if(-1 == var4) {
               y.f.am var7 = this.b.a(var2.getEdge().c());
               var6 = var1.getSourcePoint();
               var6 = new y.d.t(var6.a() + var7.getX() + var7.getWidth() * 0.5D, var6.b() + var7.getY() + var7.getHeight() * 0.5D);
               if(!var11) {
                  break label32;
               }
            }

            var6 = var1.getPoint(this.s[var3][var4]);
         }

         y.d.t var12;
         label27: {
            if(var2.pointCount() == var5) {
               y.f.am var8 = this.b.a(var2.getEdge().d());
               var12 = var1.getTargetPoint();
               var12 = new y.d.t(var12.a() + var8.getX() + var8.getWidth() * 0.5D, var12.b() + var8.getY() + var8.getHeight() * 0.5D);
               if(!var11) {
                  break label27;
               }
            }

            var12 = var1.getPoint(this.s[var3][var5]);
         }

         int var13 = var4 + 1;

         while(var13 < var5) {
            x var9 = var2.getBend(var13);
            y.d.t var10 = a(var9.b(), var9.c(), var6, var12);
            this.i[var3][var13] = var10.a() - var9.b();
            this.j[var3][var13] = var10.b() - var9.c();
            ++var13;
            if(var11) {
               break;
            }
         }

      }
   }

   private int a(y.d.t var1, y.f.I var2, int var3, int var4) {
      boolean var17 = fj.z;
      double var5 = java.lang.Double.MAX_VALUE;
      int var7 = var3;
      int var8 = var3;
      int var9 = var2.pointCount();

      int var10000;
      while(true) {
         if(var8 + var4 < var9) {
            var10000 = var8;
            if(var17) {
               break;
            }

            if(var8 < var9) {
               y.d.t var10 = var2.getPoint(var8);
               double var11 = var1.a() - var10.a();
               double var13 = var1.b() - var10.b();
               double var15 = var11 * var11 + var13 * var13;
               if(var5 > var15) {
                  var5 = var15;
                  var7 = var8;
               }

               ++var8;
               if(!var17) {
                  continue;
               }
            }
         }

         var10000 = var7;
         break;
      }

      return var10000;
   }

   Rectangle2D a(y.c.i var1, y.f.O var2, Rectangle2D var3) {
      return this.y.calcBoundingBox(var1, var2, var3);
   }

   public void calcFrame(double var1) {
      label205: {
         double var5;
         boolean var20;
         label208: {
            var20 = fj.z;
            double var3 = var1 - this.n;
            var5 = 1.0D - var1;
            this.n = var1;
            int var12;
            eU var30;
            fP var34;
            if(var1 < 1.0D) {
               int var7 = 0;
               y.c.x var8 = this.a.o();

               boolean var10000;
               byte var47;
               label200: {
                  label199:
                  do {
                     var10000 = var8.f();

                     label196:
                     while(true) {
                        if(!var10000) {
                           break label199;
                        }

                        y.c.q var9 = var8.e();
                        y.f.am var10 = this.b.a(var9);
                        fj var11 = this.a.t(var9);
                        var47 = this.h[var7];
                        if(var20) {
                           break label200;
                        }

                        if(var47 != 0) {
                           var11.setSize(var5 * this.f[var7] + var1 * var10.getWidth(), var5 * this.g[var7] + var1 * var10.getHeight());
                        }

                        var11.setLocation(var5 * this.d[var7] + var1 * var10.getX(), var5 * this.e[var7] + var1 * var10.getY());
                        var12 = 0;
                        int var13 = var11.labelCount();

                        while(true) {
                           if(var12 >= var13) {
                              break label196;
                           }

                           eR var14 = var11.getLabel(var12);
                           Object var15 = var14.getModelParameter();
                           var10000 = var15 instanceof do;
                           if(var20) {
                              break;
                           }

                           if(var10000) {
                              ((do)var15).a(var5, var1);
                              var14.setOffsetDirty();
                           }

                           ++var12;
                           if(var20) {
                              break label196;
                           }
                        }
                     }

                     var8.g();
                     ++var7;
                  } while(!var20);

                  var47 = 0;
               }

               var7 = var47;
               y.c.e var22 = this.a.p();

               label177:
               do {
                  var10000 = var22.f();

                  label174:
                  while(true) {
                     if(!var10000) {
                        break label177;
                     }

                     y.c.d var28 = var22.a();
                     y.f.I var33 = this.b.b(var28);
                     aB var36 = this.a.i(var28);
                     y.d.t var39 = var33.getSourcePoint();
                     y.d.t var41 = this.k[var7];
                     var36.getSourcePort().b(var5 * var41.a() + var1 * var39.a(), var5 * var41.b() + var1 * var39.b());
                     y.d.t var45 = var33.getTargetPoint();
                     y.d.t var46 = this.l[var7];
                     var36.getTargetPort().b(var5 * var46.a() + var1 * var45.a(), var5 * var46.b() + var1 * var45.b());
                     int var16 = 0;
                     if(var20) {
                        break label208;
                     }

                     y var17 = var36.bends();

                     label165: {
                        while(var17.f()) {
                           var17.a().b(var3 * this.i[var7][var16], var3 * this.j[var7][var16]);
                           var17.g();
                           ++var16;
                           if(var20) {
                              break label165;
                           }

                           if(var20) {
                              break;
                           }
                        }

                        var16 = 0;
                     }

                     int var48 = var36.labelCount();

                     while(true) {
                        if(var16 >= var48) {
                           break label174;
                        }

                        aA var18 = var36.getLabel(var16);
                        Object var19 = var18.getModelParameter();
                        var10000 = var19 instanceof do;
                        if(var20) {
                           break;
                        }

                        if(var10000) {
                           ((do)var19).a(var5, var1);
                           var18.setOffsetDirty();
                        }

                        ++var16;
                        if(var20) {
                           break label174;
                        }
                     }
                  }

                  var22.g();
                  ++var7;
               } while(!var20);

               if(this.t.isEmpty()) {
                  break label208;
               }

               Iterator var24 = this.t.keySet().iterator();

               do {
                  if(!var24.hasNext()) {
                     break label208;
                  }

                  var30 = (eU)var24.next();
                  var34 = var30.g();
                  ((dq)var34).a(var5, var1);
                  if(var20) {
                     break label205;
                  }
               } while(!var20);
            }

            y.c.x var21 = this.a.o();

            int var38;
            while(var21.f()) {
               y.c.q var25 = var21.e();
               y.f.aj[] var31 = this.b.a_(var25);
               if(var20) {
                  break label208;
               }

               label131: {
                  if(var31 != null) {
                     fj var35 = this.a.t(var25);
                     var38 = 0;
                     var12 = var35.labelCount();

                     while(var38 < var12) {
                        eR var42 = var35.getLabel(var38);
                        var42.a(var31[var38].a(), var31[var38].getModelParameter());
                        ++var38;
                        if(var20) {
                           break label131;
                        }

                        if(var20) {
                           break;
                        }
                     }
                  }

                  var21.g();
               }

               if(var20) {
                  break;
               }
            }

            y.c.e var23 = this.a.p();

            label112: {
               while(var23.f()) {
                  y.c.d var27 = var23.a();
                  y.f.C[] var32 = this.b.d(var27);
                  if(var20) {
                     break label112;
                  }

                  label108: {
                     if(var32 != null) {
                        aB var37 = this.a.i(var27);
                        var38 = 0;
                        var12 = var37.labelCount();

                        while(var38 < var12) {
                           aA var44 = var37.getLabel(var38);
                           var44.setLabelModel(var32[var38].getLabelModel(), var32[var38].getModelParameter());
                           ++var38;
                           if(var20) {
                              break label108;
                           }

                           if(var20) {
                              break;
                           }
                        }
                     }

                     var23.g();
                  }

                  if(var20) {
                     break;
                  }
               }

               y.f.ae.a((y.f.X)this.a, (y.f.O)this.b);
            }

            if(!this.t.isEmpty()) {
               Iterator var26 = this.t.entrySet().iterator();

               while(var26.hasNext()) {
                  Entry var29 = (Entry)var26.next();
                  var30 = (eU)var29.getKey();
                  var34 = var30.g();
                  ((dq)var34).a(0.0D, 1.0D);
                  fP var40 = (fP)var29.getValue();
                  fP var43 = var40.a().a(var30.b(), var30.h());
                  var30.a(var43);
                  if(var20) {
                     break label205;
                  }

                  if(var20) {
                     break;
                  }
               }
            }
         }

         if(this.o != null) {
            this.p.setCenter(var5 * this.c.getX() + var1 * this.m.getX(), var5 * this.c.getY() + var1 * this.m.getY());
            if(!var20) {
               return;
            }
         }
      }

      if(this.q && this.z != null) {
         this.z.calcFrame(var1);
      }

   }

   public void disposeAnimation() {
      this.t = null;
      if(this.z != null) {
         this.z.disposeAnimation();
      }

      this.p.fitWorldRect();
      this.p.updateWorldRect();
      this.p.setScrollBarPolicy(this.v, this.w);
      this.p.q();
      this.p.adjustScrollBarVisibility();
   }

   private static y.d.t a(y.d.t var0, y.d.t var1, y.d.t var2) {
      return y.d.e.b(var0.a(), var0.b(), var1.a(), var1.b(), var2.a(), var2.b());
   }

   private static y.d.t a(double var0, double var2, y.d.t var4, y.d.t var5) {
      return y.d.e.b(var0, var2, var4.a(), var4.b(), var5.a(), var5.b());
   }

   public void c(boolean var1) {
      this.r = var1;
   }
}
