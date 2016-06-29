/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import y.a.y;
import y.c.C;
import y.c.f;
import y.c.i;
import y.f.f.a.a.e;
import y.f.f.a.a.h;
import y.f.f.a.b.n;
import y.f.f.a.b.o;
import y.f.f.a.b.p;

class q
implements h {
    n a;
    f b;
    private final o c;

    private q(o o2) {
        this.c = o2;
    }

    @Override
    public void a(e e2) {
        this.a = (n)e2;
        if (this.a.d()) {
            return;
        }
        this.a.b(o.a(this.c));
        this.b = y.a(o.a(this.c));
        o.b(this.c).a(this.b.a());
        this.a.a(o.a(this.c));
    }

    q(o o2, p p2) {
        this(o2);
    }
}

