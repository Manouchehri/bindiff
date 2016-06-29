package y.h;

import java.awt.event.*;

class H implements KeyListener
{
    private final F a;
    
    H(final F a) {
        this.a = a;
    }
    
    private void a(final KeyEvent keyEvent) {
        if (this.a.isActive() && (keyEvent.getModifiers() & this.a.getModifierMask()) != 0x0 != F.b(this.a) && this.a.lastMoveEvent != null && this.a.lastDragEvent != null) {
            if (this.a.lastMoveEvent.getWhen() < this.a.lastDragEvent.getWhen()) {
                if (this.a.lastReleaseEvent != null && this.a.lastReleaseEvent.getWhen() >= this.a.lastDragEvent.getWhen()) {
                    return;
                }
                this.a.mouseDragged(new MouseEvent(this.a.lastDragEvent.getComponent(), this.a.lastDragEvent.getID(), this.a.lastDragEvent.getWhen() + 1L, keyEvent.getModifiersEx(), this.a.lastDragEvent.getX(), this.a.lastDragEvent.getY(), 0, false));
                if (!fj.z) {
                    return;
                }
            }
            if (this.a.lastReleaseEvent == null || this.a.lastReleaseEvent.getWhen() < this.a.lastMoveEvent.getWhen()) {
                this.a.mouseMoved(new MouseEvent(this.a.lastMoveEvent.getComponent(), this.a.lastMoveEvent.getID(), this.a.lastMoveEvent.getWhen() + 1L, keyEvent.getModifiersEx(), this.a.lastMoveEvent.getX(), this.a.lastMoveEvent.getY(), 0, false));
            }
        }
    }
    
    public void keyTyped(final KeyEvent keyEvent) {
    }
    
    public void keyPressed(final KeyEvent keyEvent) {
        this.a(keyEvent);
    }
    
    public void keyReleased(final KeyEvent keyEvent) {
        this.a(keyEvent);
        if (!F.c(this.a) && F.d(this.a) && F.e(this.a) != 0 && keyEvent.getKeyCode() == F.e(this.a)) {
            this.a.n();
        }
        if (!F.d(this.a)) {
            this.a.view.removeKeyListener(this);
            F.a(this.a, (KeyListener)null);
        }
    }
}
