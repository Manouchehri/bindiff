/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import y.f.a.B;
import y.f.a.z;

class D {
    B a;
    B b;
    private final z c;

    public D(z z2, B b2, B b3) {
        this.c = z2;
        this.a = b2;
        this.b = b3;
    }

    public boolean equals(Object object) {
        if (!(object instanceof D)) return false;
        D d2 = (D)object;
        if (B.a(this.a) == B.a(d2.a)) {
            if (B.a(this.b) == B.a(d2.b)) return true;
        }
        if (B.a(this.a) != B.a(d2.b)) return false;
        if (B.a(this.b) != B.a(d2.a)) return false;
        return true;
    }

    public int hashCode() {
        int n2 = this.a.hashCode();
        int n3 = this.b.hashCode();
        return n2 ^ n3;
    }
}

