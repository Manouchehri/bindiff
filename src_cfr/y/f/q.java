/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.d.n;
import y.d.o;
import y.d.q;
import y.d.t;
import y.d.y;
import y.f.R;
import y.f.X;

public class Q
implements o {
    private n a;
    private Object b;
    private R c;
    private boolean d = false;
    private double e = 0.0;
    private double f = 0.0;
    private double g = 0.0;
    private boolean h = false;

    public Q(t t2, q q2, Object object, R r2, boolean bl2) {
        this.a = new n(t2.a, t2.b + q2.b, q2.a, q2.b);
        this.b = object;
        this.c = r2;
        this.h = bl2;
    }

    public Q(n n2, Object object, R r2, boolean bl2) {
        this.a = n2;
        this.b = object;
        this.c = r2;
        this.h = bl2;
    }

    public Q(n n2, Object object, R r2) {
        this(n2, object, r2, false);
    }

    public double a() {
        return this.g;
    }

    public void a(double d2) {
        if (d2 < 0.0) throw new IllegalArgumentException("Value does not lie in interval [0,1]");
        if (d2 > 1.0) {
            throw new IllegalArgumentException("Value does not lie in interval [0,1]");
        }
        this.g = d2;
    }

    public Object b() {
        return this.b;
    }

    public t c() {
        y y2 = Q.a(this.a);
        if (y2 == null) return this.a.h().e();
        return y2.e();
    }

    @Override
    public y h() {
        y y2 = Q.a(this.a);
        if (y2 == null) return this.a.h();
        return y2;
    }

    public n d() {
        return this.a;
    }

    private static y a(n n2) {
        double d2;
        double d3;
        double d4;
        double d5;
        boolean bl2 = X.j;
        if (n2.g() == 0.0 && n2.i() == -1.0) {
            d3 = n2.b();
            d5 = n2.c() - n2.f();
            d4 = n2.f();
            d2 = n2.e();
            if (!bl2) return new y(d3, d5, d2, d4);
        }
        if (n2.g() == 0.0 && n2.i() == 1.0) {
            d3 = n2.b() - n2.e();
            d5 = n2.c();
            d4 = n2.f();
            d2 = n2.e();
            if (!bl2) return new y(d3, d5, d2, d4);
        }
        if (n2.g() == 1.0 && n2.i() == 0.0) {
            d3 = n2.b();
            d5 = n2.c();
            d4 = n2.e();
            d2 = n2.f();
            if (!bl2) return new y(d3, d5, d2, d4);
        }
        if (n2.g() != -1.0) return null;
        if (n2.i() != 0.0) return null;
        d3 = n2.b() - n2.e();
        d5 = n2.c() - n2.f();
        d4 = n2.e();
        d2 = n2.f();
        if (!bl2) return new y(d3, d5, d2, d4);
        return null;
    }

    public R e() {
        return this.c;
    }

    public boolean f() {
        return this.h;
    }

    public void g() {
        this.c.setModelParameter(this.b);
        this.d = true;
    }

    public void b(double d2) {
        this.e = d2;
    }

    public void c(double d2) {
        this.f = d2;
    }

    public double i() {
        return this.e;
    }

    public double j() {
        return this.f;
    }

    public double k() {
        return this.e + this.f;
    }

    public Object l() {
        return this.b;
    }

    public String toString() {
        return new StringBuffer().append("Label: ").append(this.c.toString()).append(" Location: ").append(this.c().toString()).toString();
    }
}

