/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.d;
import y.d.t;
import y.f.c.a.dq;

class dr {
    private final t a;
    private final d b;

    private dr(d d2, t t2) {
        this.b = d2;
        this.a = t2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        dr dr2 = (dr)object;
        if (this.b != null ? !this.b.equals(dr2.b) : dr2.b != null) {
            return false;
        }
        if (this.a != null) {
            if (this.a.equals(dr2.a)) return true;
            return false;
        }
        if (dr2.a == null) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        return 31 * n2 + (this.b != null ? this.b.hashCode() : 0);
    }

    dr(d d2, t t2, dq dq2) {
        this(d2, t2);
    }
}

