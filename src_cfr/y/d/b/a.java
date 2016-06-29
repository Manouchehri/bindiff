/*
 * Decompiled with CFR 0_115.
 */
package y.d.b;

import java.math.BigInteger;
import y.d.b.c;
import y.d.b.z;
import y.g.e;

public class A
implements z {
    private static final BigInteger g = BigInteger.valueOf(Long.MAX_VALUE);
    private static final BigInteger h = BigInteger.valueOf(Long.MIN_VALUE);
    public static final A a = new A(1);
    public static final A b = new A(0);
    private static final BigInteger i = new BigInteger("-1");
    protected boolean c;
    protected long d;
    protected int e;
    protected BigInteger f;

    public A(long l2) {
        this.c = false;
        this.f = BigInteger.valueOf(l2);
        this.c = true;
        this.d = l2;
        this.e = 0;
        long l3 = Math.abs(this.d);
        while (l3 != 0) {
            l3 >>= 1;
            ++this.e;
        }
    }

    public A(BigInteger bigInteger) {
        int n2 = c.a;
        this.c = false;
        this.f = bigInteger;
        if (this.f.compareTo(g) >= 0) return;
        if (this.f.compareTo(h) <= 0) return;
        this.c = true;
        this.d = this.f.longValue();
        this.e = 0;
        long l2 = Math.abs(this.d);
        do {
            if (l2 == 0) return;
            l2 >>= 1;
            ++this.e;
        } while (n2 == 0);
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
        A a2 = (A)z2;
        if (!this.c) return new A(this.f.add(a2.f));
        if (!a2.c) return new A(this.f.add(a2.f));
        if (this.e + 1 >= 62) return new A(this.f.add(a2.f));
        if (a2.e + 1 >= 62) return new A(this.f.add(a2.f));
        return new A(this.d + a2.d);
    }

    @Override
    public z b(z z2) {
        A a2 = (A)z2;
        if (!this.c) return new A(this.f.subtract(a2.f));
        if (!a2.c) return new A(this.f.subtract(a2.f));
        if (this.e + 1 >= 62) return new A(this.f.subtract(a2.f));
        if (a2.e + 1 >= 62) return new A(this.f.subtract(a2.f));
        return new A(this.d - a2.d);
    }

    @Override
    public z c(z z2) {
        A a2 = (A)z2;
        if (!this.c) return new A(this.f.multiply(a2.f));
        if (!a2.c) return new A(this.f.multiply(a2.f));
        if (this.e + a2.e >= 62) return new A(this.f.multiply(a2.f));
        if (this.d == 1) {
            return a2;
        }
        if (a2.d != 1) return new A(this.d * a2.d);
        return this;
    }

    @Override
    public z d(z z2) {
        A a2 = (A)z2;
        return new A(this.f.divide(a2.f));
    }

    @Override
    public z e(z z2) {
        A a2 = (A)z2;
        return new A(this.f.gcd(a2.f));
    }

    @Override
    public int c() {
        return this.f.signum();
    }

    @Override
    public z d() {
        return new A(this.f.negate());
    }

    @Override
    public int f(z z2) {
        A a2 = (A)z2;
        if (!this.c) return this.f.compareTo(a2.f);
        if (!a2.c) return this.f.compareTo(a2.f);
        if (this.e + 1 >= 62) return this.f.compareTo(a2.f);
        if (a2.e + 1 >= 62) return this.f.compareTo(a2.f);
        return e.a(this.d, a2.d);
    }

    @Override
    public double e() {
        if (!this.c) return this.f.doubleValue();
        return this.d;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof A)) {
            return false;
        }
        A a2 = (A)object;
        if (!this.c) return this.f.equals(a2.f);
        if (!a2.c) return this.f.equals(a2.f);
        if (this.d != a2.d) return false;
        return true;
    }

    public String toString() {
        if (!this.c) return this.f.toString();
        return Long.toString(this.d);
    }
}

