package y.h;

import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y.h.G;
import y.h.H;
import y.h.I;
import y.h.J;
import y.h.K;
import y.h.L;
import y.h.aB;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.dI;
import y.h.dU;
import y.h.eR;
import y.h.eU;
import y.h.ek;
import y.h.el;
import y.h.en;
import y.h.fL;
import y.h.fj;
import y.h.fu;
import y.h.gU;
import y.h.gX;
import y.h.gn;
import y.h.x;

public class F extends gX {
   private y.c.q a;
   private boolean b;
   private boolean c;
   private boolean d;
   private boolean e;
   private boolean f;
   private boolean g;
   private KeyListener h;
   private y.c.o i;
   private PropertyChangeListener j;
   private int k;
   private L l;
   private y.c.q m;
   private y.c.q n;
   private y.c.d o;
   private boolean p;
   private boolean q;
   private boolean r;
   private double s;
   private boolean t;
   private int u;
   private boolean v;
   private List w;
   private List x;
   private boolean y;
   private dU z;
   private en A;
   private boolean B;
   private boolean C;
   private boolean D;
   private boolean E;
   private y.c.q F;
   private boolean G;
   private boolean H;
   private boolean I;
   private eU J;
   private eU K;
   private eU L;
   private int M;

   public F(gU var1) {
      super(var1);
      this.c = true;
      this.e = true;
      this.f = true;
      this.k = 27;
      this.l = new L(this);
      this.t = true;
      this.u = 10;
      this.v = true;
      this.I = true;
      this.M = 2;
      this.g = false;
      this.j = new G(this);
   }

   public dU a() {
      if(this.z == null) {
         this.z = this.c();
      }

      return this.z;
   }

   protected dU c() {
      dU var1 = new dU(this.view);
      var1.c(true);
      var1.g(true);
      var1.b(15.0D);
      var1.c(20.0D);
      return var1;
   }

   public F() {
      this((gU)null);
   }

   public void init() {
      this.c = true;
   }

   public boolean e() {
      return this.I;
   }

   public boolean f() {
      return this.D;
   }

   public void a(boolean var1) {
      this.D = var1;
   }

   public void a(double var1) {
      this.s = var1;
   }

   public void b(boolean var1) {
      this.e = var1;
   }

   public void mousePressedLeft(double var1, double var3) {
      this.g = true;
      this.a(var1, var3, false);
   }

   public void mouseShiftPressedLeft(double var1, double var3) {
      this.g = true;
      this.a(var1, var3, true);
   }

   static int a(byte var0, fj var1) {
      boolean var16 = fj.z;
      int var2 = 0;
      y.c.e var3 = var1.getNode().j();
      bu var4 = var1.d();
      y.c.e var5 = var3;

      do {
         boolean var10000 = var5.f();

         double var11;
         double var13;
         label79:
         while(true) {
            if(!var10000) {
               return var2;
            }

            y.c.d var6 = var5.a();
            aB var7 = var4.i(var6);
            y.c.q var8 = var1.getNode();
            y.d.v var9 = var4.l(var6);
            y.d.m var10;
            int var15;
            if(var6.c() == var8) {
               var15 = -1;

               while(var15 + 1 < var7.bendCount()) {
                  var10000 = var1.contains(var7.getBend(var15 + 1).b(), var7.getBend(var15 + 1).c());
                  if(var16) {
                     continue label79;
                  }

                  if(!var10000) {
                     break;
                  }

                  ++var15;
                  if(var16) {
                     break;
                  }
               }

               var10 = var9.a(var15 + 1);
               var11 = var10.d().a - var10.c().a;
               var13 = var10.d().b - var10.c().b;
               if(!var16) {
                  break;
               }
            }

            var15 = var7.bendCount();

            while(var15 - 1 >= 0) {
               var10000 = var1.contains(var7.getBend(var15 - 1).b(), var7.getBend(var15 - 1).c());
               if(var16) {
                  continue label79;
               }

               if(!var10000) {
                  break;
               }

               --var15;
               if(var16) {
                  break;
               }
            }

            var10 = var9.a(var15);
            var11 = var10.c().a - var10.d().a;
            var13 = var10.c().b - var10.d().b;
            break;
         }

         byte var17;
         label50: {
            var17 = -1;
            if(Math.abs(var11) > Math.abs(var13)) {
               if(Math.abs(var13) >= 0.001D) {
                  break label50;
               }

               var17 = (byte)(var11 > 0.0D?1:3);
               if(!var16) {
                  break label50;
               }
            }

            if(Math.abs(var11) < 0.001D) {
               var17 = (byte)(var13 > 0.0D?2:0);
            }
         }

         if(var0 == var17) {
            ++var2;
         }

         var5.g();
      } while(!var16);

      return var2;
   }

