/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import y.f.aG;
import y.f.k.R;

final class S
implements Comparable {
    y.f.S a;
    int b;

    private S(y.f.S s2, int n2) {
        this.a = s2;
        this.b = n2;
    }

    public int compareTo(Object object) {
        int n2;
        S s2 = (S)object;
        aG aG2 = this.a.f();
        aG aG3 = s2.a.f();
        int n3 = aG2.k() ? -1 : (n2 = aG2.j() ? 0 : 1);
        int n4 = aG3.k() ? -1 : (aG3.j() ? 0 : 1);
        return n2 - n4;
    }

    S(y.f.S s2, int n2, R r2) {
        this(s2, n2);
    }
}

