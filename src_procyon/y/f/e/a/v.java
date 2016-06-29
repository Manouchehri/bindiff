package y.f.e.a;

class v implements ax
{
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    
    public void a(final double d, final double e, final double b, final double c) {
        this.d = d;
        this.e = e;
        this.b = b;
        this.c = c;
        this.f = this.d + this.b / 2.0;
        this.g = this.e + this.c / 2.0;
    }
    
    public v() {
        this.a = 50.0;
        this.f = this.d + this.b / 2.0;
        this.g = this.e + this.c / 2.0;
    }
    
    public v(final double n, final double n2, final double n3, final double n4, final double a) {
        this.a = 50.0;
        this.f = this.d + this.b / 2.0;
        this.g = this.e + this.c / 2.0;
        this.a(n, n2, n3, n4);
        this.a = a;
    }
    
    public k a(final m m, final l l, final a a) {
        final k a2 = m.a();
        if (this.b <= 0.0 || this.c <= 0.0) {
            return a;
        }
        final double n = this.b - 2.0 * this.a;
        final double n2 = this.c - 2.0 * this.a;
        final double n3 = a2.d() - this.f - m.h();
        final double n4 = a2.e() - this.g - m.h();
        if (Math.abs(n3) > this.b / 2.0 || Math.abs(n4) > this.c / 2.0) {
            a.a();
            return a;
        }
        if (Math.abs(n3) <= n / 2.0 && Math.abs(n4) <= n2 / 2.0) {
            a.b(n3, n4, 0.0);
            a.b();
            return a;
        }
        double n5 = 0.0;
        double n6 = 0.0;
        if (n3 > n / 2.0) {
            n5 = this.b / 2.0 - n3;
            if (Math.abs(n4) <= n2 / 2.0) {
                a.b(n5 / this.a, 0.0, 0.0);
                return a;
            }
        }
        else if (n3 < -n / 2.0) {
            n5 = -this.b / 2.0 - n3;
            if (Math.abs(n4) <= n2 / 2.0) {
                a.b(n5 / this.a, 0.0, 0.0);
                return a;
            }
        }
        if (n4 > n2 / 2.0) {
            n6 = this.c / 2.0 - n4;
            if (Math.abs(n3) <= n / 2.0) {
                a.b(0.0, n6 / this.a, 0.0);
                return a;
            }
        }
        else if (n4 < -n2 / 2.0) {
            n6 = -this.c / 2.0 - n4;
            if (Math.abs(n3) <= n / 2.0) {
                a.b(0.0, n6 / this.a, 0.0);
                return a;
            }
        }
        final double n7 = this.a - Math.abs(n5);
        final double n8 = this.a - Math.abs(n6);
        final double sqrt = Math.sqrt(n7 * n7 + n8 * n8);
        if (sqrt > this.a) {
            a.a();
            return a;
        }
        final double n9 = 1.0 - sqrt / this.a;
        a.b(n5, n6, 0.0);
        a.b();
        a.d(n9);
        return a;
    }
}
