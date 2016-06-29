/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.f.X;
import y.f.aw;
import y.f.l;
import y.h.bS;

class bL
implements Runnable {
    private final bS a;

    bL(bS bS2) {
        this.a = bS2;
    }

    @Override
    public void run() {
        if (bS.a(this.a) != null) {
            bS.b(this.a).a(this.a.a, bS.a(this.a));
        }
        this.a.a(this.a.a);
    }
}

