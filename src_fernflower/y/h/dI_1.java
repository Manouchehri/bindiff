package y.h;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D.Double;
import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.Iterator;
import y.h.aB;
import y.h.aC;
import y.h.az;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.dJ;
import y.h.dK;
import y.h.dL;
import y.h.dM;
import y.h.dN;
import y.h.dO;
import y.h.dU;
import y.h.eU;
import y.h.ek;
import y.h.em;
import y.h.fL;
import y.h.fj;
import y.h.gU;
import y.h.gX;
import y.h.gn;
import y.h.gy;
import y.h.gz;
import y.h.ic;
import y.h.x;

public class dI extends gX {
   double a;
   double b;
   protected fL c;
   dN d;
   protected y.c.D e;
   fj f;
   aB g;
   private boolean h;
   private boolean i;
   private boolean j;
   private dO k;
   private boolean l;
   private y.d.t m;
   private double n;
   private y.d.t o;
   private boolean p;
   private boolean q;
   private boolean r;
   private boolean s;
   private y.d.t t;
   private boolean u;
   private dU v;
   private boolean w;
   private boolean x;
   private boolean y;
   private boolean z;
   private y.c.o A;
   private PropertyChangeListener B;
   private int C;
   private final Ellipse2D D;

   public dI() {
      this((gU)null);
   }

   public dI(gU var1) {
      super(var1);
      this.h = true;
      this.k = new dO();
      this.n = 10.0D;
      this.p = true;
      this.q = true;
      this.r = true;
      this.s = true;
      this.C = 2;
      this.D = new Double();
      this.v = new dU((ch)null);
      this.v.b(false);
      this.v.d(false);
      this.v.c(true);
      this.v.g(true);
      this.v.b(10.0D);
      this.v.c(20.0D);
      this.B = new dJ(this);
   }

   public void a(boolean var1) {
      this.w = var1;
   }

   public boolean a() {
      return this.p;
   }

   public boolean c() {
      return this.q;
   }

   public int e() {
      return this.C;
   }

   protected boolean a(MouseEvent var1) {
      return (var1.getModifiers() & this.e()) != 0;
   }

   public boolean f() {
      return this.j;
   }

   protected cW getHitInfo(double var1, double var3) {
      cW var5 = new cW(this.view, var1, var3, true, 0);
      this.setLastHitInfo(var5);
      return var5;
   }

