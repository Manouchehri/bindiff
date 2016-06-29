/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import y.c.d;
import y.c.q;
import y.d.m;
import y.d.t;
import y.f.X;

class C {
    private d a;
    private t b;
    private t c;

    C(d d2, t t2, t t3) {
        this.a = d2;
        this.b = t2;
        this.c = t3;
    }

    m a(X x2) {
        t t2 = x2.l(this.a.c());
        t t3 = x2.l(this.a.d());
        return new m(t.b(t2, this.b), t.b(t3, this.c));
    }
}

