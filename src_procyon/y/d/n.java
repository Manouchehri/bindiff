package y.d;

import y.c.*;

public class n implements o
{
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    
    public n(final y y) {
        this(y.c, y.d + y.b, y.a, y.b);
    }
    
    public n(final n n) {
        this(n.b(), n.c(), n.e(), n.f());
        this.e = n.g();
        this.f = n.i();
    }
    
    public n(final t t, final q q) {
        this(t.a, t.b, q.a, q.b);
    }
    
    public n(final t t, final q q, final z z) {
        this(t.a, t.b, q.a, q.b, z.a(), z.b());
    }
    
    public n(final double a, final double b, final double c, final double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = 0.0;
        this.f = -1.0;
    }
    
    public n(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        this(n, n2, n3, n4);
        this.h(n5, n6);
    }
    
    public t a() {
        return new t(this.a, this.b);
    }
    
    public void a(final t t) {
        this.a(t.a(), t.b());
    }
    
    public void a(final double a, final double b) {
        this.a = a;
        this.b = b;
    }
    
    public double b() {
        return this.a;
    }
    
    public double c() {
        return this.b;
    }
    
    public q d() {
        return new q(this.c, this.d);
    }
    
    public void a(final q q) {
        this.b(q.a, q.b);
    }
    
    public void b(final double c, final double d) {
        this.c = c;
        this.d = d;
    }
    
    public double e() {
        return this.c;
    }
    
    public double f() {
        return this.d;
    }
    
    public void c(final double n, final double n2) {
        this.h(n, n2);
    }
    
    private void h(final double n, final double n2) {
        if (n == 0.0) {
            if (n2 == 0.0) {
                throw new IllegalArgumentException("Invalid up vector: (0,0).");
            }
            this.e = 0.0;
            this.f = ((n2 > 0.0) ? 1.0 : -1.0);
        }
        else if (n2 == 0.0) {
            this.e = ((n > 0.0) ? 1.0 : -1.0);
            this.f = 0.0;
        }
        else {
            final double sqrt = Math.sqrt(n * n + n2 * n2);
            this.e = n / sqrt;
            this.f = n2 / sqrt;
        }
    }
    
    public double g() {
        return this.e;
    }
    
    public double i() {
        return this.f;
    }
    
    public double j() {
        return Math.atan2(-this.e, -this.f);
    }
    
    public void a(final double n) {
        this.e = -Math.sin(n);
        this.f = -Math.cos(n);
    }
    
    public void d(final double n, final double n2) {
        this.a += n;
        this.b += n2;
    }
    
    public t k() {
        final double n = this.d * 0.5;
        final double n2 = this.c * 0.5;
        return new t(this.a + this.e * n - this.f * n2, this.b + this.f * n + this.e * n2);
    }
    
    public void b(final t t) {
        this.e(t.a(), t.b());
    }
    
    public void e(final double n, final double n2) {
        final double n3 = this.d * 0.5;
        final double n4 = this.c * 0.5;
        this.a = n - this.e * n3 + this.f * n4;
        this.b = n2 - this.f * n3 - this.e * n4;
    }
    
    public y h() {
        final t[] a = a(this);
        final double min = Math.min(Math.min(a[0].a, a[1].a), Math.min(a[2].a, a[3].a));
        final double max = Math.max(Math.max(a[0].a, a[1].a), Math.max(a[2].a, a[3].a));
        final double min2 = Math.min(Math.min(a[0].b, a[1].b), Math.min(a[2].b, a[3].b));
        return new y(min, min2, max - min, Math.max(Math.max(a[0].b, a[1].b), Math.max(a[2].b, a[3].b)) - min2);
    }
    
    public boolean a(final double n, final double n2, final boolean b) {
        return a(this, n, n2, 0.0, b);
    }
    
    public static t[] a(final n n) {
        final double c = n.c;
        final double d = n.d;
        final double a = n.a;
        final double b = n.b;
        final double e = n.e;
        final double f = n.f;
        return new t[] { new t(a, b), new t(a + e * d, b + f * d), new t(a + e * d - f * c, b + f * d + e * c), new t(a - f * c, b + e * c) };
    }
    
    private static y a(final y y, final double n) {
        return new y(y.c - n, y.d - n, y.a + 2.0 * n, y.b + 2.0 * n);
    }
    
    private static boolean a(final y y, final double n, final double n2, final double n3) {
        y a = y;
        if (n3 > 0.0) {
            a = a(y, n3);
        }
        return a.a(n, n2);
    }
    
    private static boolean a(final double n, final double n2, final double n3, final double n4, final y y, final double n5) {
        y a = y;
        if (n5 > 0.0) {
            a = a(y, n5);
        }
        return new m(new t(n, n2), new t(n3, n4)).a(a);
    }
    
