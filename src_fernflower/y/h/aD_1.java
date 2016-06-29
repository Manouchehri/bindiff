package y.h;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import y.h.aC;

class aD implements PropertyChangeListener {
   private final aC a;

   aD(aC var1) {
      this.a = var1;
   }

   public void propertyChange(PropertyChangeEvent var1) {
      y.c.i var2 = (y.c.i)var1.getOldValue();
      if(var2 != null && var2.c(aC.ORTHOGONAL_ROUTING_DPKEY) == aC.access$000(this.a)) {
         var2.d_(aC.ORTHOGONAL_ROUTING_DPKEY);
      }

      if(aC.access$100(this.a.view.getGraph2D()) == null) {
         this.a.view.getGraph2D().a((Object)aC.ORTHOGONAL_ROUTING_DPKEY, (y.c.c)aC.access$000(this.a));
      }

   }
}
