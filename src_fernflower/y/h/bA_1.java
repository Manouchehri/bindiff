package y.h;

import java.awt.event.MouseEvent;
import y.h.bw;
import y.h.gU;
import y.h.gX;

class bA extends gX {
   private final bw a;

   bA(bw var1, gU var2) {
      super(var2);
      this.a = var1;
   }

   public void mouseReleased(MouseEvent var1) {
      this.a.d(true);
   }

   public void mouseEntered(MouseEvent var1) {
   }
}
