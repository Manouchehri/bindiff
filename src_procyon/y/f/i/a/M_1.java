package y.f.i.a;

public class M
{
    private final double a;
    private final double b;
    
    public M(final double n, final double n2) {
        this.a = Math.min(n, n2);
        this.b = Math.max(n, n2);
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
    
    public boolean a(final double n) {
        return n >= this.a && n <= this.b;
    }
    
    public double d() {
        return this.b - this.a;
    }
    
    public boolean a(final M m) {
        return this.a(m, 0.0);
    }
    
    public boolean a(final M m, final double n) {
        return this.a + n <= m.b && this.b - n >= m.a;
    }
    
    public double b(final double n) {
        if (n < this.a) {
            return this.a - n;
        }
        if (n > this.b) {
            return n - this.b;
        }
        return 0.0;
    }
    
    public double b(final M m) {
        if (this.b < m.a) {
            return m.a - this.b;
        }
        if (this.a > m.b) {
            return this.a - m.b;
        }
        return 0.0;
    }
    
    public boolean c(final M m) {
        return this.b(m, 1.0E-6);
    }
    
    public boolean b(final M m, final double n) {
        return m.a - n < this.a && m.b + n > this.b;
    }
    
    public double c(final double n) {
        if (n < this.a) {
            return this.a;
        }
        if (n > this.b) {
            return this.b;
        }
        return n;
    }
    
    public String toString() {
        return "[" + this.a + ", " + this.b + "]";
    }
    
    public boolean d(final M m) {
        return this.c(m, 1.0E-6);
    }
    
    public boolean c(final M m, final double n) {
        return Math.abs(this.a - m.a) < n && Math.abs(this.b - m.b) < n;
    }
    
    public static M a(final M m, final M i) {
        if (!m.a(i)) {
            return null;
        }
        return new M(Math.max(m.a, i.a), Math.min(m.b, i.b));
    }
    
    public static M b(final M m, final M i) {
        return new M(Math.min(m.a, i.a), Math.max(m.b, i.b));
    }
    
    public static M d(final M m, final double n) {
        return new M(Math.min(m.a, n), Math.max(m.b, n));
    }
    
    public static M c(final M m, final M i) {
        final double min = Math.min(m.b, i.b);
        final double max = Math.max(m.a, i.a);
        if (min > max) {
            return null;
        }
        return new M(min, max);
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final M m = (M)o;
        return a(m.b, this.b) == 0 && a(m.a, this.a) == 0;
    }
    
    public int hashCode() {
        final long n = (this.a != 0.0) ? Double.doubleToLongBits(this.a) : 0L;
        final int n2 = (int)(n ^ n >>> 32);
        final long n3 = (this.b != 0.0) ? Double.doubleToLongBits(this.b) : 0L;
        return 31 * n2 + (int)(n3 ^ n3 >>> 32);
    }
    
    private static int a(final double n, final double n2) {
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
}
