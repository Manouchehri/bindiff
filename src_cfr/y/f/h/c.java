/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import java.util.Comparator;
import y.c.d;
import y.c.q;

class C
implements Comparator {
    private q a;
    private int[] b;

    C() {
    }

    public void a(q q2) {
        this.a = q2;
    }

    public void a(int[] arrn) {
        this.b = arrn;
    }

    public int compare(Object object, Object object2) {
        int n2;
        d d2 = (d)object;
        d d3 = (d)object2;
        int n3 = this.b[d2.a(this.a).d()];
        if (n3 < (n2 = this.b[d3.a(this.a).d()])) {
            return -1;
        }
        if (n3 <= n2) return 0;
        return 1;
    }
}

