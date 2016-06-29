/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.h.bI;
import y.h.bQ;

class bP
implements bQ {
    private final Throwable[] a;
    private final bI b;

    bP(bI bI2, Throwable[] arrthrowable) {
        this.b = bI2;
        this.a = arrthrowable;
    }

    @Override
    public void a(Throwable throwable) {
        this.a[0] = throwable;
    }
}

