/*
 * Decompiled with CFR 0_115.
 */
package y.d;

public class q
implements Comparable {
    public final double a;
    public final double b;

    public q(double d2, double d3) {
        this.a = d2;
        this.b = d3;
    }

    public final double a() {
        return this.a;
    }

    public final double b() {
        return this.b;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof q)) {
            return false;
        }
        q q2 = (q)object;
        if (q2.a != this.a) return false;
        if (q2.b != this.b) return false;
        return true;
    }

    public int hashCode() {
        long l2 = Double.doubleToLongBits(this.a) << 1 ^ Double.doubleToLongBits(this.b);
        return (int)(l2 ^ l2 >> 32);
    }

    public String toString() {
        return new StringBuffer().append("W: ").append(this.a).append(" H: ").append(this.b).toString();
    }

    public int compareTo(Object object) {
        q q2 = (q)object;
        if (this.equals(q2)) {
            return 0;
        }
        if (q2.a > this.a) {
            return -1;
        }
        if (q2.a < this.a) {
            return 1;
        }
        if (q2.b > this.b) {
            return -1;
        }
        if (q2.b >= this.b) return 0;
        return 1;
    }
}

