/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import java.awt.Insets;
import java.io.Serializable;

public final class r
implements Serializable {
    public final double a;
    public final double b;
    public final double c;
    public final double d;

    public r(double d2, double d3, double d4, double d5) {
        this.a = d2;
        this.b = d3;
        this.c = d4;
        this.d = d5;
    }

    public r(Insets insets) {
        this(insets.top, insets.left, insets.bottom, insets.right);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        r r2 = (r)object;
        if (r.a(r2.c, this.c) != 0) {
            return false;
        }
        if (r.a(r2.b, this.b) != 0) {
            return false;
        }
        if (r.a(r2.d, this.d) != 0) {
            return false;
        }
        if (r.a(r2.a, this.a) == 0) return true;
        return false;
    }

    public int hashCode() {
        long l2 = this.a != 0.0 ? Double.doubleToLongBits(this.a) : 0;
        int n2 = (int)(l2 ^ l2 >>> 32);
        l2 = this.b != 0.0 ? Double.doubleToLongBits(this.b) : 0;
        n2 = 31 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = this.c != 0.0 ? Double.doubleToLongBits(this.c) : 0;
        n2 = 31 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = this.d != 0.0 ? Double.doubleToLongBits(this.d) : 0;
        return 31 * n2 + (int)(l2 ^ l2 >>> 32);
    }

    public String toString() {
        return new StringBuffer().append(this.getClass().getName()).append("[top=").append(this.a).append(";left=").append(this.b).append(";bottom=").append(this.c).append(";right=").append(this.d).append("]").toString();
    }

    static int a(double d2, double d3) {
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

    public static r a(Object object) {
        if (object instanceof r) {
            return (r)object;
        }
        if (!(object instanceof Insets)) return null;
        return new r((Insets)object);
    }
}

