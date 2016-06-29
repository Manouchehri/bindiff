package y.f.c;

import java.util.HashMap;
import y.f.aR;
import y.f.c.D;
import y.f.c.N;
import y.f.c.O;
import y.f.c.P;
import y.f.c.a;
import y.f.c.af;
import y.f.c.aj;
import y.f.c.ay;
import y.f.c.e;
import y.f.c.g;
import y.f.c.a.aT;
import y.f.c.a.aW;
import y.f.c.a.aY;
import y.f.c.a.bK;
import y.f.c.a.bb;
import y.f.c.a.bk;
import y.f.c.a.bn;
import y.f.c.a.br;
import y.f.c.a.bx;

public class M extends y.f.c {
   public static final Object n = "y.layout.IncrementalHierarchicLayouter.STRAIGHT_EDGES_DPKEY";
   public static final Object o;
   public static final Object p;
   public static final Object q;
   public static final Object r;
   private byte s = 66;
   private y.c.c t;
   private y.c.c u;
   private boolean v = false;
   private boolean w = true;
   private byte x = 1;
   private long y = Long.MAX_VALUE;
   private y.f.c.a.N z;
   private aT A;
   private bx B;
   private aT C;
   private bx D;
   private byte E;
   private y.f.c.a.B F;
   private aY G;
   private double H = 20.0D;
   private boolean I = false;
   private boolean J = false;
   private y.f.ad K;
   private boolean L = false;
   private boolean M = false;
   private boolean N = false;

   public byte a() {
      return this.s;
   }

   public boolean n() {
      return this.v;
   }

   public long o() {
      return this.y;
   }

   public boolean p() {
      return this.w;
   }

   public void g(boolean var1) {
      this.w = var1;
   }

   public M() {
      this.f(false);
      this.b(false);
      this.e(false);
      this.d(false);
      this.E = 1;
      y.f.c.a.N var1 = this.u();
      this.K = var1.b();
      this.D = var1.u();
      this.C = var1.t();
      this.b(new bn());
      this.a((y.f.ad)(new ay()));
      y.f.an var2 = new y.f.an();
      var2.a(false);
      this.e(var2);
   }

   public boolean q() {
      return this.M;
   }

   public void h(boolean var1) {
      this.M = var1;
   }

   public boolean r() {
      return this.L;
   }

   public void i(boolean var1) {
      this.C().c(var1);
   }

   public void j(boolean var1) {
      boolean var3 = a.i;
      this.I = var1;
      if(this.I || this.J) {
         this.c(this.K);
         y.f.ad var2 = this.b();
         if(!(var2 instanceof y.f.V)) {
            throw new IllegalStateException("No LabelLayoutTranslator registered");
         }

         ((y.f.V)var2).d(this.I);
         ((y.f.V)var2).a(this.I);
         ((y.f.V)var2).c(this.J);
         if(var3) {
            throw new IllegalStateException("No LabelLayoutTranslator registered");
         }

         this.c(true);
         if(!var3) {
            return;
         }
      }

      this.c(false);
   }

   public void k(boolean var1) {
      this.J = var1;
      this.j(this.I);
   }

   public void a(double var1) {
      this.H = var1;
   }

   public void b(double var1) {
      this.s().a(var1);
   }

   public void c(double var1) {
      this.s().b(var1);
   }

   public void d(double var1) {
      this.s().c(var1);
   }

   protected y.f.c.a.q s() {
      y.f.c.a.z var1 = this.u().y();
      if(var1 instanceof y.f.c.a.q) {
         return (y.f.c.a.q)var1;
      } else {
         throw new IllegalStateException();
      }
   }

   protected y.f.c.a.N t() {
      return new y.f.c.a.N();
   }

   public y.f.c.a.N u() {
      if(this.z == null) {
         this.z = this.t();
      }

      return this.z;
   }

   public void b(byte var1) {
      Object var2 = null;
      af var3 = null;
      switch(var1) {
      case 0:
         var3 = new af();
         var3.a((byte)0);
         var2 = var3;
         break;
      case 1:
         var2 = new aj();
         break;
      case 2:
         var3 = new af();
         var3.a((byte)2);
         var2 = var3;
         break;
      case 3:
         var3 = new af();
         var3.a((byte)1);
         var2 = var3;
         break;
      case 4:
         var2 = new g();
         this.z.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.considerGroupNodeEdges", (Object)Boolean.FALSE);
         break;
      case 5:
         this.a((aT)(new e()));
         this.g(false);
         return;
      case 6:
         this.a((aT)(new D()));
         this.g(false);
         return;
      default:
         throw new IllegalArgumentException("Unknown strategy: " + var1);
      }

      if(this.x == 0) {
         y.f.c.a.f var4 = new y.f.c.a.f((aT)var2);
         this.a((aT)var4);
         if(!a.i) {
            return;
         }
      }

      this.a((aT)(new aW((aT)var2)));
   }

