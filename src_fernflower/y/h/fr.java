package y.h;

import java.util.Map;
import java.util.WeakHashMap;
import y.h.fp;

class fr {
   private WeakHashMap a;

   private fr() {
      this.a = new WeakHashMap();
   }

   public Map a() {
      return this.a;
   }

   static WeakHashMap a(fr var0) {
      return var0.a;
   }

   fr(fp var1) {
      this();
   }
}
