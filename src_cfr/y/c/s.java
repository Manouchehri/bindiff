/*
 * Decompiled with CFR 0_115.
 */
package y.c;

import y.c.d;
import y.c.e;
import y.c.q;

class s
implements e {
    d a;
    private final q b;

    s(q q2) {
        this.b = q2;
        this.a = q2.b;
    }

    @Override
    public boolean f() {
        if (this.a == null) return false;
        return true;
    }

    @Override
    public void g() {
        this.a = this.a.b;
    }

    @Override
    public void h() {
        this.a = this.a.d;
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
        this.a = this.b.b;
    }

    @Override
    public void j() {
        this.a = this.b.e;
    }

    @Override
    public int k() {
        return this.b.g;
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

