/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.d;
import y.c.q;
import y.d.t;
import y.f.X;
import y.f.aE;
import y.f.c.a.A;
import y.f.c.a.N;
import y.f.c.a.aV;
import y.f.c.a.bz;

class bF {
    private d a;
    private aE b;
    private aE c;
    private X d;
    private boolean e;

    private bF(d d2, X x2, aV aV2, boolean bl2) {
        this.a = d2;
        this.d = x2;
        A a2 = aV2.a(d2);
        this.b = bl2 ? a2.e() : a2.c();
        this.c = bl2 ? a2.c() : a2.e();
        this.e = bl2;
    }

    public q a() {
        if (!this.e) return this.a.c();
        return this.a.d();
    }

    public q b() {
        if (this.e) return this.a.c();
        return this.a.d();
    }

    public aE c() {
        return this.b;
    }

    public aE d() {
        return this.c;
    }

    public boolean a(d d2) {
        return this.a.equals(d2);
    }

    public t e() {
        if (!this.e) return this.d.p(this.a);
        return this.d.q(this.a);
    }

    public void a(t t2) {
        if (this.e) {
            this.d.d(this.a, t2);
            if (!N.x) return;
        }
        this.d.c(this.a, t2);
    }

    public t f() {
        if (this.e) return this.d.p(this.a);
        return this.d.q(this.a);
    }

    public void b(t t2) {
        if (!this.e) {
            this.d.d(this.a, t2);
            if (!N.x) return;
        }
        this.d.c(this.a, t2);
    }

    public t g() {
        if (!this.e) return this.d.n(this.a);
        return this.d.o(this.a);
    }

    public void c(t t2) {
        if (this.e) {
            this.d.b(this.a, t2);
            if (!N.x) return;
        }
        this.d.a(this.a, t2);
    }

    public t h() {
        if (this.e) return this.d.n(this.a);
        return this.d.o(this.a);
    }

    public void d(t t2) {
        if (!this.e) {
            this.d.b(this.a, t2);
            if (!N.x) return;
        }
        this.d.a(this.a, t2);
    }

    bF(d d2, X x2, aV aV2, boolean bl2, bz bz2) {
        this(d2, x2, aV2, bl2);
    }
}

