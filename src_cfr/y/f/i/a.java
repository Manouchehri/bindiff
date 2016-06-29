/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.Comparator;
import y.c.d;
import y.f.i.v;
import y.g.e;

class A
implements Comparator {
    private final int[] a;
    private final v b;

    A(v v2, int[] arrn) {
        this.b = v2;
        this.a = arrn;
    }

    public int compare(Object object, Object object2) {
        d d2 = (d)object;
        d d3 = (d)object2;
        return e.a(this.a[d3.b()], this.a[d2.b()]);
    }
}

