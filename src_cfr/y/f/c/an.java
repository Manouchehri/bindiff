/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Comparator;
import y.c.d;
import y.f.aE;
import y.f.c.am;
import y.f.c.x;
import y.g.e;

final class an
implements Comparator {
    int[] a;
    private final am b;

    an(am am2) {
        this.b = am2;
        this.a = new int[]{0, 0, 1, 0};
    }

    public int compare(Object object, Object object2) {
        aE aE2 = this.b.a((d)object);
        aE aE3 = this.b.a((d)object2);
        aE aE4 = this.b.b((d)object);
        aE aE5 = this.b.b((d)object2);
        int n2 = x.a(aE2.b(), 2);
        int n3 = x.a(aE3.b(), 2);
        int n4 = x.a(aE4.b(), 0);
        int n5 = x.a(aE5.b(), 0);
        int n6 = 4 + n4 - n2 & 3;
        int n7 = 4 + n5 - n3 & 3;
        if (n6 == 2 && n7 == 2) {
            return e.a(Math.min(n3, n5), Math.min(n2, n4));
        }
        if ((n6 = this.a[n6]) != (n7 = this.a[n7])) return e.a(n6, n7);
        return e.a(n2, n3);
    }
}

