/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Comparator;
import y.f.c.N;
import y.f.c.a.bK;
import y.g.g;

class O
implements Comparator,
g {
    private O() {
    }

    public int compare(Object object, Object object2) {
        bK bK2 = (bK)object;
        bK bK3 = (bK)object2;
        if (bK2.a()) {
            if (!bK3.a()) return 1;
            return 0;
        }
        if (!bK3.a()) return bK2.compareTo(object2);
        return -1;
    }

    O(N n2) {
        this();
    }
}

