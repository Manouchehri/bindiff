package y.d;

import y.c.*;

public class p implements Comparable
{
    public final t a;
    public final double b;
    
    public p(final t t, final t t2, final t t3) {
        final boolean d = t.d;
        final double a = t.a();
        final double b = t.b();
        final double a2 = t2.a();
        final double b2 = t2.b();
        final double a3 = t3.a();
        final double b3 = t3.b();
        final double n = (a * a + b * b) * (b2 - b3) + (a2 * a2 + b2 * b2) * (b3 - b) + (a3 * a3 + b3 * b3) * (b - b2);
        final double n2 = -(a * a + b * b) * (a2 - a3) - (a2 * a2 + b2 * b2) * (a3 - a) - (a3 * a3 + b3 * b3) * (a - a2);
        final double n3 = 2.0 * ((a2 - a) * (b3 - b) - (a3 - a) * (b2 - b));
        if (n3 == 0.0) {
            throw new IllegalArgumentException("Points are collinear");
        }
        this.a = new t(n / n3, n2 / n3);
        this.b = t.a(this.a, t);
        if (d) {
            i.g = !i.g;
        }
    }
    
    public p(final t a, final double b) {
        this.a = a;
        this.b = b;
    }
    
    public t a() {
        return this.a;
    }
    
    public final double b() {
        return this.b;
    }
    
    public t[] a(final double n) {
        final double n2 = -2.0 * this.a.a();
        final double n3 = n2 * n2 / 4.0 - (this.a.a() * this.a.a() + n * n - 2.0 * this.a.b() * n + this.a.b() * this.a.b() - this.b * this.b);
        if (n3 < 0.0) {
            return null;
        }
        if (n3 == 0.0) {
            final t[] array = { new t(-n2 / 2.0, n) };
            if (!t.d) {
                return array;
            }
        }
        final t[] array = new t[2];
        final double sqrt = Math.sqrt(n3);
        array[0] = new t(-n2 / 2.0 - sqrt, n);
        array[1] = new t(-n2 / 2.0 + sqrt, n);
        return array;
    }
    
    public t[] b(final double n) {
        final double n2 = -2.0 * this.a.b();
        final double n3 = n2 * n2 / 4.0 - (this.a.b() * this.a.b() + n * n - 2.0 * this.a.a() * n + this.a.a() * this.a.a() - this.b * this.b);
        if (n3 < 0.0) {
            return null;
        }
        if (n3 == 0.0) {
            final t[] array = { new t(n, -n2 / 2.0) };
            if (!t.d) {
                return array;
            }
        }
        final t[] array = new t[2];
        final double sqrt = Math.sqrt(n3);
        array[0] = new t(n, -n2 / 2.0 - sqrt);
        array[1] = new t(n, -n2 / 2.0 + sqrt);
        return array;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof p)) {
            return false;
        }
        final p p = (p)o;
        return p.b == this.b && p.a.equals(this.a);
    }
    
    public int hashCode() {
        return this.a.hashCode() ^ (int)Double.doubleToLongBits(this.b);
    }
    
    public int compareTo(final Object o) {
        final p p = (p)o;
        if (this.a.a < p.a.a) {
            return -1;
        }
        if (this.a.a > p.a.a) {
            return 1;
        }
        if (this.a.b < p.a.b) {
            return -1;
        }
        if (this.a.b > p.a.b) {
            return 1;
        }
        if (this.b > p.b) {
            return 1;
        }
        if (this.b < p.b) {
            return -1;
        }
        return 0;
    }
}
