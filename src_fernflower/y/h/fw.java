package y.h;

import java.awt.geom.Point2D.Double;
import y.h.fu;
import y.h.gz;

class fw extends gz {
   private final fu a;

   fw(fu var1, double var2) {
      super(var2);
      this.a = var1;
   }

   public byte a(y.d.t var1, Double var2, byte var3) {
      double var4 = var2.x;
      double var6 = var2.y;
      fu.b(this.a).a(var2);
      return (byte)((var4 != var2.x?1:0) | (var6 != var2.y?2:0) | var3);
   }

   public boolean a(y.d.t var1, y.d.t var2, byte var3) {
      return false;
   }
}
