/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.d.t;
import y.f.i.a.aI;
import y.f.i.a.aJ;

class aK {
    final aJ a;
    final aJ b;
    final t c;
    final int d;

    private aK(aJ aJ2, aJ aJ3, t t2, int n2) {
        this.a = aJ2;
        this.b = aJ3;
        this.c = t2;
        this.d = n2;
    }

    public int a() {
        return Math.min(this.a.a, this.b.a);
    }

    public int b() {
        return Math.max(this.a.a, this.b.a);
    }

    aK(aJ aJ2, aJ aJ3, t t2, int n2, aI aI2) {
        this(aJ2, aJ3, t2, n2);
    }
}

