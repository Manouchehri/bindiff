/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.c;

import y.f.f.c.g;

class d {
    private double a;
    private int b;
    private g c;

    public d(double d2, int n2, g g2) {
        this.c = g2;
        this.a = d2;
        this.b = n2;
    }

    public double a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public g c() {
        return this.c;
    }

    public String toString() {
        if (this.b == 0) {
            return new StringBuffer().append("S: ").append(this.a).append(" ").append(this.c).toString();
        }
        if (this.b != 1) return null;
        return new StringBuffer().append("E: ").append(this.a).append(" ").append(this.c).toString();
    }
}

