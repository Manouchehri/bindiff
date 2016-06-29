/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import y.h.dx;
import y.h.dz;

final class dA
implements ChangeListener {
    private final dz a;

    dA(dz dz2) {
        this.a = dz2;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        dx dx2 = (dx)changeEvent.getSource();
        if (dx2.c()) return;
        dx2.b(this);
        if (dx2 != dz.a(this.a)) return;
        if (dz.a(this.a).c()) return;
        this.a.c();
    }
}

