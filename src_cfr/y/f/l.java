/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.d.e;

public class L {
    double a;
    double b;
    double c;

    public L() {
        this(50.0, 0.0, 0.0);
    }

    public L(double d2, double d3, double d4) {
        this.a = d2;
        this.b = d3;
        this.c = d4;
    }

    public double a() {
        return this.c;
    }

    public String toString() {
        return new StringBuffer().append(this.getClass()).append(" radius=").append(this.a).append("  theta(deg)=").append(e.b(this.b)).toString();
    }
}

