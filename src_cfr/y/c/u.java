/*
 * Decompiled with CFR 0_115.
 */
package y.c;

import y.c.D;
import y.c.d;
import y.c.e;
import y.c.q;

class u
implements e {
    boolean a;
    d b;
    private final q c;

    u(q q2) {
        this.c = q2;
        this.i();
    }

    @Override
    public void g() {
        if (!this.a) {
            this.b = this.b.a;
            if (this.b != null) return;
            this.b = this.c.b;
            this.a = true;
            if (!D.e) return;
        }
        this.b = this.b.b;
    }

    @Override
    public void h() {
        if (this.a) {
            this.b = this.b.d;
            if (this.b != null) return;
            this.b = this.c.d;
            this.a = false;
            if (!D.e) return;
        }
        this.b = this.b.c;
    }

    @Override
    public void i() {
        this.b = this.c.c;
        if (this.b == null) {
            this.b = this.c.b;
            this.a = true;
            if (!D.e) return;
        }
        this.a = false;
    }

    @Override
    public void j() {
        this.b = this.c.e;
        if (this.b == null) {
            this.b = this.c.d;
            this.a = false;
            if (!D.e) return;
        }
        this.a = true;
    }

    @Override
    public boolean f() {
        if (this.b == null) return false;
        return true;
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

    @Override
    public Object d() {
        return this.b;
    }

    @Override
    public d a() {
        return this.b;
    }

    @Override
    public int k() {
        return this.c.a();
    }
}