   void a(double var1, double var3, boolean var5) {
      boolean var16 = fj.z;
      this.C = var5;
      if(this.c) {
         this.F = null;
         this.L = null;
         this.J = null;
         this.K = null;
         bu var6 = this.getGraph2D();
         this.a = this.a(var1, var3);
         if(this.a == null) {
            this.reactivateParent();
            return;
         }

         if(!this.d(this.a, var1, var3)) {
            this.c(this.a, var1, var3);
            return;
         }

         if(this.a(var6, this.a)) {
            this.J = this.a(this.a, var1, var3);
            if(!this.b(this.a, this.J, var1, var3)) {
               this.a(this.a, this.J, var1, var3);
               return;
            }
         } else {
            this.J = null;
         }

         if(this.h == null) {
            this.h = new H(this);
            this.view.getCanvasComponent().addKeyListener(this.h);
         }

         if(this.i == null) {
            this.i = new I(this);
            var6.a((y.c.o)this.i);
         }

         double var8;
         double var10;
         dU var12;
         label69: {
            this.view.addPropertyChangeListener("Graph2D", this.j);
            this.l.j();
            this.F = null;
            this.L = null;
            this.view.addDrawable(this.l);
            this.setEditing(true);
            this.n = this.l.a(this.a(var6.t(this.a)));
            this.m = this.l.a(this.b(var1, var3));
            this.o = this.l.a(this.n, this.m, this.g());
            this.d = false;
            var6.b((byte)1);
            this.view.setDrawingMode(3);
            this.b = true;
            this.c = false;
            this.p = true;
            this.q = false;
            fj var7 = this.l.t(this.n);
            var8 = var1 - var7.getCenterX();
            var10 = var3 - var7.getCenterY();
            this.a(var6);
            var12 = this.a();
            var12.a((ch)this.view);
            List var13 = Collections.EMPTY_LIST;
            List var14 = var12.n()?Collections.singletonList(this.m):var13;
            if(this.j() && this.f() || var12.n()) {
               var12.a(new y.d.t(var1, var3), var14, var13, Collections.EMPTY_SET, y.g.q.a((Object)null));
               if(!var16) {
                  break label69;
               }
            }

            var12.f();
         }

         if(this.j() && this.f()) {
            var12.b(this.A);
            this.A = null;
         }

         if(this.J != null) {
            this.l.t(this.n).getPort(eU.e(this.J)).a(this.l.i(this.o));
            if(!var16) {
               return;
            }
         }

         y.d.t var15 = this.a(var5, this.a, var8, var10);
         this.l.i(this.o).getSourcePort().b(var15.a, var15.b);
      }

   }

   protected y.c.q a(double var1, double var3) {
      if(this.e()) {
         cW var5 = this.getHitInfo(var1, var3);
         return var5.t()?var5.i():(var5.p()?var5.o().b().getNode():null);
      } else {
         return this.getHitInfo(var1, var3).i();
      }
   }

   private void a(bu var1) {
      boolean var4 = fj.z;
      if(!this.y) {
         this.w = this.x = null;
      }

      this.w = new ArrayList();
      y.c.x var2 = var1.o();

      F var10000;
      while(true) {
         if(var2.f()) {
            fj var3 = var1.t(var2.e());
            var10000 = this;
            if(var4) {
               break;
            }

            if(this.view.getVisibleRect().intersects(var3.getX(), var3.getY(), var3.getWidth(), var3.getHeight())) {
               this.w.add(var3);
            }

            var2.g();
            if(!var4) {
               continue;
            }
         }

         y.g.e.a((List)this.w, new J(this));
         this.x = new ArrayList(this.w);
         var10000 = this;
         break;
      }

      y.g.e.a((List)var10000.x, new K(this));
   }

   private fj a(double var1, List var3) {
      boolean var10 = fj.z;
      if(var3 != null && var3.size() > 0) {
         int var4 = 0;
         int var5 = var3.size() - 1;
         if(((fj)var3.get(var4)).getCenterX() > var1) {
            return (fj)var3.get(var4);
         } else if(((fj)var3.get(var5)).getCenterX() < var1) {
            return (fj)var3.get(var5);
         } else {
            double var10000;
            double var10001;
            while(true) {
               if(var4 < var5 - 1) {
                  int var6 = (var4 + var5) / 2;
                  fj var7 = (fj)var3.get(var6);
                  var10000 = var7.getCenterX();
                  var10001 = var1;
                  if(var10) {
                     break;
                  }

                  if(var10000 == var1) {
                     return var7;
                  }

                  if(var7.getCenterX() < var1) {
                     var4 = var6;
                     if(!var10) {
                        continue;
                     }
                  }

                  var5 = var6;
                  if(!var10) {
                     continue;
                  }
               }

               var10000 = ((fj)var3.get(var4)).getCenterX();
               var10001 = var1;
               break;
            }

            double var11 = Math.abs(var10000 - var10001);
            double var8 = Math.abs(((fj)var3.get(var5)).getCenterX() - var1);
            return var11 < var8?(fj)var3.get(var4):(fj)var3.get(var5);
         }
      } else {
         return null;
      }
   }

