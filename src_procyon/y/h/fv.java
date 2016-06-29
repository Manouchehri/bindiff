package y.h;

import java.beans.*;
import y.c.*;

class fv implements PropertyChangeListener
{
    private final fu a;
    
    fv(final fu a) {
        this.a = a;
    }
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        if (fu.a(this.a) != null && propertyChangeEvent.getOldValue() instanceof bu) {
            ((bu)propertyChangeEvent.getOldValue()).b(fu.a(this.a));
            fu.a(this.a, null);
        }
        this.a.cancelEditing();
    }
}
