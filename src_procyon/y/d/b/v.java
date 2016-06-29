package y.d.b;

import java.math.*;

public class v implements z
{
    public static final v a;
    public static final v b;
    protected BigInteger c;
    private static final BigInteger d;
    
    public v(final long n) {
        this.c = BigInteger.valueOf(n);
    }
    
    public v(final BigInteger c) {
        this.c = c;
    }
    
    public z a() {
        return v.b;
    }
    
    public z b() {
        return v.a;
    }
    
    public z a(final z z) {
        return new v(this.c.add(((v)z).c));
    }
    
    public z b(final z z) {
        return new v(this.c.subtract(((v)z).c));
    }
    
    public z c(final z z) {
        return new v(this.c.multiply(((v)z).c));
    }
    
    public z d(final z z) {
        return new v(this.c.divide(((v)z).c));
    }
    
    public z e(final z z) {
        return new v(this.c.gcd(((v)z).c));
    }
    
    public int c() {
        return this.c.signum();
    }
    
    public z d() {
        return new v(this.c.negate());
    }
    
    public int f(final z z) {
        return this.c.compareTo(((v)z).c);
    }
    
    public double e() {
        return this.c.doubleValue();
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof v && this.c.equals(((v)o).c));
    }
    
    public String toString() {
        return this.c.toString();
    }
    
    static {
        a = new v(1L);
        b = new v(0L);
        d = new BigInteger("-1");
    }
}
