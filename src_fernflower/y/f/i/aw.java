package y.f.i;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import y.f.i.aA;
import y.f.i.av;

class aw implements y.d.g {
   private final Double a;
   private final Double b;
   private final Double c;
   private final av d;

   aw(av var1, Double var2, Double var3, Double var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public void a(Object var1, Object var2) {
      aA var3 = (aA)var1;
      aA var4 = (aA)var2;
      if(var3.e.x() != var4.e.x()) {
         this.a.setFrame(var3.c, var3.d, var3.a, var3.b);
         this.b.setFrame(var4.c, var4.d, var4.a, var4.b);
         Rectangle2D.intersect(this.a, this.b, this.c);
         if(this.c.width > 0.01D && this.c.height > 0.01D) {
            y.c.D var5 = (y.c.D)av.a(this.d).b(var3.e);
            var5.add(var4.e);
            var5 = (y.c.D)av.a(this.d).b(var4.e);
            var5.add(var3.e);
            av.b(this.d);
         }
      }

   }
}
