package y.f.e;

import java.awt.Rectangle;

class o implements y.d.o {
   public Rectangle a;
   private y.d.y b;

   o(Rectangle var1) {
      this.a = var1;
      this.b = new y.d.y((double)var1.x, (double)var1.y, (double)var1.width, (double)var1.height);
   }

   public y.d.y h() {
      return this.b;
   }
}
