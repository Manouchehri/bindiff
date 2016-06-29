package y.h;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import y.h.ds;

class dt implements MouseWheelListener {
   private final ds a;

   dt(ds var1) {
      this.a = var1;
   }

   public void mouseWheelMoved(MouseWheelEvent var1) {
      this.a.a(var1);
   }
}
