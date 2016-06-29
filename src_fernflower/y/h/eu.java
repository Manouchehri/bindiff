package y.h;

import java.awt.geom.Rectangle2D;
import y.h.fj;

final class eu extends Rectangle2D {
   private final fj a;

   protected eu(fj var1) {
      this.a = var1;
   }

   public Rectangle2D createIntersection(Rectangle2D var1) {
      return null;
   }

   public Rectangle2D createUnion(Rectangle2D var1) {
      return null;
   }

   public int outcode(double var1, double var3) {
      return 0;
   }

   public void setRect(double var1, double var3, double var5, double var7) {
   }

   public double getHeight() {
      return this.a.getHeight();
   }

   public double getWidth() {
      return this.a.getWidth();
   }

   public double getX() {
      return this.a.getX();
   }

   public double getY() {
      return this.a.getY();
   }

   public boolean isEmpty() {
      return false;
   }
}
