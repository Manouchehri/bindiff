/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.c;
import y.f.c.a.bh;
import y.f.c.a.bt;
import y.g.e;

class aH
implements Comparator {
    private c a;
    private c b;
    private int[] c;

    aH(c c2, c c3, int[] arrn) {
        this.a = c2;
        this.b = c3;
        this.c = arrn;
    }

    public int compare(Object object, Object object2) {
        int n2 = this.b.a(object);
        int n3 = this.b.a(object2);
        bh bh2 = (bh)this.a.b(object);
        bh bh3 = (bh)this.a.b(object2);
        int n4 = bh2 != null ? bh2.c().a() : this.c[n2];
        int n5 = bh3 != null ? bh3.c().a() : this.c[n3];
        int n6 = e.a(n4, n5);
        if (n6 == 0) return e.a(n2, n3);
        return n6;
    }
}

