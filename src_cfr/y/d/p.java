/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import y.c.i;
import y.d.t;

public class p
implements Comparable {
    public final t a;
    public final double b;

    public p(t t2, t t3, t t4) {
        boolean bl2 = t.d;
        double d2 = t2.a();
        double d3 = t2.b();
        double d4 = t3.a();
        double d5 = t3.b();
        double d6 = t4.a();
        double d7 = t4.b();
        double d8 = (d2 * d2 + d3 * d3) * (d5 - d7) + (d4 * d4 + d5 * d5) * (d7 - d3) + (d6 * d6 + d7 * d7) * (d3 - d5);
        double d9 = (- d2 * d2 + d3 * d3) * (d4 - d6) - (d4 * d4 + d5 * d5) * (d6 - d2) - (d6 * d6 + d7 * d7) * (d2 - d4);
        double d10 = 2.0 * ((d4 - d2) * (d7 - d3) - (d6 - d2) * (d5 - d3));
        if (d10 == 0.0) {
            throw new IllegalArgumentException("Points are collinear");
        }
        this.a = new t(d8 / d10, d9 / d10);
        this.b = t.a(this.a, t2);
        if (!bl2) return;
        i.g = !i.g;
    }

    public p(t t2, double d2) {
        this.a = t2;
        this.b = d2;
    }

    public t a() {
        return this.a;
    }

    public final double b() {
        return this.b;
    }

    public t[] a(double d2) {
        t[] arrt;
        double d3;
        double d4 = -2.0 * this.a.a();
        double d5 = d4 * d4 / 4.0 - (d3 = this.a.a() * this.a.a() + d2 * d2 - 2.0 * this.a.b() * d2 + this.a.b() * this.a.b() - this.b * this.b);
        if (d5 < 0.0) {
            return null;
        }
        if (d5 == 0.0) {
            arrt = new t[]{new t((- d4) / 2.0, d2)};
            if (!t.d) return arrt;
        }
        arrt = new t[2];
        d5 = Math.sqrt(d5);
        arrt[0] = new t((- d4) / 2.0 - d5, d2);
        arrt[1] = new t((- d4) / 2.0 + d5, d2);
        return arrt;
    }

    public t[] b(double d2) {
        t[] arrt;
        double d3;
        double d4 = -2.0 * this.a.b();
        double d5 = d4 * d4 / 4.0 - (d3 = this.a.b() * this.a.b() + d2 * d2 - 2.0 * this.a.a() * d2 + this.a.a() * this.a.a() - this.b * this.b);
        if (d5 < 0.0) {
            return null;
        }
        if (d5 == 0.0) {
            arrt = new t[]{new t(d2, (- d4) / 2.0)};
            if (!t.d) return arrt;
        }
        arrt = new t[2];
        d5 = Math.sqrt(d5);
        arrt[0] = new t(d2, (- d4) / 2.0 - d5);
        arrt[1] = new t(d2, (- d4) / 2.0 + d5);
        return arrt;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof p)) {
            return false;
        }
        p p2 = (p)object;
        if (p2.b != this.b) return false;
        if (!p2.a.equals(this.a)) return false;
        return true;
    }

    public int hashCode() {
        return this.a.hashCode() ^ (int)Double.doubleToLongBits(this.b);
    }

    public int compareTo(Object object) {
        p p2 = (p)object;
        if (this.a.a < p2.a.a) {
            return -1;
        }
        if (this.a.a > p2.a.a) {
            return 1;
        }
        if (this.a.b < p2.a.b) {
            return -1;
        }
        if (this.a.b > p2.a.b) {
            return 1;
        }
        if (this.b > p2.b) {
            return 1;
        }
        if (this.b >= p2.b) return 0;
        return -1;
    }
}

