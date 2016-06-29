/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import y.h.dx;
import y.h.eD;
import y.h.eE;

final class eG
implements ChangeListener {
    private final eD a;

    private eG(eD eD2) {
        this.a = eD2;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        dx dx2 = (dx)changeEvent.getSource();
        if (dx2.c()) return;
        dx2.b(this);
        eD.a(this.a, null);
    }

    eG(eD eD2, eE eE2) {
        this(eD2);
    }
}

