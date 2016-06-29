package y.h;

import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import y.h.D;

class E implements PropertyChangeListener {
   private final KeyboardFocusManager a;
   private final D b;

   public E(D var1, KeyboardFocusManager var2) {
      this.b = var1;
      this.a = var2;
   }

   public void propertyChange(PropertyChangeEvent var1) {
      D.a(this.b, this.a.getPermanentFocusOwner());
   }
}
