package y.f.c.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.C;
import y.f.c.a.E;
import y.f.c.a.J;
import y.f.c.a.O;
import y.f.c.a.S;
import y.f.c.a.T;
import y.f.c.a.U;
import y.f.c.a.Z;
import y.f.c.a.aB;
import y.f.c.a.aD;
import y.f.c.a.aF;
import y.f.c.a.aH;
import y.f.c.a.aO;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aR;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aW;
import y.f.c.a.aX;
import y.f.c.a.aZ;
import y.f.c.a.ac;
import y.f.c.a.ah;
import y.f.c.a.al;
import y.f.c.a.au;
import y.f.c.a.ax;
import y.f.c.a.ay;
import y.f.c.a.az;
import y.f.c.a.bP;
import y.f.c.a.bQ;
import y.f.c.a.bR;
import y.f.c.a.bS;
import y.f.c.a.bT;
import y.f.c.a.bY;
import y.f.c.a.ba;
import y.f.c.a.bh;
import y.f.c.a.bk;
import y.f.c.a.bq;
import y.f.c.a.br;
import y.f.c.a.bt;
import y.f.c.a.bw;
import y.f.c.a.bx;
import y.f.c.a.by;
import y.f.c.a.cB;
import y.f.c.a.cd;
import y.f.c.a.cp;
import y.f.c.a.cq;
import y.f.c.a.dC;
import y.f.c.a.db;
import y.f.c.a.de;
import y.f.c.a.dp;
import y.f.c.a.dt;
import y.f.c.a.m;
import y.f.c.a.q;
import y.f.c.a.r;
import y.f.c.a.y;
import y.f.c.a.z;

public class N extends y.f.c {
   private aT y;
   private bx z;
   private bq A;
   private br B;
   private z C;
   private aZ D;
   private Map E = new HashMap();
   public static final Object n = "y.layout.hierarchic.incremental.HierarchicLayouter.INCREMENTAL_HINTS_DPKEY";
   public static final Object o = "y.layout.hierarchic.incremental.HierarchicLayouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY";
   public static final Object p = "y.layout.hierarchic.incremental.HierarchicLayouter.NODE_LAYOUT_DESCRIPTOR_DPKEY";
   public static final Object q = "y.layout.hierarchic.incremental.HierarchicLayouter.SWIMLANE_DESCRIPTOR_DPKEY";
   public static final Object r = "y.layout.hierarchic.incremental.HierarchicLayouter.LAYER_VALUE_HOLDER_DPKEY";
   public static final Object s = "y.layout.hierarchic.incremental.HierarchicLayouter.SEQUENCE_VALUE_HOLDER_DPKEY";
   public static final Object t = "y.layout.hierarchic.incremental.HierarchicLayouter.INCREMENTAL_NODES_DPKEY";
   static final Object u = "y.layout.hierarchic.incremental.HierarchicLayouter.NODE_PORT_SIZE_DPKEY";
   static final Object v = "y.layout.hierarchic.incremental.HierarchicLayouter.constraintSupport_DPKEY";
   static final Object w = "groupingSupport";
   private long F = Long.MAX_VALUE;
   public static boolean x;

   public N() {
      this.f(false);
      this.b(false);
      this.e(false);
      this.d(false);
      y.f.ad var1 = this.a();
      this.c(var1);
      if(var1 != null) {
         this.c(true);
      }

      y.f.an var2 = new y.f.an();
      var2.a(false);
      this.e(var2);
   }

   protected y.f.ad a() {
      y.f.V var1 = new y.f.V();
      var1.b(false);
      var1.c(true);
      return var1;
   }

   protected aT n() {
      return new aW(new y.f.c.aj());
   }

   public void a(long var1) {
      this.F = Math.max(0L, var1);
   }

   protected bx o() {
      return new r();
   }

   protected z p() {
      return new q();
   }

   protected bq q() {
      return new y();
   }

   protected br r() {
      return null;
   }

   protected aZ s() {
      return new by();
   }

