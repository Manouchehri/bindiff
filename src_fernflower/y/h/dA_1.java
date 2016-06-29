package y.h;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import y.h.dx;
import y.h.dz;

final class dA implements ChangeListener {
   private final dz a;

   dA(dz var1) {
      this.a = var1;
   }

   public void stateChanged(ChangeEvent var1) {
      dx var2 = (dx)var1.getSource();
      if(!var2.c()) {
         var2.b((ChangeListener)this);
         if(var2 == dz.a(this.a) && !dz.a(this.a).c()) {
            this.a.c();
         }
      }

   }
}
