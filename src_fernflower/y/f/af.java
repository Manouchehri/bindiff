package y.f;

import java.awt.geom.Rectangle2D;
import java.util.Comparator;

class af implements Comparator {
   public int compare(Object var1, Object var2) {
      Rectangle2D var3 = (Rectangle2D)var1;
      Rectangle2D var4 = (Rectangle2D)var2;
      int var5 = y.g.e.a((int)var4.getHeight(), (int)var3.getHeight());
      return var5 == 0?y.g.e.a((int)var4.getWidth(), (int)var3.getWidth()):var5;
   }
}
