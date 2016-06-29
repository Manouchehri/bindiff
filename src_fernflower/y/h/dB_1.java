package y.h;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.cW;
import y.h.dC;
import y.h.dD;
import y.h.dE;
import y.h.dF;
import y.h.dG;
import y.h.dh;
import y.h.eR;
import y.h.fj;
import y.h.gX;
import y.h.gZ;
import y.h.gg;
import y.h.gu;
import y.h.gw;
import y.h.ih;

public class dB extends gX {
   private static final Color f = new Color(51, 51, 51);
   double a;
   double b;
   double c;
   double d;
   gZ e;
   private y.c.D g;
   private dG h;
   private byte i;
   private boolean j = true;
   private y.f.al k;
   private y.f.E l;
   private ih m;
   private dE n;
   private dh o;
   private boolean p = true;
   private int q;

   public dB() {
      this.a(2);
   }

   public void a(int var1) {
      this.q = var1;
   }

   public int a() {
      return this.q;
   }

   protected boolean a(MouseEvent var1) {
      return (var1.getModifiers() & this.a()) != 0;
   }

   public dh c() {
      if(this.o == null) {
         this.o = this.f();
      }

      return this.o;
   }

   public boolean e() {
      return this.p;
   }

   protected dh f() {
      return new dh(this.view);
   }

   public boolean g() {
      return this.j;
   }

   public void mousePressedLeft(double var1, double var3) {
      boolean var13 = fj.z;
      if(this.m != null) {
         this.m.a();
      }

      this.m = new ih();
      this.a = this.c = var1;
      this.b = this.d = var3;
      bu var5 = this.getGraph2D();
      gZ var6 = this.e;
      byte var7 = this.i;
      y.f.al var8 = this.k;
      y.f.E var9 = this.l;
      this.e = null;
      this.g = null;
      if(this.h != null) {
         this.view.removeDrawable(this.h);
         this.h = null;
      }

      if(this.n != null) {
         this.n.a();
         this.n = null;
      }

      eR var11;
      aA var15;
      if(var6 != null) {
         label56: {
            this.c().f();
            y.d.n var10 = var6.getOrientedBox();
            var6.setModel(var7);
            if(var6 instanceof eR) {
               var11 = (eR)var6;
               var11.a(var8, var8.a((y.d.n)var10, var11.g()));
               if(!var13) {
                  break label56;
               }
            }

            var15 = (aA)var6;
            aB var12 = var15.getRealizer();
            var15.setLabelModel(var9, var9.a((y.d.n)var10, var12, var12.getSourceRealizer(), var12.getTargetRealizer()));
         }
      }

      label51: {
         cW var14 = this.getHitInfo(var1, var3);
         if(var14.l() != null) {
            this.setEditing(true);
            var11 = var14.l();
            this.i = var11.getModel();
            this.k = var11.a();
            this.a(var5, var11, var1, var3);
            this.e = var11;
            if(!var13) {
               break label51;
            }
         }

         if(var14.m() != null) {
            this.setEditing(true);
            var15 = var14.m();
            this.i = var15.getModel();
            this.l = var15.getLabelModel();
            this.a(var5, var15, var1, var3);
            this.e = var15;
         }
      }

      if(var6 != null && this.e == null) {
         label43: {
            this.i = var7;
            this.k = var8;
            this.l = var9;
            if(var6 instanceof eR) {
               this.a(var5, (eR)var6, var1, var3);
               if(!var13) {
                  break label43;
               }
            }

            this.a(var5, (aA)var6, var1, var3);
         }

         this.e = var6;
      }

      if(this.e != null) {
         label36: {
            if(this.n == null) {
               this.i();
               if(!var13) {
                  break label36;
               }
            }

            this.n.a(this.a(this.e, this.lastPressEvent, var1, var3));
         }

         this.view.updateView();
         this.m.a(this.view, this.e);
         this.view.setViewCursor(Cursor.getPredefinedCursor(13));
      }

   }

