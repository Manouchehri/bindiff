/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import java.util.Comparator;
import y.c.q;
import y.g.e;

class A
implements Comparator {
    private int[] a;

    A() {
    }

    public void a(int[] arrn) {
        this.a = arrn;
    }

    public int compare(Object object, Object object2) {
        int n2 = this.a[((q)object).d()];
        int n3 = this.a[((q)object2).d()];
        return e.a(n2, n3);
    }
}

