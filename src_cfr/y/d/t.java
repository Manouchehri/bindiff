/*
 * Decompiled with CFR 0_115.
 */
package y.d;

public final class t
implements Comparable {
    public final double a;
    public final double b;
    public static final t c = new t(0.0, 0.0);
    public static boolean d;

    public t() {
        this.a = 0.0;
        this.b = 0.0;
    }

    public t(double d2, double d3) {
        this.a = d2;
        this.b = d3;
    }

    public final double a() {
        return this.a;
    }

    public final double b() {
        return this.b;
    }

    public double a(double d2, double d3) {
        return Math.sqrt(d2 * (d2 -= this.a) + d3 * (d3 -= this.b));
    }

    public double a(t t2) {
        double d2 = this.a - t2.a;
        double d3 = this.b - t2.b;
        return Math.sqrt(d2 * d2 + d3 * d3);
    }

    public static double a(t t2, t t3) {
        return Math.sqrt((t2.a - t3.a) * (t2.a - t3.a) + (t2.b - t3.b) * (t2.b - t3.b));
    }

    public static double a(double d2, double d3, double d4, double d5) {
        return Math.sqrt(d2 * (d2 -= d4) + d3 * (d3 -= d5));
    }

    public static t b(t t2, t t3) {
        return new t(t2.a + t3.a, t2.b + t3.b);
    }

    public static t c(t t2, t t3) {
        return new t((t2.a + t3.a) / 2.0, (t2.b + t3.b) / 2.0);
    }

    public static t b(t t2) {
        return new t(t2.b, t2.a);
    }

    public t b(double d2, double d3) {
        return new t(this.a + d2, this.b + d3);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof t)) {
            return false;
        }
        t t2 = (t)object;
        if (t2.a != this.a) return false;
        if (t2.b != this.b) return false;
        return true;
    }

    public int hashCode() {
        long l2 = Double.doubleToLongBits(this.a) << 1 ^ Double.doubleToLongBits(this.b);
        return (int)(l2 >> 32 ^ l2);
    }

    public String toString() {
        return new StringBuffer().append("X: ").append(this.a).append(" Y: ").append(this.b).toString();
    }

    public int compareTo(Object object) {
        if (this == object) {
            return 0;
        }
        t t2 = (t)object;
        if (this.a < t2.a) {
            return -1;
        }
        if (this.a > t2.a) {
            return 1;
        }
        if (this.b < t2.b) {
            return -1;
        }
        if (this.b <= t2.b) return 0;
        return 1;
    }
}

