/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.b;

import java.util.Comparator;
import y.c.A;

class f
implements Comparator {
    private A a;
    private boolean b;

    f(A a2, boolean bl2) {
        this.a = a2;
        this.b = bl2;
    }

    public int compare(Object object, Object object2) {
        double d2;
        double d3 = this.a.c(object);
        if (d3 < (d2 = this.a.c(object2))) {
            if (!this.b) return -1;
            return 1;
        }
        if (d3 <= d2) return 0;
        if (!this.b) return 1;
        return -1;
    }
}

