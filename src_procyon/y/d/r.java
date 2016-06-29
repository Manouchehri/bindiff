package y.d;

import java.io.*;
import java.awt.*;

public final class r implements Serializable
{
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    
    public r(final double a, final double b, final double c, final double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public r(final Insets insets) {
        this(insets.top, insets.left, insets.bottom, insets.right);
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final r r = (r)o;
        return a(r.c, this.c) == 0 && a(r.b, this.b) == 0 && a(r.d, this.d) == 0 && a(r.a, this.a) == 0;
    }
    
    public int hashCode() {
        final long n = (this.a != 0.0) ? Double.doubleToLongBits(this.a) : 0L;
        final int n2 = (int)(n ^ n >>> 32);
        final long n3 = (this.b != 0.0) ? Double.doubleToLongBits(this.b) : 0L;
        final int n4 = 31 * n2 + (int)(n3 ^ n3 >>> 32);
        final long n5 = (this.c != 0.0) ? Double.doubleToLongBits(this.c) : 0L;
        final int n6 = 31 * n4 + (int)(n5 ^ n5 >>> 32);
        final long n7 = (this.d != 0.0) ? Double.doubleToLongBits(this.d) : 0L;
        return 31 * n6 + (int)(n7 ^ n7 >>> 32);
    }
    
    public String toString() {
        return this.getClass().getName() + "[top=" + this.a + ";left=" + this.b + ";bottom=" + this.c + ";right=" + this.d + "]";
    }
    
    static int a(final double n, final double n2) {
        if (n > n2) {
            return 1;
        }
        if (n < n2) {
            return -1;
        }
        final long doubleToLongBits = Double.doubleToLongBits(n);
        final long doubleToLongBits2 = Double.doubleToLongBits(n2);
        return (doubleToLongBits == doubleToLongBits2) ? 0 : ((doubleToLongBits > doubleToLongBits2) ? 1 : -1);
    }
    
    public static r a(final Object o) {
        if (o instanceof r) {
            return (r)o;
        }
        if (o instanceof Insets) {
            return new r((Insets)o);
        }
        return null;
    }
}