   private fj b(double var1, List var3) {
      boolean var10 = fj.z;
      if(var3 != null && var3.size() > 0) {
         int var4 = 0;
         int var5 = var3.size() - 1;
         if(((fj)var3.get(var4)).getCenterY() > var1) {
            return (fj)var3.get(var4);
         } else if(((fj)var3.get(var5)).getCenterY() < var1) {
            return (fj)var3.get(var5);
         } else {
            double var10000;
            double var10001;
            while(true) {
               if(var4 < var5 - 1) {
                  int var6 = (var4 + var5) / 2;
                  fj var7 = (fj)var3.get(var6);
                  var10000 = var7.getCenterY();
                  var10001 = var1;
                  if(var10) {
                     break;
                  }

                  if(var10000 == var1) {
                     return var7;
                  }

                  if(var7.getCenterY() < var1) {
                     var4 = var6;
                     if(!var10) {
                        continue;
                     }
                  }

                  var5 = var6;
                  if(!var10) {
                     continue;
                  }
               }

               var10000 = ((fj)var3.get(var4)).getCenterY();
               var10001 = var1;
               break;
            }

            double var11 = Math.abs(var10000 - var10001);
            double var8 = Math.abs(((fj)var3.get(var5)).getCenterY() - var1);
            return var11 < var8?(fj)var3.get(var4):(fj)var3.get(var5);
         }
      } else {
         return null;
      }
   }

   protected y.d.t a(boolean var1, y.c.q var2, double var3, double var5) {
      if(var1) {
         fj var7 = this.getGraph2D().t(var2);
         double var8 = var7.getCenterX() + var3;
         double var10 = var7.getCenterY() + var5;
         double var12 = this.getGridX(var8) - var7.getCenterX();
         double var14 = this.getGridY(var10) - var7.getCenterY();
         return new y.d.t(var12, var14);
      } else {
         return y.d.t.c;
      }
   }

   private boolean a(bu var1, y.c.q var2) {
      return this.e() && var2 != null && var1.t(var2).portCount() > 0;
   }

   protected eU a(y.c.q var1, double var2, double var4) {
      return this.g(var1, var2, var4);
   }

   private eU g(y.c.q var1, double var2, double var4) {
      fj var6 = this.view.getGraph2D().t(var1);
      return eU.a(var6, var2, var4);
   }

   protected aB g() {
      return this.getGraph2D().G().createCopy();
   }

   protected aB h() {
      if(this.l != null && this.l.g() >= 1) {
         return this.l.i(this.o);
      } else {
         throw new IllegalStateException("EdgeRealizer not yet created!");
      }
   }

   protected fj a(fj var1) {
      return var1.createCopy();
   }

   protected fj b(double var1, double var3) {
      gn var5 = new gn();
      var5.setSize(0.1D, 0.1D);
      var5.setVisible(false);
      var5.setCenter(var1, var3);
      var5.setShapeType((byte)0);
      return var5;
   }

   public void mouseReleasedRight(double var1, double var3) {
      this.g = false;
      if(this.p) {
         bu var5 = this.getGraph2D();
         aB var6 = this.l.i(this.o);
         int var7 = var6.bendCount();
         if(var7 > Math.max(var6.getMinBendCount(), this.j()?1:0)) {
            this.a(var6, var7 - 1);
            this.a(var6);
            if(this.a().l()) {
               this.a().b(this.A);
               this.A = null;
               x var8 = this.h().lastBend();
               if(var8 != null) {
                  y.d.t var9 = this.a().k();
                  double var10 = var1 - var9.a;
                  double var12 = var3 - var9.b;
                  y.d.t var14 = new y.d.t(var1 - var10, var3 - var12);
                  boolean var15 = this.B != (this.h().bendCount() % 2 == 1);
                  y.d.t var16 = var15?new y.d.t(var14.a(), var8.c()):new y.d.t(var8.b(), var14.b());
                  ek var17 = new ek((x)null, var16, (byte)(var15?1:2));
                  ek var18 = new ek((x)null, var14, (byte)3);
                  this.A = this.a().a((el)var17, (el)var18);
               }

               this.a().h();
            }

            this.view.updateView();
            if(!fj.z) {
               return;
            }
         }

         this.n();
         var5.T();
         this.reactivateParent();
      }
   }

