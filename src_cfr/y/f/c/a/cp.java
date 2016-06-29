/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.q;
import y.g.e;

final class cP
implements Comparator {
    final int[] a;

    cP(int[] arrn) {
        this.a = arrn;
    }

    public int compare(Object object, Object object2) {
        return e.a(this.a[((q)object).d()], this.a[((q)object2).d()]);
    }
}

