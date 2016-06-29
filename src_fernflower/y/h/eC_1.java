package y.h;

import java.awt.Cursor;
import java.awt.geom.Point2D;
import y.h.gX;

public class eC extends gX {
   private int a;
   private int b;

   public void mousePressedRight(double var1, double var3) {
      this.a = this.originalX;
      this.b = this.originalY;
      this.view.setViewCursor(Cursor.getPredefinedCursor(13));
   }

   public void mouseReleasedRight(double var1, double var3) {
      this.view.setViewCursor(Cursor.getPredefinedCursor(0));
      this.reactivateParent();
   }

   public void mouseDraggedRight(double var1, double var3) {
      double var5 = (double)(this.originalX - this.a);
      double var7 = (double)(this.originalY - this.b);
      Point2D var9 = this.view.getCenter();
      this.view.setCenter(var9.getX() - var5 / this.view.getZoom(), var9.getY() - var7 / this.view.getZoom());
      this.view.updateView();
      this.a = this.originalX;
      this.b = this.originalY;
   }
}
