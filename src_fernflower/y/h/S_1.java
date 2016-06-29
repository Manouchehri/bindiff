package y.h;

import java.awt.RenderingHints.Key;
import y.h.C;
import y.h.T;
import y.h.bu;

final class S extends Key {
   public static final Key a = new S();

   protected S() {
      super(1764);
   }

   public boolean isCompatibleValue(Object var1) {
      return var1 instanceof T || var1 == null;
   }

   public static Object a(bu var0, C var1) {
      return new T(var0, var1);
   }
}
