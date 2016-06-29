package y.h;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import y.h.fQ;

class fR implements PropertyChangeListener {
   private final fQ a;

   fR(fQ var1) {
      this.a = var1;
   }

   public void propertyChange(PropertyChangeEvent var1) {
      int var2 = ((Number)var1.getNewValue()).intValue();
      String var3 = var2 / 10 + "." + var2 % 10 + "%";
      fQ.access$000(this.a).setSelectedItem(var3);
   }
}
