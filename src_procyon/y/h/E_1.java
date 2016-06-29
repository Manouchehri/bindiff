package y.h;

import java.awt.*;
import java.beans.*;

class E implements PropertyChangeListener
{
    private final KeyboardFocusManager a;
    private final D b;
    
    public E(final D b, final KeyboardFocusManager a) {
        this.b = b;
        this.a = a;
    }
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        D.a(this.b, this.a.getPermanentFocusOwner());
    }
}
