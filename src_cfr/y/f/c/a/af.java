/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.c;

final class aF
implements Comparator {
    private c a;

    aF(c c2) {
        this.a = c2;
    }

    public int compare(Object object, Object object2) {
        int n2;
        int n3 = this.a.a(object);
        if (n3 > (n2 = this.a.a(object2))) {
            return -1;
        }
        if (n3 >= n2) return 0;
        return 1;
    }
}