    public static boolean a(final n n, final y y, final double n2) {
        if (y.a < 0.0 || y.b < 0.0) {
            return false;
        }
        final double a = n.a;
        final double b = n.b;
        final double c = n.c;
        final double d = n.d;
        if (c < 0.0 || d < 0.0) {
            return false;
        }
        if (a(y, a, b, n2)) {
            return true;
        }
        if (n.l()) {
            return y.a(y, new y(a - n2, b - d - n2, c + 2.0 * n2, d + 2.0 * n2));
        }
        final t[] a2 = a(n);
        return a(a2[0].a, a2[0].b, a2[1].a, a2[1].b, y, n2) || a(a2[1].a, a2[1].b, a2[2].a, a2[2].b, y, n2) || a(a2[2].a, a2[2].b, a2[3].a, a2[3].b, y, n2) || a(a2[3].a, a2[3].b, a2[0].a, a2[0].b, y, n2);
    }
    
    private boolean l() {
        return this.e == 0.0 && this.f == -1.0;
    }
    
    public static boolean a(final n n, final t t, final double n2) {
        return a(n, t.a, t.b, n2);
    }
    
    public static boolean a(final n n, final double n2, final double n3, final double n4) {
        return a(n, n2, n3, n4, false);
    }
    
    private static boolean a(final n n, final double n2, final double n3, final double n4, final boolean b) {
        final double e = n.e;
        final double f = n.f;
        if (n.l()) {
            return y.a(n.a - n4, n.b - n.d - n4, n.c + 2.0 * n4, n.d + 2.0 * n4, n2, n3, b);
        }
        final double a = n.a;
        final double b2 = n.b;
        final double c = n.c;
        final double d = n.d;
        if (c < 0.0 || d < 0.0) {
            return false;
        }
        final double n5 = n2 - a;
        final double n6 = n3 - b2;
        final double n7 = c + d + n4;
        return n5 >= -n7 && n5 <= n7 && n6 >= -n7 && n6 <= n7 && y.a(0.0 - n4, 0.0 - n4, c + 2.0 * n4, d + 2.0 * n4, n5 * -f + n6 * e, n5 * e + n6 * f, b);
    }
    
    public static boolean a(final n n, final n n2, final double n3) {
        final t[] a = a(n2);
        return a(n, a[0], n3) && a(n, a[1], n3) && a(n, a[2], n3) && a(n, a[3], n3);
    }
    
    public static boolean a(final n n, final m m, final double n2) {
        final double e = n.e;
        final double f = n.f;
        if (n.l()) {
            return m.a(new y(n.a - n2, n.b - n.d - n2, n.c + 2.0 * n2, n.d + 2.0 * n2));
        }
        final double a = n.a;
        final double b = n.b;
        final double c = n.c;
        final double d = n.d;
        if (c < 0.0 || d < 0.0) {
            return false;
        }
        final double a2 = m.c().a;
        final double b2 = m.c().b;
        final double a3 = m.d().a;
        final double b3 = m.d().b;
        final double n3 = a2 - a;
        final double n4 = b2 - b;
        final double n5 = a3 - a;
        final double n6 = b3 - b;
        return new m(new t(n3 * -f + n4 * e, n3 * e + n4 * f), new t(n5 * -f + n6 * e, n5 * e + n6 * f)).a(new y(0.0 - n2, 0.0 - n2, c + 2.0 * n2, d + 2.0 * n2));
    }
    
    public static t b(final n n, final m m, final double n2) {
        final double e = n.e;
        final double f = n.f;
        final double a = m.c().a;
        final double b = m.c().b;
        final double a2 = m.d().a;
        final double b2 = m.d().b;
        if (n.l()) {
            return a(new y(n.a - n2, n.b - n.d - n2, n.c + 2.0 * n2, n.d + 2.0 * n2), a, b, a2, b2);
        }
        final double a3 = n.a;
        final double b3 = n.b;
        final double c = n.c;
        final double d = n.d;
        if (c < 0.0 || d < 0.0) {
            return null;
        }
        final double n3 = a - a3;
        final double n4 = b - b3;
        final double n5 = a2 - a3;
        final double n6 = b2 - b3;
        final t a4 = a(new y(0.0 - n2, 0.0 - n2, c + 2.0 * n2, d + 2.0 * n2), n3 * -f + n4 * e, n3 * e + n4 * f, n5 * -f + n6 * e, n5 * e + n6 * f);
        if (a4 != null) {
            return new t(a3 + a4.a * -f + a4.b * e, b3 + a4.a * e + a4.b * f);
        }
        return null;
    }
    
    private static boolean a(final int n, final int n2) {
        return (n & n2) != 0x0;
    }
    
    private static boolean b(final int n, final int n2) {
        return (n | n2) == 0x0;
    }
    
    private static boolean c(final int n, final int n2) {
        return a(n, n2) || b(n, n2);
    }
    