   protected void a(aB var1, int var2) {
      var1.removeBend(var1.getBend(var2));
   }

   private void a(aB var1) {
      fj var2 = var1.getTargetRealizer();
      fL var3 = var1.getTargetPort();
      this.a(var3.a(var2), var3.b(var2), var1);
   }

   public void mouseShiftReleasedLeft(double var1, double var3) {
      this.g = false;
      this.c(var1, var3, true);
   }

   public void mouseReleasedLeft(double var1, double var3) {
      this.g = false;
      this.c(var1, var3, false);
   }

   public int i() {
      return this.M;
   }

   protected boolean a(MouseEvent var1) {
      return (var1.getModifiers() & this.i()) != 0;
   }

   void c(double var1, double var3, boolean var5) {
      boolean var26 = fj.z;
      if(this.p) {
         if(this.C != var5) {
            this.C = var5;
         }

         Double var6 = new Double(var1, var3);
         var6.x = this.getGridX(var6.x);
         var6.y = this.getGridY(var6.y);
         boolean var11 = this.a(var6, this.h(), this.a(this.lastReleaseEvent));
         double var7 = var6.x;
         double var9 = var6.y;
         bu var12 = this.getGraph2D();
         y.c.q var13 = this.d(var1, var3);
         aB var14 = this.l.i(this.o);
         if(this.a(this.a, var13, var6.x, var6.y)) {
            if(!this.e) {
               return;
            }

            this.a(var14, var7, var9);
            this.mouseMoved(var1, var3);
            if(this.a().l()) {
               this.a().b(this.A);
               this.A = null;
               x var15 = this.h().lastBend();
               if(var15 != null) {
                  y.d.t var16 = this.a().k();
                  double var17 = var1 - var16.a;
                  double var19 = var3 - var16.b;
                  y.d.t var21 = new y.d.t(var6.x - var17, var6.y - var19);
                  boolean var22 = this.B != (this.h().bendCount() % 2 == 1);
                  y.d.t var23 = var22?new y.d.t(var21.a(), var15.c()):new y.d.t(var15.b(), var21.b());
                  ek var24 = new ek((x)null, var23, (byte)(var22?1:2));
                  ek var25 = new ek((x)null, var21, (byte)3);
                  this.A = this.a().a((el)var24, (el)var25);
                  this.a().h();
               }
            }

            var12.T();
            if(!var26) {
               return;
            }
         }

         if(!this.q) {
            if(this.k()) {
               this.n();
            }

         } else if(this.a != var13 || this.f) {
            y.c.q var28 = this.d?this.a:var13;
            if(!this.f(var28, var6.x, var6.y)) {
               this.e(var28, var6.x, var6.y);
            } else {
               if(this.a(var12, var28)) {
                  this.K = this.b(var28, var7, var9);
                  if(!this.d(var28, this.K, var7, var9)) {
                     this.c(var28, this.K, var7, var9);
                     return;
                  }
               } else {
                  this.K = null;
               }

               this.view.removeDrawable(this.l);
               this.l.a(this.o);
               var12.b((byte)0);
               this.view.setDrawingMode(0);
               y.c.d var27 = this.a(var12, this.a, var28, var14);
               this.w = this.x = null;
               this.a().f();
               if(var27 != null) {
                  y.d.t var30;
                  label72: {
                     var14 = var12.i(var27);
                     fj var29 = var12.t(var28);
                     double var18 = var7 - var29.getCenterX();
                     double var20 = var9 - var29.getCenterY();
                     if(this.K != null) {
                        var30 = eU.b(this.K);
                        if(!var26) {
                           break label72;
                        }
                     }

                     var30 = this.a(var27, var5, var28, var18, var20, var11, var7, var9);
                  }

                  var14.getTargetPort().b(var30.a, var30.b);
                  this.a(var12.q(var27).a, var12.q(var27).b, var14);
                  this.b(var27);
                  this.a(var27);
               }

               this.setEditing(false);
               var12.T();
               this.reactivateParent();
            }
         }
      }
   }

   protected cW c(double var1, double var3) {
      int var5 = 1;
      if(this.e()) {
         var5 |= 64;
      }

      return this.view.getHitInfoFactory().a(var1, var3, var5, true);
   }

   protected y.c.q d(double var1, double var3) {
      if(this.e()) {
         cW var5 = this.c(var1, var3);
         return var5.t()?var5.i():(var5.p()?var5.o().b().getNode():null);
      } else {
         return this.c(var1, var3).i();
      }
   }

