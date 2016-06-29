/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import java.util.Comparator;
import y.a.g;
import y.c.i;
import y.c.q;
import y.g.e;

class m
implements Comparator {
    int[] a;

    m(i i2) {
        if (g.b(i2)) {
            throw new RuntimeException("Found cycle in constraint graph!");
        }
        this.a = new int[i2.e()];
        y.a.m.a(i2, this.a);
    }

    public int compare(Object object, Object object2) {
        q q2 = (q)object;
        q q3 = (q)object2;
        return e.a(this.a[q2.d()], this.a[q3.d()]);
    }
}