   private void a(bu var1, eR var2, double var3, double var5) {
      y.c.q var7 = var2.f();
      this.m.a(var1, var7);
      this.g = this.k.a((y.f.aj)var2, var1.t(var7));
      this.a(var1, var7);
      this.m.b(var1, var7);
      this.n = this.a((gZ)var2);
      if(this.n == null) {
         if(this.e()) {
            dh var8 = this.c();
            var8.a(this.view);
            var8.a(new y.d.t(var3, var5), var2);
         }

         var2.setModel((byte)4);
      }

   }

   private void a(bu var1, aA var2, double var3, double var5) {
      y.c.d var7 = var2.getEdge();
      this.g = this.l.a((y.f.C)var2, var1.i(var7), var1.t(var7.c()), var1.t(var7.d()));
      this.a(var1, var7);
      this.m.a(var1, var7);
      this.n = this.a((gZ)var2);
      if(this.n == null) {
         if(this.e()) {
            dh var8 = this.c();
            var8.a(this.view);
            var8.a(new y.d.t(var3, var5), var2);
         }

         var2.setModel((byte)4);
      }

   }

   protected dE a(gZ var1) {
      if(var1 instanceof aA) {
         y.f.E var2 = ((aA)var1).getLabelModel();
         if(var2 instanceof dF) {
            return ((dF)var2).a();
         }
      } else if(var1 instanceof eR) {
         y.f.al var3 = ((eR)var1).a();
         if(var3 instanceof dF) {
            return ((dF)var3).a();
         }
      }

      return null;
   }

   private void i() {
      boolean var2 = fj.z;
      if(this.i == 4 || this.i == 4) {
         this.g = null;
      }

      if(this.g != null) {
         byte var1;
         label31: {
            if(this.e instanceof eR) {
               var1 = this.a(this.k);
               if(!var2) {
                  break label31;
               }
            }

            var1 = this.a(this.l);
         }

         switch(var1) {
         case 0:
            this.h = null;
            if(!var2) {
               break;
            }
         case 2:
            this.h = new dG(this, (dC)null);
            this.h.a(true);
            this.view.addDrawable(this.h);
            if(!var2) {
               break;
            }
         case 1:
            this.h = new dG(this, (dC)null);
            this.h.a(false);
            this.view.addDrawable(this.h);
            if(var2) {
               throw new IllegalStateException("Unknown Candidates Type");
            }
            break;
         default:
            throw new IllegalStateException("Unknown Candidates Type");
         }
      }

   }

   protected void a(bu var1, y.c.q var2) {
      if(this.g()) {
         this.a(var1, var2, true);
      }

   }

   protected void a(bu var1, y.c.d var2) {
      if(this.g()) {
         this.a(var1, var2, true);
      }

   }

   protected void a(bu var1, y.c.d var2, boolean var3) {
      var1.a(var2, var3);
   }

   protected void a(bu var1, y.c.q var2, boolean var3) {
      if(var3) {
         gg.a(var1, var2);
         if(!fj.z) {
            return;
         }
      }

      gg.b(var1, var2);
   }

   public void mouseReleasedRight(double var1, double var3) {
      this.mouseReleasedLeft(var1, var3);
   }

   public void mouseReleasedLeft(double var1, double var3) {
      this.a(var1, var3, false);
   }

   private void a(double var1, double var3, boolean var5) {
      boolean var7 = fj.z;
      if(this.e != null) {
         label30: {
            if(this.n == null) {
               this.j();
               if(!var7) {
                  break label30;
               }
            }

            label23: {
               if(var5) {
                  this.n.a();
                  if(!var7) {
                     break label23;
                  }
               }

               this.n.c(this.a(this.e, this.lastReleaseEvent, var1, var3));
            }

            this.n = null;
         }

         bu var6 = this.getGraph2D();
         this.m.a(var6);
         this.c().f();
         this.view.updateWorldRect();
         this.view.setDrawingMode(0);
         this.a(var1 - this.a, var3 - this.b, var1, var3);
         this.setEditing(false);
         var6.T();
      }

      this.i = 0;
      this.e = null;
      this.l = null;
      this.k = null;
      this.g = null;
      if(this.m != null) {
         this.m.a();
      }

      this.m = null;
      this.reactivateParent();
   }