   private void b(y.c.d var1) {
      boolean var14 = fj.z;
      aB var2 = this.getGraph2D().i(var1);
      if(var2.getMinBendCount() <= 0) {
         fj var3 = var2.getTargetRealizer();
         if(this.j()) {
            if(var1.e()) {
               label68: {
                  y.d.t var4 = this.getGraph2D().p(var1);
                  x var6;
                  if(var2.bendCount() == 0) {
                     var6 = var2.appendBend(var4.a, var3.getY() - 15.0D);
                     if(var6 == null) {
                        break label68;
                     }

                     var6 = var2.appendBend(var3.getX() + var3.getWidth() + 15.0D, var6.c());
                     if(var6 == null) {
                        break label68;
                     }

                     var2.appendBend(var6.b(), this.getGraph2D().q(var1).b);
                     if(!var14) {
                        break label68;
                     }
                  }

                  if(var2.bendCount() == 1) {
                     label69: {
                        var6 = var2.firstBend();
                        double var7 = var4.a - var6.b();
                        double var9 = var4.b - var6.c();
                        if(var7 == 0.0D && var9 == 0.0D) {
                           var6.a(var4.a, var3.getY() - 15.0D);
                           var9 = var4.b - var6.c();
                        }

                        double var11;
                        x var13;
                        if(Math.abs(var7) > Math.abs(var9)) {
                           var11 = Math.max(15.0D, var7 > 0.0D?var6.b() - (var3.getX() + var3.getWidth()):var6.b() - var3.getX());
                           var13 = var2.appendBend(var6.b(), var3.getY() - Math.abs(var11));
                           if(var13 == null) {
                              break label69;
                           }

                           var2.appendBend(this.getGraph2D().q(var1).a, var13.c());
                           if(!var14) {
                              break label69;
                           }
                        }

                        var11 = Math.max(15.0D, var9 > 0.0D?var6.c() - (var3.getY() + var3.getHeight()):var6.c() - var3.getY());
                        var13 = var2.appendBend(var3.getX() - Math.abs(var11), var6.c());
                        if(var13 != null) {
                           var2.appendBend(var13.b(), this.getGraph2D().q(var1).b);
                        }
                     }
                  }
               }
            }

            fu.a(var2);
         }

         if(this.E) {
            fu.c(var2);
         }

      }
   }

   protected void a(aB var1, double var2, double var4) {
      var1.appendBend(var2, var4);
   }

   protected y.d.t b(boolean var1, y.c.q var2, double var3, double var5) {
      if(var1) {
         fj var7 = this.getGraph2D().t(var2);
         double var8 = var7.getCenterX() + var3;
         double var10 = var7.getCenterY() + var5;
         double var12 = this.getGridX(var8) - var7.getCenterX();
         double var14 = this.getGridY(var10) - var7.getCenterY();
         return new y.d.t(var12, var14);
      } else {
         return y.d.t.c;
      }
   }

   protected eU b(y.c.q var1, double var2, double var4) {
      return this.g(var1, var2, var4);
   }

   protected y.d.t a(y.c.d var1, boolean var2, y.c.q var3, double var4, double var6, boolean var8, double var9, double var11) {
      aB var13 = this.getGraph2D().i(var1);
      y.d.t var14 = var13.bendCount() > 0?var13.lastBend().e():this.getGraph2D().p(var1);
      fj var15 = var13.getTargetRealizer();
      y.d.t var16 = var8?new y.d.t(var9, var11):new y.d.t(var15.getCenterX() + var4, var15.getCenterY() + var6);
      double var17 = var14.a - var16.a;
      double var19 = var14.b - var16.b;
      if(this.H && (Math.abs(var17) < 0.1D || Math.abs(var19) < 0.1D)) {
         byte var21;
         label56: {
            if(Math.abs(var17) > Math.abs(var19)) {
               var21 = (byte)(var17 > 0.0D?1:3);
               if(!fj.z) {
                  break label56;
               }
            }

            var21 = (byte)(var19 > 0.0D?2:0);
         }

         y.c.i var22 = var1.a();
         var22.d(var1);
         int var23 = var21 >= 0?a(var21, var15):0;
         var22.e(var1);
         if(var23 == 0) {
            return this.b(var2, var3, var4, var6);
         } else {
            double var24 = var9 - var15.getCenterX();
            double var26 = var11 - var15.getCenterY();
            return new y.d.t(var24, var26);
         }
      } else {
         return this.b(var2, var3, var4, var6);
      }
   }

   protected y.c.d a(bu var1, y.c.q var2, y.c.q var3, aB var4) {
      if(var1 != var2.e() || var1 != var3.e()) {
         y.h.a.v var5 = var1.C();
         if(var5 != null) {
            var1.r();

            y.c.d var6;
            try {
               var6 = var5.a(var2, var3);
               var1.a(var6, var4);
            } finally {
               var1.s();
            }

            return var6;
         }
      }

      return var1.a(var2, var3, var4);
   }

