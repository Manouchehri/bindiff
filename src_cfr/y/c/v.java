/*
 * Decompiled with CFR 0_115.
 */
package y.c;

import y.c.d;
import y.c.e;
import y.c.q;

class v
implements e {
    d a;
    private final q b;

    v(q q2) {
        this.b = q2;
        this.a = q2.c;
    }

    v(q q2, d d2) {
        this.b = q2;
        this.a = d2;
    }

    @Override
    public boolean f() {
        if (this.a == null) return false;
        return true;
    }

    @Override
    public void g() {
        this.a = this.a.a;
    }

    @Override
    public void h() {
        this.a = this.a.c;
    }

    @Override
    public void b() {
        this.g();
        if (this.a != null) return;
        this.i();
    }

    @Override
    public void c() {
        this.h();
        if (this.a != null) return;
        this.j();
    }

    @Override
    public void i() {
        this.a = this.b.c;
    }

    @Override
    public void j() {
        this.a = this.b.d;
    }

    @Override
    public int k() {
        return this.b.f;
    }

    @Override
    public Object d() {
        return this.a;
    }

    @Override
    public d a() {
        return this.a;
    }
}