   public boolean b(y.f.X var1) {
      return this.u().b(var1);
   }

   private void d(y.f.X var1) {
      boolean var12 = a.i;
      y.c.c var2 = var1.c(r);
      if(var2 != null) {
         y.c.A var3 = var1.t();
         HashMap var4 = new HashMap();
         y.c.D var5 = new y.c.D();
         boolean var6 = false;
         y.c.x var7 = var1.o();

         label80:
         while(true) {
            if(var7.f()) {
               y.c.q var8 = var7.e();
               bK var9 = (bK)var2.b(var8);
               if(var12) {
                  break;
               }

               if(var9 != null) {
                  label73: {
                     y.f.aT var10;
                     if(!var4.containsKey(var9)) {
                        var5.add(var9);
                        var10 = new y.f.aT(0, !var9.a());
                        var3.a(var8, var10);
                        var4.put(var9, var10);
                        if(!var12) {
                           break label73;
                        }
                     }

                     var10 = (y.f.aT)var4.get(var9);
                     var3.a(var8, var10);
                  }

                  var6 = var6 || !var9.a();
               }

               var7.g();
               if(!var12) {
                  continue;
               }
            }

            if(var6) {
               var5.sort(new O((N)null));
               int var13 = 0;
               y.c.C var14 = var5.m();

               label55: {
                  while(var14.f()) {
                     y.f.aT var16 = (y.f.aT)var4.get(var14.d());
                     var16.a(var13++);
                     var14.g();
                     if(var12) {
                        break label55;
                     }

                     if(var12) {
                        break;
                     }
                  }

                  aR.a(var1, var3, 5, 2);
               }

               y.c.x var15 = var1.o();

               while(var15.f()) {
                  y.c.q var17 = var15.e();
                  bK var18 = (bK)var2.b(var17);
                  if(var12) {
                     return;
                  }

                  if(var18 != null) {
                     y.f.aT var11 = (y.f.aT)var3.b(var17);
                     var18.a(new Integer(var11.a()));
                  }

                  var15.g();
                  if(var12) {
                     break label80;
                  }
               }
            }
            break;
         }

         var1.a((y.c.A)var3);
      }

   }

   public void a(y.f.X var1) {
      boolean var9 = a.i;
      if(var1 != null) {
         y.f.c.a.N var2;
         y.c.c var3;
         Object var4;
         label116: {
            this.d(var1);
            var2 = this.u();
            this.a(var1, var2);
            var3 = var1.c(y.f.c.a.N.o);
            if(var3 == null) {
               var4 = y.g.q.a((Object)this.C());
               if(!var9) {
                  break label116;
               }
            }

            var1.d_(y.f.c.a.N.o);
            var4 = new P(var3, this.C());
         }

         y.c.c var5;
         label111: {
            var1.a((Object)y.f.c.a.N.o, (y.c.c)var4);
            var5 = var1.c(y.f.c.a.N.p);
            if(var5 == null) {
               var4 = y.g.q.a((Object)this.E());
               if(!var9) {
                  break label111;
               }
            }

            var1.d_(y.f.c.a.N.p);
            var4 = new P(var5, this.E());
         }

         var1.a((Object)y.f.c.a.N.p, (y.c.c)var4);
         y.c.c var6 = null;
         if(this.A() != 0) {
            var6 = var1.c(o);
            var1.d_(o);
         }

         try {
            var2.a(var1);
         } finally {
            var1.d_(y.f.c.a.N.o);
            if(var3 != null) {
               var1.a((Object)y.f.c.a.N.o, (y.c.c)var3);
            }

            var1.d_(y.f.c.a.N.p);
            if(var5 != null) {
               var1.a((Object)y.f.c.a.N.p, (y.c.c)var5);
            }

            if(this.A() != 0 && var6 != null) {
               var1.a((Object)o, (y.c.c)var6);
            }

            this.b(var1, var2);
         }

      }
   }

