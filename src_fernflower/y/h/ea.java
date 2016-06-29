package y.h;

import java.awt.geom.Rectangle2D.Double;
import y.h.az;
import y.h.e;
import y.h.en;
import y.h.gC;
import y.h.gy;
import y.h.id;

class ea extends gC {
   private final gy a;
   private final en c;

   ea(en var1, double var2, az var4, boolean var5, double var6, Object var8, gy var9) {
      super(var2, var4, var5, var6, var8);
      this.c = var1;
      this.a = var9;
   }

   public az a(e var1, y.d.t var2) {
      double var3 = var2.a - var1.k().a;
      double var5 = var2.b - var1.k().b;
      double var7 = Math.min(en.a(this.c).a(var3), en.b(this.c).a(var3));
      double var9 = Math.max(en.a(this.c).a(var3), en.b(this.c).a(var3));
      double var11 = en.a(this.c).b(var5);
      return ((id)this.a).a(new Double(var7, var11, var9 - var7, 0.0D));
   }
}
