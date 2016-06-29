/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import y.f.g.d;
import y.f.g.e;

class j {
    private final Object a;
    private final Object b;
    private final d c;

    private j(d d2, Object object, Object object2) {
        this.c = d2;
        this.a = object;
        this.b = object2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        j j2 = (j)object;
        if (this.b != null ? !this.b.equals(j2.b) : j2.b != null) {
            return false;
        }
        if (this.a != null) {
            if (this.a.equals(j2.a)) return true;
            return false;
        }
        if (j2.a == null) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        return 31 * n2 + (this.b != null ? this.b.hashCode() : 0);
    }

    j(d d2, Object object, Object object2, e e2) {
        this(d2, object, object2);
    }
}

