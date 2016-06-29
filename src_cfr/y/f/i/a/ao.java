/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.Comparator;
import y.c.A;
import y.f.i.a.aN;

class aO
implements Comparator {
    private final A a;
    private final aN b;

    aO(aN aN2, A a2) {
        this.b = aN2;
        this.a = a2;
    }

    public int compare(Object object, Object object2) {
        int n2;
        int n3 = this.a.a(object);
        if (n3 < (n2 = this.a.a(object2))) {
            return -1;
        }
        if (n3 <= n2) return 0;
        return 1;
    }
}

