/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import y.c.d;
import y.c.q;
import y.h.a.G;
import y.h.a.v;

final class D
extends G {
    private final v f;

    D(v v2, q q2) {
        super(v2, q2);
        this.f = v2;
        this.c = this.a(q2);
    }

    @Override
    d a(q q2) {
        int n2 = v.a;
        d d2 = null;
        q q3 = (q)v.e(this.f).b(q2);
        if (q2.b() <= 0) return d2;
        d2 = q2.i();
        q2 = d2.c();
        q3 = (q)v.e(this.f).b(q2);
        do {
            if (q2.b() <= 0) return d2;
            if (q3 != null) {
                if (this.f.j(q3)) return d2;
            }
            d2 = q2.i();
            q2 = d2.c();
            q3 = (q)v.e(this.f).b(q2);
        } while (n2 == 0);
        return d2;
    }

    @Override
    d a(d d2) {
        return d2.j();
    }

    @Override
    void a() {
        q q2;
        int n2 = v.a;
        if (this.c == null) {
            if (this.b == this.a) {
                this.d = null;
                this.e = false;
                if (n2 == 0) return;
            }
            this.c = this.b;
            q2 = this.c.c();
            this.d = (q)v.e(this.f).b(q2);
            this.e = true;
            this.b = this.c.d().h();
            this.c = this.a(this.c);
            if (n2 == 0) return;
        }
        if ((q2 = this.c.c()).b() > 0 && !this.f.j((q)v.e(this.f).b(q2))) {
            this.c = this.a(q2);
        }
        q2 = this.c.c();
        this.d = (q)v.e(this.f).b(q2);
        this.e = true;
        this.b = this.c.d().h();
        this.c = this.a(this.c);
    }
}

