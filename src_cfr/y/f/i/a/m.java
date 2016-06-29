/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

public class M {
    private final double a;
    private final double b;

    public M(double d2, double d3) {
        this.a = Math.min(d2, d3);
        this.b = Math.max(d2, d3);
    }

    public double a() {
        return this.a;
    }

    public double b() {
        return this.b;
    }

    public double c() {
        return 0.5 * (this.a + this.b);
    }

    public boolean a(double d2) {
        if (d2 < this.a) return false;
        if (d2 > this.b) return false;
        return true;
    }

    public double d() {
        return this.b - this.a;
    }

    public boolean a(M m2) {
        return this.a(m2, 0.0);
    }

    public boolean a(M m2, double d2) {
        if (this.a + d2 > m2.b) return false;
        if (this.b - d2 < m2.a) return false;
        return true;
    }

    public double b(double d2) {
        if (d2 < this.a) {
            return this.a - d2;
        }
        if (d2 <= this.b) return 0.0;
        return d2 - this.b;
    }

    public double b(M m2) {
        if (this.b < m2.a) {
            return m2.a - this.b;
        }
        if (this.a <= m2.b) return 0.0;
        return this.a - m2.b;
    }

    public boolean c(M m2) {
        return this.b(m2, 1.0E-6);
    }

    public boolean b(M m2, double d2) {
        if (m2.a - d2 >= this.a) return false;
        if (m2.b + d2 <= this.b) return false;
        return true;
    }

    public double c(double d2) {
        if (d2 < this.a) {
            return this.a;
        }
        if (d2 <= this.b) return d2;
        return this.b;
    }

    public String toString() {
        return new StringBuffer().append("[").append(this.a).append(", ").append(this.b).append("]").toString();
    }

    public boolean d(M m2) {
        return this.c(m2, 1.0E-6);
    }

    public boolean c(M m2, double d2) {
        if (Math.abs(this.a - m2.a) >= d2) return false;
        if (Math.abs(this.b - m2.b) >= d2) return false;
        return true;
    }

    public static M a(M m2, M m3) {
        if (m2.a(m3)) return new M(Math.max(m2.a, m3.a), Math.min(m2.b, m3.b));
        return null;
    }

    public static M b(M m2, M m3) {
        return new M(Math.min(m2.a, m3.a), Math.max(m2.b, m3.b));
    }

    public static M d(M m2, double d2) {
        return new M(Math.min(m2.a, d2), Math.max(m2.b, d2));
    }

    public static M c(M m2, M m3) {
        double d2;
        double d3 = Math.min(m2.b, m3.b);
        if (d3 <= (d2 = Math.max(m2.a, m3.a))) return new M(d3, d2);
        return null;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        M m2 = (M)object;
        if (M.a(m2.b, this.b) != 0) {
            return false;
        }
        if (M.a(m2.a, this.a) == 0) return true;
        return false;
    }

    public int hashCode() {
        long l2 = this.a != 0.0 ? Double.doubleToLongBits(this.a) : 0;
        int n2 = (int)(l2 ^ l2 >>> 32);
        l2 = this.b != 0.0 ? Double.doubleToLongBits(this.b) : 0;
        return 31 * n2 + (int)(l2 ^ l2 >>> 32);
    }

    private static int a(double d2, double d3) {
        long l2;
        if (d2 > d3) {
            return 1;
        }
        if (d2 < d3) {
            return -1;
        }
        long l3 = Double.doubleToLongBits(d2);
        if (l3 == (l2 = Double.doubleToLongBits(d3))) {
            return 0;
        }
        if (l3 <= l2) return -1;
        return 1;
    }
}

