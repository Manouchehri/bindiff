package y.h;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JComponent;
import y.h.hw;
import y.h.hx;
import y.h.hz;

final class hy extends hx {
   private final hz a;
   private final hw b;

   hy(hw var1, hz var2, JComponent var3) {
      super(var1, var3);
      this.b = var1;
      this.a = var2;
   }

   public void a(MouseEvent var1, int var2) {
      Double var3 = new Double();
      this.a.a(var3);
      double var4 = this.b.translateX(var1.getX());
      double var6 = this.b.translateY(var1.getY());
      Point var8 = new Point();
      if(this.a.a(this.a(), var4, var6, var8)) {
         super.a(this.a(), var1, var8.x, var8.y, var2);
      }

   }

   public Cursor b() {
      return this.a().getCursor();
   }
}
