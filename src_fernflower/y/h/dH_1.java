package y.h;

import y.h.aB;
import y.h.aC;
import y.h.bu;
import y.h.cW;
import y.h.eU;
import y.h.fO;
import y.h.fP;
import y.h.fj;
import y.h.gU;
import y.h.gX;
import y.h.ic;
import y.h.ih;

public class dH extends gX {
   protected eU a;
   private ih b;
   private boolean c;

   public dH() {
      this((gU)null);
   }

   public dH(gU var1) {
      super(var1);
   }

   protected boolean a(y.c.d var1) {
      return aC.b(var1, this.getGraph2D());
   }

   public void mousePressedLeft(double var1, double var3) {
      this.c = false;
      eU var5 = this.d(var1, var3);
      if(var5 == null) {
         this.reactivateParent();
         if(!fj.z) {
            return;
         }
      }

      this.setEditing(true);
      this.b = new ih();
      this.a = var5;
      this.a(var5);
   }

   public void mouseDraggedLeft(double var1, double var3) {
      if(this.a != null) {
         if(!this.c) {
            this.c = true;
            bu var5 = this.getGraph2D();
            var5.r();
            y.c.q var6 = b(this.a);
            if(var6 != null && var6.e() == var5) {
               this.b.b(var5, var6);
               this.b.a(var5, var6);
               var5.a(this.a.c());
               this.b.a(this.view, (new y.c.y(var6)).a(), this.a.c());
            }
         }

         y.d.t var7 = this.a(var1, var3);
         this.b(var7.a(), var7.b());
         this.view.updateView();
      }

   }

   public void mouseReleasedLeft(double var1, double var3) {
      this.c(var1, var3);
   }

   private void c(double var1, double var3) {
      if(this.a != null) {
         y.d.t var5 = this.a(var1, var3);
         this.b(var5.a(), var5.b());
         this.a(this.a, var5.a(), var5.b());
         this.view.updateView();
         this.a = null;
      }

      if(this.c) {
         this.getGraph2D().s();
      }

      this.c = false;
      this.view.setDrawingMode(0);
      this.b.a();
      this.b = null;
      if(this.isEditing()) {
         this.setEditing(false);
      }

      this.reactivateParent();
   }

   public void cancelEditing() {
      this.c(this.translateX(this.lastPressEvent.getX()), this.translateY(this.lastPressEvent.getY()));
   }

   protected void a(eU var1) {
   }

   protected void a(eU var1, double var2, double var4) {
   }

   protected y.d.t a(double var1, double var3) {
      return this.b(this.a, var1, var3);
   }

   protected y.d.t b(eU var1, double var2, double var4) {
      fO var6 = var1.g().a();
      fP var7 = var6.a(var1.b(), new y.d.t(var2, var4));
      return var6.a(var1, var7);
   }

   protected void b(double var1, double var3) {
      this.c(this.a, var1, var3);
   }

   protected void c(eU var1, double var2, double var4) {
      this.d(var1, var2, var4);
      this.b.a(this.getGraph2D());
   }

   private void d(eU var1, double var2, double var4) {
      boolean var13 = fj.z;
      fO var6 = var1.g().a();
      fP var7 = var6.a(var1.b(), new y.d.t(var2, var4));
      var1.a(var7);
      bu var8 = this.getGraph2D();
      y.c.q var9 = b(var1);
      y.c.e var10 = var1.c();

      while(var10.f()) {
         y.c.d var11 = var10.a();
         if(this.a(var11)) {
            aB var12 = var8.i(var11);
            if(var11.c() == var9) {
               ic.a(this.view, var12, var2, var4, true);
            }

            if(var11.d() == var9) {
               ic.a(this.view, var12, var2, var4, false);
            }
         }

         var10.g();
         if(var13) {
            break;
         }
      }

   }

   private eU d(double var1, double var3) {
      return this.getHitInfo(var1, var3).o();
   }

   protected cW getHitInfo(double var1, double var3) {
      cW var5 = this.b(var1, var3, 6, true);
      this.setLastHitInfo(var5);
      return var5;
   }

   private static y.c.q b(eU var0) {
      fj var1 = var0.b();
      return var1 == null?null:var1.getNode();
   }
}