   protected int v() {
      y.f.ad var1 = this.g();
      if(var1 instanceof y.f.an) {
         y.f.an var2 = (y.f.an)var1;
         return var2.c();
      } else {
         return 4;
      }
   }

   protected void a(y.f.X var1, y.f.c.a.N var2) {
      boolean var4 = a.i;
      if(var2.x() == null) {
         this.N = true;
         if(var1.c(y.f.ay.a) != null || var1.c(y.f.ax.a) != null || var1.c(y.f.ax.b) != null) {
            bb var3 = new bb();
            var3.a(this.h());
            var3.a(this.v());
            var2.a((br)var3);
         }
      }

      var2.e(this.g());
      if(this.L) {
         this.t = var1.c(y.f.aF.c);
         var1.d_(y.f.aF.c);
         this.u = var1.c(y.f.aF.d);
         var1.d_(y.f.aF.d);
      }

      var2.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.automaticEdgeGroupingEnabled", (Object)(this.r()?Boolean.TRUE:Boolean.FALSE));
      var2.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.backloopRoutingEnabled", (Object)(this.q()?Boolean.TRUE:Boolean.FALSE));
      var2.a(this.o());
      var2.a((Object)"DefaultEdgeRouter.defaultMinLayerDistance", (Object)(new Double(this.H)));
      var2.a((Object)"DefaultEdgeRouter.minimumEdgeDistance", (Object)(new Double(this.C().d())));
      var2.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.enabled", (Object)(!this.p()?Boolean.FALSE:Boolean.TRUE));
      if(!(var2.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.interEdgePromotionEnabled") instanceof Boolean)) {
         var2.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.interEdgePromotionEnabled", (Object)(this.p()?Boolean.TRUE:Boolean.FALSE));
      }

      if(!(var2.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.considerGroupNodeEdges") instanceof Boolean)) {
         var2.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.considerGroupNodeEdges", (Object)Boolean.TRUE);
      }

      var2.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.alignment", (Object)(new Byte(this.a())));
      var2.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.compactionEnabled", (Object)(this.n()?Boolean.TRUE:Boolean.FALSE));
      var2.a((Object)"y.layout.hierarchic.incremental.HierarchicLayouter.useAspectRatioLayerer", (Object)(this.x == 0?Boolean.TRUE:Boolean.FALSE));
      boolean var5 = bk.d(var1) || var1.c(y.f.c.a.aR.a) != null;
      switch(this.A()) {
      case 1:
      default:
         label63: {
            if(var5 && !(this.w() instanceof y.f.c.a.m)) {
               var2.a((aT)(new y.f.c.a.m(this.w())));
               if(!var4) {
                  break label63;
               }
            }

            var2.a(this.w());
         }

         var2.a(this.x());
         if(!var4) {
            break;
         }
      case 0:
         var2.a(this.y());
         var2.a(this.z());
      }

   }

   protected void b(y.f.X var1, y.f.c.a.N var2) {
      if(this.N) {
         var2.a((br)null);
      }

      if(this.t != null) {
         var1.a((Object)y.f.aF.c, (y.c.c)this.t);
         this.t = null;
      }

      if(this.u != null) {
         var1.a((Object)y.f.aF.d, (y.c.c)this.u);
         this.u = null;
      }

   }

   public aT w() {
      return this.C;
   }

   public void a(aT var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.C = var1;
      }
   }

   public bx x() {
      return this.D;
   }

   public aT y() {
      if(this.A == null) {
         this.A = new e();
      }

      return this.A;
   }

   public bx z() {
      if(this.B == null) {
         this.B = new y.f.c.a.d();
      }

      return this.B;
   }

   public byte A() {
      return this.E;
   }

   public void c(byte var1) {
      if(var1 != 1 && var1 != 0) {
         throw new IllegalArgumentException();
      } else {
         this.E = var1;
      }
   }

   protected y.f.c.a.B B() {
      return new y.f.c.a.B();
   }

   public y.f.c.a.B C() {
      if(this.F == null) {
         this.F = this.B();
      }

      return this.F;
   }

   protected aY D() {
      return new aY();
   }

   public aY E() {
      if(this.G == null) {
         this.G = this.D();
      }

      return this.G;
   }

   static {
      o = y.f.c.a.N.n;
      p = y.f.c.a.N.r;
      q = y.f.c.a.N.s;
      r = "y.layout.hierarchic.incremental.HierarchicLayouter.SWIMLANE_DESCRIPTOR_DPKEY";
   }
}
