/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.f.e.a.a;
import y.f.e.a.k;

public final class Z
implements a {
    private double a;
    private double b;
    private double c;

    @Override
    public void a() {
        this.a = 0.0;
        this.b = 0.0;
        this.c = 0.0;
    }

    @Override
    public double c() {
        return Math.sqrt(this.a * this.a + this.b * this.b + this.c * this.c);
    }

    @Override
    public a a(k k2, a a2) {
        a2.a(this.a - k2.d());
        a2.b(this.b - k2.e());
        a2.c(this.c - k2.f());
        return a2;
    }

    @Override
    public void a(k k2) {
        if (k2 == null) {
            return;
        }
        this.a += k2.d();
        this.b += k2.e();
        this.c += k2.f();
    }

    @Override
    public void a(double d2, double d3, double d4) {
        this.a += d2;
        this.b += d3;
        this.c += d4;
    }

    @Override
    public void d(double d2) {
        this.a *= d2;
        this.b *= d2;
        this.c *= d2;
    }

    @Override
    public boolean g() {
        if (this.a != 0.0) return false;
        if (this.b != 0.0) return false;
        if (this.c != 0.0) return false;
        return true;
    }

    @Override
    public void b() {
        this.e(1.0);
    }

    public void e(double d2) {
        double d3 = this.c();
        if (d3 == 0.0) {
            return;
        }
        double d4 = d2 / d3;
        this.a *= d4;
        this.b *= d4;
        this.c *= d4;
    }

    @Override
    public double d() {
        return this.a;
    }

    @Override
    public void a(double d2) {
        this.a = d2;
    }

    @Override
    public double e() {
        return this.b;
    }

    @Override
    public void b(double d2) {
        this.b = d2;
    }

    @Override
    public double f() {
        return this.c;
    }

    @Override
    public void c(double d2) {
        this.c = d2;
    }

    @Override
    public void b(double d2, double d3, double d4) {
        this.a(d2);
        this.b(d3);
        this.c(d4);
    }

    public String toString() {
        return new StringBuffer().append("Point3F{x=").append(this.a).append(", y=").append(this.b).append(", z=").append(this.c).append('}').toString();
    }
}

