/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.b;

import java.util.Comparator;
import y.f.S;
import y.f.aG;

class g
implements Comparator {
    g() {
    }

    public int compare(Object object, Object object2) {
        int n2;
        S s2 = (S)object;
        S s3 = (S)object2;
        int n3 = this.a(s2.f());
        if (n3 < (n2 = this.a(s3.f()))) {
            return -1;
        }
        if (n3 <= n2) return 0;
        return 1;
    }

    private int a(aG aG2) {
        if (aG2.i()) {
            return 0;
        }
        if (aG2.i()) return 1;
        if (aG2.j()) return 1;
        return 2;
    }
}

