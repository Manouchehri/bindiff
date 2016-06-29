/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import y.c.d;
import y.c.e;
import y.f.h.m;

class S
implements m {
    private e a;
    private boolean b;

    public S(e e2) {
        this.a = e2;
        this.a.i();
        this.b = this.a.f();
    }

    @Override
    public void a(d[] arrd) {
        if (arrd == null) {
            throw new IllegalArgumentException("Parameter == null");
        }
        if (arrd.length < 2) {
            throw new IllegalArgumentException("Parameter Array Size < 2");
        }
        if (!this.b) {
            throw new RuntimeException("Cursor is not valid");
        }
        arrd[0] = this.a.a();
        this.a.b();
        arrd[1] = this.a.a();
        this.a.c();
    }

    @Override
    public boolean f() {
        return this.b;
    }

    @Override
    public void g() {
        this.a.g();
        this.b = this.a.f();
    }

    @Override
    public void h() {
        this.a.h();
        this.b = this.a.f();
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
        d[] arrd = new d[2];
        this.a(arrd);
        return arrd;
    }

    @Override
    public int k() {
        return this.a.k();
    }
}