   public void a(aT var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.y = var1;
      }
   }

   public aT t() {
      if(this.y == null) {
         this.y = this.n();
      }

      return this.y;
   }

   public void a(bx var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.z = var1;
      }
   }

   public bx u() {
      if(this.z == null) {
         this.z = this.o();
      }

      return this.z;
   }

   public aZ v() {
      if(this.D == null) {
         this.D = this.s();
      }

      return this.D;
   }

   public bq w() {
      if(this.A == null) {
         this.A = this.q();
      }

      return this.A;
   }

   public void a(br var1) {
      this.B = var1;
   }

   public br x() {
      if(this.B == null) {
         this.B = this.r();
      }

      return this.B;
   }

   public z y() {
      if(this.C == null) {
         this.C = this.p();
      }

      return this.C;
   }

   public boolean b(y.f.X var1) {
      return true;
   }

   public Object a(Object var1) {
      return this.E.get(var1);
   }

   public void a(Object var1, Object var2) {
      if(var2 == null) {
         this.E.remove(var1);
         if(!x) {
            return;
         }
      }

      this.E.put(var1, var2);
   }

   private static y.c.f a(y.f.l var0) {
      boolean var9 = x;
      if(y.a.g.a(var0)) {
         return new y.c.f();
      } else {
         y.c.c var1 = var0.c((Object)y.f.c.M.n);
         if(var1 == null) {
            var1 = y.g.q.a((Object)(new Integer(1)));
         }

         y.c.h var2 = y.g.M.b();
         y.c.e var3 = var0.p();

         while(var3.f()) {
            y.c.d var4 = var3.a();
            var2.a(var4, var1.a(var4));
            var3.g();
            if(var9) {
               break;
            }
         }

         y.c.f var11 = new y.c.f();

         label88:
         while(true) {
            y.c.f var10;
            int var10000 = (var10 = y.a.c.a(var0, true)).isEmpty();

            label85:
            while(var10000 == 0) {
               var10000 = var10.size();
               int var10001 = 1;

               y.c.e var6;
               int var12;
               label82:
               while(true) {
                  if(var10000 == var10001) {
                     y.c.d var5 = var10.b();
                     var11.add(var5);
                     var0.a((y.c.d)var5);
                     if(!var9) {
                        continue label88;
                     }
                  }

                  var12 = Integer.MAX_VALUE;
                  var6 = var10.a();

                  while(true) {
                     if(!var6.f()) {
                        break label82;
                     }

                     int var7 = var2.a(var6.a());
                     var10000 = var7;
                     var10001 = var12;
                     if(var9) {
                        break;
                     }

                     if(var7 < var12) {
                        var12 = var7;
                     }

                     var6.g();
                     if(var9) {
                        break label82;
                     }
                  }
               }

               var6 = var10.a();

               while(true) {
                  if(!var6.f()) {
                     continue label88;
                  }

                  y.c.d var15 = var6.a();
                  int var8 = var2.a(var15) - var12;
                  var2.a(var15, var8);
                  if(var9) {
                     break label88;
                  }

                  var10000 = var8;
                  if(var9) {
                     break;
                  }

                  if(var8 == 0) {
                     var11.add(var15);
                     var0.a((y.c.d)var15);
                  }

                  var6.g();
                  if(var9) {
                     break label85;
                  }
               }
            }

            var11.sort(new aF(var1));
            break;
         }

         y.c.e var13 = var11.a();

         while(var13.f()) {
            label50: {
               y.c.d var14 = var13.a();
               var0.b((y.c.d)var14);
               if(!y.a.g.a(var0)) {
                  var0.a((y.c.d)var14);
                  if(!var9) {
                     break label50;
                  }
               }

               var11.b(var13);
            }

            var13.g();
            if(var9) {
               break;
            }
         }

         return var11;
      }
   }

   public void a(y.f.X var1) {
      boolean var64 = x;
      if(var1 != null && !var1.i()) {
         long var2;
         y.c.c var4;
         y.c.f var5;
         y.f.X var10000;
         label970: {
            var2 = System.currentTimeMillis();
            var4 = var1.c(y.f.c.M.n);
            var5 = new y.c.f();
            if(var4 != null) {
               y.f.l var6 = new y.f.l(var1);
               y.c.f var7 = a(var6);
               y.c.e var8 = var7.a();

               while(var8.f()) {
                  y.c.d var9 = (y.c.d)var6.i(var8.a());
                  var10000 = var1;
                  if(var64) {
                     break label970;
                  }

                  var1.c(var9);
                  var5.add(var9);
                  var8.g();
                  if(var64) {
                     break;
                  }
               }
            }

            var10000 = var1;
         }

         y.c.h var71 = var10000.u();
         y.c.A var72 = var1.t();
         ax var73 = new ax(var72, var71);
         aU var74 = this.a((aV)var73);
         C var10 = this.G();
         y.c.c var11 = this.j(var1);
         y.c.c var12 = this.a(var1, this.g(var1));
         y.c.c var13 = var1.c(y.f.U.a);
         y.g.ap var14 = null;
         y.c.h var15 = null;
         if(var13 != null) {
            var15 = var1.u();
            var14 = new y.g.ap(var15, var1, y.f.U.a);
         }

         au var16 = new au(var1, var74, var73, var10, var72, var71, this.f(var1), this.e(var1), var12, var11, var15, var14);
         aT var17 = this.D();
         this.a((y.f.X)var1, (aP)var16);
         y.c.A var18 = var1.t();
         var1.a((Object)cp.a, (y.c.c)var18);
         y.c.A var19 = var1.t();
         var1.a((Object)cp.b, (y.c.c)var19);
         E var20 = this.a((y.f.X)var1, (aV)var73, (y.c.c)var12);
         cd var21 = this.A();
         bP var22 = this.a((aV)var73, (aP)var16);
         dp var23 = this.E();
         cq var24 = this.F();
         de var25 = this.B();
         dC var26 = this.a(var22, var20);
         bx var27 = this.z();
         aT var28 = this.t();
         bx var29 = this.u();
         aZ var30 = this.v();
         z var31 = this.y();
         bq var32 = this.w();
         if(var32 instanceof y) {
            ((y)var32).a(var22);
            ((y)var32).a(var21);
         }

         br var33 = this.x();
         y.f.F var34 = new y.f.F();
         var34.b(var1);
         cB var35 = this.a(var34);
         cB.a((cB)var35, (y.c.i)var1);
         db var36 = this.C();
         var23.a(var36);
         var16.a(var26);
         var16.a(var24);
         var16.a(var21);
         var16.a(var22);
         var16.a(var23);
         var16.a(var20);
         boolean var37 = Boolean.TRUE.equals(this.a((Object)"HierarchicLayouter.considerNodeLabelsForSelfloops"));
         boolean var38 = Boolean.TRUE.equals(this.a((Object)"HierarchicLayouter.considerNodeLabelsForDrawing"));
         boolean var39 = Boolean.TRUE.equals(this.a((Object)"HierarchicLayouter.considerNodeLabelsForRouting"));
         boolean var40 = Boolean.TRUE.equals(this.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.automaticEdgeGroupingEnabled"));
         boolean var41 = Boolean.TRUE.equals(this.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.backloopRoutingEnabled"));
         boolean var42 = Boolean.TRUE.equals(this.a((Object)"HierarchicLayouter.keepLayeringForGroupsWithSwimlanes"));
         boolean var43 = Boolean.TRUE.equals(this.a((Object)"HierarchicLayouter.stopAfterLayering"));
         boolean var44 = Boolean.TRUE.equals(this.a((Object)"HierarchicLayouter.stopAfterSequencing"));
         y.c.A var45 = var1.t();
         var1.a((Object)t, (y.c.c)var45);
         var1.a((Object)w, (y.c.c)y.g.q.a((Object)var20));
         bR var46 = this.h(var1);
         var1.a((Object)v, (y.c.c)y.g.q.a((Object)var46));

         try {
            y.c.A var47 = y.g.M.a();
            if(this.K() && this.H()) {
               y.f.b.c var48 = new y.f.b.c(var1);
               y.c.x var49 = var1.o();

               y.f.b.c var75;
               while(true) {
                  if(var49.f()) {
                     y.c.q var50 = var49.e();
                     var75 = var48;
                     if(var64) {
                        break;
                     }

                     if(var48.d(var50)) {
                        var47.a(var50, var1.r(var50));
                        var1.b(var50, 1.0D, 1.0D);
                     }

                     var49.g();
                     if(!var64) {
                        continue;
                     }
                  }

                  var75 = var48;
                  break;
               }

               var75.c();
            }

            boolean var51;
            Object var76;
            bk var77;
            label876: {
               label875: {
                  var20.b();
                  var21.a(var1);
                  var77 = bk.c(var1);
                  long var78 = this.F == Long.MAX_VALUE?Long.MAX_VALUE:(long)((double)this.F * 0.2D);
                  this.a(var28, var78);
                  if(this.H()) {
                     var51 = var77 != null && var20.k();
                     y.g.I var52 = null;
                     y.c.c var53 = var1.c(bk.b);
                     y.c.c var54 = var1.c(y.f.b.f.c);
                     if(var51) {
                        var20.c();
                        y.c.A var55 = y.g.M.a();
                        y.c.A var56 = y.g.M.a();
                        var52 = this.a(var1, var77, var55, var56);
                        O var57 = new O(this, var53, var56);
                        var1.a((Object)bk.b, (y.c.c)var57);
                        Object var58 = new Object();
                        S var59 = new S(this, var55, var58, var54);
                        var1.a((Object)y.f.b.f.c, (y.c.c)var59);
                        var20.b();
                     }

                     label866: {
                        al var87 = new al(this, var28, var17, var11, var45, false);
                        var87.a((y.f.X)var1, (aU)var74, (aV)var73);
                        if(this.K()) {
                           var20.c();
                           y.c.x var91 = var1.o();

                           while(var91.f()) {
                              y.c.q var94 = var91.e();
                              var76 = var47;
                              if(var64) {
                                 break label876;
                              }

                              if(var47.b(var94) != null) {
                                 var1.a(var94, (y.d.q)var47.b(var94));
                              }

                              var91.g();
                              if(var64) {
                                 break;
                              }
                           }

                           var20.b();
                           if(!var64) {
                              break label866;
                           }
                        }

                        if(this.J()) {
                           aD var92 = new aD((O)null);
                           var92.a((y.f.X)var1, (aU)var74, (aV)var73);
                        }
                     }

                     if(!var51) {
                        break label875;
                     }

                     var20.c();
                     var52.f();
                     var1.a((Object)bk.b, (y.c.c)var53);
                     var1.a((Object)y.f.b.f.c, (y.c.c)var54);
                     var20.b();
                     if(!var64) {
                        break label875;
                     }
                  }

                  this.a((y.f.X)var1, (y.c.c)var11, (aT)var28, (aU)var74, (aV)var73, (aT)var17, (y.c.A)var45, (E)var20);
               }

               var76 = var4;
            }

            label888: {
               if(var76 != null) {
                  y.c.e var79 = var5.a();

                  while(var79.f()) {
                     var1.c(var79.a());
                     var79.g();
                     if(var64) {
                        break label888;
                     }

                     if(var64) {
                        break;
                     }
                  }
               }

               this.b(var1, var74);
               var20.a(var74);
               var36.b(var1, var74, var73);
            }

            var51 = bk.d(var1) || var1.c(aR.a) != null;
            if(!var51 && !var42) {
               var20.f(var74);
               var20.a(var74);
            }

            label920: {
               if(var77 != null) {
                  y.c.c var80 = var1.c(bk.b);
                  if(var77 != null && var80 != null) {
                     bt var81 = var77.a(0);
                     int var84 = 0;

                     label915:
                     do {
                        aQ var88;
                        bt var93;
                        label913:
                        while(true) {
                           if(var84 >= var74.b()) {
                              break label915;
                           }

                           var88 = var74.a(var84);
                           var93 = null;
                           if(var64) {
                              break label920;
                           }

                           y.c.x var95 = var88.d().a();

                           while(true) {
                              if(!var95.f()) {
                                 break label913;
                              }

                              y.c.q var97 = var95.e();
                              bh var99 = (bh)var80.b(var97);
                              if(var64) {
                                 break;
                              }

                              if(var99 != null) {
                                 var93 = var99.c();
                                 break label913;
                              }

                              var95.g();
                           }
                        }

                        if(var93 == null) {
                           var93 = var81;
                        }

                        var88.a(var93);
                        var81 = var93;
                        ++var84;
                     } while(!var64);
                  }
               }

               var20.c(var74, var16);
               var20.a((y.f.X)var1, (aV)var73);
            }

            if(var41) {
               bS.a(var1, var74, var73, var16);
            }

            if(var40) {
               bQ.a(var1, var74, var73, var16);
            }

            int var82;
            label937: {
               var10.a(var1, var73);
               var23.a(var1, var74, var73, var16, var15, var14);
               a((br)var33, (y.f.X)var1, (aU)var74, (aV)var73, (aP)var16);
               var20.a(var74);
               var26.e(var1, var74, var73, var16);
               var20.i(var74);
               var20.j(var74);
               var20.k(var74);
               var20.a(var74);
               var22.a(var1);
               var24.a(var1, var74, var73, var16);
               var20.b(var74);
               var20.c(var74);
               var20.b(var74, (aP)var16);
               var20.a((aU)var74, (aP)var16);
               var20.a(var74, var21);
               if(!var43) {
                  long var83 = System.currentTimeMillis();
                  long var90 = this.F - (var83 - var2);
                  long var96 = this.F == Long.MAX_VALUE?Long.MAX_VALUE:(long)Math.max(Math.floor((double)var90 * 0.4D), Math.floor((double)this.F * 0.3D));
                  this.a(var29, var96);
                  ah var100 = null;
                  if(var11 != null) {
                     var100 = this.a((y.f.X)var1, (aU)var74, (aV)var73, (y.c.c)var11, (E)var20);
                  }

                  var29.a(var1, var74, var73, var16);
                  var20.g(var74);
                  var36.a(var1, var74, var73);
                  if(var46 != null) {
                     var46.a(var1, (aU)var74, (aV)var73);
                  }

                  if(var100 != null) {
                     var20.a((y.c.c)var45);
                     var20.e();
                     this.a((ah)var100, (y.c.a)var45, (y.f.X)var1, (aU)var74, (aV)var73);
                     var20.a(var74);
                     var20.c(var74);
                     var20.g(var74);
                  }

                  long var101 = var96 == Long.MAX_VALUE?Long.MAX_VALUE:Math.max(0L, var96 - System.currentTimeMillis() + var83);
                  this.a(var27, var101);
                  var27.a(var1, var74, var73, var16);
                  var20.o(var74);
                  var82 = var22.a(var1, var74, var73, var16);
                  this.b((br)var33, (y.f.X)var1, (aU)var74, (aV)var73, (aP)var16);
                  if(!var64) {
                     break label937;
                  }
               }

               var82 = 0;
            }

            List var85 = var35.a(var1, (aU)var74, (aV)var73, (aP)var16);
            var20.d(var74, var16);
            var20.m(var74);
            var36.a(var1, var74, var73);
            if(var46 != null) {
               var46.a(var1, (aU)var74, (aV)var73);
            }

            var22.b(var1, var74, var73, var16);
            if(var82 > 0) {
               var22.a(var1, var74, var73, var16);
            }

            var20.l(var74);
            var36.a(var1, var74, var73);
            if(var46 != null) {
               var46.a(var1, (aU)var74, (aV)var73);
            }

            var20.n(var74);
            var21.a(var1, (aV)var73);
            var32.a(var1, var74, var73, var16);
            var25.a(var1, var73, (byte)1, var37);
            var21.a((y.f.X)var1, (aU)var74, (aV)var73);
            var30.a(var1, var73, var74);
            var26.a(var1, var74, var73, var16);
            var25.a(var1, var73, (byte)2, var38);
            long var86;
            long var98;
            if(!var43 && !var44) {
               var31.a(var1, var74, var73);
               var86 = this.F - (System.currentTimeMillis() - var2);
               var98 = this.F == Long.MAX_VALUE?Long.MAX_VALUE:(long)Math.max(Math.floor((double)var86 * 0.7D), Math.floor((double)this.F * 0.3D));
               this.a(var30, var98);

               try {
                  var30.a(var1, var73, var74, var31);
               } finally {
                  var34.c(var1);
                  var31.b(var1, var74, var73);
               }
            }

            var26.c(var1, var74, var73, var16);
            if(!var43 && !var44) {
               var25.a(var1, var73, (byte)3, var39);
               var86 = this.F - (System.currentTimeMillis() - var2);
               var98 = this.F == Long.MAX_VALUE?Long.MAX_VALUE:(long)Math.max((double)var86, Math.floor((double)this.F * 0.2D));
               this.a(var26, var98);
               var26.a(var1, var74, var73);
            }

            var26.b(var1, var74, var73, var16);
            var22.b(var1);
            var26.d(var1, var74, var73, var16);
            var35.a(var1, var74, var73, var16, var85);
            var20.i();
            var24.a(var1, var73);
            var20.a(var1);
            var26.f(var1, var74, var73, var16);
            HashSet var89 = new HashSet();
            var23.a((y.f.X)var1, (aU)var74, var73, var89);
            var35.b(var1, var74, var73);
            this.i(var1);
            var23.a(var1, var73, var89);
            var10.b(var1, var73);
            var20.c();
            var20.e(var74);
            var21.b(var1);
            var21.b(var1, (aU)var74, (aV)var73);
            var20.j();
            var20.h(var74);
            var35.a((y.f.X)var1, (aU)var74, (aV)var73);
            this.a(var1, var74);
            this.a((y.f.X)var1, (aU)var74, (aV)var73);
         } finally {
            if(var46 != null) {
               var46.a();
            }

            if(var20 != null) {
               var20.f();
            }

            if(var23 != null) {
               var23.a(var1);
            }

            cB.a((y.c.i)var1);
            if(var14 != null) {
               var14.b();
               var1.a((y.c.h)var15);
               var15 = null;
               var14 = null;
            }

            var1.a((y.c.h)var71);
            var1.a((y.c.A)var72);
            var1.a((y.c.A)var45);
            var1.d_(t);
            var1.d_(v);
            var1.d_(w);
            var1.d_(cp.a);
            var1.a((y.c.A)var18);
            var1.d_(cp.b);
            var1.a((y.c.A)var19);
         }

      }
   }

   private void b(y.f.X var1, aU var2) {
      boolean var14 = x;
      if(bk.d(var1)) {
         y.c.c var3 = var1.c(bk.b);
         y.c.A var4 = y.g.M.a();
         int[] var5 = new int[var2.b()];
         int var6 = 0;
         int var7 = 0;

         int var9;
         y.c.q var12;
         label65:
         while(true) {
            if(var7 < var2.b()) {
               aQ var8 = var2.a(var7);
               var9 = 0;
               int var10 = 0;
               if(var14) {
                  break;
               }

               y.c.x var11 = var8.d().a();

               label72: {
                  while(var11.f()) {
                     var12 = var11.e();
                     var4.a(var12, var7);
                     bh var13 = (bh)var3.b(var12);
                     if(var14) {
                        break label72;
                     }

                     if(var13 != null) {
                        var10 += var13.c().a();
                        ++var9;
                     }

                     var11.g();
                     if(var14) {
                        break;
                     }
                  }

                  if(var9 > 0) {
                     var6 = var10 / var9;
                  }

                  var5[var7] = var6;
                  ++var7;
               }

               if(!var14) {
                  continue;
               }
            }

            while(true) {
               if(var2.b() <= 0) {
                  break label65;
               }

               var2.b(0);
               if(var14) {
                  return;
               }

               if(var14) {
                  break label65;
               }
            }
         }

         y.c.q[] var15 = var1.m();
         aH var16 = new aH(var3, var4, var5);
         y.g.e.a((Object[])var15, var16);
         var9 = 0;
         aQ var17 = var2.a((byte)0, var9);
         int var18 = 0;

         while(var18 < var15.length) {
            var12 = var15[var18];
            if(var18 > 0 && var16.compare(var15[var18 - 1], var12) != 0) {
               ++var9;
               var17 = var2.a((byte)0, var9);
            }

            var17.a(var12);
            ++var18;
            if(var14) {
               break;
            }
         }
      }

   }

   private void a(dC var1, long var2) {
      if(var1 instanceof bY) {
         bY var4 = (bY)var1;
         var4.a(var2);
      }

   }

   private void a(aT var1, long var2) {
      Object var4 = var1;
      if(var1 instanceof aW) {
         var4 = ((aW)var1).a();
      }

      if(var4 instanceof ba) {
         var4 = ((ba)var4).a();
      }

      if(var4 instanceof y.f.c.aj) {
         ((y.f.c.aj)var4).a(var2);
      }

   }

   private void a(bx var1, long var2) {
      if(var1 instanceof r) {
         ((r)var1).a(var2);
         if(!x) {
            return;
         }
      }

      if(var1 instanceof bT) {
         ((bT)var1).a(var2);
      }

   }

   private void a(aZ var1, long var2) {
      if(var1 instanceof by) {
         ((by)var1).a(var2);
      }

   }

   private void a(y.f.X var1, y.c.c var2, aT var3, aU var4, aV var5, aT var6, y.c.A var7, E var8) {
      boolean var16 = x;
      y.c.f var9 = new y.c.f();
      y.c.f var10 = new y.c.f();
      y.c.h var11 = y.g.M.b();
      if(this.I() && var8 != null && var8.k()) {
         var8.c();
         this.a(var1, (y.c.f)var10, (E)var8, (y.c.q)null);
         this.a(var1, var9, var10, var8, (y.c.q)null, var11);
         var8.b();
      }

      label55: {
         ah var12;
         y.c.A var13;
         label54: {
            var12 = this.a(var1, (y.c.c)var2, (E)var8, (y.c.c)var11);
            var13 = y.g.M.a();
            if(var3 instanceof m) {
               Iterator var14 = var12.a.iterator();

               y.c.q var15;
               label50: {
                  while(var14.hasNext()) {
                     var15 = (y.c.q)var14.next();
                     var1.d(var15);
                     var13.a(var15, true);
                     if(var16) {
                        break label50;
                     }

                     if(var16) {
                        break;
                     }
                  }

                  ((m)var3).a(var13);
                  var3.a(var1, var4, var5);
               }

               var14 = var12.a.iterator();

               do {
                  if(!var14.hasNext()) {
                     break label54;
                  }

                  var15 = (y.c.q)var14.next();
                  var13.a(var15, false);
                  var1.c(var15);
                  if(var16) {
                     break label55;
                  }
               } while(!var16);
            }

            var1.a((Object)"AspectRatioComponentLayerer.GROUPING_SUPPORT", (y.c.c)y.g.q.a((Object)var8));
            var3.a(var1, var4, var5);
            var1.d_("AspectRatioComponentLayerer.GROUPING_SUPPORT");
         }

         this.b(var1, var4);
         this.a(var6, var1, var4, var5, var12, var7, var13);
      }

      if(this.I() && var8 != null && var8.k()) {
         var8.c();
         this.a(var1, var9, var10);
         var8.b();
      }

   }

   private void a(y.f.X var1, y.c.f var2, y.c.f var3) {
      boolean var6 = x;
      y.c.e var4 = var2.a();

      y.c.d var5;
      while(true) {
         if(var4.f()) {
            var5 = var4.a();
            var1.a((y.c.d)var5);
            var4.g();
            if(var6) {
               break;
            }

            if(!var6) {
               continue;
            }
         }

         var4 = var3.a();
         break;
      }

      while(var4.f()) {
         var5 = var4.a();
         var1.e(var5);
         var4.g();
         if(var6) {
            break;
         }
      }

   }

   private void a(y.f.X var1, y.c.f var2, y.c.f var3, E var4, y.c.q var5, y.c.h var6) {
      boolean var16 = x;
      if(var5 != null) {
         label100: {
            y.c.y var7 = var4.g(var5);
            y.c.f var8 = new y.c.f(var5.k());
            y.c.e var9 = var8.a();

            while(var9.f()) {
               y.c.d var10 = var9.a();
               y.c.q var11 = var10.c();
               if(var16) {
                  break label100;
               }

               if(var11 != var5) {
                  label89: {
                     label88: {
                        if(var4.d(var11)) {
                           y.c.y var12 = var4.g(var11);
                           y.c.x var13 = var12.a();

                           do {
                              if(!var13.f()) {
                                 break label88;
                              }

                              y.c.q var14 = var13.e();
                              this.a(var7, var1, var14, var2, var6, true);
                              var13.g();
                              if(var16) {
                                 break label89;
                              }
                           } while(!var16);
                        }

                        this.a(var7, var1, var11, var2, var6, true);
                     }

                     var3.add(var10);
                  }

                  var1.d(var10);
               }

               var9.g();
               if(var16) {
                  break;
               }
            }

            y.c.f var19 = new y.c.f(var5.l());
            y.c.e var20 = var19.a();

            while(var20.f()) {
               y.c.d var21 = var20.a();
               y.c.q var22 = var21.d();
               if(var22 != var5) {
                  label65: {
                     label64: {
                        if(var4.d(var22)) {
                           y.c.y var23 = var4.g(var22);
                           y.c.x var24 = var23.a();

                           do {
                              if(!var24.f()) {
                                 break label64;
                              }

                              y.c.q var15 = var24.e();
                              this.a(var7, var1, var15, var2, var6, false);
                              var24.g();
                              if(var16) {
                                 break label65;
                              }
                           } while(!var16);
                        }

                        this.a(var7, var1, var22, var2, var6, false);
                     }

                     var3.add(var21);
                  }

                  var1.d(var21);
               }

               var20.g();
               if(var16) {
                  break;
               }
            }
         }
      }

      y.c.x var17 = var4.h(var5).a();

      while(var17.f()) {
         y.c.q var18 = var17.e();
         if(var4.d(var18)) {
            this.a(var1, var2, var3, var4, var18, var6);
         }

         var17.g();
         if(var16) {
            break;
         }
      }

   }

   private void a(y.f.X var1, y.c.f var2, E var3, y.c.q var4) {
      boolean var9 = x;
      if(var4 != null) {
         Set var5 = this.a(var3, var4);
         var5.add(var4);
         y.c.f var6 = new y.c.f();
         y.c.d var7 = var4.g();

         y.c.d var8;
         y.c.e var12;
         label82: {
            boolean var10000;
            while(true) {
               if(var7 != null) {
                  var10000 = var5.contains(var7.c());
                  if(var9) {
                     break;
                  }

                  if(var10000) {
                     var6.add(var7);
                  }

                  var7 = var7.h();
                  if(!var9) {
                     continue;
                  }
               }

               var12 = var6.a();

               label61: {
                  while(var12.f()) {
                     var8 = var12.a();
                     var2.add(var8);
                     var1.d(var8);
                     var12.g();
                     if(var9) {
                        break label61;
                     }

                     if(var9) {
                        break;
                     }
                  }

                  var6 = new y.c.f();
               }

               var7 = var4.f();
               if(var7 == null) {
                  break label82;
               }

               var10000 = var5.contains(var7.d());
               break;
            }

            while(true) {
               if(var10000) {
                  var6.add(var7);
               }

               var7 = var7.g();
               if(var9 || var7 == null) {
                  break;
               }

               var10000 = var5.contains(var7.d());
            }
         }

         var12 = var6.a();

         while(var12.f()) {
            var8 = var12.a();
            var2.add(var8);
            var1.d(var8);
            var12.g();
            if(var9) {
               break;
            }
         }
      }

      y.c.x var10 = var3.h(var4).a();

      while(var10.f()) {
         y.c.q var11 = var10.e();
         if(var3.d(var11)) {
            this.a(var1, var2, var3, var11);
         }

         var10.g();
         if(var9) {
            break;
         }
      }

   }

   private Set a(E var1, y.c.q var2) {
      if(!var1.k()) {
         return null;
      } else {
         HashSet var3 = new HashSet();
         var1.a((y.c.q)var2, (J)(new T(this, var2, var3)));
         return var3;
      }
   }

   private void a(y.c.y var1, y.f.X var2, y.c.q var3, y.c.f var4, y.c.h var5, boolean var6) {
      boolean var10 = x;
      y.c.x var7 = var1.a();

      while(var7.f()) {
         y.c.q var8 = var7.e();
         if(var8 != var3) {
            y.c.d var9;
            label20: {
               if(var6) {
                  var9 = var2.a((y.c.q)var3, (y.c.q)var8);
                  if(!var10) {
                     break label20;
                  }
               }

               var9 = var2.a((y.c.q)var8, (y.c.q)var3);
            }

            var4.add(var9);
            var5.a(var9, true);
         }

         var7.g();
         if(var10) {
            break;
         }
      }

   }

   private y.c.c j(y.f.X var1) {
      y.c.c var2 = this.d(var1);
      return var2 != null?new az(var2, (O)null):null;
   }

   protected y.c.c d(y.f.X var1) {
      return var1.c(n);
   }

   protected y.c.c e(y.f.X var1) {
      return var1.c(o);
   }

   protected y.c.c f(y.f.X var1) {
      return var1.c(p);
   }

   protected y.c.c g(y.f.X var1) {
      return var1.c(q);
   }

   private y.c.c a(y.f.X var1, y.c.c var2) {
      boolean var8 = x;
      if(var2 == null) {
         return null;
      } else {
         y.c.c var3 = var1.c(y.f.b.f.b);
         y.c.c var4 = var1.c(y.f.b.f.c);
         y.c.c var5 = var1.c(y.f.b.f.d);
         if(var3 != null && var4 != null && var5 != null) {
            aB var6 = new aB(var1, var2, var5, (O)null);
            var6.a(var1, var3, var4);
            y.c.x var7 = var6.a();

            while(true) {
               if(var7.f()) {
                  var6.b(var7.e(), var6.a(var7.e()));
                  var7.g();
                  if(var8) {
                     break;
                  }

                  if(!var8) {
                     continue;
                  }
               }

               var6.a(var1);
               break;
            }

            return aB.a(var6);
         } else {
            return var2;
         }
      }
   }

   protected void a(y.f.X var1, aP var2) {
      boolean var11 = x;
      y.f.b.c var3 = new y.f.b.c(var1);
      y.c.c var4 = var1.c(y.f.b.f.d);
      U var5 = new U(this, var3);
      var1.a((Object)y.f.b.f.d, (y.c.c)var5);

      try {
         y.c.x var6 = var1.o();

         while(var6.f()) {
            y.c.q var7 = var6.e();
            var2.c(var7);
            y.c.d var8 = var7.f();

            while(true) {
               if(var8 != null) {
                  var2.a(var8);
                  var8 = var8.g();
                  if(var11) {
                     break;
                  }

                  if(!var11) {
                     continue;
                  }
               }

               var6.g();
               break;
            }

            if(var11) {
               break;
            }
         }
      } finally {
         label78: {
            if(var4 != null) {
               var1.a((Object)y.f.b.f.d, (y.c.c)var4);
               if(!var11) {
                  break label78;
               }
            }

            var1.d_(y.f.b.f.d);
         }

         var3.c();
      }

   }

   protected bx z() {
      bT var1 = new bT();
      var1.a(this.E);
      return var1;
   }

   protected aU a(aV var1) {
      return new ac(var1);
   }

   cd A() {
      return new cd();
   }

   bP a(aV var1, aP var2) {
      bP var3 = new bP(var1, var2);
      var3.a(this.E);
      return var3;
   }

   E a(y.f.X var1, aV var2, y.c.c var3) {
      E var4 = new E(var1, var2, var3);
      Object var5 = this.a((Object)"GroupingSupport.minimumGroupDistance");
      if(var5 instanceof Number) {
         var4.a(((Number)var5).doubleValue());
      }

      return var4;
   }

   de B() {
      return new de();
   }

   cB a(y.f.F var1) {
      return new cB(var1);
   }

   db C() {
      return new db();
   }

   bR h(y.f.X var1) {
      if(var1.c(bw.a) == null) {
         return null;
      } else {
         boolean var2 = Boolean.TRUE.equals(this.a((Object)"HierarchicLayouter.keepInterGroupConstraints"));
         return new dt(var2);
      }
   }

   dC a(bP var1, E var2) {
      bY var3 = new bY(var1, var2);
      var3.a(this.E);
      return var3;
   }

   protected aT D() {
      return new m(new y.f.c.af());
   }

   dp E() {
      return new dp();
   }

   cq F() {
      return new cq();
   }

   protected C G() {
      return new ay();
   }

   private static void a(br var0, y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var16 = x;
      if(var0 != null) {
         var0.optimizeAfterLayering(var1, var2, var3, var4);
      }

      y.f.aE var5 = y.f.aE.a((byte)2, true);
      y.f.aE var6 = y.f.aE.a((byte)1, true);
      y.f.aE var7 = y.f.aE.a((byte)2, false);
      y.f.aE var8 = y.f.aE.a((byte)1, false);
      y.c.e var9 = var1.p();

      while(var9.f()) {
         y.c.d var10 = var9.a();
         A var11 = var3.a(var10);
         aX var12 = var3.a(var10.c());
         aX var13 = var3.a(var10.d());
         int var14 = var13.j() - var12.j();
         if(var14 != 0) {
            B var15 = var11.k();
            if(var12.b() == 0 && !a(var10.c()) && (var11.d() == null || var0 == null) && (var15 == null || !var15.f()) && (var11.c() == null || var11.c().g())) {
               label121: {
                  if(var11.c() != null && var11.c().a()) {
                     var4.a(var10, true, var14 > 0?var5:var6);
                     if(!var16) {
                        break label121;
                     }
                  }

                  var4.a(var10, true, var14 > 0?var7:var8);
               }
            }

            if(var13.b() == 0 && (var11.f() == null || var0 == null) && !a(var10.d()) && (var15 == null || !var15.g()) && (var11.e() == null || var11.e().g())) {
               label123: {
                  if(var11.e() != null && var11.e().a()) {
                     var4.a(var10, false, var14 > 0?var6:var5);
                     if(!var16) {
                        break label123;
                     }
                  }

                  var4.a(var10, false, var14 > 0?var8:var7);
               }
            }
         }

         var9.g();
         if(var16) {
            break;
         }
      }

   }

   private static boolean a(y.c.q var0) {
      y.c.c var1 = var0.e().c(y.f.ay.a);
      return var1 != null && var1.b(var0) != null;
   }

   private void b(br var1, y.f.X var2, aU var3, aV var4, aP var5) {
      if(var1 != null) {
         var1.optimizeAfterSequencing(var2, var3, var4, var5);
      }

   }

   private ah a(y.f.X param1, aU param2, aV param3, y.c.c param4, E param5) {
      // $FF: Couldn't be decompiled
   }

   private static final boolean a(y.c.q var0, aX var1, aV var2, y.c.c var3, y.c.A var4) {
      boolean var9 = x;
      boolean var10000;
      boolean var5;
      y.c.d var6;
      boolean var7;
      y.c.d var8;
      if(var1.b() == 6) {
         if(var4.d(var0)) {
            return true;
         } else {
            var5 = false;
            var6 = var0.g();

            while(true) {
               if(var6 != null) {
                  label129: {
                     var7 = var4.d(var6.c());
                     var10000 = var7;
                     if(var9) {
                        break;
                     }

                     if(!var7) {
                        var8 = var2.a(var6).b();
                        var7 = var4.d(var8.d()) || a(var8.c(), var2.a(var8.c()), var2, var3, var4);
                        if(!var7) {
                           var7 = var3.b(var8) != null;
                        }
                     }

                     label69: {
                        if(var7) {
                           var5 = true;
                           if(!var9) {
                              break label69;
                           }
                        }

                        var5 = false;
                        if(!var9) {
                           break label129;
                        }
                     }

                     var6 = var6.h();
                     if(!var9) {
                        continue;
                     }
                  }
               }

               var10000 = var5;
               break;
            }

            return var10000;
         }
      } else if(var1.b() != 7) {
         return false;
      } else if(var4.d(var0)) {
         return true;
      } else {
         var5 = false;
         var6 = var0.f();

         while(true) {
            if(var6 != null) {
               label130: {
                  var7 = var4.d(var6.d());
                  var10000 = var7;
                  if(var9) {
                     break;
                  }

                  if(!var7) {
                     var8 = var2.a(var6).b();
                     var7 = var4.d(var8.c()) || a(var8.d(), var2.a(var8.d()), var2, var3, var4);
                     if(!var7) {
                        var7 = var3.b(var8) != null;
                     }
                  }

                  label96: {
                     if(var7) {
                        var5 = true;
                        if(!var9) {
                           break label96;
                        }
                     }

                     var5 = false;
                     if(!var9) {
                        break label130;
                     }
                  }

                  var6 = var6.g();
                  if(!var9) {
                     continue;
                  }
               }
            }

            var10000 = var5;
            break;
         }

         return var10000;
      }
   }

   private static final boolean b(y.c.q var0, aX var1, aV var2, y.c.c var3, y.c.A var4) {
      boolean var5;
      y.c.d var6;
      A var7;
      if(var1.b() == 8) {
         var5 = var4.d(var1.f()) || var4.d(var1.g().c()) || var4.d(var1.g().d());
         if(!var5) {
            var6 = var1.g();
            var5 = var3.b(var6) != null;
            if(!var5) {
               var7 = var2.a(var6);
               if(var7 != null && var7.b() != null) {
                  var5 = var3.b(var7.b()) != null;
               }
            }
         }

         return var5;
      } else if(var1.b() != 9) {
         return false;
      } else {
         var5 = var4.d(var1.f()) || var4.d(var1.g().c()) || var4.d(var1.g().d());
         if(!var5) {
            var6 = var1.g();
            var5 = var3.b(var6) != null;
            if(!var5) {
               var7 = var2.a(var6);
               if(var7 != null && var7.b() != null) {
                  var5 = var3.b(var7.b()) != null;
               }
            }
         }

         return var5;
      }
   }

   private static final boolean c(y.c.q var0, aX var1, aV var2, y.c.c var3, y.c.A var4) {
      boolean var10 = x;
      boolean var5 = false;
      y.c.d var6;
      Z var7;
      y.c.q var8;
      switch(var1.b()) {
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      default:
         return false;
      case 8:
         var5 = var4.d(var1.f());
         if(var5) {
            break;
         }

         var6 = var1.g();
         var7 = (Z)var3.b(var6);
         var5 = var7 != null;
         if(var5) {
            break;
         }

         var8 = ((y.c.d)var1.d().c()).c();
         var5 = var4.d(var8);
         if(!var10) {
            break;
         }
      case 9:
         var5 = var4.d(var1.f());
         if(var5) {
            break;
         }

         var6 = var1.g();
         var7 = (Z)var3.b(var6);
         var5 = var7 != null;
         if(var5) {
            break;
         }

         var8 = ((y.c.d)var1.d().c()).d();
         var5 = var4.d(var8);
         if(!var10) {
            break;
         }
      case 10:
         if(var3.b(var1.g()) != null) {
            return true;
         }

         y.c.p var11 = var1.d();
         y.c.d var12 = (y.c.d)var11.c();
         Z var13 = (Z)var3.b(var12);
         var5 = var13 != null;
         if(var5) {
            break;
         }

         y.c.q var9 = var12.a(var0);
         var5 = var4.d(var9);
         if(var5) {
            break;
         }

         var11 = var11.a();
         var12 = (y.c.d)var11.c();
         var13 = (Z)var3.b(var12);
         var5 = var13 != null;
         if(var5) {
            break;
         }

         var9 = var12.a(var0);
         var5 = var4.d(var9);
         if(!var10) {
            break;
         }
      case 1:
         var6 = var1.g();
         var5 = var3.b(var6) != null;
         if(!var5) {
            var5 = var4.d(var6.c()) || var4.d(var6.d());
         }
      }

      return var5;
   }

   private void a(ah var1, y.c.a var2, y.f.X var3, aU var4, aV var5) {
      boolean var8 = x;
      int var6 = 0;

      byte var10000;
      while(true) {
         if(var6 < var1.b.size()) {
            y.c.q var7 = (y.c.q)var1.b.get(var6);
            var10000 = var3.f(var7);
            if(var8) {
               break;
            }

            if(var10000 == 0) {
               var3.d(var7);
               var4.a(var5.a(var7).j()).a(var7);
               var2.a(var7, true);
            }

            ++var6;
            if(!var8) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      var6 = var10000;

      while(var6 < var1.d.size()) {
         y.c.d var9 = (y.c.d)var1.d.get(var6);
         var3.e(var9);
         var3.b(var9).clearPoints();
         ++var6;
         if(var8) {
            break;
         }
      }

   }

   protected void a(y.f.X var1, aU var2) {
      boolean var11 = x;
      y.c.c var3 = var1.c(r);
      if(var3 != null) {
         byte var4 = var3 instanceof y.c.a;
         int var5 = 0;
         int var6 = 0;

         do {
            int var10000 = var6;

            label46: {
               label45:
               while(true) {
                  if(var10000 >= var2.b()) {
                     return;
                  }

                  aQ var7 = var2.a(var6);
                  if(var7.e() == 2 || var7.e() == 3) {
                     break label46;
                  }

                  y.c.p var8 = var7.d().k();

                  while(true) {
                     if(var8 == null) {
                        break label45;
                     }

                     y.c.q var9 = (y.c.q)var8.c();
                     var10000 = var4;
                     if(var11) {
                        break;
                     }

                     label40: {
                        if(var4 != 0) {
                           ((y.c.a)var3).a(var9, var5);
                           if(!var11) {
                              break label40;
                           }
                        }

                        Object var10 = var3.b(var9);
                        if(var10 instanceof aO) {
                           ((aO)var10).a(var5);
                        }
                     }

                     var8 = var8.a();
                     if(var11) {
                        break label45;
                     }
                  }
               }

               ++var5;
            }

            ++var6;
         } while(!var11);
      }

   }

   protected void a(y.f.X var1, aU var2, aV var3) {
      boolean var13 = x;
      y.c.c var4 = var1.c(s);
      if(var4 != null) {
         boolean var5 = var4 instanceof y.c.a;
         int var6 = 0;

         do {
            int var10000 = var6;

            label47:
            while(true) {
               if(var10000 >= var2.b()) {
                  return;
               }

               aQ var7 = var2.a(var6);
               if(var7.e() == 2 || var7.e() == 3) {
                  break;
               }

               int var8 = 0;
               y.c.p var9 = var7.d().k();

               while(true) {
                  if(var9 == null) {
                     break label47;
                  }

                  y.c.q var10 = (y.c.q)var9.c();
                  aX var11 = var3.a(var10);
                  var10000 = var11.b();
                  if(var13) {
                     break;
                  }

                  if(var10000 == 0) {
                     label58: {
                        if(var5) {
                           ((y.c.a)var4).a(var10, var8);
                           ++var8;
                           if(!var13) {
                              break label58;
                           }
                        }

                        Object var12 = var4.b(var10);
                        if(var12 instanceof aO) {
                           ((aO)var12).a(var8);
                           ++var8;
                        }
                     }
                  }

                  var9 = var9.a();
                  if(var13) {
                     break label47;
                  }
               }
            }

            ++var6;
         } while(!var13);
      }

   }

   private ah a(y.f.X var1, y.c.c var2, E var3, y.c.c var4) {
      boolean var10 = x;
      ah var5 = new ah();
      if(var2 != null) {
         y.c.x var6 = var1.o();

         y.c.q var7;
         Z var8;
         while(var6.f()) {
            var7 = var6.e();
            if(var10) {
               return var5;
            }

            if(var3 == null || !var3.d(var7)) {
               var8 = (Z)var2.b(var7);
               if(var8 != null) {
                  label115: {
                     if(var8.g == 0) {
                        var5.a.add(var7);
                        if(!var10) {
                           break label115;
                        }
                     }

                     if(var8.g == 1) {
                        var5.b.add(var7);
                     }
                  }
               }
            }

            var6.g();
            if(var10) {
               break;
            }
         }

         int var11 = 0;

         y.c.e var10000;
         label130: {
            y.c.d var9;
            y.c.e var14;
            while(var11 < var5.a.size()) {
               var7 = (y.c.q)var5.a.get(var11);
               var10000 = var7.j();
               if(var10) {
                  break label130;
               }

               var14 = var10000;

               while(true) {
                  if(var14.f()) {
                     var9 = var14.a();
                     var5.c.add(var9);
                     var1.d(var9);
                     var14.g();
                     if(var10) {
                        break;
                     }

                     if(!var10) {
                        continue;
                     }
                  }

                  var1.c(var7);
                  ++var11;
                  break;
               }

               if(var10) {
                  break;
               }
            }

            var11 = 0;

            label86:
            do {
               int var15 = var11;

               label83:
               while(true) {
                  if(var15 >= var5.b.size()) {
                     break label86;
                  }

                  var7 = (y.c.q)var5.b.get(var11);
                  var10000 = var7.j();
                  if(var10) {
                     break label130;
                  }

                  var14 = var10000;

                  while(true) {
                     if(!var14.f()) {
                        break label83;
                     }

                     var9 = var14.a();
                     var15 = var4.d(var9);
                     if(var10) {
                        break;
                     }

                     if(var15 == 0) {
                        var5.d.add(var9);
                        var1.d(var9);
                     }

                     var14.g();
                     if(var10) {
                        break label83;
                     }
                  }
               }

               ++var11;
            } while(!var10);

            var10000 = var1.p();
         }

         y.c.e var12 = var10000;

         while(var12.f()) {
            y.c.d var13 = var12.a();
            var8 = (Z)var2.b(var13);
            if(!var4.d(var13) && var8 != null) {
               label138: {
                  if(var8.g == 1) {
                     var5.d.add(var13);
                     var1.d(var13);
                     if(!var10) {
                        break label138;
                     }
                  }

                  var5.c.add(var13);
                  var1.d(var13);
               }
            }

            var12.g();
            if(var10) {
               break;
            }
         }
      }

      return var5;
   }

   private ah b(y.f.X var1, y.c.c var2) {
      boolean var8 = x;
      ah var3 = new ah();
      if(var2 != null) {
         y.c.x var4 = var1.o();

         y.c.q var5;
         Z var6;
         while(var4.f()) {
            var5 = var4.e();
            var6 = (Z)var2.b(var5);
            if(var8) {
               return var3;
            }

            if(var6 != null && var6.g == 0) {
               var3.a.add(var5);
            }

            var4.g();
            if(var8) {
               break;
            }
         }

         int var9 = 0;

         y.c.e var10000;
         label57: {
            while(var9 < var3.a.size()) {
               var5 = (y.c.q)var3.a.get(var9);
               var10000 = var5.j();
               if(var8) {
                  break label57;
               }

               y.c.e var12 = var10000;

               while(true) {
                  if(var12.f()) {
                     y.c.d var7 = var12.a();
                     var3.c.add(var7);
                     var1.d(var7);
                     var12.g();
                     if(var8) {
                        break;
                     }

                     if(!var8) {
                        continue;
                     }
                  }

                  var1.c(var5);
                  ++var9;
                  break;
               }

               if(var8) {
                  break;
               }
            }

            var10000 = var1.p();
         }

         y.c.e var10 = var10000;

         while(var10.f()) {
            y.c.d var11 = var10.a();
            var6 = (Z)var2.b(var11);
            if(var6 != null && var6.g != 1) {
               var3.c.add(var11);
               var1.d(var11);
            }

            var10.g();
            if(var8) {
               break;
            }
         }
      }

      return var3;
   }

   private void a(aT var1, y.f.X var2, aU var3, aV var4, ah var5, y.c.a var6, y.c.A var7) {
      boolean var10 = x;
      Iterator var8 = var5.a.iterator();

      while(var8.hasNext()) {
         y.c.q var9 = (y.c.q)var8.next();
         var2.d(var9);
         var6.a(var9, true);
         if(var10) {
            break;
         }
      }

      int var11 = 0;

      y.c.d var12;
      y.c.d var10000;
      while(true) {
         if(var11 < var5.c.size()) {
            var12 = (y.c.d)var5.c.get(var11);
            var10000 = var12;
            if(var10) {
               break;
            }

            if(var12 != null && var2.f(var12.c()) && var2.f(var12.d())) {
               var2.e(var12);
               var5.c.remove(var11);
               if(!var10) {
                  continue;
               }
            }

            ++var11;
            if(!var10) {
               continue;
            }
         }

         if(var5.a.size() > 0) {
            if(var1 instanceof m) {
               ((m)var1).a(var7);
            }

            var1.a(var2, var3, var4);
         }

         var11 = 0;
         if(var11 >= var5.d.size()) {
            return;
         }

         var10000 = (y.c.d)var5.d.get(var11);
         break;
      }

      while(true) {
         var12 = var10000;
         if(var2.f(var12.c())) {
            if(var2.f(var12.d())) {
               var2.e(var12);
               var5.d.remove(var11);
               if(var10) {
                  ++var11;
                  if(var10) {
                     break;
                  }
               }
            } else {
               ++var11;
               if(var10) {
                  break;
               }
            }
         } else {
            ++var11;
            if(var10) {
               break;
            }
         }

         if(var11 >= var5.d.size()) {
            break;
         }

         var10000 = (y.c.d)var5.d.get(var11);
      }

   }

   private void a(aT var1, y.f.X var2, aU var3, aV var4, ah var5, y.c.a var6, y.f.b.c var7, y.c.q var8) {
      boolean var11 = x;
      Iterator var9 = var5.a.iterator();

      while(var9.hasNext()) {
         y.c.q var10 = (y.c.q)var9.next();
         if(var7.a(var10) == var8) {
            var2.d(var10);
            var6.a(var10, true);
            if(var11) {
               break;
            }
         }
      }

      int var12 = 0;

      y.c.d var13;
      y.c.d var10000;
      while(true) {
         if(var12 < var5.c.size()) {
            var13 = (y.c.d)var5.c.get(var12);
            var10000 = var13;
            if(var11) {
               break;
            }

            if(var13 != null && var2.f(var13.c()) && var2.f(var13.d())) {
               var2.e(var13);
               var5.c.remove(var12);
               if(!var11) {
                  continue;
               }
            }

            ++var12;
            if(!var11) {
               continue;
            }
         }

         if(var5.a.size() > 0) {
            var1.a(var2, var3, var4);
         }

         var12 = 0;
         if(var12 >= var5.d.size()) {
            return;
         }

         var10000 = (y.c.d)var5.d.get(var12);
         break;
      }

      while(true) {
         var13 = var10000;
         if(var2.f(var13.c())) {
            if(var2.f(var13.d())) {
               var2.e(var13);
               var5.d.remove(var12);
               if(var11) {
                  ++var12;
                  if(var11) {
                     break;
                  }
               }
            } else {
               ++var12;
               if(var11) {
                  break;
               }
            }
         } else {
            ++var12;
            if(var11) {
               break;
            }
         }

         if(var12 >= var5.d.size()) {
            break;
         }

         var10000 = (y.c.d)var5.d.get(var12);
      }

   }

   protected void i(y.f.X var1) {
      boolean var27 = x;
      y.c.e var4 = var1.p();

      while(var4.f()) {
         label51: {
            y.c.d var5 = var4.a();
            y.f.I var6 = var1.g(var5);
            if(var6.pointCount() > 0) {
               ArrayList var7;
               int var10000;
               label48: {
                  var7 = new ArrayList(var6.pointCount());
                  y.d.v var8 = var1.l(var5);
                  y.c.C var9 = var8.a();
                  y.d.t var10 = (y.d.t)var9.d();
                  var9.g();
                  double var11 = var10.a();
                  double var13 = var10.b();
                  if(var9.f()) {
                     var10 = (y.d.t)var9.d();
                     double var15 = var10.a();
                     double var17 = var10.b();
                     var9.g();

                     while(var9.f()) {
                        y.d.t var25 = (y.d.t)var9.d();
                        double var21 = var25.a();
                        double var19 = var25.b();
                        double var23 = (var11 - var21) * (var17 - var19) / (var13 - var19) + var21;
                        double var29;
                        var10000 = (var29 = Math.abs(var23 - var15) - 0.5D) == 0.0D?0:(var29 < 0.0D?-1:1);
                        if(var27) {
                           break label48;
                        }

                        if(var10000 > 0) {
                           var7.add(var10);
                           var11 = var15;
                           var13 = var17;
                        }

                        var10 = var25;
                        var15 = var21;
                        var17 = var19;
                        var9.g();
                        if(var27) {
                           break;
                        }
                     }
                  }

                  var10000 = var7.size();
               }

               if(var10000 < var6.pointCount()) {
                  var6.clearPoints();
                  int var28 = 0;

                  while(var28 < var7.size()) {
                     y.d.t var26 = (y.d.t)var7.get(var28);
                     var6.addPoint(var26.a, var26.b);
                     ++var28;
                     if(var27) {
                        break label51;
                     }

                     if(var27) {
                        break;
                     }
                  }
               }
            }

            var4.g();
         }

         if(var27) {
            break;
         }
      }

   }

   private boolean H() {
      return Boolean.TRUE.equals(this.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.enabled"));
   }

   private boolean I() {
      return Boolean.TRUE.equals(this.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.considerGroupNodeEdges"));
   }

   private boolean J() {
      return Boolean.TRUE.equals(this.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.compactionEnabled"));
   }

   private boolean K() {
      return Boolean.TRUE.equals(this.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.useAspectRatioLayerer"));
   }

   private byte L() {
      return ((Number)this.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.alignment")).byteValue();
   }

   private y.g.I a(y.f.X var1, bk var2, y.c.A var3, y.c.A var4) {
      boolean var16 = x;
      y.g.I var5 = new y.g.I(var1);
      if(var2 != null && y.f.b.c.b((y.c.i)var1)) {
         y.f.b.c var6 = new y.f.b.c(var1);
         y.c.c var7 = var1.c(bk.b);
         if(var7 != null) {
            y.c.A var8 = y.g.M.a();
            y.c.x var9 = var1.o();

            y.c.q var10;
            boolean var10000;
            while(true) {
               if(var9.f()) {
                  var10 = var9.e();
                  var10000 = var6.d(var10);
                  if(var16) {
                     break;
                  }

                  label86: {
                     if(var10000) {
                        label101: {
                           bh var11 = null;
                           y.c.y var12 = var6.c(var10);
                           y.c.x var13 = var12.a();

                           y.c.q var14;
                           label82: {
                              while(var13.f()) {
                                 var14 = var13.e();
                                 var10000 = var8.d(var14);
                                 if(var16) {
                                    break label82;
                                 }

                                 if(var10000) {
                                    var8.a(var10, true);
                                    if(!var16) {
                                       break;
                                    }
                                 }

                                 bh var15 = (bh)var7.b(var14);
                                 if(var15 != null) {
                                    if(var11 == null) {
                                       var11 = var15;
                                    }

                                    if(var11.c() != var15.c()) {
                                       var8.a(var10, true);
                                       if(!var16) {
                                          break;
                                       }
                                    }
                                 }

                                 var13.g();
                                 if(var16) {
                                    break;
                                 }
                              }

                              var10000 = var8.d(var10);
                           }

                           if(var10000) {
                              var13 = var12.a();

                              do {
                                 if(!var13.f()) {
                                    break label101;
                                 }

                                 var14 = var13.e();
                                 var3.a(var14, true);
                                 var13.g();
                                 if(var16) {
                                    break label86;
                                 }
                              } while(!var16);
                           }

                           var4.a(var10, var11);
                        }
                     }

                     var9.g();
                  }

                  if(!var16) {
                     continue;
                  }
               }

               var9 = var1.o();
               var10000 = var9.f();
               break;
            }

            while(var10000) {
               var10 = var9.e();
               if(var8.d(var10)) {
                  var5.a(var10);
               }

               var9.g();
               if(var16) {
                  break;
               }

               var10000 = var9.f();
            }
         }
      }

      return var5;
   }

   static void a(N var0, y.f.X var1, y.c.c var2, aT var3, aU var4, aV var5, aT var6, y.c.A var7, E var8) {
      var0.a(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   static byte a(N var0) {
      return var0.L();
   }

   static ah a(N var0, y.f.X var1, y.c.c var2) {
      return var0.b(var1, var2);
   }

   static void a(N var0, y.f.X var1, aU var2) {
      var0.b(var1, var2);
   }

   static void a(N var0, aT var1, y.f.X var2, aU var3, aV var4, ah var5, y.c.a var6, y.f.b.c var7, y.c.q var8) {
      var0.a(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   static void a(N var0, aT var1, y.f.X var2, aU var3, aV var4, ah var5, y.c.a var6, y.c.A var7) {
      var0.a(var1, var2, var3, var4, var5, var6, var7);
   }
}
