/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.a;

import y.c.C;
import y.f.f.a.a.c;
import y.f.f.a.a.f;
import y.f.f.a.a.j;

class d
implements C {
    C a;
    private final c b;

    public d(c c2, C c3) {
        this.b = c2;
        this.a = c3;
    }

    @Override
    public void g() {
        this.a.g();
    }

    @Override
    public boolean f() {
        return this.a.f();
    }

    @Override
    public void h() {
        this.a.h();
    }

    @Override
    public int k() {
        return this.a.k();
    }

    @Override
    public void i() {
        this.a.i();
    }

    @Override
    public void j() {
        this.a.j();
    }

    @Override
    public Object d() {
        f f2 = (f)this.a.d();
        return this.b.b.a(f2);
    }
}

