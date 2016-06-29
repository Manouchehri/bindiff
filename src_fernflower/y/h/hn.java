package y.h;

import java.awt.RenderingHints.Key;
import y.h.cV;

class hn extends Key {
   hn() {
      super(6002);
   }

   public boolean isCompatibleValue(Object var1) {
      return var1 instanceof cV;
   }

   public String toString() {
      return "Graphics context key";
   }
}
