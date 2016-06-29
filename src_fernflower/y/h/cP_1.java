package y.h;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import y.h.fj;

final class cP extends ArrayList implements PropertyChangeListener {
   public void propertyChange(PropertyChangeEvent var1) {
      boolean var3 = fj.z;
      int var2 = 0;

      while(var2 < this.size()) {
         ((PropertyChangeListener)this.get(var2)).propertyChange(var1);
         ++var2;
         if(var3) {
            break;
         }
      }

   }
}