   protected boolean a(y.c.q var1, y.c.q var2, double var3, double var5) {
      boolean var13 = fj.z;
      boolean var7 = var2 == null;
      if(!var7) {
         y.h.a.v var8 = y.h.a.v.a((y.c.i)this.getGraph2D());
         if(var8 != null) {
            fj var9 = this.getGraph2D().t(var2);
            if(var8.k(var2)) {
               if(this.m()) {
                  cW var10 = this.e(var3, var5);
                  y.c.C var11 = var10.g();

                  while(var11.f()) {
                     eR var12 = (eR)var11.d();
                     if(var13) {
                        return var7;
                     }

                     if(var12.f() == var2 && var9.getLabel(0) == var12) {
                        return false;
                     }

                     var11.g();
                     if(var13) {
                        break;
                     }
                  }
               }

               int var14 = this.l();
               if(var3 >= var9.getX() + (double)var14 && var3 <= var9.getX() + var9.getWidth() - (double)var14 && var5 >= var9.getY() + (double)var14 && var5 <= var9.getY() + var9.getHeight() - (double)var14) {
                  return true;
               }
            }
         }
      }

      return var7;
   }

   public void mouseDraggedLeft(double var1, double var3) {
      boolean var23 = fj.z;
      if(this.p) {
         MouseEvent var5 = this.lastDragEvent;
         if(this.lastDragEvent != null && this.lastMoveEvent != null && this.lastMoveEvent.getWhen() > this.lastDragEvent.getWhen()) {
            var5 = this.lastMoveEvent;
         }

         boolean var6 = this.B;
         if(var5 != null && this.C != this.isModifierPressed(var5)) {
            this.C = !this.C;
            if(this.C && this.h().bendCount() == 1) {
               this.B = !this.B;
            }
         }

         if(this.h().bendCount() < 2 && this.j() && this.lastPressEvent != null && var5 != null && this.lastPressEvent.getWhen() + 200L > var5.getWhen()) {
            int var7 = var5.getX() - this.lastPressEvent.getX();
            int var8 = var5.getY() - this.lastPressEvent.getY();
            this.B = this.a(var7, var8, this.a);
         }

         bu var24 = this.getGraph2D();
         Double var25 = new Double(var1, var3);
         y.c.q var9 = this.a(var24, var25.x, var25.y);
         if(var9 != this.a) {
            this.q = true;
         }

         boolean var10 = this.a(var24, var9);
         this.F = null;
         this.L = null;
         if(this.G && (this.q || this.d) && !this.a(this.a, var9, var1, var3) && this.f(var9, var25.x, var25.y)) {
            this.F = var9;
            if(var10) {
               this.L = this.b(var9, var1, var3);
               if(!this.d(this.F, this.L, var1, var3)) {
                  this.F = null;
                  this.L = null;
               }
            }
         }

         label125: {
            var25.x = this.getGridX(var25.x);
            var25.y = this.getGridY(var25.y);
            aB var11 = this.h();
            this.a(var25, var11, this.o());
            if(var9 == this.a && this.f && (!var10 || this.L != null)) {
               int var12;
               eU var13;
               if(!this.b) {
                  this.b = true;
                  if(var11.bendCount() != var11.getMinBendCount()) {
                     break label125;
                  }

                  this.l.a(this.o);
                  this.o = this.l.a(this.n, this.n, var11);
                  this.d = true;
                  if(!var10 || this.L == null) {
                     break label125;
                  }

                  var12 = eU.e(this.L);
                  var13 = this.l.t(this.n).getPort(var12);
                  var13.c(var11);
                  if(!var23) {
                     break label125;
                  }
               }

               if(!this.d || !var10) {
                  break label125;
               }

               var12 = eU.e(this.L);
               var13 = this.l.t(this.n).getPort(var12);
               var13.c(var11);
               if(!var23) {
                  break label125;
               }
            }

            if(this.b) {
               this.b = false;
               if(this.d) {
                  this.l.a(this.o);
                  var11.clearBends();
                  this.o = this.l.a(this.n, this.m, var11);
                  this.d = false;
                  eU.b((eU)null, var11);
                  var11.setTargetPoint(y.d.t.c);
               }
            }
         }

         this.l.t(this.m).setCenter(var25.x, var25.y);
         this.a(var25);
         this.f(var25.x, var25.y);
         if((this.B != var6 || this.A == null) && this.a().l()) {
            this.a().b(this.A);
            this.A = null;
            x var26 = this.h().lastBend();
            if(var26 != null) {
               y.d.t var27 = this.a().k();
               double var14 = var1 - var27.a;
               double var16 = var3 - var27.b;
               y.d.t var18 = new y.d.t(var25.x - var14, var25.y - var16);
               boolean var19 = !this.B;
               y.d.t var20 = var19?new y.d.t(var18.a(), var26.c()):new y.d.t(var26.b(), var18.b());
               ek var21 = new ek((x)null, var20, (byte)(!this.B?1:2));
               ek var22 = new ek((x)null, var18, (byte)3);
               this.A = this.a().a((el)var21, (el)var22);
            }

            this.a().h();
         }

         this.view.updateView();
      }
   }

