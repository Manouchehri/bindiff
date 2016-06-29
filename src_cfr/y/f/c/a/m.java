/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.d;
import y.d.q;
import y.d.t;
import y.f.X;
import y.f.c.a.E;
import y.f.c.a.N;

class M {
    final d a;
    final y.c.q b;
    final y.c.q c;
    private final E d;

    M(E e2, d d2, y.c.q q2, y.c.q q3) {
        this.d = e2;
        this.a = d2;
        this.b = q2;
        this.c = q3;
    }

    private void a() {
        boolean bl2;
        if (this.a.c() != this.c && this.a.d() != this.c) {
            throw new RuntimeException(new StringBuffer().append("Edge should contain endpoint ").append(this.c).toString());
        }
        if (!this.d.b.f(this.b)) {
            this.d.b.d(this.b);
        }
        this.d.b.a(this.b, this.d.b.r(this.c));
        this.d.b.a(this.b, this.d.b.l(this.c));
        boolean bl3 = bl2 = this.a.c() == this.c;
        if (bl2) {
            this.d.b.a(this.a, this.b, this.a.d());
            if (!N.x) return;
        }
        this.d.b.a(this.a, this.a.c(), this.b);
    }

    static void a(M m2) {
        m2.a();
    }
}

