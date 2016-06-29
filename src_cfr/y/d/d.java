/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import y.c.p;

public class d {
    p a;
    double b;
    double c;
    double d;

    d(double d2, double d3, double d4) {
        this.c = d2;
        this.b = d3;
        this.d = d4;
    }

    static d a(double d2, double d3, double d4) {
        return new d(d2, d3, d4);
    }

    public double a(double d2) {
        if (d2 == this.c) return this.b;
        if (this.d == 0.0) {
            return this.b;
        }
        double d3 = d2 - this.c;
        return this.b + d3 * this.d;
    }

    public double a() {
        p p2 = this.a.a();
        if (p2 != null) return ((d)p2.c()).c;
        return Double.MAX_VALUE;
    }

    public final d b() {
        if (this.a.b() == null) return null;
        return (d)this.a.b().c();
    }

    public String toString() {
        return new StringBuffer().append("Segment [").append(this.c).append(" - ").append(this.a()).append("], value=").append(this.b).append(", slope=").append(this.d).toString();
    }
}

