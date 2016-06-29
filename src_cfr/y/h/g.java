/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import y.c.o;
import y.h.F;
import y.h.bu;

class G
implements PropertyChangeListener {
    private final F a;

    G(F f2) {
        this.a = f2;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (F.a(this.a) != null && propertyChangeEvent.getOldValue() instanceof bu) {
            ((bu)propertyChangeEvent.getOldValue()).b(F.a(this.a));
            F.a(this.a, null);
        }
        this.a.n();
    }
}

