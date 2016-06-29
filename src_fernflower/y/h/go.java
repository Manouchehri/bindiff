package y.h;

import java.awt.RenderingHints.Key;
import y.h.gp;

final class go extends Key {
   go() {
      super(0);
   }

   public boolean isCompatibleValue(Object var1) {
      return var1 == null || var1 instanceof gp;
   }

   public String toString() {
      return "Sloppy rect painting enable key";
   }
}
