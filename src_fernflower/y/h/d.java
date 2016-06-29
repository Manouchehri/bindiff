package y.h;

import java.awt.Rectangle;
import java.awt.geom.Point2D.Double;
import y.h.fj;
import y.h.gU;
import y.h.gX;

public abstract class d extends gX {
   private Double lm = new Double();
   private java.awt.geom.Rectangle2D.Double mm = new java.awt.geom.Rectangle2D.Double();

   public d(gU var1) {
      super(var1);
   }

   public d() {
   }

   public void mousePressedLeft(double var1, double var3) {
      this.n(var1, var3);
   }

   void n(double var1, double var3) {
      this.lm = new Double(var1, var3);
      this.mm = new java.awt.geom.Rectangle2D.Double(var1, var3, 0.0D, 0.0D);
      this.view.setDrawingMode(2);
      this.view.setSelectionBoxBounds2D(this.mm);
      this.setEditing(true);
   }

   public void cancelEditing() {
      if(this.isEditing()) {
         this.view.setDrawingMode(0);
         this.view.updateView();
         this.setEditing(false);
         this.reactivateParent();
      }

   }

   public void mouseShiftPressedLeft(double var1, double var3) {
      this.n(var1, var3);
   }

   public void mouseDraggedLeft(double var1, double var3) {
      this.updateDoubleSelectionBox(var1, var3);
      this.view.setSelectionBoxBounds2D(this.mm);
      this.view.updateView();
   }

   public void mouseReleasedLeft(double var1, double var3) {
      this.view.setDrawingMode(0);
      this.selectionBoxAction(new java.awt.geom.Rectangle2D.Double(this.mm.x, this.mm.y, this.mm.width, this.mm.height), false);
      this.setEditing(false);
      this.reactivateParent();
   }

   public void mouseShiftReleasedLeft(double var1, double var3) {
      this.view.setDrawingMode(0);
      this.selectionBoxAction(new java.awt.geom.Rectangle2D.Double(this.mm.x, this.mm.y, this.mm.width, this.mm.height), true);
      this.setEditing(false);
      this.reactivateParent();
   }

   public void mouseReleasedRight(double var1, double var3) {
      this.mouseReleasedLeft(var1, var3);
   }

   protected java.awt.geom.Rectangle2D.Double updateDoubleSelectionBox(double var1, double var3) {
      java.awt.geom.Rectangle2D.Double var5;
      boolean var6;
      label30: {
         var6 = fj.z;
         var5 = this.mm;
         if(var1 < this.lm.x) {
            var5.width = this.lm.x - var1;
            var5.x = var1;
            if(!var6) {
               break label30;
            }
         }

         if(var5.x < this.lm.x) {
            var5.x = this.lm.x;
         }

         var5.width = var1 - this.lm.x;
      }

      if(var3 < this.lm.y) {
         var5.height = this.lm.y - var3;
         var5.y = var3;
         if(!var6) {
            return var5;
         }
      }

      if(var5.y < this.lm.y) {
         var5.y = this.lm.y;
      }

      var5.height = var3 - this.lm.y;
      return var5;
   }

   protected abstract void selectionBoxAction(Rectangle var1, boolean var2);

   protected void selectionBoxAction(java.awt.geom.Rectangle2D.Double var1, boolean var2) {
      this.selectionBoxAction(new Rectangle((int)var1.x, (int)var1.y, (int)var1.width, (int)var1.height), var2);
   }
}
