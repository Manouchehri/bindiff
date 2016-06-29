/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.c.d;
import y.d.m;
import y.f.i.a.bT;

class bU {
    private final d a;
    private final int b;
    private final m[] c;

    private bU(d d2, m[] arrm, int n2) {
        this.a = d2;
        this.c = arrm;
        this.b = n2;
    }

    static d a(bU bU2) {
        return bU2.a;
    }

    static m[] b(bU bU2) {
        return bU2.c;
    }

    static int c(bU bU2) {
        return bU2.b;
    }

    bU(d d2, m[] arrm, int n2, bT bT2) {
        this(d2, arrm, n2);
    }
}