   public void mousePressedLeft(double var1, double var3) {
      boolean var17 = fj.z;
      cW var5 = this.getHitInfo(var1, var3);
      if(var5.q()) {
         bu var6 = this.getGraph2D();
         this.setEditing(true);
         this.c = var5.n();
         y.c.C var7 = var5.f();

         label110: {
            while(var7.f()) {
               fL var8 = (fL)var7.d();
               if(var17) {
                  break label110;
               }

               if(var8 == var8.d().getTargetPort()) {
                  this.c = var8;
                  if(!var17) {
                     break;
                  }
               }

               var7.g();
               if(var17) {
                  break;
               }
            }

            this.a(this.c);
            this.a = var1;
            this.b = var3;
            this.g = this.c.d();
         }

         y.c.d var18 = this.g.getEdge();
         this.l = false;
         this.k.j();
         boolean var9 = this.f();
         if(var9) {
            var6.r();
            this.l = true;
            this.view.addDrawable(this.k);
         }

         label118: {
            var6.a((new y.c.f(var18)).a());
            this.g = this.c.d();
            y.c.q var10;
            y.c.q var11;
            y.c.d var12;
            if(this.c == this.g.getSourcePort()) {
               this.i = true;
               this.f = this.g.getSourceRealizer();
               this.o = var6.p(var18);
               this.t = this.g.bendCount() == 0?var6.q(this.g.getEdge()):new y.d.t(this.g.firstBend().b(), this.g.firstBend().c());
               if(!var9) {
                  break label118;
               }

               var10 = this.k.a(this.a(var1, var3 + 50.0D));
               var11 = this.k.a(this.a(this.g.getTargetRealizer()));
               var12 = this.k.a(var10, var11, this.a(this.g));
               this.k.i(var12).getSourcePort().b(0.0D, 0.0D);
               if(!var17) {
                  break label118;
               }
            }

            this.i = false;
            this.f = this.g.getTargetRealizer();
            this.o = var6.q(var18);
            this.t = this.g.bendCount() == 0?var6.p(this.g.getEdge()):new y.d.t(this.g.lastBend().b(), this.g.lastBend().c());
            if(var9) {
               var10 = this.k.a(this.a(this.g.getSourceRealizer()));
               var11 = this.k.a(this.a(var1, var3 + 50.0D));
               var12 = this.k.a(var10, var11, this.a(this.g));
               this.k.i(var12).getTargetPort().b(0.0D, 0.0D);
            }
         }

         label87: {
            this.a(this.f, var18);
            var6.N();
            this.g.setSelected(true);
            this.g.setVisible(!var9);
            this.u = this.a(this.g.getEdge());
            this.d(var1, var3);
            if(this.u && this.w) {
               aB var19 = this.k.i()?this.g:this.k.i(this.k.l());
               if(var19.bendCount() == 0) {
                  this.d(var1 + 10.0D, var3 + 10.0D);
                  this.d(var1, var3);
               }

               y.d.t var20;
               x var21;
               label82: {
                  var20 = new y.d.t(var1, var3);
                  if(this.i) {
                     var21 = var19.firstBend();
                     if(!var17) {
                        break label82;
                     }
                  }

                  var21 = var19.lastBend();
               }

               if(var21 == null) {
                  break label87;
               }

               byte var13;
               label76: {
                  if(var21.b() == var1) {
                     var13 = 1;
                     if(!var17) {
                        break label76;
                     }
                  }

                  var13 = 2;
               }

               em var14 = new em(this.c, var20, (byte)3);
               ek var15 = new ek(var21, new y.d.t(var21.b(), var21.c()), var13);
               y.d.t var16 = new y.d.t(var1, var3);
               this.v.a((ch)this.view);
               this.v.i();
               this.v.b();
               this.v.a(var16, Collections.EMPTY_LIST, Collections.singletonList(var15), Collections.singletonList(var14), y.g.q.a((Object)null));
               if(this.x) {
                  this.a(var13);
               }

               if(this.s) {
                  this.v.a((gz)(new dK(this, 0.9D, (az)null, var16, var15)));
               }

               this.v.a((gz)(new dL(this, 0.9D)));
               if(!var17) {
                  break label87;
               }
            }

            this.v.f();
         }

         if(this.A == null) {
            this.A = new dM(this, var18);
            var6.a((y.c.o)this.A);
         }

         this.view.addPropertyChangeListener("Graph2D", this.B);
         this.view.setDrawingMode(1);
         this.view.setViewCursor(this.h());
         if(!var17) {
            return;
         }
      }

      this.c = null;
      this.reactivateParent();
   }

   private void j() {
      this.view.removeDrawable(this.k);
      this.k.j();
      this.k();
      if(this.l) {
         this.getGraph2D().s();
         this.l = false;
      }

      if(this.isEditing()) {
         this.setEditing(false);
      }

      this.reactivateParent();
   }

