package y.f.c;

import java.util.ArrayList;
import y.f.c.D;
import y.f.c.L;
import y.f.c.Q;
import y.f.c.R;
import y.f.c.S;
import y.f.c.V;
import y.f.c.Y;
import y.f.c.Z;
import y.f.c.a;
import y.f.c.aE;
import y.f.c.aa;
import y.f.c.ae;
import y.f.c.af;
import y.f.c.ag;
import y.f.c.aj;
import y.f.c.ao;
import y.f.c.aw;
import y.f.c.e;
import y.f.c.g;
import y.f.c.h;
import y.f.c.v;
import y.f.c.x;

public class K extends y.f.c implements y.f.aF {
   private byte n = 0;
   private long u;
   private long v = 2147483647L;
   private boolean w = true;
   private int x = 1;
   private boolean y = false;
   private boolean z = true;
   private double A = 40.0D;
   private double B = 20.0D;
   private double C = 10.0D;
   private double D = 10.0D;
   private R E;
   private Q F;
   private v G;
   private ao H;
   private double I = 20.0D;
   static final Object o = "y.layout.hierarchic.HierarchicLayouter.NODE_TYPE_MAP_KEY";
   static final Object p = "y.layout.hierarchic.HierarchicLayouter.NORMAL_NODE_TYPE";
   static final Object q = "y.layout.hierarchic.HierarchicLayouter.BEND_NODE_TYPE";
   static final Object r = "y.layout.hierarchic.HierarchicLayouter.DUMMY_NODE_TYPE";
   static final Object s = "y.layout.hierarchic.HierarchicLayouter.LABEL_NODE_TYPE";
   static final Object t = "y.layout.hierarchic.HierarchicLayouter.SAME_LAYER_DUMMY_TYPE";
   private L J;

   public K() {
      this.f(false);
      this.b(false);
      this.e(true);
      this.F = new h();
      this.H = new aw();
      this.c((byte)2);
      this.b((byte)1);
   }

   public byte q() {
      return this.n;
   }

   public void b(byte var1) {
      boolean var2 = a.i;
      y.g.o.a(this, "Set Layout style: " + var1);
      switch(var1) {
      case 2:
         this.G = new aa();
         if(!var2) {
            break;
         }
      case 1:
         this.G = new V();
         if(!var2) {
            break;
         }
      case 0:
         this.G = new Z();
         if(!var2) {
            break;
         }
      case 3:
         this.G = new ag();
         if(!var2) {
            break;
         }
      case 4:
         this.G = new ae();
         if(!var2) {
            break;
         }
      case 5:
         this.G = new S(new ae());
         if(!var2) {
            break;
         }
      default:
         this.G = new V();
      }

   }

   public void c(byte var1) {
      boolean var3 = a.i;
      af var2 = null;
      switch(var1) {
      case 0:
         var2 = new af();
         var2.a((byte)0);
         this.E = var2;
         break;
      case 1:
         this.E = new aj();
         if(!var3) {
            break;
         }
      case 2:
         var2 = new af();
         var2.a((byte)2);
         this.E = var2;
         break;
      case 3:
         var2 = new af();
         var2.a((byte)1);
         this.E = var2;
         break;
      case 4:
         this.E = new g();
         if(!var3) {
            break;
         }
      case 5:
         this.E = new e();
         if(!var3) {
            break;
         }
      case 6:
         this.E = new D();
         if(var3) {
            throw new IllegalArgumentException("layeringStrategy " + var1 + " unknown.");
         }
         break;
      default:
         throw new IllegalArgumentException("layeringStrategy " + var1 + " unknown.");
      }

   }

   public void a(R var1) {
      this.E = var1;
   }

   public R a() {
      return this.E;
   }

   public void a(Q var1) {
      this.F = var1;
   }

   public Q n() {
      return this.F;
   }

   public void a(v var1) {
      this.G = var1;
      this.G.c(this.B);
      this.G.d(this.A);
   }

   public v o() {
      return this.G;
   }

   public double r() {
      return this.C;
   }

   public double s() {
      return this.I;
   }

   public boolean b(y.f.X var1) {
      return true;
   }

