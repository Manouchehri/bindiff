package y.h;

import java.beans.*;
import y.c.*;

class aD implements PropertyChangeListener
{
    private final aC a;
    
    aD(final aC a) {
        this.a = a;
    }
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        final i i = (i)propertyChangeEvent.getOldValue();
        if (i != null && i.c(aC.ORTHOGONAL_ROUTING_DPKEY) == aC.access$000(this.a)) {
            i.d_(aC.ORTHOGONAL_ROUTING_DPKEY);
        }
        if (aC.access$100(this.a.view.getGraph2D()) == null) {
            this.a.view.getGraph2D().a(aC.ORTHOGONAL_ROUTING_DPKEY, aC.access$000(this.a));
        }
    }
}
