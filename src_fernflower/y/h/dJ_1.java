package y.h;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import y.h.bu;
import y.h.dI;

class dJ implements PropertyChangeListener {
   private final dI a;

   dJ(dI var1) {
      this.a = var1;
   }

   public void propertyChange(PropertyChangeEvent var1) {
      if(dI.a(this.a) != null && var1.getOldValue() instanceof bu) {
         ((bu)var1.getOldValue()).b((y.c.o)dI.a(this.a));
         dI.a((dI)this.a, (y.c.o)null);
      }

      if(this.a.isEditing()) {
         this.a.cancelEditing();
      }

   }
}
