/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Comparator;
import y.c.d;
import y.c.q;
import y.f.c.S;
import y.g.e;

class T
implements Comparator {
    private final int[] a;
    private final S b;

    T(S s2, int[] arrn) {
        this.b = s2;
        this.a = arrn;
    }

    public int compare(Object object, Object object2) {
        return e.a(this.a[((d)object).c().d()], this.a[((d)object2).c().d()]);
    }
}