   protected boolean a(int var1, int var2, y.c.q var3) {
      byte var4;
      if(Math.abs(var1) > Math.abs(var2)) {
         var4 = (byte)(var1 > 0?1:3);
         if(!fj.z) {
            return a(var4, this.getGraph2D().t(var3)) == 0?Math.abs(var2) > Math.abs(var1):Math.abs(var1) > Math.abs(var2);
         }
      }

      var4 = (byte)(var2 > 0?2:0);
      return a(var4, this.getGraph2D().t(var3)) == 0?Math.abs(var2) > Math.abs(var1):Math.abs(var1) > Math.abs(var2);
   }

   private boolean a(Double var1, aB var2, boolean var3) {
      boolean var15 = fj.z;
      if(var3) {
         this.a().h();
         return false;
      } else if(this.a().l()) {
         y.d.t var16 = new y.d.t(var1.x, var1.y);
         y.d.t var5 = this.a().b(var16);
         var1.x = var5.a;
         var1.y = var5.b;
         return var16 != var5;
      } else if(this.s > 0.0D && !this.j()) {
         double var4;
         double var6;
         label64: {
            if(var2.bendCount() > 0) {
               var4 = var2.lastBend().b();
               var6 = var2.lastBend().c();
               if(!var15) {
                  break label64;
               }
            }

            y.d.t var8 = ((bu)var2.getEdge().a()).p(var2.getEdge());
            var4 = var8.a;
            var6 = var8.b;
         }

         boolean var12;
         boolean var13;
         label59: {
            double var17 = Math.abs(var1.x - var4);
            double var10 = Math.abs(var1.y - var6);
            var12 = false;
            var13 = false;
            if(var17 < var10) {
               if(var17 * this.view.getZoom() >= this.s) {
                  break label59;
               }

               var1.x = var4;
               var12 = true;
               if(!var15) {
                  break label59;
               }
            }

            if(var10 * this.view.getZoom() < this.s) {
               var1.y = var6;
               var13 = true;
            }
         }

         if(this.y) {
            fj var14;
            if(!var12) {
               var14 = this.a(var1.x, this.w);
               if(var14 != null && Math.abs(var14.getCenterX() - var1.x) < this.s) {
                  var1.x = var14.getCenterX();
                  var12 = true;
               }
            }

            if(!var13) {
               var14 = this.b(var1.y, this.x);
               if(var14 != null && Math.abs(var14.getCenterY() - var1.y) < this.s) {
                  var1.y = var14.getCenterY();
                  var13 = true;
               }
            }
         }

         return var12 || var13;
      } else {
         return false;
      }
   }

   private void a(Double var1) {
      this.a(var1.x, var1.y, this.h());
   }

   protected y.c.q a(bu var1, double var2, double var4) {
      return var1.t(this.a).contains(var2, var4)?this.a:this.d(var2, var4);
   }

   public void mouseMoved(double var1, double var3) {
      this.mouseDraggedLeft(var1, var3);
   }

   public void reactivateParent() {
      this.p();
      this.p = false;
      this.c = true;
      this.w = this.x = null;
      super.reactivateParent();
   }

   public boolean j() {
      return this.r;
   }

   public boolean k() {
      return this.t;
   }

   public int l() {
      return this.u;
   }

   public boolean m() {
      return this.v;
   }

   protected cW e(double var1, double var3) {
      return new cW(this.view, var1, var3, false, 5);
   }

   protected Rectangle2D b(fj var1) {
      return new java.awt.geom.Rectangle2D.Double(var1.getX() - 10.0D, var1.getY() - 10.0D, var1.getWidth() + 20.0D, var1.getHeight() + 20.0D);
   }

   protected void a(Graphics2D var1, fj var2) {
      dI.b(var1, var2);
   }

   protected void a(Graphics2D var1, eU var2) {
      y.d.y var3 = this.L.k();
      int var4 = (int)Math.floor(var3.c());
      int var5 = (int)Math.floor(var3.d());
      int var6 = (int)Math.ceil(var3.a());
      int var7 = (int)Math.ceil(var3.b());
      dI.a(var1, var4, var5, var6, var7);
   }

   protected void f(double var1, double var3) {
   }