   private void j() {
      boolean var6 = fj.z;
      if(this.h != null) {
         this.view.removeDrawable(this.h);
         this.h = null;
      }

      y.d.n var1;
      boolean var2;
      byte var4;
      label47: {
         var1 = this.e.getOrientedBox();
         var2 = this.e instanceof eR;
         if(var2) {
            var4 = this.a(this.k);
            if(!var6) {
               break label47;
            }
         }

         var4 = this.a(this.l);
      }

      Object var3;
      switch(var4) {
      case 0:
      case 2:
         if(var2) {
            var3 = this.a(this.k, var1, this.l().g(), this.lastReleaseEvent);
            if(!var6) {
               break;
            }
         }

         var3 = this.a(this.l, var1, this.k().getRealizer(), this.lastReleaseEvent);
         if(!var6) {
            break;
         }
      case 1:
         y.f.Q var5 = this.a(var1);
         if(var5 == null) {
            if(var2) {
               var3 = this.a(this.k, var1, this.l().g(), this.lastReleaseEvent);
               if(!var6) {
                  break;
               }
            }

            var3 = this.a(this.l, var1, this.k().getRealizer(), this.lastReleaseEvent);
            if(!var6) {
               break;
            }
         }

         var3 = var5.b();
         if(!var6) {
            break;
         }
      default:
         throw new IllegalStateException("Unknown Candidates Type");
      }

      this.e.setModel(this.i);
      if(var2) {
         this.l().a(this.k, var3);
         if(!var6) {
            return;
         }
      }

      this.k().setLabelModel(this.l, var3);
   }

   private aA k() {
      return (aA)this.e;
   }

   private eR l() {
      return (eR)this.e;
   }

   private boolean b(MouseEvent var1) {
      return this.e() && !this.a(var1);
   }

   public void mouseDraggedRight(double var1, double var3) {
      this.mouseDraggedLeft(var1, var3);
   }

   public void mouseDraggedLeft(double var1, double var3) {
      if(this.e != null) {
         label13: {
            if(this.n == null) {
               this.a(var1, var3);
               if(!fj.z) {
                  break label13;
               }
            }

            this.n.b(this.a(this.e, this.lastDragEvent, var1, var3));
         }

         this.m.a(this.view.getGraph2D());
         this.view.updateView();
      }

   }

   private void a(double var1, double var3) {
      double var5;
      double var7;
      byte var9;
      boolean var13;
      label42: {
         var13 = fj.z;
         var5 = var1 - this.c;
         var7 = var3 - this.d;
         this.c = var1;
         this.d = var3;
         if(this.e instanceof eR) {
            var9 = this.a(this.k);
            if(!var13) {
               break label42;
            }
         }

         var9 = this.a(this.l);
      }

      switch(var9) {
      case 0:
         if(this.h == null) {
            break;
         }

         this.view.removeDrawable(this.h);
         this.h = null;
         if(!var13) {
            break;
         }
      case 2:
         if(this.h != null) {
            break;
         }

         this.h = new dG(this, (dC)null);
         this.view.addDrawable(this.h);
         this.h.a(true);
         if(!var13) {
            break;
         }
      case 1:
         if(this.h != null) {
            break;
         }

         this.h = new dG(this, (dC)null);
         this.view.addDrawable(this.h);
         this.h.a(false);
         if(!var13) {
            break;
         }
      default:
         throw new IllegalStateException("Unknown Candidates Type");
      }

      y.d.n var11;
      label24: {
         y.d.n var10 = this.e.getOrientedBox();
         var11 = var10.f(var5, var7);
         if(this.b(this.lastDragEvent)) {
            y.d.t var12 = this.c().b(var11.k());
            var11.b(var12);
            this.c = var12.a();
            this.d = var12.b();
            if(!var13) {
               break label24;
            }
         }

         if(this.e()) {
            this.c().h();
         }
      }

      this.b(var11);
   }

