package y.f.g;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import y.f.X;
import y.f.aE;
import y.f.aF;
import y.f.ae;
import y.f.ah;
import y.f.ax;
import y.f.c.a.bh;
import y.f.c.a.bj;
import y.f.c.a.bk;
import y.f.c.a.bt;
import y.f.g.A;
import y.f.g.a;
import y.f.g.b;
import y.f.g.e;
import y.f.g.f;
import y.f.g.g;
import y.f.g.h;
import y.f.g.i;
import y.f.g.j;
import y.f.g.k;
import y.f.g.l;
import y.f.g.n;
import y.f.g.y;
import y.f.g.z;
import y.g.I;
import y.g.M;

public class d extends y.f.a {
   public static final Object a = "y.layout.partial.PartialLayouter.PARTIAL_NODES_DPKEY";
   public static final Object b = "y.layout.partial.PartialLayouter.PARTIAL_EDGES_DPKEY";
   public static final Object c = "y.layout.PartialLayouter.COMPONENT_ASSIGNMENT_DPKEY";
   private ah e = null;
   private y.c.y f;
   private y.c.y g;
   private y.c.f h;
   private y.c.f i;
   private y.c.f n;
   private y.c.y[] o;
   private y.c.A p;
   private y.c.A q;
   private double r = 0.5D;
   private boolean s = false;
   private y.c.y t;
   private long u;
   private byte v;
   private byte w = 0;
   private byte x = 2;
   private byte y = -1;
   private y.c.A z;
   private Map A;
   private Map B;
   private y.c.A C;
   private Map D;
   private Map E;
   private Map F;
   private Map G;
   private Map H;
   private y.c.A I = M.a();
   private y.f.b.c J;
   private y.c.q K;
   private n L;
   private boolean M;
   private boolean N;
   private boolean O;
   private double P;
   private int Q;
   private ah R;
   private boolean S;
   private y.d.t T = null;
   private boolean U;
   private boolean V;
   private long W = 2147483647L;
   private boolean X = true;
   private boolean Y = false;
   private A Z = null;
   private static final y.d.r aa = new y.d.r(0.0D, 0.0D, 0.0D, 0.0D);
   public static boolean d;

   public d() {
      this.y = -1;
      this.Q = 15;
      this.P = (double)(this.Q + 5);
      this.L = new n();
      this.M = false;
      this.O = false;
      this.V = false;
      this.U = false;
      this.c((byte)1);
   }

   public void a(ah var1) {
      this.e = var1;
   }

   public ah a() {
      return this.e;
   }

   public void a(byte var1) {
      this.x = var1;
   }

   public boolean b() {
      return this.N;
   }

   public void a(boolean var1) {
      this.N = var1;
   }

   public void b(byte var1) {
      this.w = var1;
   }

   public void b(ah var1) {
      this.R = var1;
      this.S = true;
   }

   public void c(byte var1) {
      this.v = var1;
      this.S = false;
      this.e(this.v);
   }

   public byte c() {
      return this.y;
   }

   public void d(byte var1) {
      this.y = var1;
      this.M = var1 != -1;
   }

   public void b(boolean var1) {
      this.V = var1;
   }

   public void c(X var1) {
      boolean var8 = d;
      if(var1 != null && var1.f() > 0) {
         if(var1.c(a) != null || var1.c(b) != null) {
            this.u = System.currentTimeMillis();
            bk var2 = bk.c(var1);
            if(var2 != null) {
               y.c.C var3 = var2.f().m();

               while(true) {
                  if(var3.f()) {
                     y.f.c.a.l var4 = (y.f.c.a.l)var3.d();
                     var4.g(var4.g());
                     var4.d(var4.f());
                     var3.g();
                     if(var8) {
                        break;
                     }

                     if(!var8) {
                        continue;
                     }
                  }

                  var3 = var2.e().m();
                  break;
               }

               while(var3.f()) {
                  bt var10 = (bt)var3.d();
                  var10.g(var10.f());
                  var10.d(var10.g());
                  var3.g();
                  if(var8) {
                     return;
                  }

                  if(var8) {
                     break;
                  }
               }
            }

            y.d.t var9 = this.e(var1);
            byte var11 = this.c();
            if(var11 == 5) {
               y.c.c var5 = var1.c(a);
               y.c.c var6 = var1.c(b);
               e var7 = new e(this, var5, var6);
               var11 = ae.a((X)var1, (y.c.c)var7);
               this.M = var11 != -1;
            }

            if(var11 == -1) {
               var11 = 0;
               this.M = false;
            }

            f var12 = new f(this, this);
            var12.a(var11);
            var12.a((int)0);
            var12.c(var1);
            this.a(var1, var9);
            if(!var8) {
               return;
            }
         }

         if(this.e != null) {
            this.e.c(var1);
         }
      }

   }

   private void e(byte var1) {
      boolean var3 = d;
      if(var1 == 4 || var1 == 0) {
         y.f.i.a.y var2 = new y.f.i.a.y();
         var2.a((Object)"y.layout.partial.PartialLayouter.ROUTE_EDGE_DPKEY");
         this.R = var2;
         if(!var3) {
            return;
         }
      }

      if(var1 == 1) {
         i var4 = new i();
         var4.a("y.layout.partial.PartialLayouter.ROUTE_EDGE_DPKEY");
         this.R = var4;
         if(!var3) {
            return;
         }
      }

      if(var1 == 2) {
         this.R = null;
         if(!var3) {
            return;
         }
      }

      if(var1 == 3) {
         y.f.i.q var5 = new y.f.i.q();
         this.R = var5;
      }

   }

   private void c(boolean var1) {
      this.L.b(this.Q);
      this.L.c(this.N);
      this.L.b(true);
      this.L.a(this.X);
      this.L.d(true);
      this.L.c(Integer.MAX_VALUE);
      if(var1) {
         this.L.a(200);
         if(!d) {
            return;
         }
      }

      this.L.a(500);
   }

   private y.d.t e(X var1) {
      boolean var5 = d;
      y.c.c var2 = var1.c(a);
      y.c.x var3 = var1.o();

      while(true) {
         if(var3.f()) {
            label34: {
               y.c.q var4 = var3.e();
               if(var5) {
                  break;
               }

               if(!var2.d(var4)) {
                  this.K = var4;
                  if(!var5) {
                     break label34;
                  }
               }

               var3.g();
               if(!var5) {
                  continue;
               }
            }
         }

         if(this.K == null && var1.k() != null) {
            this.K = var1.k();
         }
         break;
      }

      return this.K != null?var1.l(this.K):null;
   }

   public void b(X var1) {
      this.g(var1);
      this.b(var1, this.n);
      this.k(var1);
      this.a(var1, this.o);
      if(!this.Y) {
         this.a(var1, this.h);
      }

      this.J.c();
   }

   private void f(X var1) {
      if(this.y != -1 && this.w == 0) {
         this.Z = new A((double)this.Q);
         this.Z.a(var1, this.J);
      }

   }

