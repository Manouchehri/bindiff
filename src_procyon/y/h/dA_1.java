package y.h;

import javax.swing.event.*;

final class dA implements ChangeListener
{
    private final dz a;
    
    dA(final dz a) {
        this.a = a;
    }
    
    public void stateChanged(final ChangeEvent changeEvent) {
        final dx dx = (dx)changeEvent.getSource();
        if (!dx.c()) {
            dx.b(this);
            if (dx == dz.a(this.a) && !dz.a(this.a).c()) {
                this.a.c();
            }
        }
    }
}
