/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.f.O;
import y.f.ah;
import y.f.l;
import y.h.bI;
import y.h.bQ;
import y.h.bS;
import y.h.bu;
import y.h.ch;

class bO
extends bS {
    private final bQ i;
    private final Runnable j;
    private final bI k;

    bO(bI bI2, ch ch2, bu bu2, ah ah2, boolean bl2, bQ bQ2, Runnable runnable) {
        super(bI2, ch2, bu2, ah2, bl2);
        this.k = bI2;
        this.i = bQ2;
        this.j = runnable;
    }

    @Override
    protected void a(l l2) {
        this.k.a(this.e, l2.C());
    }

    @Override
    protected void a() {
        super.a();
        this.e.T();
        if (this.b != null && this.i != null) {
            this.i.a(this.b);
        }
        if (this.j == null) return;
        this.j.run();
    }
}

