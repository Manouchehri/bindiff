package y.h;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import y.h.F;
import y.h.bu;

class G implements PropertyChangeListener {
   private final F a;

   G(F var1) {
      this.a = var1;
   }

   public void propertyChange(PropertyChangeEvent var1) {
      if(F.a(this.a) != null && var1.getOldValue() instanceof bu) {
         ((bu)var1.getOldValue()).b((y.c.o)F.a(this.a));
         F.a((F)this.a, (y.c.o)null);
      }

      this.a.n();
   }
}
