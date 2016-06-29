package y.h;

import java.beans.*;
import y.c.*;

class dJ implements PropertyChangeListener
{
    private final dI a;
    
    dJ(final dI a) {
        this.a = a;
    }
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        if (dI.a(this.a) != null && propertyChangeEvent.getOldValue() instanceof bu) {
            ((bu)propertyChangeEvent.getOldValue()).b(dI.a(this.a));
            dI.a(this.a, null);
        }
        if (this.a.isEditing()) {
            this.a.cancelEditing();
        }
    }
}
