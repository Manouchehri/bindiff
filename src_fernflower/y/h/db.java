package y.h;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import y.h.da;

class db implements KeyListener {
   private final da a;

   db(da var1) {
      this.a = var1;
   }

   public void keyTyped(KeyEvent var1) {
   }

   public void keyPressed(KeyEvent var1) {
   }

   public void keyReleased(KeyEvent var1) {
      if(this.a.isActive() && var1.getKeyCode() == da.a(this.a)) {
         this.a.j();
      }

      if(!this.a.isActive()) {
         this.a.view.removeKeyListener(this);
         da.a(this.a, (KeyListener)null);
      }

   }
}