   private void a(byte var1) {
      boolean var14 = fj.z;
      double var2 = this.f.getCenterY();
      double var4 = this.f.getCenterX();
      double var6;
      double var8;
      double var10;
      double var12;
      if(var1 == 1) {
         var6 = this.v.m();
         if(var6 <= 0.0D || this.f.getWidth() / var6 >= 40.0D) {
            return;
         }

         var8 = this.f.getY() - 5.0D;
         var10 = this.f.getY() + this.f.getHeight() + 5.0D;
         var12 = var4;

         label60: {
            while(var12 > this.f.getX()) {
               this.v.a((gy)(new gy((byte)1, (byte)16, new y.d.t(var12, var2), var8, var10, this.f, 0.01D)));
               var12 -= var6;
               if(var14) {
                  break label60;
               }

               if(var14) {
                  break;
               }
            }

            var12 = var4 + var6;
         }

         do {
            if(var12 >= this.f.getX() + this.f.getWidth()) {
               return;
            }

            this.v.a((gy)(new gy((byte)1, (byte)16, new y.d.t(var12, var2), var8, var10, this.f, 0.01D)));
            var12 += var6;
         } while(!var14);
      }

      var6 = this.v.m();
      if(var6 > 0.0D && this.f.getHeight() / var6 < 40.0D) {
         var8 = this.f.getX() - 5.0D;
         var10 = this.f.getX() + this.f.getWidth() + 5.0D;
         var12 = var2;

         label32: {
            while(var12 > this.f.getY()) {
               this.v.a((gy)(new gy((byte)0, (byte)16, new y.d.t(var4, var12), var8, var10, this.f, 0.01D)));
               var12 -= var6;
               if(var14) {
                  break label32;
               }

               if(var14) {
                  break;
               }
            }

            var12 = var2 + var6;
         }

         while(var12 < this.f.getY() + this.f.getHeight()) {
            this.v.a((gy)(new gy((byte)0, (byte)16, new y.d.t(var4, var12), var8, var10, this.f, 0.01D)));
            var12 += var6;
            if(var14) {
               break;
            }
         }
      }

   }

   protected aB a(aB var1) {
      return var1.createCopy();
   }

   protected fj a(fj var1) {
      return var1.createCopy();
   }

   protected fj a(double var1, double var3) {
      gn var5 = new gn();
      var5.setSize(0.1D, 0.1D);
      var5.setVisible(false);
      var5.setCenter(var1, var3);
      var5.setShapeType((byte)0);
      return var5;
   }

