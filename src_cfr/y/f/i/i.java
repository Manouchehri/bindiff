/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.c.c;
import y.c.d;
import y.c.i;
import y.c.q;
import y.f.b.f;
import y.f.i.E;
import y.f.i.F;
import y.f.i.J;

class I
extends J {
    private final q b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;

    I(q q2, double d2, double d3, double d4, double d5) {
        this.b = q2;
        this.c = d2;
        this.d = d3;
        this.e = d4 + d2;
        this.f = d5 + d3;
    }

    @Override
    double a(d d2, double d3, double d4, double d5, E e2) {
        i i2 = d2.a();
        c c2 = i2.c(f.d);
        c c3 = i2.c(f.b);
        c c4 = i2.c(f.c);
        if (c3 != null && c4 != null && c2 != null && c2.d(this.b)) {
            Object object = c3.b(this.b);
            Object object2 = c4.b(d2.c());
            Object object3 = c4.b(d2.d());
            if (object2 != null) {
                if (object2.equals(object)) return 0.0;
            }
            if (object3 != null && object3.equals(object)) {
                return 0.0;
            }
        }
        if (this.b == d2.c()) return 0.0;
        if (this.b == d2.d()) {
            return 0.0;
        }
        if (d3 < this.c) return 0.0;
        if (d3 > this.e) return 0.0;
        if (d4 > this.f) return 0.0;
        if (d5 < this.d) return 0.0;
        return e2.c();
    }

    @Override
    F a(boolean bl2, double d2) {
        return new F(bl2, d2, this.d, this.f, this);
    }

    public String toString() {
        return new StringBuffer().append("NodeObject{node=").append(this.b).append('}').toString();
    }
}

