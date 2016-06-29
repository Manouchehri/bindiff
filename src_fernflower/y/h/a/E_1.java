package y.h.a;

import java.util.HashMap;
import java.util.Map;

final class E {
   y.c.q a;
   y.c.q b;
   Map c;

   E(y.c.q var1, y.c.q var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("source == null");
      } else if(var2 == null) {
         throw new IllegalArgumentException("target == null");
      } else {
         this.a = var1;
         this.b = var2;
      }
   }

   y.c.q a() {
      return this.a;
   }

   y.c.q b() {
      return this.b;
   }

   Object a(String var1, Object var2) {
      if(this.c == null) {
         this.c = new HashMap();
      }

      return this.c.put(var1, var2);
   }

   Object a(String var1) {
      return this.c == null?null:this.c.get(var1);
   }

   Object b(String var1) {
      return this.c == null?null:this.c.remove(var1);
   }

   public String toString() {
      return "source = " + this.a + "  target = " + this.b;
   }
}