   public void a(y.f.X var1) {
      boolean var20 = a.i;
      this.u = System.currentTimeMillis();
      y.f.ae.a(var1, false);
      y.c.A var2 = var1.t();
      y.c.A var3 = var1.t();
      y.c.A var4 = null;
      Object var5 = var1.c(o);
      if(var5 == null) {
         var5 = var4 = var1.t();
         var1.a((Object)o, (y.c.c)var4);
         y.c.x var6 = var1.o();

         while(var6.f()) {
            var4.a(var6.e(), p);
            var6.g();
            if(var20) {
               y.c.i.g = !y.c.i.g;
               break;
            }
         }
      }

      y.c.D var21 = new y.c.D();
      y.c.A var7 = null;
      y.c.h var8 = null;
      y.g.ap var9 = null;
      y.g.ap var10 = null;
      if(this.J != null) {
         y.c.c var11 = var1.c(y.f.ah.f_);
         if(var11 == null) {
            throw new IllegalStateException("No DataProvider " + y.f.ah.f_ + " bound to graph!");
         }

         y.c.c var12 = var1.c(y.f.ah.k);
         if(var12 == null) {
            throw new IllegalStateException("No DataProvider " + y.f.ah.k + " bound to graph!");
         }

         var7 = var1.t();
         var8 = var1.u();
         var9 = new y.g.ap(var7, var1, y.f.ah.f_);
         var10 = new y.g.ap(var8, var1, y.f.ah.k);
         this.J.a((y.c.c)var5, var2, var3, this.E, var21, this.F, var9, var7, var10, var8);
      }

      y.c.h var22 = var1.u();
      y.c.f var23 = new y.c.f();
      aE var13 = new aE(var1, var2, var3, var22);
      var13.a(true);
      x var14 = new x(var1, var2, var3, var22, var21);
      var14.a(this.y);
      var14.b(this.z);
      if(var7 != null) {
         var14.a(var7, var9, var8, var10);
      }

      label98: {
         boolean var15 = this.q() == 1;
         var14.c(var15);
         var14.a(this.r());
         var14.b(this.s());
         if(var15) {
            var14.c(this.A);
            this.G.d(0.0D);
            if(!var20) {
               break label98;
            }
         }

         var14.c(this.A);
         this.G.d(0.0D);
      }

      int var16;
      label114: {
         this.G.c(this.B);
         this.G.a(this.C);
         this.G.b(this.D);
         this.G.a(var3);
         var14.b();
         if(this.J != null && (this.J.a((byte)1) || this.J.b() != null)) {
            var16 = this.J.a(var1, var2, var23);
            if(!var20) {
               break label114;
            }
         }

         var16 = this.E.a(var1, var2, var23);
         int var17 = 0;

         while(var17 < var16) {
            var21.add("LayerID" + var17);
            ++var17;
            if(var20) {
               break;
            }
         }
      }

      y.c.p var24 = var23.k();

      while(true) {
         if(var24 != null) {
            var22.a(var24.c(), true);
            var24 = var24.a();
            if(var20) {
               break;
            }

            if(!var20) {
               continue;
            }
         }

         var16 = var14.a(var16, var23);
         var16 = var14.a(var16);
         this.H.a(var1, var2, var3);
         var16 = var14.b(var16);
         var16 = var14.c(var16);
         break;
      }

      if(this.n() instanceof h) {
         h var25 = (h)this.n();
         var25.b(this.w);
         long var18 = System.currentTimeMillis() - this.u;
         var25.a(this.v - var18);
      }

      y.c.y[] var26 = this.a(var1, var2, var16);
      var26 = var14.a(var26);
      var26 = var13.a(var26);
      var26 = var14.b(var26);
      this.G.a(var1, var26, var2);
      var26 = var14.c(var26);
      var14.d(var26);
      var13.a(var14.f());
      var14.c();
      this.H.b(var1, var2, var3);
      var14.d();
      this.d(var1);
      this.a(var1, var23);
      var14.e();
      var13.c();
      if(var4 != null) {
         var1.d_(o);
         var1.a((y.c.A)var4);
      }

      if(var9 != null) {
         var9.b();
      }

      if(var10 != null) {
         var10.b();
      }

      if(var7 != null) {
         var1.a((y.c.A)var7);
      }

      if(var8 != null) {
         var1.a((y.c.h)var8);
      }

      var1.a((y.c.h)var22);
      var1.a((y.c.A)var3);
      var1.a((y.c.A)var2);
   }

   protected y.c.y[] a(y.f.X var1, y.c.A var2, int var3) {
      return this.J == null || !this.J.a((byte)2) && this.J.b() == null?this.F.a(var1, var2, var3):this.J.a(var1, var2, var3);
   }

