/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import y.d.m;
import y.d.s;
import y.d.t;
import y.d.u;

class x
implements s {
    u a;
    t b = null;

    x(u u2) {
        this.a = u2;
        if (!this.a.f()) return;
        this.b = this.a.a();
        this.a.g();
    }

    @Override
    public boolean f() {
        return this.a.f();
    }

    @Override
    public void g() {
        this.b = this.a.a();
        this.a.g();
    }

    @Override
    public void h() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void i() {
        this.a.i();
        if (!this.a.f()) return;
        this.b = this.a.a();
        this.a.g();
    }

    @Override
    public void j() {
        this.a.j();
        this.a.h();
        if (!this.a.f()) return;
        this.b = this.a.a();
        this.a.g();
    }

    @Override
    public Object d() {
        return this.a();
    }

    @Override
    public m a() {
        t t2 = this.a.a();
        if (this.b == null) throw new NullPointerException();
        if (t2 != null) return new m(this.b, t2);
        throw new NullPointerException();
    }

    @Override
    public int k() {
        if (this.a.k() >= 2) return this.a.k() - 1;
        return 0;
    }
}

