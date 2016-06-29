/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.f.c.a.E;

class L {
    final Object a;
    final Object b;
    private final E c;

    L(E e2, Object object, Object object2) {
        this.c = e2;
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
        L l2 = (L)object;
        if (this.a != null ? !this.a.equals(l2.a) : l2.a != null) {
            return false;
        }
        if (this.b == null) {
            if (l2.b != null) return false;
            return true;
        }
        if (this.b.equals(l2.b)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        return 31 * n2 + (this.b != null ? this.b.hashCode() : 0);
    }
}

