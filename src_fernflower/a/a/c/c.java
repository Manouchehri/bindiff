package a.a.c;

import a.a.c.b;
import a.a.c.d;
import java.awt.RenderingHints.Key;

final class c extends Key {
   private c() {
      super(0);
   }

   public boolean isCompatibleValue(Object var1) {
      return var1 == null || var1 instanceof d;
   }

   c(b var1) {
      this();
   }
}
