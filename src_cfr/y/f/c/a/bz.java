/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.g.e;

final class bZ
implements Comparable {
    double a;
    Object b;

    bZ(double d2, Object object) {
        this.a = d2;
        this.b = object;
    }

    public int compareTo(Object object) {
        return e.a(this.a, ((bZ)object).a);
    }
}

