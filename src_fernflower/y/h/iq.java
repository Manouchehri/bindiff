package y.h;

import java.awt.geom.Point2D.Double;
import y.h.gv;
import y.h.gz;
import y.h.ir;

class iq extends gz {
   private final gv a;
   private final y.d.t c;

   iq(gv var1, y.d.t var2, ir var3) {
      super(1.0D, var3);
      this.a = var1;
      this.c = var2;
   }

   public byte a(y.d.t var1, Double var2, byte var3) {
      var2.x = this.c.a();
      var2.y = this.c.b();
      return (byte)3;
   }

   public boolean a(y.d.t var1, y.d.t var2, byte var3) {
      return var2.a == this.c.a() && var2.b == this.c.b();
   }

   gv c() {
      return this.a;
   }
}