   static y.c.A a(y.c.i var0) {
      return (y.c.A)var0.c(o);
   }

   static Object a(y.c.y var0, y.c.c var1) {
      boolean var10 = a.i;
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      y.c.p var8 = var0.k();

      Object var10000;
      while(true) {
         if(var8 != null) {
            Object var9 = var1.b(var8.c());
            var10000 = var9;
            if(var10) {
               break;
            }

            label74: {
               if(var9 == null) {
                  ++var2;
                  if(!var10) {
                     break label74;
                  }
               }

               if(var9 == p) {
                  ++var3;
                  if(!var10) {
                     break label74;
                  }
               }

               if(var9 == r) {
                  ++var5;
                  if(!var10) {
                     break label74;
                  }
               }

               if(var9 == q) {
                  ++var6;
                  if(!var10) {
                     break label74;
                  }
               }

               if(var9 == s) {
                  ++var4;
               }
            }

            ++var7;
            var8 = var8.a();
            if(!var10) {
               continue;
            }
         }

         if(var7 == var2) {
            return p;
         }

         var7 -= var2;
         if(var7 == var4) {
            return s;
         }

         if(var7 == var6) {
            return q;
         }

         if(var7 == var4 + var6) {
            return q;
         }

         if(var7 == var5 + var6) {
            return r;
         }

         if(var7 == var3 + var6 + var4) {
            return p;
         }

         var10000 = var5 > 0?r:p;
         break;
      }

      return var10000;
   }

   private void a(y.f.X var1, y.c.f var2) {
      boolean var8 = a.i;
      y.c.e var3 = var2.a();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         y.d.t var5 = var1.p(var4);
         y.d.t var6 = var1.q(var4);
         var1.c(var4);
         y.d.v var7 = var1.j(var4);
         var1.b(var4, var7.g());
         var1.d(var4, var5);
         var1.c(var4, var6);
         var3.g();
         if(var8) {
            break;
         }
      }

   }

   private void d(y.f.X var1) {
      boolean var25 = a.i;
      y.c.e var2 = var1.p();

      while(var2.f()) {
         label51: {
            y.c.d var3 = var2.a();
            y.f.I var4 = var1.g(var3);
            if(var4.pointCount() > 0) {
               ArrayList var5;
               int var10000;
               label48: {
                  var5 = new ArrayList(var4.pointCount());
                  y.d.v var6 = var1.l(var3);
                  y.c.C var7 = var6.a();
                  y.d.t var8 = (y.d.t)var7.d();
                  var7.g();
                  double var9 = var8.a();
                  double var11 = var8.b();
                  if(var7.f()) {
                     var8 = (y.d.t)var7.d();
                     double var13 = var8.a();
                     double var15 = var8.b();
                     var7.g();

                     while(var7.f()) {
                        y.d.t var23 = (y.d.t)var7.d();
                        double var19 = var23.a();
                        double var17 = var23.b();
                        double var21 = (var9 - var19) * (var15 - var17) / (var11 - var17) + var19;
                        double var27;
                        var10000 = (var27 = Math.abs(var21 - var13) - (double)this.x) == 0.0D?0:(var27 < 0.0D?-1:1);
                        if(var25) {
                           break label48;
                        }

                        if(var10000 > 0) {
                           var5.add(var8);
                           var9 = var13;
                           var11 = var15;
                        }

                        var8 = var23;
                        var13 = var19;
                        var15 = var17;
                        var7.g();
                        if(var25) {
                           break;
                        }
                     }
                  }

                  var10000 = var5.size();
               }

               if(var10000 < var4.pointCount()) {
                  var4.clearPoints();
                  int var26 = 0;

                  while(var26 < var5.size()) {
                     y.d.t var24 = (y.d.t)var5.get(var26);
                     var4.addPoint(var24.a, var24.b);
                     ++var26;
                     if(var25) {
                        break label51;
                     }

                     if(var25) {
                        break;
                     }
                  }
               }
            }

            var2.g();
         }

         if(var25) {
            break;
         }
      }

   }

   public Y t() {
      if(this.J == null) {
         this.J = new L();
      }

      return this.J;
   }

   boolean u() {
      return this.J != null && this.t().b() != null;
   }

   public void v() {
      if(this.J != null) {
         this.J.c();
         this.J = null;
      }

   }
}
