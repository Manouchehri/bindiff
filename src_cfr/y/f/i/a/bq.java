/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.c.q;

final class bQ {
    private final q a;
    private final Object b;

    bQ(q q2, Object object) {
        this.a = q2;
        this.b = object;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof bQ)) {
            return false;
        }
        bQ bQ2 = (bQ)object;
        if (this.a != bQ2.a) {
            return false;
        }
        if (this.b != null) {
            if (this.b.equals(bQ2.b)) return true;
            return false;
        }
        if (bQ2.b == null) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        return 31 * n2 + (this.b != null ? this.b.hashCode() : 0);
    }
}

