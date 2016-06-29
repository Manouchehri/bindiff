package y.g;

import y.g.X;
import y.g.a;

final class ac extends a {
   ac() {
      super(X.p == null?(X.p = X.a("java.lang.Class")):X.p);
   }

   protected Object a(String var1) {
      try {
         Class var2 = Class.forName(var1, false, this.getClass().getClassLoader());
         return var2;
      } catch (ClassNotFoundException var3) {
         throw new IllegalArgumentException("Did not find class " + var1);
      } catch (Exception var4) {
         throw new IllegalArgumentException("Could not load class" + var1);
      }
   }

   protected String a(Object var1) {
      return ((Class)var1).getName();
   }
}
