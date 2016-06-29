/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.c.d;
import y.c.e;
import y.h.aB;
import y.h.bu;
import y.h.fj;
import y.h.x;
import y.h.y;

class ie
implements y {
    e a;
    y b;
    x c;
    bu d;

    ie(bu bu2) {
        this.d = bu2;
        this.a = bu2.p();
        this.i();
    }

    @Override
    public Object d() {
        return this.c;
    }

    @Override
    public x a() {
        return this.c;
    }

    @Override
    public void i() {
        boolean bl2 = fj.z;
        this.a.i();
        do {
            if (!this.a.f()) return;
            aB aB2 = this.d.i(this.a.a());
            if (aB2.bendCount() > 0) {
                this.b = aB2.bends();
                this.c = this.b.a();
                return;
            }
            this.c = null;
            this.a.g();
        } while (!bl2);
    }

    @Override
    public void j() {
        boolean bl2 = fj.z;
        this.a.j();
        do {
            if (!this.a.f()) return;
            aB aB2 = this.d.i(this.a.a());
            if (aB2.bendCount() > 0) {
                this.b = aB2.bends();
                this.b.j();
                this.c = this.b.a();
                return;
            }
            this.c = null;
            this.a.h();
        } while (!bl2);
    }

    @Override
    public void g() {
        boolean bl2 = fj.z;
        this.b.g();
        if (this.b.f()) {
            this.c = this.b.a();
            if (!bl2) return;
        }
        this.a.g();
        while (this.a.f()) {
            aB aB2 = this.d.i(this.a.a());
            if (bl2) return;
            if (aB2.bendCount() > 0) {
                this.b = aB2.bends();
                this.c = this.b.a();
                return;
            }
            this.a.g();
            if (!bl2) continue;
        }
        this.c = null;
    }

    @Override
    public void h() {
        boolean bl2 = fj.z;
        this.b.h();
        if (this.b.f()) {
            this.c = this.b.a();
            if (!bl2) return;
        }
        this.a.h();
        while (this.a.f()) {
            aB aB2 = this.d.i(this.a.a());
            if (bl2) return;
            if (aB2.bendCount() > 0) {
                this.b = aB2.bends();
                this.b.j();
                this.c = this.b.a();
                return;
            }
            this.a.h();
            if (!bl2) continue;
        }
        this.c = null;
    }

    @Override
    public boolean f() {
        if (this.c == null) return false;
        return true;
    }

    @Override
    public int k() {
        throw new UnsupportedOperationException();
    }
}

