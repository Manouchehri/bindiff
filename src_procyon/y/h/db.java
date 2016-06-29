package y.h;

import java.awt.event.*;

class db implements KeyListener
{
    private final da a;
    
    db(final da a) {
        this.a = a;
    }
    
    public void keyTyped(final KeyEvent keyEvent) {
    }
    
    public void keyPressed(final KeyEvent keyEvent) {
    }
    
    public void keyReleased(final KeyEvent keyEvent) {
        if (this.a.isActive() && keyEvent.getKeyCode() == da.a(this.a)) {
            this.a.j();
        }
        if (!this.a.isActive()) {
            this.a.view.removeKeyListener(this);
            da.a(this.a, null);
        }
    }
}
