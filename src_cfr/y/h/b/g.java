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
import y.h.b.f;
import y.h.bu;

final class G
implements C {
    private final Rectangle2D a;
    private final B b;

    G(Rectangle2D rectangle2D, B b2) {
        this.a = rectangle2D;
        this.b = b2;
    }

    @Override
    public double a(Object object) {
        return ((f)object).g();
    }

    @Override
    public double b(Object object) {
        return ((f)object).f();
    }

    @Override
    public r c(Object object) {
        return ((f)object).i();
    }

    @Override
    public int d(Object object) {
        return ((f)object).n();
    }

    @Override
    public Collection e(Object object) {
        return ((f)object).o();
    }

    @Override
    public r a(double d2, double d3) {
        return new r(d2, 0.0, d3, 0.0);
    }

    @Override
    public double a(r r2) {
        return r2.b;
    }

    @Override
    public double b(r r2) {
        return r2.d;
    }

    @Override
    public double c(r r2) {
        return r2.a;
    }

    @Override
    public double d(r r2) {
        return r2.c;
    }

    @Override
    public double a() {
        return this.a.getY();
    }

    @Override
    public double b() {
        return this.a.getMaxY();
    }

    @Override
    public double a(bu bu2, q q2) {
        return bu2.k(q2);
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

