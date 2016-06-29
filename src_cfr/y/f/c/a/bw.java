/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.a.e;
import y.c.D;
import y.c.p;
import y.c.q;
import y.f.c.a.bT;

class bW
extends e {
    private final p[] a;
    private final int[] f;
    private final D[] g;
    private final bT h;

    bW(bT bT2, p[] arrp, int[] arrn, D[] arrd) {
        this.h = bT2;
        this.a = arrp;
        this.f = arrn;
        this.g = arrd;
    }

    @Override
    protected void a(q q2, int n2) {
        p p2 = this.a[q2.d()];
        int n3 = this.f[q2.d()] - 1;
        if (n3 < 0) return;
        D d2 = this.g[n3];
        if (!bT.a(this.h, q2)) return;
        d2.h(p2);
        d2.a(p2);
    }
}

