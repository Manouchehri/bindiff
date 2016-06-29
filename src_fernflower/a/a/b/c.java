package a.a.b;

import a.a.b.a;
import a.a.b.b;
import java.awt.RenderingHints.Key;

final class c extends Key {
   private c() {
      super(0);
   }

   public boolean isCompatibleValue(Object var1) {
      return var1 == null || var1 instanceof a;
   }

   c(b var1) {
      this();
   }
}
