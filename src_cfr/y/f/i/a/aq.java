/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.c.d;
import y.d.m;
import y.d.t;
import y.d.y;
import y.f.i.a.aN;
import y.f.i.a.aT;

class aQ
extends aT {
    private final y g;
    private final double h;
    private final t i;
    private final aN j;

    aQ(aN aN2, m m2, m m3, d d2) {
        super(d2, m2.b() ? m2 : m3, m2.a() ? m2 : m3);
        this.j = aN2;
        this.i = new t(this.b.c().a, this.a.c().b);
        this.h = m2.b() ? Math.abs(this.i.a - m2.d().a) : Math.abs(this.i.b - m2.d().b);
        this.g = this.g();
    }

    private y g() {
        double d2 = this.h + 2.0;
        if (this.c == 3) {
            return new y(this.i.a - this.h - 1.0, this.i.b - 1.0, d2, d2);
        }
        if (this.c == 2) {
            return new y(this.i.a - 1.0, this.i.b - 1.0, d2, d2);
        }
        if (this.c != 0) return new y(this.i.a - this.h - 1.0, this.i.b - this.h - 1.0, d2, d2);
        return new y(this.i.a - 1.0, this.i.b - this.h - 1.0, d2, d2);
    }

    @Override
    public boolean a() {
        return true;
    }

    @Override
    public double b() {
        return this.i.a();
    }

    @Override
    public double c() {
        return this.i.b();
    }

    @Override
    public y h() {
        return this.g;
    }

    @Override
    public void a(double d2) {
        throw new IllegalStateException("Segment offset is fixed!");
    }

    @Override
    public double d() {
        if (this.c == 3) return this.b() - this.h;
        if (this.c != 1) return this.b() + this.h;
        return this.b() - this.h;
    }

    @Override
    public double e() {
        if (this.c == 0) return this.c() - this.h;
        if (this.c != 1) return this.c() + this.h;
        return this.c() - this.h;
    }
}

