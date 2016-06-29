/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import y.c.d;
import y.c.e;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.y;
import y.h.a.E;
import y.h.a.v;

class z {
    i a;
    q b;
    private final v c;

    z(v v2, i i2, q q2) {
        this.c = v2;
        this.a = i2;
        this.b = q2;
    }

    i a() {
        if (this.b == null) return null;
        i i2 = this.b.e();
        return i2;
    }

    z b() {
        i i2 = this.a();
        if (i2 == null) return null;
        z z2 = v.a(this.c, i2);
        return z2;
    }

    i c() {
        return this.a;
    }

    q d() {
        return this.b;
    }

    y a(q q2) {
        y y2;
        i i2;
        block3 : {
            int n2 = v.a;
            y2 = null;
            if (q2.e() == this.a) {
                y2 = new y();
                y2.a(q2);
                return y2;
            }
            i i3 = q2.e();
            y2 = new y();
            y2.a(q2);
            while (i3 != this.a) {
                i2 = i3;
                if (n2 == 0) {
                    if (i2 == this.c.g()) break;
                    q q3 = this.c.e(i3);
                    y2.a(q3);
                    i3 = this.c.f(i3);
                    if (n2 == 0) continue;
                }
                break block3;
            }
            i2 = i3;
        }
        if (i2 != null) return y2;
        return null;
    }

    void b(q q2) {
        Object object;
        int n2 = v.a;
        if (this.c.j(q2)) {
            object = this.c.m(q2);
            object.j();
            this.c.g(q2);
            if (n2 == 0) return;
        }
        object = this.d();
        z z2 = this.b();
        block0 : do {
            if (z2 == null) return;
            i i2 = object.e();
            e e2 = object.j();
            while (e2.f()) {
                d d2 = (d)e2.d();
                E e3 = v.a(this.c, d2);
                if (n2 != 0) continue block0;
                if (e3 != null && (e3.a() == q2 || e3.b() == q2)) {
                    i2.a(d2);
                }
                e2.g();
                if (n2 == 0) continue;
            }
            object = z2.d();
            z2 = z2.b();
        } while (n2 == 0);
    }
}

