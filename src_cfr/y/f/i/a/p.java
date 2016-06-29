/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.d.y;
import y.f.i.a.M;

public class P {
    private final M a;
    private final double b;
    private final boolean c;

    P(double d2, double d3, double d4, double d5) {
        if (Math.abs(d3 - d5) < 1.0E-6 && Math.abs(d2 - d4) < 1.0E-6) {
            throw new IllegalStateException("Not able to calculate the orientation.");
        }
        this.c = Math.abs(d2 - d4) < 1.0E-6;
        this.a = this.c ? new M(d3, d5) : new M(d2, d4);
        this.b = this.c ? d2 : d3;
    }

    public P(double d2, double d3, double d4, boolean bl2) {
        this(new M(d2, d3), d4, bl2);
    }

    public P(M m2, double d2, boolean bl2) {
        if (m2 == null) {
            throw new IllegalArgumentException("range must not be null");
        }
        this.a = m2;
        this.b = d2;
        this.c = bl2;
    }

    public boolean a() {
        return this.c;
    }

    public double b() {
        return this.a.a();
    }

    public double c() {
        return this.a.b();
    }

    public double d() {
        return this.a.b() - this.a.a();
    }

    public M e() {
        return this.a;
    }

    public double f() {
        return this.b;
    }

    public double a(P p2) {
        if (this.c == p2.c) return this.e().b(p2.e()) + Math.abs(this.f() - p2.f());
        return this.e().b(p2.f()) + p2.e().b(this.f());
    }

    public boolean b(P p2) {
        return this.a(p2, 0.0);
    }

    public boolean a(P p2, double d2) {
        if (this.c == p2.c) return this.a.a(p2.a, d2);
        throw new IllegalArgumentException("orthogonal intervals have different orientation");
    }

    public boolean c(P p2) {
        if (this.c == p2.c) return this.a.c(p2.a);
        throw new IllegalArgumentException("orthogonal intervals have different orientation");
    }

    public boolean d(P p2) {
        if (this.c == p2.c) return this.a.d(p2.a);
        throw new IllegalArgumentException("orthogonal intervals have different orientation");
    }

    public static P a(P p2, P p3) {
        if (p2.c != p3.c) {
            throw new IllegalArgumentException("orthogonal intervals have different orientation");
        }
        M m2 = M.a(p2.a, p3.a);
        if (m2 == null) return null;
        return new P(m2.a(), m2.b(), p3.b, p3.a());
    }

    public String toString() {
        return new StringBuffer().append("OrthogonalInterval{range=").append(this.a).append(", location=").append(this.b).append(", isVertical=").append(this.c).append('}').toString();
    }

    private double g() {
        double d2;
        if (this.c) {
            d2 = this.c();
            return d2;
        }
        d2 = this.b;
        return d2;
    }

    private double h() {
        double d2;
        if (this.c) {
            d2 = this.b;
            return d2;
        }
        d2 = this.c();
        return d2;
    }

    private double i() {
        double d2;
        if (this.c) {
            d2 = this.b();
            return d2;
        }
        d2 = this.b;
        return d2;
    }

    private double j() {
        double d2;
        if (this.c) {
            d2 = this.b;
            return d2;
        }
        d2 = this.b();
        return d2;
    }

    static boolean a(y y2, P p2) {
        double d2 = p2.j();
        double d3 = p2.i();
        double d4 = p2.h();
        double d5 = p2.g();
        if (y2.a(d2, d3)) return true;
        if (y2.a(d4, d5)) return true;
        return false;
    }
}