   private void a(double var1, double var3, aB var5) {
      boolean var17 = fj.z;
      if(this.j()) {
         Double var10 = new Double(var1, var3);
         double var6;
         double var8;
         if(var5.bendCount() == 0) {
            label55: {
               fj var11 = var5.getSourceRealizer();
               var6 = var5.getSourcePort().a(var11);
               var8 = var5.getSourcePort().b(var11);
               double var12 = var10.x - var6;
               double var14 = var10.y - var8;
               if(this.B) {
                  var10.x = var6 + var12;
                  var10.y = var8;
                  if(!var17) {
                     break label55;
                  }
               }

               var10.x = var6;
               var10.y = var8 + var14;
            }

            if(var1 == var10.x && var3 == var10.y) {
               return;
            }

            var5.createBend(var10.x, var10.y, var5.lastBend(), 0);
            if(!var17) {
               return;
            }
         }

         x var18;
         label45: {
            var18 = var5.lastBend();
            if(var5.bendCount() > 1) {
               y.d.t var19 = var5.getPoint(var5.bendCount() - 2);
               var6 = var19.a;
               var8 = var19.b;
               if(!var17) {
                  break label45;
               }
            }

            fj var13 = var5.getSourceRealizer();
            var6 = var5.getSourcePort().a(var13);
            var8 = var5.getSourcePort().b(var13);
         }

         label64: {
            double var20 = var10.x - var6;
            double var15 = var10.y - var8;
            if(var5.bendCount() > 1) {
               if(var5.bendCount() % 2 == 0 == this.B) {
                  var10.x = var6 + var20;
                  var10.y = var8;
                  if(!var17) {
                     break label64;
                  }
               }

               var10.x = var6;
               var10.y = var8 + var15;
               if(!var17) {
                  break label64;
               }
            }

            if(!this.B) {
               var10.x = var6 + var20;
               var10.y = var8;
               if(!var17) {
                  break label64;
               }
            }

            var10.x = var6;
            var10.y = var8 + var15;
         }

         var18.a(var10.x, var10.y);
      }
   }

   private boolean o() {
      boolean var1 = false;
      if(this.lastMoveEvent != null && this.lastDragEvent != null) {
         if(this.lastDragEvent.getWhen() > this.lastMoveEvent.getWhen()) {
            var1 = this.a(this.lastDragEvent);
            if(!fj.z) {
               return var1;
            }
         }

         var1 = this.a(this.lastMoveEvent);
      }

      return var1;
   }

   protected void a(y.c.d var1) {
      if(this.e()) {
         aB var2 = this.view.getGraph2D().i(var1);
         eU.a(this.J, var2);
         eU.b(this.K, var2);
      }

   }

   protected void n() {
      this.a().f();
      this.w = this.x = null;
      this.l.j();
      this.F = null;
      this.p();
      this.getGraph2D().b((byte)0);
      this.view.setDrawingMode(0);
      this.view.removeDrawable(this.l);
      this.view.updateView();
      this.setEditing(false);
      this.reactivateParent();
   }

   protected void c(y.c.q var1, double var2, double var4) {
      this.reactivateParent();
   }

   protected boolean d(y.c.q var1, double var2, double var4) {
      return true;
   }

   protected void a(y.c.q var1, eU var2, double var3, double var5) {
      this.reactivateParent();
   }

   protected boolean b(y.c.q var1, eU var2, double var3, double var5) {
      return true;
   }

   protected void e(y.c.q var1, double var2, double var4) {
   }

   protected boolean f(y.c.q var1, double var2, double var4) {
      return true;
   }

   protected void c(y.c.q var1, eU var2, double var3, double var5) {
   }

   protected boolean d(y.c.q var1, eU var2, double var3, double var5) {
      return true;
   }

   public void cancelEditing() {
      if(this.isEditing()) {
         this.n();
      }

   }

   private void p() {
      if(this.h != null) {
         this.view.getCanvasComponent().removeKeyListener(this.h);
         this.h = null;
      }

      if(this.i != null) {
         this.getGraph2D().b((y.c.o)this.i);
         this.i = null;
      }

      this.view.removePropertyChangeListener("Graph2D", this.j);
   }

   static y.c.o a(F var0) {
      return var0.i;
   }

   static y.c.o a(F var0, y.c.o var1) {
      return var0.i = var1;
   }

   static boolean b(F var0) {
      return var0.C;
   }

   static boolean c(F var0) {
      return var0.g;
   }

   static boolean d(F var0) {
      return var0.p;
   }

   static int e(F var0) {
      return var0.k;
   }

   static KeyListener a(F var0, KeyListener var1) {
      return var0.h = var1;
   }

   static y.c.q f(F var0) {
      return var0.a;
   }

   static boolean g(F var0) {
      return var0.G;
   }

   static eU h(F var0) {
      return var0.L;
   }

   static y.c.q i(F var0) {
      return var0.F;
   }
}
