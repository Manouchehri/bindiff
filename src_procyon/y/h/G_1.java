package y.h;

import java.beans.*;
import y.c.*;

class G implements PropertyChangeListener
{
    private final F a;
    
    G(final F a) {
        this.a = a;
    }
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        if (F.a(this.a) != null && propertyChangeEvent.getOldValue() instanceof bu) {
            ((bu)propertyChangeEvent.getOldValue()).b(F.a(this.a));
            F.a(this.a, (o)null);
        }
        this.a.n();
    }
}
