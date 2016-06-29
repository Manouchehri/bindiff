/*
 * Decompiled with CFR 0_115.
 */
package y.b;

import y.b.n;

class o
implements n {
    private final double a;
    private final double b;
    private final double c;

    o(double d2, double d3) {
        this.a = 2.0 / (1.0 - d2 + d3);
        this.b = d2;
        this.c = d3;
    }

    @Override
    public double a(double d2) {
        if (0.0 >= d2) {
            return 0.0;
        }
        if (1.0 <= d2) {
            return 1.0;
        }
        if (this.b > d2) {
            return this.a / (2.0 * this.b) * d2 * d2;
        }
        if (this.c >= d2) return this.a * (d2 - this.b / 2.0);
        double d3 = 1.0 - d2;
        return 1.0 - this.a / (2.0 - 2.0 * this.c) * d3 * d3;
    }
}

