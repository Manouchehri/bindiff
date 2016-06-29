package y.d;

public class m implements o
{
    private t a;
    private t b;
    private double c;
    private double d;
    private static double e;
    
    public m(final t a, final t b) {
        final boolean d = t.d;
        this.a = a;
        this.b = b;
        if (b.a == a.a) {
            if (a.b < b.b) {
                this.c = Double.MAX_VALUE;
                this.d = Double.NaN;
                if (!d) {
                    return;
                }
            }
            this.c = -1.7976931348623157E308;
            this.d = Double.NaN;
            if (!d) {
                return;
            }
        }
        this.c = (b.b - a.b) / (b.a - a.a);
        this.d = a.b - a.a * this.c;
    }
    
    public boolean a() {
        return Math.abs(this.c().a - this.d().a) < m.e;
    }
    
    public boolean b() {
        return Math.abs(this.c().b - this.d().b) < m.e;
    }
    
    public t c() {
        return this.a;
    }
    
    public t d() {
        return this.b;
    }
    
    public boolean a(final double n) {
        if (this.a.b < this.b.b) {
            return n > this.a.b + m.e && n < this.b.b - m.e;
        }
        return n > this.b.b + m.e && n < this.a.b - m.e;
    }
    
    public boolean b(final double n) {
        if (this.a.a < this.b.a) {
            return n > this.a.a + m.e && n < this.b.a - m.e;
        }
        return n > this.b.a + m.e && n < this.a.a - m.e;
    }
    
    public double e() {
        return this.d;
    }
    
    public double f() {
        return this.c;
    }
    
    public double g() {
        return this.i().d();
    }
    
    public y h() {
        final double n = (this.a.a < this.b.a) ? this.a.a : this.b.a;
        final double n2 = (this.a.a > this.b.a) ? this.a.a : this.b.a;
        final double n3 = (this.a.b < this.b.b) ? this.a.b : this.b.b;
        return new y(n, n3, n2 - n, ((this.a.b > this.b.b) ? this.a.b : this.b.b) - n3);
    }
    
    public boolean a(final y y) {
        return a(y, this.a.a, this.a.b, this.b.a, this.b.b);
    }
    
    public boolean a(final t t) {
        return a(new y(t.a - m.e, t.b - m.e, 2.0 * m.e, 2.0 * m.e), this.a.a, this.a.b, this.b.a, this.b.b);
    }
    
    public boolean b(final t t) {
        return a(new y(t.a - 0.01, t.b - 0.01, 0.02, 0.02), this.a.a, this.a.b, this.b.a, this.b.b);
    }
    
    public static final boolean a(final y y, double n, double n2, final double n3, final double n4) {
        final boolean d = t.d;
        final double c = y.c();
        final double d2 = y.d();
        final double n5 = c + y.a();
        final double n6 = d2 + y.b();
        byte b = a(c, d2, n5, n6, n, n2);
        if (b == 0) {
            return true;
        }
        final byte a = a(c, d2, n5, n6, n3, n4);
        if (a == 0) {
            return true;
        }
        while (b != 0) {
            final byte b3;
            final byte b2 = b3 = (byte)(b & a);
            if (d) {
                return b3 != 0;
            }
            if (b2 != 0) {
                return false;
            }
            Label_0184: {
                if ((b & 0x3) != 0x0) {
                    double n7 = c;
                    if ((b & 0x2) != 0x0) {
                        n7 = n5;
                    }
                    n2 += (n7 - n) * (n4 - n2) / (n3 - n);
                    n = n7;
                    if (!d) {
                        break Label_0184;
                    }
                }
                double n8 = d2;
                if ((b & 0x8) != 0x0) {
                    n8 = n6;
                }
                n += (n8 - n2) * (n3 - n) / (n4 - n2);
                n2 = n8;
            }
            b = a(c, d2, n5, n6, n, n2);
            if (d) {
                break;
            }
        }
        byte b3 = (byte)(true ? 1 : 0);
        return b3 != 0;
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
    
    public static t a(m m, m i) {
        if (i.a()) {
            final m j = m;
            m = i;
            i = j;
        }
        if (m.a()) {
            if (!i.b(m.c().a)) {
                return null;
            }
            final double f = i.f();
            if (Double.isInfinite(f) || Double.isNaN(f)) {
                return null;
            }
            final double e = i.e();
            if (Double.isInfinite(e) || Double.isNaN(e)) {
                return null;
            }
            final double n = i.e() + i.f() * m.c().a;
            if (!m.a(n)) {
                return null;
            }
            return new t(m.c().a, n);
        }
        else {
            final double f2 = m.f();
            final double f3 = i.f();
            if (f2 == f3) {
                return null;
            }
            final double n2 = (i.e() - m.e()) / (f2 - f3);
            if (m.b(n2) && i.b(n2)) {
                return new t(n2, n2 * f2 + m.e());
            }
            return null;
        }
    }
    
    public z i() {
        return new z(this.b, this.a);
    }
    
    public double j() {
        return this.b.a - this.a.a;
    }
    
    public double k() {
        return this.b.b - this.a.b;
    }
    
    public String toString() {
        return "SP: " + this.a.toString() + " TP: " + this.b.toString();
    }
    
    static {
        m.e = 1.0E-8;
    }
}
