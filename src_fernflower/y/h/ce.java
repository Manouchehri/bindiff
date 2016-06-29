package y.h;

import java.util.EventObject;
import y.h.bu;
import y.h.x;

public class ce extends EventObject {
   private Object a;

   public ce(bu var1, Object var2) {
      super(var1);
      this.a = var2;
   }

   public boolean a() {
      return this.a instanceof y.c.q;
   }

   public boolean b() {
      return this.a instanceof y.c.d;
   }

   public boolean c() {
      return this.a instanceof x;
   }

   public Object d() {
      return this.a;
   }

   public bu e() {
      return (bu)this.getSource();
   }
}