    private static final t a(final y y, double n, double n2, double n3, double n4) {
        final boolean d = t.d;
        final double c = y.c();
        final double d2 = y.d();
        final double n5 = c + y.a();
        final double n6 = d2 + y.b();
        byte b = a(c, d2, n5, n6, n, n2);
        byte b2 = a(c, d2, n5, n6, n3, n4);
        boolean b3 = false;
        boolean b4 = false;
        int n7 = 10;
        int n8 = 0;
        Label_0333: {
            while (!c(b, b2)) {
                n8 = n7;
                if (d || n8 <= 0) {
                    break Label_0333;
                }
                --n7;
                if (b != 0) {
                    Label_0190: {
                        if ((b & 0x3) != 0x0) {
                            final double n9 = ((b & 0x2) != 0x0) ? n5 : c;
                            n2 += (n9 - n) * (n4 - n2) / (n3 - n);
                            n = n9;
                            if (!d) {
                                break Label_0190;
                            }
                        }
                        final double n10 = ((b & 0x8) != 0x0) ? n6 : d2;
                        n += (n10 - n2) * (n3 - n) / (n4 - n2);
                        n2 = n10;
                    }
                    b3 = true;
                    b = a(c, d2, n5, n6, n, n2);
                    if (!d) {
                        continue;
                    }
                }
                Label_0306: {
                    if ((b2 & 0x3) != 0x0) {
                        final double n11 = ((b2 & 0x2) != 0x0) ? n5 : c;
                        n4 += (n11 - n3) * (n4 - n2) / (n3 - n);
                        n3 = n11;
                        if (!d) {
                            break Label_0306;
                        }
                    }
                    final double n12 = ((b2 & 0x8) != 0x0) ? n6 : d2;
                    n3 += (n12 - n4) * (n3 - n) / (n4 - n2);
                    n4 = n12;
                }
                b4 = true;
                b2 = a(c, d2, n5, n6, n3, n4);
                if (d) {
                    goto Label_0331;
                }
            }
            goto Label_0331;
        }
        if (n8 == 0) {
            return null;
        }
        if (a(b, b2)) {
            return null;
        }
        if (!b3 && !b4) {
            return null;
        }
        if (b3) {
            return new t(n, n2);
        }
        return new t(n3, n4);
    }
    
    private static byte a(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        final boolean d = t.d;
        byte b = 0;
        Label_0034: {
            if (n5 < n) {
                b = 1;
                if (!d) {
                    break Label_0034;
                }
            }
            if (n5 > n3) {
                b = 2;
            }
        }
        if (n6 < n2) {
            b |= 0x4;
            if (!d) {
                return b;
            }
        }
        if (n6 > n4) {
            b |= 0x8;
        }
        return b;
    }
    
    public String toString() {
        return this.getClass().getName() + "[anchorX=" + this.a + ";anchorY=" + this.b + ";width=" + this.c + ";height=" + this.d + ";upX=" + this.e + ";upY=" + this.f + "]";
    }
    
    private static int i(final double n, final double n2) {
        return r.a(n, n2);
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final n n = (n)o;
        return i(n.a, this.a) == 0 && i(n.b, this.b) == 0 && i(n.d, this.d) == 0 && i(n.c, this.c) == 0 && i(n.e, this.e) == 0 && i(n.f, this.f) == 0;
    }
    
    public int hashCode() {
        final boolean d = t.d;
        final int hashCode = super.hashCode();
        final long n = (this.a != 0.0) ? Double.doubleToLongBits(this.a) : 0L;
        final int n2 = 31 * hashCode + (int)(n ^ n >>> 32);
        final long n3 = (this.b != 0.0) ? Double.doubleToLongBits(this.b) : 0L;
        final int n4 = 31 * n2 + (int)(n3 ^ n3 >>> 32);
        final long n5 = (this.e != 0.0) ? Double.doubleToLongBits(this.e) : 0L;
        final int n6 = 31 * n4 + (int)(n5 ^ n5 >>> 32);
        final long n7 = (this.f != 0.0) ? Double.doubleToLongBits(this.f) : 0L;
        final int n8 = 31 * n6 + (int)(n7 ^ n7 >>> 32);
        final long n9 = (this.c != 0.0) ? Double.doubleToLongBits(this.c) : 0L;
        final int n10 = 31 * n8 + (int)(n9 ^ n9 >>> 32);
        final long n11 = (this.d != 0.0) ? Double.doubleToLongBits(this.d) : 0L;
        final int n12 = 31 * n10 + (int)(n11 ^ n11 >>> 32);
        if (i.g) {
            t.d = !d;
        }
        return n12;
    }
    
    public n f(final double n, final double n2) {
        return new n(this.a + n, this.b + n2, this.c, this.d, this.e, this.f);
    }
    
    public n g(final double n, final double n2) {
        return new n(this.a, this.b, n, n2, this.e, this.f);
    }
}
