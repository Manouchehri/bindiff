/*
 * Decompiled with CFR 0_115.
 */
package y.d.b;

import java.math.BigInteger;
import y.d.b.z;

public class v
implements z {
    public static final v a = new v(1);
    public static final v b = new v(0);
    protected BigInteger c;
    private static final BigInteger d = new BigInteger("-1");

    public v(long l2) {
        this.c = BigInteger.valueOf(l2);
    }

    public v(BigInteger bigInteger) {
        this.c = bigInteger;
    }

    @Override
    public z a() {
        return b;
    }

    @Override
    public z b() {
        return a;
    }

    @Override
    public z a(z z2) {
        v v2 = (v)z2;
        return new v(this.c.add(v2.c));
    }

    @Override
    public z b(z z2) {
        v v2 = (v)z2;
        return new v(this.c.subtract(v2.c));
    }

    @Override
    public z c(z z2) {
        v v2 = (v)z2;
        return new v(this.c.multiply(v2.c));
    }

    @Override
    public z d(z z2) {
        v v2 = (v)z2;
        return new v(this.c.divide(v2.c));
    }

    @Override
    public z e(z z2) {
        v v2 = (v)z2;
        return new v(this.c.gcd(v2.c));
    }

    @Override
    public int c() {
        return this.c.signum();
    }

    @Override
    public z d() {
        return new v(this.c.negate());
    }

    @Override
    public int f(z z2) {
        v v2 = (v)z2;
        return this.c.compareTo(v2.c);
    }

    @Override
    public double e() {
        return this.c.doubleValue();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof v)) {
            return false;
        }
        v v2 = (v)object;
        return this.c.equals(v2.c);
    }

    public String toString() {
        return this.c.toString();
    }
}

