/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a;

import y.c.q;
import y.f.f.a.a.b;
import y.f.f.a.a.h;
import y.f.f.a.c;
import y.f.f.a.d;
import y.f.f.a.f;

class e
implements h {
    y.c.f a;
    private final c b;

    private e(c c2) {
        this.b = c2;
        this.a = new y.c.f();
    }

    @Override
    public void a(y.f.f.a.a.e e2) {
        boolean bl2 = f.a;
        if (e2.e()) {
            return;
        }
        if (e2.d()) {
            return;
        }
        b b2 = (b)e2;
        q q2 = b2.b_();
        y.c.e e3 = c.a(this.b).g(q2).a();
        do {
            if (!e3.f()) return;
            y.c.d d2 = e3.a();
            this.a.add(d2);
            e3.g();
        } while (!bl2);
    }

    e(c c2, d d2) {
        this(c2);
    }
}

