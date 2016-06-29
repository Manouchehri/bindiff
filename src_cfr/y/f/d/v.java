/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import java.util.Comparator;
import y.f.d.u;
import y.f.d.z;

class v
implements Comparator {
    private final u a;

    v(u u2) {
        this.a = u2;
    }

    public int compare(Object object, Object object2) {
        z z2 = (z)object;
        z z3 = (z)object2;
        if (z2.d > z3.d) {
            return -1;
        }
        if (z2.d >= z3.d) return 0;
        return 1;
    }
}