   private y.f.Q a(y.d.n var1) {
      return this.a(var1, this.g);
   }

   protected y.f.Q a(y.d.n var1, y.c.D var2) {
      return this.a(var1.k(), var2);
   }

   private y.f.Q a(y.d.t var1, y.c.D var2) {
      boolean var10 = fj.z;
      if(var2 == null) {
         return null;
      } else {
         double var3 = Double.MAX_VALUE;
         y.f.Q var5 = null;
         y.c.C var6 = var2.m();

         y.f.Q var10000;
         while(true) {
            if(var6.f()) {
               var10000 = (y.f.Q)var6.d();
               if(var10) {
                  break;
               }

               y.f.Q var7 = var10000;
               double var8 = y.d.t.a(var1, var7.d().k());
               if(var8 < var3) {
                  var3 = var8;
                  var5 = var7;
               }

               var6.g();
               if(!var10) {
                  continue;
               }
            }

            var10000 = var5;
            break;
         }

         return var10000;
      }
   }

   private void b(y.d.n var1) {
      MouseEvent var2;
      boolean var7;
      label27: {
         var7 = fj.z;
         var2 = this.lastDragEvent;
         if(this.e instanceof eR) {
            eR var3 = this.l();
            y.f.al var4 = var3.a();
            fj var5 = var3.g();
            this.e.setModelParameter(this.a(var4, var1, var5, var2));
            if(!var7) {
               break label27;
            }
         }

         if(this.e instanceof aA) {
            aA var8 = this.k();
            y.f.E var10 = var8.getLabelModel();
            aB var11 = var8.getRealizer();
            Object var6 = this.a(var10, var1, var11, var2);
            this.e.setModelParameter(var6);
         }
      }

      if(this.h != null) {
         dG.a(this.h, this.a(var1));
         if(this.h.a()) {
            Object var9;
            if(this.e instanceof eR) {
               var9 = this.a(this.k, var1, this.l().g(), var2);
               dG.a(this.h, var9);
               if(!var7) {
                  return;
               }
            }

            if(this.e instanceof aA) {
               var9 = this.a(this.l, var1, this.k().getRealizer(), var2);
               dG.a(this.h, var9);
            }
         }
      }

   }

   protected void a(double var1, double var3, double var5, double var7) {
   }

   public void cancelEditing() {
      if(this.isEditing()) {
         this.a(this.c, this.d, true);
      }

   }

   protected byte a(y.f.al var1) {
      return (byte)(var1 instanceof gw?0:(var1 instanceof y.f.M?0:1));
   }

   protected byte a(y.f.E var1) {
      return (byte)(var1 instanceof gu?0:(var1 instanceof y.f.K?0:1));
   }

   protected Object a(y.f.al var1, y.d.n var2, fj var3, MouseEvent var4) {
      return var1.a((y.d.n)var2, var3);
   }

   protected Object a(y.f.E var1, y.d.n var2, aB var3, MouseEvent var4) {
      return var1.a((y.d.n)var2, var3, var3.getSourceRealizer(), var3.getTargetRealizer());
   }

   private dD a(gZ var1, MouseEvent var2, double var3, double var5) {
      return new dD(this, var1, var2.getModifiersEx(), var3, var5, this.b(var2));
   }

   static eR a(dB var0) {
      return var0.l();
   }

   static aA b(dB var0) {
      return var0.k();
   }

   static Color h() {
      return f;
   }

   static y.c.D c(dB var0) {
      return var0.g;
   }

   static y.f.E d(dB var0) {
      return var0.l;
   }

   static y.f.al e(dB var0) {
      return var0.k;
   }
}
