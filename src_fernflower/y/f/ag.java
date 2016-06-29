package y.f;

import java.util.Comparator;
import y.f.X;
import y.f.am;

class ag implements Comparator {
   private final X a;
   private final boolean b;

   ag(X var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public int compare(Object var1, Object var2) {
      am var3 = this.a.a(var1);
      am var4 = this.a.a(var2);
      return this.b?y.g.e.a(var3.getY() + var3.getHeight() * 0.5D, var4.getY() + var4.getHeight() * 0.5D):y.g.e.a(var3.getX() + var3.getWidth() * 0.5D, var4.getX() + var4.getWidth() * 0.5D);
   }
}
