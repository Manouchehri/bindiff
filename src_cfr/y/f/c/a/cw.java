/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.d;
import y.g.e;

final class cW
implements Comparator {
    final int[] a;

    cW(int[] arrn) {
        this.a = arrn;
    }

    public int compare(Object object, Object object2) {
        int n2 = this.a[((d)object).b()];
        int n3 = this.a[((d)object2).b()];
        if (n2 <= 0) return 0;
        if (n3 > 0) return e.a(n2, n3);
        return 0;
    }
}

