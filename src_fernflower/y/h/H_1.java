package y.h;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import y.h.F;
import y.h.fj;

class H implements KeyListener {
   private final F a;

   H(F var1) {
      this.a = var1;
   }

   private void a(KeyEvent var1) {
      if(this.a.isActive() && (var1.getModifiers() & this.a.getModifierMask()) != 0 != F.b(this.a) && this.a.lastMoveEvent != null && this.a.lastDragEvent != null) {
         if(this.a.lastMoveEvent.getWhen() < this.a.lastDragEvent.getWhen()) {
            if(this.a.lastReleaseEvent != null && this.a.lastReleaseEvent.getWhen() >= this.a.lastDragEvent.getWhen()) {
               return;
            }

            this.a.mouseDragged(new MouseEvent(this.a.lastDragEvent.getComponent(), this.a.lastDragEvent.getID(), this.a.lastDragEvent.getWhen() + 1L, var1.getModifiersEx(), this.a.lastDragEvent.getX(), this.a.lastDragEvent.getY(), 0, false));
            if(!fj.z) {
               return;
            }
         }

         if(this.a.lastReleaseEvent == null || this.a.lastReleaseEvent.getWhen() < this.a.lastMoveEvent.getWhen()) {
            this.a.mouseMoved(new MouseEvent(this.a.lastMoveEvent.getComponent(), this.a.lastMoveEvent.getID(), this.a.lastMoveEvent.getWhen() + 1L, var1.getModifiersEx(), this.a.lastMoveEvent.getX(), this.a.lastMoveEvent.getY(), 0, false));
         }
      }

   }

   public void keyTyped(KeyEvent var1) {
   }

   public void keyPressed(KeyEvent var1) {
      this.a(var1);
   }

   public void keyReleased(KeyEvent var1) {
      this.a(var1);
      if(!F.c(this.a) && F.d(this.a) && F.e(this.a) != 0 && var1.getKeyCode() == F.e(this.a)) {
         this.a.n();
      }

      if(!F.d(this.a)) {
         this.a.view.removeKeyListener(this);
         F.a((F)this.a, (KeyListener)null);
      }

   }
}
