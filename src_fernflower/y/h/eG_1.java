package y.h;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import y.h.dx;
import y.h.eD;
import y.h.eE;
import y.h.eF;

final class eG implements ChangeListener {
   private final eD a;

   private eG(eD var1) {
      this.a = var1;
   }

   public void stateChanged(ChangeEvent var1) {
      dx var2 = (dx)var1.getSource();
      if(!var2.c()) {
         var2.b((ChangeListener)this);
         eD.a(this.a, (eF)null);
      }

   }

   eG(eD var1, eE var2) {
      this(var1);
   }
}
