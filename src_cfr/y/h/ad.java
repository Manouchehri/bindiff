/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import y.c.c;
import y.c.i;
import y.h.aC;
import y.h.bu;
import y.h.ch;

class aD
implements PropertyChangeListener {
    private final aC a;

    aD(aC aC2) {
        this.a = aC2;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        i i2 = (i)propertyChangeEvent.getOldValue();
        if (i2 != null && i2.c(aC.ORTHOGONAL_ROUTING_DPKEY) == aC.access$000(this.a)) {
            i2.d_(aC.ORTHOGONAL_ROUTING_DPKEY);
        }
        if (aC.access$100(this.a.view.getGraph2D()) != null) return;
        this.a.view.getGraph2D().a(aC.ORTHOGONAL_ROUTING_DPKEY, aC.access$000(this.a));
    }
}

