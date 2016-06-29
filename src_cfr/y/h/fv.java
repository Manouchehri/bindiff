/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Component;
import y.h.fT;

class fV
implements Runnable {
    private final fT a;

    fV(fT fT2) {
        this.a = fT2;
    }

    @Override
    public void run() {
        if (!fT.b(this.a)) return;
        if (fT.c(this.a) == null) return;
        if (fT.c(this.a).getGlassPane() == null) return;
        fT.c(this.a).getGlassPane().setVisible(fT.b(this.a));
    }
}

