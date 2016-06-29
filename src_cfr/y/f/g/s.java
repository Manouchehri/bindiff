/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import java.util.Comparator;
import y.f.g.o;
import y.f.g.u;

class s
implements Comparator {
    private s() {
    }

    public int compare(Object object, Object object2) {
        int n2;
        u u2 = (u)object;
        u u3 = (u)object2;
        if (u2.b() && !u3.b()) {
            return -1;
        }
        if (!u2.b() && u3.b()) {
            return 1;
        }
        int n3 = u2.l();
        if (n3 < (n2 = u3.l())) {
            return -1;
        }
        if (n3 <= n2) return 0;
        return 1;
    }

    s(o o2) {
        this();
    }
}

