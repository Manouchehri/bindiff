/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import y.h.fj;

final class cP
extends ArrayList
implements PropertyChangeListener {
    cP() {
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        boolean bl2 = fj.z;
        int n2 = 0;
        do {
            if (n2 >= this.size()) return;
            ((PropertyChangeListener)this.get(n2)).propertyChange(propertyChangeEvent);
            ++n2;
        } while (!bl2);
    }
}

