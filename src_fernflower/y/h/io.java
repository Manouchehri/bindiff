package y.h;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import y.h.ir;
import y.h.is;

class io implements is {
   private final Graphics2D a;
   private final ir b;

   io(ir var1, Graphics2D var2) {
      this.b = var1;
      this.a = var2;
   }

   public void a(Line2D var1) {
      this.a.draw(var1);
   }
}
