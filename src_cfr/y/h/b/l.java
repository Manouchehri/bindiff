/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import y.h.b.K;

public final class L {
    private final int a;

    private L(int n2) {
        this.a = n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        L l2 = (L)object;
        if (this.a == l2.a) return true;
        return false;
    }

    public int hashCode() {
        return this.a;
    }

    L(int n2, K k2) {
        this(n2);
    }
}

