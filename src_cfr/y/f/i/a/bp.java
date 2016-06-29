/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.c.c;
import y.c.d;
import y.f.X;
import y.f.i.a.Z;
import y.f.i.a.ad;
import y.f.i.a.bF;
import y.f.i.a.x;
import y.f.i.a.y;

class bP
extends x {
    private final x a;
    private final boolean b;
    private final Object c;
    private final bF d;

    bP(bF bF2, x x2, d d2, boolean bl2) {
        this.d = bF2;
        this.a = x2;
        this.b = bl2;
        c c2 = bF2.a().a().c(y.a);
        this.c = c2.b(d2);
    }

    @Override
    public double a() {
        Double d2 = (Double)bF.h(this.d).get(this.c);
        return d2;
    }

    @Override
    public double b() {
        if (!this.b) return this.a.b();
        return this.a.a();
    }

    @Override
    public double c() {
        return this.a.c();
    }

    @Override
    public double d() {
        return this.a.d();
    }

    @Override
    public byte e() {
        return this.a.e();
    }

    @Override
    public ad f() {
        return this.a.f();
    }

    @Override
    public void a(double d2) {
        this.a.a(d2);
    }

    @Override
    public void a(byte by2) {
        this.a.a(by2);
    }

    @Override
    public void a(ad ad2) {
        this.a.a(ad2);
    }
}

