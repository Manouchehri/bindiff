package y.h.b;

import java.awt.Rectangle;
import y.h.az;

abstract class ab implements az {
   protected double a;
   protected double b;
   protected double c;
   protected double d;

   public void a(double var1, double var3, double var5, double var7) {
      this.a = var1;
      this.b = var3;
      this.c = Math.ceil(var5);
      this.d = Math.ceil(var7);
   }

   public Rectangle getBounds() {
      return new Rectangle((int)this.a, (int)this.b, (int)this.c, (int)this.d);
   }
}
