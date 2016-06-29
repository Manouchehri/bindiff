/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import y.c.d;
import y.c.q;
import y.h.a.G;
import y.h.a.v;

final class J
extends G {
    private final v f;

    J(v v2, q q2) {
        super(v2, q2);
        this.f = v2;
        this.c = this.a(q2);
    }

    @Override
    d a(q q2) {
        return q2.g();
    }

    @Override
    d a(d d2) {
        return d2.h();
    }

    @Override
    void a() {
        int n2;
        d d2;
        block4 : {
            n2 = v.a;
            while (this.c == null) {
                d2 = this.b;
                if (n2 == 0) {
                    if (d2 == this.a) {
                        this.d = null;
                        this.e = false;
                        return;
                    }
                    this.c = this.b;
                    this.b = this.c.d().f();
                    this.c = this.a(this.c);
                    if (n2 == 0) continue;
                }
                break block4;
            }
            d2 = this.c;
        }
        q q2 = d2.c();
        this.d = (q)v.e(this.f).b(q2);
        this.e = true;
        if (q2.b() > 0 && !this.f.j(this.d)) {
            this.b = this.c;
            this.c = this.a(q2);
            if (n2 == 0) return;
        }
        this.c = this.a(this.c);
    }
}

