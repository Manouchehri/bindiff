/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.awt.geom.Rectangle2D;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import y.c.q;
import y.d.r;
import y.h.b.B;
import y.h.b.C;
import y.h.b.c;
import y.h.bu;

final class H
implements C {
    private final Rectangle2D a;
    private final B b;

    H(Rectangle2D rectangle2D, B b2) {
        this.a = rectangle2D;
        this.b = b2;
    }

    @Override
    public double a(Object object) {
        return ((c)object).g();
    }

    @Override
    public double b(Object object) {
        return ((c)object).f();
    }

    @Override
    public r c(Object object) {
        return ((c)object).i();
    }

    @Override
    public int d(Object object) {
        return ((c)object).k();
    }

    @Override
    public Collection e(Object object) {
        return ((c)object).l();
    }

    @Override
    public r a(double d2, double d3) {
        return new r(0.0, d2, 0.0, d3);
    }

    @Override
    public double a(r r2) {
        return r2.a;
    }

    @Override
    public double b(r r2) {
        return r2.c;
    }

    @Override
    public double c(r r2) {
        return r2.b;
    }

    @Override
    public double d(r r2) {
        return r2.d;
    }

    @Override
    public double a() {
        return this.a.getX();
    }

    @Override
    public double b() {
        return this.a.getMaxX();
    }

    @Override
    public double a(bu bu2, q q2) {
        return bu2.j(q2);
    }

    @Override
    public Collection c() {
        return this.b.e;
    }

    @Override
    public r f(Object object) {
        return (r)this.b.f.get(object);
    }
}

