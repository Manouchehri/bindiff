package y.h.b;

import java.util.HashMap;
import java.util.Map;
import y.h.b.c;
import y.h.b.f;
import y.h.b.l;
import y.h.b.q;

final class m {
   final Map a = new HashMap();
   final Map b = new HashMap();

   void a(int var1, c var2) {
      this.a.put(new Integer(var1), ((q)var2).a);
   }

   Object a(int var1) {
      Object var2 = this.a.get(new Integer(var1));
      return var2 == null?l.a:var2;
   }

   void a(int var1, f var2) {
      this.b.put(new Integer(var1), ((q)var2).a);
   }

   Object b(int var1) {
      Object var2 = this.b.get(new Integer(var1));
      return var2 == null?l.a:var2;
   }
}
