package y.d.b;

import java.math.*;
import y.g.*;

public class A implements z
{
    private static final BigInteger g;
    private static final BigInteger h;
    public static final A a;
    public static final A b;
    private static final BigInteger i;
    protected boolean c;
    protected long d;
    protected int e;
    protected BigInteger f;
    
    public A(final long d) {
        this.c = false;
        this.f = BigInteger.valueOf(d);
        this.c = true;
        this.d = d;
        this.e = 0;
        for (long abs = Math.abs(this.d); abs != 0L; abs >>= 1, ++this.e) {}
    }
    
    public A(final BigInteger f) {
        final int a = y.d.b.c.a;
        this.c = false;
        this.f = f;
        if (this.f.compareTo(A.g) < 0 && this.f.compareTo(A.h) > 0) {
            this.c = true;
            this.d = this.f.longValue();
            this.e = 0;
            long abs = Math.abs(this.d);
            while (abs != 0L) {
                abs >>= 1;
                ++this.e;
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    public z a() {
        return A.b;
    }
    
    public z b() {
        return A.a;
    }
    
    public z a(final z z) {
        final A a = (A)z;
        if (this.c && a.c && this.e + 1 < 62 && a.e + 1 < 62) {
            return new A(this.d + a.d);
        }
        return new A(this.f.add(a.f));
    }
    
    public z b(final z z) {
        final A a = (A)z;
        if (this.c && a.c && this.e + 1 < 62 && a.e + 1 < 62) {
            return new A(this.d - a.d);
        }
        return new A(this.f.subtract(a.f));
    }
    
    public z c(final z z) {
        final A a = (A)z;
        if (!this.c || !a.c || this.e + a.e >= 62) {
            return new A(this.f.multiply(a.f));
        }
        if (this.d == 1L) {
            return a;
        }
        if (a.d == 1L) {
            return this;
        }
        return new A(this.d * a.d);
    }
    
    public z d(final z z) {
        return new A(this.f.divide(((A)z).f));
    }
    
    public z e(final z z) {
        return new A(this.f.gcd(((A)z).f));
    }
    
    public int c() {
        return this.f.signum();
    }
    
    public z d() {
        return new A(this.f.negate());
    }
    
    public int f(final z z) {
        final A a = (A)z;
        if (this.c && a.c && this.e + 1 < 62 && a.e + 1 < 62) {
            return y.g.e.a(this.d, a.d);
        }
        return this.f.compareTo(a.f);
    }
    
    public double e() {
        if (this.c) {
            return this.d;
        }
        return this.f.doubleValue();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof A)) {
            return false;
        }
        final A a = (A)o;
        if (this.c && a.c) {
            return this.d == a.d;
        }
        return this.f.equals(a.f);
    }
    
    public String toString() {
        if (this.c) {
            return Long.toString(this.d);
        }
        return this.f.toString();
    }
    
    static {
        g = BigInteger.valueOf(Long.MAX_VALUE);
        h = BigInteger.valueOf(Long.MIN_VALUE);
        a = new A(1L);
        b = new A(0L);
        i = new BigInteger("-1");
    }
}
