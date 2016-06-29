package y.d;

public final class t implements Comparable
{
    public final double a;
    public final double b;
    public static final t c;
    public static boolean d;
    
    public t() {
        this.a = 0.0;
        this.b = 0.0;
    }
    
    public t(final double a, final double b) {
        this.a = a;
        this.b = b;
    }
    
    public final double a() {
        return this.a;
    }
    
    public final double b() {
        return this.b;
    }
    
    public double a(double n, double n2) {
        n -= this.a;
        n2 -= this.b;
        return Math.sqrt(n * n + n2 * n2);
    }
    
    public double a(final t t) {
        final double n = this.a - t.a;
        final double n2 = this.b - t.b;
        return Math.sqrt(n * n + n2 * n2);
    }
    
    public static double a(final t t, final t t2) {
        return Math.sqrt((t.a - t2.a) * (t.a - t2.a) + (t.b - t2.b) * (t.b - t2.b));
    }
    
    public static double a(double n, double n2, final double n3, final double n4) {
        n -= n3;
        n2 -= n4;
        return Math.sqrt(n * n + n2 * n2);
    }
    
    public static t b(final t t, final t t2) {
        return new t(t.a + t2.a, t.b + t2.b);
    }
    
    public static t c(final t t, final t t2) {
        return new t((t.a + t2.a) / 2.0, (t.b + t2.b) / 2.0);
    }
    
    public static t b(final t t) {
        return new t(t.b, t.a);
    }
    
    public t b(final double n, final double n2) {
        return new t(this.a + n, this.b + n2);
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof t)) {
            return false;
        }
        final t t = (t)o;
        return t.a == this.a && t.b == this.b;
    }
    
    public int hashCode() {
        final long n = Double.doubleToLongBits(this.a) << 1 ^ Double.doubleToLongBits(this.b);
        return (int)(n >> 32 ^ n);
    }
    
    public String toString() {
        return "X: " + this.a + " Y: " + this.b;
    }
    
    public int compareTo(final Object o) {
        if (this == o) {
            return 0;
        }
        final t t = (t)o;
        if (this.a < t.a) {
            return -1;
        }
        if (this.a > t.a) {
            return 1;
        }
        if (this.b < t.b) {
            return -1;
        }
        if (this.b > t.b) {
            return 1;
        }
        return 0;
    }
    
    static {
        c = new t(0.0, 0.0);
    }
}
