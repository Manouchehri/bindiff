package y.h;

import java.awt.RenderingHints.Key;

class hs extends Key {
   hs() {
      super(6001);
   }

   public boolean isCompatibleValue(Object var1) {
      return var1 instanceof Double;
   }

   public String toString() {
      return "Paint detail threshold key";
   }
}
