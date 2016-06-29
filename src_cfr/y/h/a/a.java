/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import y.c.d;
import y.c.q;
import y.c.x;
import y.h.a.v;

final class A
implements x {
    q a;
    d b;
    private final v c;

    A(v v2, q q2) {
        this.c = v2;
        this.a = q2;
        this.b = q2.g();
    }

    @Override
    public Object d() {
        return v.e(this.c).b(this.b.c());
    }

    @Override
    public void g() {
        this.b = this.b.h();
    }

    @Override
    public q e() {
        return (q)v.e(this.c).b(this.b.c());
    }

    @Override
    public boolean f() {
        if (this.b == null) return false;
        return true;
    }

    @Override
    public void h() {
        this.b = this.b.j();
    }

    @Override
    public int k() {
        return this.a.b();
    }

    @Override
    public void i() {
        this.b = this.a.g();
    }

    @Override
    public void j() {
        this.b = this.a.i();
    }
}