   private void a(fj var1, y.c.d var2) {
      boolean var9 = fj.z;
      this.view.getGraph2D();
      if(this.d != null) {
         this.view.removeDrawable(this.d);
      }

      double var3 = this.view.getGridResolution();
      if(var3 <= 0.0D) {
         var3 = 20.0D;
      }

      this.e = this.a(var1.getNode(), var2, var3);
      java.awt.geom.Rectangle2D.Double var5 = new java.awt.geom.Rectangle2D.Double(var1.getX() - 10.0D, var1.getY() - 10.0D, var1.getWidth() + 20.0D, var1.getHeight() + 20.0D);
      y.c.C var6 = this.e.m();

      while(true) {
         if(var6.f()) {
            y.d.t var7 = (y.d.t)var6.d();
            java.awt.geom.Rectangle2D.Double var8 = new java.awt.geom.Rectangle2D.Double(var7.a - 10.0D, var7.b - 10.0D, 20.0D, 20.0D);
            var5.add(var8);
            var6.g();
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         this.d = new dN(this, this.e, var5, var1.getNode(), var2);
         this.view.addDrawable(this.d);
         this.view.updateView();
         break;
      }

   }

   protected y.c.D a(y.c.q var1, y.c.d var2, double var3) {
      return !this.p?this.a(var1, var2):(this.c()?this.b(var1, var2):this.view.getGraph2D().t(var1).getPortCandidates(var3));
   }

   private y.c.D b(y.c.q var1, y.c.d var2) {
      boolean var6 = fj.z;
      y.c.D var3 = new y.c.D();
      fj var4 = this.view.getGraph2D().t(var1);
      y.c.D var10000;
      if(var4.portCount() > 0) {
         Iterator var5 = var4.ports();

         while(var5.hasNext()) {
            var10000 = var3;
            if(var6) {
               return var10000;
            }

            var3.add(((eU)var5.next()).h());
            if(var6) {
               break;
            }
         }
      }

      var10000 = var3;
      return var10000;
   }

   protected y.c.D a(y.c.q var1, y.c.d var2) {
      y.c.D var3 = new y.c.D();
      fj var4 = this.view.getGraph2D().t(var1);
      double var5 = var4.getCenterX();
      double var7 = var4.getCenterY();
      if(var4.contains(var5, var7)) {
         var3.add(new y.d.t(var5, var7));
         java.awt.geom.Point2D.Double var9 = new java.awt.geom.Point2D.Double();
         if(var4.findIntersection(var5, var7, var4.getX() - 10.0D, var7, var9)) {
            var3.add(new y.d.t(var9.x, var9.y));
         }

         if(var4.findIntersection(var5, var7, var4.getX() + var4.getWidth() + 10.0D, var7, var9)) {
            var3.add(new y.d.t(var9.x, var9.y));
         }

         if(var4.findIntersection(var5, var7, var5, var4.getY() - 10.0D, var9)) {
            var3.add(new y.d.t(var9.x, var9.y));
         }

         if(var4.findIntersection(var5, var7, var5, var4.getY() + var4.getHeight() + 10.0D, var9)) {
            var3.add(new y.d.t(var9.x, var9.y));
         }
      }

      if(this.i && var2.c() == var1) {
         var3.add(this.o);
      }

      if(!this.i && var2.d() == var1) {
         var3.add(this.o);
      }

      return var3;
   }

   public void mouseDraggedLeft(double var1, double var3) {
      if(this.c != null) {
         label24: {
            if(this.f()) {
               y.c.q var5 = this.b(var1, var3);
               if(var5 == null || var5 == this.f.getNode()) {
                  break label24;
               }

               this.f = this.view.getGraph2D().t(var5);
               Rectangle var6 = this.d.getBounds();
               this.a(this.f, this.c.d().getEdge());
               var6.add(this.d.getBounds());
               this.view.updateView(var6.getX(), var6.getY(), var6.getWidth(), var6.getHeight());
               if(!fj.z) {
                  break label24;
               }
            }

            this.a(this.f, this.c.d().getEdge());
         }

         this.a = var1;
         this.b = var3;
         y.d.t var7 = this.a(var1, var3, this.a(this.lastDragEvent), !this.isModifierPressed(this.lastDragEvent) ^ this.y);
         var1 = var7.a;
         var3 = var7.b;
         this.a = var1;
         this.b = var3;
         this.d(var1, var3);
         this.view.updateView();
      }

   }

   protected y.d.t a(double var1, double var3, boolean var5, boolean var6) {
      if(var6) {
         if(this.v.l()) {
            this.v.h();
         }

         this.m = this.a(var1, var3, java.lang.Double.MAX_VALUE);
         return this.m != null?this.m:new y.d.t(var1, var3);
      } else {
         this.m = null;
         if(var5) {
            if(this.v.l()) {
               this.v.h();
            }

            return new y.d.t(var1, var3);
         } else {
            y.d.t var7 = this.a(var1, var3, this.n);
            if(var7 != null) {
               this.m = var7;
               return var7;
            } else if(this.v.l()) {
               y.d.t var10 = this.v.b(new y.d.t(var1, var3));
               var1 = var10.a;
               var3 = var10.b;
               return var10;
            } else {
               double var8 = this.n / this.view.getZoom();
               return this.s?this.a(var1, var3, var8, this.f, this.t):new y.d.t(var1, var3);
            }
         }
      }
   }

   private y.d.t a(double var1, double var3, double var5) {
      boolean var15 = fj.z;
      y.d.t var7 = new y.d.t(var1, var3);
      y.d.t var8 = null;
      double var9 = var5;
      if(var5 < java.lang.Double.MAX_VALUE) {
         var9 = var5 / this.view.getZoom();
      }

      y.c.C var11 = this.e.m();

      y.d.t var10000;
      while(true) {
         if(var11.f()) {
            y.d.t var12 = (y.d.t)var11.d();
            var10000 = var7;
            if(var15) {
               break;
            }

            double var13 = y.d.t.a(var7, var12);
            if(var13 < var9) {
               var9 = var13;
               var8 = var12;
            }

            var11.g();
            if(!var15) {
               continue;
            }
         }

         var10000 = var8;
         break;
      }

      return var10000;
   }

   protected y.c.q b(double var1, double var3) {
      if(this.i) {
         if(this.c.d().getSourceRealizer().contains(var1, var3)) {
            return this.c.d().getEdge().c();
         }
      } else if(this.c.d().getTargetRealizer().contains(var1, var3)) {
         return this.c.d().getEdge().d();
      }

      return this.c(var1, var3).i();
   }

   protected cW c(double var1, double var3) {
      return this.b(var1, var3, 4, true);
   }

   protected void d(double var1, double var3) {
      Object var5;
      aB var6;
      boolean var7;
      label23: {
         var7 = fj.z;
         if(this.k.i()) {
            var5 = this.getGraph2D();
            var6 = this.c.d();
            if(!var7) {
               break label23;
            }
         }

         var5 = this.k;
         var6 = this.k.i(this.k.l());
      }

      label18: {
         if(this.i) {
            ((bu)var5).c(var6.getEdge(), new y.d.t(var1, var3));
            if(!var7) {
               break label18;
            }
         }

         ((bu)var5).d(var6.getEdge(), new y.d.t(var1, var3));
      }

      if(this.u) {
         ic.a(this.view, var6, var1, var3, this.i);
      }

   }

   private y.d.t a(double var1, double var3, double var5, fj var7, y.d.t var8) {
      y.d.t var9 = null;
      boolean var10 = var7.contains(var1, var3);
      double var15;
      double var17;
      if(this.r) {
         var15 = var8.a - var1;
         if(Math.abs(var15) < var5) {
            var1 = var8.a;
         }

         var17 = var8.b - var3;
         if(Math.abs(var17) < var5) {
            var3 = var8.b;
         }
      }

      if(this.s) {
         var15 = var1 - var8.a;
         var17 = var3 - var8.b;
         double var19 = Math.sqrt(var15 * var15 + var17 * var17);
         if(var19 > 0.0D) {
            boolean var21 = var7.contains(var1, var3);
            double var22 = var1 - var5 * var15 / var19;
            double var24 = var3 - var5 * var17 / var19;
            if(var7.contains(var22, var24) != var21) {
               java.awt.geom.Point2D.Double var26 = new java.awt.geom.Point2D.Double();
               if(var21) {
                  if(var7.findIntersection(var1, var3, var22, var24, var26)) {
                     var9 = new y.d.t(var26.x, var26.y);
                  }
               } else if(var7.findIntersection(var22, var24, var1, var3, var26)) {
                  var9 = new y.d.t(var26.x, var26.y);
               }
            } else {
               double var31 = var1 + var5 * var15 / var19;
               double var28 = var3 + var5 * var17 / var19;
               if(var7.contains(var31, var28) != var21) {
                  java.awt.geom.Point2D.Double var30 = new java.awt.geom.Point2D.Double();
                  if(var21) {
                     if(var7.findIntersection(var1, var3, var31, var28, var30)) {
                        var9 = new y.d.t(var30.x, var30.y);
                     }
                  } else if(var7.findIntersection(var31, var28, var1, var3, var30)) {
                     var9 = new y.d.t(var30.x, var30.y);
                  }
               }
            }
         }
      }

      return var9 == null && var10 && (var1 != var1 || var3 != var3) && !var7.contains(var1, var3)?new y.d.t(var1, var3):(var9 != null?var9:new y.d.t(var1, var3));
   }

   protected boolean a(y.c.d var1) {
      return aC.b(var1, this.getGraph2D());
   }

   public void mouseShiftReleasedLeft(double var1, double var3) {
      if(this.h) {
         this.mouseReleasedLeft(var1, var3);
         if(!fj.z) {
            return;
         }
      }

      this.a(var1, var3, this.y);
   }

   private void k() {
      if(this.v != null) {
         this.v.f();
      }

      this.view.setViewCursor(this.i());
      this.view.setDrawingMode(0);
      this.view.removeDrawable(this.d);
      this.d = null;
      this.setEditing(false);
      bu var1 = this.getGraph2D();
      if(this.A != null) {
         var1.b((y.c.o)this.A);
         this.A = null;
      }

      this.view.removePropertyChangeListener("Graph2D", this.B);
      var1.T();
   }

   private void l() {
      boolean var7 = fj.z;
      if(this.f()) {
         bu var1 = this.getGraph2D();
         y.h.a.v var2 = var1.C();
         y.c.d var3 = this.c.d().getEdge();
         y.c.q var4;
         y.c.q var5;
         y.c.q var6;
         if(this.i) {
            if(this.c.d().getSourceRealizer() == this.f) {
               return;
            }

            label33: {
               var4 = this.f.getNode();
               var5 = var3.d();
               if(var2 != null && var2.e(var3)) {
                  var6 = var2.c(var3);
                  var2.d(var3).b("HierarchyManager.InterEdgeData.SOURCE_PORT");
                  var2.a(var3, var4, var6);
                  if(!var7) {
                     break label33;
                  }
               }

               var1.a(var3, var4, var5);
            }

            this.b(var3);
            if(!var7) {
               return;
            }
         }

         if(this.c.d().getTargetRealizer() != this.f) {
            label23: {
               var4 = this.f.getNode();
               var5 = var3.c();
               if(var2 != null && var2.e(var3)) {
                  var6 = var2.b(var3);
                  var2.d(var3).b("HierarchyManager.InterEdgeData.TARGET_PORT");
                  var2.a(var3, var6, var4);
                  if(!var7) {
                     break label23;
                  }
               }

               var1.a(var3, var5, var4);
            }

            this.b(var3);
         }
      }

   }

   public void mouseReleasedRight(double var1, double var3) {
      this.mouseReleasedLeft(var1, var3);
   }

   public void mouseShiftReleasedRight(double var1, double var3) {
      this.mouseShiftReleasedLeft(var1, var3);
   }

   public void mouseReleasedLeft(double var1, double var3) {
      this.a(var1, var3, !this.y);
   }

   private void a(double var1, double var3, boolean var5) {
      if(this.c != null) {
         y.d.t var6 = this.a(var1, var3, this.a(this.lastReleaseEvent), var5);
         var1 = var6.a;
         var3 = var6.b;
         this.d(var1, var3);
         this.l();
         this.m();
         this.d(var1, var3);
         this.a(this.c, var1, var3);
         this.k();
      }

      if(this.l) {
         this.getGraph2D().s();
         this.l = false;
      }

      if(this.isEditing()) {
         this.setEditing(false);
      }

      this.reactivateParent();
   }

   protected void b(y.c.d var1) {
   }

   protected void a(fL var1) {
   }

   protected void a(fL var1, double var2, double var4) {
      if(this.a() && this.c()) {
         aB var6 = var1.d();
         eU var7 = this.e(var2, var4);
         if(var7 != null) {
            if(this.i) {
               var7.a(var6);
               if(!fj.z) {
                  return;
               }
            }

            var7.c(var6);
         }
      }

   }

   private eU e(double var1, double var3) {
      return eU.a(this.f, var1, var3);
   }

   private void m() {
      boolean var4 = fj.z;
      if(!this.k.i()) {
         aB var1 = this.k.i(this.k.l());
         int var2 = 0;

         aB var10000;
         label28: {
            while(var2 < var1.bendCount()) {
               x var3 = var1.getBend(var2);
               var10000 = this.g;
               if(var4) {
                  break label28;
               }

               label24: {
                  if(var10000.bendCount() <= var2) {
                     this.g.addPoint(var3.b(), var3.c());
                     if(!var4) {
                        break label24;
                     }
                  }

                  this.g.getBend(var2).a(var3.b(), var3.c());
               }

               ++var2;
               if(var4) {
                  break;
               }
            }

            var10000 = this.g;
         }

         var10000.setVisible(true);
         this.view.removeDrawable(this.k);
         this.k.j();
      }

   }

   protected void a(Graphics2D var1, y.d.t var2, y.c.q var3, y.c.d var4) {
      this.a(var1, var2, var3, var4, this.g() || !this.isModifierPressed(this.lastDragEvent) ^ this.y, var2.equals(this.m));
   }

   protected void a(Graphics2D var1, y.d.t var2, y.c.q var3, y.c.d var4, boolean var5, boolean var6) {
      label22: {
         boolean var7 = fj.z;
         if(var5) {
            if(var6) {
               var1.setColor(Color.green);
               if(!var7) {
                  break label22;
               }
            }

            var1.setColor(Color.red);
            if(!var7) {
               break label22;
            }
         }

         if(this.y) {
            return;
         }

         var1.setColor(Color.gray);
      }

      this.D.setFrame(var2.a() - 3.0D, var2.b() - 3.0D, 6.0D, 6.0D);
      var1.fill(this.D);
      var1.setColor(Color.black);
      var1.draw(this.D);
   }

   public boolean g() {
      return this.h;
   }

   public void cancelEditing() {
      if(this.isEditing()) {
         this.mouseReleasedLeft(this.a, this.b);
      }

   }

   protected void a(Graphics2D var1, fj var2) {
      b(var1, var2);
   }

   static void b(Graphics2D var0, fj var1) {
      int var2 = (int)var1.getX();
      int var3 = (int)var1.getY();
      int var4 = (int)var1.getWidth();
      int var5 = (int)var1.getHeight();
      a(var0, var2, var3, var4, var5);
   }

   static void a(Graphics2D var0, int var1, int var2, int var3, int var4) {
      Color var5 = var0.getColor();
      var0.setColor(Color.black);
      a(var0, var1, var2, var3, var4, 5);
      a(var0, var1, var2, var3, var4, 3);
      var0.setColor(Color.white);
      a(var0, var1, var2, var3, var4, 4);
      var0.setColor(var5);
   }

   private static void a(Graphics2D var0, int var1, int var2, int var3, int var4, int var5) {
      var0.drawLine(var1 - var5, var2 - var5, var1, var2 - var5);
      var0.drawLine(var1 - var5, var2 - var5, var1 - var5, var2);
      int var6 = var1 + var3;
      var0.drawLine(var6 + var5, var2 - var5, var6, var2 - var5);
      var0.drawLine(var6 + var5, var2 - var5, var6 + var5, var2);
      int var7 = var2 + var4;
      var0.drawLine(var1 - var5, var7 + var5, var1, var7 + var5);
      var0.drawLine(var1 - var5, var7 + var5, var1 - var5, var7);
      var6 = var1 + var3;
      var0.drawLine(var6 + var5, var7 + var5, var6, var7 + var5);
      var0.drawLine(var6 + var5, var7 + var5, var6 + var5, var7);
   }

   private Rectangle2D n() {
      java.awt.geom.Rectangle2D.Double var1 = new java.awt.geom.Rectangle2D.Double();
      if(this.f != null) {
         this.f.calcUnionRect(var1);
      }

      return var1;
   }

   public Cursor h() {
      return Cursor.getPredefinedCursor(13);
   }

   public Cursor i() {
      return Cursor.getPredefinedCursor(0);
   }

   static y.c.o a(dI var0) {
      return var0.A;
   }

   static y.c.o a(dI var0, y.c.o var1) {
      return var0.A = var1;
   }

   static double b(dI var0) {
      return var0.n;
   }

   static y.d.t a(dI var0, double var1, double var3, double var5, fj var7, y.d.t var8) {
      return var0.a(var1, var3, var5, var7, var8);
   }

   static y.d.t a(dI var0, double var1, double var3, double var5) {
      return var0.a(var1, var3, var5);
   }

   static void c(dI var0) {
      var0.j();
   }

   static boolean d(dI var0) {
      return var0.z;
   }

   static Rectangle2D e(dI var0) {
      return var0.n();
   }
}
