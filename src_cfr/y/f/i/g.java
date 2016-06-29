/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.c.d;
import y.f.i.E;
import y.f.i.F;
import y.f.i.J;

class G
extends J {
    private final double b;
    private final double c;
    private final double d;
    private final double e;

    G(double d2, double d3, double d4, double d5) {
        this.b = d2;
        this.c = d3;
        this.d = d4;
        this.e = d5;
    }

    public String toString() {
        return "EdgeObject{}";
    }

    @Override
    F a(boolean bl2, double d2) {
        return new F(bl2, d2, Math.min(this.c, this.e), Math.max(this.c, this.e), this);
    }

    @Override
    double a(d d2, double d3, double d4, double d5, E e2) {
        if (d5 < this.c && d5 < this.e) {
            return 0.0;
        }
        if (d4 > this.c && d4 > this.e) {
            return 0.0;
        }
        double d6 = e2.b();
        if (this.d != this.b) {
            double d7 = (this.e - this.c) / (this.d - this.b);
            double d8 = this.c + d7 * (d3 - this.b);
            if (d8 > d5) return 0.0;
            if (d8 < d4) return 0.0;
            double d9 = d6;
            return d9;
        }
        double d10 = e2.d();
        if (this.e > this.c) {
            if (d4 > this.e) return 0.0;
            if (d5 < this.c) return 0.0;
            double d11 = d10;
            return d11;
        }
        if (d4 > this.c) return 0.0;
        if (d5 < this.e) return 0.0;
        double d12 = d10;
        return d12;
    }
}

