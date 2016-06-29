/*
 * Decompiled with CFR 0_115.
 */
package y.f.b;

import java.util.Collection;
import y.c.D;

class n {
    D a = null;
    D b = null;
    D c = null;
    D d = null;

    n() {
    }

    public D a() {
        D d2 = new D();
        if (this.a != null) {
            d2.addAll(this.a);
        }
        if (this.b != null) {
            d2.addAll(this.b);
        }
        if (this.c != null) {
            d2.addAll(this.c);
        }
        if (this.d == null) return d2;
        d2.addAll(this.d);
        return d2;
    }
}

