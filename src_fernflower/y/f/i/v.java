package y.f.i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import y.f.i.A;
import y.f.i.B;
import y.f.i.C;
import y.f.i.D;
import y.f.i.E;
import y.f.i.a;
import y.f.i.aF;
import y.f.i.aI;
import y.f.i.aJ;
import y.f.i.aK;
import y.f.i.aQ;
import y.f.i.ad;
import y.f.i.ae;
import y.f.i.af;
import y.f.i.al;
import y.f.i.am;
import y.f.i.ao;
import y.f.i.ap;
import y.f.i.ar;
import y.f.i.av;
import y.f.i.g;
import y.f.i.i;
import y.f.i.w;
import y.f.i.x;
import y.f.i.y;
import y.f.i.z;

public class v extends y.f.a {
   private y.f.X g;
   private byte h;
   private boolean i;
   private y.d.t n;
   private int o;
   private int p;
   private double q;
   private double r;
   private y.c.i s;
   private y.c.f t;
   private y.c.q u;
   private y.c.q v;
   private y.c.d w;
   private boolean x;
   private y.c.c y;
   private y.c.c z;
   private y.g.N A;
   private aF B;
   private y.c.A C;
   private y.c.A D;
   private y.c.h E;
   private y.c.A F;
   private boolean G;
   private boolean H;
   private int I;
   private int J;
   private int K;
   private int L;
   private int M;
   private int N;
   private int O;
   private y.g.al P;
   private y.g.al Q;
   private y.g.al R;
   private y.g.al S;
   private y.g.al T;
   private y.g.al U;
   private y.g.al V;
   private y.g.al W;
   private y.c.h X;
   private y.c.h Y;
   private y.c.A Z;
   private boolean aa;
   private boolean ab;
   private boolean ac;
   private int ad;
   private boolean ae;
   private int af;
   private boolean ag;
   private boolean ah;
   private boolean ai;
   private double aj;
   private byte ak;
   private boolean al;
   private boolean am;
   private boolean an;
   private boolean ao;
   private y.c.f ap;
   private HashMap aq;
   private byte ar;
   private boolean as;
   private boolean at;
   private boolean au;
   Object a;
   Object b;
   private boolean av;
   private boolean aw;
   Map c;
   private y.c.h ax;
   private y.c.h ay;
   private int az;
   private double aA;
   private double aB;
   private double aC;
   private double aD;
   private double aE;
   private int aF;
   private boolean aG;
   aQ d;
   y.c.A e;
   private y.c.A aH;
   private y.c.A aI;
   private y.g.P aJ;
   private y.g.N aK;
   private y.g.N aL;
   private y.g.N aM;
   private y.c.d[] aN;
   private boolean aO;
   private boolean aP;
   private boolean aQ;
   private boolean aR;
   private boolean aS;
   private boolean aT;
   public static int f;

   public Object b() {
      return this.b;
   }

   public Object c() {
      return this.a;
   }

