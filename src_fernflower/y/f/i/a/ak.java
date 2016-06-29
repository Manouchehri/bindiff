package y.f.i.a;

import java.util.Comparator;
import java.util.Map;
import y.f.i.a.ai;
import y.f.i.a.aj;

class ak implements Comparator {
   private final Map a;
   private final aj b;

   ak(aj var1, Map var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      ai var3 = (ai)var1;
      ai var4 = (ai)var2;
      int var5 = ((Integer)this.a.get(var3)).intValue();
      int var6 = ((Integer)this.a.get(var4)).intValue();
      return var6 - var5;
   }
}
