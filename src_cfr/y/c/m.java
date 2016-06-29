/*
 * Decompiled with CFR 0_115.
 */
package y.c;

import y.c.H;
import y.c.I;
import y.c.L;
import y.c.d;
import y.c.q;

class M
implements H {
    private I a;
    private final L b;

    M(L l2) {
        this.b = l2;
        this.a = L.a(l2);
    }

    @Override
    public boolean f() {
        if (this.a == null) return false;
        return true;
    }

    @Override
    public void g() {
        this.a = this.a.i;
    }

    @Override
    public void h() {
        this.a = this.a.j;
    }

    @Override
    public void j() {
        this.a = L.b(this.b);
    }

    @Override
    public void i() {
        this.a = L.a(this.b);
    }

    @Override
    public int k() {
        return L.c(this.b);
    }

    @Override
    public Object d() {
        return this.a;
    }

    @Override
    public q e() {
        return (q)this.a;
    }

    @Override
    public d a() {
        return (d)this.a;
    }

    @Override
    public void b() {
        this.g();
        if (this.f()) return;
        this.i();
    }

    @Override
    public void c() {
        this.h();
        if (this.f()) return;
        this.j();
    }
}

