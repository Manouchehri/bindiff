/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.a.M;
import y.a.N;
import y.a.h;
import y.c.i;
import y.c.q;
import y.c.x;

class Q {
    N[] a;
    M b;

    public Q(i i2) {
        boolean bl2 = h.a;
        this.a = new N[i2.e()];
        this.b = new M();
        x x2 = i2.o();
        do {
            if (!x2.f()) return;
            this.a[x2.e().d()] = this.b.a(x2.e());
            x2.g();
        } while (!bl2);
    }

    public void a(q q2, q q3) {
        this.b.a(this.b(q2), this.b(q3));
    }

    public q a(q q2) {
        return this.a(this.b.a(this.b(q2)));
    }

    public boolean b(q q2, q q3) {
        if (this.a(q2) != this.a(q3)) return false;
        return true;
    }

    private N b(q q2) {
        return this.a[q2.d()];
    }

    private q a(N n2) {
        if (n2 == null) return null;
        return (q)this.b.b(n2);
    }
}

