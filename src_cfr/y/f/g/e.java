/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import y.c.d;
import y.c.p;
import y.c.q;
import y.d.c;
import y.f.am;
import y.f.c.a.Z;
import y.f.c.a.aQ;
import y.f.c.a.aY;
import y.f.c.a.bK;
import y.f.g.C;

abstract class E
implements C {
    aQ d;
    int e;
    final aY f;
    bK g;
    q h;

    E(aY aY2, bK bK2) {
        this.f = aY2;
        this.g = bK2;
    }

    @Override
    public Z c() {
        return Z.a;
    }

    @Override
    public final bK h() {
        return this.g;
    }

    @Override
    public final aY i() {
        return this.f;
    }

    @Override
    public d g() {
        throw new UnsupportedOperationException();
    }

    @Override
    public q f() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int j() {
        return this.d.c();
    }

    @Override
    public int k() {
        return this.e;
    }

    @Override
    public void a(aQ aQ2) {
        this.d = aQ2;
    }

    @Override
    public void b(int n2) {
        this.e = n2;
    }

    @Override
    public Object a() {
        return null;
    }

    @Override
    public q l() {
        return this.h;
    }

    @Override
    public p d() {
        return null;
    }

    @Override
    public int e() {
        return 0;
    }

    @Override
    public c a(int n2) {
        return null;
    }

    @Override
    public c a(int n2, am am2) {
        throw new UnsupportedOperationException();
    }
}

