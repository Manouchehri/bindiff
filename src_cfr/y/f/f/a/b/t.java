/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import y.c.f;
import y.c.q;
import y.f.f.a.a.b;
import y.f.f.a.a.e;
import y.f.f.a.a.h;
import y.f.f.a.b.r;
import y.f.f.a.b.s;

class t
implements h {
    private final r a;

    private t(r r2) {
        this.a = r2;
    }

    @Override
    public void a(e e2) {
        b b2 = (b)e2;
        q q2 = b2.b_();
        if (b2.e()) {
            return;
        }
        f f2 = r.a(this.a).b(q2);
        if (!b2.d() && f2.size() != 0) {
            this.a.a(q2);
            this.a.b(q2);
            r.a(this.a).i(q2);
            return;
        }
        r.a(this.a).i(q2);
    }

    t(r r2, s s2) {
        this(r2);
    }
}

