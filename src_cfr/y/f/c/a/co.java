/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.q;
import y.g.e;

final class cO
implements Comparator {
    final int[] a;

    cO(int[] arrn) {
        this.a = arrn;
    }

    public int compare(Object object, Object object2) {
        int n2 = this.a[((q)object).d()];
        int n3 = this.a[((q)object2).d()];
        if (n2 < 0) {
            n2 = - n2 + 1;
        }
        if (n3 >= 0) return e.a(n2, n3);
        n3 = - n3 + 1;
        return e.a(n2, n3);
    }
}