   private void g(X var1) {
      boolean var4 = d;
      this.J = new y.f.b.c(var1);
      this.h(var1);
      this.f(var1);
      this.i(var1);
      this.a((y.c.i)var1);
      this.c((y.c.i)var1);
      this.b((y.c.i)var1);
      this.j(var1);
      y.c.e var2 = this.h.a();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         ae.a(var1, var3, false);
         if(!aE.b(var1, var3)) {
            var1.a(var3, y.d.t.c);
         }

         if(!aE.c(var1, var3)) {
            var1.b(var3, y.d.t.c);
         }

         var2.g();
         if(var4) {
            break;
         }
      }

   }

   private void h(X var1) {
      boolean var5 = d;
      this.f = new y.c.y();
      this.g = new y.c.y();
      y.c.c var2 = var1.c(a);
      y.c.x var3 = var1.o();

      while(var3.f()) {
         label22: {
            y.c.q var4 = var3.e();
            if(var2.d(var4)) {
               this.f.add(var4);
               if(!this.J.d(var4)) {
                  break label22;
               }

               this.I.a(var4, true);
               if(!var5) {
                  break label22;
               }
            }

            this.g.add(var4);
            if(this.T == null) {
               this.T = var1.o(var4);
            }
         }

         var3.g();
         if(var5) {
            break;
         }
      }

   }

   private void a(y.c.i var1) {
      boolean var6 = d;
      this.h = new y.c.f();
      if(this.f != null && !this.f.isEmpty()) {
         y.c.x var2 = this.f.a();

         while(var2.f()) {
            y.c.q var3 = var2.e();
            y.c.e var4 = var3.j();

            label31: {
               while(var4.f()) {
                  y.c.d var5 = var4.a();
                  if(var6) {
                     break label31;
                  }

                  if(this.z.b(var5.c()) != this.z.b(var5.d())) {
                     this.h.add(var5);
                  }

                  var4.g();
                  if(var6) {
                     break;
                  }
               }

               var2.g();
            }

            if(var6) {
               break;
            }
         }
      }

   }

   private void b(y.c.i var1) {
      boolean var6 = d;
      this.n = new y.c.f();
      y.c.c var2 = var1.c(b);
      if(var2 != null) {
         y.c.c var3 = var1.c(a);
         y.c.e var4 = var1.p();

         while(var4.f()) {
            y.c.d var5 = var4.a();
            if(var2.d(var5) && (var3 == null || !var3.d(var5.c()) && !var3.d(var5.d()))) {
               this.n.add(var5);
            }

            var4.g();
            if(var6) {
               break;
            }
         }
      }

   }

   private void c(y.c.i var1) {
      boolean var8 = d;
      this.i = new y.c.f();
      y.c.x var2 = this.f.a();

      do {
         boolean var10000 = var2.f();

         label31:
         while(true) {
            if(!var10000) {
               return;
            }

            y.c.q var3 = var2.e();
            y.c.e var4 = var3.l();

            while(true) {
               if(!var4.f()) {
                  break label31;
               }

               y.c.d var5 = var4.a();
               String var6 = (String)this.z.b(var5.c());
               String var7 = (String)this.z.b(var5.d());
               var10000 = var7.startsWith("component");
               if(var8) {
                  break;
               }

               if(var10000 && var6.startsWith("component")) {
                  this.i.add(var5);
               }

               var4.g();
               if(var8) {
                  break label31;
               }
            }
         }

         var2.g();
      } while(!var8);

   }

   private void i(X var1) {
      y.c.q var7;
      d var10000;
      boolean var17;
      label211: {
         label214: {
            var17 = d;
            if(this.w == 0) {
               y.c.y[] var2 = new y.c.y[this.f.size()];
               int var3 = 0;
               y.c.x var4 = this.f.a();

               label206: {
                  while(var4.f()) {
                     y.c.q var5 = var4.e();
                     var2[var3] = new y.c.y();
                     var2[var3].add(var5);
                     ++var3;
                     var4.g();
                     if(var17) {
                        break label206;
                     }

                     if(var17) {
                        break;
                     }
                  }

                  this.o = var2;
               }

               if(!var17) {
                  break label214;
               }
            }

            I var18;
            if(this.w == 1) {
               var18 = new I(var1);
               this.b(var1, var18);
               this.a(var1, var18);
               var18.a(this.g);
               this.o = y.a.h.a(var1);
               var18.f();
               if(!var17) {
                  break label214;
               }
            }

            if(this.w == 2) {
               var18 = new I(var1);
               this.b(var1, var18);
               this.a(var1, var18);
               this.o = a((y.c.i)var1, (y.c.y)this.f);
               var18.f();
               if(!var17) {
                  break label214;
               }
            }

            var18 = new I(var1);
            var18.a(this.g);
            var18.b();
            y.c.c var20 = var1.c(c);
            y.c.f var23 = new y.c.f();
            HashMap var26 = new HashMap();
            y.c.x var6 = var1.o();

            label185: {
               while(var6.f()) {
                  var7 = var6.e();
                  var10000 = this;
                  if(var17) {
                     break label185;
                  }

                  if(!this.J.d(var7)) {
                     label218: {
                        Object var8 = var20 != null?var20.b(var7):null;
                        y.c.q var9 = this.J.a(var7);
                        j var10 = new j(this, var9, var8, (e)null);
                        if(var26.containsKey(var10)) {
                           y.c.d var11 = var1.a((y.c.q)((y.c.q)var26.get(var10)), (y.c.q)var7);
                           var23.add(var11);
                           if(!var17) {
                              break label218;
                           }
                        }

                        var26.put(var10, var7);
                     }
                  }

                  var6.g();
                  if(var17) {
                     break;
                  }
               }

               var10000 = this;
            }

            var10000.o = y.a.h.a(var1);
            y.c.e var28 = var23.a();

            while(var28.f()) {
               var1.a((y.c.d)var28.a());
               var28.g();
               if(var17) {
                  break label211;
               }

               if(var17) {
                  break;
               }
            }

            var18.f();
         }

         this.z = M.a();
      }

      y.c.x var19 = var1.o();

      while(true) {
         if(var19.f()) {
            y.c.q var22 = var19.e();
            var10000 = this;
            if(var17) {
               break;
            }

            this.z.a(var22, "remain");
            var19.g();
            if(!var17) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      int var21 = var10000.o.length;
      String[] var24 = new String[var21];
      this.D = new HashMap();
      this.C = M.a();
      int var25 = 0;

      label147: {
         y.c.y var27;
         Object var38;
         label146:
         while(true) {
            if(var25 < var21) {
               var24[var25] = "component" + String.valueOf(var25);
               var27 = this.o[var25];
               var38 = var27.a();
               if(var17) {
                  break;
               }

               Object var29 = var38;

               while(((y.c.x)var29).f()) {
                  var7 = ((y.c.x)var29).e();
                  this.z.a(var7, var24[var25]);
                  this.D.put(var7, var27);
                  ((y.c.x)var29).g();
                  if(var17) {
                     continue label146;
                  }

                  if(var17) {
                     break;
                  }
               }

               y.c.q var30 = this.J.a(var27.b());
               if(var30 != null) {
                  label223: {
                     y.c.D var32 = (y.c.D)this.C.b(var30);
                     if(var32 != null) {
                        var32.add(var27);
                        if(!var17) {
                           ++var25;
                           if(!var17) {
                              continue;
                           }
                           break label223;
                        }
                     }

                     var32 = new y.c.D();
                     var32.add(var27);
                     this.C.a(var30, var32);
                     ++var25;
                     if(!var17) {
                        continue;
                     }
                  }
               } else {
                  ++var25;
                  if(!var17) {
                     continue;
                  }
               }
            }

            this.A = new HashMap();
            this.B = new HashMap();
            this.G = new HashMap();
            this.H = new HashMap();
            var25 = 0;
            if(var25 >= var21) {
               break label147;
            }

            var27 = this.o[var25];
            var38 = this.z.b(var27.b());
            break;
         }

         label126:
         while(true) {
            String var31 = (String)var38;
            y.c.y var33 = new y.c.y();
            y.c.f var34 = new y.c.f();
            y.c.f var35 = new y.c.f();
            y.c.f var36 = new y.c.f();
            if(var17) {
               return;
            }

            y.c.x var37 = var27.a();

            label110:
            while(true) {
               boolean var39 = var37.f();

               label107:
               while(true) {
                  if(var39) {
                     y.c.q var12 = var37.e();
                     y.c.e var40 = var12.j();
                     if(var17) {
                        break;
                     }

                     y.c.e var13 = var40;

                     while(var13.f()) {
                        y.c.d var14 = var13.a();
                        y.c.q var15 = var14.a(var12);
                        String var16 = (String)this.z.b(var15);
                        var39 = var16.equals("remain");
                        if(var17) {
                           continue label107;
                        }

                        if(var39) {
                           var33.add(var15);
                           var34.add(var14);
                        }

                        label99: {
                           if(!var16.equals(var31)) {
                              var35.add(var14);
                              if(!var17) {
                                 break label99;
                              }
                           }

                           if(var14.c() == var12) {
                              var36.add(var14);
                           }
                        }

                        var13.g();
                        if(var17) {
                           break;
                        }
                     }

                     var37.g();
                     if(!var17) {
                        continue label110;
                     }
                  }

                  this.B.put(var31, var34);
                  this.A.put(var31, var33);
                  this.G.put(var27, var35);
                  this.H.put(var27, var36);
                  break;
               }

               ++var25;
               if(var17 || var25 >= var21) {
                  break label126;
               }

               var27 = this.o[var25];
               var38 = this.z.b(var27.b());
               break;
            }
         }
      }

      this.n(var1);
   }

   private void j(X var1) {
      boolean var5 = d;
      this.F = new HashMap();
      int var2 = this.o.length;
      int var3 = 0;

      while(true) {
         if(var3 < var2) {
            y.c.y var4 = this.o[var3];
            this.F.put(var4, this.c(var1, var4));
            ++var3;
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         ae.a(var1, this.g.a());
         break;
      }

   }

   private void k(X var1) {
      boolean var9 = d;
      if(this.a() != null && this.o != null) {
         if(this.e instanceof y.f.c.M) {
            ((y.f.c.M)this.e).a(this.P);
            ((y.f.c.M)this.e).b((double)this.Q);
         }

         if(this.e instanceof y.f.e.q) {
            ((y.f.e.q)this.e).d((double)this.Q);
         }

         if(this.e instanceof y.f.f.c) {
            ((y.f.f.c)this.e).a(this.Q);
         }

         int var2 = this.o.length;
         I var3 = new I(var1);
         int var4 = 0;

         while(var4 < var2) {
            y.c.y var5 = this.o[var4];
            y.d.t var6 = this.a(var1, var5);
            var3.a();
            var3.a(var5, true);
            this.d(var1);
            Rectangle2D var7 = this.c(var1, var5);
            y.d.t var8 = new y.d.t(var7.getX() + var7.getWidth() / 2.0D, var7.getY() + var7.getHeight() / 2.0D);
            ae.a(var1, var5.a(), var6.a - var8.a, var6.b - var8.b);
            var3.f();
            ++var4;
            if(var9) {
               break;
            }
         }
      }

   }

   protected void d(X var1) {
      (new y.f.b(this.e)).c(var1);
      this.o(var1);
   }

   private y.d.t a(X var1, y.c.y var2) {
      boolean var9 = d;
      double var3 = 0.0D;
      double var5 = 0.0D;
      y.c.x var7 = var2.a();

      while(var7.f()) {
         y.c.q var8 = var7.e();
         var3 += var1.j(var8);
         var5 += var1.k(var8);
         var7.g();
         if(var9) {
            break;
         }
      }

      return new y.d.t(var3 / (double)var2.size(), var5 / (double)var2.size());
   }

   protected void a(X var1, y.c.y[] var2) {
      this.E = new HashMap();
      this.c(this.x == 3);
      if(this.x == 2) {
         this.a(var1, var2, false);
         this.l(var1);
         if(!this.V) {
            return;
         }

         this.m(var1);
         this.a(var1, var2, false);
         this.l(var1);
         if(!d) {
            return;
         }
      }

      if(this.x == 3) {
         this.a(var1, var2, true);
      }

   }

   private y.d.q a(y.c.q var1, y.d.y var2, double var3, double var5, X var7) {
      double var8 = var3 * (2.0D - this.r);
      double var10 = var5 * (2.0D - this.r);
      if(var2 != null) {
         var8 = Math.max(var8, var2.a);
         var10 = Math.max(var10, var2.b);
      }

      y.d.r var12 = this.a((y.c.q)var1, (y.c.i)var7);
      var8 += var12.b + var12.d;
      var10 += var12.a + var12.c;
      y.c.c var13 = var7.c(y.f.b.f.f);
      if(var13 != null) {
         y.d.q var14 = (y.d.q)var13.b(var1);
         if(var14 != null) {
            var8 = Math.max(var8, var14.a);
            var10 = Math.max(var10, var14.b);
         }
      }

      return new y.d.q(var8, var10);
   }

   private y.d.y a(y.c.D var1) {
      boolean var12 = d;
      if(var1 != null && !var1.isEmpty()) {
         double var2 = Double.MAX_VALUE;
         double var4 = -1.7976931348623157E308D;
         double var6 = Double.MAX_VALUE;
         double var8 = -1.7976931348623157E308D;
         y.c.C var10 = var1.m();

         y.d.y var10000;
         while(true) {
            if(var10.f()) {
               var10000 = (y.d.y)var10.d();
               if(var12) {
                  break;
               }

               y.d.y var11 = var10000;
               var2 = Math.min(var2, var11.c());
               var4 = Math.max(var4, var11.c() + var11.a());
               var6 = Math.min(var6, var11.d());
               var8 = Math.max(var8, var11.d() + var11.b());
               var10.g();
               if(!var12) {
                  continue;
               }
            }

            var10000 = new y.d.y(var2, var6, var4 - var2, var8 - var6);
            break;
         }

         return var10000;
      } else {
         return null;
      }
   }

   private static y.d.y a(y.d.y var0, y.d.y var1) {
      if(var0 == null) {
         return var1;
      } else if(var1 == null) {
         return var0;
      } else {
         double var2 = Math.max(var0.c(), var1.c());
         double var4 = Math.max(var0.d(), var1.d());
         double var6 = Math.min(var0.c() + var0.a(), var1.c() + var1.a());
         double var8 = Math.min(var0.d() + var0.b(), var1.d() + var1.b());
         return new y.d.y(var2, var4, var6 - var2, var8 - var4);
      }
   }

   private void l(X var1) {
      boolean var5 = d;
      y.c.y var2 = this.J.c(this.J.b());
      var2.n();
      y.c.x var3 = var2.a();

      while(var3.f()) {
         y.c.q var4 = var3.e();
         if(this.I.d(var4)) {
            this.a(var4, var1);
         }

         var3.g();
         if(var5) {
            break;
         }
      }

   }

   private void a(y.c.q var1, X var2) {
      boolean var19 = d;
      double var3 = Double.MAX_VALUE;
      double var5 = -1.7976931348623157E308D;
      double var7 = Double.MAX_VALUE;
      double var9 = -1.7976931348623157E308D;
      y.c.y var11 = this.J.b(var1);
      if(var11.size() > 0) {
         y.c.x var12 = var11.a();

         while(var12.f()) {
            y.d.y var13 = var2.s(var12.e());
            var3 = Math.min(var3, var13.c());
            var5 = Math.max(var5, var13.c() + var13.a());
            var7 = Math.min(var7, var13.d());
            var9 = Math.max(var9, var13.d() + var13.b());
            var12.g();
            if(var19) {
               return;
            }

            if(var19) {
               break;
            }
         }

         y.c.c var20 = var2.c(y.f.b.f.e);
         if(var20 != null) {
            y.d.r var21 = y.d.r.a(var20.b(var1));
            if(var21 != null) {
               var3 -= var21.b;
               var5 += var21.d;
               var7 -= var21.a;
               var9 += var21.c;
            }
         }

         y.c.c var22 = var2.c(y.f.b.f.f);
         if(var22 != null) {
            y.d.q var14 = (y.d.q)var22.b(var1);
            if(var14 != null) {
               double var15 = var14.a - var5 + var3;
               double var17 = var14.b - var9 + var7;
               if(var15 > 0.0D) {
                  var3 -= var15 * 0.5D;
                  var5 += var15 * 0.5D;
               }

               if(var17 > 0.0D) {
                  var7 -= var17 * 0.5D;
                  var9 += var17 * 0.5D;
               }
            }
         }

         var2.b(var1, var5 - var3, var9 - var7);
         var2.c(var1, var3, var7);
      }

   }

   private boolean a(y.c.q var1, X var2, y.c.A var3) {
      boolean var15 = d;
      double var4 = Double.MAX_VALUE;
      double var6 = -1.7976931348623157E308D;
      double var8 = Double.MAX_VALUE;
      double var10 = -1.7976931348623157E308D;
      y.c.x var12 = this.J.b(var1).a();

      Object var10000;
      while(true) {
         if(var12.f()) {
            y.c.q var13 = var12.e();
            var10000 = var3;
            if(var15) {
               break;
            }

            if(var3.d(var13) || this.J.d(var13) && !this.I.d(var13)) {
               y.d.y var14 = var2.s(var12.e());
               var4 = Math.min(var4, var14.c());
               var6 = Math.max(var6, var14.c() + var14.a());
               var8 = Math.min(var8, var14.d());
               var10 = Math.max(var10, var14.d() + var14.b());
            }

            var12.g();
            if(!var15) {
               continue;
            }
         }

         var10000 = var2.c(y.f.b.f.e);
         break;
      }

      Object var16 = var10000;
      if(var16 != null) {
         y.d.r var17 = y.d.r.a(((y.c.c)var16).b(var1));
         if(var17 != null) {
            var4 -= var17.b;
            var6 += var17.d;
            var8 -= var17.a;
            var10 += var17.c;
         }
      }

      y.d.y var18 = var2.s(var1);
      var4 = Math.min(var4, var18.c);
      var8 = Math.min(var8, var18.d);
      var6 = Math.max(var6, var18.c + var18.a);
      var10 = Math.max(var10, var18.d + var18.b);
      var2.b(var1, var6 - var4, var10 - var8);
      var2.c(var1, var4, var8);
      return !var2.s(var1).equals(var18);
   }

   private y.d.r a(y.c.q var1, y.c.i var2) {
      y.c.c var3 = var2.c(y.f.b.f.e);
      if(var3 != null) {
         y.d.r var4 = y.d.r.a(var3.b(var1));
         if(var4 != null) {
            return var4;
         }
      }

      return aa;
   }

   private y a(y.c.y var1, X var2, y.c.A var3, y.d.y var4) {
      boolean var13 = d;
      y var5 = new y();
      y.c.q var6 = var1.b();
      y.c.q var7 = this.J.a(var6);
      y.d.y var8;
      if(var7 != null) {
         var8 = var2.s(var7);
         y.d.r var9 = this.a((y.c.q)var7, (y.c.i)var2);
         var5.a = new y.d.y(var8.c + var9.b, var8.d + var9.a, var8.a - var9.b - var9.d, var8.b - var9.a - var9.c);
         var5.c = !this.I.d(var7) && this.s || this.L.d();
      }

      if(var4 != null) {
         var5.a = a(var5.a, var4);
      }

      y.d.y var18;
      label95: {
         y.d.y var11;
         if(var5.c) {
            var8 = var2.s(var6);
            y.c.x var15 = this.t.a();

            while(var15.f()) {
               y.c.q var10 = var15.e();
               var11 = var2.s(var10);
               if(var13) {
                  break label95;
               }

               if(var10 != var7 && !var11.b(var8) && !var8.b(var11)) {
                  y.d.y var12 = new y.d.y(var11.c - (double)this.Q, var11.d - (double)this.Q, var11.a() + (double)(2 * this.Q), var11.b() + (double)(2 * this.Q));
                  var5.b.add(var12);
               }

               var15.g();
               if(var13) {
                  break;
               }
            }
         }

         y.c.x var14 = this.J.b(var7).a();

         d var10000;
         label67: {
            while(var14.f()) {
               y.c.q var16 = var14.e();
               var10000 = this;
               if(var13) {
                  break label67;
               }

               if(this.J.d(var16) && (var3.d(var16) || !this.I.d(var16))) {
                  var18 = var2.s(var16);
                  var11 = new y.d.y(var18.c - (double)this.Q, var18.d - (double)this.Q, var18.a() + (double)(2 * this.Q), var18.b() + (double)(2 * this.Q));
                  var5.b.add(var11);
               }

               var14.g();
               if(var13) {
                  break;
               }
            }

            var10000 = this;
         }

         var8 = var10000.b(var2, var6);
      }

      if(var8 != null) {
         var5.a = a(var5.a, var8);
      }

      if(this.Z != null && var5.a == null) {
         y.d.y var17 = this.Z.a(var6, var2, var3);
         if(var17 != null) {
            var18 = a(var5.a, var17);
            if(var18.a > 0.0D && var18.b > 0.0D) {
               var5.a = var18;
            }
         }
      }

      return var5;
   }

   private y.d.q a(X var1, y.c.q var2) {
      boolean var4 = d;
      y.c.q var3 = this.J.a(var2);

      while(var3 != null && this.I.d(var3)) {
         var3 = this.J.a(var3);
         if(var4) {
            break;
         }
      }

      return (y.d.q)(var3 != null?var1.s(var3):new y.d.q(0.0D, 0.0D));
   }

   private double a(y.f.c.a.l var1) {
      return this.y == 2?var1.h() - var1.e():(this.y == 1?var1.h():(this.y == 3?var1.h() - var1.e():var1.h()));
   }

   private double a(bt var1) {
      return this.y == 2?var1.h() - var1.e():(this.y == 1?var1.h() - var1.e():(this.y == 3?var1.h():var1.h()));
   }

   private y.d.y b(X var1, y.c.q var2) {
      boolean var17 = d;
      y.c.c var3 = var1.c(bk.b);
      if(var3 != null && var3.b(var2) != null) {
         double var4 = Double.MAX_VALUE;
         double var6 = Double.MAX_VALUE;
         double var8 = -1.7976931348623157E308D;
         double var10 = -1.7976931348623157E308D;
         bh var12 = (bh)var3.b(var2);
         Iterator var13 = var12.a().iterator();

         while(true) {
            if(var13.hasNext()) {
               bj var14 = (bj)var13.next();
               y.f.c.a.l var15 = var14.b();
               var4 = Math.min(var4, this.a(var15) + var15.c());
               var8 = Math.max(var8, this.a(var15) + var15.e() - var15.d());
               bt var16 = var14.a();
               var6 = Math.min(var6, this.a(var16) + var16.c());
               var10 = Math.max(var10, this.a(var16) + var16.e() - var16.d());
               if(var17) {
                  break;
               }

               if(!var17) {
                  continue;
               }
            }

            if(this.y != 1 && this.y != 3) {
               return new y.d.y(var4, var6, var8 - var4, var10 - var6);
            }
            break;
         }

         return new y.d.y(var6, var4, var10 - var6, var8 - var4);
      } else {
         return null;
      }
   }

   private boolean a(X var1, y.c.q var2, boolean var3, y.c.A var4) {
      double var5;
      y.c.D var7;
      y.d.q var10;
      boolean var22;
      label95: {
         var22 = d;
         var5 = (double)(5 + this.Q);
         var7 = new y.c.D();
         y.d.q var8 = this.a(var1, var2);
         y.d.y var9 = this.b(var1, var2);
         if(var9 != null) {
            var10 = new y.d.q(Math.min(var8.a, var9.a), Math.min(var8.b, var9.b));
            if(!var22) {
               break label95;
            }
         }

         var10 = var8;
      }

      double var11 = 0.0D;
      double var13 = 0.0D;
      y.c.x var15 = this.J.b(var2).a();

      y.c.A var10000;
      y.c.q var10001;
      while(true) {
         if(var15.f()) {
            y.c.q var16 = var15.e();
            var10000 = var4;
            var10001 = var16;
            if(var22) {
               break;
            }

            if(var4.d(var16)) {
               label103: {
                  var7.add(var1.s(var16));
                  if(var10.b() - (var13 + var1.q(var16)) > var10.a() - (var11 + var1.p(var16))) {
                     var13 += var1.q(var16) + var5;
                     var11 = Math.max(var11, var1.p(var16));
                     if(!var22) {
                        break label103;
                     }
                  }

                  var13 = Math.max(var13, var1.q(var16));
                  var11 += var1.p(var16) + var5;
               }
            }

            var15.g();
            if(!var22) {
               continue;
            }
         }

         var10000 = this.C;
         var10001 = var2;
         break;
      }

      d var26;
      label74: {
         y.c.D var23 = (y.c.D)var10000.b(var10001);
         if(var23 != null) {
            y.c.C var24 = var23.m();

            while(var24.f()) {
               y.c.y var17 = (y.c.y)var24.d();
               y.c.q var18 = var17.b();
               var26 = this;
               if(var22) {
                  break label74;
               }

               label101: {
                  if(this.J.d(var18)) {
                     label65: {
                        y.d.q var19 = (y.d.q)this.p.b(var18);
                        if(var10.b() - (var13 + var19.b()) > var10.a() - (var11 + var19.a())) {
                           var13 += var19.b() + var5;
                           var11 = Math.max(var11, var19.a());
                           if(!var22) {
                              break label65;
                           }
                        }

                        var13 = Math.max(var13, var19.b());
                        var11 += var19.a() + var5;
                     }

                     y.d.y var20 = (y.d.y)this.q.b(var18);
                     if(var20 == null) {
                        break label101;
                     }

                     y.d.r var21 = this.a((y.c.q)var18, (y.c.i)var1);
                     var7.add(new y.d.y(var20.c - var21.b, var20.d - var21.a, var20.a + var21.b + var21.d, var20.b + var21.a + var21.c));
                     if(!var22) {
                        break label101;
                     }
                  }

                  Rectangle2D var29 = this.c(var1, var17);
                  if(var10.b() - (var13 + var29.getHeight()) > var10.a() - (var11 + var29.getWidth())) {
                     var13 += var29.getHeight() + var5;
                     var11 = Math.max(var11, var29.getWidth());
                     if(!var22) {
                        break label101;
                     }
                  }

                  var13 = Math.max(var13, var29.getHeight());
                  var11 += var29.getWidth() + var5;
               }

               var24.g();
               if(var22) {
                  break;
               }
            }
         }

         var26 = this;
      }

      y.d.y var25 = var26.a(var7);
      this.q.a(var2, var25);
      if(var3) {
         this.p.a(var2, var1.s(var2));
         return false;
      } else if(this.J.b(var2).size() <= 0) {
         this.p.a(var2, var1.s(var2));
         return false;
      } else {
         y.d.q var27 = (y.d.q)this.p.b(var2);
         y.d.q var28 = this.a(var2, var25, var11, var13, var1);
         this.p.a(var2, var28);
         return var27 != null && !var27.equals(var28);
      }
   }

   private void a(X var1, boolean var2, y.c.A var3) {
      boolean var7 = d;
      this.p = M.a();
      this.q = M.a();
      y.c.y var4 = this.J.c(this.J.b());
      var4.n();
      y.c.x var5 = var4.a();

      while(var5.f()) {
         y.c.q var6 = var5.e();
         if(this.I.d(var6)) {
            this.a(var1, var6, var2, var3);
         }

         var5.g();
         if(var7) {
            break;
         }
      }

   }

   private void a(X var1, y.c.y[] var2, boolean var3) {
      boolean var10 = d;
      y.c.A var4 = M.a();
      y.c.A var5 = M.a();
      y.c.x var6 = this.g.a();

      while(var6.f()) {
         var4.a(var6.e(), true);
         var5.a(var6.e(), true);
         var6.g();
         if(var10) {
            break;
         }
      }

      g var11 = new g(this, var4);
      y.c.h var7 = M.b();
      y.c.e var8 = var1.p();

      while(true) {
         if(var8.f()) {
            y.c.d var9 = var8.a();
            if(var10) {
               break;
            }

            var7.a(var9, this.z.b(var9.c()) == this.z.b(var9.d()));
            var8.g();
            if(!var10) {
               continue;
            }
         }

         this.a(var1, var3, var5);
         this.a(var1, var2, this.g, var3, var4, var5, var7, var11);
         break;
      }

      if(this.U) {
         this.a(var1, var3, var4, var5, var7, var11);
      }

   }

   private void a(X param1, boolean param2, y.c.A param3, y.c.A param4, y.c.h param5, y.c.c param6) {
      // $FF: Couldn't be decompiled
   }

   private void a(X var1, y.c.y[] var2, y.c.y var3, boolean var4, y.c.A var5, y.c.A var6, y.c.h var7, y.c.c var8) {
      boolean var22 = d;
      y.c.y var9 = new y.c.y(var3);
      int var10 = 0;

      label204:
      do {
         int var10000 = var10;

         label201:
         while(var10000 < var2.length) {
            y.c.y var11 = var2[var10];
            if(var11 != null && var11.size() > 0) {
               y.c.q var12;
               boolean var33;
               label211: {
                  if(this.I.d(var11.b())) {
                     var12 = var11.b();
                     String var13 = (String)this.z.b(var12);
                     y.c.y var14 = (y.c.y)this.A.get(var13);
                     y.c.e var15 = this.J.f(var12).a();

                     y.c.d var16;
                     while(true) {
                        if(var15.f()) {
                           var16 = var15.a();
                           var33 = var5.d(var16.c());
                           if(var22) {
                              break;
                           }

                           if(var33) {
                              var14.add(var16.c());
                           }

                           var15.g();
                           if(!var22) {
                              continue;
                           }
                        }

                        var15 = this.J.g(var12).a();
                        var33 = var15.f();
                        break;
                     }

                     while(var33) {
                        var16 = var15.a();
                        var10000 = var5.d(var16.d());
                        if(var22) {
                           continue label201;
                        }

                        if(var10000 != 0) {
                           var14.add(var16.d());
                        }

                        var15.g();
                        if(var22) {
                           break;
                        }

                        var33 = var15.f();
                     }

                     y.d.q var31 = (y.d.q)this.p.b(var12);
                     var1.a(var12, var31);
                     y.d.y var34 = null;
                     y.d.y var17 = (y.d.y)this.q.b(var12);
                     if(var17 != null) {
                        double var18 = var31.a - var17.a;
                        double var20 = var31.b - var17.b;
                        var34 = new y.d.y(var17.c - var18, var17.d - var20, var17.a + 2.0D * var18, var17.b + 2.0D * var20);
                     }

                     y var40 = this.a(var11, var1, var5, var34);
                     y.d.t var19 = this.a(var1, var9, var5, var11, var40, !var4, this.p);
                     var1.a(var12, var19);
                     this.L.c(false);
                     this.L.a(this.W == 2147483647L?2147483647L:this.W - System.currentTimeMillis() + this.u);
                     k var43 = new k(this, var12, var8);
                     this.L.a(var1, var43, var7, var11, var40, (SortedSet)this.E.get(var11), this.M);
                     var5.a(var12, true);
                     if(!var22) {
                        break label211;
                     }
                  }

                  y var23 = this.a(var11, (X)var1, (y.c.A)var5, (y.d.y)null);
                  y.d.t var24 = this.a(var1, var9, var5, var11, var23, !var4, this.p);
                  Rectangle2D var26 = this.c(var1, var11);
                  double var32 = -(var26.getCenterX() - var24.a);
                  double var36 = -(var26.getCenterY() - var24.b);
                  ae.a(var1, var11.a(), var32, var36);
                  this.L.c(this.b());
                  this.L.a(this.W == 2147483647L?2147483647L:this.W - System.currentTimeMillis() + this.u);
                  this.L.a(var1, var8, var7, var11, var23, (SortedSet)this.E.get(var11), this.M);
                  y.c.x var42 = var11.a();

                  while(var42.f()) {
                     var5.a(var42.e(), true);
                     var42.g();
                     if(var22) {
                        break label211;
                     }

                     if(var22) {
                        break;
                     }
                  }

                  var9.addAll(var11);
               }

               var12 = this.J.a(var11.b());
               if((this.s || this.L.d()) && var12 != null) {
                  boolean var25;
                  if(this.I.d(var12)) {
                     var25 = this.a(var1, var12, var4, var6);
                  } else {
                     var25 = this.a(var12, var1, var5);
                  }

                  y.c.q var39 = this.J.a(var12);

                  label155:
                  while(true) {
                     y.c.q var27 = var39;

                     while(true) {
                        if(!var25) {
                           break label155;
                        }

                        var39 = var27;
                        if(var22) {
                           break;
                        }

                        if(var27 == null) {
                           break label155;
                        }

                        label150: {
                           if(this.I.d(var27)) {
                              var25 = this.a(var1, var27, var4, var6);
                              if(!var22) {
                                 break label150;
                              }
                           }

                           var25 = this.a(var27, var1, var5);
                        }

                        var27 = this.J.a(var27);
                        if(var22) {
                           break label155;
                        }
                     }
                  }
               }

               if(this.Y) {
                  label219: {
                     y.c.f var28 = new y.c.f();
                     y.c.x var29 = var11.a();

                     y.c.e var41;
                     label130:
                     while(true) {
                        var33 = var29.f();

                        label127:
                        while(var33) {
                           y.c.q var35 = var29.e();
                           var41 = var35.j();
                           if(var22) {
                              break label130;
                           }

                           y.c.e var37 = var41;

                           while(var37.f()) {
                              y.c.d var38 = var37.a();
                              var33 = var5.d(var38.a(var35));
                              if(var22) {
                                 continue label127;
                              }

                              if(var33 && this.z.b(var38.c()) != this.z.b(var38.d())) {
                                 var28.add(var38);
                              }

                              var37.g();
                              if(var22) {
                                 break;
                              }
                           }

                           var29.g();
                           if(!var22) {
                              continue label130;
                           }
                           break;
                        }

                        if(var28.isEmpty()) {
                           break label219;
                        }

                        this.a(var1, var28);
                        var41 = var28.a();
                        break;
                     }

                     y.c.e var30 = var41;

                     while(var30.f()) {
                        var7.a(var30.a(), true);
                        var30.g();
                        if(var22) {
                           continue label204;
                        }

                        if(var22) {
                           break;
                        }
                     }
                  }
               }
            }

            ++var10;
            continue label204;
         }

         return;
      } while(!var22);

   }

   private void m(X var1) {
      boolean var9 = d;
      int var2 = 0;

      while(var2 < this.o.length) {
         y.c.y var3 = this.o[var2];
         double var4 = this.b(var1, var3);
         byte var6 = 0;
         this.a(var1, var3, true);
         double var7 = this.b(var1, var3);
         if(var7 < var4) {
            var4 = var7;
            var6 = 1;
         }

         label42: {
            if(!this.M) {
               this.a(var1, var3, false);
               var7 = this.b(var1, var3);
               if(var7 < var4) {
                  var4 = var7;
                  var6 = 2;
               }

               this.a(var1, var3, true);
               var7 = this.b(var1, var3);
               if(var7 < var4) {
                  var6 = 3;
               }

               this.a(var1, var3, false);
               if(!var9) {
                  break label42;
               }
            }

            this.a(var1, var3, true);
         }

         switch(var6) {
         case 0:
            if(!var9) {
               break;
            }
         case 1:
            this.a(var1, var3, true);
            if(!var9) {
               break;
            }
         case 2:
            this.a(var1, var3, true);
            this.a(var1, var3, false);
            if(!var9) {
               break;
            }
         case 3:
            this.a(var1, var3, true);
            this.a(var1, var3, false);
            this.a(var1, var3, true);
         }

         ++var2;
         if(var9) {
            break;
         }
      }

   }

   private double b(X var1, y.c.y var2) {
      boolean var8 = d;
      double var3 = 0.0D;
      y.c.f var5 = (y.c.f)this.G.get(var2);
      y.c.e var6 = var5.a();

      double var10000;
      while(true) {
         if(var6.f()) {
            y.c.d var7 = var6.a();
            var10000 = var3 + ae.a(var1, var7.c(), var7.d());
            if(var8) {
               break;
            }

            var3 = var10000;
            var6.g();
            if(!var8) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   private void a(X var1, y.c.y var2, boolean var3) {
      Rectangle2D var5;
      double var6;
      double var8;
      label85: {
         boolean var19 = d;
         y.c.f var4 = (y.c.f)this.H.get(var2);
         var5 = ae.a(var1, var2.a());
         var6 = 0.0D - var5.getCenterX();
         var8 = 0.0D - var5.getCenterY();
         ae.a(var1, var2.a(), var6, var8);
         y.c.x var10;
         y.c.q var11;
         y.d.v var12;
         ArrayList var13;
         y.d.u var14;
         y.d.t var15;
         y.d.t var16;
         y.d.t var17;
         y.d.t var18;
         y.c.e var20;
         y.c.d var21;
         y.d.v var22;
         if(var3) {
            var10 = var2.a();

            while(var10.f()) {
               var11 = var10.e();
               var1.a(var11, -var1.j(var11), var1.k(var11));
               var10.g();
               if(var19) {
                  break;
               }
            }

            var20 = var4.a();

            do {
               label70:
               while(true) {
                  if(!var20.f()) {
                     break label85;
                  }

                  var21 = var20.a();
                  var12 = var1.j(var21);
                  var13 = new ArrayList();
                  if(var19) {
                     return;
                  }

                  var14 = var12.b();

                  while(true) {
                     if(!var14.f()) {
                        break label70;
                     }

                     var15 = var14.a();
                     var13.add(new y.d.t(-var15.a(), var15.b()));
                     var14.g();
                     if(var19) {
                        break;
                     }

                     if(var19) {
                        break label70;
                     }
                  }
               }

               var22 = new y.d.v(var13);
               var1.b(var21, var22);
               var15 = var1.n(var21);
               var16 = new y.d.t(-var15.a(), var15.b());
               var1.a(var21, var16);
               var17 = var1.o(var21);
               var18 = new y.d.t(-var17.a(), var17.b());
               var1.b(var21, var18);
               var20.g();
            } while(!var19);
         }

         var10 = var2.a();

         while(var10.f()) {
            var11 = var10.e();
            var1.a(var11, var1.j(var11), -var1.k(var11));
            var10.g();
            if(var19) {
               break;
            }
         }

         var20 = var4.a();

         label48:
         do {
            label46:
            while(true) {
               if(!var20.f()) {
                  break label48;
               }

               var21 = var20.a();
               var12 = var1.j(var21);
               var13 = new ArrayList();
               if(var19) {
                  return;
               }

               var14 = var12.b();

               while(true) {
                  if(!var14.f()) {
                     break label46;
                  }

                  var15 = var14.a();
                  var13.add(new y.d.t(var15.a(), -var15.b()));
                  var14.g();
                  if(var19) {
                     break;
                  }

                  if(var19) {
                     break label46;
                  }
               }
            }

            var22 = new y.d.v(var13);
            var1.b(var21, var22);
            var15 = var1.n(var21);
            var16 = new y.d.t(var15.a(), -var15.b());
            var1.a(var21, var16);
            var17 = var1.o(var21);
            var18 = new y.d.t(var17.a(), -var17.b());
            var1.b(var21, var18);
            var20.g();
         } while(!var19);
      }

      var6 = var5.getCenterX();
      var8 = var5.getCenterY();
      ae.a(var1, var2.a(), var6, var8);
   }

   private void a(y.c.A var1) {
      boolean var8 = d;
      y.c.A var2 = M.a();
      y.c.x var3 = this.g.a();

      while(var3.f()) {
         var2.a(var3.e(), true);
         var3.g();
         if(var8) {
            break;
         }
      }

      y.c.y var9 = this.J.c(this.J.b());
      var9.n();
      y.c.x var4 = var9.a();

      do {
         boolean var10000 = var4.f();

         label40:
         while(true) {
            if(!var10000) {
               return;
            }

            y.c.q var5 = var4.e();
            if(!this.J.d(var5)) {
               break;
            }

            y.c.x var6 = this.J.b(var5).a();

            while(true) {
               if(!var6.f()) {
                  break label40;
               }

               y.c.q var7 = var6.e();
               var10000 = var2.d(var7);
               if(var8) {
                  break;
               }

               if(var10000 || var1.d(var7)) {
                  var1.a(var5, true);
                  if(!var8) {
                     break label40;
                  }
               }

               var6.g();
               if(var8) {
                  break label40;
               }
            }
         }

         var4.g();
      } while(!var8);

   }

   private y.c.i a(X var1, y.c.A var2, y.c.y var3) {
      boolean var17 = d;
      y.c.i var4 = new y.c.i();
      y.c.A var5 = M.a();
      this.t = new y.c.y();
      y.c.x var6 = var1.o();

      y.c.q var7;
      y.c.q var9;
      y.c.q var10000;
      while(true) {
         if(var6.f()) {
            var10000 = var6.e();
            if(var17) {
               break;
            }

            var7 = var10000;
            if(this.J.d(var7)) {
               y.c.q var8 = var4.d();
               var2.a(var7, var8);
               if(!this.I.d(var7)) {
                  var3.add(var8);
                  this.t.add(var7);
               }

               var9 = var4.d();
               var3.add(var9);
               var5.a(var7, var9);
            }

            var6.g();
            if(!var17) {
               continue;
            }
         }

         var10000 = var4.d();
         break;
      }

      y.c.q var18 = var10000;
      var3.add(var18);
      var7 = var4.d();
      var3.add(var7);
      int var19 = 0;

      y.c.q var11;
      y.c.q var12;
      y.c.q var13;
      y.c.A var28;
      label137: {
         label152: {
            y.c.q var10;
            while(true) {
               if(var19 < this.o.length) {
                  y.c.y var21 = this.o[var19];
                  var10 = var21.b();
                  var11 = this.J.a(var10);
                  if(var17) {
                     break;
                  }

                  label130: {
                     var12 = var11 != null?(y.c.q)var2.b(var11):var18;
                     if(this.J.d(var10)) {
                        var13 = (y.c.q)var2.b(var10);
                        if(!var17) {
                           break label130;
                        }
                     }

                     var13 = var4.d();
                     var2.a(var10, var13);
                  }

                  var4.a(var12, var13);
                  ++var19;
                  if(!var17) {
                     continue;
                  }
               }

               if(!this.s && !this.L.d()) {
                  break label152;
               }
               break;
            }

            y.c.x var20 = this.t.a();

            label119:
            do {
               boolean var27 = var20.f();

               label116:
               while(true) {
                  if(!var27) {
                     break label119;
                  }

                  var9 = var20.e();
                  var28 = var2;
                  if(var17) {
                     break label137;
                  }

                  Object var29 = var2.b(var9);

                  while(true) {
                     var10 = (y.c.q)var29;
                     var11 = this.J.a(var9);

                     while(var11 != null) {
                        var27 = this.I.d(var11);
                        if(var17) {
                           continue label116;
                        }

                        if(!var27) {
                           break;
                        }

                        var11 = this.J.a(var11);
                        if(var17) {
                           break;
                        }
                     }

                     var12 = var11 != null?(y.c.q)var2.b(var11):var18;
                     var4.a(var10, var12);
                     y.c.D var25 = (y.c.D)this.C.b(var9);
                     if(var25 == null) {
                        break label116;
                     }

                     while(true) {
                        if(var25.isEmpty()) {
                           break label116;
                        }

                        y.c.y var14 = (y.c.y)var25.g();
                        y.c.q var15 = var14.b();
                        y.c.q var16 = (y.c.q)var2.b(var15);
                        var4.a(var16, var12);
                        if(this.I.d(var15)) {
                           var29 = this.C.b(var15);
                           if(var17) {
                              break;
                           }

                           if(var29 != null) {
                              var25.addAll((y.c.D)this.C.b(var15));
                              if(var17) {
                                 break label116;
                              }
                           }
                        }
                     }
                  }
               }

               var20.g();
            } while(!var17);
         }

         var28 = M.a();
      }

      y.c.A var22 = var28;
      this.a(var22);
      int var23 = 0;

      while(true) {
         if(var23 < this.o.length) {
            y.c.y var24 = this.o[var23];
            var11 = var24.b();
            var12 = (y.c.q)var2.b(var11);
            var13 = this.J.a(var11);
            if(var17) {
               break;
            }

            label73: {
               y.c.q var26 = var13 != null?(y.c.q)var5.b(var13):var7;
               if(var22.d(var11)) {
                  var4.a(var12, var26);
                  if(!var17) {
                     break label73;
                  }
               }

               var4.a(var26, var12);
            }

            ++var23;
            if(!var17) {
               continue;
            }
         }

         if(y.a.g.b(var4)) {
            throw new RuntimeException("constraint graph is cyclic!");
         }
         break;
      }

      return var4;
   }

   private void n(X var1) {
      boolean var23 = d;
      y.c.A var2 = M.a();
      y.c.y var3 = new y.c.y();
      y.c.i var4 = this.a(var1, var2, var3);
      l var5 = new l(this, var1, var4, var2, var3);
      int var6 = this.o.length;
      int var7 = 0;

      while(var7 < var6) {
         y.c.y var8 = this.o[var7];
         String var9 = (String)this.z.b(var8.b());
         y.c.y var10 = (y.c.y)this.A.get(var9);
         int var11 = this.a(var8.b(), var1, var10);
         var5.a(var8.b(), var11);
         ++var7;
         if(var23) {
            break;
         }
      }

      ArrayList var24 = new ArrayList();
      y.c.y[] var25 = new y.c.y[var6];
      int var26 = 0;

      label58:
      while(true) {
         if(!var5.a()) {
            y.c.q var27 = var5.c();
            y.c.y var28 = (y.c.y)this.D.get(var27);
            var25[var26] = var28;
            ++var26;
            Object var10000 = this.z.b(var27);

            label54:
            while(true) {
               String var12 = (String)var10000;
               var24.add(var12);
               y.c.x var13 = var28.a();

               while(true) {
                  boolean var29 = var13.f();

                  label49:
                  while(true) {
                     if(!var29) {
                        continue label58;
                     }

                     y.c.q var14 = var13.e();
                     if(var23) {
                        return;
                     }

                     var10000 = var14.j();
                     if(var23) {
                        continue label54;
                     }

                     Object var15 = var10000;

                     while(true) {
                        if(!((y.c.e)var15).f()) {
                           break label49;
                        }

                        y.c.d var16 = ((y.c.e)var15).a();
                        y.c.q var17 = var16.a(var14);
                        String var18 = (String)this.z.b(var17);
                        y.c.y var19 = (y.c.y)this.D.get(var17);
                        var29 = var18.equals("remain");
                        if(var23) {
                           break;
                        }

                        if(!var29 && !var24.contains(var18) && var5.a(var19.b())) {
                           y.c.y var20 = (y.c.y)this.A.get(var18);
                           var20.add(var14);
                           y.c.f var21 = (y.c.f)this.B.get(var18);
                           var21.add(var16);
                           int var22 = this.a(var19.b(), var1, var20);
                           var5.b(var19.b(), var22);
                        }

                        ((y.c.e)var15).g();
                        if(var23) {
                           break label49;
                        }
                     }
                  }

                  var13.g();
                  if(var23) {
                     break label54;
                  }
               }
            }
         }

         this.o = var25;
         return;
      }
   }

   private int a(y.c.q var1, X var2, y.c.y var3) {
      int var4 = this.Z == null?1:this.Z.a(var1) + 2;
      int var5 = var4 * var2.h() - var3.size();
      return var5;
   }

   private y.d.t a(double var1, double var3, Rectangle2D var5, y.d.y var6) {
      boolean var16 = d;
      y.d.y var7 = new y.d.y(var6.c() + var5.getWidth() / 2.0D, var6.d() + var5.getHeight() / 2.0D, var6.a() - var5.getWidth(), var6.b() - var5.getHeight());
      double var8 = var7.c();
      double var10 = var7.d();
      double var12 = var7.a();
      double var14 = var7.b();
      if(!var7.a(var1, var3)) {
         if(var1 <= var8) {
            if(var3 <= var10) {
               var1 = var8;
               var3 = var10;
               if(!var16) {
                  return new y.d.t(var1, var3);
               }
            }

            if(var3 <= var10 + var14) {
               var1 = var8;
               if(!var16) {
                  return new y.d.t(var1, var3);
               }
            }

            if(var3 <= var10 + var14) {
               return new y.d.t(var1, var3);
            }

            var1 = var8;
            var3 = var10 + var14;
            if(!var16) {
               return new y.d.t(var1, var3);
            }
         }

         if(var1 <= var8 + var12) {
            if(var3 <= var10) {
               var3 = var10;
               if(!var16) {
                  return new y.d.t(var1, var3);
               }
            }

            if(var3 <= var10 + var14 || var3 <= var10 + var14) {
               return new y.d.t(var1, var3);
            }

            var3 = var10 + var14;
            if(!var16) {
               return new y.d.t(var1, var3);
            }
         }

         if(var1 > var8 + var12) {
            if(var3 <= var10) {
               var1 = var8 + var12;
               var3 = var10;
               if(!var16) {
                  return new y.d.t(var1, var3);
               }
            }

            if(var3 <= var10 + var14) {
               var1 = var8 + var12;
               if(!var16) {
                  return new y.d.t(var1, var3);
               }
            }

            if(var3 > var10 + var14) {
               var1 = var8 + var12;
               var3 = var10 + var14;
            }
         }
      }

      return new y.d.t(var1, var3);
   }

   private static y.c.y a(X var0, y.c.y var1, y.c.A var2) {
      boolean var9 = d;
      y.c.y var3 = new y.c.y();
      y.c.y[] var4 = y.a.b.a(var0, var1);
      int var5 = 1;

      label41:
      while(true) {
         int var10000 = var5;

         y.c.y var10;
         label38:
         while(var10000 < var4.length) {
            var10 = var3;
            if(var9) {
               return var10;
            }

            if(!var3.isEmpty()) {
               break;
            }

            y.c.y var6 = var4[var5];
            y.c.x var7 = var6.a();

            while(var7.f()) {
               y.c.q var8 = var7.e();
               var10000 = var2.d(var8);
               if(var9) {
                  continue label38;
               }

               if(var10000 != 0) {
                  var3.add(var8);
               }

               var7.g();
               if(var9) {
                  break;
               }
            }

            ++var5;
            if(!var9) {
               continue label41;
            }
            break;
         }

         var10 = var3;
         return var10;
      }
   }

   private static ax a(y.c.d var0, boolean var1, X var2) {
      boolean var12 = d;
      y.c.c var3 = var1?var2.c(ax.a):var2.c(ax.b);
      if(var3 == null) {
         return null;
      } else {
         Collection var4 = (Collection)var3.b(var0);
         if(var4 != null && !var4.isEmpty()) {
            Iterator var5 = var4.iterator();
            ax var6 = (ax)var5.next();
            double var7 = var6.f();

            int var10000;
            while(true) {
               if(var5.hasNext()) {
                  ax var9 = (ax)var5.next();
                  double var10 = var9.f();
                  double var13;
                  var10000 = (var13 = var10 - var7) == 0.0D?0:(var13 < 0.0D?-1:1);
                  if(var12) {
                     break;
                  }

                  if(var10000 >= 0 && (var10 != var7 || !var6.b() || var9.b()) && (var10 != var7 || var6.a((int)255) || !var9.a((int)255))) {
                     continue;
                  }

                  var6 = var9;
                  var7 = var10;
                  if(!var12) {
                     continue;
                  }
               }

               var10000 = var6.a((int)255);
               break;
            }

            return var10000 != 0 && !var6.b()?null:var6;
         } else {
            return null;
         }
      }
   }

   private static y.d.t b(y.c.d var0, boolean var1, X var2) {
      y.c.q var3 = var1?var0.c():var0.d();
      aE var4 = var1?aE.d(var2, var0):aE.e(var2, var0);
      if(var4 != null) {
         if(var4.a()) {
            return var1?var2.p(var0):var2.q(var0);
         }

         if(!var4.g()) {
            y.d.y var5 = var2.s(var3);
            if(var4.c()) {
               return new y.d.t(var5.c() + var5.a() * 0.5D, var5.d());
            }

            if(var4.d()) {
               return new y.d.t(var5.c() + var5.a() * 0.5D, var5.d() + var5.b());
            }

            if(var4.f()) {
               return new y.d.t(var5.c(), var5.d() + var5.b() * 0.5D);
            }

            if(var4.e()) {
               return new y.d.t(var5.c() + var5.a(), var5.d() + var5.b() * 0.5D);
            }
         }
      }

      ax var7 = a(var0, var1, var2);
      if(var7 != null) {
         if(var7.b()) {
            y.d.t var8 = var2.l(var3);
            return new y.d.t(var8.a() + var7.c(), var8.b() + var7.d());
         }

         if(!var7.a((int)255)) {
            y.d.y var6 = var2.s(var3);
            if(var7.a() == 1) {
               return new y.d.t(var6.c() + var6.a() * 0.5D, var6.d());
            }

            if(var7.a() == 2) {
               return new y.d.t(var6.c() + var6.a() * 0.5D, var6.d() + var6.b());
            }

            if(var7.a() == 8) {
               return new y.d.t(var6.c(), var6.d() + var6.b() * 0.5D);
            }

            if(var7.a() == 4) {
               return new y.d.t(var6.c() + var6.a(), var6.d() + var6.b() * 0.5D);
            }
         }
      }

      return var2.l(var3);
   }

   private y.d.t a(y.c.y var1, y.c.f var2, y.d.t var3, X var4) {
      boolean var19 = d;
      String var5 = (String)this.z.b(var1.b());
      double var6 = 0.0D;
      double var8 = 0.0D;
      y.c.e var10 = var2.a();

      int var10000;
      while(true) {
         if(var10.f()) {
            y.c.d var11 = var10.a();
            y.d.t var12 = b(var11, true, var4);
            y.d.t var13 = b(var11, false, var4);
            byte var14 = var5.equals(this.z.b(var11.c()));
            var10000 = var14;
            if(var19) {
               break;
            }

            double var15 = var14 != 0?var13.a - var12.a:var12.a - var13.a;
            double var17 = var14 != 0?var13.b - var12.b:var12.b - var13.b;
            var6 += var3.a() + var15;
            var8 += var3.b() + var17;
            var10.g();
            if(!var19) {
               continue;
            }
         }

         var10000 = var2.size();
         break;
      }

      int var20 = var10000;
      return new y.d.t(var6 / (double)var20, var8 / (double)var20);
   }

   private y.d.t a(X var1, y.c.y var2, y.c.A var3, y.c.y var4, y var5, boolean var6, y.c.A var7) {
      Rectangle2D var10;
      double var12;
      double var14;
      y.c.q var18;
      boolean var23;
      label115: {
         var23 = d;
         String var8 = (String)this.z.b(var4.b());
         y.c.y var9 = (y.c.y)this.A.get(var8);
         var10 = this.c(var1, var4);
         y.d.t var11 = new y.d.t(var10.getCenterX(), var10.getCenterY());
         var12 = 0.0D;
         var14 = 0.0D;
         if(var6) {
            y.c.x var17;
            if(var9.size() > 0) {
               boolean var16 = this.I.d(var4.b());
               if(var16) {
                  var17 = var9.a();

                  label107: {
                     while(var17.f()) {
                        var18 = var17.e();
                        var12 += var1.j(var18);
                        var14 += var1.k(var18);
                        var17.g();
                        if(var23) {
                           break label107;
                        }

                        if(var23) {
                           break;
                        }
                     }

                     var12 /= (double)var9.size();
                     var14 /= (double)var9.size();
                  }

                  if(!var23) {
                     break label115;
                  }
               }

               y.c.f var27 = (y.c.f)this.B.get(var8);
               y.d.t var30 = this.a(var4, var27, var11, var1);
               var12 = var30.a();
               var14 = var30.b();
               if(!var23) {
                  break label115;
               }
            }

            y.c.y var24 = a(var1, var4, var3);
            if(var24.isEmpty()) {
               var12 = this.T != null?this.T.a:0.0D;
               var14 = this.T != null?this.T.b:0.0D;
               if(!var23) {
                  break label115;
               }
            }

            var17 = var24.a();

            label94: {
               while(var17.f()) {
                  var18 = var17.e();
                  var12 += var1.j(var18);
                  var14 += var1.k(var18);
                  var17.g();
                  if(var23) {
                     break label94;
                  }

                  if(var23) {
                     break;
                  }
               }

               var12 /= (double)var24.size();
               var14 /= (double)var24.size();
            }

            if(!var23) {
               break label115;
            }
         }

         var12 = var10.getCenterX();
         var14 = var10.getCenterY();
      }

      if(var5 != null && var5.a != null) {
         y.d.t var25 = this.a(var12, var14, var10, var5.a);
         var12 = var25.a();
         var14 = var25.b();
      }

      label75: {
         if(this.M) {
            a var26 = new a();
            var26.a(this.P);
            SortedSet var29 = var26.a(var1, var4, var2, var3, this.G, new y.d.t(var12, var14), this.b(), var5, this.I, var7);
            this.E.put(var4, var29);
            if(var29.size() <= 0) {
               break label75;
            }

            y.d.m var32 = (y.d.m)var29.iterator().next();
            if(var32 == null) {
               break label75;
            }

            var14 = var32.c().b();
            if(var5 == null || var5.a == null) {
               break label75;
            }

            double var19 = var5.a.d + var10.getHeight() / 2.0D;
            double var21 = var5.a.d + var5.a.b - var10.getHeight() / 2.0D;
            if(var19 > var14) {
               var14 = var19;
               if(!var23) {
                  break label75;
               }
            }

            if(var21 >= var14) {
               break label75;
            }

            var14 = var21;
            if(!var23) {
               break label75;
            }
         }

         if(this.b()) {
            z var28 = new z();
            y.d.t var31 = new y.d.t(var12, var14);
            var18 = null;
            b var34;
            if(var5 != null && var5.a != null) {
               var34 = new b(var5.a.c(), var5.a.d(), var5.a.a(), var5.a.b(), var31);
            } else {
               var34 = new b(-10000.0D, -10000.0D, 30000.0D, 30000.0D, var31);
            }

            SortedSet var33 = var28.a(var1, var2, var4, var34, var31, false);
            this.E.put(var4, var33);
         }
      }

      this.T = new y.d.t(var12, var14);
      return this.T;
   }

   private void o(X var1) {
      if(this.O) {
         this.a(var1, var1.p());
      }

   }

   private static double a(y.c.d var0, X var1) {
      y.d.y var2 = var1.s(var0.c());
      y.d.y var3 = var1.s(var0.d());
      return var2.d() + var2.b() < var3.d()?var3.d() - var2.d() + var2.b():(var3.d() + var3.b() < var2.d()?var2.d() - var3.d() + var3.b():0.0D);
   }

   protected void a(X var1, y.c.f var2) {
      this.a(var1, var2.a());
   }

   protected void b(X var1, y.c.f var2) {
      this.a(var1, var2.a());
   }

   private void a(X var1, y.c.e var2) {
      boolean var6 = d;
      y.c.h var3 = var1.u();

      while(var2.f()) {
         var3.a(var2.a(), true);
         var2.g();
         if(var6) {
            break;
         }
      }

      String var4;
      y.c.c var5;
      label48: {
         var4 = "y.layout.partial.PartialLayouter.ROUTE_EDGE_DPKEY";
         var5 = var1.c(var4);
         var1.a((Object)var4, (y.c.c)var3);
         if(this.S) {
            this.p(var1);
            if(!var6) {
               break label48;
            }
         }

         if(this.v == 0) {
            this.b(var1, var3);
            if(!var6) {
               break label48;
            }
         }

         if(this.v == 1) {
            this.q(var1);
            if(!var6) {
               break label48;
            }
         }

         if(this.v == 2) {
            this.a(var1, var3);
            if(!var6) {
               break label48;
            }
         }

         if(this.v == 3) {
            this.b(var1, (y.c.c)var3);
         }
      }

      var1.d_(var4);
      if(var5 != null) {
         var1.a((Object)var4, (y.c.c)var5);
      }

      var1.a((y.c.h)var3);
   }

   private static boolean a(X var0, y.c.c var1) {
      boolean var15 = d;
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      y.c.e var5 = var0.p();

      while(true) {
         if(var5.f()) {
            y.c.d var6 = var5.a();
            if(var15) {
               break;
            }

            if(var1 == null || var1.d(var6)) {
               ++var2;
               y.d.v var7 = var0.l(var6);
               if(var7.h() == 2) {
                  ++var4;
               }

               byte var8 = 1;
               y.d.s var9 = var7.j();

               int var10000;
               label54: {
                  while(var9.f()) {
                     y.d.m var10 = var9.a();
                     double var11 = Math.abs(var10.j());
                     double var13 = Math.abs(var10.k());
                     double var16;
                     var10000 = (var16 = var11 - 0.001D) == 0.0D?0:(var16 < 0.0D?-1:1);
                     if(var15) {
                        break label54;
                     }

                     if(var10000 > 0 && var13 > 0.001D && Math.abs(var11 - var13) > 0.001D) {
                        var8 = 0;
                        if(!var15) {
                           break;
                        }
                     }

                     var9.g();
                     if(var15) {
                        break;
                     }
                  }

                  var10000 = var8;
               }

               if(var10000 != 0) {
                  ++var3;
               }
            }

            var5.g();
            if(!var15) {
               continue;
            }
         }

         if(var3 == var2 || var3 > var4 && (double)var3 > 0.5D * (double)var2) {
            break;
         }

         return false;
      }

      return true;
   }

   private void a(X var1, y.c.h var2) {
      ah var3;
      label25: {
         var3 = this.R;
         y.c.c var4 = var1.c(a);
         y.c.c var5 = var1.c(b);
         h var6 = new h(this, var4, var5);
         boolean var7 = ae.b(var1, (y.c.c)var6);
         if(var7 || a((X)var1, (y.c.c)var6)) {
            y.f.i.a.y var8 = new y.f.i.a.y();
            var8.a((Object)"y.layout.partial.PartialLayouter.ROUTE_EDGE_DPKEY");
            var8.a(!var7);
            this.R = var8;
            this.b(var1, var2);
            if(!d) {
               break label25;
            }
         }

         i var9 = new i();
         var9.a("y.layout.partial.PartialLayouter.ROUTE_EDGE_DPKEY");
         this.R = var9;
         this.q(var1);
      }

      this.R = var3;
   }

   private void b(X var1, y.c.h var2) {
      y.c.c var3;
      y.c.c var4;
      boolean var10000;
      label45: {
         boolean var12 = d;
         this.c(this.R);
         var3 = var1.c(aF.a);
         var4 = var1.c(aF.b);
         if(this.M) {
            y.c.A var5 = M.a();
            y.c.A var6 = M.a();
            var1.a((Object)aF.a, (y.c.c)var5);
            var1.a((Object)aF.b, (y.c.c)var6);
            y.c.e var7 = var1.p();

            while(var7.f()) {
               y.c.d var8 = var7.a();
               y.f.i.a.x var9 = ((y.f.i.a.y)this.R).c();
               double var10 = var9.a() + var9.b() + 5.0D;
               var10000 = var2.d(var8);
               if(var12) {
                  break label45;
               }

               if(var10000 && a(var8, var1) >= var10) {
                  label51: {
                     if(var1.k(var8.c()) < var1.k(var8.d())) {
                        var5.a(var8, aE.a((byte)2));
                        var6.a(var8, aE.a((byte)1));
                        if(!var12) {
                           break label51;
                        }
                     }

                     var5.a(var8, aE.a((byte)1));
                     var6.a(var8, aE.a((byte)2));
                  }
               }

               var7.g();
               if(var12) {
                  break;
               }
            }
         }

         ((y.f.i.a.y)this.R).a((byte)2);
         this.R.c(var1);
         var10000 = this.M;
      }

      if(var10000) {
         var1.d_(aF.a);
         if(var3 != null) {
            var1.a((Object)aF.a, (y.c.c)var3);
         }

         var1.d_(aF.b);
         if(var4 != null) {
            var1.a((Object)aF.b, (y.c.c)var4);
         }
      }

   }

   private void p(X var1) {
      this.c(this.R);
      this.R.c(var1);
   }

   private void q(X var1) {
      this.c(this.R);
      this.R.c(var1);
   }

   private void b(X var1, y.c.c var2) {
      y.c.c var3 = var1.c(y.f.i.q.a);
      var1.a((Object)y.f.i.q.a, (y.c.c)var2);
      this.c(this.R);
      this.R.c(var1);
      var1.d_(y.f.i.q.a);
      if(var3 != null) {
         var1.a((Object)y.f.i.q.a, (y.c.c)var3);
      }

   }

   protected void c(ah var1) {
      if(!this.S) {
         if(var1 instanceof y.f.i.a.y) {
            y.f.i.a.y var2 = (y.f.i.a.y)var1;
            var2.a(4.0D);
            var2.a(this.v == 4);
            y.f.i.a.x var3 = var2.c();
            var3.a(5.0D);
            var3.a((byte)(this.M?1:0));
         }

      }
   }

   private Rectangle2D c(X var1, y.c.y var2) {
      return ae.a(var1, var2.a());
   }

   private void a(X var1, I var2) {
      boolean var8 = d;
      y.c.c var3 = var1.c(bk.b);
      if(var3 != null) {
         y.c.e var4 = var1.p();

         while(var4.f()) {
            y.c.d var5 = var4.a();
            bh var6 = (bh)var3.b(var5.c());
            bh var7 = (bh)var3.b(var5.d());
            if(var6 != null && var7 != null && !var6.equals(var7)) {
               var2.a(var5);
            }

            var4.g();
            if(var8) {
               break;
            }
         }
      }

   }

   private void b(X param1, I param2) {
      // $FF: Couldn't be decompiled
   }

   private void a(X var1, y.d.t var2) {
      if(this.K != null && var2 != null) {
         y.d.t var3 = var1.l(this.K);
         if(var3.a() != var2.a() || var3.b() != var2.b()) {
            double var4 = -(var3.a() - var2.a());
            double var6 = -(var3.b() - var2.b());
            ae.a(var1, var1.o(), var4, var6);
         }
      }

   }

   private static y.c.y[] a(y.c.i var0, y.c.y var1) {
      boolean var9 = d;
      if(var1 != null && !var1.isEmpty()) {
         y.c.A var2 = var0.t();
         y.a.j.a(var0, var2, false, 1, var0.f(), (y.c.c)null);
         y.c.q[] var3 = var1.e();
         Arrays.sort(var3, y.g.e.b(var2));
         int var4 = var2.a(var3[0]);
         int var5 = 0;
         int var6 = 0;

         int var10000;
         int var10001;
         while(true) {
            if(var6 < var3.length) {
               y.c.q var7 = var3[var6];
               int var8 = var2.a(var7);
               var10000 = var8;
               var10001 = var4;
               if(var9) {
                  break;
               }

               if(var8 != var4) {
                  var4 = var8;
                  ++var5;
               }

               var2.a(var7, var5);
               ++var6;
               if(!var9) {
                  continue;
               }
            }

            var10000 = var5;
            var10001 = 1;
            break;
         }

         y.c.y[] var10 = new y.c.y[var10000 + var10001];
         int var11 = 0;

         while(true) {
            if(var11 < var10.length) {
               var10[var11] = new y.c.y();
               ++var11;
               if(var9) {
                  break;
               }

               if(!var9) {
                  continue;
               }
            }

            var11 = 0;
            break;
         }

         while(true) {
            if(var11 < var3.length) {
               y.c.q var12 = var3[var11];
               var10[var2.a(var12)].add(var12);
               ++var11;
               if(var9) {
                  break;
               }

               if(!var9) {
                  continue;
               }
            }

            var0.a(var2);
            break;
         }

         return var10;
      } else {
         return new y.c.y[0];
      }
   }

   static y.f.b.c a(d var0) {
      return var0.J;
   }
}
