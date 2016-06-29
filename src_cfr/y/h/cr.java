/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.b.a;
import y.b.c;
import y.h.cQ;
import y.h.fj;

class cR
implements c {
    private final cQ a;

    cR(cQ cQ2) {
        this.a = cQ2;
    }

    @Override
    public void animationPerformed(a a2) {
        if (a2.a() == 3) {
            cQ.access$002(this.a, true);
            if (!fj.z) return;
        }
        if (a2.a() != 4) return;
        cQ.access$002(this.a, false);
    }
}

