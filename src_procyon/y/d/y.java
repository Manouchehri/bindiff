package y.d;

public class y extends q implements o
{
    public final double c;
    public final double d;
    private t e;
    
    public y() {
        super(0.0, 0.0);
        final double n = 0.0;
        this.d = n;
        this.c = n;
    }
    
    public y(final t e, final q q) {
        super(q.a, q.b);
        this.c = e.a;
        this.d = e.b;
        this.e = e;
    }
    
    public y(final double c, final double d, final double n, final double n2) {
        super(n, n2);
        this.c = c;
        this.d = d;
    }
    
    public double a(final y y) {
        final boolean d = t.d;
        double n = 0.0;
        final t t = new t(this.c(), this.d());
        final t t2 = new t(this.c() + this.a(), this.d() + this.b());
        final t t3 = new t(y.c(), y.d());
        final t t4 = new t(y.c() + y.a(), y.d() + y.b());
        Label_0162: {
            if (t2.a() < t3.a()) {
                n += Math.abs(t3.a() - t2.a());
                if (!d) {
                    break Label_0162;
                }
            }
            if (t.a() > t4.a()) {
                n += Math.abs(t4.a() - t.a());
            }
        }
        if (t2.b() < t3.b()) {
            n += Math.abs(t3.b() - t2.b());
            if (!d) {
                return n;
            }
        }
        if (t.b() > t4.b()) {
            n += Math.abs(t4.b() - t.b());
        }
        return n;
    }
    
    public final double c() {
        return this.c;
    }
    
    public final double d() {
        return this.d;
    }
    
    public final t e() {
        if (this.e == null) {
            this.e = new t(this.c, this.d);
        }
        return this.e;
    }
    
    public y h() {
        return this;
    }
    
    public boolean a(final double n, final double n2) {
        return a(this.c, this.d, this.a, this.b, n, n2, false);
    }
    
    public static boolean a(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        return a(n, n2, n3, n4, n5, n6, false);
    }
    
    public static boolean a(final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final boolean b) {
        if (b) {
            return n5 >= n && n5 - n <= n3 && n6 >= n2 && n6 - n2 <= n4;
        }
        return n5 >= n && n5 - n < n3 && n6 >= n2 && n6 - n2 < n4;
    }
    
    public boolean a(final t t) {
        return this.a(t.a, t.b);
    }
    
    public boolean b(final y y) {
        return this.a(y.c, y.d, y.a, y.b);
    }
    
    public boolean a(final double n, final double n2, final double n3, final double n4) {
        return this.a(n, n2) && this.a(n + n3, n2 + n4);
    }
    
    public static boolean a(final y y, final y y2) {
        return y.c + y.a > y2.c && y.d + y.b > y2.d && y.c < y2.c + y2.a && y.d < y2.d + y2.b;
    }
    
    public String toString() {
        return "[" + this.c + ',' + this.d + ',' + this.a + ',' + this.b + ']';
    }
    
    public int hashCode() {
        final long n = Double.doubleToLongBits(this.c) >> 1 ^ Double.doubleToLongBits(this.d);
        return super.hashCode() << 1 ^ (int)(n ^ n >> 32);
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof y)) {
            return false;
        }
        final y y = (y)o;
        return y.c == this.c && y.d == this.d && y.a == this.a && y.b == this.b;
    }
    
    public int compareTo(final Object o) {
        final y y = (y)o;
        if (this.c < y.c) {
            return -1;
        }
        if (this.c > y.c) {
            return 1;
        }
        if (this.d < y.d) {
            return -1;
        }
        if (this.d > y.d) {
            return 1;
        }
        return super.compareTo(o);
    }
}
