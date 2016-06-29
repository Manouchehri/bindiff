/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.h.fC;
import y.h.fj;

final class fB {
    final fC a;
    final double b;
    final double c;
    private double d;
    private boolean e;

    fB(fC fC2, double d2, double d3) {
        this.a = fC2;
        this.b = d2;
        this.d = d3;
        this.c = d3 - d2;
    }

    double a() {
        return this.d;
    }

    double a(double d2) {
        if (d2 >= 0.0 || this.c <= 0.0) {
            if (d2 <= 0.0) return this.b + d2;
            if (this.c >= 0.0) return this.b + d2;
        }
        double d3 = this.b;
        if (!fj.z) return d3;
        return this.b + d2;
    }

    void b(double d2) {
        double d3 = this.a(d2);
        if (this.e) {
            if (this.d == d3) return;
            this.a.b();
            if (!fj.z) return;
        }
        this.d = d3;
        this.e = true;
    }
}

