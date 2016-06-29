/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import y.c.o;
import y.h.bu;
import y.h.dI;

class dJ
implements PropertyChangeListener {
    private final dI a;

    dJ(dI dI2) {
        this.a = dI2;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (dI.a(this.a) != null && propertyChangeEvent.getOldValue() instanceof bu) {
            ((bu)propertyChangeEvent.getOldValue()).b(dI.a(this.a));
            dI.a(this.a, null);
        }
        if (!this.a.isEditing()) return;
        this.a.cancelEditing();
    }
}