   public void a(Object var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("null");
      } else {
         this.a = var1;
      }
   }

   public void a(boolean var1) {
      this.at = var1;
   }

   public boolean d() {
      return this.at;
   }

   public byte e() {
      return this.ar;
   }

   public void a(byte var1) {
      this.ar = var1;
   }

   public boolean f() {
      return this.as;
   }

   public void b(boolean var1) {
      this.as = var1;
   }

   private boolean D() {
      return this.ar == 1 || this.ar == 3;
   }

   private boolean E() {
      return this.ar == 2 || this.ar == 3;
   }

   private boolean F() {
      return this.ar != 0;
   }

   public v() {
      this((y.f.ah)null);
   }

   public v(y.f.ah var1) {
      this.aq = new HashMap();
      this.ar = 0;
      this.as = false;
      this.at = false;
      this.a = y.f.ah.h_;
      this.b = y.f.ah.g_;
      this.aE = 0.0D;
      this.aF = 0;
      this.aG = false;
      this.aQ = false;
      this.aR = false;
      this.aS = true;
      this.aT = true;
      super.a(var1);
      this.av = true;
      this.au = true;
      this.aw = false;
      this.c((byte)3);
      this.am = true;
      this.h = 0;
      this.i = false;
      this.n = new y.d.t(0.0D, 0.0D);
      this.o = 2;
      this.p = this.o;
      this.q = 2.0D;
      this.r = this.q;
      this.aa = true;
      this.aO = true;
      this.ag = true;
      this.ah = true;
      this.ai = true;
      this.aj = 0.5D;
      this.G = false;
      this.H = false;
      this.an = true;
      this.ab = true;
      this.aP = false;
   }

   public void c(y.f.X var1) {
      int var12 = f;
      boolean var2 = false;
      if(var1.c("y.layout.router.ORTHOGONAL_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY") == null) {
         this.b(var1);
         var1.a((Object)"y.layout.router.ORTHOGONAL_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY", (y.c.c)y.g.q.a((Object)Boolean.TRUE));
         var2 = true;
      }

      Object var3;
      y.c.c var4;
      if(this.h == 2) {
         var3 = this.c();
         var4 = var1.c(var3);
         if(var4 == null) {
            throw new IllegalStateException("No DataProvider " + var3 + " registered with graph!");
         }
      } else if(this.h == 4) {
         var3 = this.b();
         var4 = var1.c(var3);
         if(var4 == null) {
            throw new IllegalStateException("No DataProvider " + var3 + " registered with graph!");
         }
      }

      y.f.ah var13 = this.a();
      if(var13 != null) {
         var13.c(var1);
      }

      if(var1.h() > 0) {
         ar var14 = new ar(var1, this);
         var14.b();
         var14.d();
         this.P = new y.g.al();
         this.g = var1;
         this.ap = new y.c.f();
         this.ay = var1.u();
         this.az = 0;
         B var5 = new B(var1, (w)null);
         if(this.d()) {
            var5.a();
         }

         this.Z = y.g.M.a();
         this.g();
         this.i();
         this.X = y.g.M.b();
         this.Y = y.g.M.b();
         y.c.h var6 = y.g.M.b();
         y.c.e var7 = this.t.a();

         label116: {
            while(var7.f()) {
               var6.a(var7.a(), true);
               var7.g();
               if(var12 != 0) {
                  break label116;
               }

               if(var12 != 0) {
                  break;
               }
            }

            var7 = var1.p();
         }

         boolean var10000;
         label152: {
            while(true) {
               if(var7.f()) {
                  y.c.d var8 = var7.a();
                  var10000 = var6.d(var8);
                  if(var12 != 0) {
                     break;
                  }

                  if(!var10000) {
                     this.a(var8, var1);
                  }

                  var7.g();
                  if(var12 == 0) {
                     continue;
                  }

                  this.K();
               } else {
                  this.K();
               }

               var10000 = this.ap.isEmpty();
               break;
            }

            while(!var10000) {
               y.c.d var15 = this.ap.d();
               this.b(var15);
               if(var12 != 0) {
                  break label152;
               }

               if(var12 != 0) {
                  break;
               }

               var10000 = this.ap.isEmpty();
            }

            this.N = this.s.e();
            this.O = this.s.g();
         }

         if(this.aO) {
            this.j();
         }

         if(this.aG && this.m()) {
            this.n();
            if(this.aO) {
               this.j();
            }
         }

         label103: {
            label102: {
               if(this.az > 0 && this.i) {
                  v var16 = this.e(this);
                  var16.d(false);
                  var16.b((byte)2);
                  Object var17 = this.c();
                  y.c.c var9 = var1.c(var17);
                  var1.a((Object)var17, (y.c.c)this.ay);
                  var16.c(var1);
                  var1.d_(var17);
                  if(var9 == null) {
                     break label102;
                  }

                  var1.a((Object)var17, (y.c.c)var9);
                  if(var12 == 0) {
                     break label102;
                  }
               }

               if(this.az > 0 && this.ab) {
                  a var18 = new a();
                  y.c.c var19 = var1.c("edge2RoutedByChannelEdgeRouter");
                  if(var19 != null) {
                     y.c.e var20 = var1.p();

                     while(var20.f()) {
                        y.c.d var10 = var20.a();
                        var10000 = var19.b(var10) instanceof y.g.b;
                        if(var12 != 0) {
                           break label103;
                        }

                        if(var10000) {
                           y.g.b var11 = (y.g.b)var19.b(var10);
                           var11.a(this.ay.d(var10));
                        }

                        var20.g();
                        if(var12 != 0) {
                           break;
                        }
                     }
                  }

                  var1.a((Object)a.a, (y.c.c)this.ay);
                  E var21 = new E();
                  var21.a(a.a);
                  var21.a(this.e());
                  var18.b((y.f.ah)var21);
                  var18.c(var1);
                  var1.d_(a.a);
               }
            }

            this.h();
            var10000 = this.d();
         }

         if(var10000) {
            var5.b();
         }

         var1.a((y.c.h)this.ay);
         this.s = null;
         this.t = null;
         this.z = null;
         this.y = null;
         this.A = null;
         this.B = null;
         this.C = null;
         this.D = null;
         this.E = null;
         this.F = null;
         this.P.b();
         if(this.G) {
            System.out.print(this.S());
         }

         var14.e();
      }

      if(var2) {
         var1.d_("y.layout.router.ORTHOGONAL_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY");
      }

   }

   private v e(v var1) {
      v var2 = new v();
      var2.a((y.f.ah)var1.a());
      var2.a(var1.d());
      var2.d(var1.v());
      var2.g(var1.z());
      var2.b(var1.x());
      var2.e(var1.u());
      var2.a(var1.k());
      var2.e(var1.B());
      var2.h(var1.A());
      var2.b(var1.f());
      var2.a((int)var1.r().a, (int)var1.r().b);
      var2.d(var1.q());
      var2.b(var1.s());
      var2.i(var1.C());
      var2.f(var1.w());
      var2.c(var1.t());
      var2.d(var1.v());
      var2.a(var1.e());
      var2.c(var1.l());
      var2.c(var1.y());
      var2.b(var1.p());
      var2.a(var1.c());
      return var2;
   }

   private void b(y.f.X var1) {
      this.a((y.c.n)var1, (y.f.O)var1);
   }

   private void a(y.c.n var1, y.f.O var2) {
      int var6 = f;
      y.c.c var3 = var1.c(y.f.b.f.d);
      if(var3 == null) {
         var3 = y.g.q.a((Object)Boolean.FALSE);
      }

      Iterator var4 = var1.x();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         if(!var3.d(var5)) {
            this.a(var2, var5);
            if(var6 == 0) {
               continue;
            }
         }

         this.b(var2, var5);
         if(var6 != 0) {
            break;
         }
      }

   }

   protected void a(y.f.O var1, Object var2) {
      y.f.am var3 = var1.a(var2);
      if(var3.getWidth() == 0.0D || var3.getHeight() == 0.0D) {
         throw new IllegalArgumentException("Graph contains nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
      }
   }

   protected void b(y.f.O var1, Object var2) {
      y.f.am var3 = var1.a(var2);
      if(var3.getWidth() == 0.0D || var3.getHeight() == 0.0D) {
         throw new IllegalArgumentException("Graph contains group nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
      }
   }

   void g() {
      int var2 = f;
      this.D = this.g.t();
      this.E = this.g.u();
      this.ax = this.g.u();
      y.c.e var1 = this.g.p();

      while(var1.f()) {
         this.E.a(var1.a(), new ae(var1.a()));
         var1.g();
         if(var2 != 0) {
            break;
         }
      }

   }

   void h() {
      this.g.a((y.c.A)this.D);
      this.g.a((y.c.h)this.E);
      this.g.a((y.c.h)this.ax);
   }

   void i() {
      this.aF = 0;
      this.R();
      this.L();
      this.G();
      if(this.aa) {
         this.F = this.s.t();
      }

      this.S = new y.g.al();
      this.N();
      this.S.b();
      if(this.ac) {
         this.c((double)this.ad);
         if(f == 0) {
            return;
         }
      }

      if(this.i) {
         this.c(0.5D * (double)this.o);
      }

   }

   private void G() {
      int var5 = f;
      this.c = new HashMap();
      y.c.x var1 = this.g.o();

      while(var1.f()) {
         label79: {
            y.c.q var2 = var1.e();
            aJ var3 = (aJ)this.z.b(var2);
            y.c.C var4;
            if(this.c(var2)) {
               this.a(var3.a);
               this.a(var3.c);
               var4 = var3.a.m();

               label61: {
                  while(var4.f()) {
                     this.c.put(var4.d(), var2);
                     var4.g();
                     if(var5 != 0) {
                        break label61;
                     }

                     if(var5 != 0) {
                        break;
                     }
                  }

                  var4 = var3.c.m();
               }

               while(var4.f()) {
                  this.c.put(var4.d(), var2);
                  var4.g();
                  if(var5 != 0) {
                     break label79;
                  }

                  if(var5 != 0) {
                     break;
                  }
               }
            }

            if(this.d(var2)) {
               this.a(var3.g);
               this.a(var3.e);
               var4 = var3.g.m();

               label40: {
                  while(var4.f()) {
                     this.c.put(var4.d(), var2);
                     var4.g();
                     if(var5 != 0) {
                        break label40;
                     }

                     if(var5 != 0) {
                        break;
                     }
                  }

                  var4 = var3.e.m();
               }

               while(var4.f()) {
                  this.c.put(var4.d(), var2);
                  var4.g();
                  if(var5 != 0) {
                     break label79;
                  }

                  if(var5 != 0) {
                     break;
                  }
               }
            }

            var1.g();
         }

         if(var5 != 0) {
            break;
         }
      }

   }

   private void a(y.c.D var1) {
      int var4 = f;
      y.c.C var2 = var1.m();

      while(var2.f()) {
         ao var3 = (ao)var2.d();
         var3.n = true;
         var2.g();
         if(var4 != 0) {
            break;
         }
      }

   }

   private boolean a(y.c.d var1, boolean var2) {
      int var8 = f;
      ae var3 = (ae)this.E.b(var1);
      boolean var4 = !var3.a(var2) || this.g.k(var1).isEmpty();
      if(!var4) {
         return false;
      } else if(var3.b(var2)) {
         return true;
      } else {
         Collection var5 = var3.c(var2);
         boolean var10000;
         if(var5 != null && !var5.isEmpty()) {
            Iterator var6 = var5.iterator();

            while(var6.hasNext()) {
               y.f.ax var7 = (y.f.ax)var6.next();
               if(var7.b()) {
                  var10000 = true;
                  if(var8 == 0) {
                     return true;
                  }

                  return var10000;
               }
            }
         }

         var10000 = false;
         return var10000;
      }
   }

   void j() {
      int var9 = f;
      aK var1 = new aK();
      var1.n = this.c();
      var1.i = this.b();
      var1.h = this.h;
      var1.a = this.aQ;
      var1.b = this.ag;
      var1.c = this.i;
      var1.d = this.n;
      var1.e = this.o;
      var1.f = this.p;
      var1.g = this.q;
      w var2 = new w(this);
      x var3 = new x(this);
      y.c.c var4 = this.g.c(y.f.aF.a);
      y.c.c var5 = this.g.c(y.f.aF.b);
      this.g.a((Object)y.f.aF.a, (y.c.c)var2);
      this.g.a((Object)y.f.aF.b, (y.c.c)var3);
      y.g.I var6 = new y.g.I(this.g);
      y.c.e var7 = this.g.p();

      while(var7.f()) {
         if(this.ax.d(var7.a())) {
            var6.a(var7.a());
         }

         var7.g();
         if(var9 != 0) {
            y.c.i.g = !y.c.i.g;
            break;
         }
      }

      g var10 = new g(var1);
      y.c.h var8 = y.g.M.b(new boolean[this.g.g()]);
      this.a(var8);
      this.g.a((Object)g.a, (y.c.c)y.g.q.a((y.c.c)var8));
      var10.c(this.g);
      this.g.d_(g.a);
      var6.f();
      this.g.d_(y.f.aF.a);
      this.g.d_(y.f.aF.b);
      if(var4 != null) {
         this.g.a((Object)y.f.aF.a, (y.c.c)var4);
      }

      if(var5 != null) {
         this.g.a((Object)y.f.aF.b, (y.c.c)var5);
      }

   }

   public boolean a(String var1, Object var2) {
      int var4 = f;
      boolean var3 = false;
      if("CD".equals(var1)) {
         if(!(var2 instanceof Boolean)) {
            return var3;
         }

         this.ah = ((Boolean)var2).booleanValue();
         var3 = true;
         if(var4 == 0) {
            return var3;
         }
      }

      if("SD".equals(var1)) {
         if(!(var2 instanceof Boolean)) {
            return var3;
         }

         this.ai = ((Boolean)var2).booleanValue();
         var3 = true;
         if(var4 == 0) {
            return var3;
         }
      }

      if("AMD".equals(var1)) {
         if(!(var2 instanceof Boolean)) {
            return var3;
         }

         this.aa = ((Boolean)var2).booleanValue();
         var3 = true;
         if(var4 == 0) {
            return var3;
         }
      }

      if("Stats".equals(var1)) {
         if(!(var2 instanceof Boolean)) {
            return var3;
         }

         this.G = ((Boolean)var2).booleanValue();
         var3 = true;
         if(var4 == 0) {
            return var3;
         }
      }

      if("swStats".equals(var1)) {
         if(!(var2 instanceof Boolean)) {
            return var3;
         }

         this.H = ((Boolean)var2).booleanValue();
         var3 = true;
         if(var4 == 0) {
            return var3;
         }
      }

      if("addS".equals(var1)) {
         if(!(var2 instanceof Boolean)) {
            return var3;
         }

         this.aQ = ((Boolean)var2).booleanValue();
         var3 = true;
         if(var4 == 0) {
            return var3;
         }
      }

      if("smallSPR".equals(var1)) {
         if(!(var2 instanceof Boolean)) {
            return var3;
         }

         this.aS = ((Boolean)var2).booleanValue();
         var3 = true;
         if(var4 == 0) {
            return var3;
         }
      }

      if("lessSPR".equals(var1)) {
         if(!(var2 instanceof Boolean)) {
            return var3;
         }

         this.aT = ((Boolean)var2).booleanValue();
         var3 = true;
         if(var4 == 0) {
            return var3;
         }
      }

      if("TT".equals(var1)) {
         if(!(var2 instanceof Boolean)) {
            return var3;
         }

         this.ag = ((Boolean)var2).booleanValue();
         var3 = true;
         if(var4 == 0) {
            return var3;
         }
      }

      if("routingPreferMiddleOfNode".equals(var1)) {
         if(!(var2 instanceof Boolean)) {
            return var3;
         }

         this.am = ((Boolean)var2).booleanValue();
         var3 = true;
         if(var4 == 0) {
            return var3;
         }
      }

      if("AllowRigModification".equalsIgnoreCase(var1)) {
         if(!(var2 instanceof Boolean)) {
            return var3;
         }

         this.av = ((Boolean)var2).booleanValue();
         var3 = true;
         if(var4 == 0) {
            return var3;
         }
      }

      if("IgnoreUnselectedEdges".equalsIgnoreCase(var1)) {
         if(!(var2 instanceof Boolean)) {
            return var3;
         }

         this.aw = ((Boolean)var2).booleanValue();
         var3 = true;
         if(var4 == 0) {
            return var3;
         }
      }

      if("ObserveOccupiedPorts".equalsIgnoreCase(var1) && var2 instanceof Boolean) {
         this.au = ((Boolean)var2).booleanValue();
         var3 = true;
      }

      return var3;
   }

   private void c(double var1) {
      int var8 = f;
      y.c.x var6 = this.g.o();

      while(var6.f()) {
         y.c.q var7 = var6.e();
         if(!this.b(var7)) {
            ap var5 = new ap(this.g.l(var7), this.C);
            aJ var3 = (aJ)this.z.b(var7);
            ao var4 = this.b(var3.a);
            if(var4 != null) {
               this.a(var7, var4, var5, var1);
            }

            var4 = this.b(var3.c);
            if(var4 != null) {
               this.a(var7, var4, var5, var1);
            }

            var4 = this.b(var3.e);
            if(var4 != null) {
               this.a(var7, var4, var5, var1);
            }

            var4 = this.b(var3.g);
            if(var4 != null) {
               this.a(var7, var4, var5, var1);
            }
         }

         var6.g();
         if(var8 != 0) {
            break;
         }
      }

   }

   private void a(y.c.q var1, ao var2, ap var3, double var4) {
      int var26 = f;
      y.c.q var10 = (y.c.q)this.B.b(var2);
      var3.a(var10);
      y.c.f var11 = new y.c.f(var10.j());
      var11.sort(var3);
      boolean var6;
      boolean var7;
      double var8;
      y.c.e var12;
      y.c.d var13;
      ao var14;
      boolean var15;
      boolean var16;
      double[] var17;
      double[] var18;
      al var19;
      boolean var20;
      boolean var21;
      double var22;
      boolean var24;
      boolean var25;
      double var27;
      if(var2.x()) {
         label494: {
            var7 = var2.s() < this.g.l(var1).b;
            if(var7) {
               var8 = this.g.n(var1) - var4;
               if(var26 == 0) {
                  break label494;
               }
            }

            var8 = this.g.n(var1) + this.g.q(var1) + var4;
         }

         var6 = false;
         var12 = var11.a();

         do {
            if(!var12.f() || var6) {
               return;
            }

            var13 = var12.a();
            var14 = (ao)this.C.b(var13.a(var10));
            if(var14 != null) {
               label528: {
                  label503: {
                     var15 = false;
                     if(var7) {
                        var15 = var14.u() <= var8;
                        if(var26 == 0) {
                           break label503;
                        }
                     }

                     var15 = var14.t() >= var8;
                  }

                  if(var15) {
                     return;
                  }

                  label504: {
                     if(var7) {
                        var16 = var14.t() >= var8;
                        if(var26 == 0) {
                           break label504;
                        }
                     }

                     var16 = var14.u() <= var8;
                  }

                  var17 = new double[4];
                  var18 = new double[4];
                  var17[0] = var14.k.a;
                  var17[1] = this.g.m(var1);
                  var17[2] = this.g.m(var1) + this.g.p(var1);
                  var17[3] = var14.l.a;
                  var18[0] = var14.k.b;
                  var18[1] = var14.k.b;
                  var18[2] = var14.l.b;
                  var18[3] = var14.l.b;
                  if(var16) {
                     var20 = false;
                     var21 = false;
                     if(var14.k.a < this.g.m(var1) && var14.l.a > this.g.m(var1)) {
                        var20 = true;
                     }

                     if(var14.l.a > this.g.m(var1) + this.g.p(var1) && var14.k.a < this.g.m(var1) + this.g.p(var1)) {
                        var21 = true;
                     }

                     if(this.aT) {
                        if(var20 && var21) {
                           var19 = (al)this.a(var14, var17, var18, var14.x());
                           this.a((ao)var14, (byte)8);
                           var14.k = new y.d.t(this.g.m(var1) + this.g.p(var1), var14.k.b);
                           if(var26 == 0) {
                              break label528;
                           }
                        }

                        if(var20) {
                           var14.l = new y.d.t(this.g.m(var1), var14.l.b);
                           this.a((ao)var14, (byte)4);
                           if(var26 == 0) {
                              break label528;
                           }
                        }

                        if(var21) {
                           var14.k = new y.d.t(this.g.m(var1) + this.g.p(var1), var14.k.b);
                           this.a((ao)var14, (byte)8);
                           if(var26 == 0) {
                              break label528;
                           }
                        }

                        if(this.aS) {
                           var14.k = new y.d.t(this.g.m(var1), var14.k.b);
                           var14.l = new y.d.t(this.g.m(var1) + this.g.p(var1), var14.k.b);
                           if(var26 == 0) {
                              break label528;
                           }
                        }

                        var14.l = new y.d.t(var14.l.a, var14.k.b);
                        if(var26 == 0) {
                           break label528;
                        }
                     }

                     if(var20) {
                        label465: {
                           var19 = new al(var14.k.a, var14.k.b, this.g.m(var1), var14.l.b, var14.x());
                           if(!var21) {
                              this.c(var14, var19);
                              if(var26 == 0) {
                                 break label465;
                              }
                           }

                           this.b((ao)var14, var19, (byte)8);
                        }

                        this.a(var14, var19, var14.x(), true);
                        this.a((ao)var14, (ao)var19);
                     }

                     if(var21) {
                        label456: {
                           var19 = new al(this.g.m(var1) + this.g.p(var1), var14.k.b, var14.l.a, var14.l.b, var14.x());
                           if(!var20) {
                              this.c(var14, var19);
                              if(var26 == 0) {
                                 break label456;
                              }
                           }

                           this.b((ao)var14, var19, (byte)4);
                        }

                        this.a(var14, var19, var14.x(), false);
                        this.a((ao)var14, (ao)var19);
                     }

                     if(this.aS) {
                        var14.k = new y.d.t(this.g.m(var1), var14.k.b);
                        var14.l = new y.d.t(this.g.m(var1) + this.g.p(var1), var14.k.b);
                        if(var26 == 0) {
                           break label528;
                        }
                     }

                     var14.l = new y.d.t(var14.l.a, var14.k.b);
                     if(var26 == 0) {
                        break label528;
                     }
                  }

                  label509: {
                     var27 = 0.0D;
                     var22 = 0.0D;
                     if(this.aT) {
                        if(var7) {
                           var18[1] = var8;
                           var18[2] = var14.l.b;
                           if(var26 == 0) {
                              break label509;
                           }
                        }

                        var18[1] = var14.k.b;
                        var18[2] = var8;
                        if(var26 == 0) {
                           break label509;
                        }
                     }

                     if(var7) {
                        var27 = var8;
                        var22 = var14.l.b;
                        if(var26 == 0) {
                           break label509;
                        }
                     }

                     var27 = var14.k.b;
                     var22 = var8;
                  }

                  var24 = false;
                  var25 = false;
                  if(var14.k.a < this.g.m(var1) && var14.l.a > this.g.m(var1)) {
                     var24 = true;
                  }

                  if(var14.l.a > this.g.m(var1) + this.g.p(var1) && var14.k.a < this.g.m(var1) + this.g.p(var1)) {
                     var25 = true;
                  }

                  label556: {
                     if(this.aT) {
                        if(var24 && var25) {
                           var19 = (al)this.a(var14, var17, var18, var14.x());
                           var19 = (al)this.b(var14, var17, var18, var14.x());
                           if(var26 == 0) {
                              break label556;
                           }
                        }

                        if(var24) {
                           var19 = (al)this.a(var14, var17, var18, var14.x());
                           if(var26 == 0) {
                              break label556;
                           }
                        }

                        if(!var25) {
                           break label556;
                        }

                        var19 = (al)this.b(var14, var17, var18, var14.x());
                        if(var26 == 0) {
                           break label556;
                        }
                     }

                     if(var24) {
                        label418: {
                           var19 = new al(var14.k.a, var27, this.g.m(var1), var22, var14.x());
                           if(!var25) {
                              this.c(var14, var19);
                              if(var26 == 0) {
                                 break label418;
                              }
                           }

                           this.b((ao)var14, var19, (byte)8);
                        }

                        this.a(var14, var19, var14.x(), true);
                        this.a((ao)var14, (ao)var19);
                     }

                     if(var25) {
                        label410: {
                           var19 = new al(this.g.m(var1) + this.g.p(var1), var27, var14.l.a, var22, var14.x());
                           if(!var24) {
                              this.c(var14, var19);
                              if(var26 == 0) {
                                 break label410;
                              }
                           }

                           this.b((ao)var14, var19, (byte)4);
                        }

                        this.a(var14, var19, var14.x(), false);
                        this.a((ao)var14, (ao)var19);
                     }
                  }

                  label513: {
                     if(this.aT) {
                        if(var7) {
                           var14.l = new y.d.t(var14.l.a, var8);
                           if(var26 == 0) {
                              break label513;
                           }
                        }

                        var14.k = new y.d.t(var14.k.a, var8);
                        if(var26 == 0) {
                           break label513;
                        }
                     }

                     if(var7) {
                        var14.l = new y.d.t(var14.l.a, var27);
                        if(var26 == 0) {
                           break label513;
                        }
                     }

                     var14.k = new y.d.t(var14.k.a, var22);
                  }

                  var6 = true;
               }
            }

            this.a(var13.a(var10));
            var12.g();
         } while(var26 == 0);
      }

      label362: {
         var7 = var2.r() < this.g.l(var1).a;
         if(var7) {
            var8 = this.g.m(var1) - var4;
            if(var26 == 0) {
               break label362;
            }
         }

         var8 = this.g.m(var1) + this.g.p(var1) + var4;
      }

      var6 = false;
      var12 = var11.a();

      while(var12.f() && !var6) {
         var13 = var12.a();
         var14 = (ao)this.C.b(var13.a(var10));
         if(var14 != null) {
            label542: {
               label515: {
                  var15 = false;
                  if(var7) {
                     var15 = var14.u() <= var8;
                     if(var26 == 0) {
                        break label515;
                     }
                  }

                  var15 = var14.t() >= var8;
               }

               if(var15) {
                  break;
               }

               label516: {
                  if(var7) {
                     var16 = var14.t() >= var8;
                     if(var26 == 0) {
                        break label516;
                     }
                  }

                  var16 = var14.u() <= var8;
               }

               var17 = new double[4];
               var18 = new double[4];
               var17[0] = var14.k.a;
               var17[1] = var14.k.a;
               var17[2] = var14.l.a;
               var17[3] = var14.l.a;
               var18[0] = var14.k.b;
               var18[1] = this.g.n(var1);
               var18[2] = this.g.n(var1) + this.g.q(var1);
               var18[3] = var14.l.b;
               if(var16) {
                  var20 = false;
                  var21 = false;
                  if(var14.k.b < this.g.n(var1) && var14.l.b > this.g.n(var1)) {
                     var20 = true;
                  }

                  if(var14.l.b > this.g.n(var1) + this.g.q(var1) && var14.k.b < this.g.n(var1) + this.g.q(var1)) {
                     var21 = true;
                  }

                  if(this.aT) {
                     if(var20 && var21) {
                        var19 = (al)this.a(var14, var17, var18, var14.x());
                        this.a((ao)var14, (byte)1);
                        var14.k = new y.d.t(var14.k.a, this.g.n(var1) + this.g.q(var1));
                        if(var26 == 0) {
                           break label542;
                        }
                     }

                     if(var20) {
                        var14.l = new y.d.t(var14.l.a, this.g.n(var1));
                        this.a((ao)var14, (byte)2);
                        if(var26 == 0) {
                           break label542;
                        }
                     }

                     if(var21) {
                        var14.k = new y.d.t(var14.k.a, this.g.n(var1) + this.g.q(var1));
                        this.a((ao)var14, (byte)1);
                        if(var26 == 0) {
                           break label542;
                        }
                     }

                     if(this.aS) {
                        var14.k = new y.d.t(var14.k.a, this.g.n(var1));
                        var14.l = new y.d.t(var14.k.a, this.g.n(var1) + this.g.q(var1));
                        if(var26 == 0) {
                           break label542;
                        }
                     }

                     var14.l = new y.d.t(var14.k.a, var14.l.b);
                     if(var26 == 0) {
                        break label542;
                     }
                  }

                  if(var20) {
                     label333: {
                        var19 = new al(var14.k.a, var14.k.b, var14.l.a, this.g.n(var1), var14.x());
                        if(!var21) {
                           this.c(var14, var19);
                           if(var26 == 0) {
                              break label333;
                           }
                        }

                        this.b((ao)var14, var19, (byte)1);
                     }

                     this.a(var14, var19, var14.x(), true);
                     this.a((ao)var14, (ao)var19);
                  }

                  if(var21) {
                     label324: {
                        var19 = new al(var14.k.a, this.g.n(var1) + this.g.q(var1), var14.l.a, var14.l.b, var14.x());
                        if(!var20) {
                           this.c(var14, var19);
                           if(var26 == 0) {
                              break label324;
                           }
                        }

                        this.b((ao)var14, var19, (byte)2);
                     }

                     this.a(var14, var19, var14.x(), false);
                     this.a((ao)var14, (ao)var19);
                  }

                  if(this.aS) {
                     var14.k = new y.d.t(var14.k.a, this.g.n(var1));
                     var14.l = new y.d.t(var14.k.a, this.g.n(var1) + this.g.q(var1));
                     if(var26 == 0) {
                        break label542;
                     }
                  }

                  var14.l = new y.d.t(var14.k.a, var14.l.b);
                  if(var26 == 0) {
                     break label542;
                  }
               }

               label521: {
                  var27 = 0.0D;
                  var22 = 0.0D;
                  if(this.aT) {
                     if(var7) {
                        var17[1] = var8;
                        var17[2] = var14.l.a;
                        if(var26 == 0) {
                           break label521;
                        }
                     }

                     var17[1] = var14.k.a;
                     var17[2] = var8;
                     if(var26 == 0) {
                        break label521;
                     }
                  }

                  if(var7) {
                     var27 = var8;
                     var22 = var14.l.a;
                     if(var26 == 0) {
                        break label521;
                     }
                  }

                  var27 = var14.k.a;
                  var22 = var8;
               }

               var24 = false;
               var25 = false;
               if(var14.k.b < this.g.n(var1) && var14.l.b > this.g.n(var1)) {
                  var24 = true;
               }

               if(var14.l.b > this.g.n(var1) + this.g.q(var1) && var14.k.b < this.g.n(var1) + this.g.q(var1)) {
                  var25 = true;
               }

               label559: {
                  if(this.aT) {
                     if(var24 && var25) {
                        var19 = (al)this.a(var14, var17, var18, var14.x());
                        var19 = (al)this.b(var14, var17, var18, var14.x());
                        if(var26 == 0) {
                           break label559;
                        }
                     }

                     if(var24) {
                        var19 = (al)this.a(var14, var17, var18, var14.x());
                        if(var26 == 0) {
                           break label559;
                        }
                     }

                     if(!var25) {
                        break label559;
                     }

                     var19 = (al)this.b(var14, var17, var18, var14.x());
                     if(var26 == 0) {
                        break label559;
                     }
                  }

                  if(var24) {
                     label286: {
                        var19 = new al(var27, var14.k.b, var22, this.g.n(var1), var14.x());
                        if(!var25) {
                           this.c(var14, var19);
                           if(var26 == 0) {
                              break label286;
                           }
                        }

                        this.b((ao)var14, var19, (byte)1);
                     }

                     this.a(var14, var19, var14.x(), true);
                     this.a((ao)var14, (ao)var19);
                  }

                  if(var25) {
                     label278: {
                        var19 = new al(var27, this.g.n(var1) + this.g.q(var1), var22, var14.l.b, var14.x());
                        if(!var24) {
                           this.c(var14, var19);
                           if(var26 == 0) {
                              break label278;
                           }
                        }

                        this.b((ao)var14, var19, (byte)2);
                     }

                     this.a(var14, var19, var14.x(), false);
                     this.a((ao)var14, (ao)var19);
                  }
               }

               label525: {
                  if(this.aT) {
                     if(var7) {
                        var14.l = new y.d.t(var8, var14.l.b);
                        if(var26 == 0) {
                           break label525;
                        }
                     }

                     var14.k = new y.d.t(var8, var14.k.b);
                     if(var26 == 0) {
                        break label525;
                     }
                  }

                  if(var7) {
                     var14.l = new y.d.t(var27, var14.l.b);
                     if(var26 == 0) {
                        break label525;
                     }
                  }

                  var14.k = new y.d.t(var22, var14.k.b);
               }

               var6 = true;
            }
         }

         this.a(var13.a(var10));
         var12.g();
         if(var26 != 0) {
            break;
         }
      }

   }

   private void a(y.c.D var1, ao var2) {
      int var4 = f;
      y.c.C var3 = var1.m();

      while(var3.f()) {
         if(var3.d() == var2) {
            var1.b(var3);
         }

         var3.g();
         if(var4 != 0) {
            break;
         }
      }

   }

   private void a(y.c.D var1, ao var2, byte var3) {
      int var6 = f;
      y.c.C var4 = var1.m();

      while(var4.f()) {
         aJ var5 = (aJ)this.z.b((y.c.q)var4.d());
         switch(var3) {
         case 1:
            this.a(var5.a, var2);
            if(var6 == 0) {
               break;
            }
         case 10:
            this.a(var5.b, var2);
            if(var6 == 0) {
               break;
            }
         case 2:
            this.a(var5.c, var2);
            if(var6 == 0) {
               break;
            }
         case 20:
            this.a(var5.d, var2);
            if(var6 == 0) {
               break;
            }
         case 8:
            this.a(var5.e, var2);
            if(var6 == 0) {
               break;
            }
         case 80:
            this.a(var5.f, var2);
            if(var6 == 0) {
               break;
            }
         case 4:
            this.a(var5.g, var2);
            if(var6 == 0) {
               break;
            }
         case 40:
            this.a(var5.h, var2);
         }

         var4.g();
         if(var6 != 0) {
            break;
         }
      }

   }

   private void a(ao var1, byte var2) {
      int var4 = f;
      aJ var3 = (aJ)this.y.b(var1);
      if(var3 != null) {
         switch(var2) {
         case 1:
            this.a((y.c.D)var3.a, var1, (byte)2);
            var3.a.clear();
            this.a((y.c.D)var3.b, var1, (byte)20);
            var3.b.clear();
            if(var4 == 0) {
               break;
            }
         case 2:
            this.a((y.c.D)var3.c, var1, (byte)1);
            var3.c.clear();
            this.a((y.c.D)var3.d, var1, (byte)10);
            var3.d.clear();
            if(var4 == 0) {
               break;
            }
         case 8:
            this.a((y.c.D)var3.e, var1, (byte)4);
            var3.e.clear();
            this.a((y.c.D)var3.f, var1, (byte)40);
            var3.f.clear();
            if(var4 == 0) {
               break;
            }
         case 4:
            this.a((y.c.D)var3.g, var1, (byte)8);
            var3.g.clear();
            this.a((y.c.D)var3.h, var1, (byte)80);
            var3.h.clear();
         case 3:
         case 5:
         case 6:
         case 7:
         }

      }
   }

   private void a(ao var1, ao var2) {
      int var15 = f;
      double[] var3 = new double[2];
      double var4 = var2.v();
      double var6 = var2.w();
      y.c.q var8 = (y.c.q)this.B.b(var1);
      y.c.q var9 = this.s.d();
      this.C.a(var9, var2);
      this.B.a(var2, var9);
      y.c.e var10 = var8.j();

      while(var10.f()) {
         y.c.d var11 = var10.a();
         y.c.q var12 = var11.a(var8);
         ao var13 = (ao)this.C.b(var12);
         if(var13 != null) {
            label25: {
               if(var1.x()) {
                  var3[0] = var13.k.b;
                  var3[1] = var13.l.b;
                  if(var15 == 0) {
                     break label25;
                  }
               }

               var3[0] = var13.k.a;
               var3[1] = var13.l.a;
            }

            if(var3[0] < var6 && var3[1] > var4) {
               y.c.d var14 = this.s.a(var9, var12);
               this.A.a(var14, this.A.b(var11));
            }
         }

         var10.g();
         if(var15 != 0) {
            break;
         }
      }

   }

   private av H() {
      av var1;
      label39: {
         int var5 = f;
         this.T = new y.g.al();
         if(this.h == 0) {
            var1 = new av(this.g, new y.c.f());
            if(var5 == 0) {
               break label39;
            }
         }

         y.c.f[] var2 = this.Q();
         this.t = var2[0];
         y.c.f var3 = var2[1];
         if(!this.aw) {
            var1 = new av(this.g, var3);
            if(var5 == 0) {
               break label39;
            }
         }

         var1 = new av(this.g, new y.c.f());
      }

      this.T.b();
      int var6 = this.ae?this.af:5;
      double var7 = this.i?(double)(var6 * this.o):(double)(var6 * 2) * this.q;
      if(!this.u()) {
         var7 += (double)this.v();
      }

      var1.a(var7);
      var1.b(this.i?0.5D:this.q);
      var1.a(true);
      var1.a((byte)8);
      return var1;
   }

   private void I() {
      int var13 = f;
      y.c.e var5 = this.g.p();

      y.c.d var1;
      y.f.X var10000;
      Object var10001;
      while(true) {
         if(var5.f()) {
            var1 = var5.a();
            ae var4 = (ae)this.E.b(var1);
            Collection var2 = ad.b(this.g, var1, true);
            Object var14 = ad.a(this.g, var1, var2, true);
            Collection var3 = ad.b(this.g, var1, false);
            var10000 = this.g;
            var10001 = var1;
            if(var13 != 0) {
               break;
            }

            Object var15 = ad.a(var10000, var1, var3, false);
            if(var1.e()) {
               if(var14 == null) {
                  var14 = new ArrayList(1);
               }

               if(var15 == null) {
                  var15 = new ArrayList(1);
               }

               ad.a(this.g, var1, (Collection)var14, (Collection)var15);
            }

            var4.a(true, (Collection)var14);
            var4.a(false, (Collection)var15);
            var5.g();
            if(var13 == 0) {
               continue;
            }
         }

         var10000 = this.g;
         var10001 = y.f.ay.a;
         break;
      }

      y.c.c var16 = var10000.c(var10001);
      if(var16 != null) {
         y.c.x var6 = this.g.o();

         do {
            boolean var17 = var6.f();

            label50:
            while(true) {
               if(!var17) {
                  return;
               }

               y.c.q var7 = var6.e();
               if(var16.b(var7) == null) {
                  break;
               }

               D var8 = this.e(var7);
               y.c.e var9 = var7.j();

               while(true) {
                  if(!var9.f()) {
                     break label50;
                  }

                  var1 = var9.a();
                  ae var10 = (ae)this.E.b(var1);
                  boolean var11 = var1.c().equals(var7);
                  Collection var12 = var10.c(var11);
                  var17 = a(var12);
                  if(var13 != 0) {
                     break;
                  }

                  if(!var17) {
                     var10.a(var11, (Collection)var8.a());
                     var10.a(true, var11);
                  }

                  var9.g();
                  if(var13 != 0) {
                     break label50;
                  }
               }
            }

            var6.g();
         } while(var13 == 0);
      }

   }

   private static boolean a(Collection var0) {
      int var3 = f;
      if(var0 != null && !var0.isEmpty()) {
         Iterator var1 = var0.iterator();

         boolean var10000;
         while(true) {
            if(var1.hasNext()) {
               y.f.ax var2 = (y.f.ax)var1.next();
               if(!var2.b() && var2.a((int)1) && var2.a((int)2) && var2.a((int)4) && var2.a((int)8)) {
                  continue;
               }

               var10000 = true;
               if(var3 == 0) {
                  return true;
               }
               break;
            }

            var10000 = false;
            break;
         }

         return var10000;
      } else {
         return false;
      }
   }

   private void J() {
      int var4 = f;
      this.I();
      y.c.h var1 = this.g.u();
      y.c.e var2 = this.t.a();

      y.c.d var3;
      while(true) {
         if(var2.f()) {
            var3 = var2.a();
            this.b(var3, true);
            this.b(var3, false);
            var1.a(var3, true);
            var2.g();
            if(var4 != 0) {
               break;
            }

            if(var4 == 0) {
               continue;
            }
         }

         var2 = this.g.p();
         break;
      }

      while(true) {
         if(var2.f()) {
            var3 = var2.a();
            if(var4 != 0) {
               break;
            }

            if(!var1.d(var3)) {
               this.c(var3, true);
               this.c(var3, false);
            }

            var2.g();
            if(var4 == 0) {
               continue;
            }
         }

         this.g.a((y.c.h)var1);
         break;
      }

   }

   private void b(y.c.d var1, boolean var2) {
      int var13 = f;
      ae var3 = (ae)this.E.b(var1);
      y.c.q var4 = var2?var1.c():var1.d();
      Collection var5 = var3.c(var2);
      y.c.D var6 = new y.c.D();
      if(var5 != null && !var5.isEmpty()) {
         boolean var7 = true;
         Iterator var8 = var5.iterator();

         boolean var10000;
         label64: {
            while(var8.hasNext()) {
               y.f.ax var9 = (y.f.ax)var8.next();
               var10000 = var9.b();
               if(var13 != 0) {
                  break label64;
               }

               if(var10000) {
                  double var10;
                  ao var12;
                  if(var9.a((int)1)) {
                     var10 = this.g.j(var4) + var9.c();
                     var12 = this.a((y.c.q)var4, var10, (byte)1);
                     if(var12 != null) {
                        ((al)var12).a(var1, var10, (byte)2, var2);
                        var6.add(new af(var12, var9));
                     }
                  }

                  if(var9.a((int)2)) {
                     var10 = this.g.j(var4) + var9.c();
                     var12 = this.a((y.c.q)var4, var10, (byte)2);
                     if(var12 != null) {
                        ((al)var12).a(var1, var10, (byte)1, var2);
                        var6.add(new af(var12, var9));
                     }
                  }

                  if(var9.a((int)4)) {
                     var10 = this.g.k(var4) + var9.d();
                     var12 = this.a((y.c.q)var4, var10, (byte)4);
                     if(var12 != null) {
                        ((al)var12).a(var1, var10, (byte)8, var2);
                        var6.add(new af(var12, var9));
                     }
                  }

                  if(!var9.a((int)8)) {
                     continue;
                  }

                  var10 = this.g.k(var4) + var9.d();
                  var12 = this.a((y.c.q)var4, var10, (byte)8);
                  if(var12 == null) {
                     continue;
                  }

                  ((al)var12).a(var1, var10, (byte)4, var2);
                  var6.add(new af(var12, var9));
                  if(var13 == 0) {
                     continue;
                  }
               }

               var7 = false;
               if(var13 != 0) {
                  break;
               }
            }

            var10000 = var7;
         }

         if(var10000 && var6.isEmpty()) {
            this.ap.add(var1);
            if(var13 == 0) {
               return;
            }
         }

         if(!var6.isEmpty()) {
            var3.a(var2, var6);
         }
      }

   }

   private void c(y.c.d var1, boolean var2) {
      ae var3 = (ae)this.E.b(var1);
      Collection var4 = var3.c(var2);
      if(var4 != null && var4.size() == 1 && ((y.f.ax)var4.iterator().next()).b()) {
         var3.b(var2, true);
      }

   }

   private void K() {
      int var5 = f;
      this.J = 0;
      this.K = 0;
      this.I = 0;
      this.W = new y.g.al(false);
      this.V = new y.g.al();
      this.J();
      aI var1 = new aI(this.g, this.t, this);
      y.c.f var2 = var1.a();
      y.c.e var3 = var2.a();

      while(true) {
         if(var3.f()) {
            y.c.d var4 = var3.a();
            this.a(var4);
            var3.g();
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         this.V.b();
         break;
      }

   }

   private y.c.f a(y.c.d var1, y.c.q var2, y.c.q var3, boolean var4) {
      y.c.f var5;
      int var15;
      boolean var37;
      label381: {
         label417: {
            var15 = f;
            var5 = new y.c.f();
            ae var6 = (ae)this.E.b(var1);
            Collection var7 = var6.c(var4);
            if(var7 == null || var7.isEmpty()) {
               aJ var8;
               if(this.ar == 2) {
                  var8 = (aJ)this.z.b(var2);
                  this.a((y.c.D)var8.e, var3, (y.c.f)var5, (y.f.ax)null);
                  this.a((y.c.D)var8.g, var3, (y.c.f)var5, (y.f.ax)null);
                  if(var15 == 0) {
                     break label417;
                  }
               }

               if(this.ar == 1) {
                  var8 = (aJ)this.z.b(var2);
                  this.a((y.c.D)var8.a, var3, (y.c.f)var5, (y.f.ax)null);
                  this.a((y.c.D)var8.c, var3, (y.c.f)var5, (y.f.ax)null);
                  if(var15 == 0) {
                     break label417;
                  }
               }

               this.a(var2, var3, var5);
               if(var15 == 0) {
                  break label417;
               }
            }

            boolean var9;
            y.c.D var10;
            y.c.C var11;
            af var12;
            y.c.q var13;
            y.c.d var14;
            int var10000;
            aJ var24;
            Iterator var27;
            y.f.ax var31;
            label418: {
               if(this.ar == 1 || this.ar == 3) {
                  int var16 = (!var4 || this.g.n(var1.d()) + this.g.q(var1.d()) >= this.g.n(var1.c())) && (var4 || this.g.n(var1.c()) + this.g.q(var1.c()) >= this.g.n(var1.d()))?0:1;
                  var9 = !var4 && this.g.n(var1.d()) + this.g.q(var1.d()) < this.g.n(var1.c()) || var4 && this.g.n(var1.c()) + this.g.q(var1.c()) < this.g.n(var1.d());
                  if(var16 != 0 || var9) {
                     var10 = var6.e(var4);
                     if(var10 != null) {
                        var11 = var10.m();

                        while(var11.f()) {
                           var12 = (af)var11.d();
                           var10000 = var16;
                           if(var15 != 0) {
                              break label418;
                           }

                           if((var16 != 0 && var12.b.a((int)1) || var9 && var12.b.a((int)2)) && this.a(var2, var12)) {
                              var13 = (y.c.q)this.B.b(var12.a);
                              var14 = this.s.a(var3, var13);
                              this.aq.put(var14, var12.b);
                              var5.add(var14);
                           }

                           var11.g();
                           if(var15 != 0) {
                              break;
                           }
                        }
                     }

                     var24 = (aJ)this.z.b(var2);
                     var27 = var7.iterator();

                     label316:
                     while(true) {
                        do {
                           do {
                              if(!var27.hasNext()) {
                                 break label316;
                              }

                              var31 = (y.f.ax)var27.next();
                           } while(var31.b());

                           var10000 = var16;
                           if(var15 != 0) {
                              break label418;
                           }

                           if(var16 == 0 || !var31.a((int)1) || !this.a((y.c.q)var2, (int)1)) {
                              break;
                           }

                           this.a(var24.a, var3, var5, var31);
                        } while(var15 == 0);

                        if(var9 && var31.a((int)2) && this.a((y.c.q)var2, (int)2)) {
                           this.a(var24.c, var3, var5, var31);
                           if(var15 != 0) {
                              break;
                           }
                        }
                     }
                  }
               }

               var10000 = this.ar;
            }

            if(var10000 == 2 || this.ar == 3) {
               boolean var17 = var4 && this.g.m(var1.d()) + this.g.p(var1.d()) < this.g.m(var1.c()) || !var4 && this.g.m(var1.c()) + this.g.p(var1.c()) < this.g.m(var1.d());
               var9 = !var4 && this.g.m(var1.d()) + this.g.p(var1.d()) < this.g.m(var1.c()) || var4 && this.g.m(var1.c()) + this.g.p(var1.c()) < this.g.m(var1.d());
               if(var17 || var9) {
                  var10 = var6.e(var4);
                  if(var10 != null) {
                     var11 = var10.m();

                     while(var11.f()) {
                        var12 = (af)var11.d();
                        var37 = var17;
                        if(var15 != 0) {
                           break label381;
                        }

                        if((var17 && var12.b.a((int)8) || var9 && var12.b.a((int)4)) && this.a(var2, var12)) {
                           var13 = (y.c.q)this.B.b(var12.a);
                           var14 = this.s.a(var3, var13);
                           this.aq.put(var14, var12.b);
                           var5.add(var14);
                        }

                        var11.g();
                        if(var15 != 0) {
                           break;
                        }
                     }
                  }

                  var24 = (aJ)this.z.b(var2);
                  var27 = var7.iterator();

                  label247:
                  while(true) {
                     do {
                        do {
                           if(!var27.hasNext()) {
                              break label247;
                           }

                           var31 = (y.f.ax)var27.next();
                        } while(var31.b());

                        var37 = var17;
                        if(var15 != 0) {
                           break label381;
                        }

                        if(!var17 || !var31.a((int)8) || !this.a((y.c.q)var2, (int)8)) {
                           break;
                        }

                        this.a(var24.e, var3, var5, var31);
                     } while(var15 == 0);

                     if(var9 && var31.a((int)4) && this.a((y.c.q)var2, (int)4)) {
                        this.a(var24.g, var3, var5, var31);
                        if(var15 != 0) {
                           break;
                        }
                     }
                  }
               }
            }

            y.c.D var18;
            label219: {
               var18 = new y.c.D();
               if(var5.isEmpty()) {
                  y.c.D var19 = var6.e(var4);
                  if(var19 != null) {
                     y.c.C var22 = var19.m();

                     while(var22.f()) {
                        af var28 = (af)var22.d();
                        var18.add(var28);
                        var37 = this.a(var2, var28);
                        if(var15 != 0) {
                           break label219;
                        }

                        if(var37) {
                           y.c.q var32 = (y.c.q)this.B.b(var28.a);
                           y.c.d var36 = this.s.a(var3, var32);
                           this.aq.put(var36, var28.b);
                           var5.add(var36);
                        }

                        var22.g();
                        if(var15 != 0) {
                           break;
                        }
                     }
                  }

                  aJ var23 = (aJ)this.z.b(var2);
                  Iterator var29 = var7.iterator();

                  while(var29.hasNext()) {
                     y.f.ax var34 = (y.f.ax)var29.next();
                     if(!var34.b()) {
                        var37 = var34.a((int)1);
                        if(var15 != 0) {
                           break label219;
                        }

                        if(var37 && this.a((y.c.q)var2, (int)1)) {
                           this.a(var23.a, var3, var5, var34);
                        }

                        if(var34.a((int)2) && this.a((y.c.q)var2, (int)2)) {
                           this.a(var23.c, var3, var5, var34);
                        }

                        if(var34.a((int)8) && this.a((y.c.q)var2, (int)8)) {
                           this.a(var23.e, var3, var5, var34);
                        }

                        if(var34.a((int)4) && this.a((y.c.q)var2, (int)4)) {
                           this.a(var23.g, var3, var5, var34);
                           if(var15 != 0) {
                              break;
                           }
                        }
                     }
                  }
               }

               var37 = var5.isEmpty();
            }

            if(var37) {
               label403: {
                  y.c.C var20 = var18.m();

                  while(var20.f()) {
                     af var25 = (af)var20.d();
                     y.c.q var30 = (y.c.q)this.B.b(var25.a);
                     y.c.d var35 = this.s.a(var3, var30);
                     this.aq.put(var35, var25.b);
                     var5.add(var35);
                     var20.g();
                     if(var15 != 0) {
                        break label403;
                     }

                     if(var15 != 0) {
                        break;
                     }
                  }

                  aJ var21 = (aJ)this.z.b(var2);
                  Iterator var26 = var7.iterator();

                  while(var26.hasNext()) {
                     y.f.ax var33 = (y.f.ax)var26.next();
                     if(!var33.b()) {
                        var37 = var33.a((int)1);
                        if(var15 != 0) {
                           break label381;
                        }

                        if(var37) {
                           this.a(var21.a, var3, var5, var33);
                        }

                        if(var33.a((int)2)) {
                           this.a(var21.c, var3, var5, var33);
                        }

                        if(var33.a((int)8)) {
                           this.a(var21.e, var3, var5, var33);
                        }

                        if(var33.a((int)4)) {
                           this.a(var21.g, var3, var5, var33);
                           if(var15 != 0) {
                              break;
                           }
                        }
                     }
                  }
               }
            }
         }

         var37 = this.an;
      }

      if(var37 || this.ao && this.am || this.al) {
         this.a(var5, var2, var3, var1, 1.0D, 0.5D);
         if(var15 == 0) {
            return var5;
         }
      }

      this.a(var5, 1.0D);
      return var5;
   }

   private static boolean a(y.d.m var0, double var1) {
      return Math.abs(var0.c().a - var0.d().a) < var1;
   }

   private static boolean a(y.d.m var0, boolean var1) {
      return var1?var0.c().b < var0.d().b:var0.c().a < var0.d().a;
   }

   private boolean a(y.c.q var1, int var2) {
      D var3 = (D)this.Z.b(var1);
      return var3 == null?true:var3.a(var2) > var3.b(var2).size();
   }

   private boolean a(y.c.q var1, af var2) {
      int var10 = f;
      y.f.ax var3 = var2.b;
      if(!var3.b()) {
         return this.a(var1, var3.a());
      } else {
         D var4 = (D)this.Z.b(var1);
         if(var4 == null) {
            return true;
         } else {
            y.c.D var5 = var4.b(var3.a());
            int var6 = var4.a(var3.c(), var3.d());
            if(var6 == -1) {
               if(!this.a(var1, var3.a())) {
                  return false;
               }

               var6 = 1;
            }

            int var7 = 0;
            y.c.C var8 = var5.m();

            int var10000;
            while(true) {
               if(var8.f()) {
                  y.d.t var9 = (y.d.t)var8.d();
                  double var11;
                  var10000 = (var11 = y.d.t.a(var9.a, var9.b, var3.c(), var3.d()) - 2.0D) == 0.0D?0:(var11 < 0.0D?-1:1);
                  if(var10 != 0) {
                     break;
                  }

                  if(var10000 < 0) {
                     ++var7;
                     if(var7 >= var6) {
                        return false;
                     }
                  }

                  var8.g();
                  if(var10 == 0) {
                     continue;
                  }
               }

               var10000 = 1;
               break;
            }

            return (boolean)var10000;
         }
      }
   }

   private D e(y.c.q var1) {
      if(this.Z.b(var1) != null) {
         return (D)this.Z.b(var1);
      } else {
         D var3;
         label16: {
            y.c.c var2 = this.g.c(y.f.ay.a);
            if(var2 != null && var2.b(var1) != null) {
               var3 = new D((y.f.ay)var2.b(var1));
               if(f == 0) {
                  break label16;
               }
            }

            var3 = new D();
         }

         this.Z.a(var1, var3);
         return var3;
      }
   }

   private void a(y.c.d var1, y.f.X var2) {
      y.d.v var3;
      y.c.p var6;
      int var10;
      label44: {
         var10 = f;
         var3 = var2.l(var1);
         D var4 = this.e(var1.c());
         y.d.m var5 = var3.a(0);
         if(a(var5, 0.01D)) {
            if(a(var5, true)) {
               var6 = var4.a((y.d.t)var2.n(var1), 2);
               if(var10 == 0) {
                  break label44;
               }
            }

            var6 = var4.a((y.d.t)var2.n(var1), 1);
            if(var10 == 0) {
               break label44;
            }
         }

         if(a(var5, false)) {
            var6 = var4.a((y.d.t)var2.n(var1), 4);
            if(var10 == 0) {
               break label44;
            }
         }

         var6 = var4.a((y.d.t)var2.n(var1), 8);
      }

      y.c.p var9;
      label45: {
         this.X.a(var1, var6);
         D var7 = this.e(var1.d());
         y.d.m var8 = var3.a(var3.h() - 2);
         if(a(var8, 0.01D)) {
            if(a(var8, true)) {
               var9 = var7.a((y.d.t)var2.o(var1), 1);
               if(var10 == 0) {
                  break label45;
               }
            }

            var9 = var7.a((y.d.t)var2.o(var1), 2);
            if(var10 == 0) {
               break label45;
            }
         }

         if(a(var8, false)) {
            var9 = var7.a((y.d.t)var2.o(var1), 8);
            if(var10 == 0) {
               break label45;
            }
         }

         var9 = var7.a((y.d.t)var2.o(var1), 4);
      }

      this.Y.a(var1, var9);
   }

   private void b(y.c.d var1, y.f.X var2) {
      y.d.v var3;
      int var10;
      label44: {
         var10 = f;
         var3 = var2.l(var1);
         D var4 = this.e(var1.c());
         y.d.m var5 = var3.a(0);
         y.c.p var6 = (y.c.p)this.X.b(var1);
         if(a(var5, 0.01D)) {
            if(a(var5, true)) {
               var4.a((y.c.p)var6, 2);
               if(var10 == 0) {
                  break label44;
               }
            }

            var4.a((y.c.p)var6, 1);
            if(var10 == 0) {
               break label44;
            }
         }

         if(a(var5, false)) {
            var4.a((y.c.p)var6, 4);
            if(var10 == 0) {
               break label44;
            }
         }

         var4.a((y.c.p)var6, 8);
      }

      label45: {
         this.X.a(var1, (Object)null);
         D var7 = this.e(var1.d());
         y.d.m var8 = var3.a(var3.h() - 2);
         y.c.p var9 = (y.c.p)this.Y.b(var1);
         if(a(var8, 0.01D)) {
            if(a(var8, true)) {
               var7.a((y.c.p)var9, 1);
               if(var10 == 0) {
                  break label45;
               }
            }

            var7.a((y.c.p)var9, 2);
            if(var10 == 0) {
               break label45;
            }
         }

         if(a(var8, false)) {
            var7.a((y.c.p)var9, 8);
            if(var10 == 0) {
               break label45;
            }
         }

         var7.a((y.c.p)var9, 4);
      }

      this.Y.a(var1, (Object)null);
   }

   private y.c.D a(y.c.d var1, y.c.q var2, y.c.q var3) {
      int var11 = f;
      y.c.q var5 = var1.c();
      boolean var8 = true;
      boolean var9 = !this.aa;
      ae var10 = (ae)this.E.b(var1);

      while(true) {
         y.c.D var4;
         y.c.f var6;
         y.c.f var7;
         label67: {
            var6 = this.a(var1, var5, var2, var8);
            var7 = this.a(var1, var1.a(var5), var3, !var8);
            if(var8) {
               var4 = this.a(var2, var3, var10);
               if(var11 == 0) {
                  break label67;
               }
            }

            var4 = this.a(var3, var2, var10);
         }

         while(true) {
            if(this.aa && var4 == null) {
               label52: {
                  if(this.i) {
                     this.p /= 2;
                     if(this.p >= 2) {
                        break label52;
                     }

                     this.p = 2;
                     var9 = true;
                     if(var11 == 0) {
                        break label52;
                     }
                  }

                  this.r = Math.floor(0.5D * this.r);
                  if(this.r < 2.0D) {
                     this.r = 2.0D;
                     var9 = true;
                  }
               }

               if(!var9) {
                  this.O();
               }
            }

            this.a(var2, var6);
            var6.clear();
            this.a(var3, var7);
            var7.clear();
            this.aq.clear();
            if(!var9 && var4 == null) {
               break;
            }

            if(var11 == 0) {
               return var4;
            }

            var4 = var4;
         }
      }
   }

   private void a(y.c.d var1) {
      int var8 = f;
      this.u = var1.c();
      this.v = var1.d();
      this.w = var1;
      y.c.q var3 = this.s.d();
      y.c.q var4 = this.s.d();
      ae var5 = (ae)this.E.b(var1);
      var5.a = this.aF++;
      y.c.D var2 = this.a(var1, var3, var4);
      if(var2 == null && this.F() && !this.as && !this.i) {
         byte var6;
         label75: {
            var6 = this.ar;
            if(this.ar == 3) {
               boolean var7 = Math.abs(this.g.m(this.u) - this.g.m(this.v)) < Math.abs(this.g.n(this.u) - this.g.n(this.v));
               this.ar = (byte)(var7?1:2);
               var2 = this.a(var1, var3, var4);
               if(var2 != null) {
                  break label75;
               }

               this.ar = (byte)(var7?2:1);
               var2 = this.a(var1, var3, var4);
               if(var8 == 0) {
                  break label75;
               }
            }

            if(this.ar == 1 || this.ar == 2) {
               this.ar = (byte)(this.ar == 1?2:1);
               var2 = this.a(var1, var3, var4);
            }
         }

         if(var2 == null) {
            this.ar = 0;
            var2 = this.a(var1, var3, var4);
         }

         this.ar = var6;
      }

      if(var2 != null) {
         ++this.J;

         try {
            this.a(var1, var2, this.av);
            this.r = this.q;
            this.p = this.o;
            if(this.au) {
               this.a(var1, this.g);
            }

            return;
         } catch (IllegalStateException var9) {
            this.b(var1);
            if(var8 == 0) {
               return;
            }
         }
      }

      this.b(var1);
   }

   private void b(y.c.d var1) {
      ++this.K;
      ++this.az;
      if(!this.ab) {
         y.c.D var2 = new y.c.D();
         var2.add(this.g.p(var1));
         var2.add(this.g.q(var1));
         this.g.a(var1, var2);
      }

      this.ax.a(var1, true);
      this.ay.a(var1, true);
   }

   private y.c.D a(y.c.q var1, y.c.q var2, ae var3) {
      int var13 = f;
      y.c.f var4 = null;
      y.c.D var5 = null;
      byte var6 = 0;
      int var7 = 1;
      y.c.f var8 = null;

      int var10000;
      while(true) {
         if(var6 == 0) {
            var10000 = var7;
            if(var13 != 0) {
               break;
            }

            if(var7 < 8) {
               this.W.a();
               var4 = this.a(this.s, var1, var2, false, this.A, var3);
               if(var8 == null) {
                  var8 = var4;
               }

               this.W.b();
               ++this.I;
               var5 = this.a(var4, var1);
               y.f.ax var9 = null;
               y.f.ax var10 = null;
               if(!var4.isEmpty()) {
                  var9 = (y.f.ax)this.aq.get(var4.b());
                  if(var9 != null && var9.b() && var9.b()) {
                     this.g.a(this.w, new y.d.t(var9.c(), var9.d()));
                     var3.b(true, true);
                  }

                  var10 = (y.f.ax)this.aq.get(var4.c());
                  if(var10 != null && var10.b() && var10.b()) {
                     this.g.b(this.w, new y.d.t(var10.c(), var10.d()));
                     var3.b(false, true);
                  }
               }

               boolean var11 = var9 != null && var9.b() || var3.d(true);
               boolean var12 = var10 != null && var10.b() || var3.d(false);
               var6 = this.a(var5, var11, var12);
               ++var7;
               if(var13 == 0) {
                  continue;
               }
            }
         }

         var10000 = var6;
         break;
      }

      return var10000 == 0?null:var5;
   }

   private void L() {
      int var11 = f;
      double var1 = Double.MAX_VALUE;
      double var3 = 0.0D;
      double var5 = Double.MAX_VALUE;
      double var7 = 0.0D;
      y.c.x var9 = this.s.o();

      while(true) {
         if(var9.f()) {
            ao var10 = (ao)this.C.b(var9.e());
            if(var11 != 0) {
               break;
            }

            if(!var10.x()) {
               if(var10.k.a < var1) {
                  var1 = var10.k.a;
               }

               if(var10.k.b < var5) {
                  var5 = var10.k.b;
               }

               if(var10.l.a > var3) {
                  var3 = var10.l.a;
               }

               if(var10.l.a > var7) {
                  var7 = var10.l.b;
               }
            }

            var9.g();
            if(var11 == 0) {
               continue;
            }
         }

         this.aA = var1;
         this.aB = var3;
         this.aC = var5;
         this.aD = var7;
         break;
      }

   }

   private void M() {
      y.c.q var1;
      double var9;
      double var11;
      double var13;
      int var23;
      label65: {
         var23 = f;
         var9 = this.g.m(this.u);
         var11 = this.g.m(this.v);
         var13 = Math.min(var9, var11);
         if(var13 == var9) {
            var1 = this.u;
            if(var23 == 0) {
               break label65;
            }
         }

         var1 = this.v;
      }

      y.c.q var3;
      double var17;
      label60: {
         var9 += this.g.p(this.u);
         var11 += this.g.p(this.v);
         var17 = Math.max(var9, var11);
         if(var17 == var9) {
            var3 = this.u;
            if(var23 == 0) {
               break label60;
            }
         }

         var3 = this.v;
      }

      y.c.q var2;
      double var15;
      label55: {
         var9 = this.g.n(this.u);
         var11 = this.g.n(this.v);
         var15 = Math.min(var9, var11);
         if(var15 == var9) {
            var2 = this.u;
            if(var23 == 0) {
               break label55;
            }
         }

         var2 = this.v;
      }

      y.c.q var4;
      double var19;
      label50: {
         var9 += this.g.q(this.u);
         var11 += this.g.q(this.v);
         var19 = Math.max(var9, var11);
         if(var19 == var9) {
            var4 = this.u;
            if(var23 == 0) {
               break label50;
            }
         }

         var4 = this.v;
      }

      y.d.t var7 = new y.d.t(var13, var15);
      ap var5 = new ap(var7, this.C);
      y.d.t var8 = new y.d.t(var17, var19);
      ap var6 = new ap(var8, this.C);
      y.c.x var21 = this.s.o();

      al var22;
      while(var21.f()) {
         var22 = (al)this.C.b(var21.e());
         if(var22 != null) {
            var22.a(0);
         }

         var21.g();
         if(var23 != 0) {
            break;
         }
      }

      var22 = null;
      aJ var24 = (aJ)this.z.b(var1);
      ao var25 = this.b(var24.e);
      if(var25 != null) {
         this.a(var25, var5);
      }

      var24 = (aJ)this.z.b(var2);
      var22 = null;
      var25 = this.b(var24.a);
      if(var25 != null) {
         this.a(var25, var5);
      }

      var24 = (aJ)this.z.b(var3);
      var22 = null;
      var25 = this.b(var24.g);
      if(var25 != null) {
         this.a(var25, var6);
      }

      var24 = (aJ)this.z.b(var4);
      var22 = null;
      var25 = this.b(var24.c);
      if(var25 != null) {
         this.a(var25, var6);
      }

   }

   private ao b(y.c.D var1) {
      int var9 = f;
      double var2 = 0.0D;
      ao var4 = null;
      y.c.C var5 = var1.m();

      ao var10000;
      while(true) {
         if(var5.f()) {
            ao var6 = (ao)var5.d();
            var10000 = var6;
            if(var9 != 0) {
               break;
            }

            double var7 = var6.q();
            if(var7 > var2) {
               var4 = var6;
               var2 = var7;
            }

            var5.g();
            if(var9 == 0) {
               continue;
            }
         }

         var10000 = var4;
         break;
      }

      return var10000;
   }

   private void a(ao var1, ap var2) {
      int var10 = f;
      y.c.q var3 = (y.c.q)this.B.b(var1);
      var2.a(var3);
      y.c.f var4 = new y.c.f(var3.j());
      var4.sort(var2);
      int var5 = 0;
      y.c.e var6 = var4.a();

      while(var6.f()) {
         y.c.d var7 = var6.a();
         al var8 = (al)this.C.b(var7.a(var3));
         if(var8 != null) {
            int var9 = Math.max(var5, var8.k());
            var8.a(var9);
            var5 += 2;
         }

         var6.g();
         if(var10 != 0) {
            break;
         }
      }

   }

   y.c.d[] a(int var1) {
      if(this.aN == null || this.aN.length < var1) {
         if(this.aN == null) {
            this.aN = new y.c.d[Math.max(var1 + 20, 500)];
            if(f == 0) {
               return this.aN;
            }
         }

         this.aN = new y.c.d[Math.max(var1 + 20, this.aN.length)];
      }

      return this.aN;
   }

   private boolean a(ae var1, boolean var2, boolean var3, boolean var4) {
      int var9 = f;
      Collection var5 = var1.c(var2);
      if(var5 != null && !var5.isEmpty()) {
         boolean var6 = true;
         Iterator var7 = var5.iterator();

         boolean var10000;
         while(true) {
            if(var7.hasNext()) {
               y.f.ax var8 = (y.f.ax)var7.next();
               var10000 = var2;
               if(var9 != 0) {
                  break;
               }

               if(var2) {
                  if(var3) {
                     if(var4) {
                        var6 = var8.a((int)1) || var8.a((int)4) || var8.a((int)8);
                        if(var9 == 0) {
                           continue;
                        }
                     }

                     var6 = var8.a((int)2) || var8.a((int)4) || var8.a((int)8);
                     if(var9 == 0) {
                        continue;
                     }
                  }

                  if(var4) {
                     var6 = var8.a((int)8) || var8.a((int)1) || var8.a((int)2);
                     if(var9 == 0) {
                        continue;
                     }
                  }

                  var6 = var8.a((int)4) || var8.a((int)1) || var8.a((int)2);
                  if(var9 == 0) {
                     continue;
                  }
               }

               if(var3) {
                  if(var4) {
                     var6 = var8.a((int)2) || var8.a((int)4) || var8.a((int)8);
                     if(var9 == 0) {
                        continue;
                     }
                  }

                  var6 = var8.a((int)1) || var8.a((int)4) || var8.a((int)8);
                  if(var9 == 0) {
                     continue;
                  }
               }

               if(var4) {
                  var6 = var8.a((int)4) || var8.a((int)1) || var8.a((int)2);
                  if(var9 == 0) {
                     continue;
                  }
               }

               var6 = var8.a((int)8) || var8.a((int)1) || var8.a((int)2);
               if(var9 == 0) {
                  continue;
               }
            }

            var10000 = var6;
            break;
         }

         return var10000;
      } else {
         return true;
      }
   }

   private y.c.f a(y.c.i var1, y.c.q var2, y.c.q var3, boolean var4, y.c.h var5, ae var6) {
      int var89 = f;
      y.c.d var7 = var6.a();
      boolean var8 = this.g.n(var7.c()) > this.g.n(var7.d());
      boolean var9 = this.g.m(var7.c()) > this.g.m(var7.d());
      double var10 = !var8 && !this.a(var6, true, true, var8)?-1.7976931348623157E308D:this.g.n(var7.c());
      double var12 = var8 && !this.a(var6, true, true, var8)?Double.MAX_VALUE:this.g.n(var7.c()) + this.g.q(var7.c());
      double var14 = var8 && !this.a(var6, false, true, var8)?-1.7976931348623157E308D:this.g.n(var7.d());
      double var16 = !var8 && !this.a(var6, false, true, var8)?Double.MAX_VALUE:this.g.n(var7.d()) + this.g.q(var7.d());
      double var18 = !var9 && !this.a(var6, true, false, var9)?-1.7976931348623157E308D:this.g.m(var7.c());
      double var20 = var9 && !this.a(var6, true, false, var9)?Double.MAX_VALUE:this.g.m(var7.c()) + this.g.p(var7.c());
      double var22 = var9 && !this.a(var6, false, false, var9)?-1.7976931348623157E308D:this.g.m(var7.d());
      double var24 = !var9 && !this.a(var6, false, false, var9)?Double.MAX_VALUE:this.g.m(var7.d()) + this.g.p(var7.d());
      y.c.f var32 = null;
      this.aJ.a(0);
      this.aK.a(Double.POSITIVE_INFINITY);
      this.aL.a(Double.POSITIVE_INFINITY);
      this.aM.a(0.0D);
      Object var37 = null;
      Object var38 = null;
      double var39 = 1.0D;
      double var41 = 1.0D;
      if(this.ah && this.ai) {
         var39 = this.aj;
         var41 = 1.0D - var39;
      }

      boolean var43 = false;
      byte var44 = 0;
      double var47 = Double.POSITIVE_INFINITY;
      double var49 = Double.POSITIVE_INFINITY;
      if(var4) {
         throw new IllegalStateException("No logic for directed graphs.");
      } else {
         y.c.A var51 = y.g.M.a();
         y.g.a.f var28 = new y.g.a.f(var1.f(), var51, var51);
         y.c.A var52 = y.g.M.a();
         y.g.a.f var29 = new y.g.a.f(var1.f(), var52, var52);
         var28.a(var2, 0.0D);
         this.aJ.a(var2, 64);
         var29.a(var3, 0.0D);
         this.aJ.a(var3, 16);
         double var35 = 0.0D;
         double var33 = 0.0D;
         if(this.aR) {
            this.M();
         }

         y.d.t var53 = this.c(this.w);
         double var54 = Math.max(Math.abs(var53.a - this.aA), Math.abs(var53.a - this.aB));
         double var56 = Math.max(Math.abs(var53.b - this.aC), Math.abs(var53.b - this.aD));
         double var58 = 0.0D;
         new y.c.f();

         boolean var10000;
         while(true) {
            if(!var43) {
               var10000 = false;
               if(var89 != 0) {
                  break;
               }

               boolean var45 = false;

               y.c.q var30;
               y.c.q var31;
               ao var61;
               double var62;
               ao var64;
               y.c.q var65;
               ao var66;
               y.c.q var67;
               double var90;
               int var102;
               label677: {
                  label676:
                  while(!var28.c() && !var45) {
                     var45 = true;
                     var33 = var28.b();
                     if(var33 + var35 > var47) {
                        var44 = 1;
                        if(var89 == 0) {
                           break;
                        }
                     }

                     label670: {
                        var30 = (y.c.q)var28.a();
                        this.aJ.a(var30, 192);
                        var61 = (ao)this.C.b(var30);
                        var62 = var8?var12:var10;
                        if(this.D() && var61 != null && var61.x()) {
                           var64 = var61;
                           var65 = var30;

                           while(var64 != null) {
                              var10000 = var64.x();
                              if(var89 != 0) {
                                 break label670;
                              }

                              if(!var10000) {
                                 break;
                              }

                              var65 = ((y.c.d)this.aH.b(var65)).a(var65);
                              var64 = var65 == null?null:(ao)this.C.b(var65);
                              if(var89 != 0) {
                                 break;
                              }
                           }

                           if(var64 != null) {
                              var62 = var8?var64.t():var64.u();
                           }
                        }

                        var10000 = var9;
                     }

                     label651: {
                        var90 = var10000?var20:var18;
                        if(this.E() && var61 != null && !var61.x()) {
                           var66 = var61;
                           var67 = var30;

                           while(var66 != null) {
                              var10000 = var66.x();
                              if(var89 != 0) {
                                 break label651;
                              }

                              if(var10000) {
                                 break;
                              }

                              var67 = ((y.c.d)this.aH.b(var67)).a(var67);
                              var66 = var67 == null?null:(ao)this.C.b(var67);
                              if(var89 != 0) {
                                 break;
                              }
                           }

                           if(var66 != null) {
                              var90 = var9?var66.t():var66.u();
                           }
                        }

                        var10000 = this.ah;
                     }

                     if(var10000 && var61 != null) {
                        boolean var91 = var61.x();
                        var58 = var91?var56:var54;
                     }

                     double var92 = Double.MAX_VALUE;
                     double var68 = 0.0D;
                     if(this.ai && var61 != null) {
                        var68 = this.f(var30);
                     }

                     boolean var70 = true;
                     y.c.d var71 = var30.f();

                     while(true) {
                        if(var71 == null) {
                           if(!var70) {
                              break;
                           }

                           var102 = var30.b();
                           if(var89 != 0) {
                              break label677;
                           }

                           if(var102 <= 0) {
                              break;
                           }

                           var70 = false;
                           var71 = var30.g();
                        }

                        var31 = var71.a(var30);
                        int var72 = this.aJ.a(var31);
                        ao var73 = (ao)this.C.b(var31);
                        boolean var74 = !this.F() || var73 == null;
                        if(!var74 && this.D()) {
                           var74 = var73.x() && !this.E() || !var73.x() && (!var8 && var73.t() >= var62 && var73.u() <= var16 || var8 && var73.u() <= var62 && var73.t() >= var14);
                        }

                        if(!var74 && this.E()) {
                           var74 = !var73.x() && !this.D() || var73.x() && (!var9 && var73.t() >= var90 && var73.u() <= var24 || var9 && var73.u() <= var90 && var73.t() >= var22);
                        }

                        if(var72 != 192 && var74) {
                           double var75 = 0.0D;
                           al var77 = null;
                           double var78 = var5.c(var71);
                           var75 = var33 + var78;
                           double var80 = this.aM.c(var71);
                           boolean var82;
                           double var83;
                           double var85;
                           if(this.ah && var61 != null && var73 != null) {
                              var82 = var61.x();
                              var83 = var82?var53.b:var53.a;
                              var85 = var82?var73.s():var73.r();
                              double var87 = var39 * (Math.abs(var83 - var85) / (2.0D * var58 + 1.0D));
                              var80 = var87;
                           }

                           if(this.ai && var61 != null && var73 != null) {
                              var82 = var61.x();
                              var83 = var82?var73.l.b - var73.k.b:var73.l.a - var73.k.a;
                              var85 = var41 * ((var68 - var83) / (2.0D * var68 + 1.0D));
                              var80 += var85;
                           }

                           if(this.aR) {
                              var77 = (al)this.C.b(var31);
                              if(var77 != null) {
                                 var80 += (double)var77.k();
                              }
                           }

                           var75 += var80;
                           this.aM.a(var71, var80);
                           switch(var72) {
                           case 0:
                              if(this.m()) {
                                 this.a(var31, var30, this.e, var2, var3, var5);
                              }

                              var28.a(var31, var75);
                              this.aK.a(var31, var75);
                              this.aJ.a(var31, 64);
                              this.aH.a(var31, var71);
                              if(var89 == 0) {
                                 break;
                              }
                           case 64:
                              if(var75 >= var28.a(var31)) {
                                 break;
                              }

                              var28.b(var31, var75);
                              this.aK.a(var31, var75);
                              this.aH.a(var31, var71);
                              if(var89 == 0) {
                                 break;
                              }
                           case 192:
                              if(var89 == 0) {
                                 break;
                              }
                           case 16:
                           case 144:
                              var82 = this.a(var30, var61, var31, var73, true, var8, var9);
                              if(var82) {
                                 this.aH.a(var31, var71);
                                 var83 = var75 + this.aL.c(var31);
                                 if(var83 < var47) {
                                    var32 = this.a(var2, var31, var3);
                                    var47 = var83;
                                 }
                              }
                           }
                        }

                        var71 = var70?var71.g():var71.h();
                        if(var89 != 0) {
                           break label676;
                        }
                     }
                  }

                  var102 = var44;
               }

               int var46 = var102;

               label546: {
                  label545:
                  while(!var29.c() && var46 == 0) {
                     var46 = 1;
                     var35 = var29.b();
                     if(var35 + var33 > var47) {
                        var44 = 1;
                        if(var89 == 0) {
                           break;
                        }
                     }

                     label539: {
                        var30 = (y.c.q)var29.a();
                        this.aJ.a(var30, 144);
                        var61 = (ao)this.C.b(var30);
                        var62 = var8?var14:var16;
                        if(this.D() && var61 != null && var61.x()) {
                           var64 = var61;
                           var65 = var30;

                           while(var64 != null) {
                              var10000 = var64.x();
                              if(var89 != 0) {
                                 break label539;
                              }

                              if(!var10000) {
                                 break;
                              }

                              var65 = ((y.c.d)this.aI.b(var65)).a(var65);
                              var64 = var65 == null?null:(ao)this.C.b(var65);
                              if(var89 != 0) {
                                 break;
                              }
                           }

                           if(var64 != null) {
                              var62 = var8?var64.u():var64.t();
                           }
                        }

                        var10000 = var9;
                     }

                     label520: {
                        var90 = var10000?var22:var24;
                        if(this.E() && var61 != null && !var61.x()) {
                           var66 = var61;
                           var67 = var30;

                           while(var66 != null) {
                              var10000 = var66.x();
                              if(var89 != 0) {
                                 break label520;
                              }

                              if(var10000) {
                                 break;
                              }

                              var67 = ((y.c.d)this.aI.b(var67)).a(var67);
                              var66 = var67 == null?null:(ao)this.C.b(var67);
                              if(var89 != 0) {
                                 break;
                              }
                           }

                           if(var66 != null) {
                              var90 = var9?var66.u():var66.t();
                           }
                        }

                        var10000 = this.ah;
                     }

                     if(var10000 && var61 != null) {
                        boolean var93 = var61.x();
                        var58 = var93?var56:var54;
                     }

                     double var94 = Double.MAX_VALUE;
                     double var69 = 0.0D;
                     if(this.ai && var61 != null) {
                        var69 = this.f(var30);
                     }

                     boolean var95 = true;
                     y.c.d var96 = var30.f();

                     while(true) {
                        if(var96 == null) {
                           if(!var95) {
                              break;
                           }

                           var102 = var30.b();
                           if(var89 != 0) {
                              break label546;
                           }

                           if(var102 <= 0) {
                              break;
                           }

                           var95 = false;
                           var96 = var30.g();
                        }

                        var31 = var96.a(var30);
                        int var97 = this.aJ.a(var31);
                        ao var98 = (ao)this.C.b(var31);
                        boolean var99 = !this.F() || var98 == null;
                        if(!var99 && this.D()) {
                           var99 = var98.x() && !this.E() || !var98.x() && (!var8 && var98.u() <= var62 && var98.t() >= var10 || var8 && var98.t() >= var62 && var98.u() <= var12);
                        }

                        if(!var99 && this.E()) {
                           var99 = !var98.x() && !this.D() || var98.x() && (!var9 && var98.u() <= var90 && var98.t() >= var18 || var9 && var98.t() >= var90 && var98.u() <= var20);
                        }

                        if(var97 != 144 && var99) {
                           double var76 = 0.0D;
                           al var100 = null;
                           var76 = var35 + var5.c(var96);
                           double var79 = this.aM.c(var96);
                           boolean var81;
                           double var84;
                           double var101;
                           if(this.ah && var61 != null && var98 != null) {
                              var81 = var61.x();
                              var101 = var81?var53.b:var53.a;
                              var84 = var81?var98.s():var98.r();
                              double var86 = var39 * (Math.abs(var101 - var84) / (2.0D * var58 + 1.0D));
                              var79 = var86;
                           }

                           if(this.ai && var61 != null && var98 != null) {
                              var81 = var61.x();
                              var101 = var81?var98.l.b - var98.k.b:var98.l.a - var98.k.a;
                              var84 = var41 * ((var69 - var101) / (2.0D * var69 + 1.0D));
                              var79 += var84;
                           }

                           if(this.aR) {
                              var100 = (al)this.C.b(var31);
                              if(var100 != null) {
                                 var79 += (double)var100.k();
                              }
                           }

                           var76 += var79;
                           this.aM.a(var96, var79);
                           switch(var97) {
                           case 0:
                              if(this.m()) {
                                 this.a(var31, var30, this.e, var2, var3, var5);
                              }

                              var29.a(var31, var76);
                              this.aL.a(var31, var76);
                              this.aJ.a(var31, 16);
                              this.aI.a(var31, var96);
                              if(var89 == 0) {
                                 break;
                              }
                           case 16:
                              if(var76 >= var29.a(var31)) {
                                 break;
                              }

                              var29.b(var31, var76);
                              this.aL.a(var31, var76);
                              this.aI.a(var31, var96);
                              if(var89 == 0) {
                                 break;
                              }
                           case 144:
                              if(var89 == 0) {
                                 break;
                              }
                           case 64:
                           case 192:
                              var81 = this.a(var30, var61, var31, var98, false, var8, var9);
                              if(var81) {
                                 this.aI.a(var31, var96);
                                 var101 = var76 + this.aK.c(var31);
                                 if(var101 < var47) {
                                    var32 = this.a(var2, var31, var3);
                                    var47 = var101;
                                 }
                              }
                           }
                        }

                        var96 = var95?var96.g():var96.h();
                        if(var89 != 0) {
                           break label545;
                        }
                     }
                  }

                  var102 = var28.c();
               }

               var43 = var102 != 0 && var29.c() || var44 != 0;
               if(var89 == 0) {
                  continue;
               }
            }

            if(var32 == null) {
               var32 = new y.c.f();
            }

            var10000 = this.m();
            break;
         }

         if(var10000) {
            this.a(var32, this.e);
            this.a(var1, this.e);
         }

         return var32;
      }
   }

   private boolean a(y.c.q var1, ao var2, y.c.q var3, ao var4, boolean var5, boolean var6, boolean var7) {
      int var17 = f;
      if(this.F() && var4 != null && var2 != null) {
         double var8;
         ao var10;
         y.c.q var11;
         y.c.d var12;
         ao var14;
         y.c.q var15;
         int var10000;
         y.c.d var16;
         double var18;
         boolean var19;
         boolean var20;
         label237: {
            if(this.D()) {
               var8 = Double.MAX_VALUE;
               var10 = var5?var2:var4;
               var11 = var5?var1:var3;

               label245: {
                  while(var10 != null) {
                     var10000 = var10.x();
                     if(var17 != 0) {
                        break label245;
                     }

                     if(var10000 == 0) {
                        break;
                     }

                     var12 = (y.c.d)this.aH.b(var11);
                     var11 = var12 == null?null:var12.a(var11);
                     var10 = var11 == null?null:(ao)this.C.b(var11);
                     if(var17 != 0) {
                        break;
                     }
                  }

                  if(var10 != null) {
                     var8 = var6?var10.t():var10.u();
                  }

                  double var21;
                  var10000 = (var21 = var8 - Double.MAX_VALUE) == 0.0D?0:(var21 < 0.0D?-1:1);
               }

               if(var10000 != 0) {
                  var14 = var5?var4:var2;
                  var15 = var5?var3:var1;

                  while(var14 != null) {
                     var20 = var14.x();
                     if(var17 != 0) {
                        break label237;
                     }

                     if(!var20) {
                        break;
                     }

                     var16 = (y.c.d)this.aI.b(var15);
                     var15 = var16 == null?null:var16.a(var15);
                     var14 = var15 == null?null:(ao)this.C.b(var15);
                     if(var17 != 0) {
                        break;
                     }
                  }

                  if(var14 != null && var14 != var10) {
                     var18 = var6?var14.u():var14.t();
                     var19 = var6?var18 < var8:var18 > var8;
                     if(!var19) {
                        return false;
                     }
                  }
               }
            }

            var20 = this.E();
         }

         if(var20) {
            var8 = Double.MAX_VALUE;
            var10 = var5?var2:var4;
            var11 = var5?var1:var3;

            label251: {
               while(var10 != null) {
                  var10000 = var10.x();
                  if(var17 != 0) {
                     break label251;
                  }

                  if(var10000 != 0) {
                     break;
                  }

                  var12 = (y.c.d)this.aH.b(var11);
                  var11 = var12 == null?null:var12.a(var11);
                  var10 = var11 == null?null:(ao)this.C.b(var11);
                  if(var17 != 0) {
                     break;
                  }
               }

               if(var10 != null) {
                  var8 = var7?var10.t():var10.u();
               }

               double var22;
               var10000 = (var22 = var8 - Double.MAX_VALUE) == 0.0D?0:(var22 < 0.0D?-1:1);
            }

            if(var10000 != 0) {
               var14 = var5?var4:var2;
               var15 = var5?var3:var1;

               while(var14 != null) {
                  var20 = var14.x();
                  if(var17 != 0) {
                     return var20;
                  }

                  if(var20) {
                     break;
                  }

                  var16 = (y.c.d)this.aI.b(var15);
                  var15 = var16 == null?null:var16.a(var15);
                  var14 = var15 == null?null:(ao)this.C.b(var15);
                  if(var17 != 0) {
                     break;
                  }
               }

               if(var14 != null && var14 != var10) {
                  var18 = var7?var14.u():var14.t();
                  var19 = var7?var18 < var8:var18 > var8;
                  if(!var19) {
                     return false;
                  }
               }
            }
         }

         var20 = true;
         return var20;
      } else {
         return true;
      }
   }

   public void a(double var1) {
      this.aE = var1;
   }

   public double k() {
      return this.aE;
   }

   public void c(boolean var1) {
      this.aG = var1;
   }

   public boolean l() {
      return this.aG;
   }

   boolean m() {
      return this.aE > 0.0D;
   }

   boolean a(y.c.d var1, y.c.c var2) {
      Object var3 = var2.b(var1.c());
      Object var4 = var2.b(var1.d());
      return var3 != null && var3 == var4;
   }

   void a(y.c.i var1, y.c.A var2) {
      int var10 = f;
      y.c.d[] var3 = this.a(2 * this.g.g());
      y.c.x var4 = var1.o();

      label90:
      while(true) {
         boolean var10000 = var4.f();

         label87:
         while(var10000) {
            y.c.q var5 = var4.e();
            y.c.q var6 = (y.c.q)var2.b(var5);
            if(var10 != 0) {
               break label90;
            }

            label84: {
               if(var6 != null && var6 != var5) {
                  int var7 = 0;
                  y.c.d var8 = var5.g();

                  label72: {
                     while(var8 != null) {
                        var3[var7++] = var8;
                        var8 = var8.h();
                        if(var10 != 0) {
                           break label72;
                        }

                        if(var10 != 0) {
                           break;
                        }
                     }

                     var8 = var5.f();
                  }

                  while(var8 != null) {
                     var3[var7++] = var8;
                     var8 = var8.g();
                     if(var10 != 0) {
                        break label84;
                     }

                     if(var10 != 0) {
                        break;
                     }
                  }

                  int var11 = 0;

                  while(var11 < var7) {
                     y.c.d var9 = var3[var11];
                     var10000 = this.a((y.c.d)var9, (y.c.c)var2);
                     if(var10 != 0) {
                        continue label87;
                     }

                     if(!var10000) {
                        label101: {
                           if(var9.c() == var5) {
                              var1.a(var9, var6, var9.d());
                              if(var10 == 0) {
                                 break label101;
                              }
                           }

                           var1.a(var9, var9.c(), var6);
                        }
                     }

                     ++var11;
                     if(var10 != 0) {
                        break;
                     }
                  }

                  this.d.a(var5);
               }

               var4.g();
            }

            if(var10 == 0) {
               continue label90;
            }
            break;
         }

         var4 = var1.o();
         break;
      }

      while(var4.f()) {
         var2.a(var4.e(), (Object)null);
         var4.g();
         if(var10 != 0) {
            break;
         }
      }

   }

   void a(y.c.f var1, y.c.A var2) {
      int var7 = f;
      y.c.p var3 = var1.k();

      while(var3 != null) {
         y.c.d var4 = (y.c.d)var3.c();
         y.c.q var5 = (y.c.q)var2.b(var4.c());
         y.c.q var6 = (y.c.q)var2.b(var4.d());
         if(var5 != null && var5 == var6) {
            var1.h(var3);
         }

         var3 = var3.a();
         if(var7 != 0) {
            break;
         }
      }

   }

   void a(y.c.q var1, y.c.q var2, y.c.A var3, y.c.q var4, y.c.q var5, y.c.h var6) {
      int var32 = f;
      ao var7 = (ao)this.C.b(var1);
      ao var8 = (ao)this.C.b(var2);
      if(var7 != null && var3.b(var1) == null) {
         y var9 = new y(this, var1, var4, var7);
         y.c.d[] var10 = this.a(var1.a());
         int var11 = 0;
         y.c.d var12 = var1.g();

         while(true) {
            if(var12 != null) {
               var10[var11++] = var12;
               var12 = var12.h();
               if(var32 != 0) {
                  break;
               }

               if(var32 == 0) {
                  continue;
               }
            }

            var12 = var1.f();
            break;
         }

         while(true) {
            if(var12 != null) {
               var10[var11++] = var12;
               var12 = var12.g();
               if(var32 != 0) {
                  break;
               }

               if(var32 == 0) {
                  continue;
               }
            }

            y.g.e.a(var10, 0, var11, var9);
            break;
         }

         var12 = null;
         y.c.q var13 = null;
         Object var14 = null;
         int var15 = 0;
         boolean var16 = false;
         int var17 = this.s.g();
         int var18 = this.s.e();
         int var19 = 0;

         while(var19 < var11) {
            y.c.d var20 = var10[var19];
            y.c.q var21 = var20.a(var1);
            ao var22 = (ao)this.C.b(var21);
            ao var23 = null;
            y.c.q var24 = null;
            boolean var25 = var19 == var11 - 1;
            y.c.q var26;
            if(!var25) {
               var24 = var10[var19 + 1].a(var1);
               var23 = (ao)this.C.b(var24);
               if(var23 != null && var22 != null && var23.t() - var22.u() > 0.01D) {
                  var25 = true;
               }

               if(var23 != null && var23.n && var7.t() < (double)var23.p && var7.u() > (double)var23.o) {
                  var26 = (y.c.q)this.c.get(var23);
                  if(var26 != null && var26 != this.u && var26 != this.v) {
                     var25 = true;
                  }
               }
            }

            y.c.q var10000 = var21;
            y.c.q var34 = var2;

            label92:
            while(true) {
               if(var10000 == var34) {
                  var16 = true;
               }

               if(!var25) {
                  break;
               }

               var26 = null;
               y.c.d var27;
               if(!var16) {
                  var26 = this.d.a();
                  this.C.a(var26, var7);
                  var3.a(var26, var1);
                  this.aJ.a(var26, 0);
                  this.aK.a(var26, Double.POSITIVE_INFINITY);
                  this.aL.a(var26, Double.POSITIVE_INFINITY);

                  label87:
                  while(true) {
                     do {
                        if(var15 > var19) {
                           break label87;
                        }

                        var27 = var10[var15++];
                        y.c.q var28 = var27.d();
                        y.c.q var29 = var27.c();
                        ao var33 = (ao)this.C.b(var27.d());
                        var33 = (ao)this.C.b(var27.c());
                        var10000 = var27.c();
                        var34 = var1;
                        if(var32 != 0) {
                           continue label92;
                        }

                        if(var10000 != var1) {
                           break;
                        }

                        this.s.a(var27, var26, var27.d());
                     } while(var32 == 0);

                     this.s.a(var27, var27.c(), var26);
                  }
               } else {
                  var26 = var1;
                  var3.a(var1, var1);
               }

               var15 = var19 + 1;
               if(var13 != null) {
                  var27 = this.d.a(var13, var26);
                  var6.a(var27, this.aE);
               }

               var13 = var26;
               var16 = false;
               break;
            }

            ++var19;
            if(var32 != 0) {
               break;
            }
         }

      }
   }

   void n() {
      int var6 = f;
      y.c.f var1 = this.o();
      if(!var1.isEmpty()) {
         y.c.h var2 = this.g.u();
         Object var3 = var1.a();

         Object var9;
         label80: {
            boolean var10000;
            y.c.d var4;
            while(true) {
               if(((y.c.e)var3).f()) {
                  var4 = ((y.c.e)var3).a();
                  var2.a(var4, true);
                  var10000 = this.au;
                  if(var6 != 0) {
                     break;
                  }

                  if(var10000 && !this.ax.d(var4)) {
                     this.b(var4, this.g);
                  }

                  ((y.c.e)var3).g();
                  if(var6 == 0) {
                     continue;
                  }
               }

               var3 = this.g.p();
               var10000 = ((y.c.e)var3).f();
               break;
            }

            while(var10000) {
               var4 = ((y.c.e)var3).a();
               var9 = var2;
               if(var6 != 0) {
                  break label80;
               }

               label65: {
                  if(var2.d(var4)) {
                     y.c.e var5 = null;
                     if(this.b(var4.c())) {
                        var5 = var4.c().j();
                     } else if(this.b(var4.d())) {
                        var5 = var4.d().j();
                     }

                     if(var5 != null) {
                        while(var5.f()) {
                           var2.a(var5.a(), true);
                           var5.g();
                           if(var6 != 0) {
                              break label65;
                           }

                           if(var6 != 0) {
                              break;
                           }
                        }
                     }
                  }

                  ((y.c.e)var3).g();
               }

               if(var6 != 0) {
                  break;
               }

               var10000 = ((y.c.e)var3).f();
            }

            var3 = this.c();
            var9 = this.g.c(var3);
         }

         Object var7 = var9;
         byte var8 = this.h;
         this.h = 2;
         this.g.a((Object)var3, (y.c.c)var2);
         this.h();
         this.g();
         this.i();
         this.K();
         this.h = var8;
         this.g.d_(var3);
         if(var7 != null) {
            this.g.a((Object)var3, (y.c.c)var7);
         }

         this.g.a((y.c.h)var2);
      }
   }

   int a(y.c.h var1) {
      int var7 = f;
      int var2 = 0;
      y.c.c var3 = this.g.c(this.b());
      y.c.c var4 = this.g.c(this.c());
      y.c.e var5 = this.g.p();

      int var10000;
      while(true) {
         if(var5.f()) {
            var10000 = this.h;
            if(var7 != 0) {
               break;
            }

            label45: {
               if(var10000 == 2) {
                  if(!var4.d(var5.a())) {
                     break label45;
                  }

                  var1.a(var5.a(), true);
                  ++var2;
                  if(var7 == 0) {
                     break label45;
                  }
               }

               if(this.h == 4) {
                  y.c.d var6 = var5.a();
                  if(!var3.d(var6.c()) && !var3.d(var6.d()) || var1.d(var6)) {
                     break label45;
                  }

                  var1.a(var6, true);
                  ++var2;
                  if(var7 == 0) {
                     break label45;
                  }
               }

               var1.a(var5.a(), true);
               ++var2;
            }

            var5.g();
            if(var7 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   y.c.f o() {
      int var29 = f;
      int[] var1 = new int[this.g.g()];
      y.c.h var2 = y.g.M.b(new boolean[this.g.g()]);
      int var3 = this.a(var2);
      y.c.d[] var4 = new y.c.d[var3];
      y.c.e var5 = this.g.p();

      while(var5.f()) {
         if(var2.d(var5.a())) {
            --var3;
            var4[var3] = var5.a();
         }

         var5.g();
         if(var29 != 0) {
            break;
         }
      }

      ArrayList var30 = new ArrayList(this.g.g());
      ArrayList var6 = new ArrayList(this.g.g());
      int var7 = 0;

      int var10000;
      label168:
      do {
         var10000 = var7;

         label165:
         while(true) {
            if(var10000 >= var4.length) {
               break label168;
            }

            y.c.d var8;
            y.c.D var9;
            y.d.t var10;
            y.d.t var11;
            y.f.am var12;
            label183: {
               var8 = var4[var7];
               var9 = this.g.m(var8);
               var10 = (y.d.t)var9.j();
               var11 = (y.d.t)var9.i();
               var12 = this.g.h(var8.d());
               if(var11.a < var12.getX()) {
                  var10 = new y.d.t(var12.getX(), var10.b);
                  if(var29 == 0) {
                     break label183;
                  }
               }

               if(var11.a > var12.getX() + var12.getWidth()) {
                  var10 = new y.d.t(var12.getX() + var12.getWidth(), var10.b);
                  if(var29 == 0) {
                     break label183;
                  }
               }

               if(var11.b < var12.getY()) {
                  var10 = new y.d.t(var10.a, var12.getY());
                  if(var29 == 0) {
                     break label183;
                  }
               }

               if(var11.b > var12.getY() + var12.getHeight()) {
                  var10 = new y.d.t(var10.a, var12.getY() + var12.getHeight());
               }
            }

            label184: {
               var9.add(var10);
               var10 = (y.d.t)var9.g();
               var11 = (y.d.t)var9.f();
               var12 = this.g.h(var8.c());
               if(var11.a < var12.getX()) {
                  var10 = new y.d.t(var12.getX(), var10.b);
                  if(var29 == 0) {
                     break label184;
                  }
               }

               if(var11.a > var12.getX() + var12.getWidth()) {
                  var10 = new y.d.t(var12.getX() + var12.getWidth(), var10.b);
                  if(var29 == 0) {
                     break label184;
                  }
               }

               if(var11.b < var12.getY()) {
                  var10 = new y.d.t(var10.a, var12.getY());
                  if(var29 == 0) {
                     break label184;
                  }
               }

               if(var11.b > var12.getY() + var12.getHeight()) {
                  var10 = new y.d.t(var10.a, var12.getY() + var12.getHeight());
               }
            }

            while(true) {
               if(var9.isEmpty()) {
                  break label165;
               }

               var11 = (y.d.t)var9.g();
               C var13 = new C(var10, var11, var8);
               double var41;
               var10000 = (var41 = Math.abs(var10.a - var11.a) - 0.01D) == 0.0D?0:(var41 < 0.0D?-1:1);
               if(var29 != 0) {
                  break;
               }

               label160: {
                  if(var10000 < 0) {
                     var30.add(var13);
                     if(var29 == 0) {
                        break label160;
                     }
                  }

                  var6.add(var13);
               }

               var10 = var11;
               if(var29 != 0) {
                  break label165;
               }
            }
         }

         ++var7;
      } while(var29 == 0);

      z var31 = new z(this);
      y.g.e.a((List)var6, var31);
      C var32 = new C((y.d.t)null, (y.d.t)null, (y.c.d)null);
      C var33 = new C((y.d.t)null, (y.d.t)null, (y.c.d)null);
      int var40 = 0;
      int var34 = 0;

      label124:
      while(true) {
         var10000 = var34;

         label121:
         while(var10000 < var30.size()) {
            C var35 = (C)var30.get(var34);
            int var38 = ((ae)this.E.b(var35.c)).a;
            double var14 = var35.a.a;
            if(var29 != 0) {
               break label124;
            }

            double var16;
            double var18;
            label118: {
               if(var35.a.b < var35.b.b) {
                  var16 = var35.a.b;
                  var18 = var35.b.b;
                  var32.a = var35.a;
                  var33.a = var35.b;
                  if(var29 == 0) {
                     break label118;
                  }
               }

               var16 = var35.b.b;
               var18 = var35.a.b;
               var32.a = var35.b;
               var33.a = var35.a;
            }

            int var20 = Collections.binarySearch(var6, var32, var31);
            if(var20 < 0) {
               var20 = -var20 - 1;
            }

            int var21 = Collections.binarySearch(var6, var33, var31);
            if(var21 < 0) {
               var21 = -var21 - 1;
            }

            int var22 = var20;

            while(var22 < var21) {
               C var23 = (C)var6.get(var22);
               double var42;
               var10000 = (var42 = var23.a.b - var16) == 0.0D?0:(var42 < 0.0D?-1:1);
               if(var29 != 0) {
                  continue label121;
               }

               if(var10000 > 0 && var23.a.b < var18) {
                  double var24 = var23.a.a;
                  double var26 = var23.b.a;
                  if(var24 > var26) {
                     var26 = var23.a.a;
                     var24 = var23.b.a;
                  }

                  if(var24 < var14 && var26 > var14) {
                     label104: {
                        ++var40;
                        int var28 = ((ae)this.E.b(var23.c)).a;
                        if(var38 > var28) {
                           ++var1[var23.c.b()];
                           if(var29 == 0) {
                              break label104;
                           }
                        }

                        if(var38 < var28) {
                           ++var1[var35.c.b()];
                        }
                     }
                  }
               }

               ++var22;
               if(var29 != 0) {
                  break;
               }
            }

            ++var34;
            if(var29 == 0) {
               continue label124;
            }
            break;
         }

         y.g.e.a((Object[])var4, new A(this, var1));
         break;
      }

      y.c.f var36 = new y.c.f();
      double var37 = Math.max(0.1D * (double)this.g.g(), 5.0D);
      int var39 = 0;

      while(var39 < var4.length) {
         y.c.d var15 = var4[var39];
         if(var1[var15.b()] == 0 || (double)var36.size() > var37) {
            break;
         }

         var36.add(var15);
         ++var39;
         if(var29 != 0) {
            break;
         }
      }

      return var36;
   }

   private double f(y.c.q var1) {
      int var10 = f;
      double var2 = 0.0D;
      ao var4 = (ao)this.C.b(var1);
      boolean var5 = var4.x();
      y.c.d var8 = var1.f();

      boolean var10000;
      double var6;
      ao var9;
      while(true) {
         if(var8 != null) {
            var10000 = var8.e();
            if(var10 != 0) {
               break;
            }

            if(!var10000) {
               var9 = (ao)this.C.b(var8.a(var1));
               if(var9 != null) {
                  var6 = var5?var9.l.b - var9.k.b:var9.l.a - var9.k.a;
                  if(var6 > var2) {
                     var2 = var6;
                  }
               }
            }

            var8 = var8.g();
            if(var10 == 0) {
               continue;
            }

            var8 = var1.g();
         } else {
            var8 = var1.g();
         }

         if(var8 == null) {
            return var2;
         }

         var10000 = var8.e();
         break;
      }

      while(true) {
         if(!var10000) {
            var9 = (ao)this.C.b(var8.a(var1));
            if(var9 != null) {
               var6 = var5?var9.l.b - var9.k.b:var9.l.a - var9.k.a;
               if(var6 > var2) {
                  var2 = var6;
               }
            }
         }

         var8 = var8.h();
         if(var10 != 0 || var8 == null) {
            return var2;
         }

         var10000 = var8.e();
      }
   }

   private y.c.f a(y.c.q var1, y.c.q var2, y.c.q var3) {
      int var7 = f;
      y.c.f var6 = new y.c.f();
      y.c.q var4 = var2;

      y.c.d var5;
      while(true) {
         if(var4 != var1) {
            var5 = (y.c.d)this.aH.b(var4);
            var6.add(var5);
            var4 = var5.a(var4);
            if(var7 != 0) {
               break;
            }

            if(var7 == 0) {
               continue;
            }
         }

         var6.n();
         break;
      }

      var4 = var2;

      y.c.f var10000;
      while(true) {
         if(var4 != var3) {
            var5 = (y.c.d)this.aI.b(var4);
            var10000 = var6;
            if(var7 != 0) {
               break;
            }

            var6.add(var5);
            var4 = var5.a(var4);
            if(var7 == 0) {
               continue;
            }
         }

         var10000 = var6;
         break;
      }

      return var10000;
   }

   private ao a(y.c.q var1, double var2, byte var4) {
      int var18 = f;
      boolean var13 = false;
      ao var15 = null;
      aJ var16 = (aJ)this.z.b(var1);
      y.c.D var5 = null;
      y.c.D var6 = null;
      double var7 = 0.0D;
      double var11 = 0.0D;
      switch(var4) {
      case 1:
         var5 = var16.a;
         var6 = var16.b;
         var7 = this.g.n(var1);
         break;
      case 2:
         var5 = var16.c;
         var6 = var16.d;
         var7 = this.g.n(var1);
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         break;
      case 4:
         var5 = var16.g;
         var6 = var16.h;
         var7 = this.g.m(var1);
         break;
      case 8:
         var5 = var16.e;
         var6 = var16.f;
         var7 = this.g.m(var1);
      }

      y.c.C var17 = var5.m();

      ao var14;
      boolean var10000;
      while(true) {
         if(var17.f()) {
            var10000 = var13;
            if(var18 != 0) {
               break;
            }

            if(!var13) {
               var14 = (ao)var17.d();
               if(var2 >= var14.t() && var2 <= var14.u()) {
                  var15 = var14;
                  var13 = true;
               }

               var17.g();
               if(var18 == 0) {
                  continue;
               }
            }
         }

         var11 = Double.MAX_VALUE;
         var10000 = var13;
         break;
      }

      ao var19;
      if(!var10000) {
         var17 = var6.m();

         while(var17.f()) {
            var19 = (ao)var17.d();
            if(var18 != 0) {
               return var19;
            }

            var14 = var19;
            if(var2 >= var14.t() && var2 <= var14.u() && Math.abs(var7 - var14.v()) <= var11) {
               var11 = Math.abs(var7 - var14.v());
               var15 = var14;
            }

            var17.g();
            if(var18 != 0) {
               break;
            }
         }
      }

      var19 = var15;
      return var19;
   }

   private y.c.D a(double var1, double var3, boolean var5) {
      int var16 = f;
      y.c.D var7 = null;
      double var8 = var5?this.n.a:this.n.b;
      int var6 = (int)Math.floor((var1 - var8) / (double)this.p);
      double var10 = (double)(var6 * this.p) + var8;
      if(var10 < var1) {
         var10 += (double)this.p;
      }

      var6 = (int)Math.floor((var3 - var8) / (double)this.p);
      double var12 = (double)(var6 * this.p) + var8;
      if(var12 >= var3) {
         var12 -= (double)this.p;
      }

      y.c.D var10000;
      if(var10 >= var1 && var12 < var3) {
         var7 = new y.c.D();
         double var14 = var10;

         while(var14 <= var12) {
            var10000 = var7;
            if(var16 != 0) {
               return var10000;
            }

            var7.add(new Double(var14));
            var14 += (double)this.p;
            if(var16 != 0) {
               break;
            }
         }
      }

      var10000 = var7;
      return var10000;
   }

   private y.c.D a(ao var1) {
      return this.a(var1.t(), var1.u(), var1.x());
   }

   private int b(ao var1) {
      int var12 = f;
      int var2 = 0;
      al var3 = (al)var1;
      int var10000;
      if(var3.m()) {
         y.c.D var4 = this.a((ao)var3);
         if(var4 != null) {
            y.c.D var5 = var3.l();
            y.c.C var6 = var5.m();

            label43:
            do {
               var10000 = var6.f();

               label40:
               while(true) {
                  if(var10000 == 0) {
                     break label43;
                  }

                  var10000 = var4.isEmpty();
                  if(var12 != 0) {
                     return var10000;
                  }

                  if(var10000 != 0) {
                     break label43;
                  }

                  double var7 = ((am)var6.d()).b;
                  y.c.C var9 = var4.m();

                  while(true) {
                     if(!var9.f()) {
                        break label40;
                     }

                     double var10 = ((Double)var9.d()).doubleValue();
                     double var13;
                     var10000 = (var13 = Math.abs(var7 - var10) - 0.5D) == 0.0D?0:(var13 < 0.0D?-1:1);
                     if(var12 != 0) {
                        break;
                     }

                     if(var10000 <= 0) {
                        var4.b(var9);
                        ++var2;
                     }

                     var9.g();
                     if(var12 != 0) {
                        break label40;
                     }
                  }
               }

               var6.g();
            } while(var12 == 0);
         }
      }

      var10000 = var2;
      return var10000;
   }

   private int a(double var1, double var3) {
      int var5 = 0;
      double var6 = var1 / (double)this.p;
      var6 = Math.floor(var6);
      if(var1 - var6 * (double)this.p == 0.0D) {
         ++var5;
      }

      double var8 = var3 / (double)this.p;
      var8 = Math.floor(var8);
      if(var3 - var8 * (double)this.p == 0.0D) {
         --var5;
      }

      int var10 = (int)(var8 - var6) + var5;
      return var10;
   }

   private boolean a(y.c.D var1, boolean var2, boolean var3) {
      int var12 = f;
      if(var1.isEmpty()) {
         return false;
      } else {
         ao var5 = (ao)var1.f();
         if(var5.n) {
            var2 = true;
         }

         var5 = (ao)var1.i();
         if(var5.n) {
            var3 = true;
         }

         boolean var8 = true;
         y.c.q var4;
         int var6;
         int var7;
         if(this.i) {
            var6 = var2?1:0;
            var7 = var1.size() - (var3?1:0);

            do {
               if(var6 >= var7) {
                  return var8;
               }

               var5 = (ao)var1.a(var6);
               if(var5 != null) {
                  var4 = (y.c.q)this.B.b(var5);
                  int var9 = this.a(var5.t(), var5.u());
                  var9 -= this.b(var5);
                  if(var9 < 1) {
                     y.c.e var10 = var4.j();

                     while(true) {
                        if(var10.f()) {
                           this.A.a(var10.a(), 100.0D);
                           var10.g();
                           if(var12 != 0) {
                              break;
                           }

                           if(var12 == 0) {
                              continue;
                           }
                        }

                        if(this.aa) {
                           this.F.a(var4, true);
                        }
                        break;
                     }

                     var8 = false;
                  }
               }

               ++var6;
            } while(var12 == 0);
         }

         double var13 = 2.0D * this.r;
         var6 = var2?1:0;
         var7 = var1.size() - (var3?1:0);

         while(var6 < var7) {
            var5 = (ao)var1.a(var6);
            if(var5 != null) {
               var4 = (y.c.q)this.B.b(var5);
               if(var5.p() < var13) {
                  label158: {
                     y.c.e var11;
                     if(var5.p() < this.r + 1.0D) {
                        var11 = var4.j();

                        label144: {
                           while(var11.f()) {
                              this.A.a(var11.a(), 100.0D);
                              var11.g();
                              if(var12 != 0) {
                                 break label144;
                              }

                              if(var12 != 0) {
                                 break;
                              }
                           }

                           if(this.aa) {
                              this.F.a(var4, true);
                           }

                           var8 = false;
                        }

                        if(var12 == 0) {
                           break label158;
                        }
                     }

                     if(!this.a(var1, var13, var6)) {
                        var11 = var4.j();

                        while(true) {
                           if(var11.f()) {
                              this.A.a(var11.a(), 100.0D);
                              var11.g();
                              if(var12 != 0) {
                                 break;
                              }

                              if(var12 == 0) {
                                 continue;
                              }
                           }

                           if(this.aa) {
                              this.F.a(var4, true);
                           }
                           break;
                        }

                        var8 = false;
                     }
                  }
               }
            }

            ++var6;
            if(var12 != 0) {
               break;
            }
         }

         return var8;
      }
   }

   private boolean a(y.c.D var1, double var2, int var4) {
      int var24 = f;
      boolean var9 = false;
      boolean var10 = false;
      al var11 = null;
      al var12 = null;
      al var13 = (al)var1.a(var4);
      if(var4 > 0) {
         var11 = (al)var1.a(var4 - 1);
      } else {
         label179: {
            if(var13.x()) {
               var9 = this.g.k(this.u) < var13.s();
               if(var24 == 0) {
                  break label179;
               }
            }

            var9 = this.g.j(this.u) < var13.r();
         }
      }

      if(var4 < var1.size() - 1) {
         var12 = (al)var1.a(var4 + 1);
      } else {
         label180: {
            if(var13.x()) {
               var10 = this.g.k(this.v) < var13.s();
               if(var24 == 0) {
                  break label180;
               }
            }

            var10 = this.g.j(this.v) < var13.r();
         }
      }

      double var5;
      double var7;
      label181: {
         if(var11 == null && var12 == null) {
            if(var13.x()) {
               var5 = var13.k.b;
               var7 = var13.l.b;
               if(var24 == 0) {
                  break label181;
               }
            }

            var5 = var13.k.a;
            var7 = var13.l.a;
            if(var24 == 0) {
               break label181;
            }
         }

         if(var11 == null) {
            if(var9) {
               var5 = var13.x()?var13.k.b:var13.k.a;
               if(var12.x()) {
                  var7 = Math.max(var12.k.a, var12.l.a);
                  if(var24 == 0) {
                     break label181;
                  }
               }

               var7 = Math.max(var12.k.b, var12.l.b);
               if(var24 == 0) {
                  break label181;
               }
            }

            var7 = var13.x()?var13.l.b:var13.l.a;
            if(var12.x()) {
               var5 = Math.min(var12.k.a, var12.l.a);
               if(var24 == 0) {
                  break label181;
               }
            }

            var5 = Math.min(var12.k.b, var12.l.b);
            if(var24 == 0) {
               break label181;
            }
         }

         if(var12 == null) {
            if(var10) {
               var5 = var13.x()?var13.k.b:var13.k.a;
               if(var11.x()) {
                  var7 = Math.max(var11.k.a, var11.l.a);
                  if(var24 == 0) {
                     break label181;
                  }
               }

               var7 = Math.max(var11.k.b, var11.l.b);
               if(var24 == 0) {
                  break label181;
               }
            }

            var7 = var13.x()?var13.l.b:var13.l.a;
            if(var11.x()) {
               var5 = Math.min(var11.k.a, var11.l.a);
               if(var24 == 0) {
                  break label181;
               }
            }

            var5 = Math.min(var11.k.b, var11.l.b);
            if(var24 == 0) {
               break label181;
            }
         }

         if(var13.x()) {
            var5 = Math.min(var11.k.b, var12.k.b);
            var7 = Math.max(var11.l.b, var12.l.b);
            if(var24 == 0) {
               break label181;
            }
         }

         var5 = Math.min(var11.k.a, var12.k.a);
         var7 = Math.max(var11.l.a, var12.l.a);
      }

      boolean var14 = false;
      double var15 = var2 - var13.p();
      double[] var17 = new double[]{var5, var7};
      y.c.D var18 = new y.c.D();
      var14 = this.a(var13, true, var17, var18);
      double var19 = 0.0D;
      if(var14) {
         var19 = this.c(var18);
      }

      var17[0] = var5;
      var17[1] = var7;
      y.c.D var21 = new y.c.D();
      var14 = this.a(var13, false, var17, var21);
      double var22 = 0.0D;
      if(var14) {
         var22 = this.c(var21);
      }

      if(var19 + var22 < var15) {
         var13.d(false);
         return false;
      } else {
         var13.d(true);
         var13.c(var17[0]);
         var13.d(var17[1]);
         if(var19 < var15 && var22 < var15) {
            label111: {
               if(var19 < var22) {
                  var13.a(var13.t() - var19);
                  var13.b(var13.u() + (var15 - var19));
                  if(var24 == 0) {
                     break label111;
                  }
               }

               var13.a(var13.t() - (var15 - var22));
               var13.b(var13.u() + var22);
            }

            var13.a(var18);
            var13.b(var21);
            if(var24 == 0) {
               return true;
            }
         }

         if(var19 < var15) {
            var13.a(var13.t() - var19);
            var13.b(var13.u() + (var15 - var19));
            var13.a(var18);
            var13.b(var21);
            if(var24 == 0) {
               return true;
            }
         }

         if(var22 < var15) {
            var13.a(var13.t() - (var15 - var22));
            var13.b(var13.u() + var22);
            var13.a(var18);
            var13.b(var21);
            if(var24 == 0) {
               return true;
            }
         }

         if(var19 < var22) {
            var13.a(var13.t() - var15);
            var13.b(var13.u());
            var13.a(var18);
            if(var24 == 0) {
               return true;
            }
         }

         var13.a(var13.t());
         var13.b(var13.u() + var15);
         var13.b(var21);
         return true;
      }
   }

   private boolean a(al var1, boolean var2, double[] var3, y.c.D var4) {
      int var18 = f;
      y.c.D var5 = var2?var1.b:var1.c;
      double var6 = 0.0D;
      double var8 = var3[1];
      double var10 = var3[0];
      y.c.C var12 = var5.m();

      int var10000;
      while(true) {
         if(var12.f()) {
            al var13 = (al)var12.d();
            double var14 = var13.v();
            double var16 = var13.w();
            double var19;
            var10000 = (var19 = var16 - var3[0]) == 0.0D?0:(var19 < 0.0D?-1:1);
            if(var18 != 0) {
               break;
            }

            if(var10000 > 0 && var14 < var3[1]) {
               var4.add(var13);
               if(var14 < var8) {
                  var8 = var14;
               }

               if(var16 > var10) {
                  var10 = var16;
               }

               var6 += var16 - var14;
            }

            var12.g();
            if(var18 == 0) {
               continue;
            }
         }

         double var20;
         var10000 = (var20 = var8 - var3[0]) == 0.0D?0:(var20 < 0.0D?-1:1);
         break;
      }

      return var10000 <= 0 && var10 >= var3[1]?var6 >= Math.abs(var10 - var8):false;
   }

   private double c(y.c.D var1) {
      int var8 = f;
      if(var1.isEmpty()) {
         return 0.0D;
      } else {
         double var2 = Double.POSITIVE_INFINITY;
         y.c.C var4 = var1.m();

         double var10000;
         while(true) {
            if(var4.f()) {
               al var5 = (al)var4.d();
               double var6 = var5.p();
               var10000 = var6;
               if(var8 != 0) {
                  break;
               }

               if(var6 < var2) {
                  var2 = var6;
               }

               var4.g();
               if(var8 == 0) {
                  continue;
               }
            }

            var10000 = var2;
            break;
         }

         return var10000;
      }
   }

   private void N() {
      int var7 = f;
      this.A.a(1.0D);
      y.c.d var1;
      ao var2;
      ao var3;
      if(this.i) {
         y.c.e var4 = this.s.p();

         do {
            if(!var4.f()) {
               return;
            }

            label54: {
               var1 = var4.a();
               var2 = (ao)this.C.b(var1.c());
               var3 = (ao)this.C.b(var1.d());
               int var5 = this.a(var2.t(), var2.u());
               int var6 = this.a(var3.t(), var3.u());
               if(var5 < 1) {
                  this.A.a(var1, 100.0D);
                  if(!this.aa) {
                     break label54;
                  }

                  this.F.a(var1.c(), true);
                  if(var7 == 0) {
                     break label54;
                  }
               }

               if(var6 < 1) {
                  this.A.a(var1, 100.0D);
                  if(this.aa) {
                     this.F.a(var1.d(), true);
                  }
               }
            }

            var4.g();
         } while(var7 == 0);
      }

      double var8 = this.r + 1.0D;
      y.c.e var9 = this.s.p();

      while(var9.f()) {
         label40: {
            var1 = var9.a();
            var2 = (ao)this.C.b(var1.c());
            var3 = (ao)this.C.b(var1.d());
            if(var2.p() < var8 && !var2.n) {
               this.A.a(var1, 100.0D);
               if(!this.aa) {
                  break label40;
               }

               this.F.a(var1.c(), true);
               if(var7 == 0) {
                  break label40;
               }
            }

            if(var3.p() < var8 && !var3.n) {
               this.A.a(var1, 100.0D);
               if(this.aa) {
                  this.F.a(var1.d(), true);
               }
            }
         }

         var9.g();
         if(var7 != 0) {
            break;
         }
      }

   }

   private void O() {
      int var8 = f;
      if(this.i) {
         y.c.x var1 = this.s.o();

         label73:
         do {
            if(!var1.f()) {
               return;
            }

            y.c.q var2 = var1.e();
            if(this.F.d(var2)) {
               ao var3 = (ao)this.C.b(var2);
               int var4 = this.a(var3.t(), var3.u());
               if(var4 >= 1) {
                  y.c.e var5 = var2.j();

                  while(var5.f()) {
                     y.c.d var6 = var5.a();
                     this.A.a(var6, 1.0D);
                     var5.g();
                     if(var8 != 0) {
                        continue label73;
                     }

                     if(var8 != 0) {
                        break;
                     }
                  }

                  this.F.a(var2, false);
               }
            }

            var1.g();
         } while(var8 == 0);
      }

      double var9 = this.r + 1.0D;
      y.c.x var10 = this.s.o();

      while(var10.f()) {
         label49: {
            y.c.q var11 = var10.e();
            if(this.F.d(var11)) {
               ao var12 = (ao)this.C.b(var11);
               if(var12.p() >= var9 || !var12.n) {
                  y.c.e var13 = var11.j();

                  while(var13.f()) {
                     y.c.d var7 = var13.a();
                     this.A.a(var7, 1.0D);
                     var13.g();
                     if(var8 != 0) {
                        break label49;
                     }

                     if(var8 != 0) {
                        break;
                     }
                  }

                  this.F.a(var11, false);
               }
            }

            var10.g();
         }

         if(var8 != 0) {
            break;
         }
      }

   }

   private void a(y.c.f var1, y.c.q var2, y.c.q var3, y.c.d var4, double var5, double var7) {
      int var22 = f;
      y.d.t var9 = this.g.l(var2);
      y.c.f[] var10 = new y.c.f[4];
      int var11 = 0;

      while(var11 < 4) {
         var10[var11] = new y.c.f();
         ++var11;
         if(var22 != 0) {
            break;
         }
      }

      y.c.e var23 = var1.a();

      byte var10000;
      while(true) {
         if(var23.f()) {
            y.c.d var12 = var23.a();
            ao var13 = (ao)this.C.b(var12.a(var3));
            var10000 = var13.x();
            if(var22 != 0) {
               break;
            }

            label1177: {
               if(var10000 != 0) {
                  if(var13.s() < var9.b) {
                     var10[0].add(var12);
                     if(var22 == 0) {
                        break label1177;
                     }
                  }

                  var10[1].add(var12);
                  if(var22 == 0) {
                     break label1177;
                  }
               }

               if(var13.r() < var9.a) {
                  var10[2].add(var12);
                  if(var22 == 0) {
                     break label1177;
                  }
               }

               var10[3].add(var12);
            }

            var23.g();
            if(var22 == 0) {
               continue;
            }
         }

         var10000 = 4;
         break;
      }

      y.c.d[] var24 = new y.c.d[var10000];
      int var25 = 0;

      label1144:
      while(true) {
         ao var14;
         y.c.e var26;
         y.c.d var28;
         if(var25 < 4) {
            double var27 = Double.POSITIVE_INFINITY;
            y.c.e var29 = var10[var25].a();
            if(var22 != 0) {
               var26 = var29;

               while(true) {
                  if(!var26.f()) {
                     break label1144;
                  }

                  var28 = var26.a();
                  var14 = (ao)this.C.b(var28.a(var3));
                  if(var22 != 0) {
                     return;
                  }

                  if(var14.n) {
                     label1232: {
                        if(var4.d() == var2) {
                           this.A.a(var28, 0.0D);
                           if(var22 == 0) {
                              break label1232;
                           }
                        }

                        if(var4.c() == var2) {
                           this.A.a(var28, 0.5D);
                        }
                     }
                  }

                  var26.g();
                  if(var22 != 0) {
                     break label1144;
                  }
               }
            }

            y.c.e var15 = var29;

            label1139:
            while(true) {
               y.c.d var16;
               ao var17;
               double var18;
               double var20;
               boolean var30;
               if(var15.f()) {
                  var16 = var15.a();
                  var17 = (ao)this.C.b(var16.a(var3));
                  var30 = var17.x();
                  if(var22 == 0) {
                     if(var30) {
                        if(var9.a >= var17.k.a) {
                           if(var9.a <= var17.l.a) {
                              var24[var25] = var16;
                              if(var22 != 0) {
                                 var18 = Math.abs(var9.a - var17.k.a);
                                 var20 = Math.abs(var9.a - var17.l.a);
                                 if(var18 < var27) {
                                    var24[var25] = var16;
                                    var27 = var18;
                                 }

                                 if(var20 < var27) {
                                    var24[var25] = var16;
                                    var27 = var20;
                                    if(var22 != 0) {
                                       if(var9.b >= var17.k.b) {
                                          if(var9.b <= var17.l.b) {
                                             var24[var25] = var16;
                                             if(var22 != 0) {
                                                var18 = Math.abs(var9.b - var17.k.b);
                                                var20 = Math.abs(var9.b - var17.l.b);
                                                if(var18 < var27) {
                                                   var24[var25] = var16;
                                                   var27 = var18;
                                                }

                                                if(var20 < var27) {
                                                   var24[var25] = var16;
                                                   var27 = var20;
                                                }

                                                var15.g();
                                                if(var22 == 0) {
                                                   continue;
                                                }

                                                var15 = var10[var25].a();
                                                if(!var15.f()) {
                                                   break;
                                                }
                                             } else {
                                                var15 = var10[var25].a();
                                                if(!var15.f()) {
                                                   break;
                                                }
                                             }
                                          } else {
                                             var18 = Math.abs(var9.b - var17.k.b);
                                             var20 = Math.abs(var9.b - var17.l.b);
                                             if(var18 < var27) {
                                                var24[var25] = var16;
                                                var27 = var18;
                                             }

                                             if(var20 < var27) {
                                                var24[var25] = var16;
                                                var27 = var20;
                                             }

                                             var15.g();
                                             if(var22 == 0) {
                                                continue;
                                             }

                                             var15 = var10[var25].a();
                                             if(!var15.f()) {
                                                break;
                                             }
                                          }
                                       } else {
                                          var18 = Math.abs(var9.b - var17.k.b);
                                          var20 = Math.abs(var9.b - var17.l.b);
                                          if(var18 < var27) {
                                             var24[var25] = var16;
                                             var27 = var18;
                                          }

                                          if(var20 < var27) {
                                             var24[var25] = var16;
                                             var27 = var20;
                                          }

                                          var15.g();
                                          if(var22 == 0) {
                                             continue;
                                          }

                                          var15 = var10[var25].a();
                                          if(!var15.f()) {
                                             break;
                                          }
                                       }
                                    } else {
                                       var15.g();
                                       if(var22 == 0) {
                                          continue;
                                       }

                                       var15 = var10[var25].a();
                                       if(!var15.f()) {
                                          break;
                                       }
                                    }
                                 } else {
                                    var15.g();
                                    if(var22 == 0) {
                                       continue;
                                    }

                                    var15 = var10[var25].a();
                                    if(!var15.f()) {
                                       break;
                                    }
                                 }
                              } else {
                                 var15 = var10[var25].a();
                                 if(!var15.f()) {
                                    break;
                                 }
                              }
                           } else {
                              var18 = Math.abs(var9.a - var17.k.a);
                              var20 = Math.abs(var9.a - var17.l.a);
                              if(var18 < var27) {
                                 var24[var25] = var16;
                                 var27 = var18;
                              }

                              if(var20 < var27) {
                                 var24[var25] = var16;
                                 var27 = var20;
                                 if(var22 != 0) {
                                    if(var9.b >= var17.k.b) {
                                       if(var9.b <= var17.l.b) {
                                          var24[var25] = var16;
                                          if(var22 != 0) {
                                             var18 = Math.abs(var9.b - var17.k.b);
                                             var20 = Math.abs(var9.b - var17.l.b);
                                             if(var18 < var27) {
                                                var24[var25] = var16;
                                                var27 = var18;
                                             }

                                             if(var20 < var27) {
                                                var24[var25] = var16;
                                                var27 = var20;
                                             }

                                             var15.g();
                                             if(var22 == 0) {
                                                continue;
                                             }

                                             var15 = var10[var25].a();
                                             if(!var15.f()) {
                                                break;
                                             }
                                          } else {
                                             var15 = var10[var25].a();
                                             if(!var15.f()) {
                                                break;
                                             }
                                          }
                                       } else {
                                          var18 = Math.abs(var9.b - var17.k.b);
                                          var20 = Math.abs(var9.b - var17.l.b);
                                          if(var18 < var27) {
                                             var24[var25] = var16;
                                             var27 = var18;
                                          }

                                          if(var20 < var27) {
                                             var24[var25] = var16;
                                             var27 = var20;
                                          }

                                          var15.g();
                                          if(var22 == 0) {
                                             continue;
                                          }

                                          var15 = var10[var25].a();
                                          if(!var15.f()) {
                                             break;
                                          }
                                       }
                                    } else {
                                       var18 = Math.abs(var9.b - var17.k.b);
                                       var20 = Math.abs(var9.b - var17.l.b);
                                       if(var18 < var27) {
                                          var24[var25] = var16;
                                          var27 = var18;
                                       }

                                       if(var20 < var27) {
                                          var24[var25] = var16;
                                          var27 = var20;
                                       }

                                       var15.g();
                                       if(var22 == 0) {
                                          continue;
                                       }

                                       var15 = var10[var25].a();
                                       if(!var15.f()) {
                                          break;
                                       }
                                    }
                                 } else {
                                    var15.g();
                                    if(var22 == 0) {
                                       continue;
                                    }

                                    var15 = var10[var25].a();
                                    if(!var15.f()) {
                                       break;
                                    }
                                 }
                              } else {
                                 var15.g();
                                 if(var22 == 0) {
                                    continue;
                                 }

                                 var15 = var10[var25].a();
                                 if(!var15.f()) {
                                    break;
                                 }
                              }
                           }
                        } else {
                           var18 = Math.abs(var9.a - var17.k.a);
                           var20 = Math.abs(var9.a - var17.l.a);
                           if(var18 < var27) {
                              var24[var25] = var16;
                              var27 = var18;
                           }

                           if(var20 < var27) {
                              var24[var25] = var16;
                              var27 = var20;
                              if(var22 != 0) {
                                 if(var9.b >= var17.k.b) {
                                    if(var9.b <= var17.l.b) {
                                       var24[var25] = var16;
                                       if(var22 != 0) {
                                          var18 = Math.abs(var9.b - var17.k.b);
                                          var20 = Math.abs(var9.b - var17.l.b);
                                          if(var18 < var27) {
                                             var24[var25] = var16;
                                             var27 = var18;
                                          }

                                          if(var20 < var27) {
                                             var24[var25] = var16;
                                             var27 = var20;
                                          }

                                          var15.g();
                                          if(var22 == 0) {
                                             continue;
                                          }

                                          var15 = var10[var25].a();
                                          if(!var15.f()) {
                                             break;
                                          }
                                       } else {
                                          var15 = var10[var25].a();
                                          if(!var15.f()) {
                                             break;
                                          }
                                       }
                                    } else {
                                       var18 = Math.abs(var9.b - var17.k.b);
                                       var20 = Math.abs(var9.b - var17.l.b);
                                       if(var18 < var27) {
                                          var24[var25] = var16;
                                          var27 = var18;
                                       }

                                       if(var20 < var27) {
                                          var24[var25] = var16;
                                          var27 = var20;
                                       }

                                       var15.g();
                                       if(var22 == 0) {
                                          continue;
                                       }

                                       var15 = var10[var25].a();
                                       if(!var15.f()) {
                                          break;
                                       }
                                    }
                                 } else {
                                    var18 = Math.abs(var9.b - var17.k.b);
                                    var20 = Math.abs(var9.b - var17.l.b);
                                    if(var18 < var27) {
                                       var24[var25] = var16;
                                       var27 = var18;
                                    }

                                    if(var20 < var27) {
                                       var24[var25] = var16;
                                       var27 = var20;
                                    }

                                    var15.g();
                                    if(var22 == 0) {
                                       continue;
                                    }

                                    var15 = var10[var25].a();
                                    if(!var15.f()) {
                                       break;
                                    }
                                 }
                              } else {
                                 var15.g();
                                 if(var22 == 0) {
                                    continue;
                                 }

                                 var15 = var10[var25].a();
                                 if(!var15.f()) {
                                    break;
                                 }
                              }
                           } else {
                              var15.g();
                              if(var22 == 0) {
                                 continue;
                              }

                              var15 = var10[var25].a();
                              if(!var15.f()) {
                                 break;
                              }
                           }
                        }
                     } else if(var9.b >= var17.k.b) {
                        if(var9.b <= var17.l.b) {
                           var24[var25] = var16;
                           if(var22 != 0) {
                              var18 = Math.abs(var9.b - var17.k.b);
                              var20 = Math.abs(var9.b - var17.l.b);
                              if(var18 < var27) {
                                 var24[var25] = var16;
                                 var27 = var18;
                              }

                              if(var20 < var27) {
                                 var24[var25] = var16;
                                 var27 = var20;
                              }

                              var15.g();
                              if(var22 == 0) {
                                 continue;
                              }

                              var15 = var10[var25].a();
                              if(!var15.f()) {
                                 break;
                              }
                           } else {
                              var15 = var10[var25].a();
                              if(!var15.f()) {
                                 break;
                              }
                           }
                        } else {
                           var18 = Math.abs(var9.b - var17.k.b);
                           var20 = Math.abs(var9.b - var17.l.b);
                           if(var18 < var27) {
                              var24[var25] = var16;
                              var27 = var18;
                           }

                           if(var20 < var27) {
                              var24[var25] = var16;
                              var27 = var20;
                           }

                           var15.g();
                           if(var22 == 0) {
                              continue;
                           }

                           var15 = var10[var25].a();
                           if(!var15.f()) {
                              break;
                           }
                        }
                     } else {
                        var18 = Math.abs(var9.b - var17.k.b);
                        var20 = Math.abs(var9.b - var17.l.b);
                        if(var18 < var27) {
                           var24[var25] = var16;
                           var27 = var18;
                        }

                        if(var20 < var27) {
                           var24[var25] = var16;
                           var27 = var20;
                        }

                        var15.g();
                        if(var22 == 0) {
                           continue;
                        }

                        var15 = var10[var25].a();
                        if(!var15.f()) {
                           break;
                        }
                     }
                  } else if(!var30) {
                     break;
                  }
               } else {
                  var15 = var10[var25].a();
                  if(!var15.f()) {
                     break;
                  }
               }

               while(true) {
                  while(true) {
                     var16 = var15.a();
                     if(var22 == 0) {
                        if(var16 == var24[var25]) {
                           this.A.a(var16, var5);
                           if(var22 != 0) {
                              this.A.a(var16, var5 + var7);
                           }
                        } else {
                           this.A.a(var16, var5 + var7);
                        }

                        var15.g();
                        if(var22 != 0 || !var15.f()) {
                           break label1139;
                        }
                     } else {
                        var17 = (ao)var16;
                        var30 = var17.x();
                        if(var22 == 0) {
                           if(var30) {
                              if(var9.a >= var17.k.a) {
                                 if(var9.a <= var17.l.a) {
                                    var24[var25] = var16;
                                    if(var22 != 0) {
                                       var18 = Math.abs(var9.a - var17.k.a);
                                       var20 = Math.abs(var9.a - var17.l.a);
                                       if(var18 < var27) {
                                          var24[var25] = var16;
                                          var27 = var18;
                                       }

                                       if(var20 < var27) {
                                          var24[var25] = var16;
                                          var27 = var20;
                                          if(var22 != 0) {
                                             if(var9.b >= var17.k.b) {
                                                if(var9.b <= var17.l.b) {
                                                   var24[var25] = var16;
                                                   if(var22 != 0) {
                                                      var18 = Math.abs(var9.b - var17.k.b);
                                                      var20 = Math.abs(var9.b - var17.l.b);
                                                      if(var18 < var27) {
                                                         var24[var25] = var16;
                                                         var27 = var18;
                                                      }

                                                      if(var20 < var27) {
                                                         var24[var25] = var16;
                                                         var27 = var20;
                                                      }

                                                      var15.g();
                                                      if(var22 == 0) {
                                                         continue label1139;
                                                      }

                                                      var15 = var10[var25].a();
                                                      if(!var15.f()) {
                                                         break label1139;
                                                      }
                                                   } else {
                                                      var15 = var10[var25].a();
                                                      if(!var15.f()) {
                                                         break label1139;
                                                      }
                                                   }
                                                } else {
                                                   var18 = Math.abs(var9.b - var17.k.b);
                                                   var20 = Math.abs(var9.b - var17.l.b);
                                                   if(var18 < var27) {
                                                      var24[var25] = var16;
                                                      var27 = var18;
                                                   }

                                                   if(var20 < var27) {
                                                      var24[var25] = var16;
                                                      var27 = var20;
                                                   }

                                                   var15.g();
                                                   if(var22 == 0) {
                                                      continue label1139;
                                                   }

                                                   var15 = var10[var25].a();
                                                   if(!var15.f()) {
                                                      break label1139;
                                                   }
                                                }
                                             } else {
                                                var18 = Math.abs(var9.b - var17.k.b);
                                                var20 = Math.abs(var9.b - var17.l.b);
                                                if(var18 < var27) {
                                                   var24[var25] = var16;
                                                   var27 = var18;
                                                }

                                                if(var20 < var27) {
                                                   var24[var25] = var16;
                                                   var27 = var20;
                                                }

                                                var15.g();
                                                if(var22 == 0) {
                                                   continue label1139;
                                                }

                                                var15 = var10[var25].a();
                                                if(!var15.f()) {
                                                   break label1139;
                                                }
                                             }
                                          } else {
                                             var15.g();
                                             if(var22 == 0) {
                                                continue label1139;
                                             }

                                             var15 = var10[var25].a();
                                             if(!var15.f()) {
                                                break label1139;
                                             }
                                          }
                                       } else {
                                          var15.g();
                                          if(var22 == 0) {
                                             continue label1139;
                                          }

                                          var15 = var10[var25].a();
                                          if(!var15.f()) {
                                             break label1139;
                                          }
                                       }
                                    } else {
                                       var15 = var10[var25].a();
                                       if(!var15.f()) {
                                          break label1139;
                                       }
                                    }
                                 } else {
                                    var18 = Math.abs(var9.a - var17.k.a);
                                    var20 = Math.abs(var9.a - var17.l.a);
                                    if(var18 < var27) {
                                       var24[var25] = var16;
                                       var27 = var18;
                                    }

                                    if(var20 < var27) {
                                       var24[var25] = var16;
                                       var27 = var20;
                                       if(var22 != 0) {
                                          if(var9.b >= var17.k.b) {
                                             if(var9.b <= var17.l.b) {
                                                var24[var25] = var16;
                                                if(var22 != 0) {
                                                   var18 = Math.abs(var9.b - var17.k.b);
                                                   var20 = Math.abs(var9.b - var17.l.b);
                                                   if(var18 < var27) {
                                                      var24[var25] = var16;
                                                      var27 = var18;
                                                   }

                                                   if(var20 < var27) {
                                                      var24[var25] = var16;
                                                      var27 = var20;
                                                   }

                                                   var15.g();
                                                   if(var22 == 0) {
                                                      continue label1139;
                                                   }

                                                   var15 = var10[var25].a();
                                                   if(!var15.f()) {
                                                      break label1139;
                                                   }
                                                } else {
                                                   var15 = var10[var25].a();
                                                   if(!var15.f()) {
                                                      break label1139;
                                                   }
                                                }
                                             } else {
                                                var18 = Math.abs(var9.b - var17.k.b);
                                                var20 = Math.abs(var9.b - var17.l.b);
                                                if(var18 < var27) {
                                                   var24[var25] = var16;
                                                   var27 = var18;
                                                }

                                                if(var20 < var27) {
                                                   var24[var25] = var16;
                                                   var27 = var20;
                                                }

                                                var15.g();
                                                if(var22 == 0) {
                                                   continue label1139;
                                                }

                                                var15 = var10[var25].a();
                                                if(!var15.f()) {
                                                   break label1139;
                                                }
                                             }
                                          } else {
                                             var18 = Math.abs(var9.b - var17.k.b);
                                             var20 = Math.abs(var9.b - var17.l.b);
                                             if(var18 < var27) {
                                                var24[var25] = var16;
                                                var27 = var18;
                                             }

                                             if(var20 < var27) {
                                                var24[var25] = var16;
                                                var27 = var20;
                                             }

                                             var15.g();
                                             if(var22 == 0) {
                                                continue label1139;
                                             }

                                             var15 = var10[var25].a();
                                             if(!var15.f()) {
                                                break label1139;
                                             }
                                          }
                                       } else {
                                          var15.g();
                                          if(var22 == 0) {
                                             continue label1139;
                                          }

                                          var15 = var10[var25].a();
                                          if(!var15.f()) {
                                             break label1139;
                                          }
                                       }
                                    } else {
                                       var15.g();
                                       if(var22 == 0) {
                                          continue label1139;
                                       }

                                       var15 = var10[var25].a();
                                       if(!var15.f()) {
                                          break label1139;
                                       }
                                    }
                                 }
                              } else {
                                 var18 = Math.abs(var9.a - var17.k.a);
                                 var20 = Math.abs(var9.a - var17.l.a);
                                 if(var18 < var27) {
                                    var24[var25] = var16;
                                    var27 = var18;
                                 }

                                 if(var20 < var27) {
                                    var24[var25] = var16;
                                    var27 = var20;
                                    if(var22 != 0) {
                                       if(var9.b >= var17.k.b) {
                                          if(var9.b <= var17.l.b) {
                                             var24[var25] = var16;
                                             if(var22 != 0) {
                                                var18 = Math.abs(var9.b - var17.k.b);
                                                var20 = Math.abs(var9.b - var17.l.b);
                                                if(var18 < var27) {
                                                   var24[var25] = var16;
                                                   var27 = var18;
                                                }

                                                if(var20 < var27) {
                                                   var24[var25] = var16;
                                                   var27 = var20;
                                                }

                                                var15.g();
                                                if(var22 == 0) {
                                                   continue label1139;
                                                }

                                                var15 = var10[var25].a();
                                                if(!var15.f()) {
                                                   break label1139;
                                                }
                                             } else {
                                                var15 = var10[var25].a();
                                                if(!var15.f()) {
                                                   break label1139;
                                                }
                                             }
                                          } else {
                                             var18 = Math.abs(var9.b - var17.k.b);
                                             var20 = Math.abs(var9.b - var17.l.b);
                                             if(var18 < var27) {
                                                var24[var25] = var16;
                                                var27 = var18;
                                             }

                                             if(var20 < var27) {
                                                var24[var25] = var16;
                                                var27 = var20;
                                             }

                                             var15.g();
                                             if(var22 == 0) {
                                                continue label1139;
                                             }

                                             var15 = var10[var25].a();
                                             if(!var15.f()) {
                                                break label1139;
                                             }
                                          }
                                       } else {
                                          var18 = Math.abs(var9.b - var17.k.b);
                                          var20 = Math.abs(var9.b - var17.l.b);
                                          if(var18 < var27) {
                                             var24[var25] = var16;
                                             var27 = var18;
                                          }

                                          if(var20 < var27) {
                                             var24[var25] = var16;
                                             var27 = var20;
                                          }

                                          var15.g();
                                          if(var22 == 0) {
                                             continue label1139;
                                          }

                                          var15 = var10[var25].a();
                                          if(!var15.f()) {
                                             break label1139;
                                          }
                                       }
                                    } else {
                                       var15.g();
                                       if(var22 == 0) {
                                          continue label1139;
                                       }

                                       var15 = var10[var25].a();
                                       if(!var15.f()) {
                                          break label1139;
                                       }
                                    }
                                 } else {
                                    var15.g();
                                    if(var22 == 0) {
                                       continue label1139;
                                    }

                                    var15 = var10[var25].a();
                                    if(!var15.f()) {
                                       break label1139;
                                    }
                                 }
                              }
                           } else if(var9.b >= var17.k.b) {
                              if(var9.b <= var17.l.b) {
                                 var24[var25] = var16;
                                 if(var22 != 0) {
                                    var18 = Math.abs(var9.b - var17.k.b);
                                    var20 = Math.abs(var9.b - var17.l.b);
                                    if(var18 < var27) {
                                       var24[var25] = var16;
                                       var27 = var18;
                                    }

                                    if(var20 < var27) {
                                       var24[var25] = var16;
                                       var27 = var20;
                                    }

                                    var15.g();
                                    if(var22 == 0) {
                                       continue label1139;
                                    }

                                    var15 = var10[var25].a();
                                    if(!var15.f()) {
                                       break label1139;
                                    }
                                 } else {
                                    var15 = var10[var25].a();
                                    if(!var15.f()) {
                                       break label1139;
                                    }
                                 }
                              } else {
                                 var18 = Math.abs(var9.b - var17.k.b);
                                 var20 = Math.abs(var9.b - var17.l.b);
                                 if(var18 < var27) {
                                    var24[var25] = var16;
                                    var27 = var18;
                                 }

                                 if(var20 < var27) {
                                    var24[var25] = var16;
                                    var27 = var20;
                                 }

                                 var15.g();
                                 if(var22 == 0) {
                                    continue label1139;
                                 }

                                 var15 = var10[var25].a();
                                 if(!var15.f()) {
                                    break label1139;
                                 }
                              }
                           } else {
                              var18 = Math.abs(var9.b - var17.k.b);
                              var20 = Math.abs(var9.b - var17.l.b);
                              if(var18 < var27) {
                                 var24[var25] = var16;
                                 var27 = var18;
                              }

                              if(var20 < var27) {
                                 var24[var25] = var16;
                                 var27 = var20;
                              }

                              var15.g();
                              if(var22 == 0) {
                                 continue label1139;
                              }

                              var15 = var10[var25].a();
                              if(!var15.f()) {
                                 break label1139;
                              }
                           }
                        } else if(!var30) {
                           break label1139;
                        }
                     }
                  }
               }
            }

            ++var25;
            if(var22 == 0) {
               continue;
            }
         }

         if(!this.b(var2)) {
            break;
         }

         var26 = var1.a();

         while(true) {
            if(!var26.f()) {
               break label1144;
            }

            var28 = var26.a();
            var14 = (ao)this.C.b(var28.a(var3));
            if(var22 != 0) {
               return;
            }

            if(var14.n) {
               label1233: {
                  if(var4.d() == var2) {
                     this.A.a(var28, 0.0D);
                     if(var22 == 0) {
                        break label1233;
                     }
                  }

                  if(var4.c() == var2) {
                     this.A.a(var28, 0.5D);
                  }
               }
            }

            var26.g();
            if(var22 != 0) {
               break label1144;
            }
         }
      }

      this.a(var1);
   }

   private void a(y.c.f var1, double var2) {
      int var6 = f;
      y.c.e var4 = var1.a();

      while(true) {
         if(var4.f()) {
            y.c.d var5 = var4.a();
            this.A.a(var5, var2);
            var4.g();
            if(var6 != 0) {
               break;
            }

            if(var6 == 0) {
               continue;
            }
         }

         this.a(var1);
         break;
      }

   }

   private void a(y.c.f var1) {
      int var5 = f;
      y.c.e var2 = var1.a();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         y.f.ax var4 = (y.f.ax)this.aq.get(var3);
         if(var4 != null) {
            this.A.a(var3, this.A.c(var3) + var4.f());
         }

         var2.g();
         if(var5 != 0) {
            break;
         }
      }

   }

   private void b(y.c.D var1, ao var2, byte var3) {
      int var7 = f;
      y.c.C var4 = var1.m();

      while(var4.f()) {
         y.c.q var5 = (y.c.q)var4.d();
         aJ var6 = (aJ)this.z.b(var5);
         switch(var3) {
         case 1:
            var6.a.add(var2);
            if(var7 == 0) {
               break;
            }
         case 2:
            var6.c.add(var2);
            if(var7 == 0) {
               break;
            }
         case 8:
            var6.e.add(var2);
            if(var7 == 0) {
               break;
            }
         case 4:
            var6.g.add(var2);
            if(var7 == 0) {
               break;
            }
         case 10:
            var6.b.add(var2);
            if(var7 == 0) {
               break;
            }
         case 20:
            var6.d.add(var2);
            if(var7 == 0) {
               break;
            }
         case 80:
            var6.f.add(var2);
            if(var7 == 0) {
               break;
            }
         case 40:
            var6.h.add(var2);
         }

         var4.g();
         if(var7 != 0) {
            break;
         }
      }

   }

   private void a(ao var1, ao var2, byte var3) {
      int var6 = f;
      aJ var4 = (aJ)this.y.b(var1);
      if(var4 != null) {
         aJ var5 = new aJ();
         switch(var3) {
         case 1:
            var5.a = var4.a;
            var5.b = var4.b;
            this.b((y.c.D)var4.a, var2, (byte)2);
            this.b((y.c.D)var4.b, var2, (byte)20);
            if(var6 == 0) {
               break;
            }
         case 2:
            var5.c = var4.c;
            var5.d = var4.d;
            this.b((y.c.D)var4.c, var2, (byte)1);
            this.b((y.c.D)var4.d, var2, (byte)10);
            if(var6 == 0) {
               break;
            }
         case 8:
            var5.e = var4.e;
            var5.f = var4.f;
            this.b((y.c.D)var4.e, var2, (byte)4);
            this.b((y.c.D)var4.f, var2, (byte)40);
            if(var6 == 0) {
               break;
            }
         case 4:
            var5.g = var4.g;
            var5.h = var4.h;
            this.b((y.c.D)var4.g, var2, (byte)8);
            this.b((y.c.D)var4.h, var2, (byte)80);
         case 3:
         case 5:
         case 6:
         case 7:
         }

         ((aF)this.y).a(var2, var5);
      }
   }

   private void b(ao var1, ao var2) {
      int var14 = f;
      y.c.q var3 = (y.c.q)this.B.b(var1);
      y.c.q var4 = this.s.d();
      this.C.a(var4, var2);
      this.B.a(var2, var4);
      double var5 = var2.t();
      double var7 = var2.u();
      y.c.e var9 = var3.j();

      while(var9.f()) {
         label24: {
            y.c.d var10 = var9.a();
            y.c.q var11 = var10.a(var3);
            ao var12 = (ao)this.C.b(var11);
            y.c.d var13;
            if(var12 != null) {
               if(var12.v() >= var7 || var12.w() <= var5) {
                  break label24;
               }

               var13 = this.s.a(var4, var11);
               this.A.a(var13, this.A.b(var10));
               if(var14 == 0) {
                  break label24;
               }
            }

            var13 = this.s.a(var4, var11);
            this.A.a(var13, this.A.b(var10));
         }

         var9.g();
         if(var14 != 0) {
            break;
         }
      }

   }

   private void a(ao var1, ao var2, boolean var3, boolean var4) {
      int var7 = f;
      aJ var5 = (aJ)this.y.b(var1);
      if(var5 != null) {
         aJ var6;
         label29: {
            var6 = new aJ();
            if(var3) {
               if(var4) {
                  var6.a = var5.a;
                  var6.b = var5.b;
                  this.b((y.c.D)var5.a, var2, (byte)2);
                  this.b((y.c.D)var5.b, var2, (byte)20);
                  if(var7 == 0) {
                     break label29;
                  }
               }

               var6.c = var5.c;
               var6.d = var5.d;
               this.b((y.c.D)var5.c, var2, (byte)1);
               this.b((y.c.D)var5.d, var2, (byte)10);
               if(var7 == 0) {
                  break label29;
               }
            }

            if(var4) {
               var6.e = var5.e;
               var6.f = var5.f;
               this.b((y.c.D)var5.e, var2, (byte)4);
               this.b((y.c.D)var5.f, var2, (byte)40);
               if(var7 == 0) {
                  break label29;
               }
            }

            var6.g = var5.g;
            var6.h = var5.h;
            this.b((y.c.D)var5.g, var2, (byte)8);
            this.b((y.c.D)var5.h, var2, (byte)80);
         }

         ((aF)this.y).a(var2, var6);
      }
   }

   private void a(ao var1, ao var2, boolean var3) {
      aJ var4 = (aJ)this.y.b(var1);
      if(var4 != null) {
         aJ var5;
         label14: {
            var5 = new aJ();
            if(var3) {
               var5.a = var4.a;
               var5.b = var4.b;
               this.b((y.c.D)var4.a, var2, (byte)2);
               this.b((y.c.D)var4.b, var2, (byte)20);
               var5.c = var4.c;
               var5.d = var4.d;
               this.b((y.c.D)var4.c, var2, (byte)1);
               this.b((y.c.D)var4.d, var2, (byte)10);
               if(f == 0) {
                  break label14;
               }
            }

            var5.e = var4.e;
            var5.f = var4.f;
            this.b((y.c.D)var4.e, var2, (byte)4);
            this.b((y.c.D)var4.f, var2, (byte)40);
            var5.g = var4.g;
            var5.h = var4.h;
            this.b((y.c.D)var4.g, var2, (byte)8);
            this.b((y.c.D)var4.h, var2, (byte)80);
         }

         ((aF)this.y).a(var2, var5);
      }
   }

   private void c(ao param1, ao param2) {
      // $FF: Couldn't be decompiled
   }

   private void b(ao param1, ao param2, byte param3) {
      // $FF: Couldn't be decompiled
   }

   private boolean a(double[] var1, boolean var2) {
      if(var1[1] <= var1[0]) {
         var1[1] = var1[0];
         return true;
      } else {
         if(var2) {
            if(this.i) {
               int var3 = this.a(var1[0], var1[1]);
               if(var3 < 1) {
                  var1[1] = var1[0];
                  return true;
               }
            } else if(var1[1] - var1[0] < 2.0D * this.r) {
               var1[1] = var1[0];
               return true;
            }
         }

         return false;
      }
   }

   private boolean b(double[] var1, boolean var2) {
      if(var1[2] >= var1[3]) {
         var1[2] = var1[3];
         return true;
      } else {
         if(var2) {
            if(this.i) {
               int var3 = this.a(var1[2], var1[3]);
               if(var3 < 1) {
                  var1[2] = var1[3];
                  return true;
               }
            } else if(var1[3] - var1[2] < 2.0D * this.r) {
               var1[2] = var1[3];
               return true;
            }
         }

         return false;
      }
   }

   private void a(al var1, y.c.D var2, boolean var3) {
      int var6 = f;
      y.c.C var4 = var2.m();

      while(var4.f()) {
         al var5 = (al)var4.d();
         if(var5.v() < var1.w() && var5.w() > var1.v()) {
            var1.a(var3, var5);
            var5.a(!var3, var1);
         }

         var4.g();
         if(var6 != 0) {
            break;
         }
      }

   }

   private void c(ao var1) {
      al var2;
      double var5;
      y.c.D var7;
      double[] var8;
      double[] var9;
      y.c.C var10;
      al var11;
      y.d.t var12;
      al var13;
      int var14;
      int var10000;
      label100: {
         var14 = f;
         var2 = (al)var1;
         double var3 = var2.t() - var2.g();
         var5 = var2.h() - var2.u();
         var7 = null;
         var8 = new double[4];
         var9 = new double[4];
         if(var3 > 0.0D) {
            if(var1.x()) {
               var10 = var2.i.m();

               while(var10.f()) {
                  var11 = (al)var10.d();
                  var7 = new y.c.D(var11.c);
                  var11.c(false, (al)null);
                  var11.e(false);
                  var12 = new y.d.t(var11.l.a - var3, var11.l.b);
                  var8[0] = var11.k.a;
                  var8[1] = var12.a;
                  var8[2] = var11.l.a;
                  var8[3] = var11.l.a;
                  var9[0] = var11.k.b;
                  var9[1] = var2.i();
                  var9[2] = var2.j();
                  var9[3] = var11.l.b;
                  double var15;
                  var10000 = (var15 = var11.v() - var2.i()) == 0.0D?0:(var15 < 0.0D?-1:1);
                  if(var14 != 0) {
                     break label100;
                  }

                  if(var10000 < 0) {
                     var13 = (al)this.a((ao)var11, (double[])var8, (double[])var9, true);
                     var11.a(false, var13);
                     var13.a(true, var11);
                     this.a(var13, var7, false);
                  }

                  if(var11.w() > var2.j()) {
                     var13 = (al)this.b(var11, var8, var9, true);
                     var11.a(false, var13);
                     var13.a(true, var11);
                     this.a(var13, var7, false);
                  }

                  var11.l = var12;
                  var10.g();
               }
            } else {
               var10 = var2.i.m();

               while(var10.f()) {
                  var11 = (al)var10.d();
                  var7 = new y.c.D(var11.c);
                  var11.c(false, (al)null);
                  var11.e(false);
                  var12 = new y.d.t(var11.l.a, var11.l.b - var3);
                  var9[0] = var11.k.b;
                  var9[1] = var12.b;
                  var9[2] = var11.l.b;
                  var9[3] = var11.l.b;
                  var8[0] = var11.k.a;
                  var8[1] = var2.i();
                  var8[2] = var2.j();
                  var8[3] = var11.l.a;
                  double var16;
                  var10000 = (var16 = var11.v() - var2.i()) == 0.0D?0:(var16 < 0.0D?-1:1);
                  if(var14 != 0) {
                     break label100;
                  }

                  if(var10000 < 0) {
                     var13 = (al)this.a((ao)var11, (double[])var8, (double[])var9, false);
                     var11.a(false, var13);
                     var13.a(true, var11);
                     this.a(var13, var7, false);
                  }

                  if(var11.w() > var2.j()) {
                     var13 = (al)this.b(var11, var8, var9, false);
                     var11.a(false, var13);
                     var13.a(true, var11);
                     this.a(var13, var7, false);
                  }

                  var11.l = var12;
                  var10.g();
                  if(var14 != 0) {
                     break;
                  }
               }
            }
         }

         double var17;
         var10000 = (var17 = var5 - 0.0D) == 0.0D?0:(var17 < 0.0D?-1:1);
      }

      if(var10000 > 0) {
         label105: {
            if(var1.x()) {
               var10 = var2.j.m();

               do {
                  if(!var10.f()) {
                     break label105;
                  }

                  var11 = (al)var10.d();
                  var7 = new y.c.D(var11.b);
                  var11.c(true, (al)null);
                  var11.e(true);
                  var12 = new y.d.t(var11.k.a + var5, var11.k.b);
                  var8[0] = var11.k.a;
                  var8[1] = var11.k.a;
                  var8[2] = var12.a;
                  var8[3] = var11.l.a;
                  var9[0] = var11.k.b;
                  var9[1] = var2.i();
                  var9[2] = var2.j();
                  var9[3] = var11.l.b;
                  if(var14 != 0) {
                     return;
                  }

                  if(var11.v() < var2.i()) {
                     var13 = (al)this.a((ao)var11, (double[])var8, (double[])var9, true);
                     var11.a(true, var13);
                     var13.a(false, var11);
                     this.a(var13, var7, true);
                  }

                  if(var11.w() > var2.j()) {
                     var13 = (al)this.b(var11, var8, var9, true);
                     var11.a(true, var13);
                     var13.a(false, var11);
                     this.a(var13, var7, true);
                  }

                  var11.k = var12;
                  var10.g();
               } while(var14 == 0);
            }

            var10 = var2.j.m();

            while(var10.f()) {
               var11 = (al)var10.d();
               var7 = new y.c.D(var11.b);
               var11.c(true, (al)null);
               var11.e(true);
               var12 = new y.d.t(var11.k.a, var11.k.b + var5);
               var9[0] = var11.k.b;
               var9[1] = var11.k.b;
               var9[2] = var12.b;
               var9[3] = var11.l.b;
               var8[0] = var11.k.a;
               var8[1] = var2.i();
               var8[2] = var2.j();
               var8[3] = var11.l.a;
               if(var14 != 0) {
                  return;
               }

               if(var11.v() < var2.i()) {
                  var13 = (al)this.a((ao)var11, (double[])var8, (double[])var9, false);
                  var11.a(true, var13);
                  var13.a(false, var11);
                  this.a(var13, var7, true);
               }

               if(var11.w() > var2.j()) {
                  var13 = (al)this.b(var11, var8, var9, false);
                  var11.a(true, var13);
                  var13.a(false, var11);
                  this.a(var13, var7, true);
               }

               var11.k = var12;
               var10.g();
               if(var14 != 0) {
                  break;
               }
            }
         }
      }

      this.a((y.c.q)this.B.b(var1));
   }

   private void a(ao var1, y.d.t var2, y.d.t var3) {
      int var22 = f;
      if(var2.a != var3.a) {
         throw new IllegalArgumentException("Segment is not vertical.");
      } else {
         double[] var4 = new double[4];
         double[] var5 = new double[4];
         y.c.q var18 = (y.c.q)this.B.b(var1);
         double var6 = Math.min(var2.b, var3.b);
         double var8 = Math.max(var2.b, var3.b);
         double var16 = this.P();
         var5[0] = var1.k.b;
         var5[1] = var6 - var16;
         boolean var10 = this.a(var5, true);
         var5[2] = var8 + var16;
         var5[3] = var1.l.b;
         boolean var11 = this.b(var5, true);
         var4[0] = var1.k.a;
         var4[1] = var2.a - var16;
         boolean var12 = this.a(var4, false);
         var4[2] = var2.a + var16;
         var4[3] = var1.l.a;
         boolean var13 = this.b(var4, false);
         al var19 = null;
         y.c.D var20 = null;
         y.d.t var14;
         al var21;
         if(!var12 && !var13) {
            var19 = new al(var4[0], var5[0], var4[1], var5[3], true);
            this.c(var1, var19);
            this.a((ao)var1, (ao)var19, true);
            this.b((ao)var1, (ao)var19);
            var21 = (al)var1;
            var21.c(true, var19);
            var19.a(true, var21.b);
            var14 = new y.d.t(var4[2], var5[0]);
            var1.k = var14;
         } else if(!var12) {
            var21 = (al)var1;
            var20 = new y.c.D(var21.c);
            var21.c(false, (al)null);
            var21.e(false);
            y.d.t var15 = new y.d.t(var4[1], var5[3]);
            var1.l = var15;
         } else {
            var21 = (al)var1;
            var20 = new y.c.D(var21.b);
            var21.c(true, (al)null);
            var21.e(true);
            var14 = new y.d.t(var4[2], var5[0]);
            var1.k = var14;
         }

         if(!var10) {
            label58: {
               var21 = (al)this.a(var1, var4, var5, true);
               if(!var12 && !var13) {
                  var19.a(false, var21);
                  var21.a(true, var19);
                  var21.a(false, (al)var1);
                  ((al)var1).a(true, var21);
                  if(var22 == 0) {
                     break label58;
                  }
               }

               if(!var12) {
                  ((al)var1).a(false, var21);
                  var21.a(true, (al)var1);
                  this.b(var21, var20, false);
                  if(var22 == 0) {
                     break label58;
                  }
               }

               ((al)var1).a(true, var21);
               var21.a(false, (al)var1);
               this.b(var21, var20, true);
            }
         }

         if(!var11) {
            label59: {
               var21 = (al)this.b(var1, var4, var5, true);
               if(!var12 && !var13) {
                  var19.a(false, var21);
                  var21.a(true, var19);
                  var21.a(false, (al)var1);
                  ((al)var1).a(true, var21);
                  if(var22 == 0) {
                     break label59;
                  }
               }

               if(!var12) {
                  ((al)var1).a(false, var21);
                  var21.a(true, (al)var1);
                  this.b(var21, var20, false);
                  if(var22 == 0) {
                     break label59;
                  }
               }

               ((al)var1).a(true, var21);
               var21.a(false, (al)var1);
               this.b(var21, var20, true);
            }
         }

         this.a((y.c.q)this.B.b(var1));
      }
   }

   private void b(al var1, y.c.D var2, boolean var3) {
      int var6 = f;
      y.c.C var4 = var2.m();

      while(var4.f()) {
         al var5 = (al)var4.d();
         if(var5.v() < var1.w() && var5.w() > var1.v()) {
            var1.a(var3, var5);
         }

         var4.g();
         if(var6 != 0) {
            break;
         }
      }

   }

   private void b(ao var1, y.d.t var2, y.d.t var3) {
      int var22 = f;
      if(var2.b != var3.b) {
         throw new IllegalArgumentException("Segment is not horizontal.");
      } else {
         double[] var4;
         double[] var5;
         double var6;
         double var8;
         double var16;
         label62: {
            var4 = new double[4];
            var5 = new double[4];
            y.c.q var18 = (y.c.q)this.B.b(var1);
            var6 = Math.min(var2.a, var3.a);
            var8 = Math.max(var2.a, var3.a);
            if(this.i) {
               var16 = (double)this.p / 2.0D;
               if(var22 == 0) {
                  break label62;
               }
            }

            var16 = this.r;
         }

         var4[0] = var1.k.a;
         var4[1] = var6 - var16;
         boolean var10 = this.a(var4, true);
         var4[2] = var8 + var16;
         var4[3] = var1.l.a;
         boolean var11 = this.b(var4, true);
         var5[0] = var1.k.b;
         var5[1] = var2.b - var16;
         boolean var12 = this.a(var5, false);
         var5[2] = var2.b + var16;
         var5[3] = var1.l.b;
         boolean var13 = this.b(var5, false);
         al var19 = null;
         y.c.D var20 = null;
         y.d.t var14;
         al var21;
         if(!var12 && !var13) {
            var19 = new al(var4[0], var5[0], var4[3], var5[1], false);
            this.c(var1, var19);
            this.a((ao)var1, (ao)var19, false);
            this.b((ao)var1, (ao)var19);
            var21 = (al)var1;
            var21.c(true, var19);
            var19.a(true, var21.b);
            var14 = new y.d.t(var4[0], var5[2]);
            var1.k = var14;
         } else if(!var12) {
            var21 = (al)var1;
            var20 = new y.c.D(var21.c);
            var21.c(false, (al)null);
            var21.e(false);
            y.d.t var15 = new y.d.t(var4[3], var5[1]);
            var1.l = var15;
         } else {
            var21 = (al)var1;
            var20 = new y.c.D(var21.b);
            var21.c(true, (al)null);
            var21.e(true);
            var14 = new y.d.t(var4[0], var5[2]);
            var1.k = var14;
         }

         if(!var10) {
            label66: {
               var21 = (al)this.a(var1, var4, var5, false);
               if(!var12 && !var13) {
                  var19.a(false, var21);
                  var21.a(true, var19);
                  var21.a(false, (al)var1);
                  ((al)var1).a(true, var21);
                  if(var22 == 0) {
                     break label66;
                  }
               }

               if(!var12) {
                  ((al)var1).a(false, var21);
                  var21.a(true, (al)var1);
                  this.b(var21, var20, false);
                  if(var22 == 0) {
                     break label66;
                  }
               }

               ((al)var1).a(true, var21);
               var21.a(false, (al)var1);
               this.b(var21, var20, true);
            }
         }

         if(!var11) {
            label67: {
               var21 = (al)this.b(var1, var4, var5, false);
               if(!var12 && !var13) {
                  var19.a(false, var21);
                  var21.a(true, var19);
                  var21.a(false, (al)var1);
                  ((al)var1).a(true, var21);
                  if(var22 == 0) {
                     break label67;
                  }
               }

               if(!var12) {
                  ((al)var1).a(false, var21);
                  var21.a(true, (al)var1);
                  this.b(var21, var20, false);
                  if(var22 == 0) {
                     break label67;
                  }
               }

               ((al)var1).a(true, var21);
               var21.a(false, (al)var1);
               this.b(var21, var20, true);
            }
         }

         this.a((y.c.q)this.B.b(var1));
      }
   }

   void a(y.c.q var1) {
      int var7 = f;
      if(var1 != null) {
         ao var2 = (ao)this.C.b(var1);
         if(var2 != null) {
            java.awt.geom.Rectangle2D.Double var3 = new java.awt.geom.Rectangle2D.Double(var2.k.a, var2.k.b, var2.l.a - var2.k.a, var2.l.b - var2.k.b);
            y.c.e var4 = var1.j();

            while(var4.f()) {
               y.c.q var5 = var4.a().a(var1);
               ao var6 = (ao)this.C.b(var5);
               if(var6 != null && !var3.intersects(var6.k.a, var6.k.b, var6.l.a - var6.k.a, var6.l.b - var6.k.b)) {
                  var1.e().a(var4.a());
               }

               var4.g();
               if(var7 != 0) {
                  break;
               }
            }
         }

      }
   }

   private ao a(ao var1, double[] var2, double[] var3, boolean var4) {
      double[] var5;
      double[] var6;
      byte var7;
      al var8;
      int var16;
      label52: {
         var16 = f;
         var5 = new double[4];
         var6 = new double[2];
         var8 = null;
         if(var4) {
            var5[0] = var3[0];
            var5[1] = var3[1];
            var7 = 1;
            if(var16 == 0) {
               break label52;
            }
         }

         var5[0] = var2[0];
         var5[1] = var2[1];
         var7 = 8;
      }

      y.c.q var9 = (y.c.q)this.B.b(var1);
      if(var5[1] > var5[0]) {
         if(var4) {
            var8 = new al(var2[1], var3[0], var2[2], var3[1], true);
            this.b((ao)var1, var8, var7);
         } else {
            var8 = new al(var2[0], var3[1], var2[1], var3[2], false);
            this.b((ao)var1, var8, var7);
         }

         y.c.q var10 = this.s.d();
         this.C.a(var10, var8);
         this.B.a(var8, var10);
         y.c.e var11 = var9.j();

         while(var11.f()) {
            y.c.d var12 = var11.a();
            y.c.q var13 = var12.a(var9);
            ao var14 = (ao)this.C.b(var13);
            if(var16 != 0) {
               return var8;
            }

            if(var14 != null) {
               label39: {
                  if(var4) {
                     var6[0] = var14.k.b;
                     var6[1] = var14.l.b;
                     if(var16 == 0) {
                        break label39;
                     }
                  }

                  var6[0] = var14.k.a;
                  var6[1] = var14.l.a;
               }

               if(var6[0] < var5[1] && var6[1] > var5[0]) {
                  y.c.d var15 = this.s.a(var10, var13);
                  this.A.a(var15, this.A.b(var12));
               }
            }

            var11.g();
            if(var16 != 0) {
               break;
            }
         }

         this.a((ao)var1, var8, var7);
      }

      return var8;
   }

   private ao b(ao var1, double[] var2, double[] var3, boolean var4) {
      double[] var5;
      double[] var6;
      byte var7;
      al var8;
      int var16;
      label52: {
         var16 = f;
         var5 = new double[4];
         var6 = new double[2];
         var8 = null;
         if(var4) {
            var5[2] = var3[2];
            var5[3] = var3[3];
            var7 = 2;
            if(var16 == 0) {
               break label52;
            }
         }

         var5[2] = var2[2];
         var5[3] = var2[3];
         var7 = 4;
      }

      y.c.q var9 = (y.c.q)this.B.b(var1);
      if(var5[2] < var5[3]) {
         if(var4) {
            var8 = new al(var2[1], var3[2], var2[2], var3[3], true);
            this.b((ao)var1, var8, var7);
         } else {
            var8 = new al(var2[2], var3[1], var2[3], var3[2], false);
            this.b((ao)var1, var8, var7);
         }

         y.c.q var10 = this.s.d();
         this.C.a(var10, var8);
         this.B.a(var8, var10);
         y.c.e var11 = var9.j();

         while(var11.f()) {
            y.c.d var12 = var11.a();
            y.c.q var13 = var12.a(var9);
            ao var14 = (ao)this.C.b(var13);
            if(var16 != 0) {
               return var8;
            }

            if(var14 != null) {
               label39: {
                  if(var4) {
                     var6[0] = var14.k.b;
                     var6[1] = var14.l.b;
                     if(var16 == 0) {
                        break label39;
                     }
                  }

                  var6[0] = var14.k.a;
                  var6[1] = var14.l.a;
               }

               if(var6[0] < var5[3] && var6[1] > var5[2]) {
                  y.c.d var15 = this.s.a(var10, var13);
                  this.A.a(var15, this.A.b(var12));
               }
            }

            var11.g();
            if(var16 != 0) {
               break;
            }
         }

         this.a((ao)var1, var8, var7);
      }

      return var8;
   }

   private void c(ao var1, y.d.t var2, y.d.t var3) {
      if(var1.x()) {
         this.a(var1, var2, var3);
         if(f == 0) {
            return;
         }
      }

      this.b(var1, var2, var3);
   }

   private y.c.D d(y.c.D var1) {
      int var14 = f;
      ao var7 = null;
      ao var8 = (ao)var1.f();
      boolean var9 = var8.x();
      double var2 = var9?var8.s():var8.r();
      y.c.q var10 = (y.c.q)this.B.b(var8);
      double var11 = Double.MAX_VALUE;
      y.c.x var13 = var10.m();

      ao var10000;
      while(true) {
         if(var13.f()) {
            ao var6 = (ao)this.C.b(var13.e());
            var10000 = var6;
            if(var14 != 0) {
               break;
            }

            if(var6 != null) {
               double var4 = var9?var6.s():var6.r();
               if(Math.abs(var2 - var4) < var11) {
                  var7 = var6;
                  var11 = Math.abs(var2 - var4);
               }
            }

            var13.g();
            if(var14 == 0) {
               continue;
            }
         }

         var10000 = var7;
         break;
      }

      if(var10000 == null) {
         throw new IllegalStateException("Sightpatch missing for special case treatment");
      } else {
         y.c.D var15 = new y.c.D();
         var15.add(var8);
         var15.add(var7);
         var15.add(var8);
         return var15;
      }
   }

   private void a(y.c.d var1, y.c.D var2, boolean var3) {
      y.c.D var4;
      ae var5;
      y.d.t var6;
      y.d.t var7;
      y.d.t var8;
      ao var9;
      y.d.t var10;
      y.d.t var11;
      int var27;
      label394: {
         var27 = f;
         var4 = new y.c.D();
         var5 = (ae)this.E.b(var1);
         var6 = this.c(var1);
         this.w = var1;
         if(var2.size() == 1) {
            label398: {
               var9 = (ao)var2.f();
               this.x = true;
               var10 = this.a(var1.c(), var9, var6);
               this.x = false;
               var11 = this.a(var1.d(), var9, var6);
               if(var5.b(true) && !var5.b(false)) {
                  var7 = var10;
                  var8 = var9.x()?new y.d.t(this.g.p(var1).a, var11.b):new y.d.t(var11.a, this.g.p(var1).b);
                  var5.c(false, true);
                  if(var27 == 0) {
                     break label398;
                  }
               }

               if(!var5.b(true) && var5.b(false)) {
                  var7 = var9.x()?new y.d.t(this.g.q(var1).a, var10.b):new y.d.t(var10.a, this.g.q(var1).b);
                  var8 = var11;
                  var5.c(true, true);
                  if(var27 == 0) {
                     break label398;
                  }
               }

               var7 = var10;
               var8 = var11;
            }

            if(!var5.b(true) || !var5.b(false)) {
               break label394;
            }

            boolean var12 = var9.x()?this.g.p(var1).a == this.g.q(var1).a:this.g.p(var1).b == this.g.q(var1).b;
            if(var12) {
               break label394;
            }

            var2 = this.d(var2);
            if(var27 == 0) {
               break label394;
            }
         }

         var7 = null;
         var8 = null;
      }

      label399: {
         var9 = (ao)var2.f();
         if(var5.b(true)) {
            var10 = this.g.p(var1);
            if(var27 == 0) {
               break label399;
            }
         }

         if(var5.d(true)) {
            var10 = var7;
            if(var27 == 0) {
               break label399;
            }
         }

         this.x = true;
         if(var2.size() == 1) {
            var10 = this.a(var1.c(), var1.d(), var9, var6);
            if(var27 == 0) {
               break label399;
            }
         }

         var10 = this.a(var1.c(), var9, var6);
      }

      double var13;
      double var15;
      ao var17;
      y.d.t var18;
      y.d.t var19;
      ao var28;
      label400: {
         var28 = var9;
         this.g.c(var1, var10);
         var4.add(var10);
         var13 = var10.a;
         var15 = var10.b;
         var17 = (ao)var2.i();
         if(var5.b(false)) {
            var18 = this.g.q(var1);
            if(var27 == 0) {
               break label400;
            }
         }

         if(var5.d(false)) {
            var18 = var8;
            if(var27 == 0) {
               break label400;
            }
         }

         this.x = false;
         var19 = this.a(var1.d(), var17, var6);
         if(var2.size() == 1 && (this.an || this.ao && this.am || this.al)) {
            if(var17.x()) {
               var18 = new y.d.t(var13, var19.b);
               if(var27 == 0) {
                  break label400;
               }
            }

            var18 = new y.d.t(var19.a, var15);
            if(var27 == 0) {
               break label400;
            }
         }

         var18 = var19;
      }

      var19 = var10;
      y.c.p var20 = var2.k().a();

      while(true) {
         if(var20 != null) {
            var28 = var9;
            var11 = var19;
            var9 = (ao)var20.c();
            boolean var21 = this.a(var20, var10, var18);
            if(var27 != 0) {
               break;
            }

            label403: {
               if(var20.a() != null) {
                  if(var9.x()) {
                     if(this.i) {
                        label437: {
                           if(this.ao || this.al && var21) {
                              if(Math.abs(var9.k.a - var6.a) <= Math.abs(var9.l.a - var6.a)) {
                                 var13 = this.a(var9, true, true);
                                 if(var27 == 0) {
                                    break label437;
                                 }
                              }

                              var13 = this.a(var9, true, false);
                              if(var27 == 0) {
                                 break label437;
                              }
                           }

                           if(this.an || this.al && !var21) {
                              var13 = this.e(var9);
                              if(var27 == 0) {
                                 break label437;
                              }
                           }

                           var13 = this.a(var9, true, true);
                        }

                        var19 = new y.d.t(var13, var15);
                        if(var27 == 0) {
                           break label403;
                        }
                     }

                     if(this.ao || this.al && var21) {
                        if(Math.abs(var9.k.a - var6.a) <= Math.abs(var9.l.a - var6.a)) {
                           var19 = new y.d.t(var13 = var9.k.a + this.r, var15);
                           if(var27 == 0) {
                              break label403;
                           }
                        }

                        var19 = new y.d.t(var13 = var9.l.a - this.r, var15);
                        if(var27 == 0) {
                           break label403;
                        }
                     }

                     if(this.an || this.al && !var21) {
                        var19 = new y.d.t(var13 = this.d(var9), var15);
                        if(var27 == 0) {
                           break label403;
                        }
                     }

                     var19 = new y.d.t(var13 = var9.k.a + this.r, var15);
                     if(var27 == 0) {
                        break label403;
                     }
                  }

                  if(this.i) {
                     label438: {
                        if(this.ao || this.al && var21) {
                           if(Math.abs(var9.k.b - var6.b) <= Math.abs(var9.l.b - var6.b)) {
                              var15 = this.a(var9, false, true);
                              if(var27 == 0) {
                                 break label438;
                              }
                           }

                           var15 = this.a(var9, false, false);
                           if(var27 == 0) {
                              break label438;
                           }
                        }

                        if(this.an || this.al && !var21) {
                           var15 = this.e(var9);
                           if(var27 == 0) {
                              break label438;
                           }
                        }

                        var15 = this.a(var9, false, true);
                     }

                     var19 = new y.d.t(var13, var15);
                     if(var27 == 0) {
                        break label403;
                     }
                  }

                  if(this.ao || this.al && var21) {
                     if(Math.abs(var9.k.b - var6.b) <= Math.abs(var9.l.b - var6.b)) {
                        var19 = new y.d.t(var13, var15 = var9.k.b + this.r);
                        if(var27 == 0) {
                           break label403;
                        }
                     }

                     var19 = new y.d.t(var13, var15 = var9.l.b - this.r);
                     if(var27 == 0) {
                        break label403;
                     }
                  }

                  if(this.an || this.al && !var21) {
                     var19 = new y.d.t(var13, var15 = this.d(var9));
                     if(var27 == 0) {
                        break label403;
                     }
                  }

                  var19 = new y.d.t(var13, var15 = var9.k.b + this.r);
                  if(var27 == 0) {
                     break label403;
                  }
               }

               if(var9.x()) {
                  var19 = new y.d.t(var18.a, var15);
                  if(var27 == 0) {
                     break label403;
                  }
               }

               var19 = new y.d.t(var13, var18.b);
            }

            var4.add(var19);
            if(var9.n) {
               label423: {
                  if(var9.x()) {
                     if(var11.a < var18.a) {
                        var19 = new y.d.t(var18.a - 2.0D * this.P() - 1.0D, var15);
                        if(var27 == 0) {
                           break label423;
                        }
                     }

                     var19 = new y.d.t(var18.a + 2.0D * this.P() + 1.0D, var15);
                     if(var27 == 0) {
                        break label423;
                     }
                  }

                  if(var11.b < var18.b) {
                     var19 = new y.d.t(var13, var18.b - 2.0D * this.P() - 1.0D);
                     if(var27 == 0) {
                        break label423;
                     }
                  }

                  var19 = new y.d.t(var13, var18.b + 2.0D * this.P() + 1.0D);
               }
            }

            if(var3 && !var28.n) {
               if(((al)var28).f()) {
                  this.c(var28);
               }

               this.c(var28, var11, var19);
            }

            var20 = var20.a();
            if(var27 == 0) {
               continue;
            }
         }

         this.g.d(var1, var18);
         var4.add(var18);
         break;
      }

      if(var28.n && !var17.n) {
         label414: {
            if(var28.x()) {
               if(var19.a > var18.a) {
                  var19 = new y.d.t(var19.a - 2.0D * this.P() - 1.0D, var19.b);
                  if(var27 == 0) {
                     break label414;
                  }
               }

               var19 = new y.d.t(var19.a + 2.0D * this.P() + 1.0D, var19.b);
               if(var27 == 0) {
                  break label414;
               }
            }

            if(var19.b > var18.b) {
               var19 = new y.d.t(var19.a, var19.b - 2.0D * this.P() - 1.0D);
               if(var27 == 0) {
                  break label414;
               }
            }

            var19 = new y.d.t(var19.a, var19.b + 2.0D * this.P() + 1.0D);
         }
      }

      if(var3 && !var17.n) {
         if(((al)var17).f()) {
            this.c(var17);
         }

         this.c(var17, var19, var18);
      }

      boolean var10000;
      y.c.C var22;
      af var23;
      al var24;
      double var25;
      y.d.t var29;
      y.c.D var30;
      label193: {
         this.g.a(var1, var4);
         if(var5.b(true)) {
            var29 = this.g.p(var1);
            var30 = var5.e(true);
            var22 = var30.m();

            while(var22.f()) {
               var23 = (af)var22.d();
               var24 = (al)var23.a;
               var10000 = var24.x();
               if(var27 != 0) {
                  break label193;
               }

               var25 = var10000?var29.a:var29.b;
               var24.a(var1, var25, true);
               var22.g();
               if(var27 != 0) {
                  break;
               }
            }
         }

         var10000 = var5.b(false);
      }

      if(var10000) {
         var29 = this.g.q(var1);
         var30 = var5.e(false);
         var22 = var30.m();

         while(var22.f()) {
            var23 = (af)var22.d();
            var24 = (al)var23.a;
            if(var27 != 0) {
               return;
            }

            var25 = var24.x()?var29.a:var29.b;
            var24.a(var1, var25, false);
            var22.g();
            if(var27 != 0) {
               break;
            }
         }
      }

      this.a(var1, var2);
   }

   private boolean a(y.c.p var1, y.d.t var2, y.d.t var3) {
      int var15 = f;
      ao var4 = (ao)var1.c();
      boolean var5 = var4.x();
      double var6 = var5?var4.r():var4.s();
      if(var1.a() != null && var1.b() != null) {
         double var9;
         label70: {
            y.c.p var8 = var1.b().b();
            if(var8 == null) {
               var9 = var5?var2.a():var2.b();
               if(var15 == 0) {
                  break label70;
               }
            }

            ao var11 = (ao)var8.c();
            var9 = var5?var11.r():var11.s();
         }

         y.c.p var16 = var1.a().a();
         double var12;
         if(var16 == null) {
            var12 = var5?var3.a():var3.b();
            if(var15 == 0) {
               return var9 > var6 && var12 > var6 || var9 < var6 && var12 < var6;
            }
         }

         ao var14 = (ao)var16.c();
         var12 = var5?var14.r():var14.s();
         return var9 > var6 && var12 > var6 || var9 < var6 && var12 < var6;
      } else {
         return false;
      }
   }

   void a(y.c.d var1, y.c.D var2) {
      Object var3 = null;
      ao var4 = null;
      y.d.t var5 = null;
      y.d.t var6 = null;
      y.c.D var7;
      if(this.b(var1.c())) {
         var4 = (ao)var2.f();
         var7 = this.g.m(var1);
         var5 = (y.d.t)var7.get(0);
         var6 = (y.d.t)var7.get(1);
      } else {
         if(!this.b(var1.d())) {
            return;
         }

         var4 = (ao)var2.i();
         var7 = this.g.m(var1);
         var5 = (y.d.t)var7.get(var7.size() - 1);
         var6 = (y.d.t)var7.get(var7.size() - 2);
      }

      if(var4.n) {
         double var9 = var4.x()?var5.b:var5.a;
         var4.p = Math.max(var4.p, (float)var9);
         var4.o = Math.min(var4.o, (float)var9);
         var9 = var4.x()?var6.b:var6.a;
         var4.p = Math.max(var4.p, (float)var9);
         var4.o = Math.min(var4.o, (float)var9);
      }

   }

   private double P() {
      return this.i?(double)this.p / 2.0D:this.r;
   }

   private y.d.t a(y.c.q var1, y.c.q var2, ao var3, y.d.t var4) {
      y.d.t var5 = this.a(var1, var3, var4);
      if((this.an || this.ao || this.al) && this.am) {
         y.d.t var6 = this.a(var2, var3, var4);
         return var3.x()?(Math.abs(var5.a - this.g.j(var1)) < Math.abs(var6.a - this.g.j(var2))?var5:new y.d.t(var6.a, var5.b)):(Math.abs(var5.b - this.g.k(var1)) < Math.abs(var6.b - this.g.k(var2))?var5:new y.d.t(var5.a, var6.b));
      } else {
         return var5;
      }
   }

   private y.d.t c(y.c.d var1) {
      double[] var4 = new double[4];
      double[] var5 = new double[4];
      y.c.q var2 = var1.c();
      y.c.q var3 = var1.d();
      double var6 = this.g.m(var2);
      double var8 = var6 + this.g.p(var2);
      double var10 = this.g.n(var2);
      double var12 = var10 + this.g.q(var2);
      double var14 = this.g.m(var3);
      double var16 = var14 + this.g.p(var3);
      double var18 = this.g.n(var3);
      double var20 = var18 + this.g.q(var3);
      var4[0] = var6;
      var4[1] = var8;
      var4[2] = var14;
      var4[3] = var16;
      var5[0] = var10;
      var5[1] = var12;
      var5[2] = var18;
      var5[3] = var20;
      Arrays.sort(var4);
      Arrays.sort(var5);
      return new y.d.t((var4[1] + var4[2]) / 2.0D, (var5[1] + var5[2]) / 2.0D);
   }

   private double a(ao var1, boolean var2, boolean var3) {
      double var5;
      label40: {
         int var7 = f;
         int var4;
         if(var2) {
            if(var3) {
               var4 = (int)Math.floor((var1.k.a - this.n.a) / (double)this.p);
               var5 = (double)(var4 * this.p) + this.n.a;
               if(var5 >= var1.k.a) {
                  break label40;
               }

               var5 += (double)this.p;
               if(var7 == 0) {
                  break label40;
               }
            }

            var4 = (int)Math.floor((var1.l.a - this.n.a) / (double)this.p);
            var5 = (double)(var4 * this.p) + this.n.a;
            if(var5 < var1.l.a) {
               break label40;
            }

            var5 -= (double)this.p;
            if(var7 == 0) {
               break label40;
            }
         }

         if(var3) {
            var4 = (int)Math.floor((var1.k.b - this.n.b) / (double)this.p);
            var5 = (double)(var4 * this.p) + this.n.b;
            if(var5 >= var1.k.b) {
               break label40;
            }

            var5 += (double)this.p;
            if(var7 == 0) {
               break label40;
            }
         }

         var4 = (int)Math.floor((var1.l.b - this.n.b) / (double)this.p);
         var5 = (double)(var4 * this.p) + this.n.b;
         if(var5 >= var1.l.b) {
            var5 -= (double)this.p;
         }
      }

      if(((al)var1).m()) {
         var5 = this.a(var5, var1, var3);
      }

      return var5;
   }

   private double d(ao var1) {
      double var2 = var1.x()?var1.r():var1.s();
      return this.a(var1, var2);
   }

   private double a(ao var1, double var2) {
      int var16 = f;
      y.c.D var4 = new y.c.D();
      double var5 = var1.x()?var1.k.a:var1.k.b;
      var5 += this.r;
      double var7 = var5;
      double var9 = var1.x()?var1.l.a:var1.l.b;
      double var11 = var5;

      while(true) {
         if(var11 <= var9) {
            var4.add(new Double(var11));
            var11 += 2.0D * this.r;
            if(var16 != 0) {
               break;
            }

            if(var16 == 0) {
               continue;
            }
         }

         var11 = Math.abs(var2 - var5);
         break;
      }

      y.c.C var13 = var4.m();

      double var10000;
      while(true) {
         if(var13.f()) {
            double var14 = ((Double)var13.d()).doubleValue();
            var10000 = Math.abs(var2 - var14);
            if(var16 != 0) {
               break;
            }

            if(var10000 < var11) {
               var11 = Math.abs(var2 - var14);
               var7 = var14;
            }

            var13.g();
            if(var16 == 0) {
               continue;
            }
         }

         var10000 = var7;
         break;
      }

      return var10000;
   }

   private double e(ao var1) {
      double var2 = var1.x()?var1.r():var1.s();
      return this.b(var1, var2);
   }

   private double b(ao var1, double var2) {
      int var17 = f;
      al var4 = (al)var1;
      y.c.D var5 = this.a(var1);
      if(var5 == null) {
         throw new IllegalStateException("No grid lines available.");
      } else {
         double var6;
         boolean var24;
         label131: {
            var6 = var2;
            if(var4.m()) {
               y.c.D var8 = var4.l();
               y.c.C var9 = var8.m();
               byte var10 = 0;
               y.c.D var11 = new y.c.D();

               am var12;
               int var10000;
               label127: {
                  while(var9.f()) {
                     var10000 = var10;
                     if(var17 != 0) {
                        break label127;
                     }

                     if(var10 != 0) {
                        break;
                     }

                     var12 = (am)var9.d();
                     if(var12.a == this.w) {
                        var11.add(var12);
                     }

                     var9.g();
                     if(var17 != 0) {
                        break;
                     }
                  }

                  var10000 = var11.size();
               }

               byte var23;
               label114: {
                  label137: {
                     if(var10000 == 1) {
                        var12 = (am)var11.f();
                        if(var12.a != this.w) {
                           break label137;
                        }

                        var10 = 1;
                        var6 = var12.b;
                        if(var17 == 0) {
                           break label137;
                        }
                     }

                     y.c.C var21 = var11.m();

                     while(var21.f()) {
                        var23 = var10;
                        if(var17 != 0) {
                           break label114;
                        }

                        if(var10 != 0) {
                           break;
                        }

                        am var13 = (am)var21.d();
                        if(var13.a == this.w && var13.d == this.x) {
                           var10 = 1;
                           var6 = var13.b;
                        }

                        var21.g();
                        if(var17 != 0) {
                           break;
                        }
                     }
                  }

                  var23 = var10;
               }

               if(var23 != 0) {
                  return var6;
               }

               var9.i();

               label94:
               do {
                  var10000 = var9.f();

                  label91:
                  while(true) {
                     if(var10000 == 0) {
                        break label94;
                     }

                     var24 = var5.isEmpty();
                     if(var17 != 0) {
                        break label131;
                     }

                     if(var24) {
                        break label94;
                     }

                     double var22 = ((am)var9.d()).b;
                     y.c.C var14 = var5.m();

                     while(true) {
                        if(!var14.f()) {
                           break label91;
                        }

                        double var15 = ((Double)var14.d()).doubleValue();
                        double var26;
                        var10000 = (var26 = Math.abs(var22 - var15) - 0.5D) == 0.0D?0:(var26 < 0.0D?-1:1);
                        if(var17 != 0) {
                           break;
                        }

                        if(var10000 <= 0) {
                           var5.b(var14);
                        }

                        var14.g();
                        if(var17 != 0) {
                           break label91;
                        }
                     }
                  }

                  var9.g();
               } while(var17 == 0);
            }

            var24 = var5.isEmpty();
         }

         if(var24) {
            throw new IllegalStateException("All grid lines removed.");
         } else {
            double var18 = Double.POSITIVE_INFINITY;
            var6 = var2;
            y.c.C var20 = var5.m();

            double var25;
            while(true) {
               if(var20.f()) {
                  double var19 = ((Double)var20.d()).doubleValue();
                  var25 = Math.abs(var19 - var2);
                  if(var17 != 0) {
                     break;
                  }

                  if(var25 < var18) {
                     var18 = Math.abs(var19 - var2);
                     var6 = var19;
                  }

                  var20.g();
                  if(var17 == 0) {
                     continue;
                  }
               }

               var25 = var6;
               break;
            }

            return var25;
         }
      }
   }

   private double a(double var1, ao var3, boolean var4) {
      int var16 = f;
      double var5 = var3.t();
      double var7 = var3.u();
      al var9 = (al)var3;
      y.c.D var10 = var9.l();
      boolean var11 = false;
      y.c.C var12 = var10.m();

      boolean var10000;
      while(true) {
         if(var12.f()) {
            var10000 = var11;
            if(var16 != 0) {
               break;
            }

            if(!var11) {
               am var13 = (am)var12.d();
               if(var13.a == this.w && var13.b == var1 && var13.d == this.x) {
                  var11 = true;
               }

               var12.g();
               if(var16 == 0) {
                  continue;
               }
            }
         }

         var10000 = var11;
         break;
      }

      if(var10000) {
         return var1;
      } else {
         double var17 = var1;
         var12.i();

         while(var12.f() && !var11) {
            am var15 = (am)var12.d();
            if(var15.b == var1) {
               var1 += (double)(var4?this.p:-this.p);
               if(var1 < var5 || var1 >= var7) {
                  var1 = var17;
               }

               var11 = true;
            }

            var12.g();
            if(var16 != 0) {
               break;
            }
         }

         return var1;
      }
   }

   private y.d.t a(y.c.q var1, ao var2, y.d.t var3) {
      int var14 = f;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8;
      double var10;
      double var12;
      if(var2.x()) {
         label285: {
            if(this.i) {
               if(this.ao) {
                  if(this.am) {
                     var4 = this.b(var2, this.g.j(var1));
                     if(var14 == 0) {
                        break label285;
                     }
                  }

                  if(Math.abs(var2.k.a - var3.a) <= Math.abs(var2.l.a - var3.a)) {
                     var4 = this.a(var2, true, true);
                     if(var14 == 0) {
                        break label285;
                     }
                  }

                  var4 = this.a(var2, true, false);
                  if(var14 == 0) {
                     break label285;
                  }
               }

               if(this.an || this.al) {
                  if(this.am) {
                     var4 = this.b(var2, this.g.j(var1));
                     if(var14 == 0) {
                        break label285;
                     }
                  }

                  var4 = this.e(var2);
                  if(var14 == 0) {
                     break label285;
                  }
               }

               var4 = this.a(var2, true, true);
               if(var14 == 0) {
                  break label285;
               }
            }

            if(this.ao) {
               if(this.am) {
                  label261: {
                     var8 = this.g.j(var1);
                     var10 = var8 - this.r;
                     var12 = var8 + this.r;
                     if(var10 >= var2.k.a && var12 <= var2.l.a) {
                        var4 = var8;
                        if(var14 == 0) {
                           break label261;
                        }
                     }

                     if(var10 >= var2.k.a) {
                        var4 = var2.l.a - this.r;
                        if(var14 == 0) {
                           break label261;
                        }
                     }

                     var4 = var2.k.a + this.r;
                  }

                  if(var4 >= var2.k.a && var4 <= var2.l.a) {
                     break label285;
                  }

                  var4 = var2.r();
                  if(var14 == 0) {
                     break label285;
                  }
               }

               if(Math.abs(var2.k.a - var3.a) <= Math.abs(var2.l.a - var3.a)) {
                  var4 = var2.k.a + this.r;
                  if(var14 == 0) {
                     break label285;
                  }
               }

               var4 = var2.l.a - this.r;
               if(var14 == 0) {
                  break label285;
               }
            }

            if(this.an || this.al) {
               label263: {
                  var8 = this.am?this.g.j(var1):var2.r();
                  var10 = var8 - this.r;
                  var12 = var8 + this.r;
                  if(var10 >= var2.k.a && var12 <= var2.l.a) {
                     var4 = var8;
                     if(var14 == 0) {
                        break label263;
                     }
                  }

                  if(var10 >= var2.k.a) {
                     var4 = var2.l.a - this.r;
                     if(var14 == 0) {
                        break label263;
                     }
                  }

                  var4 = var2.k.a + this.r;
               }

               if(var4 >= var2.k.a && var4 <= var2.l.a) {
                  break label285;
               }

               var4 = var2.r();
               if(var14 == 0) {
                  break label285;
               }
            }

            var4 = var2.k.a + this.r;
         }

         if(this.aP) {
            var6 = this.g.k(var1);
            if(var14 == 0) {
               return new y.d.t(var4, var6);
            }
         }

         if(var2.k.b < this.g.n(var1)) {
            var6 = this.g.n(var1);
            if(var14 == 0) {
               return new y.d.t(var4, var6);
            }
         }

         var6 = this.g.n(var1) + this.g.q(var1);
         if(var14 == 0) {
            return new y.d.t(var4, var6);
         }
      }

      label287: {
         if(this.i) {
            if(this.ao) {
               if(this.am) {
                  var6 = this.e(var2);
                  if(var14 == 0) {
                     break label287;
                  }
               }

               if(Math.abs(var2.k.b - var3.b) <= Math.abs(var2.l.b - var3.b)) {
                  var6 = this.a(var2, false, true);
                  if(var14 == 0) {
                     break label287;
                  }
               }

               var6 = this.a(var2, false, false);
               if(var14 == 0) {
                  break label287;
               }
            }

            if(this.an || this.al) {
               if(this.am) {
                  var6 = this.e(var2);
                  if(var14 == 0) {
                     break label287;
                  }
               }

               var6 = this.b(var2, this.g.k(var1));
               if(var14 == 0) {
                  break label287;
               }
            }

            var6 = this.a(var2, false, true);
            if(var14 == 0) {
               break label287;
            }
         }

         if(this.ao) {
            if(this.am) {
               label270: {
                  var8 = this.g.k(var1);
                  var10 = var8 - this.r;
                  var12 = var8 + this.r;
                  if(var10 >= var2.k.b && var12 <= var2.l.b) {
                     var6 = var8;
                     if(var14 == 0) {
                        break label270;
                     }
                  }

                  if(var10 >= var2.k.b) {
                     var6 = var2.l.b - this.r;
                     if(var14 == 0) {
                        break label270;
                     }
                  }

                  var6 = var2.k.b + this.r;
               }

               if(var6 >= var2.k.b && var6 <= var2.l.b) {
                  break label287;
               }

               var6 = var2.s();
               if(var14 == 0) {
                  break label287;
               }
            }

            if(Math.abs(var2.k.b - var3.b) <= Math.abs(var2.l.b - var3.b)) {
               var6 = var2.k.b + this.r;
               if(var14 == 0) {
                  break label287;
               }
            }

            var6 = var2.l.b - this.r;
            if(var14 == 0) {
               break label287;
            }
         }

         if(this.an || this.al) {
            label272: {
               var8 = this.am?this.g.k(var1):var2.s();
               var10 = var8 - this.r;
               var12 = var8 + this.r;
               if(var10 >= var2.k.b && var12 <= var2.l.b) {
                  var6 = var8;
                  if(var14 == 0) {
                     break label272;
                  }
               }

               if(var10 >= var2.k.b) {
                  var6 = var2.l.b - this.r;
                  if(var14 == 0) {
                     break label272;
                  }
               }

               var6 = var2.k.b + this.r;
            }

            if(var6 >= var2.k.b && var6 <= var2.l.b) {
               break label287;
            }

            var6 = var2.s();
            if(var14 == 0) {
               break label287;
            }
         }

         var6 = var2.k.b + this.r;
      }

      if(this.aP) {
         var4 = this.g.j(var1);
         if(var14 == 0) {
            return new y.d.t(var4, var6);
         }
      }

      if(var2.k.a < this.g.m(var1)) {
         var4 = this.g.m(var1);
         if(var14 == 0) {
            return new y.d.t(var4, var6);
         }
      }

      var4 = this.g.m(var1) + this.g.p(var1);
      return new y.d.t(var4, var6);
   }

   private void a(y.c.q var1, y.c.f var2) {
      int var6 = f;
      y.c.e var3 = var2.a();

      while(true) {
         y.c.d var4;
         ao var5;
         if(var3.f()) {
            var4 = var3.a();
            var5 = (ao)this.C.b(var4.a(var1));
            this.s.a(var4);
            var3.g();
            if(var6 != 0) {
               break;
            }

            if(var6 == 0) {
               continue;
            }
         }

         if(var1.a() > 0) {
            var3 = var1.j();

            while(var3.f()) {
               var4 = var3.a();
               var5 = (ao)this.C.b(var4.a(var1));
               this.s.a(var4);
               var3.g();
               if(var6 != 0) {
                  return;
               }
            }
         }
         break;
      }

   }

   private void a(y.c.q var1, y.c.q var2, y.c.f var3) {
      aJ var4 = (aJ)this.z.b(var1);
      this.a((y.c.D)var4.a, var2, (y.c.f)var3, (y.f.ax)null);
      this.a((y.c.D)var4.c, var2, (y.c.f)var3, (y.f.ax)null);
      this.a((y.c.D)var4.e, var2, (y.c.f)var3, (y.f.ax)null);
      this.a((y.c.D)var4.g, var2, (y.c.f)var3, (y.f.ax)null);
   }

   private void a(y.c.D var1, y.c.q var2, y.c.f var3, y.f.ax var4) {
      int var12 = f;
      if(var1.size() != 0) {
         if(this.i) {
            y.c.C var5 = var1.m();

            do {
               if(!var5.f()) {
                  return;
               }

               ao var6 = (ao)var5.d();
               if(var6 != null) {
                  int var7 = this.a(var6.t(), var6.u());
                  boolean var8 = var7 > 0;
                  if(var8) {
                     y.c.q var9 = (y.c.q)this.B.b(var6);
                     y.c.d var10 = this.s.a(var2, var9);
                     var3.add(var10);
                     if(var4 != null) {
                        this.aq.put(var10, var4);
                     }
                  }
               }

               var5.g();
            } while(var12 == 0);
         }

         double var13 = this.r + 1.0D;
         y.c.C var14 = var1.m();

         while(var14.f()) {
            ao var15 = (ao)var14.d();
            if(var15 != null) {
               if(var15.n) {
                  ;
               }

               boolean var16 = var15.p() >= var13 || var15.n;
               if(var16) {
                  y.c.q var17 = (y.c.q)this.B.b(var15);
                  y.c.d var11 = this.s.a(var2, var17);
                  var3.add(var11);
                  if(var4 != null) {
                     this.aq.put(var11, var4);
                  }
               }
            }

            var14.g();
            if(var12 != 0) {
               break;
            }
         }

      }
   }

   private y.c.D a(y.c.f var1, y.c.q var2) {
      int var9 = f;
      y.c.D var3 = new y.c.D();
      y.c.q var4 = var2;
      y.c.e var5 = var1.a();

      while(var5.f()) {
         y.c.d var6 = var5.a();
         y.c.q var7 = var6.a(var4);
         ao var8 = (ao)this.C.b(var7);
         if(var8 == null) {
            break;
         }

         var3.add(var8);
         var4 = var7;
         var5.g();
         if(var9 != 0) {
            break;
         }
      }

      return var3;
   }

   private y.c.f[] Q() {
      int var4 = f;
      y.c.h var1 = y.g.M.b(new boolean[this.g.g()]);
      this.a(var1);
      y.c.f[] var2 = new y.c.f[]{new y.c.f(), new y.c.f()};
      y.c.e var3 = this.g.p();

      while(var3.f()) {
         label17: {
            if(var1.d(var3.a())) {
               var2[0].add(var3.a());
               if(var4 == 0) {
                  break label17;
               }
            }

            var2[1].add(var3.a());
         }

         var3.g();
         if(var4 != 0) {
            break;
         }
      }

      return var2;
   }

   private void R() {
      int var14 = f;
      av var1 = this.H();
      this.U = new y.g.al();
      var1.g();
      this.U.b();
      y.c.D var2 = var1.a();
      y.c.D var3 = var1.b();
      y.c.c var4 = var1.e();
      this.y = var1.c();
      this.z = var1.d();
      if(this.H) {
         System.out.print(var1.f());
      }

      this.Q = new y.g.al();
      if(this.C != null && this.s != null) {
         this.s.a(this.C);
      }

      this.s = new y.c.i();
      this.C = this.s.t();
      this.B = new aF();
      this.Q.b();
      this.R = new y.g.al();
      int var5 = 0;
      y.c.C var6 = var3.m();

      ao var7;
      y.c.q var8;
      byte var10000;
      while(true) {
         if(var6.f()) {
            ++var5;
            var7 = (ao)var6.d();
            var10000 = this.h;
            if(var14 != 0) {
               break;
            }

            label112: {
               if(var10000 == 0 || this.f(var7)) {
                  if(var7.t() == var7.u()) {
                     break label112;
                  }

                  var8 = this.s.d();
                  this.B.a(var7, var8);
                  this.C.a(var8, var7);
                  if(var14 == 0) {
                     break label112;
                  }
               }

               this.h(var7);
            }

            var6.g();
            if(var14 == 0) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      var5 = var10000;
      var6 = var2.m();

      label81:
      while(true) {
         int var15 = var6.f();

         label78:
         while(var15 != 0) {
            ++var5;
            var7 = (ao)var6.d();
            var10000 = this.h;
            if(var14 != 0) {
               break label81;
            }

            label113: {
               if(var10000 == 0 || this.f(var7)) {
                  if(var7.t() == var7.u()) {
                     break label113;
                  }

                  var8 = this.s.d();
                  this.B.a(var7, var8);
                  this.C.a(var8, var7);
                  java.awt.geom.Rectangle2D.Double var9 = new java.awt.geom.Rectangle2D.Double(var7.k.a, var7.k.b, var7.l.a - var7.k.a, var7.l.b - var7.k.b);
                  y.c.C var10 = ((y.c.D)var4.b(var7)).m();

                  do {
                     if(!var10.f()) {
                        break label113;
                     }

                     ao var11 = (ao)var10.d();
                     double var16;
                     var15 = (var16 = var11.t() - var11.u()) == 0.0D?0:(var16 < 0.0D?-1:1);
                     if(var14 != 0) {
                        continue label78;
                     }

                     if(var15 != 0) {
                        java.awt.geom.Rectangle2D.Double var12 = new java.awt.geom.Rectangle2D.Double(var11.k.a, var11.k.b, var11.l.a - var11.k.a, var11.l.b - var11.k.b);
                        y.c.q var13 = (y.c.q)this.B.b(var11);
                        if(var13 != null && var9.intersects(var12)) {
                           this.s.a(var8, (y.c.q)this.B.b(var11));
                        }
                     }

                     var10.g();
                  } while(var14 == 0);
               }

               this.h(var7);
            }

            var6.g();
            if(var14 == 0) {
               continue label81;
            }
            break;
         }

         this.R.b();
         this.L = this.s.f();
         this.M = this.s.h();
         this.aJ = new y.g.P(this.s.t(), 0);
         this.aI = this.s.t();
         this.aH = this.s.t();
         this.aL = new y.g.N(this.s.t(), 0.0D);
         this.aK = new y.g.N(this.s.t(), 0.0D);
         this.aM = new y.g.N(this.s.u(), 0.0D);
         this.A = new y.g.N(this.s.u(), 0.0D);
         var10000 = this.m();
         break;
      }

      if(var10000 != 0) {
         this.e = this.s.t();
         this.d = new aQ(this.s);
      }

   }

   private boolean f(ao var1) {
      boolean var2 = true;
      if(var1.y()) {
         var2 = this.g(var1);
      }

      return var2;
   }

   private boolean g(ao var1) {
      boolean var10000;
      boolean var2;
      label121: {
         int var5 = f;
         var2 = false;
         aJ var3 = (aJ)this.y.b(var1);
         y.c.C var4;
         if(var1.x()) {
            var4 = var3.a.m();

            label94: {
               while(var4.f()) {
                  var2 |= this.a((y.c.q)var4.d(), var1);
                  var4.g();
                  if(var5 != 0) {
                     break label94;
                  }

                  if(var5 != 0) {
                     break;
                  }
               }

               var4 = var3.c.m();
            }

            label104: {
               while(var4.f()) {
                  var2 |= this.a((y.c.q)var4.d(), var1);
                  var4.g();
                  if(var5 != 0) {
                     break label104;
                  }

                  if(var5 != 0) {
                     break;
                  }
               }

               var4 = var3.b.m();
            }

            label114: {
               while(var4.f()) {
                  var2 |= this.a((y.c.q)var4.d(), var1);
                  var4.g();
                  if(var5 != 0) {
                     break label114;
                  }

                  if(var5 != 0) {
                     break;
                  }
               }

               var4 = var3.d.m();
            }

            do {
               if(!var4.f()) {
                  break label121;
               }

               var10000 = var2 | this.a((y.c.q)var4.d(), var1);
               if(var5 != 0) {
                  return var10000;
               }

               var2 = var10000;
               var4.g();
            } while(var5 == 0);
         }

         var4 = var3.e.m();

         label50: {
            while(var4.f()) {
               var2 |= this.a((y.c.q)var4.d(), var1);
               var4.g();
               if(var5 != 0) {
                  break label50;
               }

               if(var5 != 0) {
                  break;
               }
            }

            var4 = var3.g.m();
         }

         label60: {
            while(var4.f()) {
               var2 |= this.a((y.c.q)var4.d(), var1);
               var4.g();
               if(var5 != 0) {
                  break label60;
               }

               if(var5 != 0) {
                  break;
               }
            }

            var4 = var3.f.m();
         }

         label70: {
            while(var4.f()) {
               var2 |= this.a((y.c.q)var4.d(), var1);
               var4.g();
               if(var5 != 0) {
                  break label70;
               }

               if(var5 != 0) {
                  break;
               }
            }

            var4 = var3.h.m();
         }

         while(var4.f()) {
            var10000 = var2 | this.a((y.c.q)var4.d(), var1);
            if(var5 != 0) {
               return var10000;
            }

            var2 = var10000;
            var4.g();
            if(var5 != 0) {
               break;
            }
         }
      }

      var10000 = var2;
      return var10000;
   }

   private boolean a(y.c.q var1, ao var2) {
      int var3;
      int var4;
      double var5;
      double var7;
      y.c.c var9;
      y.c.c var10;
      int var17;
      label195: {
         var17 = f;
         var3 = 0;
         var5 = var2.t();
         var7 = var2.u();
         var9 = this.g.c(this.b());
         var10 = this.g.c(this.c());
         if(var2.x()) {
            var4 = var2.s() < this.g.k(var1)?1:2;
            if(var17 == 0) {
               break label195;
            }
         }

         var4 = var2.r() < this.g.j(var1)?8:4;
      }

      y.c.e var11 = var1.k();

      int var10000;
      label184: {
         y.c.d var12;
         y.f.aE var13;
         double var14;
         double var15;
         byte var10001;
         y.f.ax var18;
         while(true) {
            if(var11.f()) {
               var12 = var11.a();
               var10000 = this.h;
               var10001 = 2;
               if(var17 != 0) {
                  break;
               }

               if((var10000 != 2 || var10.d(var12)) && (this.h != 4 || var9.d(var1) || var9.d(var12.a(var1)))) {
                  var13 = y.f.aE.e(this.g, var12);
                  if(var13 != null && var13.a() && var13.b() == var4) {
                     var14 = var2.x()?this.g.q(var12).a:this.g.q(var12).b;
                     var3 |= var5 <= var14?(var7 >= var14?1:0):0;
                  }

                  if(var13 == null) {
                     var18 = this.b(ad.a(this.g, var12, false));
                     if(var18 != null && var18.b() && var18.a() == (var4 & 15)) {
                        var15 = var2.x()?this.g.q(var12).a:this.g.q(var12).b;
                        var3 |= var5 <= var15?(var7 >= var15?1:0):0;
                     }
                  }
               }

               var11.g();
               if(var17 == 0) {
                  continue;
               }

               var11 = var1.l();
            } else {
               var11 = var1.l();
            }

            if(!var11.f()) {
               break label184;
            }

            var12 = var11.a();
            var10000 = this.h;
            if(var17 != 0) {
               return (boolean)var10000;
            }

            var10001 = 2;
            break;
         }

         while(true) {
            if((var10000 != var10001 || var10.d(var12)) && (this.h != 4 || var9.d(var1) || var9.d(var12.a(var1)))) {
               var13 = y.f.aE.d(this.g, var12);
               if(var13 != null && var13.a() && var13.b() == var4) {
                  var14 = var2.x()?this.g.p(var12).a:this.g.p(var12).b;
                  var3 |= var5 <= var14 && var7 >= var14?1:0;
               }

               if(var13 == null) {
                  var18 = this.b(ad.a(this.g, var12, true));
                  if(var18 != null && var18.b() && var18.a() == (var4 & 15)) {
                     var15 = var2.x()?this.g.p(var12).a:this.g.p(var12).b;
                     var3 |= var5 <= var15 && var7 >= var15?1:0;
                  }
               }
            }

            var11.g();
            if(var17 != 0 || !var11.f()) {
               break;
            }

            var12 = var11.a();
            var10000 = this.h;
            if(var17 != 0) {
               return (boolean)var10000;
            }

            var10001 = 2;
         }
      }

      var10000 = var3;
      return (boolean)var10000;
   }

   private y.f.ax b(Collection var1) {
      int var5 = f;
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

   private void h(ao var1) {
      int var5;
      label33: {
         var5 = f;
         aJ var2 = (aJ)this.y.b(var1);
         if(var1.x()) {
            this.a((y.c.D)var2.a, var1, (byte)2);
            this.a((y.c.D)var2.b, var1, (byte)20);
            this.a((y.c.D)var2.c, var1, (byte)1);
            this.a((y.c.D)var2.d, var1, (byte)10);
            if(var5 == 0) {
               break label33;
            }
         }

         this.a((y.c.D)var2.e, var1, (byte)4);
         this.a((y.c.D)var2.f, var1, (byte)40);
         this.a((y.c.D)var2.g, var1, (byte)8);
         this.a((y.c.D)var2.h, var1, (byte)80);
      }

      al var3 = (al)var1;
      y.c.C var4 = var3.b.m();

      while(true) {
         if(var4.f()) {
            ((al)var4.d()).b(false, var3);
            var4.g();
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         var4 = var3.c.m();
         break;
      }

      while(var4.f()) {
         ((al)var4.d()).b(true, var3);
         var4.g();
         if(var5 != 0) {
            break;
         }
      }

   }

   private String S() {
      int var2 = f;
      String var1 = "";
      var1 = var1 + "\n===Orthogonal Edge Router===\n";
      var1 = var1 + "Chosen style is ";
      switch(this.h) {
      case 0:
         var1 = var1 + "ROUTE_ALL_EDGES";
         if(var2 == 0) {
            break;
         }
      case 2:
         var1 = var1 + "ROUTE_SELECTED_EDGES";
         if(var2 == 0) {
            break;
         }
      case 4:
         var1 = var1 + "ROUTE_EDGES_AT_SELECTED_NODES";
      case 1:
      case 3:
      }

      label15: {
         if(this.i) {
            var1 = var1 + "; Grid Width = " + this.o + "\n";
            if(var2 == 0) {
               break label15;
            }
         }

         var1 = var1 + "; Minimum Distance = " + this.q + "\n";
      }

      var1 = var1 + "Number of edges routed = " + this.J + "\n";
      var1 = var1 + "Number of bad edges = " + this.K + "\n";
      var1 = var1 + "Total routing time = " + this.P + "\n";
      var1 = var1 + "Time for all edges = " + this.V + "\n";
      var1 = var1 + "Number of Dijkstra runs = " + this.I + "\n";
      var1 = var1 + "Time for Dijkstra runs = " + this.W + "\n";
      var1 = var1 + "RIG initially = " + this.L;
      var1 = var1 + " nodes, " + this.M + " edges\n";
      var1 = var1 + "RIG finally = " + this.N;
      var1 = var1 + " nodes, " + this.O + " edges\n";
      var1 = var1 + "Time for preparing the RIG = " + this.Q + "\n";
      var1 = var1 + "Time for building the RIG = " + this.R + "\n";
      var1 = var1 + "Time for decorating the RIG = " + this.S + "\n";
      var1 = var1 + "Time for instantiating the sweepline ";
      var1 = var1 + "= " + this.T + "\n";
      var1 = var1 + "Time for running the sweepline = " + this.U + "\n";
      var1 = var1 + "===Orthogonal Edge Router===\n";
      return var1;
   }

   public void b(byte var1) {
      switch(var1) {
      case 0:
      case 2:
      case 4:
         this.h = var1;
         if(f == 0) {
            return;
         }
      case 1:
      case 3:
      default:
         throw new IllegalArgumentException("Argument \'" + var1 + "\' not allowed.");
      }
   }

   public byte p() {
      return this.h;
   }

   public void d(boolean var1) {
      this.i = var1;
   }

   public boolean q() {
      return this.i;
   }

   public void a(int var1, int var2) {
      this.n = new y.d.t((double)var1, (double)var2);
   }

   public y.d.t r() {
      return this.n;
   }

   public void b(int var1) {
      if(Math.abs(var1) >= 2) {
         this.o = Math.abs(var1);
         this.p = this.o;
      }

   }

   public int s() {
      return this.o;
   }

   public void c(int var1) {
      if(Math.abs(var1) >= 4) {
         this.q = Math.abs(0.5D * (double)var1);
         this.r = this.q;
      }

   }

   public int t() {
      return (int)(this.q * 2.0D);
   }

   public void e(boolean var1) {
      this.ac = !var1;
   }

   public boolean u() {
      return !this.ac;
   }

   public void d(int var1) {
      if(Math.abs(var1) >= 2) {
         this.ad = var1;
      }

   }

   public int v() {
      return this.ad;
   }

   public void f(boolean var1) {
      this.aO = var1;
   }

   public boolean w() {
      return this.aO;
   }

   public void b(double var1) {
      if(var1 < 0.0D) {
         var1 = 0.0D;
      }

      if(var1 > 1.0D) {
         var1 = 1.0D;
      }

      this.aj = var1;
   }

   public double x() {
      return this.aj;
   }

   public void c(byte var1) {
      this.ak = var1;
      this.al = 3 == var1;
      this.an = 2 == var1;
      this.ao = 1 == var1;
   }

   public byte y() {
      return this.ak;
   }

   public void g(boolean var1) {
      this.ab = var1;
   }

   public boolean z() {
      return this.ab;
   }

   public void h(boolean var1) {
      this.ae = var1;
   }

   public boolean A() {
      return this.ae;
   }

   public void e(int var1) {
      this.af = Math.abs(var1);
   }

   public int B() {
      return this.af;
   }

   public void i(boolean var1) {
      this.aP = var1;
   }

   public boolean C() {
      return this.aP;
   }

   boolean b(y.c.q var1) {
      y.c.c var2 = this.g.c(i.a);
      return var2 != null && var2.b(var1) != null;
   }

   boolean c(y.c.q var1) {
      y.c.c var2 = this.g.c(i.a);
      return var2 != null && i.b.equals(var2.b(var1));
   }

   boolean d(y.c.q var1) {
      y.c.c var2 = this.g.c(i.a);
      return var2 != null && i.c.equals(var2.b(var1));
   }

   static boolean a(v var0, y.c.d var1, boolean var2) {
      return var0.a(var1, var2);
   }

   static y.c.A a(v var0) {
      return var0.C;
   }

   static y.c.q b(v var0) {
      return var0.u;
   }

   static y.c.q c(v var0) {
      return var0.v;
   }

   static y.f.X d(v var0) {
      return var0.g;
   }
}
