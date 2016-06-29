/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import y.h.a.l;
import y.h.a.n;
import y.h.ch;
import y.h.eR;
import y.h.fj;

class m
extends n {
    private final l a;

    m(l l2, fj fj2, ch ch2) {
        super(fj2, ch2);
        this.a = l2;
    }

    @Override
    protected boolean a(fj fj2, double d2, double d3) {
        return this.a.d(fj2).contains(d2, d3);
    }
}

