package y.h.b;

import java.util.HashMap;
import java.util.Map;
import y.h.b.c;
import y.h.b.f;
import y.h.b.q;

final class p {
   final Map a = new HashMap();
   final Map b = new HashMap();

   int a(c var1) {
      return this.a(((q)var1).a);
   }

   int a(Object var1) {
      Integer var2 = (Integer)this.a.get(var1);
      if(var2 == null) {
         var2 = new Integer(this.a.size());
         this.a.put(var1, var2);
      }

      return var2.intValue();
   }

   int a(f var1) {
      return this.b(((q)var1).a);
   }

   int b(Object var1) {
      Integer var2 = (Integer)this.b.get(var1);
      if(var2 == null) {
         var2 = new Integer(this.b.size());
         this.b.put(var1, var2);
      }

      return var2.intValue();
   }
}
