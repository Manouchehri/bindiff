/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Collection;
import y.c.d;
import y.f.aE;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.ai;
import y.f.c.a.ak;

class aL
implements ai {
    final d a;
    final A b;

    aL(d d2, A a2) {
        this.a = d2;
        this.b = a2;
    }

    @Override
    public B k() {
        return this.b.k();
    }

    @Override
    public d b() {
        return this.a;
    }

    @Override
    public aE c() {
        return null;
    }

    @Override
    public Collection d() {
        return null;
    }

    @Override
    public Object g() {
        return null;
    }

    @Override
    public aE e() {
        return null;
    }

    @Override
    public Collection f() {
        return null;
    }

    @Override
    public Object h() {
        return null;
    }

    @Override
    public byte a() {
        return 0;
    }

    @Override
    public boolean i() {
        return this.b.i();
    }

    @Override
    public boolean j() {
        return this.l();
    }

    @Override
    public void b(boolean bl2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public A a(boolean bl2, aE aE2) {
        ak ak2;
        block2 : {
            if (this.i()) {
                ak2 = new ak(this.b(), this.k(), bl2 ? null : aE2, this.f(), bl2 ? aE2 : null, this.d());
                ak2.b(true);
                if (!N.x) break block2;
            }
            ak2 = new ak(this.b(), this.k(), bl2 ? aE2 : null, this.d(), bl2 ? null : aE2, this.f());
        }
        ak2.a(this.l());
        return ak2;
    }

    @Override
    public void a(boolean bl2) {
        this.b.a(bl2);
    }

    @Override
    public boolean l() {
        return this.b.l();
    }
}

