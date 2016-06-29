package y.b;

import java.util.EventObject;

public class a extends EventObject {
   private int a;

   public a(Object var1, int var2) {
      super(var1);
      this.a = var2;
   }

   public int a() {
      return this.a;
   }
}
