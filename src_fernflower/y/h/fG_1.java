package y.h;

import java.awt.event.MouseEvent;
import y.h.fD;
import y.h.fF;
import y.h.fj;
import y.h.gU;
import y.h.gX;

class fG extends gX {
   double a;
   double b;
   double c;
   double d;
   boolean e;
   double f;
   double g;
   boolean h;
   boolean i;
   private final fD j;

   public fG(fD var1, gU var2) {
      super(var2);
      this.j = var1;
   }

   public void mouseClicked(double var1, double var3) {
      if(!this.i) {
         this.j.b(var1, var3, 0.5D);
      }

   }

   public void mousePressedLeft(double var1, double var3) {
      if(this.j.wc.a(var1, var3)) {
         this.a = var1;
         this.b = var3;
         this.c = this.j.tc.getCenter().getX();
         this.d = this.j.tc.getCenter().getY();
         this.e = true;
      }
   }

   public void mouseDraggedLeft(double var1, double var3) {
      if(this.e) {
         this.j.b(this.c + (var1 - this.a), this.d + (var3 - this.b), 1.0D);
      }

   }

   public void mouseReleasedLeft(double var1, double var3) {
      this.e = false;
      this.h = false;
   }

   public void mousePressed(MouseEvent var1) {
      boolean var4 = fj.z;
      this.i = false;
      if(Boolean.TRUE.equals(this.j.getClientProperty("Overview.AllowZooming"))) {
         int var2 = this.j.toViewCoordX(fF.a(this.j.wc).getMaxX());
         int var3 = this.j.toViewCoordY(fF.a(this.j.wc).getMaxY());
         if(Math.abs(var2 - var1.getX()) < 3 && Math.abs(var3 - var1.getY()) < 3) {
            this.h = true;
            this.f = this.j.tc.getCenter().getX();
            this.g = this.j.tc.getCenter().getY();
            if(!var4) {
               return;
            }
         }

         this.h = false;
         super.mousePressed(var1);
         if(!var4) {
            return;
         }
      }

      super.mousePressed(var1);
   }

   public void mouseDragged(MouseEvent var1) {
      this.i = true;
      if(this.h) {
         double var2 = this.j.toWorldCoordX(var1.getX());
         double var4 = this.j.toWorldCoordY(var1.getY());
         double var6 = Math.abs(this.f - var2) * 2.0D;
         double var8 = Math.abs(this.g - var4) * 2.0D;
         double var10 = (double)this.j.tc.getCanvasComponent().getWidth() / var6;
         double var12 = (double)this.j.tc.getCanvasComponent().getHeight() / var8;
         double var14 = Math.min(var10, var12);
         if(var14 == this.j.tc.getZoom()) {
            return;
         }

         this.j.tc.setZoom(var14);
         this.j.tc.setCenter(this.f, this.g);
         this.j.tc.updateView();
         if(!fj.z) {
            return;
         }
      }

      super.mouseDragged(var1);
   }
}
