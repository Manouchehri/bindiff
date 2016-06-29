package y.h.a;

import java.util.EventObject;
import y.h.a.v;

public class t extends EventObject {
   private byte a;
   private Object b;
   private Object c;

   public t(v var1, byte var2, y.c.i var3, Object var4) {
      super(var1);
      this.a = var2;
      this.c = var3;
      this.b = var4;
   }

   public t(v var1, byte var2, Object var3, Object var4) {
      super(var1);
      this.a = var2;
      this.c = var3;
      this.b = var4;
   }

   public byte a() {
      return this.a;
   }

   public Object b() {
      return this.b;
   }
}
