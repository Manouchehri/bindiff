/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.Comparator;
import y.c.c;
import y.f.i.a.z;

class D
implements Comparator {
    private c a;
    private c b;

    private D(c c2, c c3) {
        this.a = c2;
        this.b = c3;
    }

    public int compare(Object object, Object object2) {
        int n2;
        int n3 = this.a.a(object) + this.b.a(object);
        if (n3 < (n2 = this.a.a(object2) + this.b.a(object2))) {
            return 1;
        }
        if (n3 <= n2) return 0;
        return -1;
    }

    D(c c2, c c3, z z2) {
        this(c2, c3);
    }
}

