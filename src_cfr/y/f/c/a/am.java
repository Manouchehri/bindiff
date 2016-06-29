/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.d;
import y.c.p;
import y.c.q;
import y.d.c;
import y.f.am;
import y.f.c.a.Z;
import y.f.c.a.aQ;
import y.f.c.a.aY;
import y.f.c.a.as;
import y.f.c.a.bK;

abstract class aM
implements as {
    aQ f;
    int g;
    final aY h;
    bK i;
    q j;

    aM(aY aY2, bK bK2) {
        this.h = aY2;
        this.i = bK2;
    }

    @Override
    public Z c() {
        return Z.a;
    }

    @Override
    public final bK h() {
        return this.i;
    }

    @Override
    public final aY i() {
        return this.h;
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
        return this.f.c();
    }

    @Override
    public int k() {
        return this.g;
    }

    @Override
    public void a(aQ aQ2) {
        this.f = aQ2;
    }

    @Override
    public void b(int n2) {
        this.g = n2;
    }

    @Override
    public Object a() {
        return null;
    }

    @Override
    public q l() {
        return this.j;
    }

    @Override
    public void a(q q2) {
        this.j = q2;
    }

    @Override
    public p d() {
        return null;
    }

    @Override
    public p a(d d2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void a(p p2) {
        throw new UnsupportedOperationException();
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

    @Override
    public void a(bK bK2) {
        this.i = bK2;
    }
}

