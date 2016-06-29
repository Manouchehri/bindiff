/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a;

import java.util.Comparator;
import y.f.S;
import y.f.aG;

class b
implements Comparator {
    b() {
    }

    public int compare(Object object, Object object2) {
        int n2;
        S s2 = (S)object;
        S s3 = (S)object2;
        aG aG2 = s2.f();
        aG aG3 = s3.f();
        int n3 = this.a(aG2);
        if (n3 < (n2 = this.a(aG3))) {
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

