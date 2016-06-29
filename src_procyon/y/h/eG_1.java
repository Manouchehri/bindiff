package y.h;

import javax.swing.event.*;

final class eG implements ChangeListener
{
    private final eD a;
    
    private eG(final eD a) {
        this.a = a;
    }
    
    public void stateChanged(final ChangeEvent changeEvent) {
        final dx dx = (dx)changeEvent.getSource();
        if (!dx.c()) {
            dx.b(this);
            eD.a(this.a, null);
        }
    }
    
    eG(final eD ed, final eE ee) {
        this(ed);
    }
}
