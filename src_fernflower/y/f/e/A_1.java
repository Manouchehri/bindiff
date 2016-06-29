package y.f.e;

import java.awt.geom.Rectangle2D;
import y.f.X;

final class A implements y.f.b.a {
   private final y.f.b.a a;

   public A(y.f.b.a var1) {
      this.a = var1;
   }

   public Rectangle2D a(X var1, y.c.q var2, y.c.y var3) {
      if(var3.isEmpty()) {
         Rectangle2D var4 = this.a.a(var1, var2, var3);
         double var5 = var1.j(var2);
         double var7 = var1.k(var2);
         var4.setFrame(var5 - var4.getWidth() * 0.5D, var7 - var4.getHeight() * 0.5D, var4.getWidth(), var4.getHeight());
         return var4;
      } else {
         return this.a.a(var1, var2, var3);
      }
   }
}
