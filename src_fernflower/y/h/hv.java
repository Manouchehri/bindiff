package y.h;

import java.awt.RenderingHints.Key;

class hv extends Key {
   private final Class a;
   private final String b;

   hv(int var1, Class var2, String var3) {
      super(var1);
      this.a = var2;
      this.b = var3;
   }

   public boolean isCompatibleValue(Object var1) {
      return var1 == null || this.a.isInstance(var1);
   }

   public String toString() {
      return this.b;
   }
}
