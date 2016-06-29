/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import java.util.Comparator;
import y.c.d;
import y.c.e;
import y.f.h.J;

class K
implements Comparator {
    private final J a;

    K(J j2) {
        this.a = j2;
    }

    public int compare(Object object, Object object2) {
        int n2;
        d d2 = (d)object;
        d d3 = (d)object2;
        int n3 = J.a(this.a).c(d2).k();
        if (n3 == (n2 = J.a(this.a).c(d3).k())) {
            return 0;
        }
        if (n3 <= n2) return 1;
        return -1;
    }
}

