package y.f.i.a;

public final class L
{
    private final double a;
    private final double b;
    private final double c;
    
    public double a() {
        return this.a;
    }
    
    public double b() {
        return this.b;
    }
    
    public double c() {
        return this.c;
    }
    
    boolean a(final M m, final boolean b) {
        return m.a() == -1.7976931348623157E308 || m.b() == Double.MAX_VALUE || this.a(this.a(m.a(), b), b) + this.c <= m.b() + 1.0E-6;
    }
    
    int a(final M m, final boolean b, final int n) {
        final int a = ab.a;
        if (m.a() == -1.7976931348623157E308 || m.b() == Double.MAX_VALUE) {
            return 0;
        }
        double a2 = this.a(this.a(m.a(), b), b);
        double n2 = a2 + this.c;
        int i = 0;
        double n3 = 0.0;
        while (i <= n) {
            n3 = dcmpg(n2, m.b() + 1.0E-6);
            if (a != 0) {
                return (int)n3;
            }
            if (n3 <= 0) {
                return i;
            }
            final double n4 = (a2 + n2) / 2.0;
            Label_0127: {
                if (n4 < m.a() - 1.0E-6) {
                    a2 = n4;
                    if (a == 0) {
                        break Label_0127;
                    }
                }
                n2 = n4;
            }
            ++i;
            if (a != 0) {
                break;
            }
        }
        return (int)n3;
    }
    
    boolean a(final P p) {
        return this.a(p.e(), !p.a());
    }
    
    double a(final int n, final boolean b) {
        return n * this.c + (b ? this.a : this.b);
    }
    
    int a(final double n, final boolean b) {
        final double floor = Math.floor((n - (b ? this.a : this.b)) / this.c - 1.0E-6);
        if (this.a((int)floor, b) >= n) {
            return (int)(floor - 1.0);
        }
        return (int)floor;
    }
    
    int b(final double n, final boolean b) {
        final double ceil = Math.ceil((n - (b ? this.a : this.b)) / this.c + 1.0E-6);
        if (this.a((int)ceil, b) <= n) {
            return (int)(ceil + 1.0);
        }
        return (int)ceil;
    }
    
    M b(final M m, final boolean b) {
        final int n = this.a(m.a(), b) + 1;
        final int n2 = this.b(m.b(), b) - 1;
        if (n2 >= n) {
            return new M(this.a(n, b), this.a(n2, b));
        }
        return null;
    }
    
    double a(final double n, final M m, final boolean b) {
        return this.a(n, m, b, 0);
    }
    
    double a(final double n, final M m, final boolean b, final int n2) {
        final int a = ab.a;
        if (this.a(m, b, n2) >= 0) {
            final double c = m.c(n);
            double a2 = this.a(this.a(c, b), b);
            double n3 = a2 + this.c;
            int i = 0;
            while (true) {
                while (i < n2) {
                    final double n4 = (a2 + n3) / 2.0;
                    final double n5 = dcmpl(n4, c);
                    if (a == 0) {
                        Label_0100: {
                            if (n5 >= 0) {
                                n3 = n4;
                                if (a == 0) {
                                    break Label_0100;
                                }
                            }
                            a2 = n4;
                        }
                        ++i;
                        if (a != 0) {
                            break;
                        }
                        continue;
                    }
                    else {
                        if ((n5 <= 0 && m.b(a2) < 1.0E-6) || m.b(n3) > 1.0E-6) {
                            return a2;
                        }
                        return n3;
                    }
                }
                final double n6 = dcmpg(Math.abs(a2 - n), Math.abs(n3 - n));
                continue;
            }
        }
        return Double.POSITIVE_INFINITY;
    }
    
    double a(final double n, final P p2) {
        return this.a(n, p2.e(), !p2.a());
    }
    
    public String toString() {
        return "Grid[(" + this.a + ";" + this.b + "); " + this.c + "]";
    }
    
    double b(final double n, final P p2) {
        final double a = this.a(n, p2);
        return (a == Double.POSITIVE_INFINITY) ? Double.POSITIVE_INFINITY : Math.abs(n - a);
    }
}
