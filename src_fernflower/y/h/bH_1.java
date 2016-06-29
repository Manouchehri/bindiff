package y.h;

import java.beans.PropertyChangeEvent;
import y.h.bu;

public class bH extends PropertyChangeEvent {
   private Object a;

   public bH(bu var1, Object var2, String var3, Object var4, Object var5) {
      super(var1, var3, var4, var5);
      this.a = var2;
   }

   public String getPropertyName() {
      return super.getPropertyName();
   }
}
