package y.h;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import y.h.fj;
import y.h.ir;
import y.h.is;

class ip implements is {
   private final Rectangle2D a;
   private final ir b;

   ip(ir var1, Rectangle2D var2) {
      this.b = var1;
      this.a = var2;
   }

   public void a(Line2D var1) {
      if(this.a.getWidth() < 0.0D || this.a.getHeight() < 0.0D) {
         this.a.setFrameFromDiagonal(var1.getX1(), var1.getY1(), var1.getX2(), var1.getY2());
         if(!fj.z) {
            return;
         }
      }

      this.a.add(var1.getX1(), var1.getY1());
      this.a.add(var1.getX2(), var1.getY2());
   }
}
