/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import java.util.Comparator;
import y.d.k;

class i
implements Comparator {
    i() {
    }

    public int compare(Object object, Object object2) {
        k k2 = (k)object;
        k k3 = (k)object2;
        if (k2.a < k3.a) {
            return -1;
        }
        if (k2.a > k3.a) {
            return 1;
        }
        if (k2.b == 1 && k3.b == 0) {
            return 1;
        }
        if (k2.b != 0) return 0;
        if (k3.b != 1) return 0;
        return -1;
    }

    @Override
    public boolean equals(Object object) {
        return false;
    }
}

