package y.h;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import y.h.bu;
import y.h.fu;

class fv implements PropertyChangeListener {
   private final fu a;

   fv(fu var1) {
      this.a = var1;
   }

   public void propertyChange(PropertyChangeEvent var1) {
      if(fu.a(this.a) != null && var1.getOldValue() instanceof bu) {
         ((bu)var1.getOldValue()).b((y.c.o)fu.a(this.a));
         fu.a((fu)this.a, (y.c.o)null);
      }

      this.a.cancelEditing();
   }
}
