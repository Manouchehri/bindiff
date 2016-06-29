/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.ab;

public final class L {
    private final double a;
    private final double b;
    private final double c;

    public double a() {
        return this.a;
    }

    public double b() {
        return this.b;
    }

    public double c() {
        return this.c;
    }

    boolean a(M m2, boolean bl2) {
        if (m2.a() == -1.7976931348623157E308) return true;
        if (m2.b() == Double.MAX_VALUE) {
            return true;
        }
        int n2 = this.a(m2.a(), bl2);
        double d2 = this.a(n2, bl2);
        if (d2 + this.c > m2.b() + 1.0E-6) return false;
        return true;
    }

    int a(M m2, boolean bl2, int n2) {
        int n3 = ab.a;
        if (m2.a() == -1.7976931348623157E308) return 0;
        if (m2.b() == Double.MAX_VALUE) {
            return 0;
        }
        int n4 = this.a(m2.a(), bl2);
        double d2 = this.a(n4, bl2);
        double d3 = d2 + this.c;
        int n5 = 0;
        do {
            block5 : {
                if (n5 > n2) return -1;
                int n6 = (int)(d3 DCMPG m2.b() + 1.0E-6);
                if (n3 != 0) return n6;
                if (n6 <= 0) {
                    return n5;
                }
                double d4 = (d2 + d3) / 2.0;
                if (d4 < m2.a() - 1.0E-6) {
                    d2 = d4;
                    if (n3 == 0) break block5;
                }
                d3 = d4;
            }
            ++n5;
        } while (n3 == 0);
        return -1;
    }

    boolean a(P p2) {
        boolean bl2;
        if (!p2.a()) {
            bl2 = true;
            return this.a(p2.e(), bl2);
        }
        bl2 = false;
        return this.a(p2.e(), bl2);
    }

    double a(int n2, boolean bl2) {
        double d2;
        if (bl2) {
            d2 = this.a;
            return (double)n2 * this.c + d2;
        }
        d2 = this.b;
        return (double)n2 * this.c + d2;
    }

    int a(double d2, boolean bl2) {
        double d3 = bl2 ? this.a : this.b;
        double d4 = (d2 - d3) / this.c - 1.0E-6;
        double d5 = Math.floor(d4);
        double d6 = this.a((int)d5, bl2);
        if (d6 < d2) return (int)d5;
        return (int)(d5 - 1.0);
    }

    int b(double d2, boolean bl2) {
        double d3 = bl2 ? this.a : this.b;
        double d4 = (d2 - d3) / this.c + 1.0E-6;
        double d5 = Math.ceil(d4);
        double d6 = this.a((int)d5, bl2);
        if (d6 > d2) return (int)d5;
        return (int)(d5 + 1.0);
    }

    M b(M m2, boolean bl2) {
        int n2 = this.a(m2.a(), bl2) + 1;
        int n3 = this.b(m2.b(), bl2) - 1;
        if (n3 < n2) return null;
        return new M(this.a(n2, bl2), this.a(n3, bl2));
    }

    double a(double d2, M m2, boolean bl2) {
        return this.a(d2, m2, bl2, 0);
    }

    double a(double d2, M m2, boolean bl2, int n2) {
        double d3;
        double d4;
        int n3;
        double d5;
        block4 : {
            int n4 = ab.a;
            if (this.a(m2, bl2, n2) < 0) return Double.POSITIVE_INFINITY;
            double d6 = m2.c(d2);
            int n5 = this.a(d6, bl2);
            d5 = this.a(n5, bl2);
            d3 = d5 + this.c;
            for (n3 = 0; n3 < n2; ++n3) {
                double d7 = (d5 + d3) / 2.0;
                d4 = d7 DCMPL d6;
                if (n4 == 0) {
                    if (d4 >= 0) {
                        d3 = d7;
                        if (n4 == 0) continue;
                    }
                    d5 = d7;
                    if (n4 == 0) continue;
                }
                break block4;
            }
            d4 = Math.abs(d5 - d2) DCMPG Math.abs(d3 - d2);
        }
        int n6 = n3 = d4 <= 0 ? 1 : 0;
        if (n3 != 0) {
            if (m2.b(d5) < 1.0E-6) return d5;
        }
        if (m2.b(d3) <= 1.0E-6) return d3;
        return d5;
    }

    double a(double d2, P p2) {
        boolean bl2;
        if (!p2.a()) {
            bl2 = true;
            return this.a(d2, p2.e(), bl2);
        }
        bl2 = false;
        return this.a(d2, p2.e(), bl2);
    }

    public String toString() {
        return new StringBuffer().append("Grid[(").append(this.a).append(";").append(this.b).append("); ").append(this.c).append("]").toString();
    }

    double b(double d2, P p2) {
        double d3 = this.a(d2, p2);
        if (d3 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        double d4 = Math.abs(d2 - d3);
        return d4;
    }
}

