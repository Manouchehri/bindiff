/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.d.F;
import y.f.d.a;
import y.f.d.f;
import y.g.a.c;

class g
implements F {
    c a;
    private final f b;

    public g(f f2) {
        this.b = f2;
        this.a = new c(f2.i);
    }

    @Override
    public void a(y y2) {
        int n2 = a.f;
        x x2 = y2.a();
        do {
            if (!x2.f()) return;
            this.a(x2.e());
            x2.g();
        } while (n2 == 0);
    }

    public void a(q q2) {
        this.a.a(q2, -100.0 - f.a(this.b).c(q2));
    }

    @Override
    public void b(q q2) {
        this.a.b(q2);
    }

    @Override
    public boolean a() {
        return this.a.b();
    }

    @Override
    public q b() {
        return this.a.a();
    }

    @Override
    public void a(q q2, double d2) {
        f.a(this.b).a((Object)q2, d2);
        this.a.c(q2, -100.0 - d2);
    }
}

